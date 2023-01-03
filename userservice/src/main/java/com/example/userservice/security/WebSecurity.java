package com.example.userservice.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable();
//        http.authorizeRequests().antMatchers("/users/**").permitAll();
        http.authorizeRequests().antMatchers("/**")
                    .hasIpAddress("*")
                    .and()
                    .addFilter(getAuthenticationFilter());

        http.headers().frameOptions().disable();//h2-console을 열기 위함.
    }

    private AuthenticationFilter getAuthenticationFilter() throws Exception{
        AuthenticationFilter authenticationFilter = new AuthenticationFilter();
        authenticationFilter.setAuthenticationManager(authenticationManager());
// 로그인에서 사용할 비교하는 쿼리를 구현하지 않고 시큐리티에서 제공하는 로그인을 사용하기 위해 매니저 등록
        return authenticationFilter;
    }
}
