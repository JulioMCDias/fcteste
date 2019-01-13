/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fcteste.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Julio M. C. Dias
 */
public class CreateFileSGV {
    
    

    public void creatFileSVG(String directory) {
        BufferedWriter output = null;
        try {
            File file = new File(directory);
            output = new BufferedWriter(new FileWriter(file));
            output.write("asdasdad");
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
