create sequence product_price_id_seq;

create table product_prices (
    id BIGINT PRIMARY KEY DEFAULT nextval('product_price_id_seq'),

    product_id BIGINT NOT NULL,
    FOREIGN KEY (product_id) REFERENCES products(id),

    price_without_tax NUMERIC(10, 2) NOT NULL,
    tax_percentage NUMERIC(5, 2) NOT NULL,
    
    created_by VARCHAR(64) NOT NULL,
    valid_from DATE NOT NULL,
    valid_until DATE,

    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    

    updated_by VARCHAR(64)
);

