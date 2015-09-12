package com.land.farm.interfaces;


import com.land.farm.models.JobProvider;
import com.land.farm.models.JobSeeker;

import java.util.ArrayList;

public interface JsonCallback {
    void onSuccess(ArrayList<JobProvider> result);
}


