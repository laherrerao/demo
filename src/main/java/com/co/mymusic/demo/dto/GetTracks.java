package com.co.mymusic.demo.dto;

import lombok.Getter;

@Getter
public class GetTracks {
    public Tracks tracks;

    @Override
    public String toString() {
        return "GetTracks{" +
                "tracks=" + tracks +
                '}';
    }
}
