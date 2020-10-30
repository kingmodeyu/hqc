package com.hqc.user.config;

import com.hqc.user.service.IHqcDepartmentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  /*  @Autowired
    private HqcDepartmentUserServiceImpl hqcDepartmentUserService;*/

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    }

}
