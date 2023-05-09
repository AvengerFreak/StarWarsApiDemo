package com.starwars.starwars;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.net.URL;
import java.net.URLConnection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class StarWarsController {
    
    @GetMapping("/films")
    public ResponseEntity<Object> getFilms() {
		
        try {

            String GET_STARWARS_FILMS_URL = "https://swapi.dev/api/films";
            URL request = new URL(GET_STARWARS_FILMS_URL);
            URLConnection connection = request.openConnection();  
            connection.setDoOutput(true); 

            InputStream input = request.openStream();
            InputStreamReader isr = new InputStreamReader(input);
            BufferedReader reader = new BufferedReader(isr);
            StringBuilder response = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                response.append((char) c);
            }
            
            return new ResponseEntity<>(response.toString(), HttpStatus.OK);
        }

        catch(Exception e){
            return new ResponseEntity<>("Error message body", HttpStatus.BAD_REQUEST);
        }


	}
}
