package com.co.mymusic.demo.dto;

import lombok.Getter;

@Getter
public class Artist {

    public ExternalUrls external_urls;
    public String href;
    public String id;
    public String name;
    public String type;
    public String uri;

    @Override
    public String toString() {
        return "Artist{" +
                "external_urls=" + external_urls +
                ", href='" + href + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", uri='" + uri + '\'' +
                '}';
    }
}
