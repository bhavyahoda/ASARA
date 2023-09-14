package com.example.asara;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginRegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);

        ImageView loginImageView = findViewById(R.id.loginImageView);
        ImageView registerAsVolunteer = findViewById(R.id.registerAsVolunteer);
        ImageView registerAsOrg = findViewById(R.id.registerAsOrg);
        loginImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginRegisterActivity.this, Login.class);
                startActivity(intent);
            }
        });

        registerAsOrg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginRegisterActivity.this, VetRegistrationActivity.class);
                startActivity(intent);
            }
        });

        registerAsVolunteer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginRegisterActivity.this, "Registering as volunteer", Toast.LENGTH_SHORT).show();
            }
        });
        
    }
    
}