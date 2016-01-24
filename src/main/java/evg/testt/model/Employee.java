package evg.testt.model;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee extends BaseModel{

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "secondName")
    private String secondName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dep_id")
    private Department dep;

    public Department getDep() {
        return dep;
    }

    public void setDep(Department dep) {
        this.dep = dep;
//        if (!dep.getEmployees().contains(this)) {
//            dep.getEmployees().add(this);
//        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

}
