package com.e.doe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.e.doe.models.Doacao;

@Repository("doacaoRepository")
public interface DoacaoRepository extends JpaRepository<Doacao, Long> {

	Doacao findById(long id);
}
