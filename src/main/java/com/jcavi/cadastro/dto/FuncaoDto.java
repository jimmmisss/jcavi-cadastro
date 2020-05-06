package com.jcavi.cadastro.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FuncaoDto implements Serializable {

    private static final long serialVersionUID = 1647035985255564511L;

    private Long id;
    private String nome;
    private List<UsuarioDto> usuarios = new ArrayList<>();

}
