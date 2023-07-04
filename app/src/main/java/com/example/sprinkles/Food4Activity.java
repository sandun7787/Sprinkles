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
import com.example.sprinkles.databinding.ActivityFood4Binding;
import com.example.sprinkles.databinding.ActivityFoodBinding;

import java.util.ArrayList;

public class Food4Activity extends AppCompatActivity {



    ActivityFood4Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_food4);
        getSupportActionBar().setTitle("Gifts Occasions");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding = ActivityFood4Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();

        list.add(new MainModel(R.drawable.babybaybabydozenbox, "BABY BABY BABY Dozen Box", "109", ""));
        list.add(new MainModel(R.drawable.itsagirldozenbox, "ITS A GIRL Dozen Box", "109", ""));
        list.add(new MainModel(R.drawable.itsaboydozenbox, "ITS A BOY Dozen Box", "109", ""));
        list.add(new MainModel(R.drawable.iloveyoudozenbox, "I LOVE YOU Dozen Box", "109", ""));
        list.add(new MainModel(R.drawable.imissyoudozenbox, "I MISS YOU Dozen Box", "109", ""));
        list.add(new MainModel(R.drawable.sprinkledozencelebrationbox, "Sprinkle Dozen Celebration Box", "109", ""));
        list.add(new MainModel(R.drawable.graddozenyellowbox, "Grad Dozen Yellow Box", "109", ""));

        MainAdapter adapter = new MainAdapter(list, this);
        binding.recylerview4.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recylerview4.setLayoutManager(layoutManager);
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
                startActivity(new Intent(Food4Activity.this, OrderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}