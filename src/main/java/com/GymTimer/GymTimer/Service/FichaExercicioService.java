package com.GymTimer.GymTimer.Service;

import com.GymTimer.GymTimer.Model.FichaExercicio;
import com.GymTimer.GymTimer.Model.Usuario;
import com.GymTimer.GymTimer.Repositories.FichaExerciciosRepository;
import com.GymTimer.GymTimer.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FichaExercicioService {

    @Autowired
    FichaExerciciosRepository repository;

    @Autowired
    UsuarioRepository usuarioRepository;

    //FUNÇÕES
    public Optional<FichaExercicio> buscarPorId(Long id){
        Optional<FichaExercicio> lista = repository.findById(id);
        return lista;
    }

    public List<FichaExercicio> getAll(Long id){
        Usuario usuario = usuarioRepository.getReferenceById(id);
        return  usuario.getFichaExercicio();
    }

    public void salvar(FichaExercicio fichaExercicio, Long idUsuario){

        Usuario usuario = usuarioRepository.getReferenceById(idUsuario);
        usuario.addFichaExercicio(fichaExercicio);
        usuarioRepository.save(usuario);

    }

    public void editar(FichaExercicio fichaExercicio, Long idUsuario){

        Usuario usuario = usuarioRepository.getReferenceById(idUsuario);
        usuario.addFichaExercicio(fichaExercicio);
        usuarioRepository.save(usuario);

    }

    public void deletar(Long id){repository.deleteById(id);}

}
