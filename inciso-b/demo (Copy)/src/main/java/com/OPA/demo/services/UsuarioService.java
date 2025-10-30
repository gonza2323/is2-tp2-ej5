package com.OPA.demo.services;

import com.OPA.demo.entities.UserEntity;
import com.OPA.demo.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService implements UserDetailsService {

    private final UserRepository userRepository;

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> findByMail(String mail) {
        return userRepository.findByUsername(mail);
    }

    @Transactional
    public UserEntity save(UserEntity usuario) {

        //falta las validaciones
        return userRepository.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<UserEntity> userEntity = userRepository.getEmail(email);

        if (!userEntity.isEmpty()) {

            List<GrantedAuthority> permisos = new ArrayList<>();

            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" + userEntity.get().getRol().name());

            permisos.add(p);

            return new User(userEntity.get().getUsername(), userEntity.get().getPassword(), permisos);
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

    }
}
