package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.examen";

    //edi = findViewById(R.id.editText);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
     //   edihh = findViewById(R.id.editText);
    }

public void ConvetirPeso(View view){
   // edi = findViewById(R.id.editText);
    String textMessage = findViewById(R.id.editText).toString();
    Intent sendIntent = new Intent();
    sendIntent.setAction(Intent.ACTION_SEND);
    sendIntent.putExtra(Intent.EXTRA_TEXT, textMessage);
    sendIntent.setType("text/plain");

// Verify that the intent will resolve to an activity
    if (sendIntent.resolveActivity(getPackageManager()) != null) {
        startActivity(sendIntent);
    }
}



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.imc:
                Intent sendIntent = new Intent(this, MainActivity.class);
                if (sendIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(sendIntent);
                }
                boolean b = true;
                return b;
            case R.id.j_imc:
                Intent sendIntents = new Intent(this, MainActivity.class);
                if (sendIntents.resolveActivity(getPackageManager()) != null) {
                    startActivity(sendIntents);
                }
                boolean c = true;
                return c;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
