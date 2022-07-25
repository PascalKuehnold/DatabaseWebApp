package de.pascalkuehnold.aopdemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {

    //region Pointcut declarations

    //for package dao
    @Pointcut("execution(* de.pascalkuehnold.aopdemo.dao.*.*(..))")
    private void forDaoPackage() {}

    //for getter in package dao
    @Pointcut("execution(* de.pascalkuehnold.aopdemo.dao.*.get())")
    private void forGetters() {}

    //for setter in package dao
    @Pointcut("execution(* de.pascalkuehnold.aopdemo.dao.*.set())")
    private void forSetters() {}

    //endregion Pointcut declarations


    //region Advices

    // this is where we add all of our related advices for logging

    //@Before advice
    //modifier = public (optional)
    //return type = void (only void methods will be executed)
    //method call = every method starting with add (add*())
//    @Before("execution(public void add*())")
//    public void beforeAddAccountAdvice(){
//        System.out.println("\n=====>>> Executing @Before advice on add() methods");
//    }


//    //@Before advice<
//    //modifier = public (optional)
//    //return type = (*) any type (any return type method will be executed)
//    //method call = every method starting with add (add*())
//    @Before("execution(* add*())")
//    public void beforeAddAccountAdvice(){
//        System.out.println("\n=====>>> Executing @Before advice on add() methods");
//    }


//    //@Before advice
//    //modifier = any type
//    //return type = (* any type (any return type method will be executed)
//    //method call = every method starting with add (add*()) which has a parameter of Account
//    @Before("execution(* add*(de.pascalkuehnold.aopdemo.model.Account, ..))")
//    public void beforeAddAccountAdvice(){
//        System.out.println("\n=====>>> Executing @Before advice on add() methods where parameter type is Account");
//    }

//    //@Before advice
//    //modifier = any type
//    //return type = (* any type (any return type method will be executed)
//    //method call = every method starting with add (add*()) which has any type of parameter (..)
//    @Before("execution(* add*(..))")
//    public void beforeAddAccountAdvice(){
//        System.out.println("\n=====>>> Executing @Before advice on add() methods where parameter type is Account");
//    }

    //endregion Advices


    //@Before advice
    //pointcut is generated as method on top
    //executing for everything within .dao package
    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n=====>>> Executing @Before advice on all methods in .dao package");
    }

    @Before("forDaoPackage()")
    public void performApiAnalytics() {
        System.out.println("\n=====>>> Performing API analytics");
    }

}
