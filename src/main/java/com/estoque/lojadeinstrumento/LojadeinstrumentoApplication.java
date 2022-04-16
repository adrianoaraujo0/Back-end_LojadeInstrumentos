package com.estoque.lojadeinstrumento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.estoque.lojadeinstrumento.entidades"})
@EnableJpaRepositories(basePackages = {"com.estoque.lojadeinstrumento.repositorio"})
@ComponentScan(basePackages = {"com.estoque.lojadeinstrumento.servico", "com.estoque.lojadeinstrumento.controlador","com.estoque.lojadeinstrumento.excessao"})
@SpringBootApplication
public class LojadeinstrumentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LojadeinstrumentoApplication.class, args);
	}

}
