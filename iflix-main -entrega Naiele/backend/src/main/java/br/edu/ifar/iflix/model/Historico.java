package br.edu.ifar.iflix.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Historico {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int idHistorico;
    @Column(nullable = false)
    private LocalDateTime data;
    private int tempo;
    @ManyToOne
    @JoinColumn(nullable = false, name = "id_usuario")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(nullable = false, name = "id_midia")
    private Midia midia;
}
