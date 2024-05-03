package com.teste.paulo.controller;

import com.teste.paulo.dto.PessoaDTO;
import com.teste.paulo.model.Pessoa;
import com.teste.paulo.projection.ProjectedListPessoasEHoras;
import com.teste.paulo.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public void save(@RequestBody PessoaDTO pessoa) {
        this.pessoaService.save(pessoa);
    }

    @PutMapping(path = "/{id}")
    public void update(@RequestBody PessoaDTO pessoa, @PathVariable Long id) {
        this.pessoaService.update(pessoa, id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable Long id) {
        this.pessoaService.deleteById(id);
    }

    @GetMapping
    public List<ProjectedListPessoasEHoras> getListPessoasHoras() {
        return this.pessoaService.getPessoasHoras();
    }

    @GetMapping(path = "/gastos")
    public List<Double> getMediaPorTarefa(@RequestParam String nome, @RequestParam Date dataInicial, @RequestParam Date dataFinal) {
        return this.pessoaService.getMediaPorTarefa(nome, dataInicial, dataFinal);
    }
}
