package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    ActionMode actionMode = null;


    private ActionMode.Callback actionModeCallback = new ActionMode.Callback() {

        // Called when the action mode is created; startActionMode() was called
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            // Inflate a menu resource providing context menu items
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.menu_main2, menu);
            return true;
        }

        // Called each time the action mode is shown. Always called after onCreateActionMode, but
        // may be called multiple times if the mode is invalidated.
        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false; // Return false if nothing is done
        }

        // Called when the user selects a contextual menu item
        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case R.id.imc:
                    Intent sendIntent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(sendIntent);
                    mode.finish(); // Action picked, so close the CAB
                    return true;
                case R.id.j_imc:
                    Intent sendIntents = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(sendIntents);
                    mode.finish(); // Action picked, so close the CAB
                    return true;
                default:
                    return false;
            }
        }

        // Called when the user exits the action mode
        @Override
        public void onDestroyActionMode(ActionMode mode) {
            actionMode = null;
        }
    };



    public static final String EXTRA_MESSAGE = "com.example.examen";

    //edi = findViewById(R.id.editText);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
     //   edihh = findViewById(R.id.editText);
        TextView tvLong = findViewById(R.id.tvLong);
        registerForContextMenu(tvLong);

        tvLong.setOnLongClickListener(new View.OnLongClickListener() {
            // Called when the user long-clicks on someView
            public boolean onLongClick(View view) {
                if (actionMode != null) {
                    return false;
                }

                // Start the CAB using the ActionMode.Callback defined above
                actionMode = startActionMode(actionModeCallback);
                view.setSelected(true);
                return true;
            }
        });
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

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main2, menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
       // AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.imc:
                Intent sendIntent = new Intent(this, MainActivity.class);
                startActivity(sendIntent);
                return true;
            case R.id.j_imc:
                Intent sendIntents = new Intent(this, MainActivity.class);
                startActivity(sendIntents);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }


    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);

        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.menu_main2);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.imc:
                Intent sendIntent = new Intent(this, MainActivity.class);
                startActivity(sendIntent);
                return true;
            case R.id.j_imc:
                Intent sendIntents = new Intent(this, MainActivity.class);
                startActivity(sendIntents);;
                return true;
            default:
                return false;
        }
    }
}
