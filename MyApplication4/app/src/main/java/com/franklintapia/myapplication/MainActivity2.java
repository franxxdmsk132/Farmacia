package com.franklintapia.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;

public class  MainActivity2 extends AppCompatActivity {

    Button mostrar,tomarFoto;
    EditText codigo,nombreComercial,NombreGenerico,fechaVenc, fechaElab;
    EditText coste,pvp;

    String rutaImagen;

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mostrar = findViewById(R.id.mostrar);
        tomarFoto = findViewById(R.id.tomarfoto);
        codigo = findViewById(R.id.codigo);
        nombreComercial = findViewById(R.id.nombrecom);
        NombreGenerico = findViewById(R.id.nombrege);
        fechaElab = findViewById(R.id.fechaela);
        fechaVenc = findViewById(R.id.fechaven);
        coste = findViewById(R.id.coste);
        pvp = findViewById(R.id.pvp);
        tomarFoto.setOnClickListener(l -> abrirCamara());


        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Codigo = codigo.getText().toString();
                String nombrecom = nombreComercial.getText().toString();
                String nombreGen = NombreGenerico.getText().toString();
                String FechaEla = fechaElab.getText().toString();
                String Fechaven = fechaVenc.getText().toString();
                String Coste = coste.getText().toString();
                String PVP = pvp.getText().toString();

                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                intent.putExtra("Texto_Ingresado",Codigo);
                intent.putExtra("Texto_Ingresado1",nombrecom);
                intent.putExtra("Texto_Ingresado2",nombreGen);
                intent.putExtra("Texto_Ingresado3",FechaEla);
                intent.putExtra("Texto_Ingresado4",Fechaven);
                intent.putExtra("Texto_Ingresado5",Coste);
                intent.putExtra("Texto_Ingresado6",PVP);
                startActivity(intent);
                //finish();
            }
        });

    }
    private static final int REQUEST_IMAGE_CAPTURE = 2;

    private void abrirCamara() {
        Intent intentCamara = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //if(intentCamara.resolveActivity(getPackageManager())!=null){
        startActivityForResult(intentCamara, REQUEST_IMAGE_CAPTURE);

        File imagenArchivo = null;
        if (imagenArchivo != null) {
            Uri fotoUri = FileProvider.getUriForFile(this, "com.cdp.camara.filprovider", imagenArchivo);
            intentCamara.putExtra(MediaStore.EXTRA_OUTPUT, fotoUri);

        }

        // }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle info = data.getExtras();
            Bitmap imagen = (Bitmap) info.get("data");
            //Bitmap imagen = BitmapFactory.decodeFile(rutaImagen);

            ImageView imageView = findViewById(R.id.imagen);
            imageView.setImageBitmap(imagen);

        }
    }
    private File crearImagen() throws IOException {
        String imgname = "foto";
        File directorio = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File imagen = File.createTempFile(imgname, ".jpg", directorio);
        rutaImagen = imagen.getAbsolutePath();
        return imagen;
    }
}