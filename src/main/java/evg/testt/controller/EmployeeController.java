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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/empl", method = RequestMethod.GET)
    public ModelAndView showAll(Integer department_id) throws SQLException {
        Department department = departmentService.getById(department_id);
        return new ModelAndView(JspPath.EMPLOYEE_ALL, "department", department);
    }

    @RequestMapping(value = "/emplAdd", method = RequestMethod.GET)
    public ModelAndView showAdd(Integer department_id) throws SQLException {
        Department department = departmentService.getById(department_id);
        return new ModelAndView(JspPath.EMPLOYEE_ADD, "department", department);
    }


    @RequestMapping(value = "/emplSave", method = RequestMethod.POST)
    public String addNewOne(String firstName, String secondName, Long dateOfBirthday,
                            Integer department_id) throws SQLException {
        Employee employee = new Employee();
        Date birthdayDay = new Date(dateOfBirthday);
        employee.setDateOfBirthday(birthdayDay);
        employee.setFirstName(firstName);
        employee.setSecondName(secondName);
        Department department = departmentService.getById(department_id);
        employee.setDepartment(department);
        employeeService.insert(employee);
        return "redirect:/dep";
    }

    @RequestMapping(value = "/emplDelete",method = RequestMethod.POST)
    public String deleteOne(@RequestParam(required = true) Integer id) throws SQLException {
        Employee employee = new Employee();
        employee.setId(id);
        employeeService.delete(employee);
        return "redirect:/dep";
    }

    @RequestMapping(value = "/emplUpdate",method = RequestMethod.POST)
    public ModelAndView updateOne(@RequestParam(required = true) Integer id) throws SQLException {
        Employee employee = employeeService.getById(id);
        return new ModelAndView(JspPath.EMPLOYEE_UPDATE, "employee", employee);
    }

    @RequestMapping(value = "/emplSaveUpdated",method = RequestMethod.POST)
    public String saveUpdatedOne(@RequestParam(required = true) Integer id, String firstName, String secondName,
                                 Long dayOfBirthday, Integer department_id) throws SQLException {
        Employee employee = new Employee();
        Department department = departmentService.getById(department_id);
        employee.setDepartment(department);
        employee.setId(id);
        employee.setFirstName(firstName);
        employee.setSecondName(secondName);
        Date date = new Date(dayOfBirthday);
        employee.setDateOfBirthday(date);
        employeeService.update(employee);
        return "redirect:/dep";
    }

}
