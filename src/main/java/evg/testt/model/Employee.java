package evg.testt.model;

import javax.persistence.*;

@Entity(name = "employees")
public class Employee extends BaseModel{

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @Id
    private Integer id;



    @Column (name = "firstName")
    private String firstName;

    @Column(name = "secondName")
    private String secondName;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
