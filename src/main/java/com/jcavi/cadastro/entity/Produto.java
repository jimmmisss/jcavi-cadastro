package com.jcavi.cadastro.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "jcavi_produto")
public class Produto implements Serializable {

    private static final long serialVersionUID = -613979741419635077L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo nome é obrigatório")
    private String nome;
    private String descricao;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "fabricante")
    private Fabricante fabricante;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "produto_categoria",
            joinColumns = @JoinColumn(name = "produto"),
            inverseJoinColumns = @JoinColumn(name = "categoria")
    )
    private List<Categoria> categorias = new ArrayList<>();

}
