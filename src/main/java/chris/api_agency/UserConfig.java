package chris.api_agency;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserConfig {

    @Bean
    public UserDetailsService userDetailsServiceForUserConfig() {  
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("admin")
            .password("{noop}adminpassword")
            .roles("ADMIN")
            .build());
        return manager;
    }
}
