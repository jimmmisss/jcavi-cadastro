package com.jcavi.cadastro.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CategoriaDto implements Serializable {

    private static final long serialVersionUID = -5133773057574260722L;

    private Long id;
    private String nome;
    private List<ProdutoDto> produto = new ArrayList<>();

}
