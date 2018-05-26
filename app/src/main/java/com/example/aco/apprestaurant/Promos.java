package com.example.aco.apprestaurant;

import android.graphics.PointF;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class Promos extends AppCompatActivity {

    ImageView imgV;
    int []fotoId={R.drawable.promo_1,R.drawable.promo_2,R.drawable.promo_3,R.drawable.promo_4};
    int i=0;
    MediaPlayer audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promos);

        audio=MediaPlayer.create(this,R.raw.promo);
        audio.start();

        imgV =(ImageView)findViewById(R.id.imgV);

        imgV.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                PointF inicio = new PointF();
                PointF cambio=new PointF();
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        inicio.x = event.getX();
                        break;


                    case MotionEvent.ACTION_UP:
                        cambio.x=event.getX();
                        if (inicio.x>cambio.x+150){
                            i++;
                            if (i==4) i=0;
                        }
                        if (inicio.x+150<cambio.x){
                            i--;
                            if (i==-1) i=3;
                        }

                        imgV.setImageResource(fotoId[i]);
                        v.setX(0);
                        break;

                }
                return true;
            }
        });




    }

}
