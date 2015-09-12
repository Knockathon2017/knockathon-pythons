package com.land.farm.helper;


import android.content.Context;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.land.farm.interfaces.WeatherCallback;
import com.land.farm.interfaces.XmlCallback;
import com.land.farm.models.Announcement;
import com.land.farm.models.Weather;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class RemoteXml {

    static final String KEY_ITEM = "item";
    static final String KEY_TITLE = "title";
    static final String KEY_DESC = "description";
    static final String KEY_LINK = "link";
    private Context _context;

    public RemoteXml(Context context) {
        _context = context;
    }

    public void GetXmlData(XmlCallback callback, String url) {

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                XMLReader parser = new XMLReader();
                Document doc = new XMLReader().getDomElement(response);
                NodeList nl = doc.getElementsByTagName(KEY_ITEM);

                ArrayList<Announcement> announcements = new ArrayList<Announcement>();

                for (int i = 0; i < nl.getLength(); i++) {
                    Element element = (Element) nl.item(i);

                    Announcement announcement = new Announcement();
                    announcement.title = parser.getValue(element, KEY_TITLE);
                    announcement.description = parser.getValue(element, KEY_DESC);
                    announcement.link = parser.getValue(element, KEY_LINK);

                    announcements.add(announcement);
                }

                callback.onSuccess(announcements);
            }

        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError volleyError) {
                // something went wrong
            }

        });

        // Add the request to the queue
        Volley.newRequestQueue(_context).add(request);

    }


    public void GetXmlWeatherData(WeatherCallback callback, String url) {

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                XMLReader parser = new XMLReader();
                Document doc = new XMLReader().getDomElement(response);
                NodeList nl = doc.getElementsByTagName(KEY_ITEM);

                ArrayList<Weather> weathers = new ArrayList<Weather>();

                for (int i = 0; i < nl.getLength(); i++) {
                    Element element = (Element) nl.item(i);

                    Weather weather = new Weather();
                    weather.temperature = parser.getValue(element, KEY_TITLE);
                    weather.pressure = parser.getValue(element, KEY_DESC);
                    weather.humidity = parser.getValue(element, KEY_LINK);

                    weathers.add(weather);
                }

                callback.onSuccess(weathers);
            }

        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError volleyError) {
                // something went wrong
            }

        });

        // Add the request to the queue
        Volley.newRequestQueue(_context).add(request);

    }
}
