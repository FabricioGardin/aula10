package br.gama.loja.dao;

import org.springframework.data.repository.CrudRepository;

import br.gama.loja.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer>{
    
}