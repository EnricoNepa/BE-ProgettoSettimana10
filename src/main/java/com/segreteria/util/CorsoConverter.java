package com.segreteria.util;

import com.segreteria.model.Corso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.converter.Converter;

public class CorsoConverter implements Converter<String, Corso>{

	@Autowired
	ApplicationContext ctx;
	
	@Override
	public Corso convert(String codice) {
		DataBase database= ctx.getBean(DataBase.class) ;
	    for(Corso c: database.getCorsi()) {
	    	if(c.getCodice().equals(codice)) {
	    		return c;
	    	}
	    }
		return null;
	}

}
