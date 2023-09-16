package com.example.asara;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.location.LocationServices;

import java.util.ArrayList;
import java.util.List;

public class showNearestVetsMaps extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;

    private FusedLocationProviderClient fusedLocationClient;
    private GoogleMap googleMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_nearest_vets_maps);
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;

        BitmapDescriptor petClinicIcon = BitmapDescriptorFactory.fromResource(R.drawable.pet_clinic_icon);
        int iconWidth = 98; // Adjust the width as needed (in pixels)
        int iconHeight =98; // Adjust the height as needed (in pixels)
        petClinicIcon = BitmapDescriptorFactory.fromBitmap(Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(getResources(), R.drawable.pet_clinic_icon),
                iconWidth,
                iconHeight,
                false
        ));

        BitmapDescriptor volunteerIcon = BitmapDescriptorFactory.fromResource(R.drawable.volunteer_symbol);
        int iconWidth1 = 98; // Adjust the width as needed (in pixels)
        int iconHeight1= 98; // Adjust the height as needed (in pixels)
        volunteerIcon = BitmapDescriptorFactory.fromBitmap(Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(getResources(), R.drawable.volunteer_symbol),
                iconWidth1,
                iconHeight1,
                false
        ));

        // Check and request location permissions if not granted
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            return;
        }

        // Enable the My Location layer on the map
        googleMap.setMyLocationEnabled(true);

        // Get the current location and move the camera to it
        BitmapDescriptor finalPetClinicIcon = petClinicIcon;
        BitmapDescriptor finalVolunteerIcon = volunteerIcon;
        fusedLocationClient.getLastLocation().addOnSuccessListener(this, location -> {
            if (location != null) {
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();

                // Create a LatLng object for the current location
                LatLng currentLocation = new LatLng(latitude, longitude);
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 15));


                // Hardcoded list of pet clinic locations and names (you can replace this with real data)
                List<ClinicInfo> clinicInfos = new ArrayList<>();
                clinicInfos.add(new ClinicInfo(new LatLng(12.8914681, 77.634165), "Clinic A"));
                clinicInfos.add(new ClinicInfo(new LatLng(12.8963568, 77.6642669), "Clinic B"));
                clinicInfos.add(new ClinicInfo(new LatLng(12.9025344, 77.666899), "Clinic C"));
                clinicInfos.add(new ClinicInfo(new LatLng(12.8940548, 77.6529348), "Clinic D"));

                // Add markers for each pet clinic
                for (ClinicInfo clinicInfo : clinicInfos) {
                    MarkerOptions markerOptions = new MarkerOptions()
                            .position(clinicInfo.getLocation())
                            .title(clinicInfo.getName()).icon(finalPetClinicIcon); // Set the name as the marker title

                    // Add the marker to the map
                    googleMap.addMarker(markerOptions);
                }
                List<VolunteerInfo> volunteerInfos = new ArrayList<>();

                volunteerInfos.add(new VolunteerInfo(new LatLng(12.899608, 77.655085), "Volunteer A"));
                volunteerInfos.add(new VolunteerInfo(new LatLng(12.8958348, 77.674128), "Volunteer B"));
                volunteerInfos.add(new VolunteerInfo(new LatLng(12.924569, 77.675433), "Volunteer C"));
                volunteerInfos.add(new VolunteerInfo(new LatLng(12.897335, 77.644782), "Volunteer D"));

                // Add markers for each pet clinic
                for (VolunteerInfo volunteerInfo : volunteerInfos) {
                    MarkerOptions markerOptions = new MarkerOptions()
                            .position(volunteerInfo.getLocation())
                            .title(volunteerInfo.getName()).icon(finalVolunteerIcon); // Set the name as the marker title

                    // Add the marker to the map
                    googleMap.addMarker(markerOptions);
                }

            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, enable location on the map
                if (mMap != null) {
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                        return;
                    }
                    mMap.setMyLocationEnabled(true);
                }
            } else {
                Toast.makeText(this, "Location permission is required to show nearby pet clinics.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
