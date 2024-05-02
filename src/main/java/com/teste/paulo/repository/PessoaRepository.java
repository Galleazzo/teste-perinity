package com.teste.paulo.repository;

import com.teste.paulo.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM pessoa WHERE id = :id")
    Pessoa getById(@Param("id") Long id);
}
