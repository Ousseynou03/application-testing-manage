package com.dione.applicationtestingmanage.repository;

import com.dione.applicationtestingmanage.entity.CasDeTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface CasDeTestRepository extends JpaRepository<CasDeTest, String> {
}
