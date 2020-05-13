package com.jcavi.cadastro.service;

import com.jcavi.cadastro.entity.Pedido;
import com.jcavi.cadastro.repository.PedidoRepository;
import com.jcavi.cadastro.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido buscarPorId(Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        return pedido.orElseThrow(() -> new ObjectNotFoundException("Pedido não encontrado: " + id));
    }

}
