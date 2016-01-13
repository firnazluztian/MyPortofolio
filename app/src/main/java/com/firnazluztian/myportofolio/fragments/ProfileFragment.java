package com.firnazluztian.myportofolio.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firnazluztian.myportofolio.R;
import com.firnazluztian.myportofolio.fragments.profileTabFragment.TabFragment;

public class ProfileFragment extends Fragment{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_profile, container, false);

        }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // default display profile fragment
        FragmentManager fm;
        FragmentTransaction ft;
        TabFragment tabFragment = new TabFragment();
        fm = getFragmentManager();
        ft = fm.beginTransaction();
        ft.add(R.id.tabLayout,tabFragment).commit();
    }


}
