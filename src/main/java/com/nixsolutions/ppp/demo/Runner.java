package com.nixsolutions.ppp.demo;

class Runner {

    public static String MY_FAVORITE_MUSIC = "Abc";
    private final MusicPlayer musicPlayer;

    Runner(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    public static void main(String[] args) {
        Runner runner = new Runner(new DigitalMusicPlayer());
        System.out.println(runner.playMyFavoriteSong());
    }

    public String playMyFavoriteSong() {
        return "Music played: " + musicPlayer.playMusic(MY_FAVORITE_MUSIC);
    }

}