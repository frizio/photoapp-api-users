package cloud.frizio.ms.photoapp.photoappapiusers.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@Entity
@Table(name = "users")
public class UserEntity implements Serializable {

  private static final long serialVersionUID = 3222811280067520826L;

  @Id
  @GeneratedValue
  private long id;

  @Column(nullable = false, length = 50)
  private String firstName;

  @Column(nullable = false, length = 50)
  private String lastName;
  
  @Column(nullable = false, length = 120, unique = true)
  private String email;

  @Column(nullable = false,  unique = true)
  private String userId;

  @Column(nullable = false, unique = true)
  private String encryptedPassword;

  
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

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

  public String getUserId() {
    return this.userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getEncryptedPassword() {
    return this.encryptedPassword;
  }

  public void setEncryptedPassword(String encryptedPassword) {
    this.encryptedPassword = encryptedPassword;
  }
  
}