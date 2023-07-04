package com.example.sprinkles;


import android.app.Dialog;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity2 extends AppCompatActivity {

    Button login , register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        //Transparent ActionBar

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        getSupportActionBar().hide();

        login = findViewById(R.id.btnlogin);
        register = findViewById(R.id.btnregister);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity2.this, "SignIn has been clicked", Toast.LENGTH_LONG).show();


                Intent intent = new Intent(MainActivity2.this , SignInActivity.class);
                startActivity(intent);
            }

        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity2.this, "SignUp has been clicked", Toast.LENGTH_LONG).show();


                Intent intent = new Intent(MainActivity2.this , SignUp_Activity.class);
                startActivity(intent);


                @SuppressWarnings("StatementWithEmptyBody")
                @Override
                public boolean onNavigationItemSelected(MenuItem item) {
                    // Handle navigation view item clicks here.
                    int id = item.getItemId();

                    if (id == R.id.nav_birthdaycupcake) {
                        birthdaycupcakeFragment fragment = new birthdaycupcakeFragment();
                        android.support.v4.app.FragmentTransaction fragmentTransaction =
                                getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.Fragment_container, fragment);
                        fragmentTransaction.commit();


                    }else if (id == R.id.nav_valantinecupcake) {


                        valantinecupcakeFragment fragment = new valantinecupcakeFragment();
                        android.support.v4.app.FragmentTransaction fragmentTransaction =
                                getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.Fragment_container, fragment);
                        fragmentTransaction.commit();

                    }
                    else if (id == R.id.nav_classiccupcake) {

                        classiccupcakeFragment fragment = new classiccupcakeFragment();
                        android.support.v4.app.FragmentTransaction fragmentTransaction =
                                getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.Fragment_container, fragment);
                        fragmentTransaction.commit();

                    } else if (id == R.id.nav_continental) {

                        ContinentalFragment fragment = new ContinentalFragment();
                        android.support.v4.app.FragmentTransaction fragmentTransaction =
                                getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.Fragment_container, fragment);
                        fragmentTransaction.commit();

                    } else if (id == R.id.nav_traditional) {


                        TraditionalFragment fragment = new TraditionalFragment();
                        android.support.v4.app.FragmentTransaction fragmentTransaction =
                                getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.Fragment_container, fragment);
                        fragmentTransaction.commit();

                    }else if (id == R.id.nav_chinese) {


                        ChineseFragment fragment = new ChineseFragment();
                        android.support.v4.app.FragmentTransaction fragmentTransaction =
                                getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.Fragment_container, fragment);
                        fragmentTransaction.commit();
                    }
                    else if(id == R.id.order_details_drawer ){

                        Cursor check ;
                        check = mydb.Get_OrderDetails() ;

                        if(check!=null && check.getCount()>0)
                        {      Intent intent = new Intent(getApplicationContext(), OrderPage.class);
                            startActivity(intent);
                        }
                        else  {Toast.makeText(getApplicationContext(),"No details found because you didn't order something...",Toast.LENGTH_SHORT).show();}
                    }
                    else if(id == R.id.submit_order ){

                        Cursor check ;
                        check = mydb.Get_OrderDetails() ;

                        if(check!=null && check.getCount()>0)
                        {   Submit_Order fragment = new Submit_Order();
                            android.support.v4.app.FragmentTransaction fragmentTransaction =
                                    getSupportFragmentManager().beginTransaction();
                            fragmentTransaction.replace(R.id.Fragment_container, fragment);
                            fragmentTransaction.commit();

                        }
                        else  {Toast.makeText(getApplicationContext(),"Sorry, You don't order anything...",Toast.LENGTH_SHORT).show();}
                    }

                    else if(id == R.id.log_out ){

                        openDialog();

                    }

                    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                    drawer.closeDrawer(GravityCompat.START);
                    return true;

                }

                public void openDialog() {

                    final Dialog builder = new Dialog(this); // Context, this, etc.
                    builder.setContentView(R.layout.dialogdesign);
                    builder.setTitle(R.string.dialog_popup);
                    builder.show();
                    logout = (Button) builder.findViewById(R.id.dialog_ok);
                    cancel = (Button) builder.findViewById(R.id.dialog_cancel);
                    logout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            mydb.delete_all();
                            Toast.makeText(getApplicationContext(),"Hope you like our service, Have a good day !!!",Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(getApplicationContext(),LoginOptionsPage.class);
                            startActivity(intent);
                        }
                    });

                    cancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(getApplicationContext(),"So you don't want to, Logout !!!",Toast.LENGTH_SHORT).show();
                            builder.dismiss();
                        }
                    });

                }
            }





        }

        });
    }
}