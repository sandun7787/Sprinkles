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
import com.example.sprinkles.databinding.ActivityFoodBinding;

import java.util.ArrayList;

public class Food2Activity extends AppCompatActivity {



    ActivityFood2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_food2);
        getSupportActionBar().setTitle("Birthday CupCake");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding = ActivityFood2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();

        list.add(new MainModel(R.drawable.bdaybox, "Birthday Box", "109", "3 red velvet, 3 vanilla, 3 dark chocolate, 3 sprinkles, sprinkles ‘Happy Birthday’ glitter candles, and ‘Happy Birthday’ modern dots"));
        list.add(new MainModel(R.drawable.bdaybdaybdaydozen, "BDAY BDAY BDAY Dozen Celebration Box", "109", "4 red velvet, 4 dark chocolate, and 4 vanilla cupcakes"));
        list.add(new MainModel(R.drawable.itsyourbdaydozen, "ITS YOUR BDAY Dozen Box", "109", "3 red velvet, 5 dark chocolate, and 4 vanilla cupcakes"));
        list.add(new MainModel(R.drawable.bdayredvelvet, "Birthday Red Velvet", "99", "southern style light chocolate cake with cream cheese frosting with beeswax candle"));


        MainAdapter adapter = new MainAdapter(list, this);
        binding.recylerview2.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recylerview2.setLayoutManager(layoutManager);
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
                startActivity(new Intent(Food2Activity.this, OrderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}