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

/*commentary section -> below code*/
public class MainActivity extends Activity {

    Stack stack = new Stack();

    /*WHY DO WE NEED CLICKED FLAG?
      1. So we have to check if we clicked enterButton -> cause if we do, we want to clear our input first and than append a number
      2. if we didnt clicked than just append a number
                          * */
    boolean enterButtonClicked = false;

    /*INITIALIZE METHOD FOR 1-9 NUMBERS
    1. We are checking length of mainInput
     */
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
        final TextView stack1 = findViewById(R.id.stack1);
        TextView stack2 = findViewById(R.id.stack2);
        TextView stack3 = findViewById(R.id.stack3);
        TextView stack4 = findViewById(R.id.stack4);
        TextView deg = findViewById(R.id.deg);

        //these are important-stack screens
        final TextView secondStackInput = findViewById(R.id.secondStackInput);
        final TextView thirdStackInput = findViewById(R.id.thirdStackInput);
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

                    firstStackInput.setHintTextColor(getResources().getColor(R.color.stackBlack));
                    secondStackInput.setHintTextColor(getResources().getColor(R.color.stackBlack));
                    thirdStackInput.setHintTextColor(getResources().getColor(R.color.stackBlack));
                    maininput.setHintTextColor(getResources().getColor(R.color.stackBlack));

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

                    firstStackInput.setHintTextColor(getResources().getColor(R.color.greyy));
                    secondStackInput.setHintTextColor(getResources().getColor(R.color.greyy));
                    thirdStackInput.setHintTextColor(getResources().getColor(R.color.greyy));
                    maininput.setHintTextColor(getResources().getColor(R.color.greyy));

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

                    firstStackInput.setHintTextColor(getResources().getColor(R.color.greyy));
                    secondStackInput.setHintTextColor(getResources().getColor(R.color.greyy));
                    thirdStackInput.setHintTextColor(getResources().getColor(R.color.greyy));
                    maininput.setHintTextColor(getResources().getColor(R.color.greyy));

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

                    firstStackInput.setHintTextColor(getResources().getColor(R.color.greyy));
                    secondStackInput.setHintTextColor(getResources().getColor(R.color.greyy));
                    thirdStackInput.setHintTextColor(getResources().getColor(R.color.greyy));
                    maininput.setHintTextColor(getResources().getColor(R.color.greyy));

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
                        if(stack.size()==0) maininput.setText("");
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
                            secondStackInput.setText("");
                            thirdStackInput.setText("");
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
                        if(stack.size()==0) maininput.setText("0");
                        else if(stack.size()==1){
                            maininput.setText(String.valueOf(stack.peek()));
                            stack.pop();
                            firstStackInput.setText("0");
                            stackInput.setText("STACK: " + (stack.size()+1));
                        }

                        else if(stack.size()==2){
                            maininput.setText(String.valueOf(stack.peek()));
                            double lastElement=  stack.pop();//remove 2
                            double secondLastElement = stack.pop(); //remove 1
                            stack.push(secondLastElement);

                            firstStackInput.setText(String.valueOf(secondLastElement));
                            secondStackInput.setText("");
                            thirdStackInput.setText("");
                            stackInput.setText("STACK: " + (stack.size()+1));
                        }
                        else if(stack.size()==3){
                            maininput.setText(String.valueOf(stack.peek()));
                            double LastElement =  stack.pop(); //remove 3
                            double secondLastElement = stack.pop(); //remove 2
                            double thirdLastElement = stack.pop(); //remove 1
                            firstStackInput.setText(String.valueOf(secondLastElement));
                            secondStackInput.setText(String.valueOf(thirdLastElement));
                            thirdStackInput.setText("");
                            stack.push(thirdLastElement);
                            stack.push(secondLastElement);

                            stackInput.setText("STACK: " + (stack.size()+1));



                        }
                        else{
                            maininput.setText(String.valueOf(stack.peek()));
                            double LastElement =  stack.pop(); //remove 4
                            double secondLastElement = stack.pop(); //remove 3
                            double thirdLastElement = stack.pop(); //remove 2
                            double fourthLastElement = stack.pop(); //remove 1
                            firstStackInput.setText(String.valueOf(secondLastElement));
                            secondStackInput.setText(String.valueOf(thirdLastElement));
                            thirdStackInput.setText(String.valueOf(fourthLastElement));
                            stack.push(fourthLastElement);
                            stack.push(thirdLastElement);
                            stack.push(secondLastElement);

                            stackInput.setText("STACK: " + (stack.size()+1));

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
                           secondStackInput.setText("");
                           thirdStackInput.setText("");
                           stackInput.setText("STACK: "+(stack.size()+1)); //+one because we start count stack size from 1 not from 0


                       }

                       else {

                           if(stack.size()==0){
                               stack.push(Double.parseDouble(maininput.getText().toString()));
                               firstStackInput.setText(String.valueOf(stack.peek()));
                               secondStackInput.setText("");
                               thirdStackInput.setText("");
                               stackInput.setText("STACK: "+(stack.size()+1));
                           }
                           else if (stack.size()==1){
                               thirdStackInput.setText("");
                               secondStackInput.setText(String.valueOf(stack.peek()));
                               stack.push(Double.parseDouble(maininput.getText().toString()));
                               firstStackInput.setText(String.valueOf(stack.peek()));
                               stackInput.setText("STACK: "+(stack.size()+1));

                           }
                            else {
                               double lastElement =  stack.pop();//remove 2 in my example
                               double secondLastElement = stack.pop();//remove 1 in my example
                               stack.push(secondLastElement);
                               stack.push(lastElement);
                               stack.push(Double.parseDouble(maininput.getText().toString()));
                               firstStackInput.setText(String.valueOf(stack.peek()));
                               secondStackInput.setText(String.valueOf(lastElement));
                               thirdStackInput.setText(String.valueOf(secondLastElement));
                               stackInput.setText("STACK: "+(stack.size()+1));

                           }


                       }
                   }
               }
        );

        additionButton.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {

                        if(stack.size()==0) {
                            firstStackInput.setText("");
                            secondStackInput.setText("");
                            thirdStackInput.setText("");
                            maininput.setText("");
                        }
                        else if(stack.size()==1) {
                            stack.push(Double.parseDouble(maininput.getText().toString()));
                            double lastElement  =stack.pop();
                            double secondLastElement = stack.pop();
                            double result= lastElement+secondLastElement;
                            maininput.setText(String.valueOf(result));
                            stackInput.setText("STACK: " + (stack.size()+1));
                            firstStackInput.setText("");
                            secondStackInput.setText("");
                            thirdStackInput.setText("");

                        }
                        else if (stack.size()==2){
                            stack.push(Double.parseDouble(maininput.getText().toString()));
                            double lastElement  =stack.pop(); //3 in my example
                            double secondLastElement = stack.pop(); //2 in my example
                            double thirdLastElement = stack.pop(); //1 in my example
                            double result= lastElement+secondLastElement;
                            maininput.setText(String.valueOf(result));
                            stack.push(thirdLastElement);
                            firstStackInput.setText(String.valueOf(thirdLastElement));
                            secondStackInput.setText("");
                            thirdStackInput.setText("");
                            stackInput.setText("STACK: "+(stack.size()+1));


                            stackInput.setText("STACK: " + (stack.size()+1));

                        }
                        else if (stack.size()==3){
                            stack.push(Double.parseDouble(maininput.getText().toString()));
                            double lastElement  =stack.pop(); //4 in my example
                            double secondLastElement = stack.pop(); //3 in my example
                            double thirdLastElement = stack.pop(); //2 in my example
                            double fourthLastElement = stack.pop(); //1 in my example
                            double result= lastElement+secondLastElement;
                            maininput.setText(String.valueOf(result));
                            stack.push(thirdLastElement);
                            stack.push(fourthLastElement);
                            firstStackInput.setText(String.valueOf(thirdLastElement));
                            secondStackInput.setText(String.valueOf(fourthLastElement));
                            thirdStackInput.setText("");

                            stackInput.setText("STACK: " + (stack.size()+1));

                        }
                        else{
                            stack.push(Double.parseDouble(maininput.getText().toString()));
                            double lastElement  =stack.pop(); //5 in my example
                            double secondLastElement = stack.pop(); //4 in my example
                            double thirdLastElement = stack.pop(); //3 in my example
                            double fourthLastElement = stack.pop(); //2 in my example
                            double fifthLastElement = stack.pop(); //1 in my example
                            double result= lastElement+secondLastElement;
                            maininput.setText(String.valueOf(result));
                            stack.push(fifthLastElement);
                            stack.push(fourthLastElement);
                            stack.push(thirdLastElement);
                            firstStackInput.setText(String.valueOf(thirdLastElement));
                            secondStackInput.setText(String.valueOf(fourthLastElement));
                            thirdStackInput.setText(String.valueOf(fifthLastElement));
                            stackInput.setText("STACK: " + (stack.size()+1));
                        }


                    }
                }
        );


        subtractButton.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {

                        if(stack.size()==0) {
                            firstStackInput.setText("");
                            secondStackInput.setText("");
                            thirdStackInput.setText("");
                            maininput.setText("");

                        }
                        else if(stack.size()==1) {
                            stack.push(Double.parseDouble(maininput.getText().toString()));
                            double lastElement  =stack.pop();
                            double secondLastElement = stack.pop();
                            double result= lastElement-secondLastElement;
                            maininput.setText(String.valueOf(result));
                            stackInput.setText("STACK: " + (stack.size()+1));
                            firstStackInput.setText("");
                            secondStackInput.setText("");
                            thirdStackInput.setText("");

                        }
                        else if (stack.size()==2){
                            stack.push(Double.parseDouble(maininput.getText().toString()));
                            double lastElement  =stack.pop(); //3 in my example
                            double secondLastElement = stack.pop(); //2 in my example
                            double thirdLastElement = stack.pop(); //1 in my example
                            double result= lastElement-secondLastElement;
                            maininput.setText(String.valueOf(result));
                            stack.push(thirdLastElement);
                            firstStackInput.setText(String.valueOf(thirdLastElement));
                            secondStackInput.setText("");
                            thirdStackInput.setText("");


                            stackInput.setText("STACK: " + (stack.size()+1));

                        }
                        else if (stack.size()==3){
                            stack.push(Double.parseDouble(maininput.getText().toString()));
                            double lastElement  =stack.pop(); //4 in my example
                            double secondLastElement = stack.pop(); //3 in my example
                            double thirdLastElement = stack.pop(); //2 in my example
                            double fourthLastElement = stack.pop(); //1 in my example
                            double result= lastElement-secondLastElement;
                            maininput.setText(String.valueOf(result));
                            stack.push(thirdLastElement);
                            stack.push(fourthLastElement);
                            firstStackInput.setText(String.valueOf(thirdLastElement));
                            secondStackInput.setText(String.valueOf(fourthLastElement));
                            thirdStackInput.setText("");

                            stackInput.setText("STACK: " + (stack.size()+1));

                        }
                        else{
                            stack.push(Double.parseDouble(maininput.getText().toString()));
                            double lastElement  =stack.pop(); //5 in my example
                            double secondLastElement = stack.pop(); //4 in my example
                            double thirdLastElement = stack.pop(); //3 in my example
                            double fourthLastElement = stack.pop(); //2 in my example
                            double fifthLastElement = stack.pop(); //1 in my example
                            double result= lastElement-secondLastElement;
                            maininput.setText(String.valueOf(result));
                            stack.push(fifthLastElement);
                            stack.push(fourthLastElement);
                            stack.push(thirdLastElement);
                            firstStackInput.setText(String.valueOf(thirdLastElement));
                            secondStackInput.setText(String.valueOf(fourthLastElement));
                            thirdStackInput.setText(String.valueOf(fifthLastElement));
                            stackInput.setText("STACK: " + (stack.size()+1));
                        }



                    }
                }
        );

        multiplyButton.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {

                        if(stack.size()==0) {
                            firstStackInput.setText("");
                            secondStackInput.setText("");
                            thirdStackInput.setText("");
                            maininput.setText("");
                        }
                        else if(stack.size()==1) {
                            stack.push(Double.parseDouble(maininput.getText().toString()));
                            double lastElement  =stack.pop();
                            double secondLastElement = stack.pop();
                            double result= lastElement*secondLastElement;
                            maininput.setText(String.valueOf(result));
                            stackInput.setText("STACK: " + (stack.size()+1));
                            firstStackInput.setText("");
                            secondStackInput.setText("");
                            thirdStackInput.setText("");

                        }
                        else if (stack.size()==2){
                            stack.push(Double.parseDouble(maininput.getText().toString()));
                            double lastElement  =stack.pop(); //3 in my example
                            double secondLastElement = stack.pop(); //2 in my example
                            double thirdLastElement = stack.pop(); //1 in my example
                            double result= lastElement*secondLastElement;
                            maininput.setText(String.valueOf(result));
                            stack.push(thirdLastElement);
                            firstStackInput.setText(String.valueOf(thirdLastElement));
                            secondStackInput.setText("");
                            thirdStackInput.setText("");


                            stackInput.setText("STACK: " + (stack.size()+1));

                        }
                        else if (stack.size()==3){
                            stack.push(Double.parseDouble(maininput.getText().toString()));
                            double lastElement  =stack.pop(); //4 in my example
                            double secondLastElement = stack.pop(); //3 in my example
                            double thirdLastElement = stack.pop(); //2 in my example
                            double fourthLastElement = stack.pop(); //1 in my example
                            double result= lastElement*secondLastElement;
                            maininput.setText(String.valueOf(result));
                            stack.push(thirdLastElement);
                            stack.push(fourthLastElement);
                            firstStackInput.setText(String.valueOf(thirdLastElement));
                            secondStackInput.setText(String.valueOf(fourthLastElement));
                            thirdStackInput.setText("");

                            stackInput.setText("STACK: " + (stack.size()+1));

                        }
                        else{
                            stack.push(Double.parseDouble(maininput.getText().toString()));
                            double lastElement  =stack.pop(); //5 in my example
                            double secondLastElement = stack.pop(); //4 in my example
                            double thirdLastElement = stack.pop(); //3 in my example
                            double fourthLastElement = stack.pop(); //2 in my example
                            double fifthLastElement = stack.pop(); //1 in my example
                            double result= lastElement*secondLastElement;
                            maininput.setText(String.valueOf(result));
                            stack.push(fifthLastElement);
                            stack.push(fourthLastElement);
                            stack.push(thirdLastElement);
                            firstStackInput.setText(String.valueOf(thirdLastElement));
                            secondStackInput.setText(String.valueOf(fourthLastElement));
                            thirdStackInput.setText(String.valueOf(fifthLastElement));
                            stackInput.setText("STACK: " + (stack.size()+1));
                        }



                    }
                }
        );

        divideButton.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {

                        if(stack.size()==0) {
                            firstStackInput.setText("");
                            secondStackInput.setText("");
                            thirdStackInput.setText("");
                            maininput.setText("");
                        }
                        else if(stack.size()==1) {
                            stack.push(Double.parseDouble(maininput.getText().toString()));
                            double lastElement  =stack.pop();
                            double secondLastElement = stack.pop();
                            double result=secondLastElement/lastElement;
                            maininput.setText(String.valueOf(result));
                            stackInput.setText("STACK: " + (stack.size()+1));
                            firstStackInput.setText("");
                            secondStackInput.setText("");
                            thirdStackInput.setText("");

                        }
                        else if (stack.size()==2){
                            stack.push(Double.parseDouble(maininput.getText().toString()));
                            double lastElement  =stack.pop(); //3 in my example
                            double secondLastElement = stack.pop(); //2 in my example
                            double thirdLastElement = stack.pop(); //1 in my example
                            double result= secondLastElement/lastElement;
                            maininput.setText(String.valueOf(result));
                            stack.push(thirdLastElement);
                            firstStackInput.setText(String.valueOf(thirdLastElement));
                            secondStackInput.setText("");
                            thirdStackInput.setText("");


                            stackInput.setText("STACK: " + (stack.size()+1));

                        }
                        else if (stack.size()==3){
                            stack.push(Double.parseDouble(maininput.getText().toString()));
                            double lastElement  =stack.pop(); //4 in my example
                            double secondLastElement = stack.pop(); //3 in my example
                            double thirdLastElement = stack.pop(); //2 in my example
                            double fourthLastElement = stack.pop(); //1 in my example
                            double result= secondLastElement/lastElement;
                            maininput.setText(String.valueOf(result));
                            stack.push(thirdLastElement);
                            stack.push(fourthLastElement);
                            firstStackInput.setText(String.valueOf(thirdLastElement));
                            secondStackInput.setText(String.valueOf(fourthLastElement));
                            thirdStackInput.setText("");

                            stackInput.setText("STACK: " + (stack.size()+1));

                        }
                        else{
                            stack.push(Double.parseDouble(maininput.getText().toString()));
                            double lastElement  =stack.pop(); //5 in my example
                            double secondLastElement = stack.pop(); //4 in my example
                            double thirdLastElement = stack.pop(); //3 in my example
                            double fourthLastElement = stack.pop(); //2 in my example
                            double fifthLastElement = stack.pop(); //1 in my example
                            double result= secondLastElement/lastElement;
                            maininput.setText(String.valueOf(result));
                            stack.push(fifthLastElement);
                            stack.push(fourthLastElement);
                            stack.push(thirdLastElement);
                            firstStackInput.setText(String.valueOf(thirdLastElement));
                            secondStackInput.setText(String.valueOf(fourthLastElement));
                            thirdStackInput.setText(String.valueOf(fifthLastElement));
                            stackInput.setText("STACK: " + (stack.size()+1));
                        }

                    }
                }
        );

        powerButton.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {

                        if(stack.size()==0) {
                            firstStackInput.setText("");
                            secondStackInput.setText("");
                            thirdStackInput.setText("");
                            maininput.setText("");
                        }
                        else if(stack.size()==1) {
                            stack.push(Double.parseDouble(maininput.getText().toString()));
                            double lastElement  =stack.pop();
                            double secondLastElement = stack.pop();
                            double result= Math.pow(secondLastElement,lastElement);
                            maininput.setText(String.valueOf(result));
                            stackInput.setText("STACK: " + (stack.size()+1));
                            firstStackInput.setText("");
                            secondStackInput.setText("");
                            thirdStackInput.setText("");

                        }
                        else if (stack.size()==2){
                            stack.push(Double.parseDouble(maininput.getText().toString()));
                            double lastElement  =stack.pop(); //3 in my example
                            double secondLastElement = stack.pop(); //2 in my example
                            double thirdLastElement = stack.pop(); //1 in my example
                            double result= Math.pow(secondLastElement,lastElement);
                            maininput.setText(String.valueOf(result));
                            stack.push(thirdLastElement);
                            firstStackInput.setText(String.valueOf(thirdLastElement));
                            secondStackInput.setText("");
                            thirdStackInput.setText("");


                            stackInput.setText("STACK: " + (stack.size()+1));

                        }
                        else if (stack.size()==3){
                            stack.push(Double.parseDouble(maininput.getText().toString()));
                            double lastElement  =stack.pop(); //4 in my example
                            double secondLastElement = stack.pop(); //3 in my example
                            double thirdLastElement = stack.pop(); //2 in my example
                            double fourthLastElement = stack.pop(); //1 in my example
                            double result= Math.pow(secondLastElement,lastElement);
                            maininput.setText(String.valueOf(result));
                            stack.push(thirdLastElement);
                            stack.push(fourthLastElement);
                            firstStackInput.setText(String.valueOf(thirdLastElement));
                            secondStackInput.setText(String.valueOf(fourthLastElement));
                            thirdStackInput.setText("");

                            stackInput.setText("STACK: " + (stack.size()+1));

                        }
                        else{
                            stack.push(Double.parseDouble(maininput.getText().toString()));
                            double lastElement  =stack.pop(); //5 in my example
                            double secondLastElement = stack.pop(); //4 in my example
                            double thirdLastElement = stack.pop(); //3 in my example
                            double fourthLastElement = stack.pop(); //2 in my example
                            double fifthLastElement = stack.pop(); //1 in my example
                            double result= Math.pow(secondLastElement,lastElement);
                            maininput.setText(String.valueOf(result));
                            stack.push(fifthLastElement);
                            stack.push(fourthLastElement);
                            stack.push(thirdLastElement);
                            firstStackInput.setText(String.valueOf(thirdLastElement));
                            secondStackInput.setText(String.valueOf(fourthLastElement));
                            thirdStackInput.setText(String.valueOf(fifthLastElement));
                            stackInput.setText("STACK: " + (stack.size()+1));
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

/* O kodzie:

1. Każdy widok to nowa aktywność. Mamy widoki z 1,2,3 lub 4 wierszami do stosu.
2. Wiekszosc kodu jest powtarzalna zatem komentarze znajduja się w tej klasie

* */