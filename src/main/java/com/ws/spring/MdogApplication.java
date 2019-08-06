package com.ws.spring;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

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
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

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
@Resource(name = "jdbc/walkindbDS", type = javax.sql.DataSource.class, lookup = "jdbc/walkindbDS")
public class MdogApplication extends SpringBootServletInitializer implements ApplicationRunner {

	Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Value("${spring.profiles.active}")
	private String activeProfile;

	@Value("${spring.datasource.jndi-name}")
	private String jndiDataSourceName;

	@Autowired
	EmailServiceImpl emailServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(MdogApplication.class, args);
	}

	@Bean
	public TaskScheduler taskScheduler() {
		return new ConcurrentTaskScheduler(); // single threaded by default
	}

	@Profile("dev")
	public JndiDataSourceLookup jndDataSource() {
		JndiDataSourceLookup dataSourceLookup = null;
		try {
			dataSourceLookup = new JndiDataSourceLookup();
			dataSourceLookup.getDataSource("java:comp/env/jdbc/walkindbDS");
			// JndiTemplate jndi = new JndiTemplate();
			// dataSource = jndi.lookup("java:comp/env/jdbc/walkindbDS", DataSource.class);
			logger.info("JDNI Datasource Connection success : jdbc/walkindbDS");
		} catch (Exception e) {
			logger.error("NamingException for java:comp/env/jdbc/yourname", e);
		}
		return dataSourceLookup;
	}

	public DataSource jndiDataSource() {
		JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
		bean.setJndiName(jndiDataSourceName);
		bean.setProxyInterface(DataSource.class);
		bean.setLookupOnStartup(false);
		try {
			bean.afterPropertiesSet();
		} catch (IllegalArgumentException | NamingException e) {
			logger.error("NamingException for {}", jndiDataSourceName, e);
		}
		return (DataSource) bean.getObject();

	}

	/*
	 * @Profile("dev")
	 * 
	 * @Bean(destroyMethod = "")
	 * 
	 * @Resource(name = "jdbc/walkindbDS", type = javax.sql.DataSource.class, lookup
	 * = "jdbc/walkindbDS")
	 */
	public DataSource loadJndiDataSource() throws NamingException {

		Context ctx = new InitialContext();
		Context initCtx = (Context) ctx.lookup("java:/comp/env");
		DataSource ds = (DataSource) initCtx.lookup("jdbc/walkindbDS");
		return ds;
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
		if (!"Asia/Calcutta".equals(TimeZone.getDefault().getID())) {
			TimeZone.setDefault(TimeZone.getTimeZone("Asia/Calcutta"));

			logger.info("Default time zone : {} , Calendare time zone :  {} , and date and time : {}",
					TimeZone.getDefault(), calendar.getTimeZone(), calendar.getTime());
			logger.info("Updated time : {}", new Date());
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
