package com.firnazluztian.myportofolio.fragments;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.PopupMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.firnazluztian.myportofolio.R;

public class SkillsFragment extends Fragment {
    private Button programmingLanguageButton,webTechButton,webServicesButton,toolsButton,databasesButton,cvsButton,osButton;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_skills, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        programmingLanguageButton = (Button) getView().findViewById(R.id.programmingLanguageButton);
        webTechButton = (Button) getView().findViewById(R.id.webTechButton);
        webServicesButton = (Button) getView().findViewById(R.id.webServicesButton);
        toolsButton = (Button) getView().findViewById(R.id.toolsButton);
        databasesButton = (Button) getView().findViewById(R.id.databasesButton);
        cvsButton = (Button) getView().findViewById(R.id.cvsButton);
        osButton = (Button) getView().findViewById(R.id.osButton);

        String[] pLanguageArray = {"Java","Android-SDK","JavaScript","JQuery","PHP","C++"};
        String[] webTechArray = {"HTML5","CSS3","JSON","XML","Bootstrap","Wordpress"};
        String[] webServicesArray = {"REST","SOAP"};
        String[] toolsArray = {"Android Studio 2.0","Eclipse","NetBeans","Adobe Dreamweaver","Adobe Fireworks"};
        String[] databaseArray = {"SQLite","phpMyAdmin"};
        String[] cvsArray = {"GitHub","Git"};
        String[] osArray = {"Windows","Linux","Mac"};

        final GridView gw1 = (GridView)getView().findViewById(R.id.programmingGridView);
        final GridView gw2 = (GridView)getView().findViewById(R.id.webTechBGridView);
        final GridView gw3 = (GridView)getView().findViewById(R.id.webServicesGridView);
        final GridView gw4 = (GridView)getView().findViewById(R.id.toolsGridView);
        final GridView gw5 = (GridView)getView().findViewById(R.id.databasesGridView);
        final GridView gw6 = (GridView)getView().findViewById(R.id.cvsGridView);
        final GridView gw7 = (GridView)getView().findViewById(R.id.osGridView);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,pLanguageArray);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,webTechArray);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,webServicesArray);
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,toolsArray);
        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,databaseArray);
        ArrayAdapter<String> adapter6 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,cvsArray);
        ArrayAdapter<String> adapter7 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,osArray);

        gw1.setAdapter(adapter1);
        gw2.setAdapter(adapter2);
        gw3.setAdapter(adapter3);
        gw4.setAdapter(adapter4);
        gw5.setAdapter(adapter5);
        gw6.setAdapter(adapter6);
        gw7.setAdapter(adapter7);


        programmingLanguageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gw1.setVisibility(View.VISIBLE);
                gw2.setVisibility(View.GONE);
                gw3.setVisibility(View.GONE);
                gw4.setVisibility(View.GONE);
                gw5.setVisibility(View.GONE);
                gw6.setVisibility(View.GONE);
                gw7.setVisibility(View.GONE);
            }
        });

        webTechButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gw1.setVisibility(View.GONE);
                gw2.setVisibility(View.VISIBLE);
                gw3.setVisibility(View.GONE);
                gw4.setVisibility(View.GONE);
                gw5.setVisibility(View.GONE);
                gw6.setVisibility(View.GONE);
                gw7.setVisibility(View.GONE);
            }
        });

        webServicesButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                gw1.setVisibility(View.GONE);
                gw2.setVisibility(View.GONE);
                gw3.setVisibility(View.VISIBLE);
                gw4.setVisibility(View.GONE);
                gw5.setVisibility(View.GONE);
                gw6.setVisibility(View.GONE);
                gw7.setVisibility(View.GONE);
            }
        });

        toolsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gw1.setVisibility(View.GONE);
                gw2.setVisibility(View.GONE);
                gw3.setVisibility(View.GONE);
                gw4.setVisibility(View.VISIBLE);
                gw5.setVisibility(View.GONE);
                gw6.setVisibility(View.GONE);
                gw7.setVisibility(View.GONE);
            }
        });

        databasesButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                gw1.setVisibility(View.GONE);
                gw2.setVisibility(View.GONE);
                gw3.setVisibility(View.GONE);
                gw4.setVisibility(View.GONE);
                gw5.setVisibility(View.VISIBLE);
                gw6.setVisibility(View.GONE);
                gw7.setVisibility(View.GONE);
            }
        });

        cvsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                gw1.setVisibility(View.GONE);
                gw2.setVisibility(View.GONE);
                gw3.setVisibility(View.GONE);
                gw4.setVisibility(View.GONE);
                gw5.setVisibility(View.GONE);
                gw6.setVisibility(View.VISIBLE);
                gw7.setVisibility(View.GONE);
            }
        });

       osButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                gw1.setVisibility(View.GONE);
                gw2.setVisibility(View.GONE);
                gw3.setVisibility(View.GONE);
                gw4.setVisibility(View.GONE);
                gw5.setVisibility(View.GONE);
                gw6.setVisibility(View.GONE);
                gw7.setVisibility(View.VISIBLE);
            }
        });

    }
}
