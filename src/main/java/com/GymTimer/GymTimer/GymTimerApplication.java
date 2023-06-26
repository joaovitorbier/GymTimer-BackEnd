package com.GymTimer.GymTimer;


import com.GymTimer.GymTimer.Model.*;
import com.GymTimer.GymTimer.Model.Enums.*;
import com.GymTimer.GymTimer.Service.LoginService;
import com.GymTimer.GymTimer.Service.MedidasService;
import com.GymTimer.GymTimer.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Date;

@SpringBootApplication
@EnableWebMvc
public class GymTimerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GymTimerApplication.class, args);

	}

	@Override
	public void run(String...args) throws Exception {

		System.out.println("ESTOU FUNCIONANDO!");

	}

}
