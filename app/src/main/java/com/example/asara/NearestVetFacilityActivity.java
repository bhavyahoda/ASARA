package com.example.asara;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class NearestVetFacilityActivity extends AppCompatActivity implements OnMapReadyCallback {

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    private MapView mapView;
    private GoogleMap googleMap;
    private FusedLocationProviderClient fusedLocationClient;
    private List<Marker> petClinicMarkers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearest_vet_facility);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkLocationPermission();
        }
        // Initialize the MapView
        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        // Initialize the FusedLocationProviderClient
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        petClinicMarkers = new ArrayList<>();

        // Initialize the Google Map Fragment
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        googleMap = map;

        // Check and request location permission
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            // Permission already granted
            showUserLocation();
        } else {
            // Request location permission
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    LOCATION_PERMISSION_REQUEST_CODE);
        }
    }

    private void showUserLocation() {
        if (googleMap != null) {
            // Enable the user's location on the map
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            googleMap.setMyLocationEnabled(true);

            // Get the user's last known location
            fusedLocationClient.getLastLocation()
                    .addOnSuccessListener(this, location -> {
                        if (location != null) {
                            LatLng userLatLng = new LatLng(location.getLatitude(), location.getLongitude());

                            // Move the camera to the user's location
                            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLatLng, 15f));

                            showNearestPetClinics(userLatLng);

                            // Now, you can implement nearby facility search and display markers on the map.
                        } else {
                            Toast.makeText(this, "Unable to determine your location.", Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }

    public boolean checkLocationPermission() {
        //first checking the permission was granted or not
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            //if permission is not granted we ask for the permission an educational message is shown as to why the permission is required
            //this will return true if the user had asked for the permission before and denied for it,and is now trying to access the feature again
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                //after reading the message the user knows why we need permission now the diluoge box appears to
                //to the user to choose the permission and this time we check it with the request code to match that the permision is granted for the work we want to o ith the permission
                //new string will take a array of permission that we have to give

                ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSION_REQUEST_CODE);

            }

            else {
                //if we dont want to show the explaination then we directly request for the permission
                ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSION_REQUEST_CODE);
            }
            //permission denied hogaya ab they cannot access the current location
            //if the permission was asked before by the app and the user had choosen the dont ask again vala option
            return false;

        }
        //if the permission is granted directly true bejh dega
        else
            return true;

    }

    private void showNearestPetClinics(LatLng userLocation) {
        // Replace this logic with your own method to retrieve nearby pet clinics
        // For demonstration purposes, we'll add some sample markers
        LatLng clinic1 = new LatLng(userLocation.latitude + 0.005, userLocation.longitude + 0.005);
        LatLng clinic2 = new LatLng(userLocation.latitude - 0.005, userLocation.longitude - 0.005);

        // Clear existing markers before adding new ones
        clearPetClinicMarkers();

        // Add sample markers for pet clinics
        Marker marker1 = googleMap.addMarker(new MarkerOptions()
                .position(clinic1)
                .title("Pet Clinic 1")
                .snippet("123 Main St, City"));
        Marker marker2 = googleMap.addMarker(new MarkerOptions()
                .position(clinic2)
                .title("Pet Clinic 2")
                .snippet("456 Elm St, City"));

        // Add markers to the marker list
        petClinicMarkers.add(marker1);
        petClinicMarkers.add(marker2);
    }

    private void clearPetClinicMarkers() {
        // Remove existing pet clinic markers from the map
        for (Marker marker : petClinicMarkers) {
            marker.remove();
        }
        petClinicMarkers.clear();
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, show user location
                showUserLocation();
            } else {
                Toast.makeText(this, "Location permission denied.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}