package edu.utsa.project3443;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.ComponentActivity;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class RegisterActivity extends ComponentActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        setupButtons();
    }
    private void setupButtons(){
        Button submit = (Button)findViewById(R.id.submitRegister);
        Button returnbtn = (Button)findViewById(R.id.returnbtn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText unameInput = (EditText) findViewById(R.id.register_unameInput);
                EditText passInput = (EditText) findViewById(R.id.register_passInput);
                EditText repassInput = (EditText) findViewById(R.id.register_repassInput);
                EditText nameInput = (EditText) findViewById(R.id.register_nameInput);
                EditText emailInput = (EditText) findViewById(R.id.register_emailInput);
                EditText weightInput = (EditText) findViewById(R.id.register_weightInput);
                int id = -1;
                if(validateAccountInfo()){
                    //Toast.makeText(getBaseContext(), "all EditText has values.", Toast.LENGTH_SHORT).show();
                    id = createLogin();
                    if(id > 0){
                        createAccount(id);
                    }
                    Intent intent = new Intent(RegisterActivity.this, loginActivity.class); //FIX ME:MainActivity changed
                    startActivity(intent);
                    //finish();
                }
                else{
                    //Toast.makeText(getBaseContext(), "at least one EditText is empty.", Toast.LENGTH_SHORT).show();
                    unameInput.setText("");
                    passInput.setText("");
                    repassInput.setText("");
                    nameInput.setText("");
                    emailInput.setText("");
                    weightInput.setText("");
                    unameInput.setError("All fields must be filled out.");
                    passInput.setError("All fields must be filled out.");
                    repassInput.setError("All fields must be filled out.");
                    nameInput.setError("All fields must be filled out.");
                    emailInput.setError("All fields must be filled out.");
                    weightInput.setError("All fields must be filled out.");
                }
                //Intent intent = new Intent(RegisterActivity.this, loginActivity.class);  //FIX ME: might need to go to a different class
                //startActivity(intent);
            }
        });
        //return to login
        returnbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(RegisterActivity.this, loginActivity.class);  //FIX ME class
                //startActivity(intent);
                finish();
            }
        });
    }
    private boolean validateAccountInfo(){
        EditText unameInput = (EditText) findViewById(R.id.register_unameInput);
        EditText passInput = (EditText) findViewById(R.id.register_passInput);
        EditText repassInput = (EditText) findViewById(R.id.register_repassInput);
        EditText nameInput = (EditText) findViewById(R.id.register_nameInput);
        EditText emailInput = (EditText) findViewById(R.id.register_emailInput);
        EditText weightInput = (EditText) findViewById(R.id.register_weightInput);
        if(!unameInput.getText().toString().equals("") && !passInput.getText().toString().equals("") &&
                !repassInput.getText().toString().equals("") && !nameInput.getText().toString().equals("") &&
                !emailInput.getText().toString().equals("") && !weightInput.getText().toString().equals("")){
            return true;
        }
        return false;
    }
    private int createLogin(){
        EditText unameInput = (EditText) findViewById(R.id.register_unameInput);
        EditText passInput = (EditText) findViewById(R.id.register_passInput);
        EditText repassInput = (EditText) findViewById(R.id.register_repassInput);
        String username = unameInput.getText().toString();
        String password = passInput.getText().toString();
        String repassword = repassInput.getText().toString();

        File f = new File(getFilesDir().getAbsolutePath() + "/register.txt");
        OutputStreamWriter w = null;
        Scanner scan;
        String str = "";
        String[] arr = null;
        int id = -1;

        if(!f.exists()){
            id = 1;
            try {
                w = new OutputStreamWriter(openFileOutput("register.txt", MODE_PRIVATE));
                w.write(id + "," + username + "," + password + "," + repassword);
                w.close();
            }
            catch (IOException e){
                Toast.makeText(getBaseContext(),"IOException: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        else{
            try{
                scan = new Scanner(openFileInput("register.txt"));
                while(scan.hasNextLine()) {
                    str = scan.nextLine();
                }
                if(str != null) {
                    arr = str.split(",");
                    if (arr.length == 4) {
                        id = Integer.parseInt(arr[0] + 1);
                    }
                }
                scan.close();
                w = new OutputStreamWriter(openFileOutput("register.txt", MODE_APPEND));
                w.append("\n" + id + "," + username + "," + password + "," + repassword);
                w.close();
            }
            catch (IOException e){
                Toast.makeText(getBaseContext(),"IOException: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        return id;
    }
    private void createAccount(int id){
        EditText nameInput = (EditText) findViewById(R.id.register_nameInput);
        EditText emailInput = (EditText) findViewById(R.id.register_emailInput);
        EditText weightInput = (EditText) findViewById(R.id.register_weightInput);
        String name = nameInput.getText().toString();
        String email = emailInput.getText().toString();
        String weight = weightInput.getText().toString();

        File f = new File(getFilesDir().getAbsolutePath() + "/user.txt");
        OutputStreamWriter w = null;

        if(!f.exists()){
            id = 1;
            try {
                w = new OutputStreamWriter(openFileOutput("user.txt", MODE_PRIVATE));
                w.write(id + "," + name + "," + email + "," + weight);
                w.close();
            }
            catch (IOException e){
                Toast.makeText(getBaseContext(),"IOException: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        else{
            try {
                w = new OutputStreamWriter(openFileOutput("user.txt", MODE_APPEND));
                w.append("\n" + id + "," + name + "," + email + "," + weight);
                w.close();
            }
            catch (IOException e){
                Toast.makeText(getBaseContext(),"IOException: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
