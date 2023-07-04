package com.example.sprinkles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sprinkles.Models.DBHelper1;

public class SignInActivity extends AppCompatActivity {

    EditText username, password;
    Button login, register;
    DBHelper1 DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getSupportActionBar().setTitle("Sign In");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        username = (EditText) findViewById(R.id.username1);
        password = (EditText) findViewById(R.id.password1);

        login = findViewById(R.id.btnlogin1);
        register = findViewById(R.id.btnregister1);
        DB = new DBHelper1(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(SignInActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = DB.checkusernamepassword(user,pass);
                    if(checkuserpass==true){
                        Toast.makeText(SignInActivity.this, "Sign In successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), CategoryActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(SignInActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }

                }
            }

        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SignInActivity.this, "Register has been clicked", Toast.LENGTH_LONG).show();


                Intent intent = new Intent(SignInActivity.this , SignUp_Activity.class);
                startActivity(intent);
            }

        });

    }

    @Override
    public boolean onSupportNavigateUp(){
            onBackPressed();
            return super.onSupportNavigateUp();
            }
}