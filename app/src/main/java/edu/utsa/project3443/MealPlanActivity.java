package edu.utsa.project3443;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.ComponentActivity;

public class MealPlanActivity extends ComponentActivity {
    private Button submit, button2, customButton, customButton2;
    private ImageButton imageButton2, imageButton3, imageButton6, imageButton7, imageButton8, imageButton9, imageButton10;
    private EditText n2, n3;
    private TextView result;
    private String am = "AM", pm = "PM", ampm = null;
    private int veggies = 0, meat = 0, fruit = 0, oil = 0, carbs = 0, dairy = 0, sweets = 0;
    private int currentVal = 0, sumTotal = 0, subTotal = 0, veggieCalPerAmount = 0, meatCalPerAmount = 0, fruitCalPerAmount = 0,
            oilCalPerAmount = 0, carbsCalPerAmount = 0, dairyCalPerAmount = 0, sweetsCalPerAmount = 0;
    private boolean customButtonClicked = false, customButton2Clicked = false;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meals);
        setupButtons();
    }
    private void setupButtons(){
        submit = (Button) findViewById(R.id.submit);
        button2 = (Button) findViewById(R.id.backbutton);
        customButton = (Button) findViewById(R.id.custom_button_meal);
        customButton2 = (Button) findViewById(R.id.custom_button2_meal);
        Switch switchEnableButton = findViewById(R.id.switch_enable_meal_button);
        Switch switchEnableButton2 = findViewById(R.id.switch_enable_meal_button2);
        imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        imageButton3 = (ImageButton) findViewById(R.id.imageButton3);
        imageButton6 = (ImageButton) findViewById(R.id.imageButton6);
        imageButton7 = (ImageButton) findViewById(R.id.imageButton7);
        imageButton8 = (ImageButton) findViewById(R.id.imageButton8);
        imageButton9 = (ImageButton) findViewById(R.id.imageButton9);
        imageButton10 = (ImageButton) findViewById(R.id.imageButton10);

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText wText = (EditText) findViewById(R.id.mealtype);
                ampm = wText.getText().toString();
                EditText tText = (EditText) findViewById(R.id.editTextNumber2);
                if(workoutCount(wText.getText().toString(), Integer.parseInt(tText.getText().toString()))) {
                    Intent intent = new Intent(edu.utsa.project3443.MealPlanActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                else{
                    wText.setText("");
                    tText.setText("");
                    wText.setError("Incorrect choice, choose AM/PM");
                    tText.setError("Incorrect time in minutes.");
                }
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText wText = (EditText) findViewById(R.id.mealtype);
                ampm = wText.getText().toString();
                EditText submit = (EditText) findViewById(R.id.editTextNumber3);   //FIX ME: want to pass mealtype too
                Intent intent = new Intent(edu.utsa.project3443.MealPlanActivity.this, MainActivity.class); //FIX ME
                intent.putExtra("Meal Calories", Integer.parseInt(submit.getText().toString()));
                intent.putExtra("Time of the day", ampm);
                startActivity(intent);
            }
        });
        //veggies
        imageButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentVal = 25;
                n2 = (EditText) findViewById(R.id.editTextNumber2);
                n3 = (EditText) findViewById(R.id.editTextNumber3);
                result = (TextView) findViewById(R.id.tvAnswer11);
                int num2 = 0;
                try{
                    num2 = Integer.parseInt(n2.getText().toString());
                }
                catch(NumberFormatException e){
                    Toast.makeText(getBaseContext(), "Please set product amount, amount can't be NULL", Toast.LENGTH_SHORT).show();
                }
                veggieCalPerAmount = num2 * currentVal;
                result.setText("Cal " + veggieCalPerAmount);
                customButtonClicked = false;
                customButton2Clicked = false;
            }
        });
        //dairy
        imageButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    currentVal = 150;
                    n2 = (EditText) findViewById(R.id.editTextNumber2);
                    n3 = (EditText) findViewById(R.id.editTextNumber3);
                    result = (TextView) findViewById(R.id.tvAnswer2);
                    int num2 = 0;
                    try{
                        num2 = Integer.parseInt(n2.getText().toString());
                    }
                    catch(NumberFormatException e){
                        Toast.makeText(getBaseContext(), "Please set product amount, amount can't be NULL", Toast.LENGTH_SHORT).show();
                    }
                    dairyCalPerAmount = num2 * currentVal;
                    result.setText("Cal " + dairyCalPerAmount);
                    customButtonClicked = false;
                    customButton2Clicked = false;
                }
            });
            //carbs
            imageButton6.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    currentVal = 206;
                    n2 = (EditText) findViewById(R.id.editTextNumber2);
                    n3 = (EditText) findViewById(R.id.editTextNumber3);
                    result = (TextView) findViewById(R.id.tvAnswer5);
                    int num2 = 0;
                    try{
                        num2 = Integer.parseInt(n2.getText().toString());
                    }
                    catch(NumberFormatException e){
                        Toast.makeText(getBaseContext(), "Please set product amount, amount can't be NULL", Toast.LENGTH_SHORT).show();
                    }
                    carbsCalPerAmount = num2 * currentVal;
                    result.setText("Cal " + carbsCalPerAmount);
                    customButtonClicked = false;
                    customButton2Clicked = false;
                }
            });
            //meat
            imageButton7.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    currentVal = 375;
                    n2 = (EditText) findViewById(R.id.editTextNumber2);
                    n3 = (EditText) findViewById(R.id.editTextNumber3);
                    result = (TextView) findViewById(R.id.tvAnswer3);
                    int num2 = 0;
                    try{
                        num2 = Integer.parseInt(n2.getText().toString());
                    }
                    catch(NumberFormatException e){
                        Toast.makeText(getBaseContext(), "Please set product amount, amount can't be NULL", Toast.LENGTH_SHORT).show();
                    }
                    meatCalPerAmount = num2 * currentVal;
                    result.setText("Cal " + meatCalPerAmount);
                    customButtonClicked = false;
                    customButton2Clicked = false;
                }
            });
            //fruit
            imageButton8.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    currentVal = 80;
                    n2 = (EditText) findViewById(R.id.editTextNumber2);
                    n3 = (EditText) findViewById(R.id.editTextNumber3);
                    result = (TextView) findViewById(R.id.tvAnswer4);
                    int num2 = 0;
                    try{
                        num2 = Integer.parseInt(n2.getText().toString());
                    }
                    catch(NumberFormatException e){
                        Toast.makeText(getBaseContext(), "Please set product amount, amount can't be NULL", Toast.LENGTH_SHORT).show();
                    }
                    fruitCalPerAmount = num2 * currentVal;
                    result.setText("Cal " + fruitCalPerAmount);
                    customButtonClicked = false;
                    customButton2Clicked = false;
                }
            });
            //sweets
            imageButton9.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    currentVal = 100;
                    n2 = (EditText) findViewById(R.id.editTextNumber2);
                    n3 = (EditText) findViewById(R.id.editTextNumber3);
                    result = (TextView) findViewById(R.id.tvAnswer10);
                    int num2 = 0;
                    try{
                        num2 = Integer.parseInt(n2.getText().toString());
                    }
                    catch(NumberFormatException e){
                        Toast.makeText(getBaseContext(), "Please set product amount, amount can't be NULL", Toast.LENGTH_SHORT).show();
                    }
                    sweetsCalPerAmount = num2 * currentVal;
                    result.setText("Cal " + sweetsCalPerAmount);
                    customButtonClicked = false;
                    customButton2Clicked = false;
                }
            });
            //oil
            imageButton10.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    currentVal = 120;
                    n2 = (EditText) findViewById(R.id.editTextNumber2);
                    n3 = (EditText) findViewById(R.id.editTextNumber3);
                    result = (TextView) findViewById(R.id.tvAnswer9);
                    int num2 = 0;
                    try{
                        num2 = Integer.parseInt(n2.getText().toString());
                    }
                    catch(NumberFormatException e){
                        Toast.makeText(getBaseContext(), "Please set product amount, amount can't be NULL", Toast.LENGTH_SHORT).show();
                    }
                    oilCalPerAmount = num2 * currentVal;
                    result.setText("Cal " + oilCalPerAmount);
                    customButtonClicked = false;
                    customButton2Clicked = false;
                }
            });
            //Add
            customButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(edu.utsa.project3443.MealPlanActivity.this, "Clicked Add", Toast.LENGTH_SHORT).show();
                    veggies = veggieCalPerAmount; meat = meatCalPerAmount; fruit = fruitCalPerAmount; oil = oilCalPerAmount;
                    carbs = carbsCalPerAmount; dairy = dairyCalPerAmount; sweets = sweetsCalPerAmount;
                    n3 = (EditText) findViewById(R.id.editTextNumber3);
                    result = (TextView) findViewById(R.id.tvAnswer);
                    sumTotal = veggies + meat + fruit + oil + carbs + dairy + sweets;
                    result.setText("Calories: " + sumTotal);
                    n3.setText(String.valueOf(sumTotal));
                    customButtonClicked = true;
                }
            });
            switchEnableButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        customButton.setEnabled(true);
                    }
                    else {
                        customButton.setEnabled(false);
                    }
                }
            });
            //Subtract
            customButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(edu.utsa.project3443.MealPlanActivity.this, "Clicked Subtract", Toast.LENGTH_SHORT).show();
                    veggies = veggieCalPerAmount; meat = meatCalPerAmount; fruit = fruitCalPerAmount; oil = oilCalPerAmount;
                    carbs = carbsCalPerAmount; dairy = dairyCalPerAmount; sweets = sweetsCalPerAmount;
                    currentVal = sumTotal;
                    n3 = (EditText) findViewById(R.id.editTextNumber3);
                    result = (TextView) findViewById(R.id.tvAnswer);
                    subTotal = currentVal - veggies - meat - fruit - oil - carbs - dairy - sweets;
                    result.setText("Calories: " + subTotal);
                    n3.setText(String.valueOf(subTotal));
                    customButton2Clicked = true;
                }
            });
            switchEnableButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        customButton2.setEnabled(true);
                    }
                    else {
                        customButton2.setEnabled(false);
                    }
                }
            });
        }
        private boolean workoutCount (String workout, int time_min) {
            if (workout.equalsIgnoreCase(am) || workout.equalsIgnoreCase(pm) || workout.equalsIgnoreCase("") ) {
                return true;
            }
            return false;

        }
    }
