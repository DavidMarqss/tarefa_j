package application.repository;

import org.springframework.data.repository.CrudRepository;

import application.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    public Usuario findByNomeUser(String nomeUser);
}
