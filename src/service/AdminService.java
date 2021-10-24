package service;

import dao.EmployeeDao;
import model.Employee;

import java.sql.SQLException;
import java.util.List;

public class AdminService {
    EmployeeDao employeeDao;
    public  List<Employee> employees;

    public AdminService() throws SQLException, ClassNotFoundException {
        this.employeeDao = new EmployeeDao();
    }

    public void showAllEmployee() throws SQLException, ClassNotFoundException {
      employees=employeeDao.getAll();

    }
    public List<Employee> showEmployeeOnYear(){
        return  null;//TODO
    }
}
