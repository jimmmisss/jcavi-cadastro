package com.jcavi.cadastro.service;

import com.jcavi.cadastro.dto.UsuarioDto;
import com.jcavi.cadastro.entity.Usuario;
import com.jcavi.cadastro.mapper.Mappable;
import com.jcavi.cadastro.security.UserSS;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Objects;

@Configuration
public class UserDetailsServiceImpl implements UserDetailsService, Mappable {

    private final UsuarioService usuarioService;
    private final ModelMapper mapper;

    @Autowired
    public UserDetailsServiceImpl(UsuarioService usuarioService, ModelMapper mapper) {
        this.usuarioService = usuarioService;
        this.mapper = mapper;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Usuario usuario = usuarioService.buscaPorEmail(email);

        if (Objects.isNull(usuario)) {
            throw new UsernameNotFoundException("Usuário não existe");
        }

        return new UserSS(usuario.getId(), usuario.getEmail(), usuario.getSenha(), usuario.getFuncoes());

    }

    @Override
    public ModelMapper mapper() {
        return mapper;
    }
}
