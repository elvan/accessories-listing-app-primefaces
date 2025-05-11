-- Create database if it doesn't exist
CREATE DATABASE IF NOT EXISTS accessories_listing_app_primefaces;

USE accessories_listing_app_primefaces;

-- Create accessories_category table
CREATE TABLE IF NOT EXISTS accessories_category (
    accessories_category_id VARCHAR(50) PRIMARY KEY,
    accessories_category_name VARCHAR(100) NOT NULL
);

-- Create accessories table
CREATE TABLE IF NOT EXISTS accessories (
    accessories_id VARCHAR(50) PRIMARY KEY,
    accessories_name VARCHAR(255) NOT NULL,
    accessories_category_id VARCHAR(50),
    accessories_id_accessories_status VARCHAR(50),
    supplier VARCHAR(50),
    brand VARCHAR(100),
    color VARCHAR(50),
    FOREIGN KEY (accessories_category_id) REFERENCES accessories_category(accessories_category_id)
);

-- Create accessories_price table
CREATE TABLE IF NOT EXISTS accessories_price (
    accessories_id VARCHAR(50),
    accessories_id_accessories_id_price_self DECIMAL(10, 2),
    PRIMARY KEY (accessories_id),
    FOREIGN KEY (accessories_id) REFERENCES accessories(accessories_id)
);

-- Create accessories_discount table
CREATE TABLE IF NOT EXISTS accessories_discount (
    accessories_id VARCHAR(50),
    accessories_id_accessories_id_discount DECIMAL(10, 2),
    accessories_price_discount_id_disc_pc DECIMAL(5, 2),
    PRIMARY KEY (accessories_id),
    FOREIGN KEY (accessories_id) REFERENCES accessories(accessories_id)
);

-- Insert sample data into accessories_category
INSERT INTO accessories_category (accessories_category_id, accessories_category_name) VALUES
('CAT001', 'KOTAK AKSESORIS'),
('CAT002', 'DESK ORGANIZER'),
('CAT003', 'LAPTOP STAND'),
('CAT004', 'PHONE HOLDER'),
('CAT005', 'CABLE ORGANIZER');

-- Insert sample accessories
INSERT INTO accessories (accessories_id, accessories_name, accessories_category_id, accessories_id_accessories_status, supplier, brand, color) VALUES
('PENAES', 'Premium Pen Set', 'CAT001', 'ACTIVE', 'KERAS', 'Elegance', 'Blue'),
('ORGN001', 'Desk Organizer Pro', 'CAT002', 'ACTIVE', 'KERAS', 'OfficeMate', 'Black'),
('LPST001', 'Ergonomic Laptop Stand', 'CAT003', 'ACTIVE', 'SUPP_3', 'TechSupport', 'Silver'),
('PHLD001', 'Adjustable Phone Holder', 'CAT004', 'ACTIVE', 'KERAS', 'MobileTech', 'White'),
('CBOR001', 'Cable Management System', 'CAT005', 'ACTIVE', 'SUPP_3', 'WireWorks', 'Gray'),
('PENHLD', 'Luxury Pen Holder', 'CAT001', 'ACTIVE', 'KERAS', 'Elegance', 'Brown'),
('ORGN002', 'Mini Desk Tray', 'CAT002', 'ACTIVE', 'SUPP_3', 'OfficeMate', 'Green'),
('LPST002', 'Collapsible Laptop Stand', 'CAT003', 'ACTIVE', 'KERAS', 'TechSupport', 'Black'),
('PHLD002', 'Desktop Phone Mount', 'CAT004', 'ACTIVE', 'SUPP_3', 'MobileTech', 'Orange'),
('CBOR002', 'Cable Clips Pack', 'CAT005', 'ACTIVE', 'KERAS', 'WireWorks', 'White');

-- Insert pricing data
INSERT INTO accessories_price (accessories_id, accessories_id_accessories_id_price_self) VALUES
('PENAES', 75000.00),
('ORGN001', 125000.00),
('LPST001', 185000.00),
('PHLD001', 45000.00),
('CBOR001', 55000.00),
('PENHLD', 65000.00),
('ORGN002', 85000.00),
('LPST002', 155000.00),
('PHLD002', 38000.00),
('CBOR002', 28000.00);

-- Insert discount data
INSERT INTO accessories_discount (accessories_id, accessories_id_accessories_id_discount, accessories_price_discount_id_disc_pc) VALUES
('PENAES', 5000.00, 6.67),
('ORGN001', 15000.00, 12.00),
('LPST001', 25000.00, 13.51),
('PHLD001', 0.00, 0.00),
('CBOR001', 5000.00, 9.09),
('PENHLD', 10000.00, 15.38),
('ORGN002', 0.00, 0.00),
('LPST002', 20000.00, 12.90),
('PHLD002', 3000.00, 7.89),
('CBOR002', 0.00, 0.00);
