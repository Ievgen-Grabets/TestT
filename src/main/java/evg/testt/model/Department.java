package evg.testt.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity(name = "departments")
public class Department extends BaseModel {

    private String name;

    //@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    //@OneToMany(cascade = CascadeType.ALL)
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "department")
    private Set<Employee> employees;

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
