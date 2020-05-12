package com.jcavi.cadastro.controller;

import com.jcavi.cadastro.dto.FabricanteDto;
import com.jcavi.cadastro.service.FabricanteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "API REST - Fabricante")
@RestController
@RequestMapping("/v1")
public class FabricanteController {

    private final FabricanteService fabricanteService;

    @Autowired
    public FabricanteController(FabricanteService fabricanteService) {
        this.fabricanteService = fabricanteService;
    }

    @ApiOperation(value = "Lista um fabricante", authorizations = { @Authorization(value = "jwtToken")})
    @PreAuthorize("hasAnyRole('USER')")
    @GetMapping("/fabricante/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public FabricanteDto buscarPorId(@PathVariable Long id) {
        return fabricanteService.buscarPorId(id);
    }

    @ApiOperation(value = "Lista fabricantes", authorizations = { @Authorization(value = "jwtToken")})
    @PreAuthorize("hasAnyRole('USER')")
    @GetMapping("/fabricantes")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<FabricanteDto> listar() {
        return fabricanteService.listar();
    }

    @ApiOperation(value = "Salvar um fabricante", authorizations = { @Authorization(value = "jwtToken")})
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/fabricante")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody FabricanteDto fabricanteDto) {
        fabricanteService.salvar(fabricanteDto);
    }

    @ApiOperation(value = "Atualizar um fabricante", authorizations = { @Authorization(value = "jwtToken")})
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/fabricante/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void alterar(@RequestBody FabricanteDto fabricanteDto, @PathVariable Long id) {
        fabricanteService.alterar(fabricanteDto, id);
    }

    @ApiOperation(value = "Deletar", authorizations = { @Authorization(value = "jwtToken")})
    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/fabricante/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(Long id) {
        fabricanteService.deletar(id);
    }

}
