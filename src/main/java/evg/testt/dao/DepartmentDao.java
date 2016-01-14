package evg.testt.dao;

import evg.testt.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
//Branch test-sb
public interface DepartmentDao extends JpaRepository<Department, Integer> {

}
