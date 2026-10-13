package product_service.service;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import product_service.dto.CreateProductRequest;
import product_service.entity.Product;
import product_service.exception.ProductAlreadyExistsException;
import product_service.exception.ProductNotFoundException;
import product_service.repository.ProductRepository;
@Service 
public class ProductService   {


    private final ProductRepository productRepository;
     public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Product DeleteProduct(Long id) {
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new ProductNotFoundException("Product with ID " + id + " not found."));
            productRepository.delete(product);
        return product;
    }
    
    public List<Product> getAllProducts(){
        System.out.println("GET ALL PRODUCTS service CALLED");
        return productRepository.findAll().stream().collect(Collectors.toList());
    }
    public Product getProduct(Long id) {
       return productRepository.findById(id)
       .orElseThrow(() -> new ProductNotFoundException("Product with ID " + id + " not found."));
    }
    public Product createProduct(CreateProductRequest request) {
    // your logic here
     
   
    if (productRepository.findBySku(request.getSku()).isPresent()) {
        throw new ProductAlreadyExistsException("Product with SKU " + request.getSku() + " already exists.");
    }
    if(request.getValidUntil() != null) {
        if(request.getValidUntil().isBefore(request.getValidFrom())) {
            throw new IllegalArgumentException("validUntil date must be after validFrom date or equal to validFrom date.");
        }
    }


     Product product = new Product(
        request.getSku(),
        request.getName(),
        request.getDescription(),
        request.getCategory(),
        request.getValidFrom(),
        request.getValidUntil()
    );

    
    return productRepository.save(product);
    
    
}
}
