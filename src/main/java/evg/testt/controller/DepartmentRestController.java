package evg.testt.controller;

import evg.testt.model.Department;
import evg.testt.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class DepartmentRestController {

    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/department/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Department> getDepartment(@PathVariable("id") int id) {
        Department department;
        try {
            department = departmentService.getById(id);
        } catch (SQLException e) {
            return new ResponseEntity<Department>(HttpStatus.SERVICE_UNAVAILABLE);
        }
        if (department == null) {
            return new ResponseEntity<Department>(HttpStatus.SERVICE_UNAVAILABLE);
        }
        return new ResponseEntity<Department>(department, HttpStatus.OK);
    }



}
