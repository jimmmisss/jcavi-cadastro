package com.jcavi.cadastro.service;

import com.jcavi.cadastro.dto.CategoriaDto;
import com.jcavi.cadastro.dto.FuncaoDto;
import com.jcavi.cadastro.entity.Categoria;
import com.jcavi.cadastro.entity.Funcao;
import com.jcavi.cadastro.mapper.Mappable;
import com.jcavi.cadastro.repository.FuncaoRepository;
import com.jcavi.cadastro.service.exception.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncaoService implements Mappable {

    private final FuncaoRepository funcaoRepository;
    private final ModelMapper mapper;

    @Autowired
    public FuncaoService(FuncaoRepository funcaoRepository, ModelMapper mapper) {
        this.funcaoRepository = funcaoRepository;
        this.mapper = mapper;
    }

    public FuncaoDto buscarPorId(Long id) {
        Optional<Funcao> funcao = funcaoRepository.findById(id);
        Funcao func = funcao.orElseThrow(() -> new ObjectNotFoundException("Nenhuma categoria encontrada: " + id));
        return map(func, FuncaoDto.class);
    }

    public List<FuncaoDto> listar() {
        List<Funcao> funcaos = funcaoRepository.findAll();
        return funcaos.stream().map(m -> map(m, FuncaoDto.class)).collect(Collectors.toList());
    }

    public void salvar(FuncaoDto funcaoDto) {
        Funcao funcao = map(funcaoDto, Funcao.class);
        funcaoRepository.save(funcao);
    }

    public void alterar(FuncaoDto funcaoDto, Long id) {
        Optional<Funcao> funcao = funcaoRepository.findById(id);
        if (funcao.isPresent()) {
            funcaoDto.setId(id);
            funcaoRepository.save(map(funcaoDto, Funcao.class));
        }
    }

    public void deletar(Long id) {
        funcaoRepository.deleteById(id);
    }

    @Override
    public ModelMapper mapper() {
        return this.mapper;
    }
}
