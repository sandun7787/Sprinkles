package com.example.sprinkles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sprinkles.Models.DBHelper1;

public class SignUp_Activity extends AppCompatActivity {

    EditText username, password, repassword;
    Button register,login ;
    DBHelper1 DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().setTitle("Sign Up");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);

        register = findViewById(R.id.btnregister2);
        login = findViewById(R.id.btnlogin2);
        DB = new DBHelper1(this);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if (user.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(SignUp_Activity.this, "Please enter all the fields",Toast.LENGTH_LONG).show();
                else
                    if(pass.equals(repass)){
                    Boolean checkuser = DB.checkusername(user);
                    if (checkuser==false){
                        Boolean insert = DB.insertData(user,pass);
                        if (insert==true){

                            Toast.makeText(SignUp_Activity.this,"Registerd Successfully",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),SignInActivity.class);
                            startActivity(intent);
                        }else {
                            Toast.makeText(SignUp_Activity.this, "Registered failed", Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(SignUp_Activity.this, "User already exista! Please SignIn!", Toast.LENGTH_SHORT).show();
                    }


                }else {
                    Toast.makeText(SignUp_Activity.this,"password not maching", Toast.LENGTH_SHORT).show();
                }



            }

        });

       login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SignUp_Activity.this, "Login has been clicked", Toast.LENGTH_LONG).show();


                Intent intent = new Intent(SignUp_Activity.this , SignInActivity.class);
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