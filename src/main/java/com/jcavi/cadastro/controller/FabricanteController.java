package com.jcavi.cadastro.controller;

import com.jcavi.cadastro.dto.FabricanteDto;
import com.jcavi.cadastro.service.FabricanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasAnyRole('USER')")
    @GetMapping("/fabricante/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public FabricanteDto buscarPorId(@PathVariable Long id) {
        return fabricanteService.buscarPorId(id);
    }

    @PreAuthorize("hasAnyRole('USER')")
    @GetMapping("/fabricantes")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<FabricanteDto> listar() {
        return fabricanteService.listar();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/fabricante")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody FabricanteDto fabricanteDto) {
        fabricanteService.salvar(fabricanteDto);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/fabricante/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void alterar(@RequestBody FabricanteDto fabricanteDto, @PathVariable Long id) {
        fabricanteService.alterar(fabricanteDto, id);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/fabricante/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(Long id) {
        fabricanteService.deletar(id);
    }

}
