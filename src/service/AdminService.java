package service;

import dao.EmployeeDao;
import model.Employee;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class AdminService {
    EmployeeDao employeeDao;
    public List<Employee> employees;

    public AdminService() throws SQLException, ClassNotFoundException {
        this.employeeDao = new EmployeeDao();
    }

    public void showAllEmployee() throws SQLException, ClassNotFoundException {
        employees = employeeDao.getAll();

    }

    public List<Employee> showEmployeeOnYear() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        int currentDate = Integer.parseInt(dateFormat.format(date).substring(0,4))-621;

        return null;//TODO
    }
}
