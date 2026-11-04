package br.edu.ifar.iflix.service;

import br.edu.ifar.iflix.model.Categoria;
import br.edu.ifar.iflix.repository.CategoriaRepository;
import jakarta.persistence.OrderBy;
import jakarta.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.beans.Transient;
import java.util.List;
@Service
public class CategoriaService {

    private CategoriaRepository repo;

    public CategoriaService(CategoriaRepository r){
        this.repo = r;
    }

    // listar todas categoria
    public List<Categoria> buscarTodos(){
        return this.repo.findAll(Sort.by(Order.asc("nome"))  );
    }
     
    public void gravar(Categoria c){
        this.repo.save(c);
    }

    public Categoria buscaPorId(int id){
        return this.repo.findById(id)
        .orElseThrow( () ->  new  ResponseStatusException(
            HttpStatus.NOT_FOUND, "Categoria não encontrada"
        ) ) ;
    }
}
