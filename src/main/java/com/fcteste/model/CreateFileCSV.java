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
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Julio M. C. Dias
 */
public class CreateFileCSV {

    public void creatFileCSV(File file, ArrayList<CodeAnalyzer> cA, ArrayList<String> lFName) {
        BufferedWriter output = null;
        Iterator<CodeAnalyzer> iCA = cA.iterator();
        Iterator<String> iLFN = lFName.iterator();
        CodeAnalyzer cAna;
        try {
            output = new BufferedWriter(new FileWriter(file));
            output.write("Name,SLOC,Method,MethodCall,Operator,OperatorOnly,Operating,\n");

            while (iCA.hasNext() && iLFN.hasNext()) {
                cAna = iCA.next();
                output.write(
                        iLFN.next() + ","
                        + cAna.count.getLineNumber() + ","
                        + cAna.count.getMethod() + ","
                        + cAna.count.getMethodCall() + ","
                        + cAna.count.getOperator() + ","
                        + cAna.count.getOperatorOnly() + ","
                        + cAna.count.getOperating() + "\n"
                );
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (output != null) {
                    output.close();
                }
            } catch (IOException e) {
            }

        }
    }
}
