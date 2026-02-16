package SQLHomeWork;

import SQLHomeWork.EmployeeDAO;
import SQLHomeWork.Employee;
import java.sql.Date;

public class Main {

    public static void main(String[] args) throws Exception {

        EmployeeDAO dao = new EmployeeDAO();

        Employee emp = new Employee(
                1,
                "Nandan",
                "IT",
                50000,
                Date.valueOf("2023-01-01")
        );

        dao.insertEmp(emp);

        System.out.println("Max Salary: " + dao.getMaxSal());
        System.out.println("Avg Salary: " + dao.getAvgSal());
    }
}
