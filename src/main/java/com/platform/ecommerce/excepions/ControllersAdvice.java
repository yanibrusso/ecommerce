package com.platform.ecommerce.excepions;


import com.platform.ecommerce.dtos.ErrorDao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ControllersAdvice {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDao> runtimeException(NotFoundException ex){
        ErrorDao errorDaoMsj = ErrorDao.builder().code(HttpStatus.NOT_FOUND.value())
                .message(ex.getMessage()).build();
        return new ResponseEntity<>(errorDaoMsj,HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorDao> runtimeException(BadRequestException ex){
        ErrorDao errorDaoMsj = ErrorDao.builder().code(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage()).build();
        return new ResponseEntity<>(errorDaoMsj,HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDao> runtimeException(Exception ex){
        ErrorDao errorDaoMsj = ErrorDao.builder().code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(ex.getMessage()).build();
        return new ResponseEntity<>(errorDaoMsj,HttpStatus.INTERNAL_SERVER_ERROR);

    }



}
