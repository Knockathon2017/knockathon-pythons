package com.land.farm.helper;

import com.land.farm.models.JobSeeker;
import com.land.farm.models.Person;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ParseJson {

    public ArrayList<JobSeeker> DeserializeJson(String jsonString) {

        ArrayList<JobSeeker> jobseekers = new ArrayList<JobSeeker>();

        try {
            JSONObject jsonObject = new JSONObject(jsonString);

            JSONArray jsonArray = jsonObject.getJSONArray("data");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONArray values = jsonArray.getJSONArray(i);

                JobSeeker jobSeeker = new JobSeeker();
                jobSeeker.id = values.getString(0);
                jobSeeker.district = values.getString(1);
                jobSeeker.total = values.getString(2);

                jobseekers.add(jobSeeker);
                jobSeeker = null;
            }

        } catch (Exception exception) {
            //Todo : Handle exception

        }

        return jobseekers;
    }
}
