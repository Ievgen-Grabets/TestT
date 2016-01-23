package evg.testt.controller;

import evg.testt.model.Department;
import evg.testt.model.Employee;
import evg.testt.service.DepartmentService;
import evg.testt.service.EmployeeService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.sql.SQLException;

@Controller
@RequestMapping(value = "/dep")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView showAll() {
        List<Department> departments = null;
        try {
            departments = departmentService.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
            departments = Collections.emptyList();
        }
        return new ModelAndView(JspPath.DEPARTMENT_ALL, "departments", departments);
    }

    @RequestMapping(value = "/Add", method = RequestMethod.GET)
    public ModelAndView showAdd() {
        return new ModelAndView(JspPath.DEPARTMENT_ADD);
    }

    @RequestMapping(value = "/Save", method = RequestMethod.POST)
    public String addNewOne(@RequestParam(required = true) String name) throws SQLException {
        Department addedDepartment = new Department();
        addedDepartment.setName(name);
        departmentService.insert(addedDepartment);
        return "redirect:/dep";
    }

    @RequestMapping(value = "/Delete", method = RequestMethod.POST)
    public String deleteOne(@RequestParam(required = true) Integer id) throws SQLException {
        Department departmentForDelete = departmentService.getById(id);
        if (departmentForDelete.getEmployees() != null) {
            for(int i = 0; i < departmentForDelete.getEmployees().size(); i++) {
                employeeService.delete(departmentForDelete.getEmployees().get(i));
            }
        }
        departmentService.delete(departmentService.getById(id));
        return "redirect:/dep";
    }

    @RequestMapping(value = "/Update", method = RequestMethod.POST)
    public ModelAndView updeteOne(@RequestParam(required = true) Integer id) throws SQLException {
        Department departmentForUpdate = departmentService.getById(id);
        return new ModelAndView(JspPath.DEPARTMENT_UPDATE,"departmentForUpdate", departmentForUpdate);
    }

    @RequestMapping(value = "/SaveUpdated", method = RequestMethod.POST)
    public String updateOne(@RequestParam(required = true) Integer id, @RequestParam(required = true) String name) throws SQLException {
        Department departmentUpdated = new Department();
        departmentUpdated.setId(id);
        departmentUpdated.setName(name);
        departmentService.update(departmentUpdated);
        return "redirect:/dep";
    }


}
