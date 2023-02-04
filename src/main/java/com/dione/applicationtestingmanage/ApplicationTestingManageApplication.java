package com.dione.applicationtestingmanage;

import com.dione.applicationtestingmanage.entity.*;
import com.dione.applicationtestingmanage.service.AppTestingServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class ApplicationTestingManageApplication implements CommandLineRunner {
	private final AppTestingServiceImpl appTestingService;
	private final RepositoryRestConfiguration restConfiguration;

	public ApplicationTestingManageApplication(AppTestingServiceImpl appTestingService, RepositoryRestConfiguration repositoryRestConfiguration, RepositoryRestConfiguration restConfiguration) {
		this.appTestingService = appTestingService;

		this.restConfiguration = restConfiguration;
	}

	public static void main(String[] args) {

		SpringApplication.run(ApplicationTestingManageApplication.class, args);
	}


	@Override
	@Transactional
	public void run(String... args) throws Exception {
		//Exposition des id
		restConfiguration.exposeIdsFor(Release.class);
		restConfiguration.exposeIdsFor(Ticket.class);
		restConfiguration.exposeIdsFor(Testeur.class);
		restConfiguration.exposeIdsFor(Anomalie.class);
		restConfiguration.exposeIdsFor(CasDeTest.class);
		restConfiguration.exposeIdsFor(ScenarioDeTest.class);

		appTestingService.initAnomalie();
		appTestingService.initCasDeTest();
		appTestingService.initScenarioDeTest();
		appTestingService.initRelease();
		appTestingService.initTicket();
		appTestingService.initTesteur();

	}
}
