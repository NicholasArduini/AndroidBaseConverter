package com.example.nicholasarduini.baseconverter;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import junit.framework.Assert;

public class NumberConverterTestCase extends ApplicationTest{
    //test a perfect decimal number to decimal
    public void testConvertDec1(){
        NumberConverter nc = new NumberConverter();
        Editable temp = new SpannableStringBuilder("d:12345");
        Assert.assertEquals(nc.convertToDec(temp), "12345");
    }
    //test a perfect binary number to decimal
    public void testConvertDec2(){
        NumberConverter nc = new NumberConverter();
        Editable temp = new SpannableStringBuilder("b:10001");
        Assert.assertEquals(nc.convertToDec(temp), "17");
    }
    //test a perfect hex number to decimal
    public void testConvertDec3(){
        NumberConverter nc = new NumberConverter();
        Editable temp = new SpannableStringBuilder("h:4e9");
        Assert.assertEquals(nc.convertToDec(temp), "1257");
    }
    //test a input that is invalid because it has no number
    public void testConvertDec4(){
        NumberConverter nc = new NumberConverter();
        Editable temp = new SpannableStringBuilder("h:");
        Assert.assertEquals(nc.convertToDec(temp), null);
    }
    //test an invalid hex input to decimal
    public void testConvertDec5(){
        NumberConverter nc = new NumberConverter();
        Editable temp = new SpannableStringBuilder("h:aez4");
        Assert.assertEquals(nc.convertToDec(temp), null);
    }
    //test an invalid binary number to decimal
    public void testConvertDec6(){
        NumberConverter nc = new NumberConverter();
        Editable temp = new SpannableStringBuilder("b:1001f1");
        Assert.assertEquals(nc.convertToDec(temp), null);
    }
    //test an invalid decimal number to decimal
    public void testConvertDec7(){
        NumberConverter nc = new NumberConverter();
        Editable temp = new SpannableStringBuilder("d:1472d5");
        Assert.assertEquals(nc.convertToDec(temp), null);
    }
    //test a hex number that would result in an app crash
    public void testConvertDec8(){
        NumberConverter nc = new NumberConverter();
        Editable temp = new SpannableStringBuilder("h:fffffff");
        Assert.assertEquals(nc.convertToDec(temp), null);
    }
    //test a check for a perfect decimal number
    public void testCheckDec1(){
        NumberConverter nc = new NumberConverter();
        Editable temp = new SpannableStringBuilder("d:1234");
        Assert.assertEquals((boolean)nc.checkDec(temp), true);
    }
    //test a check for a invalid decimal number
    public void testCheckDec2(){
        NumberConverter nc = new NumberConverter();
        Editable temp = new SpannableStringBuilder("d:123s4");
        Assert.assertEquals((boolean)nc.checkDec(temp), false);
    }
    //test a check for a perfect binary number
    public void testCheckBin1(){
        NumberConverter nc = new NumberConverter();
        Editable temp = new SpannableStringBuilder("b:10110");
        Assert.assertEquals((boolean)nc.checkBin(temp), true);
    }
    //test a check for a perfect invalid binary number
    public void testCheckBin2(){
        NumberConverter nc = new NumberConverter();
        Editable temp = new SpannableStringBuilder("b:1011v0");
        Assert.assertEquals((boolean)nc.checkBin(temp), false);
    }
    //test a check for a perfect hex number
    public void testCheckHex1(){
        NumberConverter nc = new NumberConverter();
        Editable temp = new SpannableStringBuilder("h:4da1");
        Assert.assertEquals((boolean)nc.checkHex(temp), true);
    }
    //test a check for a perfect invalid hex number
    public void testCheckHex2(){
        NumberConverter nc = new NumberConverter();
        Editable temp = new SpannableStringBuilder("h:4daq1");
        Assert.assertEquals((boolean)nc.checkHex(temp), false);
    }
}