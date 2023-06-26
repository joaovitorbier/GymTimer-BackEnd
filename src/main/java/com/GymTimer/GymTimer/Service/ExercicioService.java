package com.GymTimer.GymTimer.Service;

import com.GymTimer.GymTimer.Model.Exercicio;
import com.GymTimer.GymTimer.Repositories.ExercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExercicioService {

    @Autowired
    ExercicioRepository repository;

    //FUNÇÕES
    public Optional<Exercicio> buscarPorId(Long id){
        Optional<Exercicio> exercicio = repository.findById(id);
        return exercicio;
    }

    public List<Exercicio> getAll(){
        return repository.findAll();
    }

    public void salvar(Exercicio exercicio){
        repository.save(exercicio);
    }

    public void editar(Exercicio exercicio){repository.save(exercicio);}

    public void deletar(Long id){repository.deleteById(id);}

}
