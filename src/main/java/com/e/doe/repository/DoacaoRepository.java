package com.e.doe.repository;

import com.e.doe.models.Doacao;

public interface DoacaoRepository {

	Doacao findById(long id);
}
