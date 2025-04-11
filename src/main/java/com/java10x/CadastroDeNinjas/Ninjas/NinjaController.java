package com.java10x.CadastroDeNinjas.Ninjas;

import jdk.javadoc.doclet.Reporter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa ordem";
    }

    //Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja =  ninjaService.criarNinja(ninja);
        return  ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso! " + novoNinja.getNome() + " id: " + novoNinja.getId());
    }

    // Mostrar ninja por id (READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id) {
        NinjaDTO ninja =  ninjaService.listarNinjaPorId(id);

        if (ninja != null){
            return ResponseEntity.ok(ninja);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o ID: " + id + "não encontrado");
        }

    }

    //Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    //alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        NinjaDTO ninja = ninjaService.atualizaNinja(id, ninjaAtualizado);
        if (ninja != null){
            return ResponseEntity.ok(ninja);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o id: " + id + "não encontrado");
        }

    }
    
    //deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id){
        if (ninjaService.listarNinjaPorId(id) != null){
            ninjaService.deletarNinja(id);
            return  ResponseEntity.ok("Ninja com ID " + id + " deletado com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com id " + id + " não encontrado");
        }
    }
}
