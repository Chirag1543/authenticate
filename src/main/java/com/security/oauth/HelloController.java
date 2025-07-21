package com.security.oauth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;
@RestController
public class HelloController {
    @GetMapping("/")
    public String home(Principal principal)
    {
        return "Welcome ," + principal.getname();

    }
}


