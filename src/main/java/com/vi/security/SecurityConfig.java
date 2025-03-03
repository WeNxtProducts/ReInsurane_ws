// package com.vi.security;

// import com.vi.corelib.utils.UrlUtility;
// import lombok.RequiredArgsConstructor;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import jakarta.servlet.Filter;

// @Configuration
// @RequiredArgsConstructor
// @EnableWebSecurity
// public class SecurityConfig extends WebSecurityConfigurerAdapter {
//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         UrlUtility.setPolicy(http);
//     }
// }
package com.vi.security;

import com.vi.corelib.utils.UrlUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        UrlUtility.setPolicy(http); 
        return http.build();
    }
}

