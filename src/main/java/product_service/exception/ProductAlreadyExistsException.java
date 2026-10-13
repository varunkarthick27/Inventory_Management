package product_service.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;


public class ProductAlreadyExistsException extends RuntimeException {
    

    public ProductAlreadyExistsException(String message) {
        super(message);
    }

}
