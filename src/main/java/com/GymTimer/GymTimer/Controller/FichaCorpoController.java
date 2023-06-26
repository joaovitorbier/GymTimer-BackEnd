package com.GymTimer.GymTimer.Controller;

import com.GymTimer.GymTimer.Model.DTOs.FichaCorpoDTO;
import com.GymTimer.GymTimer.Model.FichaCorpo;
import com.GymTimer.GymTimer.Model.FichaExercicio;
import com.GymTimer.GymTimer.Service.FichaCorpoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ficha/corpo")
public class FichaCorpoController {

    @Autowired
    FichaCorpoService service;

    @GetMapping("/usuario/{idUsuario}")
    public List<FichaCorpo> getAll(@PathVariable Long idUsuario){return service.getAll(idUsuario);}

    @GetMapping("/{id}")
    public Optional<FichaCorpo> getById(@PathVariable Long id){return service.buscarPorId(id);}

    @PostMapping("/usuario/{idUsuario}")
    public void salvar(@PathVariable Long idUsuario,@RequestBody FichaCorpo fichaCorpo){service.salvar(fichaCorpo,idUsuario);}

    @DeleteMapping("/{idFichaCorpo}/medida/{idMedida}")
    public void removerExercicioFicha(@PathVariable Long idFichaCorpo, @PathVariable Long idMedida){}

    @PutMapping("/editar")
    public void editar(@RequestBody FichaCorpoDTO fichaCorpoDTO){service.editar(fichaCorpoDTO);}

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){service.deletar(id);}

}
