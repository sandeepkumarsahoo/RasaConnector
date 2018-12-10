package com.rasa.demo;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RasaController {

	@RequestMapping("/core/message/{message}")
	public String get(@PathVariable String message) {

		RestTemplate restTemplate = new RestTemplate();

		String url = "http://localhost:5005/webhooks/rest/webhook";
		String requestJson = "{\"message\":\""+message+"\"}";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);
		String answer = restTemplate.postForObject(url, entity, String.class);
		System.out.println(answer);

		return answer;
	}
}
