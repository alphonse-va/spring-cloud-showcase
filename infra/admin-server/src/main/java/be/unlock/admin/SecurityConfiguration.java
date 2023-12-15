package be.unlock.admin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    final KeycloakLogoutHandler keycloakLogoutHandler;

    public SecurityConfiguration(KeycloakLogoutHandler keycloakLogoutHandler) {
        this.keycloakLogoutHandler = keycloakLogoutHandler;
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http.oauth2Client(withDefaults())
                .oauth2Login(configurer -> configurer.tokenEndpoint(tokenEndpointConfig -> configurer.userInfoEndpoint(withDefaults())))
                .sessionManagement(managementConfigurer -> managementConfigurer.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
                .authorizeHttpRequests(matcherRegistry -> {
                    matcherRegistry.requestMatchers("/unauthenticated", "/oauth2/**", "/login/**").permitAll();
                    matcherRegistry.requestMatchers("/actuator/**", "/logout/**").permitAll();
                    matcherRegistry.anyRequest().fullyAuthenticated();
                })
                .logout(logoutConfigurer -> {
                    logoutConfigurer.addLogoutHandler(keycloakLogoutHandler);
                    logoutConfigurer.logoutUrl("/logout");
                })
                .csrf(AbstractHttpConfigurer::disable)
                .build();
    }
}