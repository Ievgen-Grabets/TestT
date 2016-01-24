package evg.testt.controller;

import evg.testt.model.Department;
import evg.testt.model.Employee;
import evg.testt.service.DepartmentService;
import evg.testt.service.EmployeesService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

import java.sql.SQLException;
import java.util.Set;

@Controller
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;
    @Autowired
    EmployeesService employeesService;

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

    @RequestMapping(value = "/depEdit", method = RequestMethod.POST)
    public ModelAndView showEdit(@RequestParam(required = true) int depId) {
        Department department = null;
        try {
            department = departmentService.getById(depId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ModelAndView(JspPath.DEPARTMENT_EDIT, "department", department);
    }

    @RequestMapping(value = "/depEditSave", method = RequestMethod.POST)
    public String Edit(@RequestParam(required = true) int depId, String name) {
        Department editedDepartment = new Department();
        editedDepartment.setName(name);
        editedDepartment.setId(depId);
        try {
            departmentService.update(editedDepartment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/dep";


    }

    @RequestMapping(value = "/depDel", method = RequestMethod.POST)
    public String delete(@RequestParam(required = true) int depId) {
        Department delDepartment = null;
        try{
            delDepartment = departmentService.getById(depId);
        }catch(SQLException e) {
            e.printStackTrace();
        }
        Set<Employee> delEmployees = delDepartment.getEmployees();
      //Set<Employee> clonedDelEmployees = delEmployees.
        for (Employee delEmployee:delEmployees){
            try{
                employeesService.delete(delEmployee);
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        try {
            departmentService.delete(delDepartment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/dep";
    }
}
