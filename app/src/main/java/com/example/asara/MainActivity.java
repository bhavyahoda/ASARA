package com.example.asara;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    Button registered_animals, case_history, nearest_vet_facility,my_profile,sos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView authenticateCard = findViewById(R.id.authenticateCard);
        CardView reportNowCard = findViewById(R.id.reportNowCard);
        authenticateCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginRegisterActivity.class);
                startActivity(intent);
            }
        });

        reportNowCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Intent intent = new Intent();
                    intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });



//
//        my_profile = findViewById(R.id.my_profile);
//        case_history = findViewById(R.id.case_history);
//        nearest_vet_facility = findViewById(R.id.nearest_vet_facility);
//        Resources resources = getResources();
//        InputStream inputStream = resources.openRawResource(R.raw.dog_model); // Replace with your JSON file name
//        try {
//            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//            StringBuilder stringBuilder = new StringBuilder();
//            String line;
//
//            while ((line = bufferedReader.readLine()) != null) {
//                stringBuilder.append(line);
//            }
//
//            String jsonData = stringBuilder.toString();
//
//            JSONObject jsonObject = new JSONObject(jsonData);
//
//            // Now, you can access data from the JSON object
//            JSONArray dog_model = jsonObject.getJSONArray("json_data");
//            Log.d("printing", String.valueOf(dog_model));
//
//            // Handle the parsed data as needed
//        } catch (IOException | JSONException e) {
//            e.printStackTrace();
//            // Handle exceptions appropriately
//        }
//
//
//        my_profile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent= new Intent(getApplicationContext(), Profile.class);
//                startActivity(intent);
//            }
//        });
//        case_history.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), CaseHistoryActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        nearest_vet_facility.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), NearestVetFacilityActivity.class);
//                startActivity(intent);
//            }
//        });

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            // The image was successfully captured.
            // You can access the image data from the intent.
            Bitmap imageBitmap = (Bitmap) data.getExtras().get("data");

            // Now, you can use the captured image as needed.
            Intent intent = new Intent(MainActivity.this, SendDetailsActivity.class);
            intent.putExtra("imageBitmap", imageBitmap);
            startActivity(intent);
            // Save the image to storage, send it to a server, or process it further.
        }
    }

}
