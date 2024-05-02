package com.teste.paulo.dto;

import com.teste.paulo.model.Tarefa;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

public class PessoaDTO {

    private Long id;
    private String nome;
    private String departamento;
    private List<TarefaDTO> tarefaList;

    public PessoaDTO(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public List<TarefaDTO> getTarefaList() {
        return tarefaList;
    }

    public void setTarefaList(List<TarefaDTO> tarefaList) {
        this.tarefaList = tarefaList;
    }
}
