package com.example.kacper.rpn_calculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        final TextView maininput = (TextView)findViewById(R.id.mainInput);
        Button button0 = (Button)findViewById(R.id.button0);
        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button3);
        Button button4 = (Button)findViewById(R.id.button4);
        Button button5 = (Button)findViewById(R.id.button5);
        Button button6 = (Button)findViewById(R.id.button6);
        Button button7 = (Button)findViewById(R.id.button7);
        Button button8 = (Button)findViewById(R.id.button8);
        Button button9 = (Button)findViewById(R.id.button9);
        Button acButton = findViewById(R.id.ACButton);
        Button backButton = findViewById(R.id.backButton);


        //event handler and inside him callback method
        button0.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        int inputCounter = maininput.getText().length();
                        //append zero only if mainINPUT is not empty -> we can not type 0 at the beginnig
                        //append zero until limit 10 numbers -> because UI can crashed
                        if(!(maininput.getText().toString().matches("")) && inputCounter<10)
                            maininput.append("0");
                    }
                }
        );

        button1.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        int inputCounter = maininput.getText().length();

                        if(inputCounter<10)
                            maininput.append("1");
                    }
                }
        );
        button2.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        int inputCounter = maininput.getText().length();
                        if(inputCounter<10)
                            maininput.append("2");
                    }
                }
        );
        button3.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        int inputCounter = maininput.getText().length();
                        if(inputCounter<10)
                            maininput.append("3");
                    }
                }
        );
        button4.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        int inputCounter = maininput.getText().length();
                        if(inputCounter<10)
                            maininput.append("4");
                    }
                }
        );
        button5.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        int inputCounter = maininput.getText().length();
                        if(inputCounter<10)
                            maininput.append("5");
                    }
                }
        );
        button6.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        int inputCounter = maininput.getText().length();
                        if(inputCounter<10)
                            maininput.append("6");
                    }
                }
        );
        button6.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        int inputCounter = maininput.getText().length();
                        if(inputCounter<10)
                            maininput.append("6");
                    }
                }
        );

        button7.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        int inputCounter = maininput.getText().length();
                        if(inputCounter<10)
                            maininput.append("7");
                    }
                }
        );
        button8.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        int inputCounter = maininput.getText().length();
                        if(inputCounter<10)
                            maininput.append("8");
                    }
                }
        );
        button9.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        int inputCounter = maininput.getText().length();
                        if(inputCounter<10)
                            maininput.append("9");
                    }
                }
        );
        acButton.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                            maininput.setText("0");
                    }
                }
        );
        backButton.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {

                        //if you have something to remove than remove from input last character (character from the right side),
                        //else if you dont have anything to remove just set 0
                        if(maininput.getText().length()>=1)
                            maininput.setText(maininput.getText().toString().substring(0,maininput.getText().toString().length()-1));
                        else maininput.setText("0");
                    }
                }
        );




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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
