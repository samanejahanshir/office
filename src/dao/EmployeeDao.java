package dao;

import model.Employee;
import model.enums.Degree;
import model.enums.Gender;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao extends AccessDao {
    public EmployeeDao() throws SQLException, ClassNotFoundException {
    }

    public List<Employee> getAll() throws SQLException, ClassNotFoundException {
        if (getConnection() != null) {

            PreparedStatement statement = getConnection().prepareStatement("select * from employee");
            ResultSet resultSet = statement.executeQuery();
            List<Employee> employees = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String fullName = resultSet.getString("full_name");
                String personalId = resultSet.getString("personal_id");
                String degree = resultSet.getString("degree");
                Date inputYear = resultSet.getDate("input_year");
                long salary = resultSet.getLong("salary");
                String gender = resultSet.getString("gender");
                Employee employee = new Employee(fullName, personalId, Degree.getDegree(degree), inputYear, salary, Gender.getVal(gender));
                employee.setId(id);
                employees.add(employee);
            }
            return employees;
        }
        return null;
    }

}
