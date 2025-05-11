package com.houseofdonatello.accessories.bean;

import com.houseofdonatello.accessories.dao.AccessoryDao;
import com.houseofdonatello.accessories.model.Accessory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Managed Bean for accessory listing and filtering
 */
@Named("accessoryBean")
@SessionScoped
public class AccessoryBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private List<Accessory> accessories;
    private List<Accessory> filteredAccessories;
    private List<String> categories;
    private List<String> suppliers;
    
    // Filter fields
    private String codeFilter;
    private String nameFilter;
    private String categoryFilter;
    private BigDecimal minPriceFilter;
    private BigDecimal maxPriceFilter;
    private String supplierFilter;
    
    private AccessoryDao accessoryDao;
    
    @PostConstruct
    public void init() {
        accessoryDao = new AccessoryDao();
        loadAccessories();
        loadCategories();
        loadSuppliers();
    }
    
    /**
     * Load all accessories from database
     */
    public void loadAccessories() {
        accessories = accessoryDao.getAllAccessories();
        filteredAccessories = accessories;
    }
    
    /**
     * Load all categories for filter dropdown
     */
    private void loadCategories() {
        categories = accessoryDao.getAllCategories();
    }
    
    /**
     * Load all suppliers for filter dropdown
     */
    private void loadSuppliers() {
        suppliers = accessoryDao.getAllSuppliers();
    }
    
    /**
     * Apply filters to accessory data
     */
    public void applyFilters() {
        filteredAccessories = accessoryDao.searchAccessories(
                codeFilter, 
                nameFilter, 
                categoryFilter, 
                minPriceFilter, 
                maxPriceFilter, 
                supplierFilter
        );
    }
    
    /**
     * Reset all filters
     */
    public void resetFilters() {
        codeFilter = null;
        nameFilter = null;
        categoryFilter = null;
        minPriceFilter = null;
        maxPriceFilter = null;
        supplierFilter = null;
        
        loadAccessories();
    }
    
    // Getters and Setters
    
    public List<Accessory> getAccessories() {
        return accessories;
    }
    
    public void setAccessories(List<Accessory> accessories) {
        this.accessories = accessories;
    }
    
    public List<Accessory> getFilteredAccessories() {
        return filteredAccessories;
    }
    
    public void setFilteredAccessories(List<Accessory> filteredAccessories) {
        this.filteredAccessories = filteredAccessories;
    }
    
    public List<String> getCategories() {
        return categories;
    }
    
    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
    
    public List<String> getSuppliers() {
        return suppliers;
    }
    
    public void setSuppliers(List<String> suppliers) {
        this.suppliers = suppliers;
    }
    
    public String getCodeFilter() {
        return codeFilter;
    }
    
    public void setCodeFilter(String codeFilter) {
        this.codeFilter = codeFilter;
    }
    
    public String getNameFilter() {
        return nameFilter;
    }
    
    public void setNameFilter(String nameFilter) {
        this.nameFilter = nameFilter;
    }
    
    public String getCategoryFilter() {
        return categoryFilter;
    }
    
    public void setCategoryFilter(String categoryFilter) {
        this.categoryFilter = categoryFilter;
    }
    
    public BigDecimal getMinPriceFilter() {
        return minPriceFilter;
    }
    
    public void setMinPriceFilter(BigDecimal minPriceFilter) {
        this.minPriceFilter = minPriceFilter;
    }
    
    public BigDecimal getMaxPriceFilter() {
        return maxPriceFilter;
    }
    
    public void setMaxPriceFilter(BigDecimal maxPriceFilter) {
        this.maxPriceFilter = maxPriceFilter;
    }
    
    public String getSupplierFilter() {
        return supplierFilter;
    }
    
    public void setSupplierFilter(String supplierFilter) {
        this.supplierFilter = supplierFilter;
    }
}
