package a4SuperUser;

import java.io.IOException;
import java.util.Scanner;

public class UserApplication {
    static Scanner scan = new Scanner(System.in);
    static boolean validLogins = false;
    static String username = null;
    static boolean  superuser = false;

    public static void main(String[] args) throws IOException {

        loginScreen();

    }

    public static void loginScreen() throws IOException {
        UserService.readFile();

        int invalidLogins = 0;
        int indexOfUsers = 0;
        //5 login trials before program termination
        while (invalidLogins < 5 && !validLogins) {
            System.out.println("Enter your email:");
            String email = scan.nextLine();
            System.out.println("Enter your password:");
            String password = scan.nextLine();
            
            // validating username and password
            for(indexOfUsers = 0; indexOfUsers < UserService.users.length; indexOfUsers++) {
                if((email.equalsIgnoreCase(UserService.users[indexOfUsers].getEmail())) &&  (password.equals(UserService.users[indexOfUsers].getPassword()))){

                    System.out.println("Welcome " + UserService.users[indexOfUsers].getName());
                    username = UserService.users[indexOfUsers].getName();

                    validLogins = true;
                    //validation of role - super user or normal user
                    if (UserService.users[indexOfUsers].getRole().equals("super_user")){
                        superuser = true;
                        superUserMenu(indexOfUsers);}
                    else {
                        normalUserMenu(indexOfUsers);}
                }
            }

            if (validLogins == false){
                System.out.println("Invalid login. Please try again");
                invalidLogins++;
            }
            if(invalidLogins == 5) {
                System.out.println("Too many failed login attempts, you are now locked out.");
            }
        }
        System.out.println("Program terminates");
        scan.close();
    }



   
    
    
    
    private static void superUserMenu(int indexOfUsers) throws IOException {
        String option = null;
        System.out.println("----------");

        System.out.println("Please choose from the following options:");
        System.out.println("(0) Log in as another user");
        System.out.println("(1) Update username");
        System.out.println("(2) Update password");
        System.out.println("(3) Update name");
        System.out.println("(4) Exit");

        option = scan.nextLine();
        while(option !="4") {
            if(option.equals("0")) {
                while (validLogins) {
                    System.out.println("Which user would you like to login as? (Type in a valid user email)");

                    String email = scan.nextLine();

                    for(indexOfUsers = 0; indexOfUsers < UserService.users.length; indexOfUsers++) {
                        if((email.equalsIgnoreCase(UserService.users[indexOfUsers].getEmail()))){

                            System.out.println("Welcome " + UserService.users[indexOfUsers].getName() +", " +UserService.users[indexOfUsers].getRole());
                            username = UserService.users[indexOfUsers].getName();
                            validLogins = true;
                            normalUserMenu(indexOfUsers);
                        }
                    } break; 
                }
                break;
            }
            else if(option.equals("1")) {
                System.out.println("Updating username");
                UserService.changeUserEmail(scan);
                System.out.println("Your username has been changed");
                superUserMenu(indexOfUsers);
                //break;
            }
            else if(option.equals("2")) {
                System.out.println("Updating password");
                UserService.changeUserPassword(scan);
                System.out.println("Your password has been changed");
                superUserMenu(indexOfUsers);
            }
            else if(option.equals("3")) {
                System.out.println("Updating name");
                UserService.changeUserName(scan);
                System.out.println("	, "+ UserService.users[indexOfUsers].getName());
                superUserMenu(indexOfUsers);
            }
            else if(!option.equals("4")) {
                System.out.println("Wrong input. Try again:");
                superUserMenu(indexOfUsers);
            }
            break;
        }
    }


 
    
    
    private static void normalUserMenu(int indexOfUsers) throws IOException {
        String option = null;
        while(validLogins == true) {

            System.out.println("(1) Update username");
            System.out.println("(2) Update password");
            System.out.println("(3) Update name");
            System.out.println("(4) Exit");


            option = scan.nextLine();

            while(option !="4") {
            	if(option.equals("1")) {
                    System.out.println("Updating username");
                    UserService.changeUserEmail(scan);
                    System.out.println("Your username has been changed");
                    normalUserMenu(indexOfUsers);
                }
                else if(option.equals("2")) {
                    System.out.println("Updating password");
                    UserService.changeUserPassword(scan);
                    System.out.println("Your password has been changed");
                    normalUserMenu(indexOfUsers);
                }
                else if(option.equals("3")) {
                    System.out.println("Updating name");
                    UserService.changeUserName(scan);
                    System.out.println("Your name has been changed, "+ UserService.users[indexOfUsers].getName()); 
                    normalUserMenu(indexOfUsers);
                }
                else if(!option.equals("4")) {
                    System.out.println("Wrong input. try again:");
                    normalUserMenu(indexOfUsers);   
                }
            	break;
            }
          break;
    }
    }
}