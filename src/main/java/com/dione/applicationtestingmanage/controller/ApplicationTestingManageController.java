package com.dione.applicationtestingmanage.controller;


import com.dione.applicationtestingmanage.entity.*;
import com.dione.applicationtestingmanage.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@Transactional
public class ApplicationTestingManageController {
    private final ReleaseRepository releaseRepository;

    private final AnomalieRepository anomalieRepository;
    private final TicketRepository ticketRepository;
    private final CasDeTestRepository casDeTestRepository;
    private final ScenarioDeTestRepository scenarioDeTestRepository;
    private final TesteurRepository testeurRepository;

    public ApplicationTestingManageController(ReleaseRepository releaseRepository, AnomalieRepository anomalieRepository, TicketRepository ticketRepository, CasDeTestRepository casDeTestRepository, ScenarioDeTestRepository scenarioDeTestRepository, TesteurRepository testeurRepository) {
        this.releaseRepository = releaseRepository;
        this.anomalieRepository = anomalieRepository;
        this.ticketRepository = ticketRepository;
        this.casDeTestRepository = casDeTestRepository;
        this.scenarioDeTestRepository = scenarioDeTestRepository;
        this.testeurRepository = testeurRepository;
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

    //Méthodes de récupérateur de tous les tickets
    @GetMapping("/allTickets")
    public List<Ticket> findAllTicket(){
        return ticketRepository.findAll();
    }

    //Méthodes de récupération de tous les testeurs
    @GetMapping("/allTesteurs")
    public List<Testeur> findAllTesteur(){
        return testeurRepository.findAll();
    }

    //AJOUT


    //Méthode d'ajoute d'une release
    @PostMapping("/addRelease")
    public Release ajoutRelease(@RequestBody Release release){
        release.setRefRelease(UUID.randomUUID().toString());
        return releaseRepository.save(release);
    }

    //Méthode d'ajout d'un testeur
    @PostMapping("addTesteur")
    public Testeur ajoutTesteur( @RequestBody Testeur testeur){
        return testeurRepository.save(testeur);
    }

    //méthode d'ajout de ticket
    @PostMapping("/addTicket")
    public Ticket ajoutTicket(@RequestBody Ticket ticket){
        ticket.setRefTicket(UUID.randomUUID().toString());
        return ticketRepository.save(ticket);
    }

    //Méthode d'ajout de cas de test
    @PostMapping("/addCasTest")
    public CasDeTest ajoutCasTest(@RequestBody CasDeTest casDeTest){
        casDeTest.setRefCasTest(UUID.randomUUID().toString());
        return casDeTestRepository.save(casDeTest);
    }

    //Méthode d'ajout Scenario de test
    @PostMapping("/addScenario")
    public ScenarioDeTest ajoutScenario(ScenarioDeTest scenario){
        scenario.setRefScenario(UUID.randomUUID().toString());
        return scenarioDeTestRepository.save(scenario);
    }

    //Méthode de récupération d'un release sachant sont ID
    @GetMapping("/release/{id}")
    public Release findReleaseById(@PathVariable String id) {
        return releaseRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Release not found "));
    }



}
