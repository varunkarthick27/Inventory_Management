package product_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import product_service.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
   Optional<Product> findBySku(String sku);
}
