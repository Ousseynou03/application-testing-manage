package com.dione.applicationtestingmanage.repository;

import com.dione.applicationtestingmanage.entity.Testeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TesteurRepository extends JpaRepository<Testeur, Long> {

}
