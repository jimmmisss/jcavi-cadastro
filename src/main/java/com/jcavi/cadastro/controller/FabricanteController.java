package com.jcavi.cadastro.controller;

import com.jcavi.cadastro.dto.FabricanteDto;
import com.jcavi.cadastro.service.FabricanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class FabricanteController {

    private final FabricanteService fabricanteService;

    @Autowired
    public FabricanteController(FabricanteService fabricanteService) {
        this.fabricanteService = fabricanteService;
    }

    @GetMapping("/fabricantes")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<FabricanteDto> listar() {
        return fabricanteService.listar();
    }

    @PostMapping("/fabricante")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody FabricanteDto fabricanteDto) {
        fabricanteService.salvar(fabricanteDto);
    }

    @PutMapping("/fabricante/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void alterar(@RequestBody FabricanteDto fabricanteDto, @PathVariable Long id) {
        fabricanteService.alterar(fabricanteDto, id);
    }

    @DeleteMapping("/fabricante/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(Long id) {
        fabricanteService.deletar(id);
    }

}
