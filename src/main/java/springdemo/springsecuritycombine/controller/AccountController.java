package springdemo.springsecuritycombine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springdemo.springsecuritycombine.entity.Account;
import springdemo.springsecuritycombine.repository.AccountRepository;

@RestController
@RequestMapping(value = "/api")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping(value = "/register")
    public String register() {
        System.out.println("Hello");
        return "Yoyo";
    }

    @GetMapping(value = "/authentication")
    public String authentication() {
        System.out.println("Hallo");
        return "Yaya";
    }

    @GetMapping(value = "/public")
    public String getPublic() {
        System.out.println("Pub");
        return "pupu";
    }

    @GetMapping(value = "/accounts/{id}")
    public Account getAccountDetail(@PathVariable String id) {
        System.out.println("Hello");
        return accountRepository.findById(id).orElse(null);
    }
}
