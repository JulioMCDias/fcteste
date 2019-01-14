/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fcteste.model;

import java.io.File;
import java.util.ArrayList;
import java.util.regex.Pattern;
/**
 *
 * @author Julio M. C. Dias
 */
public class FilesJava {
    private ArrayList<File> files;
    private String directory;
    
    
    public FilesJava(String directory) {
        this.directory = directory;
        files = new ArrayList<>();
    }

    public FilesJava() {
        files = new ArrayList<>();
    }
    
    
    public void findFiles(){
        listf(directory, files);
    }
    
    
    private void listf(String directoryName, ArrayList<File> files) {
    File fDirectory = new File(directoryName);

    // Get all files from a directory.
    File[] fList = fDirectory.listFiles();
        
    if(fList != null)
        for (File file : fList) {      
            if (file.isFile()) {
                if(getFileExtensionJava(file)){
                    try{
                    files.add(file);
                    
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }    
            } else if (file.isDirectory()) {
                listf(file.getAbsolutePath(), files);
            }
        }
    }

    private boolean getFileExtensionJava(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0 &&
                fileName.matches("^[a-zA-Z0-9]*.java$"))
            return true;
        return false;
    }
    
    
    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public String getDirectory() {
        return directory;
    }

    public ArrayList<File> getFiles() {
        return files;
    }
    
    public void cleanArrayFiles(){
        files.clear();
    }
    
}
