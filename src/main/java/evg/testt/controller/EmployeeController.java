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

        return new ModelAndView(JspPath.EMPLOYEE_ALL, "employees", employees);
    }

    private List<Department> getDepartments() {
        List<Department> departments;
        try {
            departments = departmentService.getAll();
        } catch (SQLException e) {
            departments = Collections.emptyList();
            e.printStackTrace();
        }
        return departments;
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
    public ModelAndView addNew() {
        return makeModelAndViewForEdit(new Employee());
    }

    private ModelAndView makeModelAndViewForEdit(Employee editEmployee) {
        List<Department> departments = getDepartments();

        ModelAndView modelAndView = new ModelAndView(JspPath.EMPLOYEE_ADD);
        modelAndView.addObject("departments",departments);
        modelAndView.addObject("editEmployee", editEmployee);

        return modelAndView;
    }

    @RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam(required = true) Integer id) {
        try {
            return makeModelAndViewForEdit(employeeService.getById(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return showAll();
    }


    @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
    public String save(@ModelAttribute Employee employee) {
        try {
            employeeService.update(employee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/employees";
    }

    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
    public String delete(@RequestParam(required = true) Integer id) {
        try {
            Employee employee = new Employee();
            employee.setId(id);
            employeeService.delete(employee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/employees";
    }

}
