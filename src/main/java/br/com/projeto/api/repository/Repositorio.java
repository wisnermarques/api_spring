package br.com.projeto.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.projeto.api.model.Pessoa;

public interface Repositorio extends CrudRepository<Pessoa, Integer> {
    List<Pessoa> findAll();

    Pessoa findByCodigo(int codigo);
}


