package com.week.test.website.model;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name ="product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column(name ="product_name")
    private String productName;

    @Column(name ="product_stock")
    private Integer productStock;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }
}
