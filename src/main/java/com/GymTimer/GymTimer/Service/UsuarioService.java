package com.GymTimer.GymTimer.Service;

import com.GymTimer.GymTimer.Model.DTOs.UsuarioDTO;
import com.GymTimer.GymTimer.Model.Usuario;
import com.GymTimer.GymTimer.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class UsuarioService {


    @Autowired
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Optional<Usuario> buscarPorId(Long id){
        Optional<Usuario> usuario = repository.findById(id);
        return usuario;
    }

    public UsuarioDTO buscarPorIdDTO(Long id){
        Optional<Usuario> usuario = repository.findById(id);

        UsuarioDTO dto = new UsuarioDTO(usuario.get());


        return dto;
    }


    public List<Usuario> getAll(){
        return repository.findAll();
    }

    public void salvar(Usuario usuario){
        repository.save(usuario);
    }

    public void editar(Usuario usuario){repository.save(usuario);}

    public void deletar(Long id){repository.deleteById(id);}

}
