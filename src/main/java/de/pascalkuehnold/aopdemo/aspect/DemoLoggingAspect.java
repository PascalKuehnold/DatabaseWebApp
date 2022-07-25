package de.pascalkuehnold.aopdemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {
    //this is where we add all of our related advices for logging

    //@Before advice
    //modifier = public (optional)
    //returntype = void (only void methods will be executed)
    //method call = every method starting with add (add*())
//    @Before("execution(public void add*())")
//    public void beforeAddAccountAdvice(){
//        System.out.println("\n=====>>> Executing @Before advice on add() methods");
//    }


//    //@Before advice<
//    //modifier = public (optional)
//    //returntype = (*) any type (any return type method will be executed)
//    //method call = every method starting with add (add*())
//    @Before("execution(* add*())")
//    public void beforeAddAccountAdvice(){
//        System.out.println("\n=====>>> Executing @Before advice on add() methods");
//    }


    //@Before advice
    //modifier = any type
    //returntype = (* any type (any return type method will be executed)
    //method call = every method starting with add (add*()) which has a parameter of Account
    @Before("execution(* add*(de.pascalkuehnold.aopdemo.model.Account))")
    public void beforeAddAccountAdvice(){
        System.out.println("\n=====>>> Executing @Before advice on add() methods where parameter type is Account");
    }
}
