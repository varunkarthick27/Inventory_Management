package product_service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import product_service.dto.CreateProductRequest;
import product_service.entity.Product;
import product_service.repository.ProductRepository;
import product_service.service.ProductService;

@RestController 
@RequestMapping ("/products")
public class ProductController {
    private final ProductService productService;
   
    public ProductController(ProductService productService) {
        this.productService = productService;
        System.out.println("ProductController created");
    }
    @PostMapping
    public Product createProduct(@RequestBody @Valid  CreateProductRequest request) {
        return productService.createProduct(request);
    }
    @GetMapping("/{id}")
    public Product getProduct( @PathVariable Long id){
        System.out.println("GET PRODUCT CALLED");
        return productService.getProduct(id);
    }
    @GetMapping ("/getAllProducts")
    public List<Product> getAllProducts(){
        System.out.println("GET ALL PRODUCTS CALLED");
        return productService.getAllProducts();
    }

    @DeleteMapping ("/{id}")
    public Product deleteProduct(@PathVariable Long id) {
        return productService.DeleteProduct(id);
    }
}
