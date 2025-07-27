package com.javatpoint.microservice.springjavaprogram.DesignPatterns.Structural;

/*
     Structural Design Patterns --> deals with the Object Composition
    -> Composite --> Treats Indivisual Object & group of Objects Uniformly , Think of it as File System Simulator where Folders and Files Should be Accessed using same Methods ( display(), getsize())
*/

import org.springframework.boot.autoconfigure.ssl.SslProperties;

import java.util.ArrayList;
import java.util.List;

public class CompositeExample {
   public static void main(String args[]){
       System.out.println("Structural Design Pattern Examples -> Composite");
       FileSystemDetails simpleFile = new SimpleFile("HelloWorld.java",2);
       FileSystemDetails appletFile = new SimpleFile("Applet.java",4);
       FileSystemDetails musicFile = new SimpleFile("Atif_Aslam_mashup.mp3",4);
       FileSystemDetails musicFile1 = new SimpleFile("Rahet_Fateh_Ali.mp3",5);
       FileSystemDetails movieFile = new SimpleFile("3 Iditos.mp4",100);
       FileSystemDetails movieFile1 = new SimpleFile("Delhi Crime.vlc",110);
       FileSystemDetails premRog = new SimpleFile("PREM ROG",120);
       FileSystemDetails yehJawaniHaiDiwani = new SimpleFile("YEH JAWANI HAI DIWANI",120);
       
       Folder rootFolder = new Folder("New Folder");
       Folder code = new Folder("Java");
       Folder movie = new Folder("Movies");
       Folder oldMovies = new Folder("Old Movies");
       Folder music = new Folder("Music");
       code.addFile(appletFile);                                
       code.addFile(simpleFile);
       movie.addFile(movieFile);
       movie.addFile(movieFile1);
       music.addFile(musicFile);
       music.addFile(musicFile1);
       rootFolder.addFile(code);
       oldMovies.addFile(premRog);
       oldMovies.addFile(yehJawaniHaiDiwani);
       movie.addFile(oldMovies);
       rootFolder.addFile(movie);
       rootFolder.addFile(music);
       System.out.println("+ "+rootFolder.getName());
       rootFolder.showDetails(" ");
       System.out.println();

   }
}

// Composite Related Classes

// Component
interface FileSystemDetails {
    public void showDetails(String indent);
    public Integer getSize();
    public String getName();
}


// Leaf
class SimpleFile implements FileSystemDetails {
    private String fileName;
    private Integer size;

    public SimpleFile(String fileName,Integer size){
        this.fileName = fileName;
        this.size = size;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public void showDetails(String indent) {
        System.out.println(indent+"- "+this.fileName);
    }

    @Override
    public Integer getSize() {
        return this.size;
    }

    @Override
    public String getName() {
        return this.fileName;
    }
}


// Composite
class Folder implements FileSystemDetails {
    private String name;
    private List<FileSystemDetails> folderDetails = new ArrayList<>();

    public Folder(String name){
        this.name = name;
    }

    @Override
    public void showDetails(String indent) {
        for(FileSystemDetails file : folderDetails) {
            if (file instanceof Folder) {
                ((Folder) file).show(file,indent+" ");
            }else
                file.showDetails(indent+" ");
        }
    }

    public void show(FileSystemDetails fileSystemDetails,String indent){
        //System.out.println(this.getName());
        System.out.println(indent+"+ "+fileSystemDetails.getName());
        fileSystemDetails.showDetails(indent+" ");
    }

    @Override
    public Integer getSize() {
        Integer size = null;
        for(FileSystemDetails file : folderDetails)
            size += file.getSize();
        return size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FileSystemDetails> getFolderDetails() {
        return folderDetails;
    }

    public void setFolderDetails(List<FileSystemDetails> folderDetails) {
        this.folderDetails = folderDetails;
    }

    public void addFile(FileSystemDetails fileSystemDetails){
        folderDetails.add(fileSystemDetails);
    }
}

