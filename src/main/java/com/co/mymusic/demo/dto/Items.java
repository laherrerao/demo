package com.co.mymusic.demo.dto;

import lombok.Getter;

import java.util.ArrayList;
@Getter
public class Items {

    public String album_type;
    public ArrayList<Artist> artists;
    public ArrayList<String> available_markets;
    public ExternalUrls external_urls;
    public String href;
    public String id;
    public ArrayList<Image> images;
    public String name;
    public String release_date;
    public String release_date_precision;
    public int total_tracks;
    public String type;
    public String uri;

    @Override
    public String toString() {
        return "Items{" +
                "album_type='" + album_type + '\'' +
                ", artists=" + artists +
                ", available_markets=" + available_markets +
                ", external_urls=" + external_urls +
                ", href='" + href + '\'' +
                ", id='" + id + '\'' +
                ", images=" + images +
                ", name='" + name + '\'' +
                ", release_date='" + release_date + '\'' +
                ", release_date_precision='" + release_date_precision + '\'' +
                ", total_tracks=" + total_tracks +
                ", type='" + type + '\'' +
                ", uri='" + uri + '\'' +
                '}';
    }
}
