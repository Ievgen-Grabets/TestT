package evg.testt.controller;

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
 * Created by milu on 21.01.16.
 */
@Controller
public class EmployeeController {

        @Autowired
        EmployeeService employeeService;

    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public ModelAndView showAll(){
        List<Employee> employees;
        try {
            employees = employeeService.getAll();
        }
        catch (SQLException e){
            employees = Collections.emptyList();
            e.printStackTrace();
        }
        return new ModelAndView(JspPath.EMPLOYEE_ALL, "employees", employees);
    }

    @RequestMapping(value = "/empAdd", method = RequestMethod.GET)
    public ModelAndView showAdd(){
        return new ModelAndView(JspPath.EMPLOYEE_ADD);
    }

    @RequestMapping(value = "/empSave", method = RequestMethod.POST)
    public String addNewOne(@RequestParam(required=true) String name, String surname){
        Employee addEmployee = new Employee();
        addEmployee.setFirstName(name);
        addEmployee.setSecondName(surname);

        try {
            employeeService.insert(addEmployee);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return "redirect:/dep";
    }

}
