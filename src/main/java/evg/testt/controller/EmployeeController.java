package evg.testt.controller;

import evg.testt.model.Department;
import evg.testt.service.DepartmentService;
import evg.testt.service.EmployeeService;
import evg.testt.util.JspPath;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

/**
 * Created by alex on 27.01.16.
 */
public class EmployeeController {

EmployeeService employeeService;

DepartmentService departmentService;


    @RequestMapping(value = "/empDep", method = RequestMethod.GET)
    public ModelAndView showAll(@RequestParam(required = false) Integer depId) throws SQLException {
        return new ModelAndView(JspPath.EMPLOYEES_ALL, "department", departmentService.getById(depId));
    }
    }
