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

    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public ModelAndView showAll(Integer dep_id) throws SQLException {

            Department department = departmentService.getById(dep_id);

        return new ModelAndView(JspPath.EMPLOYEE_ALL, "department", department);
    }

    @RequestMapping(value = "/empAdd", method = RequestMethod.GET)
    public ModelAndView showAdd(Integer dep_id) throws SQLException {

        Department department = departmentService.getById(dep_id);
        return new ModelAndView(JspPath.EMPLOYEE_ADD, "department", department);
    }

    @RequestMapping(value = "/empSave", method = RequestMethod.POST)
    public String addNewOne(@RequestParam(required = true) String firstName,
                            @RequestParam(required = true) String secondName,
                            Integer dep_id) throws SQLException {
        Employee addedEmployee = new Employee();
        Department department = departmentService.getById(dep_id);
        addedEmployee.setFirstName(firstName);
        addedEmployee.setSecondName(secondName);
        addedEmployee.setDep(department);
        try {
            employeeService.insert(addedEmployee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/emp?dep_id=" + department.getId();
    }

    @RequestMapping(value = "/empUpdate", method = RequestMethod.GET)
    public ModelAndView showUpdate(@RequestParam(required = true) Integer id) throws SQLException {
        Employee employee = employeeService.getById(id);
        return new ModelAndView(JspPath.EMPLOYEE_UPDATE, "employee", employee);
    }

    @RequestMapping(value = "/empUpdateNow", method = RequestMethod.POST)
    public String updateOne(@RequestParam(required = true) String firstName,
                            @RequestParam(required = true) String secondName,
                            @RequestParam(required = true) Integer id,
                            @RequestParam(required = true) Integer dep_id) throws SQLException {
        Employee employee = new Employee();
        Department department = departmentService.getById(dep_id);
        try {
            employee.setDep(department);
            employee.setFirstName(firstName);
            employee.setSecondName(secondName);
            employee.setId(id);
            employeeService.update(employee);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/emp?dep_id=" + department.getId();
    }

    @RequestMapping(value = "/empDelete", method = RequestMethod.GET)
    public String deleteOne(@RequestParam(required = true) Integer id) throws SQLException {
        Employee employee = new Employee();
        Integer integer = employeeService.getById(id).getDep().getId();

        try {
            employee.setId(id);
            employeeService.delete(employee);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/emp?dep_id=" + integer;
    }
}
