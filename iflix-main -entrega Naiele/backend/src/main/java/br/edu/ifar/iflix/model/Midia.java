package br.edu.ifar.iflix.model;

import jakarta.persistence.*;

@Entity
public class Midia {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int idMidia;
    @Column(nullable = false, length = 500)
    private String nome;
    @Column(length = 2000)
    private String descricao;
    @Column(nullable = false)
    private int duracao; // em minutos
    @ManyToOne
    @JoinColumn(nullable = false, name = "id_categoria")
    private Categoria categoria;
}
