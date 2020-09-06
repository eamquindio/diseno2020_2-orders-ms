package co.edu.eam.disenosoftware.homeautobackend.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Shopping Cart's Product class
 */
@Entity
@Table(name = "shopping_cart_products")
public class ShoppingCartProduct implements Serializable {

  /**
   * Shopping Cart's Product's - Primary key
   */
  @Id
  private Long id;

  /**
   * Shopping cart of the product shopping cart's - Foreign Key
   */
  @ManyToOne
  @JoinColumn(name = "id_shopping_cart", referencedColumnName = "id")
  private ShoppingCart shoppingCart;

  /**
   * Shopping Cart's Product
   */
  @ManyToOne
  @JoinColumn(name = "id_product_store", referencedColumnName = "id")
  private ProductStore product;

  /**
   * Shopping Cart's Product quantity
   */
  private int quantity;

  /**
   * Shopping Cart's Product constructor
   */
  public ShoppingCartProduct() {
  }
}
