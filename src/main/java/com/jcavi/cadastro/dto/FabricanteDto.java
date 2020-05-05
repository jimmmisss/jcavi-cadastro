package com.jcavi.cadastro.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class FabricanteDto implements Serializable {

    private static final long serialVersionUID = -3913429238652250638L;

    private Long id;
    private String nome;
    private List<ProdutoDto> produto;

}
