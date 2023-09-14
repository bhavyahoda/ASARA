package com.example.asara;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    Button registered_animals, case_history, nearest_vet_facility,my_profile,sos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        my_profile = findViewById(R.id.my_profile);
        case_history = findViewById(R.id.case_history);
        nearest_vet_facility = findViewById(R.id.nearest_vet_facility);
        Resources resources = getResources();
        InputStream inputStream = resources.openRawResource(R.raw.dog_model); // Replace with your JSON file name
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }

            String jsonData = stringBuilder.toString();

            JSONObject jsonObject = new JSONObject(jsonData);

            // Now, you can access data from the JSON object
            JSONArray dog_model = jsonObject.getJSONArray("json_data");
            Log.d("printing", String.valueOf(dog_model));

            // Handle the parsed data as needed
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }


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
                Intent intent = new Intent(getApplicationContext(), CaseHistoryActivity.class);
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

    }

}
