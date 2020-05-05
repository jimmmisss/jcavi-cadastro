package com.jcavi.cadastro.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "jcavi_categoria")
public class Categoria implements Serializable {

    private static final long serialVersionUID = 3488703549102717354L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @JsonIgnore
    @ManyToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Produto> produto;

    public Categoria() {
    }

    public Categoria(Long id, String nome, List<Produto> produto) {
        this.id = id;
        this.nome = nome;
        this.produto = produto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produto> getProduto() {
        return produto;
    }

    public void setProduto(List<Produto> produto) {
        this.produto = produto;
    }
}
