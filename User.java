package a4SuperUser;

//POJO
public class User implements Comparable<User> {

  private String email;
  private String password;
  private String name;
  private String role;


  //constructor
  public User (String[] userData) {
      this.email = userData[0];
      this.password = userData[1];
      this.name = userData[2];
      this.role = userData[3];
  }
  
  //getters and setters
  public String getEmail() {
      return email;
  }
  public  void setEmail(String email) {
      this.email = email;
  }

  public  String getPassword() {
      return password;
  }
  public  void setPassword(String password) {
      this.password = password;
  }

  public  String getName() {
      return name;
  }
  public  void setName(String name) {
      this.name = name;
  }

  public String getRole() {
      return role;
  }

  public void setRole(String role) {
      this.role = role;
  }

  String getInfo() {
      return "Email: " + email+", Password: "+ password+", Name: "+name+", role: "+role;
  }


//compareTo method is responsible for sorting the stored users data
  // - superuser before normal user
  // - alphabetically

  @Override
  public int compareTo(User that) {
      if(that.getRole().compareTo(this.getRole()) ==0) {
          return this.getEmail().compareToIgnoreCase(that.getEmail());
      }
      else {
          return that.getRole().compareTo(this.getRole());
      }

  }

}