package com.GymTimer.GymTimer.Controller;

import com.GymTimer.GymTimer.Model.DTOs.UsuarioDTO;
import com.GymTimer.GymTimer.Model.Usuario;
import com.GymTimer.GymTimer.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService service;

    @GetMapping("/{email}/{senha}")
    public UsuarioDTO logar(@PathVariable String email, String senha){return service.logar(email,senha);}

}
