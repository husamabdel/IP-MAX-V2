import java.net.*;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.awt.desktop.*;

public class webRequests {
	
	
	// GLOBALS
	String ip;
    String url;
	ipObject ipobj;
	

	//GETTERS AND SETTERS
	public String getIp() {
		return ip;
	}

	public void setIp(String tip) {
		ip = tip;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ipObject getIpobj() {
		return ipobj;
	}

	public void setIpobj(ipObject ipobj) {
		this.ipobj = ipobj;
	}

	
	//Set the URI for the rest API
	public URI setURI(String ip) {
		
		URI uri = URI.create("https://ipapi.co/"+ip+"/json/");
		
		return uri;
	}
	
	
	//Sends the actual web requests, returns a string of the JSON file.
	public String requestJson(URI uri) throws IOException, InterruptedException {
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest ipRequest = HttpRequest.newBuilder()
				.GET()
				.uri(uri)
				//.header(null, null)
				.build();
		
		HttpResponse<String> response = client.send(ipRequest, BodyHandlers.ofString());
		return response.body();
	
	}
	
	
	//@JsonIgnoreProperties(ignoreUnknown = true)
	//Maps the JSON response to an POJO (ipObject class)
	public void MapObjects(String jsonFile) throws JsonMappingException, JsonProcessingException {
		
				ObjectMapper mapper = new ObjectMapper();
				
				JsonNode node = mapper.readTree(jsonFile);
		
				ipobj = mapper.treeToValue(node, ipObject.class);
		
	}
	
	
	//The constructor that creates all of the required.
	public webRequests(String ip) throws IOException, InterruptedException {
		
	setIp(ip);
	URI uriNeeded =setURI(ip);
	String jsonFile = requestJson(uriNeeded);
	MapObjects(jsonFile);
		
	}
	
	//THe actual object after its been initialized with the mapped response JSON file.
	public ipObject CreateObject() {
		
		return ipobj;
	}
	
}
