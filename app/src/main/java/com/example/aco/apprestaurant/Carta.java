package com.example.aco.apprestaurant;

import android.content.Intent;
import android.graphics.PointF;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Carta extends AppCompatActivity {

    ImageView imagenV;
    TextView categoria,desc;
    int [][]fotoId={{R.drawable.baguette,R.drawable.enchiladas,R.drawable.espagueti,R.drawable.hamburguesa,R.drawable.pizza,R.drawable.sushi},
            {R.drawable.cafe,R.drawable.cerveza,R.drawable.clericot,R.drawable.soda,R.drawable.tequila,R.drawable.whiskey},
            {R.drawable.churros,R.drawable.delicia_de_champagne,R.drawable.gelatina_baileys,R.drawable.mousse_de_lima,R.drawable.pan_de_manzana,R.drawable.pastel_opera}};
    String []cabeza={"Comida","Bebidas","Postres"};
    String [][]nombre={{"Baguette $40","Enchiladas $45","Espagueti $65","Hamburguesa $50","Pizza $140","Sushi $85"},
            {"Café $20","Cerveza $30","Clericot $50","Soda $20","Tequila $15","Whiskey $45"},
            {"Churros $20","Delicia $35","Gelatina $35","Mousse $50","Pan de manzana $30","Pastel $25"}};
    int i=0,j=0;
    PointF inicio = new PointF(), cambio=new PointF();
    MediaPlayer audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carta);

        audio=MediaPlayer.create(this,R.raw.menu);
        audio.start();

        imagenV=(ImageView)findViewById(R.id.imagenV);
        categoria=(TextView)findViewById(R.id.categoria);
        desc=(TextView)findViewById(R.id.desc);

        categoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                j++;
                if (j==3){
                    j=0;
                }

                categoria.setText(cabeza[j]);
                desc.setText(nombre[j][i]);
                imagenV.setImageResource(fotoId[j][i]);
                v.setX(0);

            }
        });

        imagenV.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        inicio.x=event.getX();
                        break;


                    case MotionEvent.ACTION_UP:
                        cambio.x=event.getX();
                        if (inicio.x>cambio.x+150){
                            i++;
                            if (i==6) i=0;
                        }
                        if (inicio.x+150<cambio.x){
                            i--;
                            if (i==-1) i=5;
                        }

                        categoria.setText(cabeza[j]);
                        desc.setText(nombre[j][i]);
                        imagenV.setImageResource(fotoId[j][i]);
                        break;
                }
                return true;
            }
        });


    }

}
