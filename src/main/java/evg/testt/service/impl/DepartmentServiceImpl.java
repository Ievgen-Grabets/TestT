package evg.testt.service.impl;

import evg.testt.dao.DepartmentDao;
import evg.testt.model.Department;
import evg.testt.service.DepartmentService;
import evg.testt.service.EmployeeService;
import org.hibernate.annotations.Target;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.sql.SQLException;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class DepartmentServiceImpl extends BaseService<Department, DepartmentDao> implements DepartmentService{

    @PersistenceContext(type= PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    @Autowired
    private EmployeeService employeeService;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public List<Department> getAll() throws SQLException {
        List<Department> departments = dao.findAll();
        TransactionSynchronizationManager.isActualTransactionActive();
        for(Department department: departments){
            employeeService.getByDepartment(department);
            System.out.println("department.getEmployees()" + department.getEmployees());
        }
        return departments;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void test(){
        //entityManager.getTransaction().begin();
        TransactionSynchronizationManager.isActualTransactionActive();
        //entityManager.getTransaction().commit();
    }


}
