package com.teste.paulo.repository;

import com.teste.paulo.model.Pessoa;
import com.teste.paulo.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
