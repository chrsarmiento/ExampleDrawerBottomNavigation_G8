package com.desafiolatam.menudrawerbottomlist_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.desafiolatam.menudrawerbottomlist_app.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    TextView textViewHomeTitle;
    EditText editTextNombre;
    Button buttonValidarNombre;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        //return inflater.inflate(R.layout.fragment_home, container, false);

        textViewHomeTitle = binding.textViewHomeTitle;
        editTextNombre = binding.editTextNombreHome;
        //buttonValidarNombre = view.findViewById(R.id.buttonValidarNombre);
        buttonValidarNombre = binding.buttonValidarNombre;

        textViewHomeTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewHomeTitle.setText("Bienvenido a mi APP!!!!");
            }
        });

        editTextNombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String textoIngresado = editTextNombre.getText().toString().trim();
                if(textoIngresado.length() >= 10){
                    buttonValidarNombre.setEnabled(true);
                }else {
                    buttonValidarNombre.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        buttonValidarNombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Hola " + editTextNombre.getText().toString().trim(),Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }
}