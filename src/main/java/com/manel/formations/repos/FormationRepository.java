package com.manel.formations.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manel.formations.entities.Formation;

public interface FormationRepository extends JpaRepository<Formation, Long> {

}
