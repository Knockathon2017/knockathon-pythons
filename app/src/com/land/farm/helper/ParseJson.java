package com.land.farm.helper;

import com.land.farm.models.JobProvider;
import com.land.farm.models.JobSeeker;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ParseJson {

    public ArrayList<JobSeeker> DeserializeJson(String jsonString) {

        ArrayList<JobSeeker> jobseekers = new ArrayList<JobSeeker>();

        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                JobSeeker jobSeeker = new JobSeeker();
                jobSeeker.name = jsonObject.getString("name");
                jobSeeker.phone = jsonObject.getString("contactNo1");
                jobSeeker.age = jsonObject.getString("age");
                jobSeeker.workForce = jsonObject.getString("requiredWorkforce");
                jobSeeker.sex = jsonObject.getString("sex");
                //jobSeeker.isAvailable = jsonObject.getString("isAvailable");

                jobseekers.add(jobSeeker);

            }

        } catch (Exception exception) {
            //Todo : Handle exception

        }

        return jobseekers;
    }


    public ArrayList<JobProvider> getWorkersList(String jsonString) {

        ArrayList<JobProvider> jobProviders = new ArrayList<JobProvider>();

        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                JobProvider jobProvider = new JobProvider();
                jobProvider.name = jsonObject.getString("name");
                jobProvider.phone = jsonObject.getString("contactNo1");
                jobProvider.age = jsonObject.getString("age");
                jobProvider.sex = jsonObject.getString("sex");
                jobProvider.isAvailable = jsonObject.getString("isAvailable");

                jobProviders.add(jobProvider);

            }

        } catch (Exception exception) {
            //Todo : Handle exception

        }

        return jobProviders;
    }
}
