package com.jcavi.cadastro.service;

import com.jcavi.cadastro.entity.Usuario;
import com.jcavi.cadastro.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Objects;

@Configuration
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioService usuarioService;

    @Autowired
    public UserDetailsServiceImpl(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Usuario usuario = usuarioService.buscaPorEmail(email);

        if (Objects.isNull(usuario)) {
            throw new UsernameNotFoundException("Usuário não existe");
        }

        return new UserSS(usuario.getId(), usuario.getEmail(), usuario.getSenha(), usuario.getFuncoes());

    }

}
