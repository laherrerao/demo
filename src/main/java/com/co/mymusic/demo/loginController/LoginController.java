package com.co.mymusic.demo.loginController;

import com.co.mymusic.demo.dao.AlbumDao;
import com.co.mymusic.demo.dao.ArtistsDao;
import com.co.mymusic.demo.dao.Sound;
import com.co.mymusic.demo.dto.*;
import com.co.mymusic.demo.spotifyServices.WebServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Controller

public class LoginController {
    @Autowired
    private WebServices spotifyServices;

    @Value("${spotify.clientId}")
    private String clientId;

    @GetMapping("/")
    public String indexPage(Model model){
        System.out.println("index");
        return "index";
    }


    @RequestMapping(value = "/getLogin",method = RequestMethod.GET)
    public String loginPage(){

        String login="https://accounts.spotify.com/authorize?client_id=".concat(clientId) +
                "&response_type" +
                "=code&redirect_uri=http://localhost:8080/login&%26scope=user-read-private%20user-read-email";
        return "redirect:" +login;
    }

    @GetMapping("/login")
    public String callback(@RequestParam(name="code",required = false) String code,@RequestParam(name = "error", required = false) String error, Model model) {

        if(error==null){
            System.out.println("code"+code);
            return "home";
        }else{
            return "redirect:/";
        }

    }

    @GetMapping("/logut")
    public String logout(){
        return "redirect:/";
    }


    @GetMapping("/search")
    public String search(@RequestParam(name = "query",required = false)String query,Model model){
        if(query.contains(" ")){
            query= query.replaceAll(" ","+");
        }


        //get 8 tracks for query
        GetTracks getTracks=spotifyServices.getTracks(query);
        ArrayList<Item> items= getTracks.getTracks().getItems();
        ArrayList<Sound> sounds = new ArrayList<>();

        for (int i=0;i<items.size();i++) {
            ArrayList<String> artist = new ArrayList<>();
            Sound sound =new Sound();
            sound.setName(items.get(i).getName());
            sound.setAlbum(items.get(i).getAlbum().getName());
            ArrayList<Image> images =items.get(i).getAlbum().getImages();
            ArrayList<String> img =new ArrayList<>();
            for (int j=0;j<images.size();j++){
                img.add(images.get(j).getUrl());
            }
            sound.setImage(img.get(0));
            ArrayList<Artist> artists = items.get(i).getArtists();
                for (int j=0;j<artists.size();j++){
                    artist.add(artists.get(j).getName());
                }
            sound.setArtists(artist);
            sounds.add(sound);
        }

        model.addAttribute("tracks",sounds);

        GetAlbums getAlbums =spotifyServices.getAlbums(query);

        ArrayList<Items> items1= getAlbums.albums.getItems();
        ArrayList<AlbumDao> almbumList = new ArrayList<>();

        for (int i=0;i<items1.size();i++){
            ArrayList<Artist> artists = items.get(i).getArtists();
            ArrayList<String> artist = new ArrayList<>();
            AlbumDao albumDao =new AlbumDao();
            albumDao.setName(items1.get(i).getName());
            System.out.println(items1.get(i).getName());
            for (int j=0;j<artists.size();j++){
                artist.add(artists.get(j).getName());
            }
            albumDao.setArtists(artist);
            ArrayList<Image> images=items1.get(i).getImages();
            ArrayList<String> img =new ArrayList<>();
            for (int j=0;j<images.size();j++){
                img.add(images.get(j).getUrl());
            }
            albumDao.setImage(img.get(0));

            almbumList.add(albumDao);
        }


        model.addAttribute("albums",almbumList);

        GetArtists getArtists =spotifyServices.getArtits(query);
        ArrayList<ItemsArtists> itemsArtists =getArtists.artists.getItems();
        ArrayList<ArtistsDao> artistsDaos =new ArrayList<>();

        for(int i=0;i<itemsArtists.size();i++){
            ArtistsDao artist = new ArtistsDao();
            artist.setName(itemsArtists.get(i).getName());
            artist.setGeners(itemsArtists.get(i).genres);
            artist.setImage(itemsArtists.get(i).getImages().get(0).getUrl());

            artistsDaos.add(artist);
        }

        model.addAttribute("artists",artistsDaos);
        return "result";
    }

}
