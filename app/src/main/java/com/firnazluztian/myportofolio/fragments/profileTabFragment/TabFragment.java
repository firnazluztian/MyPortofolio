package com.firnazluztian.myportofolio.fragments.profileTabFragment;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.firnazluztian.myportofolio.R;

import org.w3c.dom.Text;

public class TabFragment extends Fragment {
    private WebView webViewTab;
    private TextView detailsSummaryTextView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.profile_fragment_tab, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        webViewTab = (WebView)getView().findViewById(R.id.webViewTab);
        webViewTab.getSettings().setJavaScriptEnabled(true);
        webViewTab.loadUrl("file:///android_asset/web/index.html");



    }
}
