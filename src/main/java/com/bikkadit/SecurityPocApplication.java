package com.bikkadit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.bikkadit.constants.AppConstants;
import com.bikkadit.model.Role;
import com.bikkadit.repository.RoleRepository;

@SpringBootApplication // Configuration, CompoentScan, EnableAutoConnfiguration.
public class SecurityPocApplication implements CommandLineRunner {
	

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepository roleRepo;


	public static void main(String[] args) {
		SpringApplication.run(SecurityPocApplication.class, args);

	}
	@Override
	public void run(String... args) throws Exception {

		System.out.println(this.passwordEncoder.encode("abc"));

		try {

			Role role = new Role();
			role.setId(AppConstants.ADMIN_USER);
			role.setName("ROLE_ADMIN");

			Role role1 = new Role();
			role1.setId(AppConstants.NORMAL_USER);
			role1.setName("ROLE_NORMAL");

			List<Role> roles = List.of(role, role1);

			List<Role> result = this.roleRepo.saveAll(roles);

			result.forEach(r -> {
				System.out.println(r.getName());
			});

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
