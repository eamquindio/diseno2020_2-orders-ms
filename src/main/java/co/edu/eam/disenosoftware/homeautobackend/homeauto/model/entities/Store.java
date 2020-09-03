package co.edu.eam.disenosoftware.homeautobackend.homeauto.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Stores")
public class Store {

  /**
   * Primary Key
   */
  @Id
  private Long id;

  /**
   * Store name
   */
  private String name;

  /**
   * Store owner
   */
  private String owner;

  /**
   * Store address
   */
  private String address;

  /**
   * Store img
   */
  private String img;

  /**
   * Store delivery
   */
  private boolean delivery;

  /**
   * Store isOpen
   */
  private boolean is_open;

  /**
   * Store phone
   */
  private String phone;

  /**
   * Store email
   */
  private String email;

  /**
   * Store password
   */
  private String password;

  /**
   * Constructor
   */
  public Store() {
  }
}
