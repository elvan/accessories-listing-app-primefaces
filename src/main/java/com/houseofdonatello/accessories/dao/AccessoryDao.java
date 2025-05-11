package com.houseofdonatello.accessories.dao;

import com.houseofdonatello.accessories.model.Accessory;
import com.houseofdonatello.accessories.util.DatabaseUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object for Accessory entities
 */
public class AccessoryDao {

    /**
     * Retrieves all accessories from the database
     * 
     * @return List of all accessories
     */
    public List<Accessory> getAllAccessories() {
        List<Accessory> accessories = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = DatabaseUtil.getConnection();
            String sql = "SELECT a.accessories_id, a.accessories_name, " +
                         "c.accessories_category_id, c.accessories_category_name, " +
                         "a.accessories_id_accessories_status, " +
                         "p.accessories_id_accessories_id_price_self, " +
                         "d.accessories_id_accessories_id_discount, " +
                         "d.accessories_price_discount_id_disc_pc, " +
                         "a.supplier, a.brand, a.color " +
                         "FROM accessories a " +
                         "LEFT JOIN accessories_category c ON a.accessories_category_id = c.accessories_category_id " +
                         "LEFT JOIN accessories_price p ON a.accessories_id = p.accessories_id " +
                         "LEFT JOIN accessories_discount d ON a.accessories_id = d.accessories_id";
            
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Accessory accessory = mapResultSetToAccessory(rs);
                accessories.add(accessory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }
        
        return accessories;
    }
    
    /**
     * Searches accessories based on filter criteria
     * 
     * @param code Accessory code
     * @param name Accessory name
     * @param category Accessory category
     * @param minPrice Minimum price
     * @param maxPrice Maximum price
     * @param supplier Supplier (KERAS or SUPP_3)
     * @return List of filtered accessories
     */
    public List<Accessory> searchAccessories(String code, String name, String category, 
                                        BigDecimal minPrice, BigDecimal maxPrice, String supplier) {
        List<Accessory> accessories = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = DatabaseUtil.getConnection();
            StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append("SELECT a.accessories_id, a.accessories_name, ");
            sqlBuilder.append("c.accessories_category_id, c.accessories_category_name, ");
            sqlBuilder.append("a.accessories_id_accessories_status, ");
            sqlBuilder.append("p.accessories_id_accessories_id_price_self, ");
            sqlBuilder.append("d.accessories_id_accessories_id_discount, ");
            sqlBuilder.append("d.accessories_price_discount_id_disc_pc, ");
            sqlBuilder.append("a.supplier, a.brand, a.color ");
            sqlBuilder.append("FROM accessories a ");
            sqlBuilder.append("LEFT JOIN accessories_category c ON a.accessories_category_id = c.accessories_category_id ");
            sqlBuilder.append("LEFT JOIN accessories_price p ON a.accessories_id = p.accessories_id ");
            sqlBuilder.append("LEFT JOIN accessories_discount d ON a.accessories_id = d.accessories_id ");
            sqlBuilder.append("WHERE 1=1 ");
            
            List<Object> params = new ArrayList<>();
            
            if (code != null && !code.isEmpty()) {
                sqlBuilder.append("AND a.accessories_id = ? ");
                params.add(code);
            }
            
            if (name != null && !name.isEmpty()) {
                sqlBuilder.append("AND a.accessories_name LIKE ? ");
                params.add("%" + name + "%");
            }
            
            if (category != null && !category.isEmpty()) {
                sqlBuilder.append("AND c.accessories_category_name = ? ");
                params.add(category);
            }
            
            if (minPrice != null) {
                sqlBuilder.append("AND p.accessories_id_accessories_id_price_self >= ? ");
                params.add(minPrice);
            }
            
            if (maxPrice != null) {
                sqlBuilder.append("AND p.accessories_id_accessories_id_price_self <= ? ");
                params.add(maxPrice);
            }
            
            if (supplier != null && !supplier.isEmpty()) {
                sqlBuilder.append("AND a.supplier = ? ");
                params.add(supplier);
            }
            
            stmt = conn.prepareStatement(sqlBuilder.toString());
            
            // Set parameters
            for (int i = 0; i < params.size(); i++) {
                stmt.setObject(i + 1, params.get(i));
            }
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Accessory accessory = mapResultSetToAccessory(rs);
                accessories.add(accessory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }
        
        return accessories;
    }
    
    /**
     * Maps a ResultSet row to an Accessory object
     * 
     * @param rs ResultSet containing accessory data
     * @return Accessory object
     * @throws SQLException if a database access error occurs
     */
    private Accessory mapResultSetToAccessory(ResultSet rs) throws SQLException {
        Accessory accessory = new Accessory();
        
        accessory.setId(rs.getString("accessories_id"));
        accessory.setName(rs.getString("accessories_name"));
        accessory.setCategoryId(rs.getString("accessories_category_id"));
        accessory.setCategoryName(rs.getString("accessories_category_name"));
        accessory.setStatus(rs.getString("accessories_id_accessories_status"));
        
        // Handle numeric fields that might be null
        BigDecimal price = rs.getBigDecimal("accessories_id_accessories_id_price_self");
        if (price != null) {
            accessory.setPrice(price);
        }
        
        BigDecimal discount = rs.getBigDecimal("accessories_id_accessories_id_discount");
        if (discount != null) {
            accessory.setDiscount(discount);
        }
        
        BigDecimal discountPercentage = rs.getBigDecimal("accessories_price_discount_id_disc_pc");
        if (discountPercentage != null) {
            accessory.setDiscountPercentage(discountPercentage);
        }
        
        accessory.setSupplier(rs.getString("supplier"));
        accessory.setBrand(rs.getString("brand"));
        accessory.setColor(rs.getString("color"));
        
        return accessory;
    }
    
    /**
     * Closes database resources
     * 
     * @param conn Database connection
     * @param stmt PreparedStatement
     * @param rs ResultSet
     */
    private void closeResources(Connection conn, PreparedStatement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        DatabaseUtil.closeConnection(conn);
    }
    
    /**
     * Gets a list of all unique accessory categories
     * 
     * @return List of category names
     */
    public List<String> getAllCategories() {
        List<String> categories = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = DatabaseUtil.getConnection();
            String sql = "SELECT DISTINCT accessories_category_name FROM accessories_category ORDER BY accessories_category_name";
            
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                categories.add(rs.getString("accessories_category_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }
        
        return categories;
    }
    
    /**
     * Gets a list of all suppliers
     * 
     * @return List of supplier names
     */
    public List<String> getAllSuppliers() {
        List<String> suppliers = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = DatabaseUtil.getConnection();
            String sql = "SELECT DISTINCT supplier FROM accessories WHERE supplier IS NOT NULL";
            
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                suppliers.add(rs.getString("supplier"));
            }
            
            // If the specific suppliers are not in the database, add them manually as required
            if (!suppliers.contains("KERAS")) {
                suppliers.add("KERAS");
            }
            
            if (!suppliers.contains("SUPP_3")) {
                suppliers.add("SUPP_3");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }
        
        return suppliers;
    }
}
