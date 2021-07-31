package br.com.orangetalents.orangeTalents.controller;

import java.net.URI;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.orangetalents.orangeTalents.model.Endereco;
import br.com.orangetalents.orangeTalents.model.dto.EnderecoRequest;
import br.com.orangetalents.orangeTalents.model.dto.EnderecoResponse;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	
	@PersistenceContext
	private EntityManager m;
	
	@PostMapping
	@Transactional
	public ResponseEntity<EnderecoResponse> cadastrarEndereco(@RequestBody @Valid EnderecoRequest request,
			UriComponentsBuilder uriBuilder) {
		Endereco endereco = request.converter(m);
		m.persist(endereco);
		URI uri = uriBuilder.path("/endereco/{id}").buildAndExpand(endereco.getId()).toUri();
		return ResponseEntity.created(uri).body(new EnderecoResponse(endereco));
	}
}
