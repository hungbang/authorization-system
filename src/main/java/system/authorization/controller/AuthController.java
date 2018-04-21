package system.authorization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import system.authorization.domain.User;
import system.authorization.exception.UsernameIsExistingException;
import system.authorization.model.WrapperUserResponse;
import system.authorization.request.RegistrationRequest;
import system.authorization.service.UserService;

import javax.validation.Valid;

/**
 * Created by KAI on 4/16/18.
 */
@RestController
@RequestMapping("/api/public")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity createUser(@RequestBody @Valid RegistrationRequest registrationRequest) throws UsernameIsExistingException {
        User user = userService.registerUser(registrationRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(new WrapperUserResponse(user));
    }

}
