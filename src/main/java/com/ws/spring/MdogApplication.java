package com.ws.spring;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.ws.spring.email.service.EmailServiceImpl;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author admin
 *
 */
@SpringBootApplication
@Configuration
@EnableJdbcHttpSession
@EnableSwagger2
//@Resource(name = "jdbc/walkindbDS", type = javax.sql.DataSource.class, lookup = "jdbc/walkindbDS")
public class MdogApplication extends SpringBootServletInitializer implements ApplicationRunner {

	Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Value("${spring.profiles.active}")
	private String activeProfile;

	@Autowired
	EmailServiceImpl emailServiceImpl;

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
			if ("prod".equals(activeProfile))
				emailServiceImpl.sendSimpleMessage("paramanagowda.patil@gmail.com", "Test Mdog App Mail",
						"Test Mdog App Mail");
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
}
