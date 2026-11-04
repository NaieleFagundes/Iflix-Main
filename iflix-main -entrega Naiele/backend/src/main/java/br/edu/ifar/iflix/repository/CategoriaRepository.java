package br.edu.ifar.iflix.repository;

import br.edu.ifar.iflix.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository
        extends JpaRepository<Categoria, Integer > {
}
