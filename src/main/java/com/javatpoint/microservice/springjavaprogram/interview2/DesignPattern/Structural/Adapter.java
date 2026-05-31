package com.javatpoint.microservice.springjavaprogram.interview2.DesignPattern.Structural;

// Structural - Adapter
/*
     Allow In-Compataible Interfaces to work together
     want to add additional functionality without modifying existing code.
*/
public class Adapter {
    public static void main(String args[]) {
        MediaPlayer mediaPlayer = new MediaAdapter();
        mediaPlayer.play("mp3","songs.mp3");
        mediaPlayer.play("vlc","video.vlc");
        mediaPlayer.play("mp4","rathore.mp4");
        mediaPlayer.play("vlx","doc.vlx");
    }
}

interface MediaPlayer {
    public void play(String audioType,String fileName);
}

class AdvanceMediaPlayer {

    public void playVlc(String fileName) {
        System.out.println("Playing VLC File : "+fileName);
    }

    public void playMp4(String fileName) {
        System.out.println("Playing Mp4 File : "+fileName);
    }

}

class MediaAdapter implements MediaPlayer {
    AdvanceMediaPlayer advanceMediaPlayer = new AdvanceMediaPlayer();

    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("mp3")){
            System.out.println("Playing Mp3 File : "+fileName);
        }else if(audioType.equalsIgnoreCase("mp4")){
            advanceMediaPlayer.playMp4(fileName);
        }else if(audioType.equalsIgnoreCase("vlc")){
            advanceMediaPlayer.playVlc(fileName);
        }else{
            System.out.println("UnSupported AudioType : "+audioType);
        }
    }
}
