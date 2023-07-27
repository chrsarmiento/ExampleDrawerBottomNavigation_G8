package com.desafiolatam.menudrawerbottomlist_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ProfileFragment extends Fragment {

    final String TAG = "Profile Fragment";
    View fragmentView;
    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragmentView = inflater.inflate(R.layout.fragment_profile, container, false);

        listView = fragmentView.findViewById(R.id.mainList);

        /*ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity().getApplication().getApplicationContext(),
                R.array.marca_automoviles, android.R.layout.simple_list_item_1);*/

        CustomAdapter adapter = setUpAdapter();
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(adapterView.getContext(),"Elemento seleccionado: " +
                        adapter.getItem(i).toString(),Toast.LENGTH_SHORT).show();
            }
        });

        return fragmentView;

    }

    private CustomAdapter setUpAdapter(){
        CustomAdapter adapter = new CustomAdapter();
        adapter.setValues(cargarLista());
        return adapter;
    }

    private class CustomAdapter extends BaseAdapter{

        private final List<String> values = new ArrayList<>();

        @Override
        public int getCount() {
            return values.size();
        }

        @Override
        public Object getItem(int i) {
            return values.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if(view == null){
                view = getLayoutInflater().inflate(R.layout.item, viewGroup,false);
            }
            String textToShow = getItem(i).toString();
            ((TextView) view.findViewById(R.id.titleText)).setText(textToShow);
            return view;
        }

        public void setValues(List<String> newValues){
            values.clear();
            values.addAll(newValues);
        }

    }

    private ArrayList<String> cargarLista(){
        ArrayList<String> valores = new ArrayList<>();
        valores.add("Ferrari");
        valores.add("Lada");
        valores.add("Fiat");
        valores.add("Mazda");
        valores.add("Lamborghini");
        valores.add("BMW");
        valores.add("Ford");
        valores.add("Chevrolet");
        valores.add("Suzuki");
        valores.add("Volvo");
        valores.add("Mercedes Benz");
        valores.add("Toyota");
        valores.add("Hyundai");
        valores.add("Kia");
        valores.add("Honda");
        valores.add("Opel");
        valores.add("MG");
        valores.add("Aston Martin");
        valores.add("Alpine");

        return valores;

    }


}