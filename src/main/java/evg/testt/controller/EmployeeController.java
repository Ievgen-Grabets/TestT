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

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public ModelAndView showAll() {
        List<Employee> employees;
        try {
            employees = employeeService.getAll();
        } catch (SQLException e) {
            employees = Collections.emptyList();
            e.printStackTrace();
        }

        /*
        System.err.println("employees.size = " + employees.size());
        if(!employees.isEmpty()) {
            Employee employee = employees.get(0);
            System.err.println("empl[0]: name = " + employee.getFirstName());
        }
        */

        return new ModelAndView(JspPath.EMPLOYEE_ALL, "employees", employees);
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
    public ModelAndView showAdd() {

        List<Department> departments;
        try {
            departments = departmentService.getAll();
        } catch (SQLException e) {
            departments = Collections.emptyList();
            e.printStackTrace();
        }

        return new ModelAndView(JspPath.EMLOYEE_ADD,"departments",departments);
    }

    @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
    public String addNewOne(@RequestParam String firstName,
                            @RequestParam String secondName,
                            @RequestParam Integer departmentId) {
        try {

            Employee employee = new Employee();
            employee.setFirstName(firstName);
            employee.setSecondName(secondName);
            employee.setDepartment(departmentService.getById(departmentId));

            employeeService.insert(employee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/employees";
    }


}
