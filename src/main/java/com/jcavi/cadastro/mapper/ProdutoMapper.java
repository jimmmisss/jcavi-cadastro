package com.jcavi.cadastro.mapper;

import com.jcavi.cadastro.dto.ProdutoDto;
import com.jcavi.cadastro.entity.Produto;

@Deprecated
public class ProdutoMapper {

    private ProdutoMapper() {
        super();
    }

    public static Produto toEntity(ProdutoDto produtoDto) {
        Produto produto = new Produto();
        produto.setId(produtoDto.getId());
        produto.setNome(produtoDto.getNome());
        produto.setDescricao(produtoDto.getDescricao());
//        produto.setFabricante(produtoDto.getFabricante());
        return produto;
    }

    public static ProdutoDto toDto(Produto produto) {
        ProdutoDto produtoDto = new ProdutoDto();
        produtoDto.setId(produto.getId());
        produtoDto.setNome(produto.getNome());
        produtoDto.setDescricao(produto.getDescricao());
//        produtoDto.setFabricante(produto.getFabricante());
        return produtoDto;
    }

}
