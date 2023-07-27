package com.desafiolatam.menudrawerbottomlist_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.desafiolatam.menudrawerbottomlist_app.databinding.ActivityLibraryBinding;

public class LibraryActivity extends AppCompatActivity {

    private static final String TAG = "Library Activity";
    private ActivityLibraryBinding binding;

    TextView textView;

    Toolbar toolbar;

    EditText editTextNombre;

    Button buttonSaludar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLibraryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //setContentView(R.layout.activity_library);

        textView = binding.textViewSaludo;
        toolbar = binding.toolbar;

        textView.setText("Bienvenidos a mi lista de libros leidos");

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.baseline_keyboard_arrow_left_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editTextNombre = binding.editTextNombre;
        editTextNombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.i(TAG,"Texto ingresado: " + charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        buttonSaludar = binding.buttonSaludar;
        buttonSaludar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = editTextNombre.getText().toString().trim();
                if(nombre.length() > 0){
                    Toast.makeText(getApplicationContext(),"Hola " + nombre.toUpperCase() + "!!!!",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Debes ingresar un nombre para saludarte!!!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == android.R.id.home){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}