package com.example.bootstraprestful.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() //cross site request forgery
                .authorizeRequests() //all requests to the API requires authentication
                .anyRequest() //all requests to the API requires authentication
                .authenticated() //all requests to the API requires authentication
                .and()
                .httpBasic(); //allow user basic authentication
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password(encoder().encode("password"))
                .roles("USER");
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}

//CSRF Cross site request forgery
//commands are transmitted by specially crafted images tags, hidden forms, XMLHttpRequest (JavaScript)
//also cookies, url parameters
//can all work without the user's interaction or knowledge
//unline cross site scripting (XSS) whicht explouts the trust a user has for a particular site
//CSRF exploits the trust that a site has in a user's browser
//the goal is to cause the victims umknowingly submit a web request to a website that the victim has privileged access to
//at risk are applications, tht perform actions without requiring the uer to authorize the specific action

