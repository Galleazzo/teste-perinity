package com.teste.paulo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.teste.paulo.model.Pessoa;
import jakarta.persistence.ManyToOne;

import java.util.Date;

public class TarefaDTO {

    private Long id;
    private String titulo;
    private String descricao;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date prazo;
    private String departamento;
    private Integer duracao;

    private Long pessoaAlocada;
    private Boolean finalizado;

    public TarefaDTO(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getPrazo() {
        return prazo;
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public Long getPessoaAlocada() {
        return pessoaAlocada;
    }

    public void setPessoaAlocada(Long pessoaAlocada) {
        this.pessoaAlocada = pessoaAlocada;
    }

    public Boolean getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(Boolean finalizado) {
        this.finalizado = finalizado;
    }
}
