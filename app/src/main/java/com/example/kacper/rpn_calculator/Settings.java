package com.example.kacper.rpn_calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Settings extends Activity {

    public void save(View view){

        RadioButton radio1=findViewById(R.id.radio1);
        RadioButton radio2=findViewById(R.id.radio2);
        RadioButton radio3=findViewById(R.id.radio3);
        RadioButton radio4=findViewById(R.id.radio4);
        RadioButton whiteStack=findViewById(R.id.whiteStack);
        RadioButton blackStack=findViewById(R.id.blackStack);
        RadioButton greenStack=findViewById(R.id.greenStack);
        RadioButton blueStack=findViewById(R.id.blueStack);

        if(radio2.isChecked()){
        Intent i = new Intent(this,TwoRowsDisplay.class);

            if(blackStack.isChecked()) i.putExtra("color","black");
            else if (blueStack.isChecked())  i.putExtra("color","blue");
            else if (greenStack.isChecked()) i.putExtra("color","green");
            else i.putExtra("color","white");

            startActivity(i);
        }
        else if(radio1.isChecked()){
            Intent i = new Intent(this,OneRowDisplay.class);

            if(blackStack.isChecked()) i.putExtra("color","black");
            else if (blueStack.isChecked())  i.putExtra("color","blue");
            else if (greenStack.isChecked()) i.putExtra("color","green");
            else i.putExtra("color","white");

            startActivity(i);
        }
        else if(radio3.isChecked()){
            Intent i = new Intent(this,ThreeRowsDisplay.class);

            if(blackStack.isChecked()) i.putExtra("color","black");
            else if (blueStack.isChecked())  i.putExtra("color","blue");
            else if (greenStack.isChecked()) i.putExtra("color","green");
            else i.putExtra("color","white");


            startActivity(i);
        }
        else {
            Intent i = new Intent(this,MainActivity.class);

            if(blackStack.isChecked()) i.putExtra("color","black");
            else if (blueStack.isChecked())  i.putExtra("color","blue");
            else if (greenStack.isChecked()) i.putExtra("color","green");
            else i.putExtra("color","white");

            startActivity(i);
        }

    }
    public void back(View view){


            Intent i = new Intent(this,MainActivity.class);
            startActivity(i);


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

    }
}
