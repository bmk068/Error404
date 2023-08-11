package edu.utsa.project3443;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.ComponentActivity;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ProfileActivity extends ComponentActivity {
    private Button returnbtn;
    private Account profileInfo;
    //private AssetManager assets;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        profileInfo = null;
        //assets = getAssets();
        setupProfile();
        setupButtons();
    }
    public void setupProfile(){
        Intent intent = getIntent();
        int id = intent.getIntExtra("id",-1);
        //profileInfo = new Account(id, assets);
        File f = new File(getFilesDir().getAbsolutePath() + "/user.txt");
        Scanner scan;
        String str = "";
        String[] arr = null;

        try {
            if(f.exists()) {
                //scan = new Scanner(assets.open("user.txt"));
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
            TextView name = (TextView) findViewById(R.id.nameInput);
            TextView email = (TextView) findViewById(R.id.emailInput);
            name.setText(profileInfo.getName());
            email.setText(profileInfo.getEmail());
        }
    }
    private void setupButtons(){
        //return button to main
        returnbtn = (Button) findViewById(R.id.ret);
        returnbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                //startActivity(intent);
                finish();
            }
        });
    }
}
