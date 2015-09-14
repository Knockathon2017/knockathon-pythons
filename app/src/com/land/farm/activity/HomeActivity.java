package com.land.farm.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.land.farm.Constants.UrlConstants;
import com.land.farm.R;
import com.land.farm.adapter.TickerAdapter;
import com.land.farm.helper.RemoteXml;
import com.land.farm.interfaces.XmlCallback;
import com.land.farm.models.Announcement;

import java.util.ArrayList;

public class HomeActivity extends Activity {

    private ListView _tickerListView;
    private ListView _weatherListView;
    private TextView _loaderView;

    private SensorManager senseManage;
    private Sensor envSense;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        senseManage = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        envSense = senseManage.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);

//        if (envSense == null)
//            Toast.makeText(this.getApplicationContext(),
//                    "Sorry - your device doesn't have an pressure sensor!",
//                    Toast.LENGTH_SHORT).show();

        _tickerListView = (ListView) this.findViewById(R.id.tickerListView);
        _loaderView = (TextView) this.findViewById(R.id.homeLoaderView);
        //_weatherListView = (ListView) this.findViewById(R.id.weatherListView);

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
                try {
                    TextView linkView = (TextView) view.findViewById(R.id.linkView);

                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(linkView.getText().toString()));
                    startActivity(intent);
                } catch (Exception ex) {
                    Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_LONG).show();
                }
            }

        });


//        RemoteXml remoteXmlData = new RemoteXml(this.getApplicationContext());
//        remoteXml.GetXmlWeatherData(new WeatherCallback() {
//
//            @Override
//            public void onSuccess(ArrayList<Weather> result) {
//                WeatherAdapter weatherAdapter = new WeatherAdapter(HomeActivity.this, R.id.weatherListView, result);
//                _weatherListView.setAdapter(weatherAdapter);
//
//            }
//        }, UrlConstants.WEATHER);

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


    public void navigateToWarehouseStorage(View view) {
        Intent intent = new Intent(HomeActivity.this, WarehouseActivity.class);
        startActivity(intent);
    }


}
