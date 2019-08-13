package com.ws.spring;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

import com.ws.common.util.Constants;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author admin
 *
 */
@SpringBootApplication
@Configuration
@EnableJdbcHttpSession
@EnableSwagger2
public class MdogApplication extends SpringBootServletInitializer implements ApplicationRunner {

	Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Value("${spring.profiles.active}")
	private String activeProfile;

	public static void main(String[] args) {
		SpringApplication.run(MdogApplication.class, args);
	}

	@Bean
	public TaskScheduler taskScheduler() {
		return new ConcurrentTaskScheduler(); // single threaded by default
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(MdogApplication.class);
	}

	@Override
	public void run(ApplicationArguments applicationArguments) {
		logger.warn("Application started with Active Profile is : {} and Date : {} and ", activeProfile, new Date());
		try {
			setTimeZone();
			logger.debug("Debug log");
			logger.info("Info Log");

		} catch (Exception e) {
			logger.error("SendSms got an error : {},", e.getMessage(), e);
		}
	}

	private void setTimeZone() {
		Calendar calendar = Calendar.getInstance();
		logger.info("Default time zone : {} , Calendare time zone :  {} , and date and time : {}",
				TimeZone.getDefault(), calendar.getTimeZone(), calendar.getTime());
		logger.info("Current time : {}", new Date());
		if (!Constants.TIME_ZONE_ID.equals(TimeZone.getDefault().getID())) {
			TimeZone timeZone = TimeZone.getTimeZone(Constants.TIME_ZONE_ID);
			TimeZone.setDefault(timeZone);
			calendar.setTimeZone(timeZone);
			logger.info("Default time zone : {} , Calendare time zone :  {} , and date and time : {}",
					TimeZone.getDefault(), calendar.getTimeZone(), calendar.getTime().toString());
			logger.info("Updated time : {}", new Date().toString());
		}
	}
	/*
	 * @Bean public JavaMailSender getJavaMailSender() { JavaMailSenderImpl
	 * mailSender = new JavaMailSenderImpl(); mailSender.setHost("smtp.gmail.com");
	 * mailSender.setPort(587);
	 * 
	 * mailSender.setUsername("paramanagowda.patil@gmail.com");
	 * mailSender.setPassword("letsdoit@333");
	 * 
	 * Properties props = mailSender.getJavaMailProperties();
	 * props.put("mail.transport.protocol", "smtp"); props.put("mail.smtp.auth",
	 * "true"); props.put("mail.smtp.starttls.enable", "true");
	 * props.put("mail.debug", "true");
	 * 
	 * return mailSender; }
	 */

}
