package de.pascalkuehnold.aopdemo.dao;


import de.pascalkuehnold.aopdemo.model.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
    public void addAccount(Account account) {
        System.out.println(getClass() + ": doing DB Work: Adding an Account");
    }
}
