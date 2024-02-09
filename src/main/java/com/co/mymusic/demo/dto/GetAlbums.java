package com.co.mymusic.demo.dto;

import lombok.Getter;

@Getter
public class GetAlbums {
    public Albums albums;

    @Override
    public String toString() {
        return "GetAlbums{" +
                "albums=" + albums +
                '}';
    }
}
