package com.jcavi.cadastro.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "jcavi_pagamento_boleto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoComBoleto extends Pagamento {

    private static final long serialVersionUID = 2453310495668094746L;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataVencimento;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataPagamento;

}
