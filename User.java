import java.time.LocalDate;

public class User {
private String name,email,phone,password;
private LocalDate dob;
// Constructor
public User(String name,String Email,String phone,String password, LocalDate dob){
this.name=name;
this.email=Email;
this.phone=phone;
this.password=password;
this.dob=dob;
}

public String getName() {
return name;
}
public String getEmail() {
return email;
}
public String getPhone() {
return phone;
}
public String getPassword() {
return password;
}
public LocalDate getDob() {
return dob;
}

public void setName(String name) {
this.name = name;
}
public void setEmail(String email) {
this.email = email;
}
public void setPassword(String password) {
this.password = password;
}
public void setPhone(String phone) {
this.phone = phone;
}
public void setDob(LocalDate dob) {
this.dob = dob;
}
}