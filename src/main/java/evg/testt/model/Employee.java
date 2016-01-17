package evg.testt.model;

import javax.persistence.Entity;
import java.util.Date;

@Entity(name = "employees")
public class Employee extends BaseModel{

    private String firstName;
    private String secondName;
    private Department departmennt;
    private Date dateOfBirthday;

    public Date getDateOfBirthday() { return dateOfBirthday;  }

    public void setDateOfBirthday(Date dateOfBirthday) { this.dateOfBirthday = dateOfBirthday; }

    public Department getDepartmennt() { return departmennt; }

    public void setDepartmennt(Department departmennt) { this.departmennt = departmennt; }

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
