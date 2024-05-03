package com.teste.paulo.service;

import com.teste.paulo.dto.TarefaDTO;
import com.teste.paulo.model.Pessoa;
import com.teste.paulo.model.Tarefa;
import com.teste.paulo.repository.PessoaRepository;
import com.teste.paulo.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public void novaTarefa(TarefaDTO tarefaDTO){
        Tarefa tarefa = new Tarefa();
        if(tarefaDTO.getId() != null) {
            tarefa = this.tarefaRepository.getById(tarefaDTO.getId());
        }

        tarefa.setTitulo(tarefaDTO.getTitulo());
        tarefa.setDescricao(tarefaDTO.getDescricao());
        tarefa.setPrazo(tarefaDTO.getPrazo());
        tarefa.setDepartamento(tarefaDTO.getDepartamento());
        tarefa.setDuracao(tarefaDTO.getDuracao());
        tarefa.setPessoaAlocada(null);
        if(tarefaDTO.getPessoaAlocada() != null) {
            tarefa.setPessoaAlocada(this.pessoaRepository.getById(tarefaDTO.getPessoaAlocada()));
        }
        tarefa.setFinalizado(tarefaDTO.getFinalizado());

        this.tarefaRepository.save(tarefa);
    }

    public void finalizar(Long id) {
        Tarefa tarefa = this.tarefaRepository.getById(id);
        tarefa.setFinalizado(true);
        this.tarefaRepository.save(tarefa);
    }

    public List<Tarefa> getPendentes() {
        return this.tarefaRepository.getPendentes();
    }
}
