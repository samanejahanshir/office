import exception.InvalidInputExp;
import model.Employee;
import service.AdminService;

import java.sql.SQLException;
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
        }
    }

    private static void showAdminMenu() throws SQLException, ClassNotFoundException {
        System.out.println("1.Show All Employee List\n2.Show Employee List on Input Year\n3.exit");
        int selectMenu = scanner.nextInt();
        switch (selectMenu) {
            case 1:
                System.out.println("---------- List Employees ----------");
                adminService.showAllEmployee();
                for (Employee employee : adminService.employees) {
                    System.out.println(employee);
                }

            case 2:
                adminService.showEmployeeOnYear();
            case 3:
            default:
                throw new InvalidInputExp("you should enter 1 - 3 ");
        }
    }
}
