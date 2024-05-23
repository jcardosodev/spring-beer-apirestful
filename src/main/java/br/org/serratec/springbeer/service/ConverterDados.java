package br.org.serratec.springbeer.service;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ConverterDados {
	
	private ObjectMapper mapper = new ObjectMapper();
	
	public <T> T converter(String json, Class<T> classe) {
		try {
			return mapper.readValue(json, classe);
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
}
