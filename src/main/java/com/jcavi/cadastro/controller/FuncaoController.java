package com.jcavi.cadastro.controller;

import com.jcavi.cadastro.dto.FuncaoDto;
import com.jcavi.cadastro.service.FuncaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class FuncaoController {

    private final FuncaoService funcaoService;

    @Autowired
    public FuncaoController(FuncaoService funcaoService) {
        this.funcaoService = funcaoService;
    }

    @GetMapping("/funcoes")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<FuncaoDto> listar() {
        return funcaoService.listar();
    }

    @PostMapping("/funcao")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody FuncaoDto funcaoDto) {
        funcaoService.salvar(funcaoDto);
    }

    @PutMapping("/funcao/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void alterar(@RequestBody FuncaoDto funcaoDto, @PathVariable Long id) {
        funcaoService.alterar(funcaoDto, id);
    }

    @DeleteMapping("/funcao/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(Long id) {
        funcaoService.deletar(id);
    }

}
