package com.example.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("LoggingAspectBean")
@Aspect
public class LoggingAspect {

    public LoggingAspect(){}

    /*
     * PointCut expressions are used to select joinpoints, or in other works, pointcuts target a subset of joinpoints
     * PointCut expression symbols
     * "*" is a wildcard that for return types, methods, and single parameter in a parameter list
     * ".." us a wildcard for the parameter list of a method
     * These examples are from another trainers examples, but you can still take a look to see some examples of more wildcard use
     * @Before("execution(* *(..)") this will execute on all the methods
     * @Before("execution(* draw*(..))") this one will match any method with draw in the name and one or zero parameter
     * @Before("execution(int *aw*(..))") this one will match any method that returns an integer and has aw in the method name, with one or zero parameters
     * @Before("execution(* *(char, int)") this one will match any method that takes in a char and int as its paramaters
     * @Before("execution(* *aw*(..,int))") this one will match any method with aw in its name, and has 1 or 2 paremeters, the second parameter being an int
     * @Before("execution(protected * *(..)") this one will match any method with one or zero parameters that is protected
     */

    //Create a set of joinpoints that gets called before the execution of any method in the application
    //This creates a join for methods with ANY return type, ANY name, and ANY param list
    /*
    @Before("execution(* *(..))")
    public void printBeforeAllMethods(JoinPoint jp){
        System.out.println("This should print before every method call");
        System.out.println("Method: " + jp.getSignature() + " was called");
    }
    */

    //This will be called before any method in the PersonService
    /*
    @Before("execution(* com.example.service.UserService.*(..))")
    public void beforeAnyUserServiceMethod(JoinPoint jp){
        System.out.println("User service method executed: " + jp.getSignature() + " was called");
    }
     */
    @AfterThrowing("execution(* com.example.service.UserService.login(..))")
    public void loginFailed(JoinPoint jp){
        Object[] credentials = jp.getArgs();
        System.out.println("User: " + (String) credentials[0] + " tried logging in but failed");
    }


    @AfterReturning("execution(void *(..))")
    public void afterReturningFromAnyVoidMethod(JoinPoint jp){
        System.out.println("This method with a void return type was called: " + jp.getSignature());
    }

    @After("execution(boolean *(String, String))")
    public void afterLoginRegardless(JoinPoint jp){
        System.out.println("This should run whether the login failed or not");
    }

    @Around("execution(* com.example.service.UserService.updateUser(..))")
    public void lookAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("This part is acting as @ before");
        System.out.println("We have a user updating their info");

        //For the method we are creating this join point around to proceed, we must call proceed
        //If the User class was public, we could get access to the returned value with the .proceed method
        pjp.proceed();

        System.out.println("This happens after we call the method");
    }

}
