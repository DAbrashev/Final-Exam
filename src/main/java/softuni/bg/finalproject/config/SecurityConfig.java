package softuni.bg.finalproject.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import softuni.bg.finalproject.repository.UserRepository;
import softuni.bg.finalproject.services.EcontUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests(
                        httpRequests ->
                                httpRequests
                                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                                        .requestMatchers("/", "/login", "/register").permitAll()
                                        .anyRequest().authenticated()

                )
                .formLogin(
                        login ->
                                login
                                        .loginPage("/login")
                                        .usernameParameter("email")
                                        .passwordParameter("password")
                                        .defaultSuccessUrl("/", true)
                                        .failureForwardUrl("/login-error")
                )
                .logout(
                        logout ->
                                logout.logoutUrl("/logout")
                                        .logoutSuccessUrl("/")
                                        .invalidateHttpSession(true)
                )
                .build();
    }

    @Bean
    public EcontUserDetailsService userDetailsService(UserRepository userRepository) {
        return new EcontUserDetailsService(userRepository);
    }

}
