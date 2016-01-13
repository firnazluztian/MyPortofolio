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

public class ContactMeFragment extends Fragment {
    private WebView socialWebView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_contact_me, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        socialWebView = (WebView)getView().findViewById(R.id.socialWebView);
        socialWebView.getSettings().setJavaScriptEnabled(true);
        socialWebView.loadUrl("file:///android_asset/web/socialmedia.html");



    }
}
