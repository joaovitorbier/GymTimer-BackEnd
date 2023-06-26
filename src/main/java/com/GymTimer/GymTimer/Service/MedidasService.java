package com.GymTimer.GymTimer.Service;

import com.GymTimer.GymTimer.Model.FichaCorpo;
import com.GymTimer.GymTimer.Model.Medidas;
import com.GymTimer.GymTimer.Model.Usuario;
import com.GymTimer.GymTimer.Repositories.FichaCorpoRepository;
import com.GymTimer.GymTimer.Repositories.MedidasRepository;
import com.GymTimer.GymTimer.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedidasService {

    @Autowired
    MedidasRepository repository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    FichaCorpoRepository fichaCorpoRepository;

    public MedidasService(MedidasRepository repository) {
        this.repository = repository;
    }

    //FUNÇÕES
//    public Optional<Medidas> buscarPorId(Long id){
//        Optional<Medidas> medidas = repository.findById(id);
//        return medidas;
//    }

    //FAZER COM MEDIDA NORMAL
    public Medidas buscarPorId(Long id){
        Optional<Medidas> medidas = repository.findById(id);
        return medidas.get();
    }

    public List<Medidas> getAll(Long id){

        Usuario usuario = usuarioRepository.getReferenceById(id);
        List<FichaCorpo> fichaCorpos = usuario.getFichaCorpos();
        List<Medidas> medidas = null;
        for(FichaCorpo element: fichaCorpos){
            medidas.add((Medidas) element.getMedidas());
        }
       return medidas;

    }

    public void salvar(Long id, Long idFichaCorpo ,Medidas medidas){

        Usuario usuario = usuarioRepository.getReferenceById(id);
        FichaCorpo fichaCorpo;
        fichaCorpo = usuario.getFichaCorpos().get(idFichaCorpo.intValue());
        fichaCorpo.addMedida(medidas);
        usuario.addFichaCorpo(fichaCorpo);
        usuarioRepository.save(usuario);

    }

    public void salvarMedidaEmFicha(Long idFichaCorpo ,Medidas medidas){

        FichaCorpo ficha = fichaCorpoRepository.getReferenceById(idFichaCorpo);
        ficha.addMedida(medidas);
        fichaCorpoRepository.save(ficha);

    }

    public void editar(Long id, Long idFichaCorpo ,Medidas medidas){
        Usuario usuario = usuarioRepository.getReferenceById(id);
        FichaCorpo fichaCorpo;
        fichaCorpo = usuario.getFichaCorpos().get(idFichaCorpo.intValue());
        fichaCorpo.addMedida(medidas);
        usuario.addFichaCorpo(fichaCorpo);
        usuarioRepository.save(usuario);
    }

    public void deletar(Long idMedida, Long idUsuario){
        //SIM, PRIMEIRO EU TO PEGANDO O USUARIO INTEIRO DO BANCO
        Usuario usuario = usuarioRepository.getReferenceById(idUsuario);

        //AQUI ESTOU REMOVENDO UNICAMENTE AQUELA MEDIDA DAQUELE USUARIO PARA CORTAR RELAÇÃ
        usuario.getFichaCorpos().removeIf(
                obj -> obj.getId() == idMedida
        );

        //SALVAR O USUARIO MODIFICADO PRA FAZER VALER MINHA ALTERAÇÃO
        usuarioRepository.save(usuario);

        //TENTAR DELETAR A MEDIDA QUE AGORA NÃO ESTA RELACIONADA A NADA
        repository.deleteById(idMedida);

    }

}
