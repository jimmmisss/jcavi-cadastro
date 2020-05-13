package com.jcavi.cadastro.entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "jcavi_pagamento_cartao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeName("pagamentoCartao")
public class PagamentoComCartao extends Pagamento {

    private final static long serialVersionUID = 7234060734381295353L;

    private Integer numeroDeParcelas;

}
