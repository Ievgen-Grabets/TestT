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

import java.sql.SQLException;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Controller
public class EmployeesController {

    @Autowired
    DepartmentService departmentService;
    @Autowired
    EmployeesService employeesService;

    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public ModelAndView showAllEmp() {
        List<Employee> employees;
        try {
            employees = employeesService.getAll();
        } catch (SQLException e) {
            employees = Collections.emptyList();
            e.printStackTrace();
        }
        return new ModelAndView(JspPath.EMPLOYEES_ALL, "employees", employees);
    }

    @RequestMapping(value = "/depEmp", method = RequestMethod.GET)
    public ModelAndView showAll(@RequestParam(required = true) int depId) {
        Set<Employee> employees;
        try {
            Department department = departmentService.getById(depId);
            employees = department.getEmployees();
        } catch (SQLException e) {
            employees = Collections.emptySet();
            e.printStackTrace();
        }
        return new ModelAndView(JspPath.EMPLOYEES_ALL, "employees", employees);
    }

    @RequestMapping(value = "/empAdd", method = RequestMethod.GET)
    public ModelAndView showAdd(@RequestParam(required = true) int depId) {
        return new ModelAndView(JspPath.EMPLOYEES_ADD);
    }

    //@RequestMapping(value = "/emp", method = R)

    @RequestMapping(value = "/empSave", method = RequestMethod.POST)
    public String addNewOne(@RequestParam(required = true) String firstName,
                            @RequestParam(required = true) String secondName,
                            @RequestParam(required = true) int depId) {
        Employee addedEmployee = new Employee();
        addedEmployee.setFirstName(firstName);
        addedEmployee.setSecondName(secondName);
        addedEmployee.setDate(new Date());
        try {
            Department department = departmentService.getById(depId);
            addedEmployee.setDepartment(department);
            employeesService.insert(addedEmployee);
            department.getEmployees().add(addedEmployee);
            departmentService.update(department);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/depEmp?depId="+depId;
    }

    @RequestMapping(value = "/empEdit", method = RequestMethod.POST)
    public ModelAndView showEdit(@RequestParam(required = true) int empId) {
        Employee employee = null;
        try {
            employee = employeesService.getById(empId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ModelAndView(JspPath.EMPLOYEES_EDIT, "employee", employee);
    }

    @RequestMapping(value = "/empEditSave", method = RequestMethod.POST)
    public String Edit(@RequestParam(required = true) String firstName, @RequestParam(required = true) String secondName, @RequestParam(required = true) int empId) {
        Employee editedEmployee = null;
        Integer depId = null;
        try {
            editedEmployee = employeesService.getById(empId);
            depId = editedEmployee.getDepartment().getId();
            editedEmployee.setFirstName(firstName);
            editedEmployee.setSecondName(secondName);
            employeesService.update(editedEmployee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/depEmp?depId="+depId;

    }

    @RequestMapping(value = "/empDel", method = RequestMethod.POST)
    public String delete(@RequestParam(required = true) int empId) throws SQLException {
        Employee delEmployee = employeesService.getById(empId);
        Department department = delEmployee.getDepartment();
        Integer depId = department.getId();
        department.getEmployees().remove(delEmployee);
        employeesService.delete(delEmployee);
        //employeesService.update(delEmployee);
        //departmentService.update(department);
       // return "redirect:/dep";
        return "redirect:/depEmp?depId="+depId;
    }
}
