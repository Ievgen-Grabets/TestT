package evg.testt.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department extends BaseModel{

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "dep")
    private List <Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public void addEmployee(Employee employee){
//        this.employees.add(employee);
//        if (employee.getDep() != this){
//            employee.setDep(this);
//        }
//    }

}
