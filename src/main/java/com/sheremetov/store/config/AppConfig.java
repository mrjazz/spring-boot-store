package com.sheremetov.store.config;

import com.sheremetov.store.interceptor.FrontendInterceptor;
import com.sheremetov.store.service.impl.UserSessionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@ComponentScan("com.sheremetov.store")
public class AppConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private FrontendInterceptor frontendInterceptor;

    @Bean
    @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public UserSessionImpl userSession() {
        return new UserSessionImpl();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        frontendInterceptor.setUserSession(userSession());
        registry.addInterceptor(frontendInterceptor);
    }

}