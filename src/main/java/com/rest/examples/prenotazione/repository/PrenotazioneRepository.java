package com.rest.examples.prenotazione.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.examples.prenotazione.entity.PrenotazioneEntity;
 
 
@Repository
public interface PrenotazioneRepository extends JpaRepository<PrenotazioneEntity, Long> {
 
}