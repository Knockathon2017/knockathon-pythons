package com.land.farm.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.land.farm.R;
import com.land.farm.models.JobSeeker;

import java.util.ArrayList;

public class JobSeekerAdapter extends ArrayAdapter<JobSeeker> {

    private Activity _myContext;
    private ArrayList<JobSeeker> _jobSeekers;

    public JobSeekerAdapter(Context context, int resourceId, ArrayList<JobSeeker> jobseekers) {
        super(context, resourceId, jobseekers);

        _myContext = (Activity) context;
        _jobSeekers = jobseekers;

    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = _myContext.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.adapter_ticker, null);

        if (_jobSeekers.get(position) != null) {

        }

        return rowView;
    }

}
