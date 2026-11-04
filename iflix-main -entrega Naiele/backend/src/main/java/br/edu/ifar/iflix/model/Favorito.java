package br.edu.ifar.iflix.model;

import jakarta.persistence.*;

@Entity
public class Favorito {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int idFavorito;
    @ManyToOne
    @JoinColumn(nullable = false, name = "id_usuario")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(nullable = false, name = "id_midia")
    private Midia midia;
}
