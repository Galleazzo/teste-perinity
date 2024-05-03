package com.teste.paulo.repository;

import com.teste.paulo.model.Pessoa;
import com.teste.paulo.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM tarefa WHERE id = :id")
    Tarefa getById(@Param("id") Long id);

    @Query(nativeQuery = true, value = "SELECT * FROM tarefa WHERE pessoa_alocada_id IS NULL ORDER BY prazo ASC LIMIT 3")
    List<Tarefa> getPendentes();

}
