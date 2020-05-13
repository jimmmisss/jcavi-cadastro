package com.jcavi.cadastro.config;

import com.jcavi.cadastro.security.JWTAuthenticantionFilter;
import com.jcavi.cadastro.security.JWTAuthorizationFilter;
import com.jcavi.cadastro.security.JWTUtil;
import com.jcavi.cadastro.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JWTUtil jwtUtil;

    public static final String[] PUBLICS_MATCHERS = {
            "/h2-console/**",
            "/v2/api-docs/**",
            "/swagger-ui.html",
            "/swagger-ui/**",
            "/webjars/springfox-swagger-ui/**",
            "/swagger-resources/**"
    };

    public static final String[] PUBLICS_ROUTES_GET = {
            "/v1/categorias/**",
            "/v1/fabricantes/**",
            "/v1/produtos/**",
            "/v1/funcoes/**",
            "/v1/usuarios/**"
    };

    public static final String[] PUBLICS_ROUTES_POST = {
            "/v1/categoria/**",
            "/v1/fabricante/**",
            "/v1/produto/**",
            "/v1/funcao/**",
            "/v1/usuario/**"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();
        http.cors().and().csrf().disable();
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, PUBLICS_ROUTES_GET).permitAll()
                .antMatchers(HttpMethod.POST, PUBLICS_ROUTES_POST).permitAll()
                .antMatchers(PUBLICS_MATCHERS).permitAll()
                .anyRequest().authenticated();
        http.addFilter(new JWTAuthenticantionFilter(authenticationManager(), jwtUtil));
        http.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtUtil, userDetailsService));
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCrypt());
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
        configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public BCryptPasswordEncoder bCrypt() {
        return new BCryptPasswordEncoder();
    }

}
