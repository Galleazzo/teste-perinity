package com.teste.paulo.service;

import com.teste.paulo.dto.PessoaDTO;
import com.teste.paulo.model.Pessoa;
import com.teste.paulo.projection.ProjectedListPessoasEHoras;
import com.teste.paulo.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public void save(PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa();
        if(pessoaDTO.getId() != null) {
            pessoa = this.pessoaRepository.getById(pessoaDTO.getId());
        }

        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setDepartamento(pessoaDTO.getDepartamento());

        this.pessoaRepository.save(pessoa);
    }

    public void update(PessoaDTO pessoaDTO, Long id) {
        Pessoa pessoa = new Pessoa();
        if(id != null) {
            pessoa = this.pessoaRepository.getById(id);
        }

        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setDepartamento(pessoaDTO.getDepartamento());

        this.pessoaRepository.save(pessoa);
    }

    public void deleteById(Long id) {
        try {
            this.pessoaRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Id invalido");
        }
    }

    public List<ProjectedListPessoasEHoras> getPessoasHoras() {
        return this.pessoaRepository.getPessoasEHoras();
    }
}
