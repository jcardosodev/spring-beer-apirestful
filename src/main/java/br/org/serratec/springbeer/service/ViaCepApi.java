package br.org.serratec.springbeer.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.springframework.stereotype.Service;

@Service
public class ViaCepApi {
	
	private static String buscarApiViaCep(String endereco) {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(endereco)).build();
		
		HttpResponse<String> response = null;
		
			try {
				response = client.send(request, BodyHandlers.ofString());
			} catch (IOException | InterruptedException e) {
				
				e.printStackTrace();
			}
			
			return response.body();
		}
	
	public static String obterDadosViaCep(String cep) {
		String endereco = "https://viacep.com.br/ws/" + cep + "/json/";
		
		return buscarApiViaCep(endereco);
	}
}
