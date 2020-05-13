package com.jcavi.cadastro.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.jcavi.cadastro.entity.enums.EstadoPagamento;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "jcavi_pagamento")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
public abstract class Pagamento implements Serializable {

    private static final long serialVersionUID = -8556272870602881632L;

    @Id
    @EqualsAndHashCode.Include()
    private Long id;
    private Integer estado;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "id_pedido")
    @MapsId
    private Pedido pedido;

    public Pagamento() {
    }

    public Pagamento(Long id, EstadoPagamento estado, Pedido pedido) {
        super();
        this.id = id;
        this.estado = (estado == null) ? null : estado.getCodigo();
        this.pedido = pedido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EstadoPagamento getEstado() {
        return EstadoPagamento.toEnum(estado);
    }

    public void setEstado(EstadoPagamento estado) {
        this.estado = estado.getCodigo();
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}

