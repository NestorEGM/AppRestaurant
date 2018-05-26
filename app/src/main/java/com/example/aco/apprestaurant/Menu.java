package com.example.aco.apprestaurant;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    Button bMap, bPromo, bMenu, bReserva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        bMap=(Button)findViewById(R.id.bMap);
        bPromo=(Button)findViewById(R.id.bPromo);
        bMenu=(Button)findViewById(R.id.bMenu);
        bReserva=(Button)findViewById(R.id.bReserva);

        bMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent (Menu.this, Map.class);
                startActivity(intent);


            }
        });

        bMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent (Menu.this, Carta.class);
                startActivity(intent);


            }
        });

        bPromo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent (Menu.this, Promos.class);
                startActivity(intent);


            }
        });


    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent (Menu.this, MainActivity.class);
        startActivity(intent);
    }

}
