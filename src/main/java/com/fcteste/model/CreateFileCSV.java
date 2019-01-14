/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fcteste.model;

import com.fcteste.core.CodeAnalyzer;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Julio M. C. Dias
 */
public class CreateFileCSV {
    
    

    public void creatFileCSV(File file, ArrayList<CodeAnalyzer> cA) {
        BufferedWriter output = null;
        try {
            output = new BufferedWriter(new FileWriter(file));
            
            for (CodeAnalyzer codeAnalyzer : cA) {
                output.write(
                        codeAnalyzer.count.getLineAll()+","+
                        codeAnalyzer.count.getCommand()+","+
                        codeAnalyzer.count.getLineBlank()+","+
                        codeAnalyzer.count.getOperating()+","+
                        codeAnalyzer.count.getOperatorOnly()+","+
                        codeAnalyzer.count.getOperator()+"\n"
                        );
            }
            
            
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (output != null) 
                output.close();
            } catch (Exception e) { }
            
        }
    }
}
