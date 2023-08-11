package edu.utsa.project3443;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.ComponentActivity;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class loginActivity extends ComponentActivity {
    //private AssetManager assets;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        //assets = getAssets();

        setupButtons();
    }
    private void setupButtons(){
        Button register = (Button) findViewById(R.id.registerbtn);
        Button signup = (Button) findViewById(R.id.signupbtn);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText uText = (EditText) findViewById(R.id.username);
                EditText pText = (EditText) findViewById(R.id.password);
                EditText rpText = (EditText) findViewById(R.id.repassword);
                int id = authenticate(uText.getText().toString(), pText.getText().toString(), rpText.getText().toString());
                if(id > 0) {
                    Intent intent = new Intent(loginActivity.this, MainActivity.class);
                    intent.putExtra("id",id);
                    startActivity(intent);
                }
                else{
                    uText.setText("");
                    pText.setText("");
                    rpText.setText("");
                    uText.setError("Incorrect username, email and/or password combination");
                    pText.setError("Incorrect username, email and/or password combination");
                    rpText.setError("Incorrect username, email and/or password combination");
                }
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
    private int authenticate(String username, String password, String re_password){
        Scanner scan;
        String str = "";
        String[] arr = null;
        boolean authenticated = false;
        int id = -1;
        File f = new File(getFilesDir().getAbsolutePath() + "/register.txt");
        try {
            if(f.exists()) {
                //scan = new Scanner(assets.open("register.txt"));
                scan = new Scanner(openFileInput("register.txt"));
                while (scan.hasNext()) {
                    str = scan.nextLine();
                    arr = str.split(",");
                    if (username.equalsIgnoreCase(arr[1]) && password.equals(arr[2]) && re_password.equals(arr[3])) {
                        authenticated = true;
                        id = Integer.parseInt(arr[0]);
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
        return id;
    }
}
