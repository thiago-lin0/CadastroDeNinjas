package com.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    //listando todas as missoes
    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }

    //listando missoes por id
    public MissoesModel listarMissoesPorId(Long id){
        Optional<MissoesModel> missao = missoesRepository.findById(id);
        return missao.orElse(null);
    }

    public MissoesModel criarMissoes(MissoesModel missoesModel){
        return missoesRepository.save(missoesModel);
    }

    public  MissoesModel alterarMissoes(Long id, MissoesModel misaoAtualizada){
        if (missoesRepository.existsById(id)){
            misaoAtualizada.setId(id);
            return missoesRepository.save(misaoAtualizada);
        }
        return null;
    }

    public void deletarMissao(Long id){
        missoesRepository.deleteById(id);
    }

}
