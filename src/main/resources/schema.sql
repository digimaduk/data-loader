CREATE TABLE products (
    product_id NUMBER PRIMARY KEY,
    product_name VARCHAR2(255) NOT NULL,
    description VARCHAR2(1000),
    price NUMBER(10, 2) NOT NULL,
    stock_quantity NUMBER NOT NULL,
    active_flag VARCHAR2(1) NOT NULL DEFAULT 'Y',
    created_by VARCHAR(20) NOT NULL DEFAULT CURRENT_USER,
    created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(20) DEFAULT CURRENT_USER,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE categories (
    category_id NUMBER PRIMARY KEY,
    category_name VARCHAR2(255) NOT NULL,
    active_flag VARCHAR2(1) NOT NULL DEFAULT 'Y',
    created_by VARCHAR(20) NOT NULL DEFAULT CURRENT_USER,
    created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(20) DEFAULT CURRENT_USER,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE product_category (
    product_id NUMBER,
    category_id NUMBER,
    PRIMARY KEY (product_id, category_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id),
    FOREIGN KEY (category_id) REFERENCES categories(category_id),
    active_flag VARCHAR2(1) NOT NULL DEFAULT 'Y',
    created_by VARCHAR(20) NOT NULL DEFAULT CURRENT_USER,
    created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(20) DEFAULT CURRENT_USER,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE customers (
    customer_id NUMBER PRIMARY KEY,
    first_name VARCHAR2(255) NOT NULL,
    last_name VARCHAR2(255) NOT NULL,
    email VARCHAR2(255) NOT NULL,
    phone_number VARCHAR2(20),
    address VARCHAR2(1000),
    active_flag VARCHAR2(1) NOT NULL DEFAULT 'Y',
    created_by VARCHAR(20) NOT NULL DEFAULT CURRENT_USER,
    created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(20) DEFAULT CURRENT_USER,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE orders (
    order_id NUMBER PRIMARY KEY,
    customer_id NUMBER,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR2(50) NOT NULL,
    total_amount NUMBER(10, 2) NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
    active_flag VARCHAR2(1) NOT NULL DEFAULT 'Y',
    created_by VARCHAR(20) NOT NULL DEFAULT CURRENT_USER,
    created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(20) DEFAULT CURRENT_USER,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE order_items (
    order_item_id NUMBER PRIMARY KEY,
    order_id NUMBER,
    product_id NUMBER,
    quantity NUMBER NOT NULL,
    unit_price NUMBER(10, 2) NOT NULL,
    total_price NUMBER(10, 2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id),
    active_flag VARCHAR2(1) NOT NULL DEFAULT 'Y',
    created_by VARCHAR(20) NOT NULL DEFAULT CURRENT_USER,
    created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(20) DEFAULT CURRENT_USER,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE payments (
    payment_id NUMBER PRIMARY KEY,
    order_id NUMBER,
    payment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    payment_amount NUMBER(10, 2) NOT NULL,
    payment_method VARCHAR2(100) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    active_flag VARCHAR2(1) NOT NULL DEFAULT 'Y',
    created_by VARCHAR(20) NOT NULL DEFAULT CURRENT_USER,
    created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(20) DEFAULT CURRENT_USER,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
