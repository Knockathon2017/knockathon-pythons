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
                jobSeeker.age = jsonObject.getString("age");
                jobSeeker.name = jsonObject.getString("name");
                jobSeeker.workForce = jsonObject.getString("requiredWorkforce");
                jobSeeker.phone = jsonObject.getString("contactNo1");

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
                jobProvider.age = jsonObject.get("age").toString();
                jobProvider.gender = jsonObject.getString("sex");
                jobProvider.phone = jsonObject.getString("contactNo1");

                jobProviders.add(jobProvider);

            }

        } catch (Exception exception) {
            //Todo : Handle exception

        }

        return jobProviders;

    }


    public ArrayList<JobSeeker> getWorkOpportunityList(String jsonString) {

        ArrayList<JobSeeker> jobSeekers = new ArrayList<JobSeeker>();

        try {
            JSONArray jsonArray = new JSONArray(jsonString);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                JobSeeker jobSeeker = new JobSeeker();
                jobSeeker.age = jsonObject.getString("Age");
                jobSeeker.name = jsonObject.getString("Name");
                jobSeeker.status = jsonObject.getString("IsAvailable");
                jobSeeker.phone = jsonObject.getString("ContactNo1");

                jobSeekers.add(jobSeeker);

            }

        } catch (Exception exception) {
            //Todo : Handle exception

        }

        return jobSeekers;

    }
}
