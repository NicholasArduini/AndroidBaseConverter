package com.example.nicholasarduini.baseconverter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    String error = "Error";

    NumberConverter numberConverter = new NumberConverter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText textF = (EditText) findViewById(R.id.editText);

        final Button decB = (Button) this.findViewById(R.id.dec);
        final Button binB = (Button) this.findViewById(R.id.bin);
        final Button hexB = (Button) this.findViewById(R.id.hex);

        //set all the buttons to red on start
        decB.setBackgroundResource(R.color.red);
        binB.setBackgroundResource(R.color.red);
        hexB.setBackgroundResource(R.color.red);

        //on dec button press check if the input is valid, then it will convert the input into a dec
        //else report error
        decB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numberConverter.convertToDec(textF.getText()) != null) {
                    textF.setText("d:" + numberConverter.convertToDec(textF.getText()));
                    decB.setBackgroundResource(R.color.green);
                    binB.setBackgroundResource(R.color.red);
                    hexB.setBackgroundResource(R.color.red);
                    textF.setBackgroundResource(textF.getSolidColor());
                } else {
                    textF.setText(error);
                    decB.setBackgroundResource(R.color.red);
                    binB.setBackgroundResource(R.color.red);
                    hexB.setBackgroundResource(R.color.red);
                    textF.setBackgroundResource(R.color.red);
                }
            }
        });

        //on bin button press check if the input is valid, then it will convert the input into a bin
        //else report error
        binB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numberConverter.convertToDec(textF.getText()) != null) {
                    String temp = Integer.toBinaryString(Integer.parseInt(
                            numberConverter.convertToDec(textF.getText())));
                    textF.setText("b:" + temp);
                    decB.setBackgroundResource(R.color.red);
                    binB.setBackgroundResource(R.color.green);
                    hexB.setBackgroundResource(R.color.red);
                    textF.setBackgroundResource(textF.getSolidColor());

                } else {
                    textF.setText(error);
                    decB.setBackgroundResource(R.color.red);
                    binB.setBackgroundResource(R.color.red);
                    hexB.setBackgroundResource(R.color.red);
                    textF.setBackgroundResource(R.color.red);
                }
            }
        });

        //on hex button press check if the input is valid, then it will convert the input into a hex
        //else report error
        hexB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numberConverter.convertToDec(textF.getText()) != null) {
                    String temp = Integer.toHexString(Integer.parseInt(
                            numberConverter.convertToDec(textF.getText())));
                    textF.setText("h:" + temp);
                    decB.setBackgroundResource(R.color.red);
                    binB.setBackgroundResource(R.color.red);
                    hexB.setBackgroundResource(R.color.green);
                    textF.setBackgroundResource(textF.getSolidColor());
                } else {
                    textF.setText(error);
                    decB.setBackgroundResource(R.color.red);
                    binB.setBackgroundResource(R.color.red);
                    hexB.setBackgroundResource(R.color.red);
                    textF.setBackgroundResource(R.color.red);
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
        //    return true;
        //}

        return super.onOptionsItemSelected(item);
    }
}

