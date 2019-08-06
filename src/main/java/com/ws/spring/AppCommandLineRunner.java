package com.ws.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ws.common.util.Constants;
import com.ws.spring.model.Role;
import com.ws.spring.repository.RoleRepository;

@Configuration
public class AppCommandLineRunner implements CommandLineRunner {

	@Autowired
	RoleRepository roleRepository;

	@Override
	public void run(String... args) throws Exception {

		roleRepository.save(new Role(Constants.ROLE_ID_SUPERADMIN, "SuperAdmin"));
		roleRepository.save(new Role(Constants.ROLE_ID_GENERAL_USER, "User"));
		roleRepository.save(new Role(Constants.ROLE_ID_ADMIN, "Admin"));
		roleRepository.save(new Role(Constants.ROLE_ID_REPORTER, "Reporter"));
	}

}
