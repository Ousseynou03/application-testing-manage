package com.dione.applicationtestingmanage.controller;


import com.dione.applicationtestingmanage.entity.*;
import com.dione.applicationtestingmanage.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@Transactional
public class ApplicationTestingManageController {
    private final ReleaseRepository releaseRepository;
    private final TesteurRepository testeurRepository;
    private final AnomalieRepository anomalieRepository;
    private final TicketRepository ticketRepository;
    private final CasDeTestRepository casDeTestRepository;
    private final ScenarioDeTestRepository scenarioDeTestRepository;

    public ApplicationTestingManageController(ReleaseRepository releaseRepository, TesteurRepository testeurRepository, AnomalieRepository anomalieRepository, TicketRepository ticketRepository, CasDeTestRepository casDeTestRepository, ScenarioDeTestRepository scenarioDeTestRepository) {
        this.releaseRepository = releaseRepository;
        this.testeurRepository = testeurRepository;
        this.anomalieRepository = anomalieRepository;
        this.ticketRepository = ticketRepository;
        this.casDeTestRepository = casDeTestRepository;
        this.scenarioDeTestRepository = scenarioDeTestRepository;
    }

    //Méthode de récupértion de tous les releases
    @GetMapping("/allReleases")
    public List<Release> findAllRelease(){
        return releaseRepository.findAll();
    }

    //Méthode de récupération de tous les anomalies
    @GetMapping("/allAnomalies")
    public List<Anomalie> findAllAnomalie(){
        return anomalieRepository.findAll();
    }

    //Méthode de récupération de tous les cas de tests
    @GetMapping("/allCasDeTests")
    public List<CasDeTest> findAllCasDeTest(){
        return casDeTestRepository.findAll();
    }

    //Méthodes de récupération de tous les scenario de test
    @GetMapping("/allScenarios")
    public List<ScenarioDeTest> findAllScenarioDeTest(){
        return scenarioDeTestRepository.findAll();
    }

    //Méthodes de récupération de tous les testeurs
    @GetMapping("/allTesteurs")
    public List<Testeur> findAllTesteur(){
        return testeurRepository.findAll();
    }

    //Méthodes de récupérateur de tous les tickets
    @GetMapping("/allTickets")
    public List<Ticket> findAllTicket(){
        return ticketRepository.findAll();
    }

    //Méthode d'ajoute d'une release
    @PostMapping("/addRelease")
    public Release ajoutRelease(@RequestBody Release release){
        release.setRefRelease(UUID.randomUUID().toString());
        release.setDatePrevision(new Date());
        release.setDateLivraison(new Date());
        release.setDateReelle(new Date());
        release.setTickets(release.getTickets());
        return releaseRepository.save(release);
    }

    //Méthodes d'ajout d'un testeur
    @PostMapping
    public Testeur addTesteur(@RequestBody Testeur testeur){
        return testeurRepository.save(testeur);
    }
}
