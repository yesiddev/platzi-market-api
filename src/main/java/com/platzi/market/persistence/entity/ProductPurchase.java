package com.platzi.market.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "compras_productos")
public class ProductPurchase {

  @EmbeddedId
  private ProductPurchasePK id;

  @Column(name = "cantidad")
  private Integer quantity;

  private Double total;

  @Column(name = "estado")
  private Boolean state;

  @ManyToOne
  @JoinColumn(name = "id_compra", insertable = false, updatable = false)
  private Purchase purchase;

  @ManyToOne
  @JoinColumn(name = "id_producto", insertable = false, updatable = false)
  private Product product;


  public ProductPurchasePK getId() {
    return id;
  }

  public void setId(ProductPurchasePK id) {
    this.id = id;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Double getTotal() {
    return total;
  }

  public void setTotal(Double total) {
    this.total = total;
  }

  public Boolean getState() {
    return state;
  }

  public void setState(Boolean state) {
    this.state = state;
  }

}
