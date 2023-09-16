package com.example.asara;

import com.google.android.gms.maps.model.LatLng;

public class ClinicInfo {
    private LatLng location;
    private String name;

    public ClinicInfo(LatLng location, String name) {
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
