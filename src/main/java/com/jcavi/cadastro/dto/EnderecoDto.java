package com.jcavi.cadastro.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EnderecoDto implements Serializable {

    private static final long serialVersionUID = -3559341939461300724L;

    private Long id;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    private UsuarioDto usuario;

}
