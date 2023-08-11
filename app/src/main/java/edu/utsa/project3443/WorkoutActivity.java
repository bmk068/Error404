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

public class WorkoutActivity extends ComponentActivity {
    private Button button1, button2, customButton, customButton2;
    private ImageButton imageButton2, imageButton3, imageButton6, imageButton7, imageButton8, imageButton9, imageButton10;
    private EditText n2, n3;
    private TextView result;
    private String am = "AM", pm = "PM", tdayampm = null;
    private int run = 0, walk = 0, swim = 0, dance = 0, weight = 0, yoga = 0, bicycle = 0;
    private int currentVal = 0, sumTotal = 0, subTotal = 0, runCalPerMin = 0, yogaCalPerMin = 0, weightCalPerMin = 0,
            walkCalPerMin = 0, swimCalPerMin = 0, bicycleCalPerMin = 0, danceCalPerMin = 0;
    private boolean customButtonClicked = false, customButton2Clicked = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout);
        setupButtons();
    }
    private void setupButtons(){
        button1 = (Button) findViewById(R.id.submit);
        button2 = (Button) findViewById(R.id.backbutton);
        customButton = (Button) findViewById(R.id.custom_button);
        customButton2 = (Button) findViewById(R.id.custom_button2);
        Switch switchEnableButton = findViewById(R.id.switch_enable_button);
        Switch switchEnableButton2 = findViewById(R.id.switch_enable_button2);
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
                tdayampm = wText.getText().toString();
                EditText tText = (EditText) findViewById(R.id.editTextNumber2);
                if(workoutCount(wText.getText().toString(), Integer.parseInt(tText.getText().toString()))) {
                    Intent intent = new Intent(WorkoutActivity.this, MainActivity.class);
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
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText wText = (EditText) findViewById(R.id.mealtype);
                tdayampm = wText.getText().toString();
                EditText submit = (EditText) findViewById(R.id.editTextNumber3);   //FIX ME: want to pass worktype too
                Intent intent = new Intent(WorkoutActivity.this, MainActivity.class); //FIX ME:MainActivity changed
                intent.putExtra("Workout Calories", Integer.parseInt(submit.getText().toString()));
                intent.putExtra("Time of day", tdayampm);
                startActivity(intent);
            }
        });
        //run
        imageButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentVal = 10;
                n2 = (EditText) findViewById(R.id.editTextNumber2);
                n3 = (EditText) findViewById(R.id.editTextNumber3);
                result = (TextView) findViewById(R.id.tvAnswer11);
                int num2 = 0;
                try{
                    num2 = Integer.parseInt(n2.getText().toString());
                }
                catch(NumberFormatException e){
                    Toast.makeText(getBaseContext(), "Please set time in minutes, time can't be NULL", Toast.LENGTH_SHORT).show();
                }
                runCalPerMin = num2 * currentVal;
                result.setText("Cal " + runCalPerMin);
                //n3.setText(String.valueOf(runCalPerMin));
                customButtonClicked = false;
                customButton2Clicked = false;
            }
        });
        //yoga/stretch
        imageButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentVal = 5;
                n2 = (EditText) findViewById(R.id.editTextNumber2);
                n3 = (EditText) findViewById(R.id.editTextNumber3);
                result = (TextView) findViewById(R.id.tvAnswer2);
                int num2 = 0;
                try{
                    num2 = Integer.parseInt(n2.getText().toString());
                }
                catch(NumberFormatException e){
                    Toast.makeText(getBaseContext(), "Please set time in minutes, time can't be NULL", Toast.LENGTH_SHORT).show();
                }
                yogaCalPerMin = num2 * currentVal;
                result.setText("Cal " + yogaCalPerMin);
                //n3.setText(String.valueOf(yogaCalPerMin));
                customButtonClicked = false;
                customButton2Clicked = false;
            }
        });
        //weight lifting
        imageButton6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentVal = 4;
                n2 = (EditText) findViewById(R.id.editTextNumber2);
                n3 = (EditText) findViewById(R.id.editTextNumber3);
                result = (TextView) findViewById(R.id.tvAnswer5);
                int num2 = 0;
                try{
                    num2 = Integer.parseInt(n2.getText().toString());
                }
                catch(NumberFormatException e){
                    Toast.makeText(getBaseContext(), "Please set time in minutes, time can't be NULL", Toast.LENGTH_SHORT).show();
                }
                weightCalPerMin = num2 * currentVal;
                result.setText("Cal " + weightCalPerMin);
                //n3.setText(String.valueOf(weightCalPerMin));
                customButtonClicked = false;
                customButton2Clicked = false;
            }
        });
        //walk
        imageButton7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentVal = 5;
                n2 = (EditText) findViewById(R.id.editTextNumber2);
                n3 = (EditText) findViewById(R.id.editTextNumber3);
                result = (TextView) findViewById(R.id.tvAnswer3);
                int num2 = 0;
                try{
                    num2 = Integer.parseInt(n2.getText().toString());
                }
                catch(NumberFormatException e){
                    Toast.makeText(getBaseContext(), "Please set time in minutes, time can't be NULL", Toast.LENGTH_SHORT).show();
                }
                walkCalPerMin = num2 * currentVal;
                result.setText("Cal " + walkCalPerMin);
                //n3.setText(String.valueOf(walkCalPerMin));
                customButtonClicked = false;
                customButton2Clicked = false;
            }
        });
        //swim
        imageButton8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentVal = 6;
                n2 = (EditText) findViewById(R.id.editTextNumber2);
                n3 = (EditText) findViewById(R.id.editTextNumber3);
                result = (TextView) findViewById(R.id.tvAnswer4);
                int num2 = 0;
                try{
                    num2 = Integer.parseInt(n2.getText().toString());
                }
                catch(NumberFormatException e){
                    Toast.makeText(getBaseContext(), "Please set time in minutes, time can't be NULL", Toast.LENGTH_SHORT).show();
                }
                swimCalPerMin = num2 * currentVal;
                result.setText("Cal " + swimCalPerMin);
                //n3.setText(String.valueOf(swimCalPerMin));
                customButtonClicked = false;
                customButton2Clicked = false;
            }
        });
        //bicycle
        imageButton9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentVal = 7;
                n2 = (EditText) findViewById(R.id.editTextNumber2);
                n3 = (EditText) findViewById(R.id.editTextNumber3);
                result = (TextView) findViewById(R.id.tvAnswer10);
                int num2 = 0;
                try{
                    num2 = Integer.parseInt(n2.getText().toString());
                }
                catch(NumberFormatException e){
                    Toast.makeText(getBaseContext(), "Please set time in minutes, time can't be NULL", Toast.LENGTH_SHORT).show();
                }
                bicycleCalPerMin = num2 * currentVal;
                result.setText("Cal " + bicycleCalPerMin);
                //n3.setText(String.valueOf(bicycleCalPerMin));
                customButtonClicked = false;
                customButton2Clicked = false;
            }
        });
        //dance
        imageButton10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentVal = 9;
                n2 = (EditText) findViewById(R.id.editTextNumber2);
                n3 = (EditText) findViewById(R.id.editTextNumber3);
                result = (TextView) findViewById(R.id.tvAnswer9);
                int num2 = 0;
                try{
                    num2 = Integer.parseInt(n2.getText().toString());
                }
                catch(NumberFormatException e){
                    Toast.makeText(getBaseContext(), "Please set time in minutes, time can't be NULL", Toast.LENGTH_SHORT).show();
                }
                danceCalPerMin = num2 * currentVal;
                result.setText("Cal " + danceCalPerMin);
                //n3.setText(String.valueOf(danceCalPerMin));
                customButtonClicked = false;
                customButton2Clicked = false;
            }
        });
        //Add
        customButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WorkoutActivity.this, "Clicked Add", Toast.LENGTH_SHORT).show();
                run = runCalPerMin; walk = walkCalPerMin; swim = swimCalPerMin; dance = danceCalPerMin;
                weight = weightCalPerMin; yoga = yogaCalPerMin; bicycle = bicycleCalPerMin;
                n3 = (EditText) findViewById(R.id.editTextNumber3);
                result = (TextView) findViewById(R.id.tvAnswer);
                sumTotal = run + walk + swim + dance + weight + yoga + bicycle;
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
                Toast.makeText(WorkoutActivity.this, "Clicked Subtract", Toast.LENGTH_SHORT).show();
                run = runCalPerMin; walk = walkCalPerMin; swim = swimCalPerMin; dance = danceCalPerMin;
                weight = weightCalPerMin; yoga = yogaCalPerMin; bicycle = bicycleCalPerMin;
                currentVal = sumTotal;
                n3 = (EditText) findViewById(R.id.editTextNumber3);
                result = (TextView) findViewById(R.id.tvAnswer);
                subTotal = currentVal - run - walk - swim - dance - weight - yoga - bicycle;
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