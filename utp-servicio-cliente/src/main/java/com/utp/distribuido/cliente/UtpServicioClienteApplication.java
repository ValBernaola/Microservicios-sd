package com.utp.distribuido.cliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class UtpServicioClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(UtpServicioClienteApplication.class, args);
	}

}
