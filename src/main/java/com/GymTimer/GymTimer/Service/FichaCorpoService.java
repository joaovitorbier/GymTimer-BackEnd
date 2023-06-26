package com.GymTimer.GymTimer.Service;

import com.GymTimer.GymTimer.Model.DTOs.FichaCorpoDTO;
import com.GymTimer.GymTimer.Model.FichaCorpo;
import com.GymTimer.GymTimer.Model.Usuario;
import com.GymTimer.GymTimer.Repositories.FichaCorpoRepository;
import com.GymTimer.GymTimer.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FichaCorpoService {

    @Autowired
    FichaCorpoRepository repository;

    @Autowired
    UsuarioRepository usuarioRepository;

    //FUNÇÕES
    public Optional<FichaCorpo> buscarPorId(Long id){
        Optional<FichaCorpo> lista = repository.findById(id);
        return lista;
    }

    public List<FichaCorpo> getAll(Long id){
        Usuario usuario = usuarioRepository.getReferenceById(id);
        //List<FichaCorpo> fichas = usuario.getFichaCorpos();
        return usuario.getFichaCorpos();
    }

    public void salvar(FichaCorpo fichaCorpo, Long idUsuario){
        Usuario usuario = usuarioRepository.getReferenceById(idUsuario);
        usuario.addFichaCorpo(fichaCorpo);

        usuarioRepository.save(usuario);
    }

    public void editar(FichaCorpoDTO fichaCorpoDTO){

        FichaCorpo ficha = repository.getReferenceById(fichaCorpoDTO.getId());

        ficha.setPeso(fichaCorpoDTO.getPeso());
        ficha.setAltura(fichaCorpoDTO.getAltura());
        ficha.setBodyFat(fichaCorpoDTO.getBodyFat());

        repository.save(ficha);

    }

    public void deletar(Long id){repository.deleteById(id);}

    public void deletarMedida(Long idFichaCorpo, Long idMedida){

    }

}
