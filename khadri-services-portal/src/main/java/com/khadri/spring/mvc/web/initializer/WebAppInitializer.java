package com.khadri.spring.mvc.web.initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.khadri.spring.author.config.AuthorAppConfig;
import com.khadri.spring.customer.config.CustomerAppConfig;
import com.khadri.spring.employee.config.EmployeeAppConfig;
import com.khadri.spring.mvc.config.AppConfig;
import com.khadri.spring.student.config.StudentAppConfig;
import com.khadri.spring.task.config.TaskAppConfig;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		return new Class[] { AppConfig.class, StudentAppConfig.class, CustomerAppConfig.class, EmployeeAppConfig.class,
				AuthorAppConfig.class, TaskAppConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
