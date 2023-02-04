package com.dione.applicationtestingmanage;

import com.dione.applicationtestingmanage.service.AppTestingServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class ApplicationTestingManageApplication implements CommandLineRunner {
	private final AppTestingServiceImpl appTestingService;


	public ApplicationTestingManageApplication(AppTestingServiceImpl appTestingService, RepositoryRestConfiguration repositoryRestConfiguration) {
		this.appTestingService = appTestingService;

	}

	public static void main(String[] args) {

		SpringApplication.run(ApplicationTestingManageApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		appTestingService.initAnomalie();
		appTestingService.initCasDeTest();
		appTestingService.initScenarioDeTest();
		appTestingService.initRelease();
		appTestingService.initTicket();
		appTestingService.initTesteur();

	}
}
