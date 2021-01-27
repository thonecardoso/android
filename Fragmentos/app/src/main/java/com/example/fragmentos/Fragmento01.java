package com.example.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class Fragmento01 extends Fragment {


    public Fragmento01() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragmento01, container,false);
        Button b = (Button) view.findViewById(R.id.btnFrag01);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(),
                        "Estou no Fragmento!!!",
                        Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}
