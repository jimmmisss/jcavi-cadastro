package com.jcavi.cadastro.dto;

import java.time.LocalDateTime;

public class ProdutoDto {

    private Long id;
    private String nome;
    private String descricao;
    private LocalDateTime dataChegada;
    private FabricanteDto fabricante;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(LocalDateTime dataChegada) {
        this.dataChegada = dataChegada;
    }

    public FabricanteDto getFabricante() {
        return fabricante;
    }

    public void setFabricante(FabricanteDto fabricante) {
        this.fabricante = fabricante;
    }
}
