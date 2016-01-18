package evg.testt.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "departments")
public class Department extends BaseModel {

    private String name;

    //@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    @OneToMany(cascade = CascadeType.ALL)
    private List<Employee> employees;

    public void addEmployee(Employee employee) {
        employee.setDepartment(this);
        employees.add(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
