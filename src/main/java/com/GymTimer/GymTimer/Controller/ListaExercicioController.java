package com.GymTimer.GymTimer.Controller;

import com.GymTimer.GymTimer.Model.Exercicio;
import com.GymTimer.GymTimer.Model.ListaExercicios;
import com.GymTimer.GymTimer.Service.ListaExercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lista/exercicios")
public class ListaExercicioController {


    @Autowired
    ListaExercicioService service;

    @GetMapping
    public List<ListaExercicios> getAll(){return service.getAll();}

    @GetMapping("/{id}")
    public Optional<ListaExercicios> getById(@PathVariable Long id){return service.buscarPorId(id);}

    @DeleteMapping("/remover/lista/{idLista}/exercicio/{idExercicio}")
    public void removerExercico(@PathVariable Long idLista, @PathVariable Long idExercicio){service.removerExercicio(idLista,idExercicio);}

    @PostMapping("/{idLista}")
    public void adicionarExercicioEmLista(@PathVariable Long idLista, @RequestBody Exercicio exercicio){service.adicionarExercicioNovo(idLista, exercicio);}

    @PostMapping("/{idLista}/{idExercicio}/adicionar")
    public void adicionarExercicio(@PathVariable Long idLista, @PathVariable Long idExercicio){service.adicionarExercicio(idLista,idExercicio);}

    @PostMapping("/{idLista}/novo")
    public void adicionarExercicioNovo(@PathVariable Long idLista, @RequestBody Exercicio exercicio){service.adicionarExercicioNovo(idLista,exercicio);}

    @PostMapping("/registrar/{idFicha}")
    public void salvar(@RequestBody ListaExercicios listaExercicios, @PathVariable Long idFicha){service.salvar(idFicha,listaExercicios);}

    @PutMapping
    public void editar(@RequestBody ListaExercicios listaExercicios){service.editar(listaExercicios);}

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){service.deletar(id);}

}
