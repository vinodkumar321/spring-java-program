package com.javatpoint.microservice.springjavaprogram.DesignPatterns.Structural;

/*
     Structural  Design Patterns --> deals with the Object Composition
    -> Adapter -> Allows Incompaitable Interfaces to work together -> Media Player that Plays .mp3 files only we want to add functionality of playing .mp4 and .vlc files also. create Adapter to Handle New Class Implementation
*/

public class AdapterExample {
    public static void main(String args[]){
        System.out.println("Structural Design Pattern Examples -> Adaptor");
        MediaPlayer mediaPlayer = new MediaAdapter();
        String mp3File = "vinod.mp3";
        mediaPlayer.play(mp3File);
        String mp4File = "Music.mp4";
        mediaPlayer.play(mp4File);
        String vlcFile = "Movie Kesari2.vlc";
        mediaPlayer.play(vlcFile);
    }
}

interface MediaPlayer {
    public void play(String fileName);
}

class OldMediaPlayer implements MediaPlayer {
    @Override
    public void play(String fileName) {
        System.out.println("Playing mp3 file , fileName : "+fileName);
    }
}

class Mp4MediaPlayer implements MediaPlayer {
    @Override
    public void play(String fileName) {
        System.out.println("Playing mp4 file , fileName : "+fileName);
    }
}

class VlcMediaPlayer implements MediaPlayer {
    @Override
    public void play(String fileName) {
        System.out.println("Playing Vlc file , fileName : "+fileName);
    }
}

class MediaAdapter implements MediaPlayer {

    @Override
    public void play(String fileName) {
        if(fileName.contains(".mp3")){
            OldMediaPlayer oldMediaPlayer = new OldMediaPlayer();
            oldMediaPlayer.play(fileName);
        }else if(fileName.contains(".mp4")){
            Mp4MediaPlayer mp4MediaPlayer = new Mp4MediaPlayer();
            mp4MediaPlayer.play(fileName);
        }else if(fileName.contains(".vlc")){
            VlcMediaPlayer vlcMediaPlayer = new VlcMediaPlayer();
            vlcMediaPlayer.play(fileName);
        }else{
            System.out.println("Provided File format not Support to Play...");
        }
    }
}

