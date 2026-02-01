package com.suhail.learn_spring.Ai.advices;

import com.suhail.learn_spring.Ai.Eceptions.InvaildInputException;
import com.suhail.learn_spring.Ai.Eceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NoSuchElementException.class)

    public ResponseEntity<ApiResponse<?>> handleUserNotFound(NoSuchElementException e){
        ApiError apiError=new ApiError(e.getMessage(), HttpStatus.NOT_FOUND);
//        apiError.setStatus(HttpStatus.NOT_FOUND);
//        apiError.
//        return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
        return buildErrorResponseEntity(apiError);
    }

    private ResponseEntity<ApiResponse<?>> buildErrorResponseEntity(ApiError apiError) {
  return new ResponseEntity<>(new ApiResponse(apiError),apiError.getStatus());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> userNotFoundException(UserNotFoundException exception){
//        ApiError apiError=ApiError.builder()
//                .status(HttpStatus.NOT_FOUND)
//                .message(exception.getMessage())
//                .build();
        ApiError apiError=new ApiError("user with this id is not present", HttpStatus.NOT_FOUND);
//        return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(new ApiResponse(apiError),apiError.getStatus());
    }
    @ExceptionHandler(InvaildInputException.class)
    public ResponseEntity<ApiResponse<?>> handleInputMismatch(InvaildInputException exception){
        ApiError apiError=new ApiError("feild mismatch",HttpStatus.BAD_REQUEST);
//        return new ResponseEntity<>(apiError,HttpStatus.BAD_REQUEST);

return  new ResponseEntity<>(new ApiResponse(apiError),apiError.getStatus());

    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Map<String,String>>handleValidationErrors(MethodArgumentNotValidException ex){
//        Map<String,String> errors=new HashMap<>();
//        ex.getBindingResult()
//                .getFieldErrors()
//                .forEach(error->errors.put(error.getField(),error.getDefaultMessage()));
//return  ResponseEntity.badRequest().body(errors);
//    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>>handleInputErrors(MethodArgumentNotValidException exception){
List<String >errors=exception.getBindingResult().getAllErrors().stream().map(error->error.getDefaultMessage()).collect(Collectors.toList());
ApiError apiError=new ApiError(errors.toString(),HttpStatus.BAD_REQUEST);
//ret
// urn new ResponseEntity<>(apiError,HttpStatus.BAD_REQUEST);
   return new ResponseEntity<>(new ApiResponse<>(apiError),apiError.getStatus());
    }
}
