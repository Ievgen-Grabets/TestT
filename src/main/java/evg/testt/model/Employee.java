package evg.testt.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.Set;

@Entity(name = "employees")
public class Employee extends BaseModel{

    private String firstName;
    private String secondName;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;
    private Date dateOfBirthday;

    public Date getDateOfBirthday() { return dateOfBirthday;  }

    public void setDateOfBirthday(Date dateOfBirthday) { this.dateOfBirthday = dateOfBirthday; }

    public Department getDepartment() { return department; }

    public void setDepartment(Department department) { this.department = department; }

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
