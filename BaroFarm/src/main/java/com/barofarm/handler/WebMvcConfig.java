package com.barofarm.handler;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.barofarm.fish.interceptor.LoginInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addInterceptors(registry);
		registry.addInterceptor(new LoginInterceptor())
		.addPathPatterns("/add","/allview","/u_view");
		//상품등록,상품전체보기,회원 전체보기 로그인한 회원만 볼 수 있다. <로그인 한 회원=관리자>
		
		
//		registry.addInterceptor(new LoginInterceptor())
//		.addPathPatterns("/add");
		
		
		
//		("/","/member/add","/board","/board/post/*","/login","/logout","/css/**","/*.ico","/error");
//
//
//		"/**" : / 하위의 모든 경로
//		"/board" : 정확히 '/board'만 해당
//		/css/** : /css로 시작하는 모든 경로
//		/*. ico 끝나는 경로 제외
//		/board/post/* : /board/post/(숫자)인 경로
	}
}
