package com.camavilca.orlando.camavilca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  implements  View.OnClickListener{

    private CardView cardView,cardView2,cardView3;
    private TextView  t1,t2,t3,t4,t5,t6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cardView = findViewById(R.id.card1);
        cardView2 = findViewById(R.id.card2);
        cardView3 = findViewById(R.id.card3);

        t1 = findViewById(R.id.nombre1);
        t2 = findViewById(R.id.nombre2);
        t3 = findViewById(R.id.nombre3);
        t4 = findViewById(R.id.funcion1);
        t5 = findViewById(R.id.funcion2);
        t6 = findViewById(R.id.funcion3);

        cardView.setOnClickListener( this);
        cardView2.setOnClickListener( this);
        cardView3.setOnClickListener( this);
    }


    @Override
    public void onClick(View v) {
        Intent i ;

        switch (v.getId()) {
            case R.id.card1:
                i = new Intent(this, Contacto.class);
                i.putExtra("nombres", t1.getText().toString());
                i.putExtra("ocupación", t4.getText().toString());
                i.putExtra(  "telefono", "(323)-555-1234");
                i.putExtra(  "correo", "juan.manuel@gmail.com");
                i.putExtra(  "web", "www.juansac.pe");
                startActivity(i);
                break;
            case R.id.card2:
                i = new Intent(this, Contacto.class);
                i.putExtra("nombres", t2.getText().toString());
                i.putExtra("ocupación", t5.getText().toString());
                i.putExtra(  "telefono", "946866415");
                i.putExtra(  "correo", "diego.martinez.r.com");
                i.putExtra(  "web", "www.youtube");
                startActivity(i);
                break;
            case R.id.card3:
                i = new Intent(this, Contacto.class);
                i.putExtra("nombres", t3.getText().toString());
                i.putExtra("ocupación", t6.getText().toString());
                i.putExtra(  "telefono", "952485241");
                i.putExtra(  "correo", "orlando.camavilca@tecsp.edu.pe");
                i.putExtra(  "web", "www.faceboock");
                startActivity(i);
                break;
            default:
                break;



        }


    }
}
