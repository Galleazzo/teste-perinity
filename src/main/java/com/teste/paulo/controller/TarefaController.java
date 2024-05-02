package com.teste.paulo.controller;

import com.teste.paulo.dto.TarefaDTO;
import com.teste.paulo.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public void save(@RequestBody TarefaDTO tarefaDTO) {
        this.tarefaService.novaTarefa(tarefaDTO);
    }

    @PutMapping(path = "/finalizar/{id}")
    public void save(@PathVariable Long id) {
        this.tarefaService.finalizar(id);
    }
}
