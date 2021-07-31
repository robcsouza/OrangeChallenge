package br.com.orangetalents.orangeTalents.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.orangetalents.orangeTalents.model.Usuario;
import br.com.orangetalents.orangeTalents.model.dto.UsuarioDetalheResponse;
import br.com.orangetalents.orangeTalents.model.dto.UsuarioRequest;
import br.com.orangetalents.orangeTalents.model.dto.UsuarioResponse;
import br.com.orangetalents.orangeTalents.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired //Gera injeção de dependências
	private UsuarioRepository repository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<UsuarioResponse> cadastrarUsuario(@RequestBody @Valid UsuarioRequest request,
			UriComponentsBuilder uriBuilder){
		if(repository.existsByEmail(request.getEmail())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este e-mail já existe no cadastro.");
		}
		
		if(repository.existsByCpf(request.getCpf())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este CPF já existe no cadastro.");
		}
		
		Usuario usuario = request.converter();
		repository.save(usuario);
		URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(new UsuarioResponse(usuario));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDetalheResponse> consultarUsuario(@PathVariable Long id) {
		Optional<Usuario> usuario = repository.findById(id);
		if(usuario.isPresent()) {
			return ResponseEntity.ok(new UsuarioDetalheResponse(usuario.get()));
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não foi encontrado");
	}
	
}
