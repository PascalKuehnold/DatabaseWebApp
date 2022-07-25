package de.pascalkuehnold.aopdemo;

import de.pascalkuehnold.aopdemo.config.DemoConfig;
import de.pascalkuehnold.aopdemo.dao.AccountDAO;
import de.pascalkuehnold.aopdemo.dao.MembershipDAO;
import de.pascalkuehnold.aopdemo.model.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {
        //read spring config java class
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class)) {
            //get the bean from spring container
            AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
            MembershipDAO membershipDao = context.getBean("membershipDAO", MembershipDAO.class);

            Account tempAccount = new Account();
            tempAccount.setLevel("Jame");
            tempAccount.setLevel("2");

            //call business method
            accountDAO.addAccount(tempAccount);

            membershipDao.addMembershipAccount();
        }
    }
}
