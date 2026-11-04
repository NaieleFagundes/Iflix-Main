package br.edu.ifar.iflix.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
public class Avaliacao {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int idAvaliacao;
    @Column(nullable = false)
    private int nota;
    @Column(length = 2000)
    private String comentario;
    @Column(nullable = false)
    private LocalDateTime data;
    @ManyToOne
    @JoinColumn(nullable = false, name = "id_usuario")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(nullable = false, name = "id_midia")
    private Midia midia;
}

