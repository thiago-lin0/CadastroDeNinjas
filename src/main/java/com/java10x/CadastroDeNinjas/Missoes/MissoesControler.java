package com.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissoesControler {

    @GetMapping("/listar")
    public String listarMissoes(){
        return "Missoes listada com sucesso";
    }

    @PostMapping("/criar")
    public String criarMissoes(){
        return "Missão criada com sucesso";
    }

    @PutMapping("/alterar")
    public String alterarMissoes(){
        return "Missão alterada com sucesso";
    }

    @DeleteMapping("/deletar")
    public String deletarMissoes(){
        return "Missão deletada com sucesso";
    }
}
