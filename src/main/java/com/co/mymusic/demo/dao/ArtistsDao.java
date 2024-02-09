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
public class ArtistsDao {
    private String name;
    private ArrayList<String> geners;
    private String image;

    @Override
    public String toString() {
        return "ArtistsDao{" +
                "name='" + name + '\'' +
                ", geners=" + geners +
                ", image='" + image + '\'' +
                '}';
    }
}
