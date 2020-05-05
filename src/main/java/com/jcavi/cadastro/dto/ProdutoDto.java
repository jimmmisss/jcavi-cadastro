package com.jcavi.cadastro.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ProdutoDto implements Serializable {

    private static final long serialVersionUID = -8848293829242239180L;

    private Long id;
    private String nome;
    private String descricao;
    private LocalDateTime dataChegada;
    private FabricanteDto fabricante;
    private List<CategoriaDto> categoria = new ArrayList<>();

}
