package com.GymTimer.GymTimer.Controller;

import com.GymTimer.GymTimer.Model.DTOs.UsuarioDTO;
import com.GymTimer.GymTimer.Model.Usuario;
import com.GymTimer.GymTimer.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    UsuarioService service;

    @GetMapping
    public List<Usuario> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> getById(@PathVariable Long id){return service.buscarPorId(id);}

    @GetMapping("/data/{id}")
    public UsuarioDTO getOnlyDataById(@PathVariable Long id){return service.buscarPorIdDTO(id);}

    @PostMapping("/novo")
    public  void salvar(@RequestBody Usuario usuario){service.salvar(usuario);}

    @PutMapping
    public void editar(@RequestBody Usuario usuario){service.editar(usuario);}

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){service.deletar(id);}

}
