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
import com.example.sprinkles.databinding.ActivityFood3Binding;
import com.example.sprinkles.databinding.ActivityFoodBinding;

import java.util.ArrayList;

public class Food3Activity extends AppCompatActivity {



    ActivityFood3Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_food3);
        getSupportActionBar().setTitle("Cakes");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding = ActivityFood3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();

        list.add(new MainModel(R.drawable.redvelvetlayercake, "Red Velvet Layer Cake", "109", ""));
        list.add(new MainModel(R.drawable.darkchocolatelayercake, "Dark Chocolate Layer Cake", "109", ""));
        list.add(new MainModel(R.drawable.sprinklelayercake, "Sprinkle Layer Cake", "109", ""));
        list.add(new MainModel(R.drawable.strawberrylayercake, "Strawberry Layer Cake", "109", ""));
        list.add(new MainModel(R.drawable.blackwhitwlayercake, "Black & White Layer Cake", "109", ""));


        MainAdapter adapter = new MainAdapter(list, this);
        binding.recylerview3.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recylerview3.setLayoutManager(layoutManager);
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
                startActivity(new Intent(Food3Activity.this, OrderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}