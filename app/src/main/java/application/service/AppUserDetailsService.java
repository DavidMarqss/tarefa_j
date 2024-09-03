package application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import application.model.Usuario;
import application.repository.UsuarioRepository;

@Service
public class AppUserDetailsService implements UserDetailsService{
    @Autowired
    private UsuarioRepository usuarioRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepo.findByNomeUser(username);
        if(usuario == null){
            throw new UsernameNotFoundException("Usuario não encontrado");
        }
        UserDetails detalhesDoUsuario = 
            org.springframework.security.core.userdetails.User.builder()
                .username(usuario.getNomeUser())
                .password(usuario.getSenha())
                .roles("USER")
                .build();

        return detalhesDoUsuario;
    }
    
}
