package com.jcavi.cadastro.controller;

import com.jcavi.cadastro.dto.CategoriaDto;
import com.jcavi.cadastro.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/categorias")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<CategoriaDto> listar() {
        return categoriaService.listar();
    }

    @PostMapping("/categoria")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody CategoriaDto categoriaDto) {
        categoriaService.salvar(categoriaDto);
    }

    @PutMapping("/categoria/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void alterar(@RequestBody CategoriaDto categoriaDto, @PathVariable Long id) {
        categoriaService.alterar(categoriaDto, id);
    }

    @DeleteMapping("/categoria/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(Long id) {
        categoriaService.deletar(id);
    }

}
