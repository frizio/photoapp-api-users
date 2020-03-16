package cloud.frizio.ms.photoapp.photoappapiusers.ui.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

  @NotNull(message = "First name cannot be null")
  @Size(min = 2, message = "First name length > 2")
  private String firstName;
  
  @NotNull(message = "Last name cannot be null")
  @Size(min = 2, message = "Last name length > 2")
  private String lastName;
  
  @NotNull(message = "Email cannot be null")
  @Email
  private String email;

  @NotNull(message = "First name cannot be null")
  @Size(min = 8, max = 12, message = "Password length > 8 and < 12")
  private String password;


  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
