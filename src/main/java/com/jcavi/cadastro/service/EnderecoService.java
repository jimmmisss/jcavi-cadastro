package com.jcavi.cadastro.service;

import com.jcavi.cadastro.dto.EnderecoDto;
import com.jcavi.cadastro.entity.Endereco;
import com.jcavi.cadastro.mapper.Mappable;
import com.jcavi.cadastro.repository.EnderecoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService implements Mappable {

    private final EnderecoRepository enderecoRepository;
    private final ModelMapper mapper;

    @Autowired
    public EnderecoService(EnderecoRepository enderecoRepository, ModelMapper mapper) {
        this.enderecoRepository = enderecoRepository;
        this.mapper = mapper;
    }

    public void salvar(List<EnderecoDto> enderecoDto) {
        for (EnderecoDto e: enderecoDto) {
            Endereco endereco = map(e, Endereco.class);
            enderecoRepository.save(endereco);
        }
    }

    @Override
    public ModelMapper mapper() {
        return this.mapper;
    }
}
