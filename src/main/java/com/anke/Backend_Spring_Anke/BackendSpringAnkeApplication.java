package com.anke.Backend_Spring_Anke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true) // AspectJ desteğini aktif hale getiriyoruz. Otomatik proxy ler oluşturabilirsin.
public class BackendSpringAnkeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendSpringAnkeApplication.class, args);
	}

}
