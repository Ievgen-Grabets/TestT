package evg.testt.service.impl;

import evg.testt.dao.EmployeeDao;
import evg.testt.model.Employee;
import evg.testt.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * Created by alex on 18.01.16.
 */
@Service
public class EmployeeServiseImpl extends BaseService<Employee, EmployeeDao> implements EmployeeService {
}
