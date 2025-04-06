package com.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa ordem";
    }

    //Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja Criado";
    }

    // Mostrar ninja por id (READ)
    @GetMapping("/listaID")
    public String listaNinjasPorId(){
        return "Mostrar Ninjas por ID ";
    }
    //Mostrar todos os ninjas (READ)
    @GetMapping("/lista")
    public String listaTodosNinjas(){
        return "Mostrar Todos os Ninjas";
    }

    //alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinjaPorId(){
        return "Alterar Ninjas";
    }
    
    //deletar Ninja (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId(){
        return "Ninja Deletado por Id";
    }
}
