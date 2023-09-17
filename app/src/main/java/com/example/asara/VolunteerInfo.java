package com.example.asara;

import com.google.android.gms.maps.model.LatLng;

public class VolunteerInfo {
    private LatLng location;
    private String name;

    public VolunteerInfo(LatLng location, String name) {
        this.location = location;
        this.name = name;
    }

    public LatLng getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}
