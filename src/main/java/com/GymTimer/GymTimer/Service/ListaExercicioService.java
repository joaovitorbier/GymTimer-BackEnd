package com.GymTimer.GymTimer.Service;

import com.GymTimer.GymTimer.Model.Exercicio;
import com.GymTimer.GymTimer.Model.FichaExercicio;
import com.GymTimer.GymTimer.Model.ListaExercicios;
import com.GymTimer.GymTimer.Model.Usuario;
import com.GymTimer.GymTimer.Repositories.ExercicioRepository;
import com.GymTimer.GymTimer.Repositories.FichaExerciciosRepository;
import com.GymTimer.GymTimer.Repositories.ListaExerciciosRepository;
import com.GymTimer.GymTimer.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListaExercicioService {

    @Autowired
    ListaExerciciosRepository repository;

    @Autowired
    ExercicioRepository exercicioRepository;

    @Autowired
    FichaExerciciosRepository fichaExerciciosRepository;

    //FUNÇÕES
    public Optional<ListaExercicios> buscarPorId(Long id){
        Optional<ListaExercicios> lista = repository.findById(id);
        return lista;
    }

    public List<ListaExercicios> getAll(){
        return repository.findAll();
    }

    public void adicionarExercicioNovo(Long idLista, Exercicio exercicio){
        ListaExercicios lista = repository.findById(idLista).get();
        exercicioRepository.save(exercicio);
        lista.getListaDeExercicios().add(exercicio);
        //lista.getListaDeExercicios().removeIf(exercicio -> exercicio.getId() == idExercicio);
        repository.save(lista);
    }

    public void adicionarLista(String nome){

        ListaExercicios lista = new ListaExercicios();
        lista.setNome(nome);
        repository.save(lista);

    }

    public void adicionarExercicio(Long idLista, Long idExercicio){
        ListaExercicios lista = repository.findById(idLista).get();
        Exercicio exercicio = exercicioRepository.getReferenceById(idExercicio);
        lista.getListaDeExercicios().add(exercicio);
        //lista.getListaDeExercicios().removeIf(exercicio -> exercicio.getId() == idExercicio);
        repository.save(lista);
    }

    public void removerExercicio(Long idLista, Long idExercicio){
        ListaExercicios lista = repository.findById(idLista).get();
        lista.getListaDeExercicios().removeIf(exercicio -> exercicio.getId() == idExercicio);
        repository.save(lista);
        System.out.println("O EXERCÍCIO FOI REMOVIDO COM SUCESSO");
    }

    public void salvar(Long idFicha,ListaExercicios listaExercicios){

        Optional<FichaExercicio> fichaOptional = fichaExerciciosRepository.findById(idFicha);
        FichaExercicio ficha = fichaOptional.get();

        ficha.addListaDeExercicio(listaExercicios);

        fichaExerciciosRepository.save(ficha);
    }

    public void editar(ListaExercicios listaExercicios){repository.save(listaExercicios);}

    public void deletar(Long id){repository.deleteById(id);}

}
