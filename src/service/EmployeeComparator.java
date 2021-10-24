package service;

import model.Employee;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {


    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.compareTo(o2)==0) {
            return Long.compare(o1.getSalary(), o2.getSalary());
        }
        else
            return 1;

    }
}
