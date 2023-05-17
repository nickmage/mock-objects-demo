package com.nixsolutions.ppp.demo;

public class DigitalMusicPlayer implements MusicPlayer {

    @Override
    public String playMusic(String music) {
        System.out.printf("Playing %s...\n", music);
        return music;
    }

}
