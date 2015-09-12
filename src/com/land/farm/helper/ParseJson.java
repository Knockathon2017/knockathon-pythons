package com.land.farm.helper;

import com.land.farm.models.JobSeeker;
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


            }

        } catch (Exception exception) {
            //Todo : Handle exception

        }

        return jobseekers;
    }
}
