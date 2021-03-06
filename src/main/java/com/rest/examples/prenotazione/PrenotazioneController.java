package com.rest.examples.prenotazione;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.examples.prenotazione.entity.PrenotazioneEntity;
import com.rest.examples.prenotazione.model.Prenotazione;


@RestController
public class PrenotazioneController  {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	PrenotazioneService prenotazioneService;

	List<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();

	@PostMapping(path = "/API/prenotazione")
	ResponseEntity<String> prenota(@RequestParam Map<String, String> body){

		prenotazioni.add(new Prenotazione(1, body.get("name"), body.get("surname"), body.get("email"), Integer.parseInt(body.get("age"))));

		return ResponseEntity.status(HttpStatus.OK).body(prenotazioni.get(0).getNome()  +" prenotato in data: ");
	}
	/*
	@PostMapping("/API/prenot")
	Prenotazione registra(@RequestParam Map<String, String> body) {

		Prenotazione prenotazione = pr.create(new Prenotazione(1, body.get("name"), body.get("surname"), body.get("email"), Integer.parseInt(body.get("age"))));

		return prenotazione;
	}
	 */


	@PostMapping(value="/API/prenot", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE) 
	PrenotazioneEntity registra(PrenotazioneEntity prenotazi) {
		System.out.print(prenotazi);
		prenotazioneService.addPrenotazione(prenotazi);
		return prenotazi;
	}

	@GetMapping(value = "/API/prenot/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	Optional<PrenotazioneEntity> recupera(@PathVariable("id") Long id) {
		return prenotazioneService.getPrenotazione(id);
	}

	@GetMapping("/API/prenot/")
	List<PrenotazioneEntity> lista(){
		List<PrenotazioneEntity> list = prenotazioneService.getAll();
		return list;
	}


}
