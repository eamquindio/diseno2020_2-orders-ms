package co.edu.eam.disenosoftware.mitienda.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * User's class
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

  /**
   * User's - Primary key
   */
  @Id
  private Long id;

  /**
   * User's username
   */
  private String username;

  /**
   * User's phone
   */
  private String phone;

  /**
   * User's email
   */
  private String email;

  /**
   * User's password
   */
  private String password;

  /**
   * User's name
   */
  private String name;

  /**
   * User's constructor
   */
  public User() {
  }

  /**
   * User's constructor
   *
   * @param id primary key
   */
  public User(Long id) {
    this.id = id;
  }

  /**
   * User's constructor
   *
   * @param id       primary key
   * @param username username to user
   */
  public User(Long id, String username) {
    this.id = id;
    this.username = username;
  }


  /**
   * get id
   *
   * @return id
   */
  public Long getId() {
    return id;
  }

  /**
   * set id
   *
   * @param id primary key
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * get Username
   *
   * @return username
   */
  public String getUsername() {
    return username;
  }

  /**
   * set Username
   *
   * @param username username to setUsername
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * Get phone
   *
   * @return phone
   */
  public String getPhone() {
    return phone;
  }

  /**
   * Set phone
   *
   * @param phone phone to setPhone
   */
  public void setPhone(String phone) {
    this.phone = phone;
  }

  /**
   * Get email
   *
   * @return email
   */
  public String getEmail() {
    return email;
  }

  /**
   * Set email
   *
   * @param email email to setEmail
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Get password
   *
   * @return pasword
   */
  public String getPassword() {
    return password;
  }

  /**
   * Set password
   *
   * @param password password to setPassword
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Get name
   *
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * Set name
   *
   * @param name name to setName
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Override
   *
   * @return user
   */
  @Override
  public String toString() {
    return "User{"
            + "id=" + id
            + ", username='" + username + '\''
            + '}';
  }
}