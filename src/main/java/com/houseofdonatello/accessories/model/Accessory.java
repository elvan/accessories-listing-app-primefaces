package com.houseofdonatello.accessories.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Model class representing an accessory item based on accessories_tp table
 */
public class Accessory implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code; // accessories_tp_key
    private String name; // accessories_tp_name
    private String categoryId; // accessories_category_tp_id
    private String categoryName; // accessories_category_tp_name
    private String status; // accessories_tp_status
    private String satuan; // accessories_tp_satuan
    private BigDecimal price; // accessories_tp_price_sell
    private BigDecimal discountPercent; // accessories_tp_disc_percent
    private BigDecimal discountIdr; // accessories_tp_disc_idr
    private Date createdDate; // cre_tms
    private String supplierId; // supplier_tp_id
    private String supplierName; // supplier_tp_name
    private String brand; // Brand of the accessory
    private String color; // Color of the accessory

    // Default constructor
    public Accessory() {
    }

    // Constructor with fields
    public Accessory(String code, String name, String categoryId, String categoryName, String status,
                     String satuan, BigDecimal price, BigDecimal discountPercent, BigDecimal discountIdr,
                     Date createdDate, String supplierId, String supplierName, String brand, String color) {
        this.code = code;
        this.name = name;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.status = status;
        this.satuan = satuan;
        this.price = price;
        this.discountPercent = discountPercent;
        this.discountIdr = discountIdr;
        this.createdDate = createdDate;
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.brand = brand;
        this.color = color;
    }

    // Getters and Setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(BigDecimal discountPercent) {
        this.discountPercent = discountPercent;
    }

    public BigDecimal getDiscountIdr() {
        return discountIdr;
    }

    public void setDiscountIdr(BigDecimal discountIdr) {
        this.discountIdr = discountIdr;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
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

        return code != null ? code.equals(that.code) : that.code == null;
    }

    @Override
    public int hashCode() {
        return code != null ? code.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Accessory{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", satuan='" + satuan + '\'' +
                ", price=" + price +
                ", supplierName='" + supplierName + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
