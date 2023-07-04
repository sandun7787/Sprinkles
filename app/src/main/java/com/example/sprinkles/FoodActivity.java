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
import com.example.sprinkles.databinding.ActivityFoodBinding;

import java.util.ArrayList;

public class FoodActivity extends AppCompatActivity {



    ActivityFoodBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_food);
        getSupportActionBar().setTitle("CupCake");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding = ActivityFoodBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();

        list.add(new MainModel(R.drawable.redvelvet, "Red Velvet", "109", "southern style light chocolate cake with cream cheese frosting"));
        list.add(new MainModel(R.drawable.darkchocolate, "Dark Chocolate", "109", "Belgian dark chocolate cake with bittersweet chocolate frosting and then rolled in dark chocolate sprinkles"));
        list.add(new MainModel(R.drawable.sprinkle, "Sprinkle", "109", "birthday cake topped with vanilla buttercream and colorful non pareil sprinkles"));
        list.add(new MainModel(R.drawable.strawberry, "Strawberry", "99", "pure strawberry cake with sweet strawberry frosting"));
        list.add(new MainModel(R.drawable.blackwhite, "Black & White", "99", "Belgian dark chocolate cake with creamy vanilla frosting"));


        MainAdapter adapter = new MainAdapter(list, this);
        binding.recylerview.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recylerview.setLayoutManager(layoutManager);
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
                startActivity(new Intent(FoodActivity.this, OrderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}