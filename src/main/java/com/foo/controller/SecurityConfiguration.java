package com.foo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	// @Autowired
	// private BCryptPasswordEncoder bCryptPasswordEncoder;

	// @Autowired
	// private DataSource dataSource;

	// @Value("${spring.queries.users-query}")
	// private String usersQuery;
	//
	// @Value("${spring.queries.roles-query}")
	// private String rolesQuery;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// auth.
		// jdbcAuthentication()
		// .usersByUsernameQuery(usersQuery)
		// .authoritiesByUsernameQuery(rolesQuery)
		// .dataSource(dataSource)
		// .passwordEncoder(bCryptPasswordEncoder);
		
//		no se puede agregar esto
//		auth.inMemoryAuthentication().withUser("username").roles("USER");
//		System.out.println("in mem  auth");
//		
//		auth.inMemoryAuthentication()
//        .withUser("emi").password("pass").roles("USER");
	}
	
	

//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		System.out.println("auth " + auth);
//		auth
//		.inMemoryAuthentication()
//		.withUser("emi").password("pass").roles("USER");
//		System.out.println("configure global");
//	}
//	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
/*
		System.out.println("configure  httpsecurity ");
		http.authorizeRequests().antMatchers("/").permitAll()
			.antMatchers("/login").permitAll()
			.antMatchers("/login1").permitAll()
			.antMatchers("/login2").permitAll()
				.antMatchers("/greeting*").permitAll()
				.anyRequest().authenticated().and().csrf().disable()
				.formLogin().loginPage("/greeting")
				.loginProcessingUrl("login2")
				.usernameParameter("username")
				.passwordParameter("password")
				 .successHandler((req,res,auth)->{    //Success handler invoked after successful authentication
			         for (GrantedAuthority authority : auth.getAuthorities()) {
			            System.out.println("authority1 " + authority.getAuthority());
			         }
			         System.out.println(auth.getName());
			         res.sendRedirect("/"); // Redirect user to index/home page
			      })
				.failureUrl("/login?error=true").defaultSuccessUrl("/admin/home").usernameParameter("username")
				.passwordParameter("password").and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/").and().exceptionHandling().accessDeniedPage("/access-denied");
*/
		
		
		
		http
        .authorizeRequests()
        .antMatchers("/logon*")
        .hasRole("USER")
        .anyRequest()
        
        .authenticated()
        
        .and()
        .formLogin()
        
        
        // FUNDAMENTAL: redirecciona al RequestMapping /logon 
        .loginPage("/logon")
        .permitAll()
        
//        .defaultSuccessUrl("/greeting.html")
//        .failureUrl("/index.html?error=true")
//        .and()
//        .logout().logoutSuccessUrl("/index.html")
        ;
        
		
	}



	@Override
	public void configure(WebSecurity web) throws Exception {
		System.out.println("configure web security");
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}
}