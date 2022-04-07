package com.alex.sms.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.*;

// TODO: Auto-generated Javadoc
/**
 * The Class SecurityConfig.
 * https://docs.spring.io/spring-security/site/docs/current/guides/html5/hellomvc-javaconfig.html
 */
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Configure global.
     *
     * @param auth the auth
     * @throws Exception the exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("alatoo")
                .password("{noop}alatoo1996")
                .roles("ADMIN");
    }
}
