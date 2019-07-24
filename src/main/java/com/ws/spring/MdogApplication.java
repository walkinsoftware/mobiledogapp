package com.ws.spring;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

import com.ws.spring.email.service.EmailServiceImpl;

/**
 * @author admin
 *
 */
@SpringBootApplication
@Configuration
@EnableJdbcHttpSession
public class MdogApplication extends SpringBootServletInitializer implements ApplicationRunner {

	Logger logger = LogManager.getLogger(this.getClass().getName());

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

	@Bean
	@Profile({ "prod", "stage" })
	@Resource(name = "jdbc/walkindbDS", type = javax.sql.DataSource.class, lookup = "jdbc/walkindbDS")
	public JndiDataSourceLookup jndDataSource() {
		JndiDataSourceLookup dataSource = null;
		try {
			JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
			dataSourceLookup.getDataSource("java:comp/env/jdbc/walkindbDS");
			// JndiTemplate jndi = new JndiTemplate();
			// dataSource = jndi.lookup("java:comp/env/jdbc/walkindbDS", DataSource.class);
			logger.info("JDNI Datasource Connection success : jdbc/walkindbDS");
		} catch (Exception e) {
			logger.error("NamingException for java:comp/env/jdbc/yourname", e);
		}
		return dataSource;
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(MdogApplication.class);
	}

	@Override
	public void run(ApplicationArguments applicationArguments) {
		logger.warn("Application started with Active Profile is : {} and Date : {} and ", activeProfile, new Date());
		try {
			if ("prod".equals(activeProfile))
				emailServiceImpl.sendSimpleMessage("paramanagowda.patil@gmail.com", "Test Mdog App Mail",
						"Test Mdog App Mail");
			logger.info("Email Sent Successfully");

		} catch (Exception e) {
			logger.error("SendSms got an error : {},", e.getMessage(), e);
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
