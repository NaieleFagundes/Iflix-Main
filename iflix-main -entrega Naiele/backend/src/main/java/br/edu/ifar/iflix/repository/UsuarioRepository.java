package br.edu.ifar.iflix.repository;

import br.edu.ifar.iflix.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//
@Repository 
public interface UsuarioRepository
    extends JpaRepository <Usuario, Integer>{

    }
    
