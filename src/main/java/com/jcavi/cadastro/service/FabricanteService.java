package com.jcavi.cadastro.service;

import com.jcavi.cadastro.dto.FabricanteDto;
import com.jcavi.cadastro.entity.Fabricante;
import com.jcavi.cadastro.mapper.Mappable;
import com.jcavi.cadastro.repository.FabricanteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FabricanteService implements Mappable {

    private final FabricanteRepository fabricanteRepository;
    private final ModelMapper mapper;

    @Autowired
    public FabricanteService(FabricanteRepository fabricanteRepository, ModelMapper mapper) {
        this.fabricanteRepository = fabricanteRepository;
        this.mapper = mapper;
    }

    public List<FabricanteDto> listar() {
        List<Fabricante> fabricantes = fabricanteRepository.findAll();
        return fabricantes.stream().map(m -> map(m, FabricanteDto.class)).collect(Collectors.toList());
    }

    public void salvar(FabricanteDto fabricanteDto) {
        Fabricante fabricante = map(fabricanteDto, Fabricante.class);
        fabricanteRepository.save(fabricante);
    }

    public void alterar(FabricanteDto fabricanteDto, Long id) {
        Optional<Fabricante> fabricante = fabricanteRepository.findById(id);
        if (fabricante.isPresent()) {
            fabricanteDto.setId(id);
            fabricanteRepository.save(map(fabricanteDto, Fabricante.class));
        }
    }

    public void deletar(Long id) {
        fabricanteRepository.deleteById(id);
    }

    @Override
    public ModelMapper mapper() {
        return this.mapper;
    }
}
