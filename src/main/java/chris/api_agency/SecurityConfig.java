package chris.api_agency;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()  
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers("/public/**").permitAll()  
                .anyRequest().authenticated()  
            )
            .httpBasic() 
            .and()
            .formLogin()
                .loginProcessingUrl("/login") 
                .permitAll()
            .and()
            .logout()
                .permitAll();

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsServiceForSecurity() {  
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user")
            .password("{noop}password")  
            .roles("USER")
            .build());
        manager.createUser(User.withUsername("admin")
            .password("{noop}adminpassword")
            .roles("ADMIN")
            .build());
        return manager;
    }

    // Configuração do AuthenticationManager
    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = 
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsServiceForSecurity());
        return authenticationManagerBuilder.build();
    }
}
