package evg.testt.service;

import evg.testt.model.Department;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface DepartmentService extends Service<Department>{

    void test();

}
