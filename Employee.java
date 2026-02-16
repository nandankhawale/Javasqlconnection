package SQLHomeWork;

import java.sql.Date;

public class Employee {

    private int id;
    private String name;
    private String dept;
    private double salary;
    private Date joiningDt;

    public Employee() {}

    public Employee(int id, String name, String dept, double salary, Date joiningDt) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.joiningDt = joiningDt;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDept() { return dept; }
    public void setDept(String dept) { this.dept = dept; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public Date getJoiningDt() { return joiningDt; }
    public void setJoiningDt(Date joiningDt) { this.joiningDt = joiningDt; }
}
