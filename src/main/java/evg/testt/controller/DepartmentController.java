package evg.testt.controller;

import evg.testt.model.Department;
import evg.testt.model.Employee;
import evg.testt.service.DepartmentService;
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
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/dep", method = RequestMethod.GET)
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

    @RequestMapping(value = "/depAdd", method = RequestMethod.GET)
    public ModelAndView showAdd() {
        return new ModelAndView(JspPath.DEPARTMENT_ADD);
    }

    @RequestMapping(value = "/depSave", method = RequestMethod.POST)
    public String addNewOne(@RequestParam(required = true) String name) throws SQLException {
        Department addedDepartment = new Department();
        addedDepartment.setName(name);
        addedDepartment.setEmployees(new ArrayList<Employee>());
        departmentService.insert(addedDepartment);
        return "redirect:/dep";
    }

    @RequestMapping(value = "/depDelete", method = RequestMethod.POST)
    public String deleteOne(@RequestParam(required = true) Integer id) throws SQLException {
        Department departmentForDelete = new Department();
        departmentForDelete.setId(id);
        departmentService.delete(departmentForDelete);
        return "redirect:/dep";
    }

    @RequestMapping(value = "/depUpdate", method = RequestMethod.POST)
    public ModelAndView updeteOne(@RequestParam(required = true) Integer id) throws SQLException {
        Department departmentForUpdate = departmentService.getById(id);
        return new ModelAndView(JspPath.DEPARTMENT_UPDATE,"departmentForUpdate", departmentForUpdate);
    }

    @RequestMapping(value = "/depSaveUpdated", method = RequestMethod.POST)
    public String updateOne(@RequestParam(required = true) Integer id, @RequestParam(required = true) String name) throws SQLException {
        Department departmentUpdated = new Department();
        departmentUpdated.setId(id);
        departmentUpdated.setName(name);
        departmentService.update(departmentUpdated);
        return "redirect:/dep";
    }



}
