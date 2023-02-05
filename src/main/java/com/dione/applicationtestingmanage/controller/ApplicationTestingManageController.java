package com.dione.applicationtestingmanage.controller;


import com.dione.applicationtestingmanage.entity.*;
import com.dione.applicationtestingmanage.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;


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

    //Méthode d'ajout d'une Anomalie
    @PostMapping("/addAnomalie")
    public Anomalie ajoutAnomalie(@RequestBody Anomalie anomalie){
        anomalie.setRefAnomalie(UUID.randomUUID().toString());
        return anomalieRepository.save(anomalie);
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
                orElseThrow(() -> new RuntimeException("Release introuvable "));
    }

    //Méthode de récupération d'un ticket sachant son ID
    @GetMapping("/ticket/{id}")
    public Ticket findTicketById(@PathVariable String id) {
        return ticketRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Ticket introuvable "));
    }

    //Méthode de récupération d'un cas de test sachant ID
    @GetMapping("/casTest/{id}")
    public CasDeTest findCasTestById(@PathVariable String id) {
        return casDeTestRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Cas de test introuvable "));
    }

    //Méthode de récupération d'une anomalie sachant son ID
    @GetMapping("/anomalie/{id}")
    public Anomalie findAnomalieById(@PathVariable String id) {
        return anomalieRepository.findById(id).
                orElseThrow(() -> new RuntimeException("L'anomalie est introuvable "));
    }


    //Ce qui peut être une possibilité en cas de besoin
    //Méthode de récupération d'un testeur sachant son ID
    //Méthode de récupération d'un Scénario de test sachant son ID


    //Modification


    //Méthode de modification d'un release
    @PutMapping("/updateRelease/{id}")
    public Release updateRelease(@RequestBody Release release,@PathVariable String id){
        release.setRefRelease(id);
        return releaseRepository.save(release);
    }

    //Méthode de modification d'un ticket
    @PutMapping("/updateTicket/{id}")
    public Ticket updateTicket(@RequestBody Ticket ticket,@PathVariable String id){
        ticket.setRefTicket(id);
        return ticketRepository.save(ticket);
    }

    //Méthode de modification de testeur
    @PutMapping("/updateTesteur/{id}")
    public Testeur updateTesteur(@RequestBody Testeur testeur,@PathVariable Long id){
        testeur.setIdTesteur(id);
        return testeurRepository.save(testeur);
    }

    //Méthode de modification d'un cas de test
    @PutMapping("/updateCasTest/{id}")
    public CasDeTest updateCasTest(@RequestBody CasDeTest casDeTest,@PathVariable String id){
        casDeTest.setRefCasTest(id);
        return casDeTestRepository.save(casDeTest);
    }

    //Méthode de modification d'une anomalie
    @PutMapping("/updateAnomalie/{id}")
    public Anomalie updateAnomalie(@RequestBody Anomalie anomalie,@PathVariable String id){
        anomalie.setRefAnomalie(id);
        return anomalieRepository.save(anomalie);
    }

    //Méthode de modification d'un Scénario de test
    @PutMapping("/updateScenario/{id}")
    public ScenarioDeTest updateScenario(@RequestBody ScenarioDeTest scenarioDeTest,@PathVariable String id){
        scenarioDeTest.setRefScenario(id);
        return scenarioDeTestRepository.save(scenarioDeTest);
    }


    //SUPPRESSION

    //Méthode de suppression d'un release
    @DeleteMapping("/deleteRelease/{id}")
    public void deleteRelease(@PathVariable String id){
        releaseRepository.deleteById(id);
    }

    //Méthode de suppression d'un ticket
    @DeleteMapping("/deleteTicket/{id}")
    public void deleteTicket(@PathVariable String id){
        ticketRepository.deleteById(id);
    }

    //Méthode de suppression d'une anomalie
    @DeleteMapping("/deleteAnomalie/{id}")
    public void deleteAnomalie(@PathVariable String id){
        anomalieRepository.deleteById(id);
    }

    //Méthode de suppression d'un testeur
    @DeleteMapping("/deleteTesteur/{id}")
    public void deleteTesteur(@PathVariable Long id){
        testeurRepository.deleteById(id);
    }

    //Méthode de suppression d'un cas de test
    @DeleteMapping("/deleteCasTest/{id}")
    public void deleteCasTest(@PathVariable String id){
        casDeTestRepository.deleteById(id);
    }

    //Méthode de suppression d'un Scénario de test
    @DeleteMapping("/deleteScenario/{id}")
    public void deleteScenario(@PathVariable String id){
        scenarioDeTestRepository.deleteById(id);
    }



}
