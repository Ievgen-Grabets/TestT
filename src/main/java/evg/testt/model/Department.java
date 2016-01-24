package evg.testt.model;

import org.hibernate.annotations.Cache;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "departments")
public class Department extends BaseModel{

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "department")
    private Set<Employee> employees;


    @Column(name = "name")
    private String name;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
