package com.example.asara;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;

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
        String subscriptionKey = "";
        AssetManager assetManager = getAssets();
        try {
            InputStream inputStream = assetManager.open("dog_image.png");
            OkHttpClient client = new OkHttpClient();
            byte[] imageData = inputStreamToByteArray(inputStream);
            String apiUrl = "https://cxcvapis.cognitiveservices.azure.com/computervision/retrieval:vectorizeImage?api-version=2023-02-01-preview&modelVersion=latest";
            RequestBody requestBody = RequestBody.create(MediaType.parse("application/octet-stream"), imageData);
            Request request = new Request.Builder()
                    .url(apiUrl) // Replace with your API endpoint URL
                    .addHeader("Ocp-Apim-Subscription-Key", subscriptionKey) // Add your headers here
                    .addHeader("Content-Type", "application/octet-stream")
                    .post(requestBody)
                    .build();

            try {
                Response response = client.newCall(request).execute();
                if (response.isSuccessful()) {
                    String responseBody = response.body().string();
                } else {
                    Log.d("HTTP error code: " , String.valueOf(response.code()));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private byte[] inputStreamToByteArray(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int bytesRead;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            byteArrayOutputStream.write(buffer, 0, bytesRead);
        }

        return byteArrayOutputStream.toByteArray();
    }
}
