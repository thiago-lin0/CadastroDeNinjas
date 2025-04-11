package com.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {

    public MissoesModel map(MissoesDTO missoesDTO){
        MissoesModel missoesModel = new MissoesModel();
        missoesModel.setId(missoesDTO.getId());
        missoesModel.setNome(missoesDTO.getNome());
        missoesModel.setDificuldade(missoesDTO.getDificuldade());
        missoesModel.setNinjas(missoesDTO.getNinjas());

        return missoesModel;
    }

    public MissoesDTO map(MissoesModel missoesModels){
        MissoesDTO missoesDTO = new MissoesDTO();
        missoesDTO.setId(missoesModels.getId());
        missoesDTO.setNome(missoesModels.getNome());
        missoesDTO.setDificuldade(missoesModels.getDificuldade());
        missoesDTO.setNinjas(missoesModels.getNinjas());

        return missoesDTO;
    }



}
