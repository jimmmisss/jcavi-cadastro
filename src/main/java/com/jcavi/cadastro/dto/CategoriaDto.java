package com.jcavi.cadastro.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDto implements Serializable {

    private static final long serialVersionUID = -5133773057574260722L;

    private Long id;
    private String nome;
    private List<ProdutoDto> produtos = new ArrayList<>();

}
