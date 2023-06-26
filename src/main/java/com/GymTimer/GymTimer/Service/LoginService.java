package com.GymTimer.GymTimer.Service;

import com.GymTimer.GymTimer.Model.DTOs.UsuarioDTO;
import com.GymTimer.GymTimer.Model.Usuario;
import com.GymTimer.GymTimer.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public LoginService(UsuarioRepository usuarioRepository){this.usuarioRepository = usuarioRepository;}

    public UsuarioDTO logar(String email, String senha){

        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);

        UsuarioDTO dto = new UsuarioDTO(usuario.get());

        return dto;
    }

}
