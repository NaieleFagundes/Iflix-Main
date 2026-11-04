package br.edu.ifar.iflix.controller;

import br.edu.ifar.iflix.model.Categoria;
import br.edu.ifar.iflix.model.Usuario;
import br.edu.ifar.iflix.service.CategoriaService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/categoria")
public class CategoriaController {

    private CategoriaService service;

    public CategoriaController( CategoriaService s ) {
        this.service = s;
    }
    @GetMapping("/{id}") 
    public Categoria buscaPorId( @PathVariable int id ){
        return this.service.buscaPorId(id);
    }

    @GetMapping
    public List<Categoria> buscarTodos(){
        return this.service.buscarTodos();
    }
    @PostMapping
    public Categoria gravar( @RequestBody Categoria cat){
        this.service.gravar(cat);
        return cat;
        
    }
    @PutMapping 
    public Categoria atualizar( @RequestBody Categoria cat){
        this.service.gravar(cat);
        return cat;
        
    }

}

