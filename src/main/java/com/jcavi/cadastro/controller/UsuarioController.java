package com.jcavi.cadastro.controller;

import com.jcavi.cadastro.dto.UsuarioDto;
import com.jcavi.cadastro.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/usuarios")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioDto> listar() {
        return usuarioService.listar();
    }

    @PostMapping("/usuario")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody UsuarioDto usuarioDto) {
        usuarioService.salvar(usuarioDto);
    }

    @PutMapping("/usuario/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void alterar(@RequestBody UsuarioDto usuarioDto, @PathVariable Long id) {
        usuarioService.alterar(usuarioDto, id);
    }

    @DeleteMapping("/usuario/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(Long id) {
        usuarioService.deletar(id);
    }

}
