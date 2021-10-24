package model;

import model.enums.Degree;
import model.enums.Gender;

import java.util.Date;

public class EmployeeInformation extends Employee{
    private  int row;
    private String rangeSalary;

    public EmployeeInformation(String fullName, String personalId, Degree degree, Date inputYear, long salary, Gender gender, int row, String rangeSalary) {
        super(fullName, personalId, degree, inputYear, salary, gender);
        this.row = row;
        this.rangeSalary = rangeSalary;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getRangeSalary() {
        return rangeSalary;
    }

    public void setRangeSalary(String rangeSalary) {
        this.rangeSalary = rangeSalary;
    }
}
