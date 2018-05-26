package com.example.aco.apprestaurant;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button bEntrar,bRegistrar;
    EditText user,pass;
    String us,con;
    MediaPlayer saludo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        saludo=MediaPlayer.create(this,R.raw.hola);
        saludo.start();

        bEntrar=(Button)findViewById(R.id.bEntrar);
        bRegistrar=(Button)findViewById(R.id.bRegistrar);

        user=(EditText)findViewById(R.id.editText);
        pass=(EditText)findViewById(R.id.editText2);

        bEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                us=user.getText().toString();
                con=pass.getText().toString();

                if(us.equals("") || con.equals("")) {

                }else{
                    Intent intent = new Intent(MainActivity.this, Menu.class);
                    startActivity(intent);
                }
            }
        });

        bRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent (MainActivity.this, Registro.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onBackPressed() {
        finish();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
