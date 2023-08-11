package edu.utsa.project3443;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.ComponentActivity;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MainActivity extends ComponentActivity { //FIX ME: logout
    private ImageButton imgButton, imgButton2, imgButton3, imgButton4;
    private Button logout, profile;
    private Account profileInfo;                                     //FIX ME: according to Carlos logon/profile
    //private AssetManager assets;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        Intent i = getIntent();
        int a = i.getIntExtra("Workout Calories", -1);
        int b = i.getIntExtra("Meal Calories", -1);
        String time = i.getStringExtra("Time of day");
        String time2 = i.getStringExtra("Time of the day");
        if (time != null) {
            Toast.makeText(this, String.valueOf(a) + " " + time, Toast.LENGTH_SHORT).show();
        }
        else if (time2 != null) {
            Toast.makeText(this, String.valueOf(b) + " " + time2, Toast.LENGTH_SHORT).show();
        }
        setupButtons();
        //assets = getAssets();                                    //FIX ME: delete if no assets
        //profileInfo = new Account(-1, "invalid", "invalid",-1);  //FIX ME
        setupProfile();
    }
    /**************************************************************************************/
    public void setupProfile(){
        Intent intent = getIntent();
        int id = intent.getIntExtra("id",-1);
        //profileInfo = new Account(id,assets);
        File f = new File(getFilesDir().getAbsolutePath() + "/user.txt");
        Scanner scan;
        String str = "";
        String[] arr = null;

        try {
            if(f.exists()) {
                //scan = new Scanner(assets.open("user.txt"));  //FIX ME: Carlos user.txt file
                scan = new Scanner(openFileInput("user.txt"));
                while (scan.hasNext()) {
                    str = scan.nextLine();
                    arr = str.split(",");
                    if (Integer.parseInt(arr[0]) == id) {
                        profileInfo = new Account(id, arr[1], arr[2], Integer.parseInt(arr[3]));
                        break;
                    }
                }
                scan.close();
            }
        }
        catch (IOException e){
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            //System.out.println("Error: " + e.getMessage());
        }
        if(profileInfo != null) {
            TextView name = (TextView) findViewById(R.id.username);
            name.setText(profileInfo.getName());
        }
    }

    /**************************************************************************************/
    private void setupButtons(){
        //Workout
        imgButton= (ImageButton) findViewById(R.id.imageButton);
        imgButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You Clicked Workout Button", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, WorkoutActivity.class);
                startActivity(intent);
            }
        });
        //Meal
        imgButton2= (ImageButton) findViewById(R.id.imageButton4);
        imgButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You Clicked Meal Button", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MealPlanActivity.class);
                startActivity(intent);
            }
        });
        //CalorieCount
        imgButton3= (ImageButton) findViewById(R.id.imageButton11);
        imgButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You Clicked Calorie Count Button", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, WorkoutActivity.class); //FIX ME: CalorieCountActivity
                startActivity(intent);
            }
        });
        //Goal
        imgButton4= (ImageButton) findViewById(R.id.imageButton5);
        imgButton4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You Clicked Goal Button", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, WorkoutActivity.class); //FIX ME: GoalActivity
                startActivity(intent);
            }
        });
        //profile
        profile = (Button) findViewById(R.id.profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You Clicked Profile Button", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        //logout
        logout = (Button) findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                logoutMenu(MainActivity.this);
            }
        });
    }
    private void logoutMenu(MainActivity mainActivity){
        AlertDialog.Builder builder = new AlertDialog.Builder(mainActivity);
        builder.setTitle("Logout");
        builder.setMessage("Are you sure you want to logout?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                System.exit(0);
                //finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }
}
