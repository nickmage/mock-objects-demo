package com.nixsolutions.ppp.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static com.nixsolutions.ppp.demo.Runner.MY_FAVORITE_MUSIC;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestRunnerWithSpy {

    @Spy
    private final MusicPlayer musicPlayer = new DigitalMusicPlayer();

    @Test
    public void shouldPlayMockedMusic() {
        String mockedMusic = "Music from mock";
        when(musicPlayer.playMusic(MY_FAVORITE_MUSIC)).thenReturn(mockedMusic);

        String actualMusic = musicPlayer.playMusic(MY_FAVORITE_MUSIC);
        verify(musicPlayer).playMusic(MY_FAVORITE_MUSIC);

        assertEquals(mockedMusic, actualMusic);
    }

}
