package com.GymTimer.GymTimer.Controller;

import com.GymTimer.GymTimer.Model.FichaExercicio;
import com.GymTimer.GymTimer.Service.FichaExercicioService;
import com.GymTimer.GymTimer.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import com.GymTimer.GymTimer.Model.*;

@RestController
@RequestMapping("/ficha/exercicios")
public class FichaExercicioController {


    @Autowired
    FichaExercicioService service;

    @GetMapping("/usuario/{idUsuario}")
    public List<FichaExercicio> getAll(@PathVariable Long idUsuario){return service.getAll(idUsuario);}

    @GetMapping("/{id}")
    public Optional<FichaExercicio> getById(@PathVariable Long id){return service.buscarPorId(id);}

    @PostMapping("/usuario/{idUsuario}")
    public void salvar(@PathVariable Long idUsuario,@RequestBody FichaExercicio fichaExercicio){service.salvar(fichaExercicio,idUsuario);}

    @PutMapping("/usuario/{idUsuario}")
    public void editar(@PathVariable Long idUsuario,@RequestBody FichaExercicio fichaExercicio){service.editar(fichaExercicio,idUsuario);}

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){service.deletar(id);}

}
