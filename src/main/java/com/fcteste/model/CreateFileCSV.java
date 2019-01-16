/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fcteste.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Julio M. C. Dias
 */
public class CreateFileCSV implements Serializable {
    private static final long serialVersionUID = 1L;
    public void creatFileCSV(File file, ArrayList<CodeAnalyzer> cA, ArrayList<String> lFName) {
        BufferedWriter output = null;
        Iterator<CodeAnalyzer> iCA = cA.iterator();
        Iterator<String> iLFN = lFName.iterator();
        CodeAnalyzer cAna;
        try {
            output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), Charset.defaultCharset()));
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
