package com.jcavi.cadastro.dto;

import com.jcavi.cadastro.entity.Endereco;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioDto implements Serializable {

    private static final long serialVersionUID = 1647035985255564511L;

    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String profissao;
    private Double salario;
    private List<EnderecoDto> enderecos = new ArrayList<>();
    private List<FuncaoDto> funcoes = new ArrayList<>();

}
