package com.firnazluztian.myportofolio.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.firnazluztian.myportofolio.R;

public class WorksFragment extends Fragment {
    private WebView projectWebView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_works, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        projectWebView = (WebView)getView().findViewById(R.id.projectWebView);
        projectWebView.getSettings().setJavaScriptEnabled(true);
        projectWebView.loadUrl("file:///android_asset/web/projectlist.html");
    }
}
