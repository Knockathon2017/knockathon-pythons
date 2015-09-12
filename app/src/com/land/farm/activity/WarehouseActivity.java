package com.land.farm.activity;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import com.land.farm.R;


public class WarehouseActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warehouse);

        WebView webView = (WebView) this.findViewById(R.id.warehouseWeb);
        webView.loadUrl("http://knockapi.starshipchandan.com/warehouse");
    }

}
