package com.land.farm.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.land.farm.R;
import com.land.farm.models.JobProvider;

import java.util.ArrayList;

public class JobSeekerAdapter extends ArrayAdapter<JobProvider> {

    private Activity _myContext;
    private ArrayList<JobProvider> _jobProvider;

    public JobSeekerAdapter(Context context, int resourceId, ArrayList<JobProvider> jobseekers) {
        super(context, resourceId, jobseekers);

        _myContext = (Activity) context;
        _jobProvider = jobseekers;

    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = _myContext.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.adapter_jobprovider, null);

        if (_jobProvider.get(position) != null) {
            TextView workProviderNameView = (TextView) rowView.findViewById(R.id.workProviderView);
            TextView workProviderContact = (TextView) rowView.findViewById(R.id.contactView);
            TextView ageView = (TextView) rowView.findViewById(R.id.ageView);

            String online = "No";

            if (_jobProvider.get(position).isAvailable == "true") {
                online = "Yes";
            }
            workProviderNameView.setText(_jobProvider.get(position).name + " , Age " + _jobProvider.get(position).age + " , Sex " + _jobProvider.get(position).sex + " , Is Available : " + online);
            workProviderContact.setText(_jobProvider.get(position).phone);

        }

        return rowView;
    }

}
