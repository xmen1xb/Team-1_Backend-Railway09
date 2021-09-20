package com.vti.repository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vti.entity.Account;

public class LoginUserDetail implements UserDetails {

	private static final long serialVersionUID = 1L;

	private int id;

	private String username;

	private String email;

	@JsonIgnore
	private String password;

	private String role;

	private Collection<? extends GrantedAuthority> authorities;

	public LoginUserDetail(int id, String username, String email, String password, String role,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
		this.authorities = authorities;
	}

	public static LoginUserDetail create(Account account) {

		String userRole = account.getRole().name();

		List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + userRole));

		return new LoginUserDetail(account.getAccountId(), account.getUsername(), account.getEmail(), account.getPassword(),
				userRole, authorities);

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return authorities;
	}

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getRole() {
		return role;
	}

	@Override
	public String getPassword() {

		return password;
	}

	@Override
	public String getUsername() {

		return username;
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
