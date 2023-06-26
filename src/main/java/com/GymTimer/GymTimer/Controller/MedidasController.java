package com.GymTimer.GymTimer.Controller;

import com.GymTimer.GymTimer.Model.Medidas;
import com.GymTimer.GymTimer.Service.MedidasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medidas")
public class MedidasController {

    @Autowired
    MedidasService service;

    @GetMapping({"/usuario/{id}"})
    public List<Medidas> getMedidiasUsuario(@PathVariable Long id){return service.getAll(id);}

    @GetMapping("/{id}")
    //@CrossOrigin(origins = {"http://localhost:4200", "http://lcoalhost:8080"})
    public  Medidas getMedidaById(@PathVariable Long id){return service.buscarPorId(id);}

    //@GetMapping("/{id}")
    //public Optional<Medidas> getById(@PathVariable Long id){ return service.buscarPorId(id);}

    @PostMapping({"/fichacorpo/{idFicha}"})
    public void salvarMedidaEmFicha(@PathVariable Long idFicha ,@RequestBody Medidas medidas){service.salvarMedidaEmFicha(idFicha,medidas);}


    @PutMapping({"usuario/{id}/{idMedida}"})
    public void editar(@PathVariable Long id, @PathVariable Long idMedida ,@RequestBody Medidas medidas){service.editar(id,idMedida,medidas);}

    @DeleteMapping({"/{idMedida}/usuario/{idUsuario}"})
    public void deletar(@PathVariable Long idMedida,@PathVariable Long idUsuario){service.deletar(idUsuario,idMedida);}

}
