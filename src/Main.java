import exception.InvalidInputExp;
import service.AdminService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
   public static Scanner scanner=new Scanner(System.in);
   public  static AdminService adminService=new AdminService();
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
                        break ;
                    case 2:
                        break outer;
                    default:
                        throw new InvalidInputExp("you should enter 1 or 2 ");

                }
            }catch (NumberFormatException | InputMismatchException | InvalidInputExp e){
                System.out.println(e.getMessage());
            }
        }

    }

    private static void showMenuLogin() {
        System.out.println("user name :");
        String userName=scanner.next();
        System.out.println("password :");
        String password=scanner.next();
        if(userName.equals("admin") && password.equals("admin")){
            showAdminMenu();
        }
    }

    private static void showAdminMenu() {
        System.out.println("1.Show All Employee List\n2.Show Employee List on Input Year\n3.exit");
        int selectMenu=scanner.nextInt();
        switch (selectMenu){
            case 1:
            case 2:
            case 3:
            default:
                throw new InvalidInputExp("you should enter 1 - 3 ");
        }
    }
}
