package com.segreteria.util;

import com.segreteria.model.Corso;
import com.segreteria.model.Studente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class DataBaseInit implements CommandLineRunner{

	@Autowired
	ApplicationContext ctx;

	@Override
	public void run(String... args) throws Exception {
		DataBase db = ctx.getBean(DataBase.class);
		fillDataBase(db);
		log.info("Test Database caricato");
	}

	public void fillDataBase(DataBase db) {
		//FILL CORSI
		Corso corso = new Corso();
		Corso corso1 = new Corso();
		Corso corso2 = new Corso();
		corso.setCodice("AAA-111");
		corso.setIndirizzo("Via Carducci 9");
		corso.setNome("Lettere");
		corso.setNumeroEsami(15);
		corso1.setCodice("BBB-222");
		corso1.setIndirizzo("Via Trieste 87");
		corso1.setNome("Inglese");
		corso1.setNumeroEsami(15);
		corso2.setCodice("CCC-333");
		corso2.setIndirizzo("Via Palermo 11");
		corso2.setNome("Robotica");
		corso2.setNumeroEsami(15);
		db.aggiungiCorso(corso);
		db.aggiungiCorso(corso1);
		db.aggiungiCorso(corso2);
		
		//FILL STUDENTI
		Studente s1= new Studente();
		Studente s2= new Studente();
		Studente s3= new Studente();
		s1.setDataN("1999-05-05");
		s1.setCitta("Milano");
		s1.setCorso(corso1);
		s1.setCognome("Rossi");
		s1.setEmail("mario.rossi@email.com");
		s1.setMatricola("ABC101");
		s1.setNome("Mario");
		s1.setIndirizzo("Via Silvi 56");
		
		s2.setDataN("1989-10-12");
		s2.setCitta("Roma");
		s2.setCorso(corso2);
		s2.setCognome("Verdi");
		s2.setEmail("luigi.verdi@email.com");
		s2.setMatricola("ABC102");
		s2.setNome("Luigi");
		s2.setIndirizzo("Via Scarni 99");
		
		s3.setDataN("2001-11-09");
		s3.setCitta("Napoli");
		s3.setCorso(corso);
		s3.setCognome("Bianchi");
		s3.setEmail("paolo.bianchi@email.com");
		s3.setMatricola("ABC103");
		s3.setNome("Paolo");
		s3.setIndirizzo("Via Mari 28");
		
		db.aggiungiStudente(s1);
		db.aggiungiStudente(s2);
		db.aggiungiStudente(s3);
		
		
	}
}
