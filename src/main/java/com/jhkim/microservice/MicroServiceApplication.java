package com.jhkim.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication  // 이 클래스를 스프링 부트 서비스의 진입점으로 스프링 부트에 지정
public class MicroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceApplication.class, args);
    }


    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(Locale.KOREA); // Korea를 기본 locale로 설정

        return localeResolver;
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();

        // 메시지가 발견되지 않아도 에러를 던지지 않고 메세지 코드를 반환
        messageSource.setUseCodeAsDefaultMessage(true);
        messageSource.setBasenames("messages"); // 언어 프로퍼티 파일의 기본 이름 설정

        return messageSource;
    }
}