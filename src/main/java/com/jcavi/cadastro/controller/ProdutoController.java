package com.jcavi.cadastro.controller;

import com.jcavi.cadastro.entity.Produto;
import com.jcavi.cadastro.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/produtos")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> listarProdutos() {
        return produtoService.retornaTodosProdutos();
    }

    @PostMapping("/produto")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void salvarProdutos(Produto produto) {
        produtoService.salvarProduto(produto);
    }

    @PutMapping("/alterar-produto/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void alterarProduto(Produto produto, @PathVariable Integer id) {
        produtoService.atualizarProduto(produto, id);
    }

    @DeleteMapping("/deletar-produto/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarProduto(@PathVariable Integer id) {
        produtoService.deletarProduto(id);
    }

}
