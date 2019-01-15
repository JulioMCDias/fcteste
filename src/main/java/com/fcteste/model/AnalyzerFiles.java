/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fcteste.model;

import com.github.javaparser.ParseProblemException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julio M. C. Dias
 */
public class AnalyzerFiles {

    private ArrayList<CodeAnalyzer> listCAnalyzer;

    public AnalyzerFiles() {
        listCAnalyzer = new ArrayList<>();
    }

    public void applyAnaly(FilesJava filesJ) {
        ArrayList<File> fJ = (ArrayList<File>) filesJ.getFiles().clone();
        InputStream istream;
        CodeAnalyzer cAnaly;
        for (File file : fJ) {
            try {
                istream = new FileInputStream(file);
                cAnaly = new CodeAnalyzer(istream);
                listCAnalyzer.add(cAnaly);
                istream.close();
            
            }catch (ParseProblemException e) {
                filesJ.getFiles().remove(file);
            } catch (IOException ex) {
                Logger.getLogger(AnalyzerFiles.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void cleanArrayFiles() {
        listCAnalyzer.clear();
    }

    public ArrayList<CodeAnalyzer> getListCAnalyzer() {
        return listCAnalyzer;
    }
}
