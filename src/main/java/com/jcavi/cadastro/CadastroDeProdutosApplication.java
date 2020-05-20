package com.jcavi.cadastro;

import com.jcavi.cadastro.service.email.EmailService;
import com.jcavi.cadastro.service.email.SmtpEmailService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CadastroDeProdutosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroDeProdutosApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}

}
