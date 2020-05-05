package com.jcavi.cadastro.dto;

import java.util.List;

public class FabricanteDto {

    private Long id;
    private String nome;
    private List<ProdutoDto> produto;

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

    public List<ProdutoDto> getProduto() {
        return produto;
    }

    public void setProduto(List<ProdutoDto> produto) {
        this.produto = produto;
    }
}
