package com.jcavi.cadastro.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "jcavi_usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1647035985255564511L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo nome é obrigatório")
    private String nome;

    @NotNull
    @Email(message = "Email precisa ser válido")
    private String email;

    @Size(min = 6, max = 12, message = "Senha deve ter no mínimo 6 caracteres e no máxmo 12")
    @NotBlank(message = "Senha é obrigatório")
    private String senha;
    private String profissao;
    private Double salario;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "usuario_funcao",
            joinColumns = @JoinColumn(name = "usuario"),
            inverseJoinColumns = @JoinColumn(name = "funcao")
    )
    private List<Funcao> funcoes = new ArrayList<>();

}