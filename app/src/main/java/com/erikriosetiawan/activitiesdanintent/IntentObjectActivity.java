package com.erikriosetiawan.activitiesdanintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class IntentObjectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_object);

        // Get the data passed in using getStringExtra()
        Toast.makeText(this, getIntent().getStringExtra("strone"), Toast.LENGTH_SHORT).show();
        // Get the data passed in using getIntExtra()
        Intent intentGetInt = getIntent();
        int intValue = intentGetInt.getIntExtra("ageone", 0);
        Toast.makeText(this, Integer.toString(intValue), Toast.LENGTH_SHORT).show();
        // Get the bundle object passed in
        Bundle bundle = getIntent().getExtras();
        // Get the data using getString()
        Toast.makeText(this, bundle.getString("strtwo"), Toast.LENGTH_SHORT).show();
        // Get the data using getInt()
        Toast.makeText(this, Integer.toString(bundle.getInt("agetwo", 0)), Toast.LENGTH_SHORT).show();

    }

    public void onClickBackEvent(View view) {
        // Use an intent object to return data
        Intent intentBack = new Intent();
        // Use putExtra() method to return some value
        intentBack.putExtra("agethree", 45);
        // Use setData() method to return some value
        intentBack.setData(Uri.parse("Something passed back to the main activity"));
        // Set the result with OK and the intent object
        setResult(RESULT_OK, intentBack);
        // Destroy the current activity
        finish();
    }
}
