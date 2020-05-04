package com.jcavi.cadastro.service;

import com.jcavi.cadastro.dto.ProdutoDto;
import com.jcavi.cadastro.entity.Produto;
import com.jcavi.cadastro.mapper.ProdutoMapper;
import com.jcavi.cadastro.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoDto> listar() {
        List<Produto> produtos = produtoRepository.findAll();
        return produtos.stream().map(ProdutoMapper::toDto).collect(Collectors.toList());
    }

    public void salvar(ProdutoDto produtoDto) {
        Produto produto = ProdutoMapper.toEntity(produtoDto);
        produtoRepository.save(produto);
    }

    public void atualizar(ProdutoDto produtoDto, Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isPresent()) {
            produtoDto.setId(id);
            Produto produtoMapper = ProdutoMapper.toEntity(produtoDto);
            produtoRepository.save(produtoMapper);
        }
    }

    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }

}
