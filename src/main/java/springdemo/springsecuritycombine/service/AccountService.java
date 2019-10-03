package springdemo.springsecuritycombine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import springdemo.springsecuritycombine.entity.Account;
import springdemo.springsecuritycombine.repository.AccountRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public String login(String username, String password) {
        Optional<Account> optionalAccount = accountRepository.findByUsernameAndPassword(username, password);
        if (optionalAccount.isPresent()) {
            String token = UUID.randomUUID().toString();
            Account account = optionalAccount.get();
            account.setToken(token);
            accountRepository.save(account);
            return token;
        }
        return "";
    }

    public User findByToken(String token) {
        Optional<Account> optionalAccount = accountRepository.findByToken(token);
        if (optionalAccount.isPresent()) {
            System.out.println("Found account with token: " + optionalAccount.get().getUsername());
            Account acc1 = optionalAccount.get();
            User user = new User(acc1.getUsername(), acc1.getPassword(), true, true, true, true, AuthorityUtils.createAuthorityList("USER"));
            return user;
        }
        return null;
    }

}
