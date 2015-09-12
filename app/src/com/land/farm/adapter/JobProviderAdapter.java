package com.land.farm.adapter;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.land.farm.R;
import com.land.farm.models.JobSeeker;

import java.util.ArrayList;

public class JobProviderAdapter extends ArrayAdapter<JobSeeker> {

    private Activity _myContext;
    private ArrayList<JobSeeker> _jobSeekers;

    public JobProviderAdapter(Context context, int resourceId, ArrayList<JobSeeker> jobseekers) {
        super(context, resourceId, jobseekers);

        _myContext = (Activity) context;
        _jobSeekers = jobseekers;

    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = _myContext.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.adapter_jobseeker, null);

        if (_jobSeekers.get(position) != null) {
            TextView workProviderNameView = (TextView) rowView.findViewById(R.id.workProviderNameView);
            TextView workProviderLocationView = (TextView) rowView.findViewById(R.id.workProviderLocationView);
            TextView workProviderContactView = (TextView) rowView.findViewById(R.id.workProviderContactView);

            workProviderNameView.setText(_jobSeekers.get(position).name + " , Age " + _jobSeekers.get(position).age + " , Work Force Required " + _jobSeekers.get(position).workForce);
            workProviderLocationView.setText(_jobSeekers.get(position).location);
            workProviderContactView.setText(_jobSeekers.get(position).phone);

        }

        return rowView;
    }
}
