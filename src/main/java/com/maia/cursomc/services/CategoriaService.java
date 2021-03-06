package com.maia.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maia.cursomc.domain.Categoria;
import com.maia.cursomc.repositores.CategoriaRepository;
import com.maia.cursomc.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired // instanciando o Categoria Service
	private CategoriaRepository repository;

	// metodo para BusarPor ID com SpringDataJPA
	public Categoria busbar(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto Não Encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

}
