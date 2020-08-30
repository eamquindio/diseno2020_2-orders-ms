package co.edu.eam.disenosoftware.homeauto.model.entities;

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
   * User's primary key
   */
  @Id
  private String id;

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
   * User's address
   */
  private String address;

  /**
   * User's name
   */
  private String name;

  /**
   * User's constructor
   */
  public User() {
  }

}
