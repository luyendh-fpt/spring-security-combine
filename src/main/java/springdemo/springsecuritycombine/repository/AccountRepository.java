package springdemo.springsecuritycombine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springdemo.springsecuritycombine.entity.Account;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, String> {

    Optional<Account> findByUsernameAndPassword(String username, String password);

    Optional<Account> findByToken(String token);
}
