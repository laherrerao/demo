package com.co.mymusic.demo.spotifyServices;

import com.co.mymusic.demo.dto.GetAccesToken;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.reactive.function.client.WebClient;

import static org.junit.jupiter.api.Assertions.*;

class WebServicesTest {

    @Autowired
    private WebClient webClient;

    @Value("${spotify.clientId}")
    private String clientId;

    @Value("${spotify.clientSecret}")
    private String clientSecret;



      void getToken() {
        GetAccesToken getAccessToken =webClient.post()
                .uri("https://accounts.spotify.com/api/token?"+
                        "grant_type=client_credentials"+
                        "&client_id=".concat(clientId)+
                        "&client_secret=".concat(clientSecret))
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .retrieve()
                .bodyToMono(GetAccesToken.class).block();

          Assertions.assertNotNull(getAccessToken.getAccess_token());
    }




}