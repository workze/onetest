package com.onetest.spring.config;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangguize
 * @date 2022/2/16
 */
@Configuration
@EnableAdminServer
public class SpringAdminConfig {

    /*@Configuration
    public static class SecurityPermitAllConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests().anyRequest().permitAll()
                    .and().csrf().disable();
        }
    }*/

}
