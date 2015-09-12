package com.land.farm.helper;


import android.content.Context;
import android.widget.ListView;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.land.farm.interfaces.JsonCallback;
import com.land.farm.interfaces.WorkProviderCallBack;


public class RemoteJson {

    private Context _context;
    private ListView _listView;
    private int _type;

    public RemoteJson(Context context) {
        _context = context;
    }

    public RemoteJson(Context context, ListView listView, int type) {
        _context = context;
        _listView = listView;
        _type = type;
    }

    public void SendRequest(JsonCallback callback, String url) {

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                callback.onSuccess(new ParseJson().getWorkersList(response));

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


    public void SendRequestWorkers(WorkProviderCallBack callback, String url) {

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                callback.onSuccess(new ParseJson().DeserializeJson(response));

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




