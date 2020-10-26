package com.hqc.user.config;

import com.hqc.user.service.IHqcDepartmentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private IHqcDepartmentUserService hqcDepartmentUserService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.(hqcDepartmentUserService).passwordEncoder(new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return s.equals(charSequence.toString());
            }
        });
    }

}
