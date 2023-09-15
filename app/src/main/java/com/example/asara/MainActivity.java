package com.example.asara;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button registered_animals, case_history, nearest_vet_facility,my_profile,sos;
    CreateLoadLocalData createLoadLocalData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        my_profile = findViewById(R.id.my_profile);
        case_history = findViewById(R.id.case_history);
        nearest_vet_facility = findViewById(R.id.nearest_vet_facility);
        registered_animals = findViewById(R.id.registered_animals);

        createLoadLocalData = new CreateLoadLocalData(this);
        createLoadLocalData.createAndInsertAnimalTable();

        my_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(getApplicationContext(), Profile.class);
                startActivity(intent);
            }
        });
        case_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CaseHistoryInternalActivity.class);
                startActivity(intent);
            }
        });

        nearest_vet_facility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NearestVetFacilityActivity.class);
                startActivity(intent);
            }
        });

        registered_animals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisteredAnimalsActivity.class);
                startActivity(intent);
            }
        });
    }

}
