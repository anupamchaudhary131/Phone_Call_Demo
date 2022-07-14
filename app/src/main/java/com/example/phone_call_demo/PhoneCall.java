package com.example.phone_call_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PhoneCall extends AppCompatActivity {

    private static final int REQUEST_PHONE_CALL = 1;
    Button callButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_call);

        callButton = (Button)findViewById(R.id.contactButton);
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:9870797329"));

                if(ActivityCompat.checkSelfPermission(PhoneCall.this, Manifest.permission.CALL_PHONE ) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(PhoneCall.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_PHONE_CALL);
                }
                else {
                    startActivity(callIntent);
                }
            }
        });
    }

    public void callFriend(View v)
    {
        Toast.makeText(PhoneCall.this, "Successfully Reached To Calling Page", Toast.LENGTH_LONG).show();
        Intent callIntent = new Intent(PhoneCall.this, UserInterventionCall.class);
        startActivity(callIntent);
    }
}