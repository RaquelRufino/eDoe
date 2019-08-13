package com.e.doe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.e.doe.models.Doacao;

public interface DoacaoRepository extends JpaRepository<Doacao, Long> {

	Doacao findById(long id);
}
