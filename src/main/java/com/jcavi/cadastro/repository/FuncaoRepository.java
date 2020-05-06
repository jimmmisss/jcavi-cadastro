package com.jcavi.cadastro.repository;

import com.jcavi.cadastro.entity.Funcao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncaoRepository extends JpaRepository<Funcao, Long> {
}
