Create sequence product_id_seq;

CREATE TABLE products (
    id BIGINT PRIMARY KEY DEFAULT nextval('product_id_seq'),

    sku VARCHAR(25) NOT NULL,
    name VARCHAR(108) NOT NULL,
    description TEXT,
    category VARCHAR(16) NOT NULL,

    valid_from DATE NOT NULL,
    valid_until DATE,

    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,

    updated_by VARCHAR(64)
);

Create or REPLACE FUNCTION update_product_updated_at()
returns TRIGGER 
language plpgsql
as $$
BEGIN
    NEW.updated_at = CURRENT_TIMESTAMP;
    RETURN NEW;
END;
$$;

create TRIGGER update_product_updated_at_trigger
    BEFORE UPDATE ON products
    FOR EACH ROW
    EXECUTE FUNCTION update_product_updated_at();
    