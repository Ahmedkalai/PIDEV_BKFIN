package com.BKFIN.provider;
import java.io.IOException;

import javax.sql.DataSource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.BKFIN.services.JwtUserDetailsService;

@EnableWebSecurity
@Configuration
//@Profile("development")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
   @Autowired
   private JwtAuthenticationEntryPoint authenticationEntryPoint;
   @Autowired
   private JwtUserDetailsService userDetailsService;
   @Autowired
   private JwtFilter filter;
   @Autowired
   private PasswordEncoder passwordEncoder;

	@Autowired
	private DataSource dataSource;
   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
   }
   @Bean
   @Override
   public AuthenticationManager authenticationManagerBean() throws
   Exception {
      return super.authenticationManagerBean();
   }
   @Override
   protected void configure(HttpSecurity http) throws Exception {
      http.cors().and()
      .csrf().disable()
      .authorizeRequests()
      .antMatchers("/login").permitAll()
      .antMatchers("/logout").permitAll()
      .antMatchers("/Admin/**").access("hasRole('ADMIN')")
      //.antMatchers("/Agent/**").access("hasRole('ADMIN')")
      .antMatchers("/Agent/AddAgent").access("hasRole('ADMIN')")
      .antMatchers("/Client/insertClient/**").access("hasRole('AGENT')")
      .antMatchers("/Client/getClients").access("hasRole('CLIENT')")
      .anyRequest().permitAll().and()
      .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint)
      .and()
      
      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
      http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        }
 /*  private class AuthentificationLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

       @Override
       public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
                                   Authentication authentication) throws IOException, ServletException {
           response.setStatus(HttpServletResponse.SC_OK);
       }
      
   }*/
   
   @Bean
   public CorsConfigurationSource configurationSource() {
       UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
       CorsConfiguration config = new CorsConfiguration();
       config.addAllowedOrigin("/**");
       config.setAllowCredentials(true);
       config.addAllowedHeader("X-Requested-With");
       config.addAllowedHeader("Content-Type");
       config.addAllowedMethod(HttpMethod.POST);
       config.addAllowedMethod(HttpMethod.DELETE);
       config.addAllowedMethod(HttpMethod.OPTIONS);
       config.addAllowedMethod(HttpMethod.PUT);
       config.addAllowedMethod(HttpMethod.PATCH);
       source.registerCorsConfiguration("/**", config);
       return source;
     }

	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
		db.setDataSource(dataSource);
		return db;
	}
	 
   
  
}