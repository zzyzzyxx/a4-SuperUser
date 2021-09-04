package a4SuperUser;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class UserService {

    public static User[] users = new User[20];	

    static int indexOfUsers = 0;

    public static void readFile() {
        String[] userData = null;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("users.txt"));
            String line;
          
            while((line = reader.readLine())!= null) {
                userData = line.split(", ");
                users[indexOfUsers] = new User(userData);
                indexOfUsers++;
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            e.printStackTrace();
        } catch  (IOException e) {
            System.out.println("IO Exception");
            e.printStackTrace();
        }
        finally {
            try {
                //System.out.println("Closing the reader");
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

 
    
    public static void changeUserPassword(Scanner scan)throws IOException {
        BufferedWriter writer = null;

        try{
            writer = new BufferedWriter(new FileWriter("users.txt"));

            String data = scan.nextLine();

            for(indexOfUsers =0; indexOfUsers < users.length; indexOfUsers++) {
                if(UserApplication.username == users[indexOfUsers].getName()) {
                    users[indexOfUsers].setPassword(data);
                }
                writer.write(users[indexOfUsers].getEmail()+", ");
                writer.write(users[indexOfUsers].getPassword()+", ");
                writer.write(users[indexOfUsers].getName()+", ");
                writer.write(users[indexOfUsers].getRole()+"\n");
            }
        }
        finally {
            if(writer !=null)
                writer.close();
        }
    }

 
    
    public static void changeUserEmail(Scanner scan)throws IOException {
        BufferedWriter writer = null;

        try{
            writer = new BufferedWriter(new FileWriter("users.txt"));

            String data = scan.nextLine();

            for(indexOfUsers =0; indexOfUsers < users.length; indexOfUsers++) {
                if(UserApplication.username == users[indexOfUsers].getName()) {
                    users[indexOfUsers].setEmail(data);
                }

                users[indexOfUsers].getEmail();
                users[indexOfUsers].getPassword();
                users[indexOfUsers].getName();
                users[indexOfUsers].getRole();
            }
            Arrays.sort(users);
            for(indexOfUsers =0; indexOfUsers < users.length; indexOfUsers++) {

                writer.write(users[indexOfUsers].getEmail()+", ");
                writer.write(users[indexOfUsers].getPassword()+", ");
                writer.write(users[indexOfUsers].getName()+", ");
                writer.write(users[indexOfUsers].getRole()+"\n");
            }
        }
        finally {
            if(writer !=null)
                writer.close();
        }
    }

 
    
    public static void changeUserName(Scanner scan)throws IOException {
        BufferedWriter writer = null;

        try{
            writer = new BufferedWriter(new FileWriter("users.txt"));

            String data = scan.nextLine();

            for(indexOfUsers =0; indexOfUsers < users.length; indexOfUsers++) {
                if(UserApplication.username == users[indexOfUsers].getName()) {
                    users[indexOfUsers].setName(data);
                }
                writer.write(users[indexOfUsers].getEmail()+", ");
                writer.write(users[indexOfUsers].getPassword()+", ");
                writer.write(users[indexOfUsers].getName()+", ");
                writer.write(users[indexOfUsers].getRole()+"\n");
            }
        }
        finally {
            if(writer !=null)
                writer.close();
        }
    }
}
