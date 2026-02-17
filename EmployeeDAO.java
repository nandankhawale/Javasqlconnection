package SQLHomeWork;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import SQLHomeWork.Employee;

public class EmployeeDAO {

    private String url = "jdbc:mysql://localhost:3307/testdb";
    private String username = "root";
    private String password = "";

    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, username, password);
    }

    // ---------------- INSERT ----------------
    public void insertEmp(Employee emp) throws Exception {

        String sql = "INSERT INTO employee VALUES (?, ?, ?, ?, ?)";
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, emp.getId());
        ps.setString(2, emp.getName());
        ps.setString(3, emp.getDept());
        ps.setDouble(4, emp.getSalary());
        ps.setDate(5, emp.getJoiningDt());

        ps.executeUpdate();
        con.close();
    }

    // ---------------- UPDATE ----------------
    public void updateEmp(Employee emp) throws Exception {

        String sql = "UPDATE employee SET name=?, dept=?, salary=?, joiningDt=? WHERE id=?";
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, emp.getName());
        ps.setString(2, emp.getDept());
        ps.setDouble(3, emp.getSalary());
        ps.setDate(4, emp.getJoiningDt());
        ps.setInt(5, emp.getId());

        ps.executeUpdate();
        con.close();
    }

    // ---------------- DELETE ----------------
    public void deleteEmp(int id) throws Exception {

        String sql = "DELETE FROM employee WHERE id=?";
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);
        ps.executeUpdate();
        con.close();
    }

    // ---------------- GET ALL ----------------
    public List<Employee> getEmp() throws Exception {

        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employee";
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Employee emp = new Employee(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("dept"),
                    rs.getDouble("salary"),
                    rs.getDate("joiningDt")
            );
            list.add(emp);
        }

        con.close();
        return list;
    }

    // ---------------- GET BY DEPT ----------------
    public List<Employee> getEmpByDept(String dept) throws Exception {

        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employee WHERE dept=?";
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, dept);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Employee emp = new Employee(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("dept"),
                    rs.getDouble("salary"),
                    rs.getDate("joiningDt")
            );
            list.add(emp);
        }

        con.close();
        return list;
    }

    // ---------------- MAX SALARY ----------------
    public double getMaxSal() throws Exception {

        String sql = "SELECT MAX(salary) FROM employee";
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        double max = 0;
        if (rs.next()) {
            max = rs.getDouble(1);
        }

        con.close();
        return max;
    }

    // ---------------- AVG SALARY ----------------
    public double getAvgSal() throws Exception {

        String sql = "SELECT AVG(salary) FROM employee";
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        double avg = 0;
        if (rs.next()) {
            avg = rs.getDouble(1);
        }

        con.close();
        return avg;
    }
}


