package com.co.mymusic.demo.dto;

import lombok.Getter;

import java.util.ArrayList;
@Getter
public class Tracks {

    public String href;
    public ArrayList<Item> items;
    public int limit;
    public String next;
    public int offset;
    public Object previous;
    public int total;

    @Override
    public String toString() {
        return "Tracks{" +
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
