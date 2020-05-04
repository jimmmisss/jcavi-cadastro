package com.jcavi.cadastro.controller;

import com.jcavi.cadastro.dto.ProdutoDto;
import com.jcavi.cadastro.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/produtos")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<ProdutoDto> listarProdutos() {
        return produtoService.listar();
    }

    @PostMapping("/produto")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void salvarProdutos(@RequestBody ProdutoDto produtoDto) {
        produtoService.salvar(produtoDto);
    }

    @PutMapping("/alterar-produto/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void alterarProduto(@RequestBody ProdutoDto produtoDto, @PathVariable Long id) {
        produtoService.atualizar(produtoDto, id);
    }

    @DeleteMapping("/deletar-produto/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarProduto(@PathVariable Long id) {
        produtoService.deletar(id);
    }

}
