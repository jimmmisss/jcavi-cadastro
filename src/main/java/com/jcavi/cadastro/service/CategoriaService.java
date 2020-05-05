package com.jcavi.cadastro.service;

import com.jcavi.cadastro.dto.CategoriaDto;
import com.jcavi.cadastro.entity.Categoria;
import com.jcavi.cadastro.mapper.Mappable;
import com.jcavi.cadastro.repository.CategoriaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaService implements Mappable {

    private final CategoriaRepository categoriaRepository;
    private final ModelMapper mapper;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository, ModelMapper mapper) {
        this.categoriaRepository = categoriaRepository;
        this.mapper = mapper;
    }

    public List<CategoriaDto> listar() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return categorias.stream().map(m -> map(m, CategoriaDto.class)).collect(Collectors.toList());
    }

    public void salvar(CategoriaDto categoriaDto) {
        Categoria categoria = map(categoriaDto, Categoria.class);
        categoriaRepository.save(categoria);
    }

    public void alterar(CategoriaDto categoriaDto, Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if (categoria.isPresent()) {
            categoriaDto.setId(id);
            categoriaRepository.save(map(categoriaDto, Categoria.class));
        }
    }

    public void deletar(Long id) {
        categoriaRepository.deleteById(id);
    }

    @Override
    public ModelMapper mapper() {
        return this.mapper;
    }
}
