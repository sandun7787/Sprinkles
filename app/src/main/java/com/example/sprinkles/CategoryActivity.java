package com.example.sprinkles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class CategoryActivity extends AppCompatActivity {

    ImageButton food1, food2, food3, food4, food5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportActionBar().setTitle("Category");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        food1 = findViewById(R.id.imagebtn1);
        food2 = findViewById(R.id.imagebtn2);
        food3 = findViewById(R.id.imagebtn3);
        food4 = findViewById(R.id.imagebtn4);
        food5 = findViewById(R.id.imagebtn5);

        food1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(CategoryActivity.this , FoodActivity.class);
                startActivity(intent);
            }

        });


        food2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(CategoryActivity.this , Food2Activity.class);
                startActivity(intent);
            }

        });

        food3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(CategoryActivity.this , Food3Activity.class);
                startActivity(intent);
            }

        });

        food4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(CategoryActivity.this , Food4Activity.class);
                startActivity(intent);
            }

        });

        food5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(CategoryActivity.this , Food5Activity.class);
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