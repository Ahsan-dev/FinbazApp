package com.example.myfirst;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.Arrays;


public class SavBankLocateFragment extends Fragment {

    private View view;
    private WebView webView;
    private String url;
    private String bankName;



    public SavBankLocateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_sav_bank_locate, container, false);

        bankName = getArguments().getString("bankName");

        webView = view.findViewById(R.id.bank_location_web_view_id);

        if(bankName=="indusind"){

            url = "https://www.indusind.com/in/en/personal/locate-us.html#";

        }
        if(bankName=="kotak"){

            url = " https://www.kotak.com/en/reach-us.html";

        }
        if(bankName=="digibank"){

            url = "https://www.dbs.com/in/index/locator.page";

        }
        if(bankName=="rbl"){

            url = "https://www.rblbank.com/locate-branch";

        }
        if(bankName=="idfc"){

            url = "http://locator.idfcbank.com/";

        }


        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webView.setScrollbarFadingEnabled(true);
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient());


        return view;
    }
}