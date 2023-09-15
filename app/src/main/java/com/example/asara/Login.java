package com.example.asara;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Login extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ImageView backArrow = findViewById(R.id.loginScreenTopBackArrow);
        Button sign_in_button = findViewById(R.id.sign_in_button);
        EditText email_sign_in = findViewById(R.id.email_sign_in);

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, LoginRegisterActivity.class);
                startActivity(intent);
            }
        });

        //using org@org.com as an email credential for an org
        //using volunteer@vol.com for volunteer
        sign_in_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = email_sign_in.getText().toString();
                //organisation account
                if(email.equals("org@org.com")) {
                    Intent intent = new Intent(Login.this, OrgSignedInActivity.class);
                    startActivity(intent);
                }
                //volunteer account
                else {
                    Intent intent = new Intent(Login.this, VolunteerSignedinActivity.class);
                    startActivity(intent);
                }
            }
        });

        //aborting the app
//        String subscriptionKey = "";
//        AssetManager assetManager = getAssets();
//        try {
//            InputStream inputStream = assetManager.open("dog_image.png");
//            OkHttpClient client = new OkHttpClient();
//            byte[] imageData = inputStreamToByteArray(inputStream);
//            String apiUrl = "https://cxcvapis.cognitiveservices.azure.com/computervision/retrieval:vectorizeImage?api-version=2023-02-01-preview&modelVersion=latest";
//            RequestBody requestBody = RequestBody.create(MediaType.parse("application/octet-stream"), imageData);
//            Request request = new Request.Builder()
//                    .url(apiUrl) // Replace with your API endpoint URL
//                    .addHeader("Ocp-Apim-Subscription-Key", subscriptionKey) // Add your headers here
//                    .addHeader("Content-Type", "application/octet-stream")
//                    .post(requestBody)
//                    .build();
//
//            try {
//                Response response = client.newCall(request).execute();
//                if (response.isSuccessful()) {
//                    String responseBody = response.body().string();
//                } else {
//                    Log.d("HTTP error code: " , String.valueOf(response.code()));
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

//    private byte[] inputStreamToByteArray(InputStream inputStream) throws IOException {
//        byte[] buffer = new byte[1024];
//        int bytesRead;
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//
//        while ((bytesRead = inputStream.read(buffer)) != -1) {
//            byteArrayOutputStream.write(buffer, 0, bytesRead);
//        }
//
//        return byteArrayOutputStream.toByteArray();
//    }
}
