package com.tyss.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfigure extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource ds;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(ds)
				.authoritiesByUsernameQuery("select * from Employee_details where id=?").authoritiesByUsernameQuery("select roll_type from roll_details where id=?");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/index.jsp" , "/empform.jsp", "/loginform.jsp","/saved.jsp", "/welcome.jsp").access("permitAll")
		.antMatchers("/viewemp.jsp").access("hasAnyRole('admin')")
		.and().formLogin()
		.and().exceptionHandling().accessDeniedPage("/loginform.jsp")
		.and().logout().logoutSuccessUrl("/logoutpage.jsp");
	}
}
