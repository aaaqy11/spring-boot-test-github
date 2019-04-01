package com.gongyongqin.demo;

import com.github.pagehelper.PageHelper;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.omg.PortableInterceptor.Interceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

@SpringBootApplication
@MapperScan("com.gongyongqin.demo.dao")
public class SpingBootTestGithubApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpingBootTestGithubApplication.class, args);
	}



}
