INSERT INTO products (product_id, product_name, description, price, stock_quantity)
VALUES (1, 'Laptop', 'High-performance laptop with SSD', 1200.00, 50);

INSERT INTO products (product_id, product_name, description, price, stock_quantity)
VALUES (2, 'Smartphone', 'Latest smartphone model', 800.00, 100);

INSERT INTO categories (category_id, category_name)
VALUES (1, 'Electronics');

INSERT INTO categories (category_id, category_name)
VALUES (2, 'Mobile Devices');

INSERT INTO product_category (product_id, category_id)
VALUES (1, 1); -- Laptop belongs to Electronics

INSERT INTO product_category (product_id, category_id)
VALUES (2, 1); -- Smartphone belongs to Electronics

INSERT INTO customers (customer_id, first_name, last_name, email, phone_number, address)
VALUES (1, 'John', 'Doe', 'john.doe@example.com', '123-456-7890', '123 Main St');

INSERT INTO customers (customer_id, first_name, last_name, email, phone_number, address)
VALUES (2, 'Jane', 'Smith', 'jane.smith@example.com', '987-654-3210', '456 Oak Ave');

INSERT INTO orders (order_id, customer_id, status, total_amount)
VALUES (1, 1, 'Shipped', 1200.00);

INSERT INTO orders (order_id, customer_id, status, total_amount)
VALUES (2, 2, 'Processing', 800.00);

INSERT INTO order_items (order_item_id, order_id, product_id, quantity, unit_price, total_price)
VALUES (1, 1, 1, 1, 1200.00, 1200.00); -- Laptop in the first order

INSERT INTO order_items (order_item_id, order_id, product_id, quantity, unit_price, total_price)
VALUES (2, 2, 2, 2, 800.00, 1600.00); -- Two smartphones in the second order

INSERT INTO payments (payment_id, order_id, payment_amount, payment_method)
VALUES (1, 1, 1200.00, 'Credit Card');

INSERT INTO payments (payment_id, order_id, payment_amount, payment_method)
VALUES (2, 2, 800.00, 'PayPal');






