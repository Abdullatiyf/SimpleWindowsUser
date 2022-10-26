package uz.pdp;

import java.util.Scanner;

public class Main {
    static User currentUser = null;
    static Scanner textScan = new Scanner(System.in);
    static Scanner digitScan = new Scanner(System.in);
    static UserService userService = new UserService();

    public static void main(String[] args) {
        welcomeMenu();
        while (true) {
            userMenu();
        }
    }

    public static void welcomeMenu() {
        UserDTO user = new UserDTO();
        System.out.println("Welcome.......");
        System.out.print("Enter admin name:");
        user.setName(textScan.nextLine());
        System.out.print("Enter admin type....1=Admin|2=User|3=Guest:");
        int chose = digitScan.nextInt();
        if (chose == 1) {
            user.setType(Types.ADMIN);
        } else if (chose == 2) {
            user.setType(Types.USER);
        } else if (chose == 3) {
            user.setType(Types.GUEST);
        } else {
            System.err.println("Error");
        }
        System.out.print("Create a password:");
        user.setPassword(textScan.nextLine());
        currentUser = userService.create(user);
    }

    public static void userMenu() {
        if (currentUser.getUserType().equals(Types.ADMIN)) {
            adminMenu();
        } else if (currentUser.getUserType().equals(Types.USER)) {
            menuForUSer();
        }
    }

    private static void menuForUSer() {
        System.out.println("Welcome User=" + currentUser.getAdminName());
        System.out.println("Menu=|0=>Exit|1=>Edit your profile");
        int command = digitScan.nextInt();
        switch (command) {
            case 0:
                return;
            case 1: {
                UserEditDTO userEditDTO = new UserEditDTO();
                System.out.print("Enter new name:");
                userEditDTO.setName(textScan.nextLine());
                System.out.print("Enter new password:");
                userEditDTO.setPassword(textScan.nextLine());
                userEditDTO.setUserType(currentUser.getUserType());
                userService.edit(userEditDTO);
            }
        }
    }

    public static void adminMenu() {
        System.out.println("----->|Welcome to Admin Menu|<-----");
        System.out.println("0=>Exit|1=>Show All Users|2=>Edit your account|3=>Add user");
        int command = digitScan.nextInt();
        switch (command) {
            case 0:
                welcomeMenu();
            case 1: {
                Result result;
                userService.printAll(currentUser);
                System.out.print("Chose by oder number:");
                int index = digitScan.nextInt();
                UserEditDTO userEditDTO = new UserEditDTO();
                System.out.print("Enter new name for user:");
                userEditDTO.setName(textScan.nextLine());
                System.out.print("Change his password:");
                userEditDTO.setPassword(textScan.nextLine());
                userEditDTO.setUserType(currentUser.getUserType());
                result = userService.editUserByAdmin(index, userEditDTO);
                if (result.getSuccess())
                    System.out.println(result.getMessage());
                else System.out.println(result.getMessage());
            }
            break;
            case 2: {
                Result result;
                UserEditDTO userEditDTO = new UserEditDTO();
                System.out.print("Enter new name for Admin:");
                userEditDTO.setName(textScan.nextLine());
                System.out.print("Enter a new password:");
                userEditDTO.setPassword(textScan.nextLine());
                userEditDTO.setUserType(currentUser.getUserType());
                result = userService.edit(userEditDTO);
                if (result.getSuccess()) {
                    System.out.println(result.getMessage());
                } else {
                    System.out.println(result.getMessage());
                }
            }
            break;
            case 3: {
                UserDTO newUserByAdmin = new UserDTO();
                System.out.print("Enter new User's name:");
                newUserByAdmin.setName(textScan.nextLine());
                System.out.print("Enter new User's password");
                newUserByAdmin.setPassword(textScan.nextLine());
                newUserByAdmin.setType(Types.USER);
                userService.create(newUserByAdmin);
            }
            break;
            default:
                System.out.println("Error");
        }
    }
}
