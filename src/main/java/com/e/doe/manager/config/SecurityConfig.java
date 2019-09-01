package com.e.doe.manager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.e.doe.manager.edoeUser.EdoeUserService;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
    @Autowired
    private EdoeUserService edoeUserService;
    	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//			.anyRequest()
//			.authenticated()
//			.and()
    
//			.httpBasic()
//			.and()
//			.csrf().disable();
//	}
	
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//
//        auth.inMemoryAuthentication()
//        .withUser("user")
//        .password(encoder.encode("12345"))
//        .roles(PrivilegeUtils.PRIVILAGE_USER)
//        .and()
//        .withUser("admin")
//        .password(encoder.encode("12345"))
//        .roles(PrivilegeUtils.PRIVILAGE_USER, PrivilegeUtils.PRIVILAGE_ADMIN);
//	}
    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors()
		.and()
		.csrf()
		.disable()
		.authorizeRequests()
		.anyRequest().authenticated()
		.and()
		.addFilter(new JWTAuthenticationFilter(authenticationManager()))
		.addFilter(new JWTAuthorizationFilter(authenticationManager(), edoeUserService));
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(edoeUserService).passwordEncoder(
				new BCryptPasswordEncoder());
		
	}
}
