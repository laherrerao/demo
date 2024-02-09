package com.co.mymusic.demo.dto;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class ItemsArtists
{
    public ExternalUrls external_urls;
    public Followers followers;
    public ArrayList<String> genres;
    public String href;
    public String id;
    public ArrayList<Image> images;
    public String name;
    public int popularity;
    public String type;
    public String uri;

    @Override
    public String toString() {
        return "ItemsArtists{" +
                "external_urls=" + external_urls +
                ", followers=" + followers +
                ", genres=" + genres +
                ", href='" + href + '\'' +
                ", id='" + id + '\'' +
                ", images=" + images +
                ", name='" + name + '\'' +
                ", popularity=" + popularity +
                ", type='" + type + '\'' +
                ", uri='" + uri + '\'' +
                '}';
    }
}
