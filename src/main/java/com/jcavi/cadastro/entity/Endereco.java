package com.jcavi.cadastro.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "jcavi_endereco")
public class Endereco implements Serializable {

    private static final long serialVersionUID = 3488703549102717354L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

}
