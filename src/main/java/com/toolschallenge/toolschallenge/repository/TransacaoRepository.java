package com.toolschallenge.toolschallenge.repository;

import com.toolschallenge.toolschallenge.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}