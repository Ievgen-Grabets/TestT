package evg.testt.controller;

import evg.testt.model.Department;
import evg.testt.service.DepartmentService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

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
        ModelAndView modelAndView = makeModelAndViewForEdit(new Department());
        modelAndView.addObject("title","Add a new department");
        return modelAndView;
    }

    private ModelAndView makeModelAndViewForEdit(Department department) {
        ModelAndView modelAndView = new ModelAndView(JspPath.DEPARTMENT_UPDATE);
        modelAndView.addObject("department",department);
        return modelAndView;
    }

    @RequestMapping(value = "/depEdit", method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam(required = true) Integer id) {
        try {
            ModelAndView modelAndView = makeModelAndViewForEdit(departmentService.getById(id));
            modelAndView.addObject("title","Edit a department");
            return modelAndView;
        } catch (SQLException e) {
            e.printStackTrace();
            return showAll();
        }
    }

    @RequestMapping(value = "/depUpdate", method = RequestMethod.POST)
    public String updateOne(@ModelAttribute Department department) {
        try {
            departmentService.update(department);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/dep";
    }

    @RequestMapping(value = "/showDepEmployees", method = RequestMethod.GET)
    public ModelAndView showDepEmployees(@RequestParam(required = true) Integer id) {
        Department department;
        try {
            department = departmentService.getById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            department = new Department();
        }

        ModelAndView modelAndView = new ModelAndView(JspPath.DEPARTMENT_ALL_EMPLOYEES, "department", department);
        modelAndView.addObject("employeesCount",department.getEmployees().size());

        return modelAndView;
    }


    @RequestMapping(value = "/depDelete", method = RequestMethod.GET)
    public String deleteDep(@RequestParam(required = true) Integer id) {
        try {
            Department department = new Department();
            department.setId(id);
            departmentService.delete(department);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/dep";
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


}
