package com.rest.examples.prenotazione.dao;

import java.util.List;
import java.util.Optional;

import com.rest.examples.prenotazione.entity.PrenotazioneEntity;

public interface PrenotazioneDAO {

	public void addPrenotazione(PrenotazioneEntity prenotazione);
	
	public Optional<PrenotazioneEntity> getPrenotazione(long id);
	
	public List<PrenotazioneEntity> getAll();
	
}
