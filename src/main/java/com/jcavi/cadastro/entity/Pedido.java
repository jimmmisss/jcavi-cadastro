package com.jcavi.cadastro.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "jcavi_pedido")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pedido implements Serializable {

    private static final long serialVersionUID = -8556272870602881632L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
    private Pagamento pagamento;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "id.pedido")
    private Set<ItemPedido> itens = new HashSet<>();

    public Double getValorTotal() {
        Double soma = 0.0;
        for (ItemPedido ip: itens) {
            soma = soma + ip.getSubTotal();
        }
        return soma;
    }

}















