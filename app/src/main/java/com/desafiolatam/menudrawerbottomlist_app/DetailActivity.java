package com.desafiolatam.menudrawerbottomlist_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.desafiolatam.menudrawerbottomlist_app.databinding.ActivityDetailBinding;

import java.text.DecimalFormat;

public class DetailActivity extends AppCompatActivity {

    private ActivityDetailBinding binding;

    Bundle bundle;

    Toolbar toolbar;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.baseline_keyboard_arrow_left_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bundle = this.getIntent().getExtras();

        textView = binding.textViewMarcaSeleccionada;

        if(bundle != null){
            String texto = "Marca Seleccionada: " + bundle.getString("marca") + "\n" +
                    "Precio " + new DecimalFormat("$ #,##0").format(bundle.getDouble("precio"));
            textView.setText(texto);
        }

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}