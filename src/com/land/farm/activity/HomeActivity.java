package com.land.farm.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import com.land.farm.Constants.UrlConstants;
import com.land.farm.R;
import com.land.farm.adapter.TickerAdapter;
import com.land.farm.helper.RemoteXml;
import com.land.farm.interfaces.XmlCallback;
import com.land.farm.models.Announcement;

import java.util.ArrayList;

public class HomeActivity extends Activity {

    private ListView _tickerListView;
    private TextView _loaderView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        _tickerListView = (ListView) this.findViewById(R.id.tickerListView);
        _loaderView = (TextView) this.findViewById(R.id.homeLoaderView);

        RemoteXml remoteXml = new RemoteXml(this.getApplicationContext());
        remoteXml.GetXmlData(new XmlCallback() {

            @Override
            public void onSuccess(ArrayList<Announcement> result) {
                TickerAdapter tickerAdapter = new TickerAdapter(HomeActivity.this, R.id.tickerListView, result);
                _tickerListView.setAdapter(tickerAdapter);

                _loaderView.setVisibility(View.INVISIBLE);
                _loaderView.setHeight(0);
                _loaderView.setWidth(0);
            }

        }, UrlConstants.TICKERS);

        _tickerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView linkView = (TextView) view.findViewById(R.id.linkView);

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(linkView.getText().toString()));
                startActivity(intent);
            }

        });

    }

    // those who can provide work
    public void navigateToJobSeekers(View view) {
        Intent intent = new Intent(HomeActivity.this, JobSeekerActivity.class);
        startActivity(intent);
    }


    // those who want job
    public void navigateToJobProviders(View view) {
        Intent intent = new Intent(HomeActivity.this, JobProviderActivity.class);
        startActivity(intent);
    }

}
