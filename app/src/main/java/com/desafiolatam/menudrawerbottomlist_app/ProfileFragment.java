package com.desafiolatam.menudrawerbottomlist_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ProfileFragment extends Fragment {

    View fragmentView;
    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragmentView = inflater.inflate(R.layout.fragment_profile, container, false);

        listView = fragmentView.findViewById(R.id.mainList);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity().getApplication().getApplicationContext(),
                R.array.marca_automoviles, android.R.layout.simple_list_item_1);

        listView.setAdapter(adapter);

        return fragmentView;

    }
}