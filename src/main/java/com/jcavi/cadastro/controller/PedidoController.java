package com.jcavi.cadastro.controller;

import com.jcavi.cadastro.entity.Pedido;
import com.jcavi.cadastro.service.PedidoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Api(value = "API REST - Pedido")
@RestController
@RequestMapping("/v1")
public class PedidoController {

    private final PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @ApiOperation(value = "Busca pedido por id", authorizations = {@Authorization(value = "jwtToken")})
    @PreAuthorize("hasAnyRole('USER')")
    @GetMapping("/pedido/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Pedido buscaPorId(@PathVariable Long id) {
        return pedidoService.buscarPorId(id);
    }

    @ApiOperation(value = "Salvar pedido", authorizations = { @Authorization(value = "jwtToken")})
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/pedido")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido salvar(@RequestBody Pedido pedido) {
        return pedidoService.salvar(pedido);
    }

}
