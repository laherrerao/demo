package com.co.mymusic.demo.dto;

import lombok.Getter;

@Getter
public class GetArtists {

    public Artists artists;

    @Override
    public String toString() {
        return "GetArtits{" +
                "artists=" + artists +
                '}';
    }
}
