package com.anke.Backend_Spring_Anke.aop;

import com.anke.Backend_Spring_Anke.controller.AnkeController;
import com.anke.Backend_Spring_Anke.entities.Anke;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect // Aspect sınıfı olduğunu belirtmek için @Aspect annotation'ını kullanıyoruz.
@Component // Aspect sınıfını Spring context'ine eklemek için @Component annotation'ını kullanıyoruz.
public class ControllerAspect {

    // Anke classın içindeki return type ı Anke olan metotlarda afterReturning metodu çalışır.
    @AfterReturning(pointcut = "execution(* com.anke.Backend_Spring_Anke.controller.*(..))", returning = "result")
    public void afterReturning(Object result) {
        if (result instanceof String anke) {
            System.out.println("String: " + anke);
        }

    }
}