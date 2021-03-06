package ru.garagetools.parapi.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
class SecurityConfig  : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) : Unit {
        http.csrf().disable()

        http.authorizeRequests()
                .antMatchers("/api/**").hasRole("API")
                .and().httpBasic()

        http.authorizeRequests()
                //.antMatchers("/api/**").permitAll()
                .antMatchers("/").hasRole("USER").anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout().permitAll()


    }
    @Autowired
    fun configureGlobal(auth: AuthenticationManagerBuilder): Unit {
        auth.inMemoryAuthentication().withUser("s").password("{noop}1").roles("USER");
        auth.inMemoryAuthentication().withUser("d").password("{noop}1").roles("USER");
        auth.inMemoryAuthentication().withUser("v").password("{noop}1").roles("USER");
        auth.inMemoryAuthentication().withUser("e").password("{noop}1").roles("USER");
        auth.inMemoryAuthentication().withUser("gv").password("{noop}1").roles("USER");
        auth.inMemoryAuthentication().withUser("un").password("{noop}1").roles("USER");
        auth.inMemoryAuthentication().withUser("sg").password("{noop}1").roles("USER");
        auth.inMemoryAuthentication().withUser("ad").password("{noop}1").roles("USER");
        auth.inMemoryAuthentication().withUser("ra").password("{noop}1").roles("USER");
        auth.inMemoryAuthentication().withUser("kp").password("{noop}1").roles("USER");
        auth.inMemoryAuthentication().withUser("kr").password("{noop}1").roles("USER");
        auth.inMemoryAuthentication().withUser("ku").password("{noop}1").roles("USER");
        auth.inMemoryAuthentication().withUser("api").password("{noop}@%TG5h").roles("API");
    }
}