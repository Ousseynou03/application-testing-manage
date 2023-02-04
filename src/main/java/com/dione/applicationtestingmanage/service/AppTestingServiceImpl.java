package com.dione.applicationtestingmanage.service;

import com.dione.applicationtestingmanage.entity.*;
import com.dione.applicationtestingmanage.enums.*;
import com.dione.applicationtestingmanage.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@Transactional
public class AppTestingServiceImpl implements IAppTestingService{

    private final ReleaseRepository releaseRepository;
    private final TicketRepository ticketRepository;
    private final TesteurRepository testeurRepository;
    private final ScenarioDeTestRepository scenarioDeTestRepository;
    private final CasDeTestRepository casDeTestRepository;
    private final AnomalieRepository anomalieRepository;

    public AppTestingServiceImpl(ReleaseRepository releaseRepository, TicketRepository ticketRepository, TesteurRepository testeurRepository, ScenarioDeTestRepository scenarioDeTestRepository, CasDeTestRepository casDeTestRepository, AnomalieRepository anomalieRepository) {
        this.releaseRepository = releaseRepository;
        this.ticketRepository = ticketRepository;
        this.testeurRepository = testeurRepository;
        this.scenarioDeTestRepository = scenarioDeTestRepository;
        this.casDeTestRepository = casDeTestRepository;
        this.anomalieRepository = anomalieRepository;
    }

    //Initialisation des données de releases
    @Override
    public void initRelease() {
        for (int i=0; i<10;i++){
            Release release = new Release();
            release.setRefRelease(UUID.randomUUID().toString());
            release.setDateLivraison(new Date());
            release.setDatePrevision(new Date());
            release.setDateReelle(new Date());
            releaseRepository.save(release);
        }

    }

    //Initialisation des données de Ticket
    @Override
    public void initTicket() {
        releaseRepository.findAll().forEach(release -> {
            //testeurRepository.findAll().forEach(testeur -> {
            Stream.of("Déclaration des salaires","Controle de validite","Affilié ajouté sur un mois M").forEach(titreTicket -> {
                Ticket ticket = new Ticket();
                ticket.setRefTicket(UUID.randomUUID().toString());
                ticket.setTitre(titreTicket);
                ticket.setType(Math.random() > 0.5 ? Types.ANOMALIE : Types.EVOLUTION);
                ticket.setTesteur(ticket.getTesteur());
                ticketRepository.save(ticket);
            });
        });
        // });

    }


    //Initialisation des données des anomalies
    @Override
    public void initAnomalie() {
        //releaseRepository.findAll().forEach(rel -> {
        //  rel.getTesteurs().forEach(test -> {
        // test.getCasDeTests().forEach(cas -> {
        //ticketRepository.findAll().forEach(tick -> {
        Anomalie anomalie = new Anomalie();
        anomalie.setRefAnomalie(UUID.randomUUID().toString());
        double randomNumber = Math.random();
        Criticite criticite;
        if (randomNumber < 0.33){
            criticite = Criticite.BLOQUANTE;
        } else if (randomNumber < 0.67) {
            criticite = Criticite.MAJEURE;
        }else {
            criticite = Criticite.MINEURE;
        }
        anomalie.setCriticite(criticite);
        anomalie.setRefAnomalie(UUID.randomUUID().toString());
        double randomNumber2 = Math.random();
        Statut statut;
        if (randomNumber2 < 0.33){
            statut = Statut.FERME;
        } else if (randomNumber2 < 0.67) {
            statut = Statut.OUVERTE;
        }else {
            statut = Statut.CLOTUREE;
        }
        anomalie.setStatut(statut);
        double randomNumber3 = Math.random();
        EnCours enCours;
        if (randomNumber3 < 0.33){
            enCours = EnCours.Atraite;
        } else if (randomNumber3 < 0.67) {
            enCours = EnCours.Verification;
        }else {
            enCours = EnCours.Corrigees;
        }
        anomalie.setEnCours(enCours);
        double randomNumber4 = Math.random();
        Cloturee cloturee;
        if (randomNumber4 < 0.25){
            cloturee = Cloturee.Rejetees;
        } else if (randomNumber4 < 0.5) {
            cloturee =  Cloturee.ProblemeDocumentaire;
        }else if(randomNumber4 < 0.75){
            cloturee = Cloturee.ArbitrageProjetEvolution;
        }else {
            cloturee = Cloturee.ValidationCorrectifs;
        }
        anomalie.setCloturee(cloturee);
        anomalie.setTickets(anomalie.getTickets());
        anomalieRepository.save(anomalie);
        // });
        //  });
        //});
        //});

    }

    //Initialisation des données de Scenario de test

    @Override
    public void initScenarioDeTest() {
        // releaseRepository.findAll().forEach(re -> {
        //re.getTesteurs().forEach(t -> {
        // casDeTestRepository.findAll().forEach(casTest -> {
        Stream.of("Scenario", "ScenarioTest1", "ScenarioTest2").forEach(nomScenario -> {
            ScenarioDeTest scenarioDeTest = new ScenarioDeTest();
            scenarioDeTest.setRefScenario(UUID.randomUUID().toString());
            scenarioDeTest.setScenario(nomScenario);
            scenarioDeTest.setCasDeTest(scenarioDeTest.getCasDeTest());
            scenarioDeTestRepository.save(scenarioDeTest);
        });
        // });
        // });
        //  });


    }

    //Initialisation des données de Testeur
    @Override
    public void initTesteur() {
        releaseRepository.findAll().forEach(release -> {

                Testeur testeur = new Testeur();
                testeur.setIdTesteur(UUID.randomUUID().toString());
                testeur.setNom(Math.random() > 0.5 ? Nom.Richard : Nom.Andres);
                testeur.setReleases(testeur.getReleases());
                testeur.setCasDeTests(testeur.getCasDeTests());
                testeurRepository.save(testeur);
            });


    }

    //Initialisation des données de Cas de test
    @Override
    public void initCasDeTest() {
        //ticketRepository.findAll().forEach(ticket -> {
        //testeurRepository.findAll().forEach(teste -> {
        CasDeTest  casDeTest = new CasDeTest();
        casDeTest.setRefCasTest(UUID.randomUUID().toString());
        double randomNumber5 = Math.random();
        Resultat resultat;

        if (randomNumber5 < 0.2) {
            resultat = Resultat.OK;
        } else if (randomNumber5 < 0.4) {
            resultat = Resultat.KO;
        } else if (randomNumber5 < 0.6) {
            resultat = Resultat.Nonteste;
        } else if (randomNumber5 < 0.8) {
            resultat = Resultat.Abandonnes;
        } else {
            resultat = Resultat.HorsPerimetre;
        }

        casDeTest.setResultat(resultat);
        casDeTest.setTesteur(casDeTest.getTesteur());
        casDeTestRepository.save(casDeTest);
        // });
        // });


    }
}