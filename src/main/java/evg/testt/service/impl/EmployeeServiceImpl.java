package evg.testt.service.impl;

import evg.testt.dao.DepartmentDao;
import evg.testt.dao.EmployeeDao;
import evg.testt.model.Department;
import evg.testt.model.Employee;
import evg.testt.service.DepartmentService;
import evg.testt.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * Created by agios on 24.01.16.
 */
@Service
public class EmployeeServiceImpl extends BaseService<Employee, EmployeeDao> implements EmployeeService {
}
