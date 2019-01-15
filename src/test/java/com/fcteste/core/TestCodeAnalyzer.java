/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fcteste.core;

import com.fcteste.model.CodeAnalyzer;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rnr
 */
public class TestCodeAnalyzer {

    public TestCodeAnalyzer() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    /*
    *
    * Simples operations
    *
     */
    String data = "public class Test {\n"
            + "\n"
            + "    public void t0() {\n"
            + "        int a,b,c;\n"
            + "        \n"
            + "        a=b+c;\n"
            + "        \n"
            + "        if(a<=5){\n"
            + "            b=7;\n"
            + "        }\n"
            + "        else{\n"
            + "            c=10;\n"
            + "        }\n"
            + "    }\n"
            + "    \n"
            + "    private void t1(int s) {\n"
            + "        int t;\n"
            + "         t = s;\n"
            + "    }\n"
            + "    \n"
            + "    private String t2() {\n"
            + "        String S = \"ola\";\n"
            + "        String T = \"mundo\";\n"
            + "        \n"
            + "        return S+\" \"+T;\n"
            + "    }\n"
            + "\n"
            + "}";

    @Test
    public void StringVoid() {
        InputStream is = new ByteArrayInputStream(data.getBytes(StandardCharsets.UTF_8));
        CodeAnalyzer code = new CodeAnalyzer(is);
        assertEquals(8, code.count.getOperator());
    }

}
