package de.pascalkuehnold.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
    public void addMembershipAccount(){
        System.out.println(getClass() + ": doing Membership work: Adding a membership account");
    }
}
