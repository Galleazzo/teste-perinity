package com.teste.paulo.repository;

import com.teste.paulo.model.Pessoa;
import com.teste.paulo.projection.ProjectedListPessoasEHoras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM pessoa WHERE id = :id")
    Pessoa getById(@Param("id") Long id);

    @Query(nativeQuery = true, value = "SELECT") //TODO fazer listagem
    List<ProjectedListPessoasEHoras> getPessoasEHoras();
}
