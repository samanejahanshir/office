package service;

import dao.EmployeeDao;
import model.Employee;

import java.sql.SQLException;
import java.util.List;

public class AdminService {
    EmployeeDao employeeDao;

    public AdminService() throws SQLException, ClassNotFoundException {
        this.employeeDao = new EmployeeDao();
    }

    public List<Employee> showAllEmployee() throws SQLException, ClassNotFoundException {
      return employeeDao.getAll();
    }
    public List<Employee> showEmployeeOnYear(){
        return  null;//TODO
    }
}
