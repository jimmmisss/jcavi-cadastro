package com.jcavi.cadastro.security;

import com.jcavi.cadastro.entity.Funcao;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserSS implements UserDetails {

    private static final long serialVersionUID = -1073550158269878100L;

    private Long id;
    private String email;
    private String senha;
    private Collection<? extends GrantedAuthority> authorities;

    public UserSS() {
    }

    public UserSS(Long id, String email, String senha, List<Funcao> funcoes) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.authorities = funcoes.stream().map(x -> new SimpleGrantedAuthority(x.getNome())).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Boolean hasRole(Funcao funcao) {
        return getAuthorities().contains(new SimpleGrantedAuthority(funcao.getNome()));
    }

}
