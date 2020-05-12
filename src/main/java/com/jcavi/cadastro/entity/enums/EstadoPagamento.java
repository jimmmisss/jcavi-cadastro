package com.jcavi.cadastro.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum EstadoPagamento {

    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3, "Cancelado");

    @Getter
    private Integer codigo;

    @Getter
    private String descricao;

    public static EstadoPagamento toEnum(Integer codigo) {
        if (codigo == null) {
            return null;
        }

        for (EstadoPagamento x : EstadoPagamento.values()) {
            if (codigo.equals(x.getCodigo())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Código inválido: " + codigo);
    }

}
