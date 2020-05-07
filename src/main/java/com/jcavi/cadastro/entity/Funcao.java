package com.jcavi.cadastro.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "jcavi_funcao")
public class Funcao implements Serializable {

    private static final long serialVersionUID = 1647035985255564511L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToMany(mappedBy = "funcoes", cascade = CascadeType.ALL)
    private List<Usuario> usuarios = new ArrayList<>();

}
