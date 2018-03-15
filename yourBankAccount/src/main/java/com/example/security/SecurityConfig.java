package com.example.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	// die user sind in memory gespeichert 
		/*auth.inMemoryAuthentication().withUser("admin").password("abc").roles("ADMIN","USER");
		auth.inMemoryAuthentication().withUser("user").password("abcd").roles("USER");*/
		
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select username as principal, password as credentials, active from users where username=? ")
		.authoritiesByUsernameQuery("select username as principal, roles as role from users_roles where username=?")
		.rolePrefix("ROLE_");
		
	}
	
	@Override
	
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/login");
		http.authorizeRequests().antMatchers("/operations","/consultercompte").hasRole("USER");
		http.authorizeRequests().antMatchers("/saveOperation").hasRole("ADMIN");
		http.exceptionHandling().accessDeniedPage("/403");
	}

}
