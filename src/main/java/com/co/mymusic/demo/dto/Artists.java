package com.co.mymusic.demo.dto;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Artists {
    public String href;
    public ArrayList<ItemsArtists> items;
    public int limit;
    public String next;
    public int offset;
    public Object previous;
    public int total;

    @Override
    public String toString() {
        return "Artists{" +
                "href='" + href + '\'' +
                ", items=" + items +
                ", limit=" + limit +
                ", next='" + next + '\'' +
                ", offset=" + offset +
                ", previous=" + previous +
                ", total=" + total +
                '}';
    }
}
