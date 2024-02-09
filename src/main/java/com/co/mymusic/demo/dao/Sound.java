package com.co.mymusic.demo.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Sound {

    private String name;

    private ArrayList<String> artists;

    private  String album;

    private String image;

    @Override
    public String toString() {
        return "Sound{" +
                "name='" + name + '\'' +
                ", artists=" + artists +
                ", album='" + album + '\'' +
                '}';
    }
}
