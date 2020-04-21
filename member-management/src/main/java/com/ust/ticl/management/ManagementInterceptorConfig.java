package com.ust.ticl.management;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ust.ticl.management.interceptors.TokenValidateInterceptor;


@Configuration
public class ManagementInterceptorConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new TokenValidateInterceptor()).addPathPatterns("/**");
	}
 
}
