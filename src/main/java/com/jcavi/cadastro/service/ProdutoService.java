package com.jcavi.cadastro.service;

import com.jcavi.cadastro.entity.Produto;
import com.jcavi.cadastro.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> retornaTodosProdutos() {
        return produtoRepository.findAll();
    }

    public void salvarProduto(Produto produto) {
        produtoRepository.save(produto);
    }

    public void atualizarProduto(Produto produto, Integer id) {
        Optional<Produto> produtoRetornadoDoBanco = produtoRepository.findById(id);
        if (produtoRetornadoDoBanco.isPresent()) {
            produto.setId(id);
            produtoRepository.save(produto);
        }
    }

    public void deletarProduto(Integer id) {
        produtoRepository.deleteById(id);
    }

}
