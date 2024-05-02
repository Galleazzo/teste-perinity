package com.teste.paulo.repository;

import com.teste.paulo.model.Pessoa;
import com.teste.paulo.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM tarefa WHERE id = :id")
    Tarefa getById(@Param("id") Long id);
}
