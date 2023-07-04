package com.example.sprinkles.Models;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sprinkles.Adapters.OrderAdapter;
import com.example.sprinkles.DBHelper;

import java.util.ArrayList;

public class OrdePage {
    import android.content.Intent;
import android.database.Cursor;
import android.hardware.camera2.TotalCaptureResult;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

    public class OrderPage extends AppCompatActivity {

        DBHelper mydb;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_order_page);

            ListView listView = (ListView) findViewById(R.id.order_page);
            mydb = new DatabaseHelper(this);


            ArrayList<OrderPage> list = new ArrayList<OrderPage>(); //use to store data from cursor
            Cursor data = mydb.Get_OrderDetails();  //contain all data

            if (data.getCount() == 0) {


            } else {
                while (data.moveToNext()) {

                    list.add(new OrderClass(data.getString(0),data.getString(1),data.getString(2),data.getString(3)));

                }
            }

           OrderAdapter adapter = new OrderAdapter(getApplicationContext(),list);
            listView.setAdapter((ListAdapter) adapter);
        }
    }





























    /*public void Order_data(){
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res =   mydb.Get_OrderDetails();
                if(res.getCount() == 0) {
                    showmessage("Error", "nothing found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()){

                    buffer.append("Id : " + res.getString(0) + "\n");
                    buffer.append("Item Name : " + res.getString(1) + "\n");
                    buffer.append("Quantity : " + res.getString(2)+ "\n");
                    buffer.append("Price : " + res.getString(3)+ "\n");

                }
                showmessage("Data",buffer.toString());


            }
        });
    }
    public void DeleteAll() {
        delete.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mydb.delete_all();
        }
    });


    }


        public void showmessage(String title,String message){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }
*/


}
