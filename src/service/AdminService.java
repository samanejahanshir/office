package service;

import dao.EmployeeDao;
import model.Employee;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class AdminService {
    EmployeeDao employeeDao;
    public  List<Employee> employees=new ArrayList<>();
    public  static final  int year=setCurrentYear();

    private static int setCurrentYear() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        int currentYear;
        if(Integer.parseInt(dateFormat.format(date).substring(5,7))>3) {
           currentYear= Integer.parseInt(dateFormat.format(date).substring(0, 4)) - 621;
        } else {
            currentYear= Integer.parseInt(dateFormat.format(date).substring(0, 4)) - 622;
        }
        return currentYear;
    }

    public AdminService() throws SQLException, ClassNotFoundException {
        this.employeeDao = new EmployeeDao();
    }

    public void showAllEmployee() throws SQLException, ClassNotFoundException {
        employees = employeeDao.getAll();


    }

    public  List<Employee> showEmployeeOnYear() throws SQLException, ClassNotFoundException {
        List<Employee> employeesInYears=new ArrayList<>();
        for (Employee employee : employees) {
            int yearDifference=year-Integer.parseInt(employee.getInputYear().toString().substring(0,4));
            if(yearDifference<=5){
                employeesInYears.add(employee);
            }

        }
        Collections.sort(employeesInYears);
       employeesInYears.sort(new EmployeeComparator());
        return employeesInYears;

    }


}
