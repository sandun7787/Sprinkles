package com.example.sprinkles;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.example.sprinkles.Adapters.MainAdapter;
import com.example.sprinkles.Models.MainModel;
import com.example.sprinkles.databinding.ActivityFood2Binding;
import com.example.sprinkles.databinding.ActivityFood5Binding;
import com.example.sprinkles.databinding.ActivityFoodBinding;

import java.util.ArrayList;

public class Food5Activity extends AppCompatActivity {



    ActivityFood5Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_food5);
        getSupportActionBar().setTitle("Limited Time Offering");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding = ActivityFood5Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();

        list.add(new MainModel(R.drawable.germanchocolate, "German Chocolate", "89", "light chocolate cake topped with fresh coconut and crunchy pecans laced with caramel"));
        list.add(new MainModel(R.drawable.pumpkin, "Pumpkin", "89", "pumpkin cake laced with fragrant ginger, clove, nutmeg and cinnamon, topped with sweet cinnamon cream cheese frosting"));


        MainAdapter adapter = new MainAdapter(list, this);
        binding.recylerview5.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recylerview5.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return super.onSupportNavigateUp();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.orders:
                startActivity(new Intent(Food5Activity.this, OrderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}