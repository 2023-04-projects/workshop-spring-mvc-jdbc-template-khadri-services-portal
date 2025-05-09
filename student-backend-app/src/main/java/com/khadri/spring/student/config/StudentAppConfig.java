package com.khadri.spring.student.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.khadri.spring.student" })
public class StudentAppConfig {

}