package com.nixsolutions.ppp.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.nixsolutions.ppp.demo.Runner.MY_FAVORITE_MUSIC;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TestRunner {

    @Mock
    private MusicPlayer musicPlayer;
    @InjectMocks
    private Runner runner;
    @Captor
    private ArgumentCaptor<String> captor;

    @Test
    public void shouldPlayMockedMusic() {
        String mockedMusic = "Music from mock";
        String expectedMusic = "Music played: " + mockedMusic;
        given(musicPlayer.playMusic(MY_FAVORITE_MUSIC)).willReturn(mockedMusic);

        String actualMusic = runner.playMyFavoriteSong();

        assertEquals(expectedMusic, actualMusic);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowMockedException() {
        given(musicPlayer.playMusic(MY_FAVORITE_MUSIC)).willThrow(new RuntimeException());

        runner.playMyFavoriteSong();
    }

    @Test
    public void shouldVerifyThatExpectedMusicPlayerParamPassed() {
        String expectedMusicPlayerParam = MY_FAVORITE_MUSIC;

        runner.playMyFavoriteSong();
        verify(musicPlayer).playMusic(captor.capture());
        String capturedValue = captor.getValue();

        assertEquals(expectedMusicPlayerParam, capturedValue);
    }

}