package com.capgemini.project.microsevice_apigateway.configurations;

import com.capgemini.project.microsevice_apigateway.filters.JwtRequestFilter;
import com.capgemini.project.microsevice_apigateway.models.CommonMan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public CommonMan gg(){
		return new CommonMan();
	}

	@Autowired
	private UserDetailsService myUserDetailsService;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserDetailsService);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.httpBasic().and()
				.authorizeRequests().antMatchers(HttpMethod.POST,"/authenticate","/user-service/**, /train-service/search/**, /ticket-service/search/**").permitAll().
				 antMatchers("/train-service/station/**, /train-service/train/**, /ticket-service/ticket/**, /passenger-service/passenger/**").hasAnyAuthority("ADMIN").
				 antMatchers("/booking-service/booking/**").hasAnyAuthority("USER,ADMIN").
						anyRequest().authenticated().and().csrf().disable().					
						exceptionHandling().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

	}

}