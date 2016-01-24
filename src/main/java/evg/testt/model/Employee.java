package evg.testt.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity(name = "employees")
public class Employee extends BaseModel{

    @ManyToOne
    private Department department;
    private Date date;

    private String firstName;
    private String secondName;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
