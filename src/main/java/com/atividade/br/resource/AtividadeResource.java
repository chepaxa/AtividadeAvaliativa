package com.atividade.br.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atividade.br.domain.Social;
import com.atividade.br.service.AtividadeService;

@Service
public class AtividadeResource {

	@Autowired
	private AtividadeService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Social>> listarTodos() {
		List<Social> lista = service.listarTodos();
		return ResponseEntity.ok(lista);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Social> buscar(@PathVariable Integer id) {
		Social obj = service.buscarPorId(id); 
		return ResponseEntity.ok(obj);
	}

	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		service.delete(id); 
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Social obj,
			@PathVariable Integer id) {
		obj.setId(id);
		service.update(obj); 
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Social obj) {
		service.insert(obj); 
		return ResponseEntity.noContent().build();
	}
	
	
}
