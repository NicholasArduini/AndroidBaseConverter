package com.example.nicholasarduini.baseconverter;

import java.lang.String;
import android.app.Activity;
import android.text.Editable;

public class NumberConverter extends Activity {

    //converts any valid input to a decimal, else it will return null
    public String convertToDec(Editable text){
        String output = text.toString();
        if(text.length() < 3){
            output = null;
        } else if(text.toString().startsWith("d:") && this.checkDec(text)){
            output = output.substring(2);
        } else if(text.toString().startsWith("b:") && this.checkBin(text) && text.length() < 20){
            output = output.substring(2);
            int temp = Integer.parseInt(output,2);
            output = Integer.toString(temp);
        } else if(text.toString().startsWith("h:") && this.checkHex(text) && text.length() < 9){
            output = output.substring(2);
            int temp = Integer.parseInt(output,16);
            output = Integer.toString(temp);
        } else {
            output = null;
        }
        return output;
    }

    //check if the input is a valid decimal number
    public Boolean checkDec(Editable text){
        int count = 2;
        Boolean output = false;
        char[] valid = {'1','2','3','4','5','6','7','8','9','0'};

        for(int i = 2; i < text.length(); i++) {
            for(int j = 0; j < valid.length; j++) {
                if (text.charAt(i) == valid[j]) {
                    count++;
                }
            }
        }
        return (count == text.length());
    }

    //check if the input is a valid binary number
    public Boolean checkBin(Editable text){
        int count = 2;
        Boolean output = false;

        for(int i = 0; i < text.length(); i++){
            if(text.toString().charAt(i) == '0' || text.toString().charAt(i) == '1' ||
                    text.toString().charAt(i) == ' '){
                count++;
            }
        }
        return (count == text.length());
    }

    //check if the input is a valid hex number
    public Boolean checkHex(Editable text){
        int count = 2;
        Boolean output = false;
        char[] valid = {'a','b','c','d','e','f','A','B','C','D','E','F','1','2','3','4','5','6'
                ,'7','8','9','0'};

        for(int i = 2; i < text.length(); i++){
            for(int j = 0; j < valid.length; j++){
                if(text.charAt(i) == valid[j]){
                    count++;
                }
            }
        }
        return (count == text.length());
    }
}
