package ru.beregmira.SMSpring.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;


@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Qualifier("dataSource")
    @Autowired
    DataSource dataSource;
//    @Autowired
//    private final DataSource dataSource;
//    SecurityConfiguration(DataSource dataSource){
//        this.dataSource = dataSource;
//    }

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("SELECT  user_app.name, user_app.password, user_app.enabled FROM user_app where user_app.name=?")
                .authoritiesByUsernameQuery("SELECT  user_app.name, user_app.role FROM user_app WHERE user_app.name =?");
    }

    @Override
    protected void configure(HttpSecurity config) throws Exception {
        config
                .authorizeRequests()
                .antMatchers("/").permitAll();
        config
                .authorizeRequests()
                .antMatchers("/main").hasAnyRole("USER", "EDITOR")
                .antMatchers("/editor").hasRole("EDITOR")
                .antMatchers("/blog/*").hasAnyRole("USER", "EDITOR")
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/main").permitAll()
                .and().logout().logoutUrl("/logout");
    }

}