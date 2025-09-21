package demo.spring.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* demo.spring.aop.ShoppingCart.checkout(..))")
    public void beforeLogger(JoinPoint jp){
//        System.out.println("signature:" +jp.getSignature()); //to get method which is called
        System.out.println("arguments:"+jp.getArgs()[0].toString());//to get argument value
        System.out.println("Before Logger");
    }


    @After("execution(* demo.spring.aop.ShoppingCart.checkout(..))")
    public void afterLogger(){
        System.out.println("After Logger");
    }


    @Pointcut("execution(* demo.spring.aop.ShoppingCart.quantity(..))")
    public void afterReturningPointCut(){}

    @AfterReturning(pointcut = "afterReturningPointCut()", returning = "retVal")
    public void afterReturning(int retVal){
        System.out.println("After Returning: " + retVal);
    }
}

