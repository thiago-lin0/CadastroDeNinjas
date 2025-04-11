package com.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesControler {

    private MissoesService missoesService;

    public MissoesControler(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes() {
        return missoesService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissoesModel listarMissoesPorId(@PathVariable Long id) {
        return missoesService.listarMissoesPorId(id);

    }

    @PostMapping("/criar")
    public MissoesModel criarMissoes(@RequestBody MissoesModel missoesModel){
        return missoesService.criarMissoes(missoesModel);
    }

    @PutMapping("/alterar/{id}")
    public MissoesModel alterarMissoes(@PathVariable Long id, @RequestBody MissoesModel missaoAtualizada) {
        return missoesService.alterarMissoes(id,missaoAtualizada);

    }

    @DeleteMapping("/deletar/{id}")
    public void deletarMissoes(@PathVariable Long id) {
        missoesService.deletarMissao(id);
    }
}
