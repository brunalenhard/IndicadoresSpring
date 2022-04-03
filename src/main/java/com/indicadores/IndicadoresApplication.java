package com.indicadores;

import com.indicadores.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class IndicadoresApplication {

	@Autowired
    PacienteService pacienteService;

	public static void main(String[] args) {
		SpringApplication.run(IndicadoresApplication.class, args);
	}



}
