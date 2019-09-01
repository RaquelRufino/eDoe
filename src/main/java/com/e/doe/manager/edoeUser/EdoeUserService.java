package com.e.doe.manager.edoeUser;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.e.doe.manager.utils.RoleConstants;

@Component
public class EdoeUserService implements UserDetailsService{
	
	@Autowired
	private EdoeUserRepository edoeUserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		EdoeUser edoeUser = edoeUserRepository.findByUsername(username);
		
		List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList(
				RoleConstants.ROLE_USER, 
				RoleConstants.ROLE_ADMIN);
		List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList(RoleConstants.ROLE_USER);
		return new org.springframework.security.core.userdetails.User(
				edoeUser.getUsername(),
				edoeUser.getPassword(),
				edoeUser.isAdmin() ? authorityListAdmin : authorityListUser);
	}
}
