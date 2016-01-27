package evg.testt.service.impl;

import evg.testt.dao.EmployeeDao;
import evg.testt.model.Department;
import evg.testt.model.Employee;
import evg.testt.service.EmployeeService;
import evg.testt.service.Service;

import java.util.List;

/**
 * Created by alex on 27.01.16.
 */
public class EmployeeServiceImpl extends BaseService<Employee, EmployeeDao> implements EmployeeService {
    @Override
    public List<Employee> getByDepartment(Department department) {
        return dao.findByDepartment(department);
    }
}
