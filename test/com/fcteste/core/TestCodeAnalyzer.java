/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fcteste.core;

import com.fcteste.core.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
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
    @Test
    public void SimpleSum() throws ParseException {
        StringReader sr = new StringReader("5+2;");
        CodeAnalyzer code = new CodeAnalyzer(sr);
        code.run();
        assertEquals(code.count.getOpSum(), 1);
    }

    @Test
    public void SimpleSubtrac() throws ParseException {
        StringReader sr = new StringReader("10-2;");
        CodeAnalyzer code = new CodeAnalyzer(sr);
        code.run();
        assertEquals(code.count.getOpSubtrac(), 1);
    }

    @Test
    public void SimpleMultiplication() throws ParseException {
        StringReader sr = new StringReader("78*5;");
        CodeAnalyzer code = new CodeAnalyzer(sr);
        code.run();
        assertEquals(code.count.getOpMultiplication(), 1);
    }

    @Test
    public void SimpleDivision() throws ParseException {
        StringReader sr = new StringReader("56/4;");
        CodeAnalyzer code = new CodeAnalyzer(sr);
        code.run();
        assertEquals(code.count.getOpDivision(), 1);
    }

    @Test
    public void SimpleModule() throws ParseException {
        StringReader sr = new StringReader("78%4;");
        CodeAnalyzer code = new CodeAnalyzer(sr);
        code.run();
        assertEquals(code.count.getOpModule(), 1);
    }

    @Test
    public void SimpleXor() throws ParseException {
        StringReader sr = new StringReader("3^8;");
        CodeAnalyzer code = new CodeAnalyzer(sr);
        code.run();
        assertEquals(code.count.getOpXor(), 1);
    }

    @Test
    public void SimpleAnd() throws ParseException {
        StringReader sr = new StringReader("3&8;");
        CodeAnalyzer code = new CodeAnalyzer(sr);
        code.run();
        assertEquals(code.count.getOpAnd(), 1);
    }

    @Test
    public void SimpleOr() throws ParseException {
        StringReader sr = new StringReader("3|8;");
        CodeAnalyzer code = new CodeAnalyzer(sr);
        code.run();
        assertEquals(code.count.getOpOr(), 1);
    }

    @Test
    public void SimpleNot() throws ParseException {
        StringReader sr = new StringReader("~8+5;");
        CodeAnalyzer code = new CodeAnalyzer(sr);
        code.run();
        assertEquals(code.count.getOpNot(), 1);
    }

    /*
    *
    * Other operations: Variables and Methods 
    *
     */
    @Test
    public void MethodSimple() throws ParseException {
        StringReader sr = new StringReader("14-pi();");
        CodeAnalyzer code = new CodeAnalyzer(sr);
        code.run();
        assertEquals(code.count.getOpSubtrac(), 1);
    }

    @Test
    public void MethodCompound() throws ParseException {
        StringReader sr = new StringReader("2*Math.pi();");
        CodeAnalyzer code = new CodeAnalyzer(sr);
        code.run();
        assertEquals(code.count.getOpMultiplication(), 1);
    }

    @Test
    public void VariableSimple() throws ParseException {
        StringReader sr = new StringReader("2*a;");
        CodeAnalyzer code = new CodeAnalyzer(sr);
        code.run();
        assertEquals(code.count.getOpNot(), 1);
    }

    @Test
    public void VariableCompound() throws ParseException {
        StringReader sr = new StringReader("2*obj.varB;");
        CodeAnalyzer code = new CodeAnalyzer(sr);
        code.run();
        assertEquals(code.count.getOpNot(), 1);
    }

    /*
    *
    * Assignment operations
    *
     */
    @Test
    public void Assignment() throws ParseException {
        StringReader sr = new StringReader("area=pi*r^2;");
        CodeAnalyzer code = new CodeAnalyzer(sr);
        code.run();
        assertEquals(code.count.getOpMultiplication(), 1);
    }

    public void AssignmentOperation() throws ParseException {
        StringReader sr = new StringReader("count+=2;");
        CodeAnalyzer code = new CodeAnalyzer(sr);
        code.run();
        assertEquals(code.count.getOpSum(), 1);
    }

    /*
    *
    * Condition operations
    *
     */
    @Test
    public void CompareEqual() throws ParseException {
        StringReader sr = new StringReader("5+2==10;");
        CodeAnalyzer code = new CodeAnalyzer(sr);
        code.run();
        assertEquals(code.count.getOpSum(), 1);
    }

    @Test
    public void CompareDifferent() throws ParseException {
        StringReader sr = new StringReader("5+2!=10;");
        CodeAnalyzer code = new CodeAnalyzer(sr);
        code.run();
        assertEquals(code.count.getOpSum(), 1);
    }

    @Test
    public void CompareGreater() throws ParseException {
        StringReader sr = new StringReader("5+2>10;");
        CodeAnalyzer code = new CodeAnalyzer(sr);
        code.run();
        assertEquals(code.count.getOpSum(), 1);
    }

    @Test
    public void CompareLess() throws ParseException {
        StringReader sr = new StringReader("5+2<10;");
        CodeAnalyzer code = new CodeAnalyzer(sr);
        code.run();
        assertEquals(code.count.getOpSum(), 1);
    }

    @Test
    public void CompareGreaterOrEqual() throws ParseException {
        StringReader sr = new StringReader("5+2>=10;");
        CodeAnalyzer code = new CodeAnalyzer(sr);
        code.run();
        assertEquals(code.count.getOpSum(), 1);
    }

    @Test
    public void CompareLessOrEqual() throws ParseException {
        StringReader sr = new StringReader("5+2<=10;");
        CodeAnalyzer code = new CodeAnalyzer(sr);
        code.run();
        assertEquals(code.count.getOpSum(), 1);
    }

    @Test
    public void CompareAnd() throws ParseException {
        StringReader sr = new StringReader("5+2&&10;");
        CodeAnalyzer code = new CodeAnalyzer(sr);
        code.run();
        assertEquals(code.count.getOpSum(), 1);
    }

    @Test
    public void CompareOr() throws ParseException {
        StringReader sr = new StringReader("5+2||10;");
        CodeAnalyzer code = new CodeAnalyzer(sr);
        code.run();
        assertEquals(code.count.getOpSum(), 1);
    }

    @Test
    public void CompareXor() throws ParseException {
        StringReader sr = new StringReader("5+2^^10;");
        CodeAnalyzer code = new CodeAnalyzer(sr);
        code.run();
        assertEquals(code.count.getOpSum(), 1);
    }

    @Test
    public void CompareNot() throws ParseException {
        StringReader sr = new StringReader("!(2==10);");
        CodeAnalyzer code = new CodeAnalyzer(sr);
        code.run();
        assertEquals(code.count.getOpSum(), 1);
    }

    /*
    *
    * First operations
    *
     */
    @Test
    public void FirstSum() throws ParseException {
        StringReader sr = new StringReader("+7+10;");
        CodeAnalyzer code = new CodeAnalyzer(sr);
        code.run();
        assertEquals(code.count.getOpSum(), 2);
    }

    @Test
    public void FirstSubtrac() throws ParseException {
        StringReader sr = new StringReader("-7+10;");
        CodeAnalyzer code = new CodeAnalyzer(sr);
        code.run();
        assertEquals(code.count.getOpSum(), 1);
        assertEquals(code.count.getOpSubtrac(), 1);
    }

    /*
    *
    * Parenthesis operations
    *
     */
    @Test
    public void ParenthesisFirst() throws ParseException {
        StringReader sr = new StringReader("(5+2)*5;");
        CodeAnalyzer code = new CodeAnalyzer(sr);
        code.run();
        assertEquals(code.count.getOpSum(), 1);
        assertEquals(code.count.getOpMultiplication(), 1);
    }

    @Test
    public void ParenthesisHalf() throws ParseException {
        StringReader sr = new StringReader("2+7*(2-1);");
        CodeAnalyzer code = new CodeAnalyzer(sr);
        code.run();
        assertEquals(code.count.getOpSum(), 1);
        assertEquals(code.count.getOpSubtrac(), 1);
        assertEquals(code.count.getOpMultiplication(), 1);
    }

    /*
    *
    * Half operations
    *
     */
    @Test
    public void HalfSum() throws ParseException {
        StringReader sr = new StringReader("7+(+10)*2;");
        CodeAnalyzer code = new CodeAnalyzer(sr);
        code.run();
        assertEquals(code.count.getOpSum(), 2);
        assertEquals(code.count.getOpMultiplication(), 1);
    }

    @Test
    public void HalfSubtrac() throws ParseException {
        StringReader sr = new StringReader("7+(-10)/10;");
        CodeAnalyzer code = new CodeAnalyzer(sr);
        code.run();
        assertEquals(code.count.getOpSum(), 1);
        assertEquals(code.count.getOpSubtrac(), 1);
        assertEquals(code.count.getOpDivision(), 1);
    }

    /*
    *
    * Method operations
    *
     */
    @Test
    public void MethodOperationsSimple() throws ParseException {
        StringReader sr = new StringReader("abs(5+2);");
        CodeAnalyzer code = new CodeAnalyzer(sr);
        code.run();
        assertEquals(code.count.getOpSum(), 1);
    }

    @Test
    public void MethodOperationsCompound() throws ParseException {
        StringReader sr = new StringReader("Math.pow(5+2,7-8);");
        CodeAnalyzer code = new CodeAnalyzer(sr);
        code.run();
        assertEquals(code.count.getOpSum(), 1);
        assertEquals(code.count.getOpSubtrac(), 1);
        assertEquals(code.count.getOpMultiplication(), 1);
    }

    /*
    *
    * Complex expression
    *
     */
    @Test
    public void ComplexExpression() throws ParseException {
        StringReader sr = new StringReader("5+(-2)*(5&(-2*4)*7) && (7/2*4) || (7^5);");
        CodeAnalyzer code = new CodeAnalyzer(sr);
        code.run();
        assertEquals(code.count.getOpSum(), 1);
        assertEquals(code.count.getOpSubtrac(), 2);
        assertEquals(code.count.getOpMultiplication(), 4);
        assertEquals(code.count.getOpDivision(), 1);
        assertEquals(code.count.getOpXor(), 1);
        assertEquals(code.count.getOpAnd(), 1);
    }

    /*
    *
    * Line numbers
    *
     */
    @Test
    public void LineNumberAll() throws ParseException {
        StringReader sr = new StringReader("5+7\n78+8\nfun()\n;");
        CodeAnalyzer code = new CodeAnalyzer(sr);
        code.run();
        assertEquals(code.count.getLineAll(), 3);
    }

    @Test
    public void LineNumberBlank() throws ParseException {
        StringReader sr = new StringReader("5+7\n\nfun()\n\n;");
        CodeAnalyzer code = new CodeAnalyzer(sr);
        code.run();
        assertEquals(code.count.getLineBlank(), 3);
    }

    /*
    *
    * Command numbers
    *
     */
    @Test
    public void CommandNumber() throws ParseException {
        StringReader sr = new StringReader("c=10-2;\nfunc();\n");
        CodeAnalyzer code = new CodeAnalyzer(sr);
        code.run();
        assertEquals(code.count.getOpSum(), 1);
    }

}
