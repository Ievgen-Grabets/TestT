package evg.testt.model;

import javax.persistence.Entity;
import java.util.List;

@Entity(name = "departments")
public class Department extends BaseModel{

    private String name;

    public List<Employee> getEmployees() { return employees; }

    public void setEmployees(List<Employee> employees) { this.employees = employees; }

    private List<Employee> employees;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
