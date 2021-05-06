package com.rest.examples.prenotazione.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rest.examples.prenotazione.entity.PrenotazioneEntity;
import com.rest.examples.prenotazione.repository.PrenotazioneRepository;

@Component
public class PrenotazioneDAOimpl implements PrenotazioneDAO{
	
	@Autowired
	PrenotazioneRepository repository;
		
	@Override
	public void addPrenotazione(PrenotazioneEntity prenotazione) {
		
		//this.session.getCurrentSession().save(prenotazione);
		repository.save(prenotazione);
	}


	@Override
	public Optional<PrenotazioneEntity> getPrenotazione(long id) {
		
		//return this.session.getCurrentSession().get(PrenotazioneEntity.class,	id);
		return repository.findById(id);
	}


	@Override
	public List<PrenotazioneEntity> getAll() {
		return repository.findAll();
	}
	 
	 
	

}
