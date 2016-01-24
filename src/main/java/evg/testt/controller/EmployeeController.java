package evg.testt.controller;

import evg.testt.model.Department;
import evg.testt.model.Employee;
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

import java.sql.SQLException;
import java.util.*;

/**
 * Created by oleg on 22.01.16.
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;


    @RequestMapping(value = "/empAdd", method = RequestMethod.GET)
    public ModelAndView showAdd(@RequestParam("departmentID") int departmentID) {
        return new ModelAndView(JspPath.EMPLOYEE_ADD);
    }

    @RequestMapping(value = "/depEmp", method = RequestMethod.GET)
    public ModelAndView showAll(@RequestParam("departmentID") int departmentID) {
        List<Employee> employees = getEmployees();
        List<Employee> showedEmployees = new ArrayList<>();

        for (Employee employee : employees) {
            try {
                if (employee.getDepartment().getId() == departmentID) {
                    showedEmployees.add(employee);
                }
            } catch (NullPointerException nPEx) {
                //NOP
            }
        }

        return new ModelAndView(JspPath.EMPLOYEE_ALL, "employees", showedEmployees);
    }

    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public ModelAndView showAll() {
        List<Employee> employees = getEmployees();
        return new ModelAndView(JspPath.EMPLOYEE_ALL, "employees", employees);
    }

    private List<Employee> getEmployees() {
        List<Employee> employees;
        try {
            employees = employeeService.getAll();
        } catch (SQLException e) {
            employees = Collections.emptyList();
            //e.printStackTrace();
        }
        return employees;
    }

    @RequestMapping(value = "/empSave", method = RequestMethod.POST)
    public  String addNewOne(@RequestParam(value="departmentID") int departmentID,
                                   @RequestParam(value="firstName") String firstName,
                                   @RequestParam(value="secondName") String secondName) {
        Employee employee = new Employee();
        employee.setDate(new Date());
        employee.setFirstName(firstName);
        employee.setSecondName(secondName);
        Department department = null;
        try {
            department = departmentService.getById(departmentID);
        } catch (SQLException sqlEx) {
            suppressingSQLException(sqlEx);
        }
        employee.setDepartment(department);
        try {
            employeeService.insert(employee);
        } catch (SQLException sqlEx) {
            suppressingSQLException(sqlEx);
        }
        Set<Employee> employees = department.getEmployees();
        employees.add(employee);
        try {
            departmentService.update(department);
        } catch (SQLException sqlEx) {
            suppressingSQLException(sqlEx);
        }

        return "redirect:/depEmp?departmentID=" + departmentID;
    }

    @RequestMapping(value = "/empDel", method = RequestMethod.POST)
    public  String delete(@RequestParam(value="employeeID") int employeeID) {
        Employee employee = null;
        try {
            employee = employeeService.getById(employeeID);
        } catch (SQLException sqlEx) {
            suppressingSQLException(sqlEx);
        }
        Department department = null;
        try {
            department = employee.getDepartment();
            department.getEmployees().remove(employee);
        } catch (NullPointerException nPEx) {
            //NOP
        }

        try {
            employeeService.delete(employee);
        } catch (SQLException sqlEx) {
            suppressingSQLException(sqlEx);
        }

        try {
            return "redirect:/depEmp?departmentID=" + department.getId();
        } catch (NullPointerException nPEx) {
            //NOP
        }

        return "redirect:/emp";
    }

    @RequestMapping(value = "/empEdit", method = RequestMethod.POST)
    public ModelAndView showEdit(@RequestParam("employeeID") int employeeID) {
        Employee employee = null;
        try {
            employee = employeeService.getById(employeeID);
        } catch (SQLException sqlEx) {
            suppressingSQLException(sqlEx);
        }
        return new ModelAndView(JspPath.EMPLOYEE_EDIT, "employee", employee);
    }

    @RequestMapping(value = "/empSaveEdited", method = RequestMethod.POST)
    public String edit(@RequestParam(value="employeeID") int employeeID,
                       @RequestParam(value="firstName") String firstName,
                       @RequestParam(value="secondName") String secondName) {
        Employee employee = null;
        try {
            employee = employeeService.getById(employeeID);
        } catch (SQLException sqlEx) {
            suppressingSQLException(sqlEx);
        }
        employee.setFirstName(firstName);
        employee.setSecondName(secondName);
        try {
            employeeService.update(employee);
        } catch (SQLException sqlEx) {
            suppressingSQLException(sqlEx);
        }

        return "redirect:/depEmp?departmentID=" + employee.getDepartment().getId();
    }

    private void suppressingSQLException(SQLException sqlEx) {
        RuntimeException exception = new RuntimeException();
        exception.addSuppressed(sqlEx);
        throw exception;
    }
}
