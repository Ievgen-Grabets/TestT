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
import java.util.Set;

/**
 * Created by agios on 24.01.16.
 */
@Controller
public class EmployeesController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/empDep", method = RequestMethod.GET)
    public ModelAndView showAll(@RequestParam(required = false) Integer depId) throws SQLException {
        return new ModelAndView(JspPath.EMPLOYEES_ALL, "department", departmentService.getById(depId));
    }

    @RequestMapping(value = "/empAdd", method = RequestMethod.GET)
    public ModelAndView showAdd(@RequestParam(required = true) Integer id) throws SQLException {
        return new ModelAndView(JspPath.EMPLOYEES_ADD,"department",departmentService.getById(id));
    }

    @RequestMapping(value = "/empSave", method = RequestMethod.POST)
    public String addNewOne(@RequestParam(required = false) Integer id, String firstName, String secondName) throws SQLException {

        Department dep = departmentService.getById(id);
        Employee addedEmployee = new Employee();
        addedEmployee.setFirstName(firstName);
        addedEmployee.setSecondName(secondName);
        addedEmployee.setDepartment(dep);
        employeeService.insert(addedEmployee);

        return "redirect:/empDep?depId="+dep.getId();
    }

    @RequestMapping(value = "/empDelete", method = RequestMethod.GET)
    public String empDelete(@RequestParam(required = true) Integer empID, Integer depID) throws SQLException {

        Department dep = departmentService.getById(depID);
        employeeService.delete(employeeService.getById(empID));

        return "redirect:/empDep?depId="+dep.getId();
    }
//
    @RequestMapping(value = "/empEdit", method = RequestMethod.GET)
    public ModelAndView showRename(Integer empID) throws SQLException {
        return new ModelAndView(JspPath.EMPLOYEES_RENAME, "employee", employeeService.getById(empID));
    }
    @RequestMapping(value = "/empRename", method = RequestMethod.POST)
    public String Rename(@RequestParam(required = true) Integer empID ,Integer depID, String firstName, String secondName) throws SQLException {

        Department dep = departmentService.getById(depID);
        Employee employee = employeeService.getById(empID);
        employee.setFirstName(firstName);
        employee.setSecondName(secondName);
        employee.setDepartment(dep);
        employeeService.update(employee);

        return "redirect:/empDep?depId="+dep.getId();
    }
}
