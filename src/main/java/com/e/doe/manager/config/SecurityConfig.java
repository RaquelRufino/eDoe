package com.e.doe.manager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.e.doe.manager.utils.PrivilegeUtils;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
    @Autowired
    private Environment env;
    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic()
			.and()
			.csrf().disable();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        auth.inMemoryAuthentication()
        .withUser(env.getProperty("spring.security.user"))
        .password(encoder.encode(env.getProperty("spring.security.password")))
        .roles(PrivilegeUtils.PRIVILAGE_USER)
        .and()
        .withUser(env.getProperty("spring.security.admin"))
        .password(encoder.encode("12345"))
        .roles(PrivilegeUtils.PRIVILAGE_USER, PrivilegeUtils.PRIVILAGE_ADMIN);
	}
}
