package br.com.orangetalents.orangeTalents.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.orangetalents.orangeTalents.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Boolean existsByEmail(String email);
	Boolean existsByCpf(String cpf);

}
