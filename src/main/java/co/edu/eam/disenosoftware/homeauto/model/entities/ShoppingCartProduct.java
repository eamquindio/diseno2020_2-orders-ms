package co.edu.eam.disenosoftware.homeauto.model.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Class Shopping Card Product
 */
@Entity
@Table(name = "shopping_cart_product")
public class ShoppingCartProduct implements Serializable {

  /**
   * ID product Store
   */
  @ManyToOne
  @JoinColumn(name = "id_product_store", referencedColumnName = "id")
  private ProductStore product;

  /**
   * quantity Shopping Cart Product
   */
  private int quantity;

  /**
   * Constructor Shopping Cart Product
   */
  public ShoppingCartProduct() {
  }
}
