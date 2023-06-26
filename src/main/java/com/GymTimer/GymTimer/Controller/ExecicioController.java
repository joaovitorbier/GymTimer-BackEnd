package com.GymTimer.GymTimer.Controller;

import com.GymTimer.GymTimer.Model.Exercicio;
import com.GymTimer.GymTimer.Service.ExercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/exercicio")
public class ExecicioController {

    @Autowired
    ExercicioService service;

    @GetMapping
    public List<Exercicio> getAll(){return service.getAll();}

    @GetMapping("/{id}")
    public Optional<Exercicio> getById(@PathVariable Long id){return service.buscarPorId(id);}

    @PostMapping
    public void salvar(@RequestBody Exercicio exercicio){service.salvar(exercicio);}

    @PutMapping
    public void editar(@RequestBody Exercicio exercicio){service.editar(exercicio);}

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){service.deletar(id);}

}
