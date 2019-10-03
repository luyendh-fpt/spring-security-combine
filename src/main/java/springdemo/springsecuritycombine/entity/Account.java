package springdemo.springsecuritycombine.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {

    @Id
    private String username;
    private String password;
    private String token;
    private long tokenExpiredAt;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getTokenExpiredAt() {
        return tokenExpiredAt;
    }

    public void setTokenExpiredAt(long tokenExpiredAt) {
        this.tokenExpiredAt = tokenExpiredAt;
    }
}
