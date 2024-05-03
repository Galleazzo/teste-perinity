package com.teste.paulo.service;

import com.teste.paulo.projection.ProjectedListDepartamentos;
import com.teste.paulo.repository.DepartamentoReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoReposiroty departamentoReposiroty;

    public List<ProjectedListDepartamentos> getDepartamentos() {
        return this.departamentoReposiroty.getDepartamentos();
    }
}
