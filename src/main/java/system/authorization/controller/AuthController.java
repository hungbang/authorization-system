package system.authorization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import system.authorization.domain.User;
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
    public ResponseEntity createUser(@RequestBody @Valid RegistrationRequest registrationRequest){
        User user = userService.registerUser(registrationRequest);
        return ResponseEntity.ok(user.getId());
    }

}
