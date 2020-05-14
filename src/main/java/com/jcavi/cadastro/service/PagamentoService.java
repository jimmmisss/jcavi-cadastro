package com.jcavi.cadastro.service;

import com.jcavi.cadastro.entity.Pagamento;
import com.jcavi.cadastro.repository.PagamentoRepository;
import com.jcavi.cadastro.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;

    @Autowired
    public PagamentoService(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    public Pagamento buscarPorId(Long id) {
        Optional<Pagamento> pagamento = pagamentoRepository.findById(id);
        return pagamento.orElseThrow(() -> new ObjectNotFoundException("Pagamento não encontrado: " + id));
    }

    public void salvar(Pagamento pagamento) {
        pagamentoRepository.save(pagamento);
    }
}
