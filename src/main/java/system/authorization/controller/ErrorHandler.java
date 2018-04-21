package system.authorization.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import system.authorization.exception.UsernameIsExistingException;
import system.authorization.model.WrapperErrorResponse;
import org.springframework.web.bind.annotation.*;

/**
 * Created by KAI on 4/21/18.
 */
@ControllerAdvice
public class ErrorHandler {


    @ExceptionHandler(UsernameIsExistingException.class)
    public ResponseEntity handlingUsernameIsExistingException(UsernameIsExistingException e){
        WrapperErrorResponse wrapperErrorResponse = new WrapperErrorResponse("Username is existing.", "User is existing.");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(wrapperErrorResponse);
    }

}
