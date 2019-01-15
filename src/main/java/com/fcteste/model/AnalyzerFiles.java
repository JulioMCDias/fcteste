/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fcteste.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

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
        InputStream istream;
        CodeAnalyzer cAnaly;
        for (File file : filesJ.getFiles()) {
            try {
                istream = new FileInputStream(file);
                cAnaly = new CodeAnalyzer(istream);
                listCAnalyzer.add(cAnaly);
                istream.close();
            } catch (IOException e) {
                e.printStackTrace();
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
