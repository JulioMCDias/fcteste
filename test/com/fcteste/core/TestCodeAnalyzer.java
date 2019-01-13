/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fcteste.core;

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
    public void SimpleSum() {
        String expression = "5+2";
    }
    
    @Test
    public void SimpleSubtrac() {
        String expression = "10-2";
    }
    
    @Test
    public void SimpleMultiplication() {
        String expression = "78*5";
    }
    
    @Test
    public void SimpleDivision() {
        String expression = "56/4";
    }
    
    @Test
    public void SimpleModule() {
        String expression = "78%4";
    }
    
    @Test
    public void SimpleXor() {
        String expression = "3^8";
    }
    
    @Test
    public void SimpleAnd() {
        String expression = "3&8";
    }
    
    @Test
    public void SimpleOr() {
        String expression = "3|8";
    }
    
    @Test
    public void SimpleNot() {
        String expression = "~8+5";
    }
    
    /*
    *
    * Other operations: Variables and Methods 
    *
    */
    
    @Test
    public void MethodSimple() {
        String expression = "14-pi()";
    }
    
    @Test
    public void MethodCompound() {
        String expression = "2*Math.pi()";
    }
    
    @Test
    public void VariableSimple() {
        String expression = "2*a";
    }
    
    @Test
    public void VariableCompound() {
        String expression = "2*obj.varB";
    }
    
    
    
    /*
    *
    * Assignment operations
    *
    */
    
    
    @Test
    public void Assignment() {
        String expression = "area=pi*r^2";
    }
    
    
    
    /*
    *
    * Condition operations
    *
    */
    @Test
    public void CompareEqual() {
        String expression = "5+2==10";
    }
    
    @Test
    public void CompareDifferent() {
        String expression = "5+2!=10";
    }
    
    @Test
    public void CompareGreater() {
        String expression = "5+2>10";
    }
    
    @Test
    public void CompareLess() {
        String expression = "5+2<10";
    }
    
    @Test
    public void CompareGreaterOrEqual() {
        String expression = "5+2>=10";
    }
    
    @Test
    public void CompareLessOrEqual() {
        String expression = "5+2<=10";
    }
    
    @Test
    public void CompareAnd() {
        String expression = "5+2&&10";
    }
    
    @Test
    public void CompareOr() {
        String expression = "5+2||10";
    }
    
    @Test
    public void CompareNot() {
        String expression = "!(2==10)";
    }
    
    
    
    /*
    *
    * First operations
    *
    */
    
    @Test
    public void FirstSum() {
        String expression = "+7+10";
    }
    
    @Test
    public void FirstSubtrac() {
        String expression = "-7+10";
    }
    
    
    /*
    *
    * Parenthesis operations
    *
    */
    
    @Test
    public void ParenthesisFirst() {
        String expression = "(5+2)*5";
    }
    
    @Test
    public void ParenthesisHalf() {
        String expression = "2+7*(2-1)";
    }
    
    
    
    
    
    
    /*
    *
    * Half operations
    *
    */
    
    @Test
    public void HalfSum() {
        String expression = "7+(+10)*2";
    }
    
    @Test
    public void HalfSubtrac() {
        String expression = "7+(-10)/10";
    }
    
    
    /*
    *
    * Method operations
    *
    */
    
    @Test
    public void MethodOperationsSimple() {
        String expression = "abs(5+2)";
    }
    
    
    @Test
    public void MethodOperationsCompound() {
        String expression = "Math.pow(5+2,7-8)";
    }
    
    
    /*
    *
    * Complex expression
    *
    */
    
    @Test
    public void ComplexExpression() {
        String expression = "5+(-2)*(5&(-2*4)*7) && (7/2*4) || (7^5)";
    }
    
}
