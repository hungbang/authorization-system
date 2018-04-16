package system.authorization.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by KAI on 4/16/18.
 */
@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/test")
    public ResponseEntity home(){
        return ResponseEntity.ok("Welcome to my system");
    }

}
