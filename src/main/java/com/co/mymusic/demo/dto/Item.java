package com.co.mymusic.demo.dto;

import lombok.Getter;

import java.util.ArrayList;
@Getter
public class Item {

    public Album album;
    public ArrayList<Artist> artists;
    public ArrayList<String> available_markets;
    public int disc_number;
    public int duration_ms;
    public boolean explicit;
    public ExternalIds external_ids;
    public ExternalUrls external_urls;
    public String href;
    public String id;
    public boolean is_local;
    public String name;
    public int popularity;
    public String preview_url;
    public int track_number;
    public String type;
    public String uri;

    @Override
    public String toString() {
        return "Item{" +
                "album=" + album +
                ", artists=" + artists +
                ", available_markets=" + available_markets +
                ", disc_number=" + disc_number +
                ", duration_ms=" + duration_ms +
                ", explicit=" + explicit +
                ", external_ids=" + external_ids +
                ", external_urls=" + external_urls +
                ", href='" + href + '\'' +
                ", id='" + id + '\'' +
                ", is_local=" + is_local +
                ", name='" + name + '\'' +
                ", popularity=" + popularity +
                ", preview_url='" + preview_url + '\'' +
                ", track_number=" + track_number +
                ", type='" + type + '\'' +
                ", uri='" + uri + '\'' +
                '}';
    }
}
