package evg.testt.service.impl;

import evg.testt.dao.EmployeeDao;
import evg.testt.model.Employee;
import evg.testt.service.EmploeeService;
import org.springframework.stereotype.Service;

@Service
public class EmploeeServiceImpl extends BaseService<Employee, EmployeeDao> implements EmploeeService {
}
