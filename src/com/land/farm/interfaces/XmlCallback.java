package com.land.farm.interfaces;


import com.land.farm.models.Announcement;

import java.util.ArrayList;

public interface XmlCallback {
    void onSuccess(ArrayList<Announcement> result);
}
