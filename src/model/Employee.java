package model;

import model.enums.Degree;
import model.enums.Gender;

import java.util.Date;

public class Employee {
    private  int id;
    private  String fullName;
    private String personalId;
    private Degree degree;
    private Date inputYear;
    private long salary;
    private Gender gender;

    public Employee(String fullName, String personalId, Degree degree, Date inputYear, long salary,Gender gender) {
        this.fullName = fullName;
        this.personalId = personalId;
        this.degree = degree;
        this.inputYear = inputYear;
        this.salary = salary;
        this.gender=gender;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Date getInputYear() {
        return inputYear;
    }

    public void setInputYear(Date inputYear) {
        this.inputYear = inputYear;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}
