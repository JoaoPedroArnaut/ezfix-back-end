package br.com.ezfix.api.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Usuarios implements UserDetails {

	@Id
	private String email;
	@NotNull
	private String senha;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Perfis> perfis = new ArrayList<>();

	public Usuarios(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}

	public Usuarios() {
	}

	public String getEmail() {
		return email;
	}

	public List<Perfis> getPerfis() {
		return perfis;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.perfis;
	}

	@Override
	public String getPassword() {
		return this.senha;
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
