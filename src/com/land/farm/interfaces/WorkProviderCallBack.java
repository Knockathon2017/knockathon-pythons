package com.land.farm.interfaces;

import com.land.farm.models.JobSeeker;

import java.util.ArrayList;


public interface WorkProviderCallBack {
    void onSuccess(ArrayList<JobSeeker> result);
}
