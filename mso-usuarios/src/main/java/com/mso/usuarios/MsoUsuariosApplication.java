package com.mso.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class MsoUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsoUsuariosApplication.class, args);
	}

}
