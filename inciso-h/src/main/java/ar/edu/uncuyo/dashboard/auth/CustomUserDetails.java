package ar.edu.uncuyo.dashboard.auth;

import ar.edu.uncuyo.dashboard.entity.Usuario;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {

    @Getter private final Long id;
    @Getter private final Long mecanicoId;
    private final String email;
    private final String clave;

    public CustomUserDetails(Long userId, Long mecanicoId, String email, String clave) {
        this.id = userId;
        this.mecanicoId = mecanicoId;
        this.email = email;
        this.clave = clave;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { return List.of(); }

    @Override
    public String getPassword() {
        return this.clave;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}