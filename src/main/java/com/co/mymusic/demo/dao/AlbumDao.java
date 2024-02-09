package com.co.mymusic.demo.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlbumDao {

    private String name;

    private ArrayList<String> artists;

    private String image;

    @Override
    public String toString() {
        return "AlbumDao{" +
                "name='" + name + '\'' +
                ", artists=" + artists +
                ", image=" + image +
                '}';
    }
}
