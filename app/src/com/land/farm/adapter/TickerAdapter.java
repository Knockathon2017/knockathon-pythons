package com.land.farm.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.land.farm.R;
import com.land.farm.models.Announcement;

import java.util.ArrayList;

public class TickerAdapter extends ArrayAdapter<Announcement> {

    protected ArrayList<Announcement> _announcements;
    private Activity _myContext;

    public TickerAdapter(Context context, int resourceId, ArrayList<Announcement> announcements) {
        super(context, resourceId, announcements);

        _myContext = (Activity) context;
        _announcements = announcements;

    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = _myContext.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.adapter_ticker, null);

        if (_announcements.get(position) != null) {
            TextView titleView = (TextView) rowView.findViewById(R.id.titleView);
            TextView descriptionView = (TextView) rowView.findViewById(R.id.descriptionView);
            TextView linkView = (TextView) rowView.findViewById(R.id.linkView);

            titleView.setText(_announcements.get(position).title);
            descriptionView.setText(_announcements.get(position).description.replace("Advisories:-", ""));
            linkView.setText(_announcements.get(position).link);
        }

        return rowView;
    }
}
