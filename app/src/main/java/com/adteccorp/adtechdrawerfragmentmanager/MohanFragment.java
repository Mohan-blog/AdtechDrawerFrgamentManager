package com.adteccorp.adtechdrawerfragmentmanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MohanFragment extends Fragment {
    Button btn;
    private RecyclerView hrecyclerView;
    private RecyclerView vrecylerview;

    private HorizontalRecyclerAdapter horizontalRecyclerAdapter;
    private VerticalRecyclerAdapter verticalRecyclerAdapter;
    private RecyclerView.LayoutManager hlayoutManager, vlayoutManager;
    ArrayList<String> title, subtitle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate( R.layout.fragment_mohan, container, false );
        hrecyclerView = view.findViewById( R.id.mohanhorizontalrecycler );
        vrecylerview = view.findViewById( R.id.mohanverticalrecycler );

        title = new ArrayList<>();
        subtitle = new ArrayList<>();
        title.add( "Mohan" );
        title.add( "Mohan" );
        title.add( "Mohan" );
        title.add( "Mohan" );
        title.add( "Mohan" );
        title.add( "Mohan" );
        title.add( "Mohan" );

        hrecyclerView.setHasFixedSize( true );
        vrecylerview.setHasFixedSize( true );


        hlayoutManager = new LinearLayoutManager( getContext(), LinearLayoutManager.HORIZONTAL, false );
        vlayoutManager = new LinearLayoutManager( getContext(), LinearLayoutManager.VERTICAL, false );


        hrecyclerView.setLayoutManager( hlayoutManager );
        vrecylerview.setLayoutManager( vlayoutManager );
        horizontalRecyclerAdapter = new HorizontalRecyclerAdapter( title );
        verticalRecyclerAdapter = new VerticalRecyclerAdapter( title );
        hrecyclerView.setAdapter( horizontalRecyclerAdapter );
        vrecylerview.setAdapter( verticalRecyclerAdapter );


        btn = view.findViewById( R.id.mohanclickme );
        btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( getContext(), MohanAct.class ) );
            }
        } );

        return view;
    }


}

