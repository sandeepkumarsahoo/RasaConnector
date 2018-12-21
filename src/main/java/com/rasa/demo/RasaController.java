package com.rasa.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

@RestController
//@RequestMapping("/core")
public class RasaController {

	@Value("${RASA_CORE_WEBHOOK_URL}")
	private String URL;

	@RequestMapping("/")
	@ResponseBody
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}

	@PostMapping(value = "/message", produces = "application/json")
	public ResponseEntity<String> get(@RequestBody String message) {
		RestTemplate restTemplate = new RestTemplate();
		String url = URL + "/webhooks/rest/webhook";
		System.out.println(url);
		// String requestJson = "{\"message\":\"" + message + "\"}";
		// System.out.println(requestJson);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(message, headers);
		String answer = restTemplate.postForObject(url, entity, String.class);
		System.out.println(answer);
		RasaResponse[] responseMap = new Gson().fromJson(answer, RasaResponse[].class);
		RasaResponse response=responseMap[0];
		return new ResponseEntity<String>(response.getText(), HttpStatus.OK);
	}

	@GetMapping(value = "/status", produces = "application/json")
	public ResponseEntity<String> checkStatus() {
		// http://localhost:5005/status
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String answer = restTemplate.getForObject(URL + "/status", String.class);
		System.out.println(answer);
		return new ResponseEntity<String>(answer, HttpStatus.OK);
	}

	@GetMapping(value = "/hi", produces = "application/json")
	public ResponseEntity<String> sayHiToRasa() {
		RestTemplate restTemplate = new RestTemplate();
		// String url = "http://localhost:5005/";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String answer = restTemplate.getForObject(URL, String.class);
		System.out.println(answer);
		return new ResponseEntity<String>(answer, HttpStatus.OK);
	}

	@GetMapping(value = "/domain", produces = "application/json", consumes = "application/json")
	public ResponseEntity<String> readDomain() {
		RestTemplate restTemplate = new RestTemplate();
		// String url = "http://localhost:5005/domain";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String answer = restTemplate.getForObject(URL + "/domain", String.class);
		System.out.println(answer);
		return new ResponseEntity<String>(answer, HttpStatus.OK);
	}
}
