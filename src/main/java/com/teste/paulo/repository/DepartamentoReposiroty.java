package com.teste.paulo.repository;

import com.teste.paulo.model.Departamento;
import com.teste.paulo.model.Tarefa;
import com.teste.paulo.projection.ProjectedListDepartamentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartamentoReposiroty extends JpaRepository<Departamento, Long> {

    @Query(nativeQuery = true, value = "SELECT d.nome as departamento, " +
            "(SELECT COUNT(*) FROM pessoa p WHERE p.departamento = d.nome) as qtdPessoas, " +
            "(SELECT COUNT(*) FROM tarefa t WHERE t.departamento = d.nome) as qtdTarefas " +
            "FROM departamento d")
    List<ProjectedListDepartamentos> getDepartamentos();

}
