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
import android.widget.EditText;

public class UserInterventionCall extends AppCompatActivity {

    EditText phoneNumber;
    Button callButton;
    private static final int PHONE_REQUEST_CALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_intervention_call);

        phoneNumber = (EditText)findViewById(R.id.phoneNumber);
        callButton = (Button)findViewById(R.id.callButton);

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String retrieveNumber = phoneNumber.getText().toString();
                Intent UserIntent = new Intent(Intent.ACTION_CALL);
                UserIntent.setData(Uri.parse("tel : " + retrieveNumber));

                if (ActivityCompat.checkSelfPermission(UserInterventionCall.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(UserInterventionCall.this, new String[]{Manifest.permission.CALL_PHONE}, PHONE_REQUEST_CALL);
                }
                startActivity(UserIntent);
            }
        });
    }
}