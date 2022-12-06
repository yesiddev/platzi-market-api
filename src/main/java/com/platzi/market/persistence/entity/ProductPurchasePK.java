package com.platzi.market.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ProductPurchasePK {

  @Column(name = "id_compra")
  private Integer idPurchase;

  @Column(name = "id_producto")
  private Integer idProduct;

  public Integer getIdPurchase() {
    return idPurchase;
  }

  public void setIdPurchase(Integer idPurchase) {
    this.idPurchase = idPurchase;
  }

  public Integer getIdProduct() {
    return idProduct;
  }

  public void setIdProduct(Integer idProduct) {
    this.idProduct = idProduct;
  }

}
