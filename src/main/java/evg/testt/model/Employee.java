package evg.testt.model;

import javax.persistence.*;

@Entity(name = "employees")
public class Employee extends BaseModel{

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "department_id")
    private Department department;

    private String firstName;
    private String secondName;

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

    public static Builder newBuilder(){
        return new Employee().new Builder();
    }

    public class Builder {

        private Builder(){}

        public Builder setId(Integer id){
            Employee.this.setId(id);
            return this;
        }

        public Builder setFirstName(String name){
            Employee.this.setFirstName(name);
            return this;
        }

        public Builder setSecondName(String name){
            Employee.this.setSecondName(name);
            return this;
        }

        public Builder setDepartment(Department department){
            Employee.this.setDepartment(department);
            return this;
        }

        public Employee build(){
            return Employee.this;
        }





    }
}
