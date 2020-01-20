package com.adteccorp.adtechdrawerfragmentmanager;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class KishoreFragment extends Fragment {
Button btn;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate( R.layout.fragment_kishore, container, false );
        btn =view.findViewById( R.id.kishoreclickme );

        btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( getContext(),KishoreAct.class ) );
            }
        } );

        return view;
    }

}
