package com.teste.paulo.controller;

import com.teste.paulo.projection.ProjectedListDepartamentos;
import com.teste.paulo.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping
    public List<ProjectedListDepartamentos> getDepartamentos() {
        return this.departamentoService.getDepartamentos();
    }
}
