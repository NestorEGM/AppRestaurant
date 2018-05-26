package com.example.aco.apprestaurant;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registro extends AppCompatActivity {

    Button bRegistro;
    EditText user,pass,passR;
    String usuario,con1,con2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        bRegistro=(Button)findViewById(R.id.bRegistro);
        user=(EditText)findViewById(R.id.user);
        pass=(EditText)findViewById(R.id.pass);
        passR=(EditText)findViewById(R.id.passR);

        bRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                usuario=user.getText().toString();
                con1=pass.getText().toString();
                con2=passR.getText().toString();

                if(usuario.equals("") || con1.equals("") || con2.equals("")){

                }else {
                    if (con1.equals(con2)) {
                        Intent intent = new Intent(Registro.this, Menu.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }


}
