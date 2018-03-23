package com.larry.wyj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@SpringBootApplication
@MapperScan("com.larry.wyj.mapper")
public class WyjApplication{

//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		return builder.sources(WyjApplication.class);
//	}

	@RequestMapping("/index")
	public String toLogin(){
		return "index";
	}

	public static void main(String[] args) {
		SpringApplication.run(WyjApplication.class, args);
	}
}
