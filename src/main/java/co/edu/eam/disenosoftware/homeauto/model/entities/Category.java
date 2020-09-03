package co.edu.eam.disenosoftware.homeauto.model.entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Clase categoria
 */
@Entity
@Table(name = "category")
public class Category implements Serializable {

  /**
   * Icono de Categoria
   */

  private String icon;

  /**
   * Categoria de Tienda
   */
  private String storeld;

  /**
   * Nombre Categoria
   */
  private String name;

  /**
   * Id categoria
   */
  @Id
  private Long id;

  /**
   * Constructor Categoria
   */
  public Category() {
  }
}
