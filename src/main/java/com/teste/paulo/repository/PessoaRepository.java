package com.teste.paulo.repository;

import com.teste.paulo.model.Pessoa;
import com.teste.paulo.projection.ProjectedListPessoasEHoras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM pessoa WHERE id = :id")
    Pessoa getById(@Param("id") Long id);

    @Query("SELECT p.nome as nome, p.departamento as departamento, SUM(t.duracao) as totalHorasGastas " +
            "FROM Pessoa p " +
            "JOIN p.tarefaList t " +
            "GROUP BY p.id")
    List<ProjectedListPessoasEHoras> getPessoasEHoras();

    @Query("SELECT AVG(t.duracao) " +
            "FROM Tarefa t " +
            "WHERE t.pessoaAlocada.nome = :nome " +
            "AND t.prazo BETWEEN :dataInicial AND :dataFinal")
    List<Double> getMediaPorTarefa(@Param("nome") String nome,
                                   @Param("dataInicial") Date dataInicial,
                                   @Param("dataFinal") Date dataFinal);
}
