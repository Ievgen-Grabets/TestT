package evg.testt.controller;

import evg.testt.model.Department;
import evg.testt.service.DepartmentService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

import java.sql.SQLException;

//Branch test-sb
@Controller
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/dep", method = RequestMethod.GET)
    public ModelAndView showAll() {
        List<Department> departments;
        try {
            departments = departmentService.getAll();
        } catch (SQLException e) {
            departments = Collections.emptyList();
            e.printStackTrace();
        }
        return new ModelAndView(JspPath.DEPARTMENT_ALL, "departments", departments);
    }

    @RequestMapping(value = "/depAdd", method = RequestMethod.GET)
    public ModelAndView showAdd() {
        return new ModelAndView(JspPath.DEPARTMENT_ADD);
    }

    @RequestMapping(value = "/depSave", method = RequestMethod.POST)
    public String addNewOne(@RequestParam(required = true) String name) {
        Department addedDepartment = new Department();
        addedDepartment.setName(name);
        try {
            departmentService.insert(addedDepartment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/dep";
    }


    @RequestMapping(value = "/depEdit", method = RequestMethod.GET)
    public ModelAndView showEdit(@RequestParam(value = "id", required=true)Integer id) throws SQLException{

            Department department = departmentService.getById(id);
            return new ModelAndView(JspPath.DEPARTMENT_EDIT,"department",department);

    }
    /*@RequestMapping(value = "/updateDep", method = RequestMethod.POST)
    public String editDep(@RequestParam (required  = true) String name, @RequestParam(value="id", required = true)Integer id ){
        try {
            Department ediDep = new Department();
            ediDep.setName(name);
            ediDep.setId(id);
            departmentService.update(ediDep);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return "redirect:/dep";
    }*/
    @RequestMapping(value = "/updateDep", method = RequestMethod.POST)
    public String editDep(@ModelAttribute Department department){
        try{
                departmentService.update(department);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return "redirect:/dep";
    }

    @RequestMapping(value = "/deleteDep", method = RequestMethod.GET)
    public String deleteOne(@RequestParam(required = true) Integer id){
        try {
            Department deleteDepartment = new Department();
            deleteDepartment.setId(id);
            departmentService.delete(deleteDepartment);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return "redirect:/dep";
    }

}
