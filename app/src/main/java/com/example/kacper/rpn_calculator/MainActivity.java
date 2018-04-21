package com.example.kacper.rpn_calculator;

import android.app.Activity;
import android.content.Intent;
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
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    Stack stack = new Stack();
    /*WHY DO WE NEED CLICKED FLAG?
      1. So we have to check if we clicked enterButton -> cause if we do, we want to clear our input first and than append a number
      2. if we didnt clicked than just append a number
                          * */
    boolean enterButtonClicked = false;

    public void initializeButtons(View.OnClickListener view, String number , TextView maininput){

        int inputCounter = maininput.getText().length();
        if(inputCounter<19) {

            if(enterButtonClicked){
                maininput.setText("");
                maininput.append(number);
                enterButtonClicked=false;
            }
            else maininput.append(number);
        }


    }
    public void goToSettings(View view) {
        Intent i = new Intent(this, Settings.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
//------------------------------------------------------------------------------------------------------------------------------------------------
        //HERE WE ARE CHECKING WHAT COLOR OF STACK SCREEN THE USER WOULD LIKE TO CHOOSE

        String color=null;
        GridLayout fourStackLayout = findViewById(R.id.StackLayout);
        //These are only numbers, exists only for change color, they useful
        TextView stack1 = findViewById(R.id.stack1);
        TextView stack2 = findViewById(R.id.stack2);
        TextView stack3 = findViewById(R.id.stack3);
        TextView stack4 = findViewById(R.id.stack4);
        TextView deg = findViewById(R.id.deg);

        //these are important-stack screens
        TextView secondStackInput = findViewById(R.id.secondStackInput);
        TextView thirdStackInput = findViewById(R.id.thirdStackInput);
        final TextView maininput = (TextView)findViewById(R.id.mainInput);
        final TextView stackInput = findViewById(R.id.stackInput);
        final TextView firstStackInput = findViewById(R.id.firstStackInput);

        if (getIntent().hasExtra("color")) {
            color = getIntent().getStringExtra("color");

            switch (color){
                case "black":
                    fourStackLayout.setBackgroundColor(getResources().getColor(R.color.greyy));
                    stackInput.setTextColor(getResources().getColor(R.color.stackWhite));

                    firstStackInput.setTextColor(getResources().getColor(R.color.stackWhite));
                    secondStackInput.setTextColor(getResources().getColor(R.color.stackWhite));
                    thirdStackInput.setTextColor(getResources().getColor(R.color.stackWhite));
                    maininput.setTextColor(getResources().getColor(R.color.stackWhite));

                    firstStackInput.setHintTextColor(getResources().getColor(R.color.stackWhite));
                    secondStackInput.setHintTextColor(getResources().getColor(R.color.stackWhite));
                    thirdStackInput.setHintTextColor(getResources().getColor(R.color.stackWhite));
                    maininput.setHintTextColor(getResources().getColor(R.color.stackWhite));

                    stack1.setTextColor(getResources().getColor(R.color.stackWhite));
                    stack2.setTextColor(getResources().getColor(R.color.stackWhite));
                    stack3.setTextColor(getResources().getColor(R.color.stackWhite));
                    stack4.setTextColor(getResources().getColor(R.color.stackWhite));
                    deg.setTextColor(getResources().getColor(R.color.stackWhite));
                    break;
                case "white":
                    fourStackLayout.setBackgroundColor(getResources().getColor(R.color.stackWhite));
                    stackInput.setTextColor(getResources().getColor(R.color.stackBlack));

                    firstStackInput.setTextColor(getResources().getColor(R.color.stackBlack));
                    secondStackInput.setTextColor(getResources().getColor(R.color.stackBlack));
                    thirdStackInput.setTextColor(getResources().getColor(R.color.stackBlack));
                    maininput.setTextColor(getResources().getColor(R.color.stackBlack));

                    firstStackInput.setHintTextColor(getResources().getColor(R.color.stackBlack));
                    secondStackInput.setHintTextColor(getResources().getColor(R.color.stackBlack));
                    thirdStackInput.setHintTextColor(getResources().getColor(R.color.stackBlack));
                    maininput.setHintTextColor(getResources().getColor(R.color.stackBlack));

                    stack1.setTextColor(getResources().getColor(R.color.stackBlack));
                    stack2.setTextColor(getResources().getColor(R.color.stackBlack));
                    stack3.setTextColor(getResources().getColor(R.color.stackBlack));
                    stack4.setTextColor(getResources().getColor(R.color.stackBlack));
                    deg.setTextColor(getResources().getColor(R.color.stackBlack));
                    break;
                case "green":
                    fourStackLayout.setBackgroundColor(getResources().getColor(R.color.enter));
                    stackInput.setTextColor(getResources().getColor(R.color.stackWhite));

                    firstStackInput.setTextColor(getResources().getColor(R.color.stackWhite));
                    secondStackInput.setTextColor(getResources().getColor(R.color.stackWhite));
                    thirdStackInput.setTextColor(getResources().getColor(R.color.stackWhite));
                    maininput.setTextColor(getResources().getColor(R.color.stackWhite));

                    firstStackInput.setHintTextColor(getResources().getColor(R.color.stackWhite));
                    secondStackInput.setHintTextColor(getResources().getColor(R.color.stackWhite));
                    thirdStackInput.setHintTextColor(getResources().getColor(R.color.stackWhite));
                    maininput.setHintTextColor(getResources().getColor(R.color.stackWhite));

                    stack1.setTextColor(getResources().getColor(R.color.stackWhite));
                    stack2.setTextColor(getResources().getColor(R.color.stackWhite));
                    stack3.setTextColor(getResources().getColor(R.color.stackWhite));
                    stack4.setTextColor(getResources().getColor(R.color.stackWhite));
                    deg.setTextColor(getResources().getColor(R.color.stackWhite));
                    break;
                case "blue":
                    fourStackLayout.setBackgroundColor(getResources().getColor(R.color.drop));
                    stackInput.setTextColor(getResources().getColor(R.color.stackWhite));

                    firstStackInput.setTextColor(getResources().getColor(R.color.stackWhite));
                    secondStackInput.setTextColor(getResources().getColor(R.color.stackWhite));
                    thirdStackInput.setTextColor(getResources().getColor(R.color.stackWhite));
                    maininput.setTextColor(getResources().getColor(R.color.stackWhite));

                    firstStackInput.setHintTextColor(getResources().getColor(R.color.stackWhite));
                    secondStackInput.setHintTextColor(getResources().getColor(R.color.stackWhite));
                    thirdStackInput.setHintTextColor(getResources().getColor(R.color.stackWhite));
                    maininput.setHintTextColor(getResources().getColor(R.color.stackWhite));

                    stack1.setTextColor(getResources().getColor(R.color.stackWhite));
                    stack2.setTextColor(getResources().getColor(R.color.stackWhite));
                    stack3.setTextColor(getResources().getColor(R.color.stackWhite));
                    stack4.setTextColor(getResources().getColor(R.color.stackWhite));
                    deg.setTextColor(getResources().getColor(R.color.stackWhite));
            }
        }

 //===================================================================================================================================================
 //========================================================     INITIALIZE PART    ===========================================================================
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
        Button signButton = (Button)findViewById(R.id.signButton);
        Button dotButton = (Button)findViewById(R.id.dotButton);
        Button acButton = findViewById(R.id.ACButton);
        ImageButton backButton = findViewById(R.id.backButton);
        final Button enterButton = findViewById(R.id.enterButton);
        Button additionButton = findViewById(R.id.additionButton);
        Button subtractButton = findViewById(R.id.subtractButton);
        Button multiplyButton = findViewById(R.id.multiplyButton);
        Button divideButton = findViewById(R.id.divideButton);
        ImageButton settingsButton = findViewById(R.id.settingsButton);
        Button swapButton = findViewById(R.id.swapButton);
        Button dropButton= findViewById(R.id.dropButton);
        Button powerButton  =findViewById(R.id.powerButton);
        Button sqrtButton  =findViewById(R.id.squareButton);


        signButton.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        if(maininput.getText().toString().matches("")) maininput.setText("");
                        else {
                            double element = Double.parseDouble(maininput.getText().toString());
                            double result = -1 * element;
                            String parser = String.valueOf(result);
                            maininput.setText(parser);
                        }
                    }
                }
        );
        swapButton.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        if(stack.size()==0) maininput.setText("Error");
                        else if(maininput.getText().toString().matches("")){
                            maininput.setText("");
                        }
                        else {
                            double secondLastElement = stack.pop();
                            double lastElement = Double.parseDouble(maininput.getText().toString());

                            //parsing to Strings
                            String parser = String.valueOf(secondLastElement);
                            String parser2 = String.valueOf(lastElement);
                            maininput.setText(parser);
                            stack.push(lastElement);
                            firstStackInput.setText(parser2);
                        }
                    }
                }
        );


        //event handler and inside him callback method
        button0.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        int inputCounter = maininput.getText().length();
                        //append zero only if mainINPUT is not matches '0' -> we can not type 0 at the beginnig
                        //append zero until limit 10 numbers -> because UI can crashed

                        if(!(maininput.getText().toString().matches("0")) && inputCounter<19) {

                            if(enterButtonClicked){
                                maininput.setText("");
                                maininput.append("0");
                                enterButtonClicked=false;
                            }
                            else maininput.append("0");
                        }
                    }
                }
        );

        button1.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        initializeButtons(this,"1",maininput);

                    }
                }
        );
        button2.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        initializeButtons(this,"2",maininput);
                    }
                }
        );
        button3.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        initializeButtons(this,"3",maininput);
                    }
                }
        );
        button4.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        initializeButtons(this,"4",maininput);
                    }
                }
        );
        button5.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        initializeButtons(this,"5",maininput);
                    }
                }
        );

        button6.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        initializeButtons(this,"6",maininput);
                    }
                }
        );

        button7.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        initializeButtons(this,"7",maininput);
                    }
                }
        );
        button8.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        initializeButtons(this,"8",maininput);
                    }
                }
        );
        button9.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        int inputCounter = maininput.getText().length();
                        initializeButtons(this,"9",maininput);
                    }
                }
        );
        dotButton.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        int inputCounter = maininput.getText().length();
                        //append dot only if mainINPUT is not empty -> we can not type . at the beginnig
                        //append dot until limit 10 numbers -> because UI can crashed
                        //i dot is in maininput DONT APPEND IT AGAIN
                        if(!(maininput.getText().toString().matches("")) && inputCounter<19 && !(maininput.getText().toString().contains(".")))
                            maininput.append(".");
                    }
                }
        );
        acButton.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                            maininput.setText("");
                            stack.clear();
                            stackInput.setText("STACK: "+(stack.size()+1));
                            firstStackInput.setText("");
                    }
                }
        );
        backButton.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {

                        //if you have something to remove than remove from input last character (character from the right side),
                        //else if you dont have anything to remove just set null
                        if(maininput.getText().length()>=1)
                            maininput.setText(maininput.getText().toString().substring(0,maininput.getText().toString().length()-1));
                        else maininput.setText("0");
                    }
                }
        );

        dropButton.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {


                        if (stack.size() == 0) {
                            maininput.setText(firstStackInput.getText().toString());
                            firstStackInput.setText("0");
                        }
                        if (stack.size() == 1) {
                            double lastElement = stack.pop();
                            String parser = String.valueOf(lastElement);

                            stackInput.setText("STACK: " + (stack.size() + 1));
                            firstStackInput.setText("0");
                            maininput.setText(parser);
                        }
                        if(stack.size()>1)
                        {
                            double lastElement = stack.pop();
                            String parser = String.valueOf(lastElement);

                            double element = stack.peek();
                            String parser2 = String.valueOf(element);

                            stackInput.setText("STACK: " + (stack.size() + 1));
                            firstStackInput.setText(parser2);
                            maininput.setText(parser);
                        }
                    }
                }
        );
        sqrtButton.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        if(maininput.getText().toString().matches("")) maininput.setText("0");
                        else {
                            double number = Double.parseDouble(maininput.getText().toString());
                            double result = Math.sqrt(number);
                            String parser = String.valueOf(result);
                            maininput.setText(parser);
                        }
                    }
                }
        );

        enterButton.setOnClickListener(
               new Button.OnClickListener(){
                   @Override
                   public void onClick(View v) {
                       enterButtonClicked=true;

                        String parseNumber;

                       //first make sure that input is not null -> if it is just enter 0 to stack
                       if(maininput.getText().toString().matches("")){

                           stack.push(0);
                           long result = (long) stack.peek();
                           parseNumber = String.valueOf(result);
                           maininput.setText(parseNumber);
                           firstStackInput.setText("");
                           stackInput.setText("STACK: "+(stack.size()+1)); //+one because we start count stack size from 1 not from 0


                       }

                       else {
                               //first parse input to double than push our result to the stack
                               //then add last element on the stack to the firstStackInput)
                               double result = Double.parseDouble(maininput.getText().toString());
                               stack.push(result);
                               stackInput.setText("STACK: " + (stack.size()+1));

                                   //check if our number from stack is integer or double - cause if its integer than we dont want to see zeros
                                   // -> for example we dont want to see this on stack input -> 54.0
                                   if ((stack.peek() % 1) == 0) {
                                      long resultInt = (long) stack.peek();
                                       parseNumber = String.valueOf(resultInt);

                                       //add to the screen last element of our stack
                                       firstStackInput.setText(parseNumber);
                                       maininput.setText(parseNumber);

                                   } else {
                                       //add to the screen last element of our stack

                                       parseNumber = String.valueOf(stack.peek());
                                       firstStackInput.setText(parseNumber);
                                   }






                       }
                   }
               }
        );

        additionButton.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        String parseNumber;

                        //we have to stack number from mainInput
                        //

                        //FIRST BEFORE ADD ELEMENTS CHECK IF STACK IS EMPTY -> IF ITS EMPTY THAN DONT CHANGE ANTYHING
                        if(stack.size()==0) {
                            firstStackInput.setText("");

                        }
                        //ELSE DO ADDITION
                        else {
                            //pop two elements from stack,add them,parse and set to inputs

                            double x = Double.parseDouble(maininput.getText().toString());
                            stack.push(x);

                            double result = stack.add();
                            //check if result is integer
                            if ((result % 1) == 0) {
                               long resultInt = (long) result;
                                parseNumber = String.valueOf(resultInt);
                                maininput.setText(parseNumber);
                                stackInput.setText("STACK: " + (stack.size()+1));
                            } else {
                                parseNumber = String.valueOf(result);
                                maininput.setText(parseNumber);
                                stackInput.setText("STACK: " + (stack.size()+1));
                            }
                            //PUTTING LAST POP ELEMENT TO STACK2 ROW

                            //we have to get last pop element from stack and put him into the screen
                            //if stack is empty than set null to STACK2 SCREEEN else just put lastPopElement
                            if (stack.size() == 0) {
                                firstStackInput.setText("");
                            } else {

                                //we get lastPopElement, check if its integer and put it to inputs
                                double lastPopElement = stack.getSecondLastElement();
                                if((lastPopElement %1)==0)
                                {
                                    if(stack.isStackIsOver()){
                                        firstStackInput.setText("");
                                        stackInput.setText("STACK: 1");
                                    }
                                    else {
                                        long tmp = (long) lastPopElement;
                                        parseNumber = String.valueOf(tmp);
                                        firstStackInput.setText(parseNumber);
                                    }

                                }
                                else {
                                    if(stack.isStackIsOver()){
                                        firstStackInput.setText("");
                                        stackInput.setText("STACK: 1");
                                    }
                                    else {
                                        parseNumber = String.valueOf(lastPopElement);
                                        firstStackInput.setText(parseNumber);
                                    }
                                }
                            }

                        }


                    }
                }
        );


        subtractButton.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        String parseNumber;

                        //we have to stack number from mainInput
                        //

                        //FIRST BEFORE ADD ELEMENTS CHECK IF STACK IS EMPTY -> IF ITS EMPTY THAN DONT CHANGE ANTYHING
                        if(stack.size()==0) {
                            firstStackInput.setText("");

                        }
                        //ELSE DO ADDITION
                        else {
                            //pop two elements from stack,add them,parse and set to inputs

                            double x = Double.parseDouble(maininput.getText().toString());
                            stack.push(x);

                            double result = stack.sub();
                            //check if result is integer
                            if ((result % 1) == 0) {
                                long resultInt = (long) result;
                                parseNumber = String.valueOf(resultInt);
                                maininput.setText(parseNumber);
                                stackInput.setText("STACK: " + (stack.size()+1));
                            } else {
                                parseNumber = String.valueOf(result);
                                maininput.setText(parseNumber);
                                stackInput.setText("STACK: " + (stack.size()+1));
                            }
                            //PUTTING LAST POP ELEMENT TO STACK2 ROW

                            //we have to get last pop element from stack and put him into the screen
                            //if stack is empty than set null to STACK2 SCREEEN else just put lastPopElement
                            if (stack.size() == 0) {
                                firstStackInput.setText("");
                            } else {

                                //we get lastPopElement, check if its integer and put it to inputs
                                double lastPopElement = stack.getSecondLastElement();
                                if((lastPopElement %1)==0)
                                {
                                    if(stack.isStackIsOver()){
                                        firstStackInput.setText("");
                                        stackInput.setText("STACK: 1");
                                    }
                                    else {
                                        long tmp = (long) lastPopElement;
                                        parseNumber = String.valueOf(tmp);
                                        firstStackInput.setText(parseNumber);
                                    }

                                }
                                else {
                                    if(stack.isStackIsOver()){
                                        firstStackInput.setText("");
                                        stackInput.setText("STACK: 1");
                                    }
                                    else {
                                        parseNumber = String.valueOf(lastPopElement);
                                        firstStackInput.setText(parseNumber);
                                    }
                                }
                            }

                        }
                    }
                }
        );

        multiplyButton.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        String parseNumber;

                        //we have to stack number from mainInput
                        //

                        //FIRST BEFORE ADD ELEMENTS CHECK IF STACK IS EMPTY -> IF ITS EMPTY THAN DONT CHANGE ANTYHING
                        if(stack.size()==0) {
                            firstStackInput.setText("");

                        }
                        //ELSE DO ADDITION
                        else {
                            //pop two elements from stack,add them,parse and set to inputs

                            double x = Double.parseDouble(maininput.getText().toString());
                            stack.push(x);

                            double result = stack.mul();
                            //check if result is integer
                            if ((result % 1) == 0) {
                                long resultInt = (long) result;
                                parseNumber = String.valueOf(resultInt);
                                maininput.setText(parseNumber);
                                stackInput.setText("STACK: " + (stack.size()+1));
                            } else {
                                parseNumber = String.valueOf(result);
                                maininput.setText(parseNumber);
                                stackInput.setText("STACK: " + (stack.size()+1));
                            }
                            //PUTTING LAST POP ELEMENT TO STACK2 ROW

                            //we have to get last pop element from stack and put him into the screen
                            //if stack is empty than set null to STACK2 SCREEEN else just put lastPopElement
                            if (stack.size() == 0) {
                                firstStackInput.setText("");
                            } else {

                                //we get lastPopElement, check if its integer and put it to inputs
                                double lastPopElement = stack.getSecondLastElement();
                                if((lastPopElement %1)==0)
                                {
                                    if(stack.isStackIsOver()){
                                        firstStackInput.setText("");
                                        stackInput.setText("STACK: 1");
                                    }
                                    else {
                                        long tmp = (long) lastPopElement;
                                        parseNumber = String.valueOf(tmp);
                                        firstStackInput.setText(parseNumber);
                                    }

                                }
                                else {
                                    if(stack.isStackIsOver()){
                                        firstStackInput.setText("");
                                        stackInput.setText("STACK: 1");
                                    }
                                    else {
                                        parseNumber = String.valueOf(lastPopElement);
                                        firstStackInput.setText(parseNumber);
                                    }
                                }
                            }

                        }
                    }
                }
        );

        powerButton.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        String parseNumber;

                        //we have to stack number from mainInput
                        //

                        //FIRST BEFORE ADD ELEMENTS CHECK IF STACK IS EMPTY -> IF ITS EMPTY THAN DONT CHANGE ANTYHING
                        if(stack.size()==0) {
                            firstStackInput.setText("");

                        }
                        //ELSE DO ADDITION
                        else {
                            //pop two elements from stack,add them,parse and set to inputs

                            double x = Double.parseDouble(maininput.getText().toString());
                            stack.push(x);

                            double result = stack.pow();
                            //check if result is integer
                            if ((result % 1) == 0) {
                               long resultInt = (long) result;
                                parseNumber = String.valueOf(resultInt);
                                maininput.setText(parseNumber);
                                stackInput.setText("STACK: " + (stack.size()+1));
                            } else {
                                parseNumber = String.valueOf(result);
                                maininput.setText(parseNumber);
                                stackInput.setText("STACK: " + (stack.size()+1));
                            }
                            //PUTTING LAST POP ELEMENT TO STACK2 ROW

                            //we have to get last pop element from stack and put him into the screen
                            //if stack is empty than set null to STACK2 SCREEEN else just put lastPopElement
                            if (stack.size() == 0) {
                                firstStackInput.setText("");
                            } else {

                                //we get lastPopElement, check if its integer and put it to inputs
                                double lastPopElement = stack.getSecondLastElement();
                                if((lastPopElement %1)==0)
                                {
                                    if(stack.isStackIsOver()){
                                        firstStackInput.setText("");
                                        stackInput.setText("STACK: 1");
                                    }
                                    else {
                                        long tmp = (long) lastPopElement;
                                        parseNumber = String.valueOf(tmp);
                                        firstStackInput.setText(parseNumber);
                                    }

                                }
                                else {
                                    if(stack.isStackIsOver()){
                                        firstStackInput.setText("");
                                        stackInput.setText("STACK: 1");
                                    }
                                    else {
                                        parseNumber = String.valueOf(lastPopElement);
                                        firstStackInput.setText(parseNumber);
                                    }
                                }
                            }

                        }
                    }
                }
        );

        divideButton.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        String parseNumber;

                        //we have to stack number from mainInput
                        //

                        //FIRST BEFORE ADD ELEMENTS CHECK IF STACK IS EMPTY -> IF ITS EMPTY THAN DONT CHANGE ANTYHING
                        if(stack.size()==0) {
                            firstStackInput.setText("");

                        }
                        //ELSE DO ADDITION
                        else {
                            //pop two elements from stack,add them,parse and set to inputs

                            double x = Double.parseDouble(maininput.getText().toString());
                            stack.push(x);

                            double result = stack.div();
                            //check if result is integer
                            if ((result % 1) == 0) {
                                long resultInt = (long) result;
                                parseNumber = String.valueOf(resultInt);
                                maininput.setText(parseNumber);
                                stackInput.setText("STACK: " + (stack.size()+1));
                            } else {
                                parseNumber = String.valueOf(result);
                                maininput.setText(parseNumber);
                                stackInput.setText("STACK: " + (stack.size()+1));
                            }
                            //PUTTING LAST POP ELEMENT TO STACK2 ROW

                            //we have to get last pop element from stack and put him into the screen
                            //if stack is empty than set null to STACK2 SCREEEN else just put lastPopElement
                            if (stack.size() == 0) {
                                firstStackInput.setText("");
                            } else {

                                //we get lastPopElement, check if its integer and put it to inputs
                                double lastPopElement = stack.getSecondLastElement();
                                if((lastPopElement %1)==0)
                                {
                                    if(stack.isStackIsOver()){
                                        firstStackInput.setText("");
                                        stackInput.setText("STACK: 1");
                                    }
                                    else {
                                        long tmp = (long) lastPopElement;
                                        parseNumber = String.valueOf(tmp);
                                        firstStackInput.setText(parseNumber);
                                    }

                                }
                                else {
                                    if(stack.isStackIsOver()){
                                        firstStackInput.setText("");
                                        stackInput.setText("STACK: 1");
                                    }
                                    else {
                                        parseNumber = String.valueOf(lastPopElement);
                                        firstStackInput.setText(parseNumber);
                                    }
                                }
                            }

                        }
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
