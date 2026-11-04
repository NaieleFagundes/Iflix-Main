package br.edu.ifar.iflix.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Categoria {
   @Id
   @GeneratedValue(strategy =  GenerationType.IDENTITY)
   private int idCategoria;
   @Column(nullable = false, unique = true, length = 100)
   private String nome;
}
