package com.atividade.br.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atividade.br.domain.Social;
import com.atividade.br.repositories.SocialRepository;
import com.atividade.br.service.exceptions.ObjectNotFoundException;

@Service
public class AtividadeService {
	
	@Autowired
	private SocialRepository repo;
	
	public List<Social> listarTodos() {
		return repo.findAll();
	}
	
	public Social buscarPorId(Integer id) {
		Optional<Social> obj = repo.findById(id);
		return obj.orElseThrow( 
				() -> new ObjectNotFoundException(
						"Tarefa não encontrada"));
	}
	
	public void delete(Integer id) {
		buscarPorId(id);
		repo.deleteById(id);
	}
	
	public void update(Social obj) {
		buscarPorId(obj.getId());
		repo.save(obj);
	}

	public void insert(Social obj) {
		obj.setId(null);
		repo.save(obj);
	}
	
	

}
