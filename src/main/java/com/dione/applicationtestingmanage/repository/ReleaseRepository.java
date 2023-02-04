package com.dione.applicationtestingmanage.repository;

import com.dione.applicationtestingmanage.entity.Release;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface ReleaseRepository extends JpaRepository<Release, String> {
}
