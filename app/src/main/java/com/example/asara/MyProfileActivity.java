package com.example.asara;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MyProfileActivity extends AppCompatActivity {

    private ImageView profileImage;
    private TextView usernameTextView;
    private TextView emailTextView;
   // private Button editProfileButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        // Initialize UI components
        profileImage = findViewById(R.id.profileImage);
        usernameTextView = findViewById(R.id.usernameTextView);
        emailTextView = findViewById(R.id.emailTextView);

        // Replace with actual user data
        String username = "John Doe";
        String email = "johndoe@example.com";

        // Set user data in UI
        usernameTextView.setText(username);
        emailTextView.setText(email);

        }
}