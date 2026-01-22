package com.project.hospitalManagement.advices;

import com.project.hospitalManagement.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobaLExceptionHeader {

    // Exception Handler
//    @ExceptionHandler(NoSuchElementException.class)
//    public ResponseEntity<String> handleResourceNotFoundException(NoSuchElementException exception){
//        return new ResponseEntity<>("Resource Not found " , HttpStatus.NOT_FOUND);
//    }

//    @ExceptionHandler(NoSuchElementException.class)
//    public ResponseEntity<ApiError> resourceNotFoundException(NoSuchElementException ex) {
//        ApiError apiError = ApiError.builder().status(HttpStatus.NOT_FOUND).message("Resource not found").build();
//        return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
//    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundException(ResourceNotFoundException exception){
        ApiError apiError = ApiError
                .builder()
                .status(HttpStatus.NOT_FOUND)
                .message(exception.getMessage()).build();
        return buildErrorResponseEntity(apiError);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> internalServerErrror(Exception ex){
        ApiError apiError = ApiError
                .builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .message(ex.getMessage())
                .build();
        return  buildErrorResponseEntity(apiError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleInputValidErrors(MethodArgumentNotValidException ex){
      List<String> errors =   ex.getBindingResult()
              .getAllErrors()
              .stream()
              .map(objectError -> objectError.getDefaultMessage())
              .collect(Collectors.toList());

        ApiError apiError = ApiError
                .builder()
                .status(HttpStatus.BAD_REQUEST)
                .message("Input InValid")
                .subErrors(errors)
                .build();
        return buildErrorResponseEntity(apiError);
    }

    private ResponseEntity<ApiResponse> buildErrorResponseEntity(ApiError apiError){
        return new ResponseEntity<>(new ApiResponse<> (apiError), apiError.getStatus());
    }
}
