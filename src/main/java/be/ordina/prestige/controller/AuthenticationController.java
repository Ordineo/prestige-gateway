package be.ordina.prestige.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by JoLe on 23/01/2017.
 */
@RestController
public class AuthenticationController {

    @RequestMapping("/user")
    public Principal user(Principal principal) {
        return principal;
    }

}
