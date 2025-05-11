package com.houseofdonatello.accessories.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Model class representing an accessory item
 */
public class Accessory implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String id; // accessories_id or code_tms
    private String name; // accessories_name
    private String categoryId; // accessories_category_id
    private String categoryName; // accessories_category_name
    private String status; // accessories_id_accessories_status
    private BigDecimal price; // accessories_id_accessories_id_price_self
    private BigDecimal discount; // accessories_id_accessories_id_discount
    private BigDecimal discountPercentage; // accessories_price_discount_id_disc_pc
    private String supplier; // Supplier type (KERAS or SUPP_3)
    private String brand; // Brand of the accessory
    private String color; // Color of the accessory
    
    // Default constructor
    public Accessory() {
    }
    
    // Constructor with fields
    public Accessory(String id, String name, String categoryId, String categoryName, String status, 
                  BigDecimal price, BigDecimal discount, BigDecimal discountPercentage, 
                  String supplier, String brand, String color) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.status = status;
        this.price = price;
        this.discount = discount;
        this.discountPercentage = discountPercentage;
        this.supplier = supplier;
        this.brand = brand;
        this.color = color;
    }
    
    // Getters and Setters
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getCategoryId() {
        return categoryId;
    }
    
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
    
    public String getCategoryName() {
        return categoryName;
    }
    
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public BigDecimal getPrice() {
        return price;
    }
    
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    public BigDecimal getDiscount() {
        return discount;
    }
    
    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
    
    public BigDecimal getDiscountPercentage() {
        return discountPercentage;
    }
    
    public void setDiscountPercentage(BigDecimal discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
    
    public String getSupplier() {
        return supplier;
    }
    
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
    
    public String getBrand() {
        return brand;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Accessory that = (Accessory) o;
        
        return id != null ? id.equals(that.id) : that.id == null;
    }
    
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
    
    @Override
    public String toString() {
        return "Accessory{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", price=" + price +
                '}';
    }
}
