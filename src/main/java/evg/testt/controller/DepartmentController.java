package evg.testt.controller;

import evg.testt.model.Department;
import evg.testt.service.DepartmentService;
import evg.testt.service.EmployeeService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

import java.sql.SQLException;

@Controller
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/dep", method = RequestMethod.GET)
    public ModelAndView showAll() {
        List<Department> departments;
        try {
            departments = departmentService.getAll();
        } catch (SQLException e) {
            departments = Collections.emptyList();
            e.printStackTrace();
        }
        return new ModelAndView(JspPath.DEPARTMENT_ALL, "departments", departments);
    }

    @RequestMapping(value = "/depAdd", method = RequestMethod.GET)
    public ModelAndView showAdd() {
        return new ModelAndView(JspPath.DEPARTMENT_ADD);
    }

    @RequestMapping(value = "/depSave", method = RequestMethod.POST)
    public String addNewOne(@RequestParam(required = true) String name) {
        Department addedDepartment = new Department();
        addedDepartment.setName(name);
        try {
            departmentService.insert(addedDepartment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/dep";
    }

    @RequestMapping(value = "/depDel", method = RequestMethod.GET)
    public String delete(@RequestParam("id") int departmentId) {
        //System.err.println("xdcfvbhnj");
        try {
            //CAP
            Department deletedDepartment = new Department();
            deletedDepartment.setId(departmentId);
            departmentService.delete(deletedDepartment);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/dep";
    }

    @RequestMapping(value = "/depEdit", method = RequestMethod.GET)
    public ModelAndView showEdit(@RequestParam("id") int departmentId,
                                 @RequestParam("name") String departmentName) {
        Department department = new Department();
        department.setId(departmentId);
        department.setName(departmentName);
        return new ModelAndView(JspPath.DEPARTMENT_EDIT, "department", department);
    }

    @RequestMapping(value = "/depSaveEdited", method = RequestMethod.POST)
    public String update(/*@ModelAttribute("contact") Department department,*/
                         @RequestParam(value="id") int id,
                         @RequestParam(value="name") String name) {
        try {
            Department department = new Department();
            department.setId(id);
            department.setName(name);
            departmentService.update(department);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/dep";
    }


}
