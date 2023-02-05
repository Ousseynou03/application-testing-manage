package com.dione.applicationtestingmanage.service;

public interface IAppTestingService {
    //Iniatialisation des classes
    public void initRelease();
    public void initTicket();
    public void initAnomalie();
    public void initScenarioDeTest();
    public void initCasDeTest();
    public void initTesteur();
}
