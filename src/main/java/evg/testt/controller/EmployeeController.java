package evg.testt.controller;

import evg.testt.model.Employee;
import evg.testt.service.EmployeeService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 * Created by alex on 18.01.16.
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

   /* @RequestMapping(value = "/empl", method = RequestMethod.GET)
    public ModelAndView showAll() {
        List<Employee> employees;
        try {
            employees = employeeService.getAll();
        } catch (SQLException e) {
            employees = Collections.emptyList();
            e.printStackTrace();
        }
        return new ModelAndView(JspPath.EMPLOYEE_ALL, "employees", employees);
    }*/

}
