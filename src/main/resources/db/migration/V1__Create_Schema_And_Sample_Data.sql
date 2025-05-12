-- Create database if it doesn't exist
CREATE DATABASE IF NOT EXISTS accessories_listing_app_primefaces;

USE accessories_listing_app_primefaces;

-- Create accessories_category_tp table
CREATE TABLE IF NOT EXISTS accessories_category_tp (
    accessories_category_tp_id VARCHAR(50) PRIMARY KEY,
    accessories_category_tp_name VARCHAR(100) NOT NULL
);

-- Create supplier_tp table
CREATE TABLE IF NOT EXISTS supplier_tp (
    supplier_tp_id VARCHAR(50) PRIMARY KEY,
    supplier_tp_name VARCHAR(100) NOT NULL,
    supplier_tp_status VARCHAR(50) DEFAULT 'ACTIVE',
    supplier_tp_contact VARCHAR(100),
    cre_tms TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create accessories_tp table (main accessories table)
CREATE TABLE IF NOT EXISTS accessories_tp (
    accessories_tp_key VARCHAR(50) PRIMARY KEY,
    accessories_tp_name VARCHAR(255) NOT NULL,
    accessories_category_tp_id VARCHAR(50),
    accessories_tp_status VARCHAR(50),
    supplier_tp_id VARCHAR(50),
    brand VARCHAR(100),
    color VARCHAR(50),
    accessories_tp_satuan VARCHAR(50),
    accessories_tp_price_sell DECIMAL(10, 2),
    accessories_tp_disc_percent DECIMAL(5, 2),
    accessories_tp_disc_idr DECIMAL(10, 2),
    cre_tms TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (accessories_category_tp_id) REFERENCES accessories_category_tp(accessories_category_tp_id),
    FOREIGN KEY (supplier_tp_id) REFERENCES supplier_tp(supplier_tp_id)
);

-- Insert sample data into accessories_category_tp
INSERT INTO accessories_category_tp (accessories_category_tp_id, accessories_category_tp_name) VALUES
('CAT001', 'KOTAK AKSESORIS'),
('CAT002', 'DESK ORGANIZER'),
('CAT003', 'LAPTOP STAND'),
('CAT004', 'PHONE HOLDER'),
('CAT005', 'CABLE ORGANIZER'),
('CAT006', 'KERTAS');

-- Insert sample supplier data
INSERT INTO supplier_tp (supplier_tp_id, supplier_tp_name, supplier_tp_status, supplier_tp_contact) VALUES
('SUP001', 'Office Supplies Co.', 'ACTIVE', 'contact@officesupplies.com'),
('SUP002', 'Tech Accessories Ltd.', 'ACTIVE', 'sales@techaccessories.com'),
('SUPP_3', 'Premium Stationary Inc.', 'ACTIVE', 'info@premiumstationary.com');

-- Insert sample accessories with all data in one table
INSERT INTO accessories_tp (
    accessories_tp_key, 
    accessories_tp_name, 
    accessories_category_tp_id, 
    accessories_tp_status, 
    supplier_tp_id, 
    brand, 
    color, 
    accessories_tp_satuan, 
    accessories_tp_price_sell, 
    accessories_tp_disc_percent, 
    accessories_tp_disc_idr, 
    cre_tms
) VALUES
('PENAES', 'Premium Pen Set', 'CAT001', 'ACTIVE', 'SUP001', 'Elegance', 'Blue', 'PCS', 75000.00, 6.67, 5000.00, NOW()),
('ORGN001', 'Desk Organizer Pro', 'CAT002', 'ACTIVE', 'SUP001', 'OfficeMate', 'Black', 'UNIT', 125000.00, 12.00, 15000.00, NOW()),
('LPST001', 'Ergonomic Laptop Stand', 'CAT003', 'ACTIVE', 'SUPP_3', 'TechSupport', 'Silver', 'UNIT', 185000.00, 13.51, 25000.00, NOW()),
('PHLD001', 'Adjustable Phone Holder', 'CAT004', 'ACTIVE', 'SUP002', 'MobileTech', 'White', 'PCS', 45000.00, 0.00, 0.00, NOW()),
('CBOR001', 'Cable Management System', 'CAT005', 'ACTIVE', 'SUPP_3', 'WireWorks', 'Gray', 'SET', 55000.00, 9.09, 5000.00, NOW()),
('PENHLD', 'Luxury Pen Holder', 'CAT001', 'ACTIVE', 'SUP001', 'Elegance', 'Brown', 'PCS', 65000.00, 15.38, 10000.00, NOW()),
('ORGN002', 'Mini Desk Tray', 'CAT002', 'ACTIVE', 'SUPP_3', 'OfficeMate', 'Green', 'UNIT', 85000.00, 0.00, 0.00, NOW()),
('LPST002', 'Collapsible Laptop Stand', 'CAT003', 'ACTIVE', 'SUP002', 'TechSupport', 'Black', 'UNIT', 155000.00, 12.90, 20000.00, NOW()),
('PHLD002', 'Desktop Phone Mount', 'CAT004', 'ACTIVE', 'SUPP_3', 'MobileTech', 'Orange', 'PCS', 38000.00, 7.89, 3000.00, NOW()),
('CBOR002', 'Cable Clips Pack', 'CAT005', 'ACTIVE', 'SUP001', 'WireWorks', 'White', 'PACK', 28000.00, 0.00, 0.00, NOW()),
('PENA05', 'Standard Pen Set', 'CAT001', 'ACTIVE', 'SUP002', 'WriteBest', 'Black', 'SET', 45000.00, 5.00, 2250.00, NOW()),
('KERTAS01', 'Premium A4 Paper', 'CAT006', 'ACTIVE', 'SUPP_3', 'PaperPro', 'White', 'RIM', 65000.00, 0.00, 0.00, NOW()),
('KERTAS02', 'Colored Paper Pack', 'CAT006', 'ACTIVE', 'SUP001', 'ColorPlus', 'Multi', 'PACK', 85000.00, 10.00, 8500.00, NOW()),
('KERTAS03', 'Photo Paper Glossy', 'CAT006', 'ACTIVE', 'SUPP_3', 'PhotoMax', 'White', 'PACK', 120000.00, 15.00, 18000.00, NOW());
