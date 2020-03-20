package com.example.examen;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static android.util.Log.*;

public class MainActivity extends AppCompatActivity {


    EditText etmasa;
    EditText etestatura;
    TextView tvResultado;
    Button btncalcular;
    ImageView Img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResultado = findViewById(R.id.textView);


        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(Main2Activity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        //TextView textView = findViewById(R.id.textView);
        tvResultado.setText(message);

        Log.e("TAG", "Paso por nCreate");

        etmasa = findViewById(R.id.etmasa);
        etestatura = findViewById(R.id.etestatura);
        Img = findViewById(R.id.IVBandera);
        btncalcular = findViewById(R.id.btncalcula);

        btncalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double MASA = Double.parseDouble(etmasa.getText().toString());
                double ESTATURA = Double.parseDouble(etestatura.getText().toString());
                double Resultado;
                Resultado = MASA / (ESTATURA * ESTATURA);
                tvResultado.setText("Resultado: " + Resultado);


                if (Resultado < 18.5) {
                    Img.setImageResource(R.drawable.delgadez);
                }
                if ((Resultado > 18.5) && (Resultado < 24.9)) {
                    Img.setImageResource(R.drawable.normal);
                }
                if ((Resultado > 25) && (Resultado < 29.99)) {
                    Img.setImageResource(R.drawable.obesidad);
                }
                if (Resultado > 30) {
                    Img.setImageResource(R.drawable.sobrepeso);
                }
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("TAG", "Paso por onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("TAG", "Paso por onStop");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.e("TAG", "Paso por onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("TAG","Paso por onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("TAG","Paso por onPause");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.e("TAG","Paso por onPause");
    }


}