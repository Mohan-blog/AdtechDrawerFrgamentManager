package com.adteccorp.adtechdrawerfragmentmanager;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MuraliFragment extends Fragment {
Button btn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate( R.layout.fragment_murali, container, false );
        btn  =view.findViewById( R.id.muraliclickme );

        btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( getContext(),MuraliAct.class ) );
            }
        } );
        return view;
    }


    }

