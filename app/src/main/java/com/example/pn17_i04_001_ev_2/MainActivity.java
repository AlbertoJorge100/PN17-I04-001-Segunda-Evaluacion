package com.example.pn17_i04_001_ev_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ActionBar myToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        TextView lblCalculadora=findViewById(R.id.lblCalculadora);
        lblCalculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intn=new Intent(MainActivity.this,CalculadoraActivity.class);
                startActivity(intn);
            }
        });
    }
}