package product_service.exception;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler (ProductAlreadyExistsException.class)
    public ResponseEntity<String> handleProductAlreadyExistsException(ProductAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    public GlobalExceptionHandler() {
    System.out.println("GLOBAL EXCEPTION HANDLER CREATED");
}
    @ExceptionHandler (IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {

        System.out.println("ILLEGAL ARGUMENT HANDLER CALLED");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler (MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
       Map<String,String> errors= fieldErrors.stream().collect(Collectors.toMap(
        fieldError -> fieldError.getField(),
        fieldError -> fieldError.getDefaultMessage()));
       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler (ProductNotFoundException.class)
        public ResponseEntity<String> handleProductNotFoundException( ProductNotFoundException ex){
            return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(ex.getMessage());
        }
}


