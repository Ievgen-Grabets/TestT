package evg.testt.model;

import org.hibernate.annotations.Cache;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "departments")
public class Department extends BaseModel{

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "department")
    private Set<Employee> employees;

    @Id
    Integer id;

    @Column(name = "name")
    private String name;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

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
