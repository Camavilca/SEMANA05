package com.camavilca.orlando.camavilca;

import android.Manifest;
import android.app.SearchManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static java.net.Proxy.Type.HTTP;

public class Contacto extends AppCompatActivity {
    private TextView    text_name;
    private TextView    text_funcion;
    private TextView    text_telefono;
    private TextView    text_correo;
    private TextView    text_sitio;
    private ImageView imagen;

    private Bundle datos;
    private String nombre;
    private String ocupacion;
    private String celu ;
    private String correo;
    private String web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        text_funcion = findViewById(R.id.text_funcion);
        text_name = findViewById(R.id.text_nombre);
        text_telefono = findViewById(R.id.txt_telefono);
        text_correo = findViewById(R.id.txt_correo);
        text_sitio = findViewById(R.id.txt_sitioweb);
        datos = this.getIntent().getExtras();

        if(datos != null) {
            nombre = datos.getString("nombres");
            ocupacion = datos.getString("ocupación");
            celu = datos.getString("telefono");
            correo = datos.getString("correo");
            web = datos.getString("web");
        }
        text_name.setText(nombre);
        text_funcion.setText(ocupacion);
        text_telefono.setText(celu);
        text_correo.setText(correo);
        text_sitio.setText(web);
        if (nombre.equals("Juan Manuel Paredes")) {
            imagen.setImageResource(R.drawable.img1);
        } else if (nombre.equals("Diego Martinez Rayme")){
            imagen.setImageResource(R.drawable.img2);
        }else if (nombre.equals("Orlando Camavilca Chavez")){
            imagen.setImageResource(R.drawable.img3);
        }
    }
    public void llamar(View view) {
        String cadena = String.valueOf(celu);
        String cel = "tel:" + cadena;
        Log.i("Conversion", cel);

        Intent obj = new Intent(Intent.ACTION_CALL);
        obj.setData(Uri.parse(cel));
        if (ActivityCompat.checkSelfPermission(Contacto.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(obj);
    }

    public void enviarCorreo(View view) {
        String[] TO = {"orlando.camavilca@tecsup.edu.pe"};
        String[] CC = {correo};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:ronald.miya@tecsup.edu.pe"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(Contacto.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
        startActivity(emailIntent);
    }
    public void searchWeb(View view) {
        Intent intent = new Intent(Intent.ACTION_SEARCH);
        intent.putExtra(SearchManager.QUERY, web);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void composeMmsMessage(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("smsto:"));  // This ensures only SMS apps respond
        intent.putExtra("sms_body", "hola");
        intent.putExtra(Intent.EXTRA_STREAM, celu);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
