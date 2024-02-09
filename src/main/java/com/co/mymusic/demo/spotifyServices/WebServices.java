package com.co.mymusic.demo.spotifyServices;

import com.co.mymusic.demo.dto.GetAccesToken;
import com.co.mymusic.demo.dto.GetAlbums;
import com.co.mymusic.demo.dto.GetArtists;
import com.co.mymusic.demo.dto.GetTracks;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Date;

@Service
@Getter
public class WebServices {

    @Value("${spotify.clientId}")
    private String clientId;

    @Value("${spotify.clientSecret}")
    private String clientSecret;

    @Autowired
    private WebClient webClient;

    private String access_token;
/*
    private final String host="https://accounts.spotify.com/api/token?"+
            "grant_type=client_credentials"+
            "&client_id=".concat(clientId)+
            "&client_secret=".concat(clientSecret);*/

    public String getToken(){

        GetAccesToken getAccessToken =webClient.post()
                .uri("https://accounts.spotify.com/api/token?"+
                        "grant_type=client_credentials"+
                        "&client_id=".concat(clientId)+
                        "&client_secret=".concat(clientSecret))
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .retrieve()
                .bodyToMono(GetAccesToken.class).block();

        return getAccessToken.getAccess_token();
    }

    @Scheduled(fixedRate = 3600000)
    public void newToken(){
        this.access_token=getToken();
        System.out.println( new Date() + " pasaron 1 Hora");
    }


    public GetTracks getTracks(String query){
        String uri="https://api.spotify.com/v1/search?query="+
                query+
                "&type=track&offset=0&limit=8";

        GetTracks getTracks = webClient.get()
                .uri(uri)
                .header(HttpHeaders.AUTHORIZATION,"Bearer "+ this.access_token)
                .retrieve()
                .bodyToMono(GetTracks.class).block();

        return getTracks;
    }

    public GetAlbums getAlbums(String query){
        String uri="https://api.spotify.com/v1/search?type=album&" +
                "query="+
                query+
                "&offset=0&limit=4";
        GetAlbums getAlbums =webClient.get()
                .uri(uri)
                .header(HttpHeaders.AUTHORIZATION,"Bearer "+ this.access_token)
                .retrieve()
                .bodyToMono(GetAlbums.class).block();
        return getAlbums;
    }

    public GetArtists getArtits(String query){
        String uri="https://api.spotify.com/v1/search?type=artist&" +
                "query="+
                query+
                "&offset=0&limit=4";

        GetArtists getArtists =webClient.get()
                .uri(uri)
                .header(HttpHeaders.AUTHORIZATION,"Bearer "+ this.access_token)
                .retrieve()
                .bodyToMono(GetArtists.class).block();

        return getArtists;
    }
}
