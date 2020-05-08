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
public class CredenciaisDto implements Serializable {

    private static final long serialVersionUID = 5092213479646158988L;

    private String email;
    private String senha;

}
