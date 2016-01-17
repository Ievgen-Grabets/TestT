package evg.testt.controller;

import evg.testt.model.Department;
import evg.testt.service.DepartmentService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value = "/depDelete", method = RequestMethod.POST)
    public String deleteOne(@RequestParam(required = true) Integer id) {
        Department departmentForDelete = new Department();
        departmentForDelete.setId(id);
        try {
            departmentService.delete(departmentForDelete);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/dep";
    }

    @RequestMapping(value = "/depUpdate", method = RequestMethod.POST)
    public ModelAndView updeteOne(@RequestParam(required = true) Integer id) {
        Department departmentForUpdate = new Department();
        try {
            departmentForUpdate = departmentService.getById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ModelAndView(JspPath.DEPARTMENT_UPDATE,"departmentForUpdate", departmentForUpdate);
    }

    @RequestMapping(value = "/depSaveUpdated", method = RequestMethod.POST)
    public String updateOne(@RequestParam(required = true) Integer id, @RequestParam(required = true) String name){
        Department departmentUpdated = new Department();
        departmentUpdated.setId(id);
        departmentUpdated.setName(name);
        try {
            departmentService.update(departmentUpdated);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/dep";
    }


   // @RequestMapping(value = "/depUpdate", )



}
