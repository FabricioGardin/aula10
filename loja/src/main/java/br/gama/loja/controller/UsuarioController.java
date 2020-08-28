package br.gama.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.gama.loja.dao.UsuarioDAO;
import br.gama.loja.model.Usuario;

@RestController
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioDAO dao;

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Usuario> buscaUsuario(@PathVariable int id){
        Usuario usuario = dao.findById(id).orElse(null);
        
        if(usuario != null){
            return ResponseEntity.ok(usuario);
        }else{
            return ResponseEntity.notFound().build();

        }
    }

    @PostMapping("/usuario/novo")
    public ResponseEntity<Usuario> novoUsuario(@RequestBody Usuario user){
        try{
            Usuario novo = dao.save(user); // salva o usuário no BD
            return ResponseEntity.ok(novo); // retorna os dados do usuário inserido no BD
        }catch(Exception ex){
            return ResponseEntity.status(400).build(); // 400 = bad request 9dados incorretos)
        }

    }
    
}