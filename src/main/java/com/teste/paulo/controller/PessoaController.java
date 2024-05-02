package com.teste.paulo.controller;

import com.teste.paulo.dto.PessoaDTO;
import com.teste.paulo.model.Pessoa;
import com.teste.paulo.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;
    @PostMapping
    public void save(@RequestBody PessoaDTO pessoa) {
        this.pessoaService.save(pessoa);
    }

    @PostMapping(path = "/{id}")
    public void update(@RequestBody PessoaDTO pessoa, @PathVariable Long id) {
        this.pessoaService.update(pessoa, id);
    }
}
