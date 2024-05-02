package com.teste.paulo.service;

import com.teste.paulo.dto.PessoaDTO;
import com.teste.paulo.model.Pessoa;
import com.teste.paulo.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public void save(PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa();
        if(pessoaDTO.getId() != null) {
            pessoa = this.pessoaRepository.getById(pessoa.getId());
        }

        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setDepartamento(pessoaDTO.getDepartamento());
        //pessoa.setTarefaList(pessoaDTO.getTarefaList());

        this.pessoaRepository.save(pessoa);
    }

    public void update(PessoaDTO pessoaDTO, Long id) {
        Pessoa pessoa = new Pessoa();
        if(id != null) {
            pessoa = this.pessoaRepository.getById(id);
        }

        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setDepartamento(pessoaDTO.getDepartamento());
        //pessoa.setTarefaList(pessoaDTO.getTarefaList());

        this.pessoaRepository.save(pessoa);
    }
}
