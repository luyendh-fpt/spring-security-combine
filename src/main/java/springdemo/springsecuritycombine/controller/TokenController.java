package springdemo.springsecuritycombine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springdemo.springsecuritycombine.service.AccountService;

@RestController
public class TokenController {

    @Autowired
    private AccountService accountService;

    @PostMapping(value = "/token")
    public String getToken(@RequestParam("username") final String username, @RequestParam("password") final String password) {
        String token = accountService.login(username, password);
        if (token.isEmpty() || token.length() == 0) {
            return "no token found";
        }
        return token;
    }
}
