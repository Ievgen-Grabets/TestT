package evg.testt.service;

import evg.testt.model.Department;
import evg.testt.model.Employee;

import java.util.List;

/**
 * Created by alex on 27.01.16.
 */
public interface EmployeeService extends Service<Employee>{
    List<Employee> getByDepartment (Department department);
}

