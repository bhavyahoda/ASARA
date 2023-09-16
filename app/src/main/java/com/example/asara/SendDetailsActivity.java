package com.example.asara;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

public class SendDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_details);
        ImageView imageView = findViewById(R.id.animalImage);
        Intent intent = getIntent();

        if (intent != null) {
            // Check if the Intent has the Bitmap extra
            if (intent.hasExtra("imageBitmap")) {
                // Retrieve the Bitmap from the Intent
                Bitmap receivedBitmap = intent.getParcelableExtra("imageBitmap");

                // Now you can use the received Bitmap as needed
                imageView.setImageBitmap(receivedBitmap); // Display it in an ImageView
                // Perform any other operations with the Bitmap
            }
        }
    }
}