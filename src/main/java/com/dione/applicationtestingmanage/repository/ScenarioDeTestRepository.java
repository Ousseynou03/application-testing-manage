package com.dione.applicationtestingmanage.repository;

import com.dione.applicationtestingmanage.entity.ScenarioDeTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface ScenarioDeTestRepository extends JpaRepository<ScenarioDeTest, String> {
}
