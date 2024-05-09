package dev.harsha.productsevice.advice;

import dev.harsha.productsevice.productdto.ErrorDTO;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorDTO> handleNullPointerException() {
        ErrorDTO errorDto = new ErrorDTO();
        errorDto.setMessage("Something went wrong. Please try again");

        return new ResponseEntity<>(errorDto,
                HttpStatusCode.valueOf(404));

        // reflections in java
    }
}
