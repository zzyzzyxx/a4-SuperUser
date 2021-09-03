package a4SuperUser;

public class NormalUser extends User {


    public NormalUser(String[] userData) {
        super(userData);
        this.setRole("normal_user") ;
    }


}
