-- Create products table
CREATE TABLE products (
                          id UUID PRIMARY KEY,
                          created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
                          name VARCHAR(200) NOT NULL,
                          sku_code VARCHAR(120) NOT NULL,
                          barcode VARCHAR(150) NOT NULL,
                          CONSTRAINT UC_PRODUCT__SKU_CODE UNIQUE (sku_code),
                          CONSTRAINT UC_PRODUCT__BARCODE UNIQUE (barcode)
);

-- Create storage_location table
CREATE TABLE storage_location (
                                  id UUID PRIMARY KEY,
                                  created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
                                  code VARCHAR(200) NOT NULL,
                                  description VARCHAR(200),
                                  is_available BOOLEAN DEFAULT TRUE,
                                  user_id UUID,
                                  CONSTRAINT UC_STORAGE_LOCATION__CODE UNIQUE (code),
                                  CONSTRAINT FK_STORAGE_LOCATION__USER_ID FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Create products_stock table
CREATE TABLE products_stock (
                                id UUID PRIMARY KEY,
                                created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
                                batch_number VARCHAR(200) NOT NULL,
                                shipment_code VARCHAR(200) NOT NULL,
                                manufacture_date DATE,
                                expiration_date DATE,
                                quantity BIGINT,
                                product_id UUID,
                                user_added_id UUID,
                                storage_location_id UUID,
                                CONSTRAINT FK_PRODUCT_STOCK__PRODUCT_ID FOREIGN KEY (product_id) REFERENCES products(id),
                                CONSTRAINT FK_PRODUCT_STOCK__USER_ID FOREIGN KEY (user_added_id) REFERENCES users(id),
                                CONSTRAINT FK_PRODUCT_STOCK__STORAGE_LOCATION_ID FOREIGN KEY (storage_location_id) REFERENCES storage_location(id)
);
