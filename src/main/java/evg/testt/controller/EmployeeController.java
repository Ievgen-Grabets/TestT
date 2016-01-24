package evg.testt.controller;

import evg.testt.model.Department;
import evg.testt.model.Employee;
import evg.testt.service.EmployeeService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 * Created by funtusthan on 17.01.16.
 */

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public ModelAndView showAll(Department department) {
        List<Employee> employees;
        try {
            employees = employeeService.getAll();
        } catch (SQLException e) {
            employees = Collections.emptyList();
            e.printStackTrace();
        }
        return new ModelAndView(JspPath.EMPLOYEE_ALL, "employees", employees);
    }

    @RequestMapping(value = "/empAdd", method = RequestMethod.GET)
    public ModelAndView showAdd() {
        return new ModelAndView(JspPath.EMPLOYEE_ADD);
    }

    @RequestMapping(value = "/empSave", method = RequestMethod.POST)
    public String addNewOne(@RequestParam(required = true) String firstName,
                            @RequestParam(required = true) String secondName) {
        Employee addedEmployee = new Employee();
        addedEmployee.setFirstName(firstName);
        addedEmployee.setSecondName(secondName);
        try {
            employeeService.insert(addedEmployee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/emp";
    }

    @RequestMapping(value = "/empUpdate", method = RequestMethod.GET)
    public ModelAndView showUpdate(@RequestParam(required = true) Integer id) throws SQLException {
        Employee employee = employeeService.getById(id);
        return new ModelAndView(JspPath.EMPLOYEE_UPDATE, "employee", employee);
    }

    @RequestMapping(value = "/empUpdateNow", method = RequestMethod.POST)
    public String updateOne(@RequestParam(required = true) String firstName,
                            @RequestParam(required = true) String secondName,
                            @RequestParam(required = true) Integer id) {
        try {
            Employee employee = new Employee();
            employee.setFirstName(firstName);
            employee.setSecondName(secondName);
            employee.setId(id);
            employeeService.update(employee);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/emp";
    }

    @RequestMapping(value = "/empDelete", method = RequestMethod.GET)
    public String deleteOne(@RequestParam(required = true) Integer id){
        try {
            Employee employee = new Employee();
            employee.setId(id);
            employeeService.delete(employee);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/emp";
    }
}
