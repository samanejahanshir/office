import exception.InvalidInputExp;
import model.Employee;
import model.EmployeeInformation;
import model.enums.RangeSalary;
import service.AdminService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static AdminService adminService;

    static {
        try {
            adminService = new AdminService();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        outer:
        while (true) {
            try {
                System.out.println("---------- Welcome to Office ----------");
                System.out.println("1.sign in \n2.exit");
                int selectMenu = scanner.nextInt();
                switch (selectMenu) {
                    case 1:
                        showMenuLogin();
                        break;
                    case 2:
                        break outer;
                    default:
                        throw new InvalidInputExp("you should enter 1 or 2 ");

                }
            } catch (NumberFormatException | InputMismatchException | InvalidInputExp | SQLException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }

    }

    private static void showMenuLogin() throws SQLException, ClassNotFoundException {
        System.out.println("user name :");
        String userName = scanner.next();
        System.out.println("password :");
        String password = scanner.next();
        if (userName.equals("admin") && password.equals("admin")) {
            showAdminMenu();
        }else{
            System.out.println("input just for admin !");
        }
    }

    private static void showAdminMenu() throws SQLException, ClassNotFoundException {
        outer:
        while(true) {
            System.out.println("1.Show All Employee List\n2.Show Employee List on Input Year\n3.exit");
            int selectMenu = scanner.nextInt();
            switch (selectMenu) {
                case 1:
                    System.out.println("---------- List Employees ----------");
                    adminService.showAllEmployee();
                    showList(adminService.employees);
                    break;
                case 2:
                    setListByRange(adminService.showEmployeeOnYear());
                    break;
                case 3:
                    break outer;
                default:
                    throw new InvalidInputExp("you should enter 1 - 3 ");
            }
        }
    }

    public static void showList(List<Employee> employees) {
        System.out.format("+-----+----------------------+--------------+-----------+---------------+------------+----------+%n");
        System.out.format("| ID  |      Full Name       |  Personal ID |   Degree  |   Input Year  |   salary   |  Gender  |%n");
        System.out.format("+-----+----------------------+--------------+-----------+---------------+------------+----------+%n");
        String leftAlignFormat = "| %-3d | %-20s | %-12s | %-10s | %-12s | %-10d | %-8s |%n";
        for (Employee employee : employees) {
            System.out.format(leftAlignFormat,employee.getId(),employee.getFullName(),employee.getPersonalId(),employee.getDegree().getTitle(),employee.getInputYear(),employee.getSalary(),employee.getGender().getName());
        }
        System.out.format("+-----+----------------------+--------------+-----------+---------------+------------+----------+%n");

    }
     public static void setListByRange(List<Employee> employees) {
        List<EmployeeInformation> employeeInformation=new ArrayList<>();
        for (Employee employee : employees) {
            int row=AdminService.year-Integer.parseInt(employee.getInputYear().toString().substring(0,4));
            String range;
           if(employee.getSalary()>1000000 && employee.getSalary()<5000000){
               range= RangeSalary.ONE_TO_FIVE.getRange();
           }else  if(employee.getSalary()>=5000000 && employee.getSalary()<10000000){
               range=RangeSalary.FIVE_TO_TEN.getRange();
           }else{
               range=RangeSalary.UP_TEN.getRange();
           }
            EmployeeInformation employeeInformation1=new EmployeeInformation(employee.getFullName(),employee.getPersonalId()
                    ,employee.getDegree(), employee.getInputYear(),
                    employee.getSalary(),employee.getGender(),row,range);

           employeeInformation.add(employeeInformation1);
        }
        showListByYear( employeeInformation );
    }
public static  void  showListByYear(List<EmployeeInformation> infoEmployees ){
    System.out.format("+-----+--------+----------+-------------+----------------------+%n");
    System.out.format("| Row | I-Year | R-Salary | Personal ID |       Full Name      |%n");
    System.out.format("+-----+--------+----------+-------------+----------------------+%n");
    String leftAlignFormat = "| %-3s | %-6s | %-8s | %-11s | %-20s |%n";
    String row="1";
    String year=infoEmployees.get(0).getInputYear().toString().substring(0,4);
    String rangeSalary=infoEmployees.get(0).getRangeSalary();
    for (int i=0;i<infoEmployees.size();i++) {
        System.out.format(leftAlignFormat,row,year
                ,rangeSalary
                ,infoEmployees.get(i).getPersonalId()
                ,infoEmployees.get(i).getFullName());
        row="";
        year="";
        rangeSalary="";


        if(i<infoEmployees.size()-1 ) {
            if(infoEmployees.get(i).getRow() == infoEmployees.get(i + 1).getRow() && infoEmployees.get(i).getRangeSalary().equals(infoEmployees.get(i+1).getRangeSalary())) {

                System.out.format("|     |        |          |-------------|----------------------|%n");
            }
            if(infoEmployees.get(i).getRow() == infoEmployees.get(i + 1).getRow() &&!infoEmployees.get(i).getRangeSalary().equals(infoEmployees.get(i+1).getRangeSalary())){
                rangeSalary=infoEmployees.get(i+1).getRangeSalary();
                System.out.format("|     |        |----------|-------------|----------------------|%n");

            }
            if (infoEmployees.get(i).getRow() != infoEmployees.get(i + 1).getRow()) {
                row = (infoEmployees.get(i).getRow() + 1) + "";
                year=(infoEmployees.get(i+1).getInputYear().toString().substring(0,4));
                rangeSalary=infoEmployees.get(i+1).getRangeSalary();
                System.out.format("|-----|--------|----------|-------------|----------------------|%n");

            }
        }



    }
    System.out.format("+-----+--------+----------+-------------+----------------------+%n");


}

}
