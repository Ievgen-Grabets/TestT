package evg.testt.service.impl;

import evg.testt.dao.EmployeeDao;
import evg.testt.model.Employee;
import evg.testt.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * Created by funtusthan on 24.01.16.
 */
@Service
public class EmployeeServiceIml extends BaseService<Employee, EmployeeDao> implements EmployeeService{
}
