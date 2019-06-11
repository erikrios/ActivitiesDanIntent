package com.erikriosetiawan.activitiesdanintent;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buttonMaps, buttonCalls, buttonBrowse;

    private static final String TAG = "Activity Lifecycle";
    int requestCode = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "Pada event onCreate()");

        buttonMaps = findViewById(R.id.button_maps);
        buttonCalls = findViewById(R.id.button_calls);
        buttonBrowse = findViewById(R.id.button_browse);

        buttonMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMaps = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.827500,-122.481670"));
                startActivity(intentMaps);
            }
        });

        buttonCalls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCalls = new Intent();
                intentCalls.setAction(Intent.ACTION_DIAL);
                intentCalls.setData(Uri.parse("tel:+6283854050592"));
                startActivity(intentCalls);
            }
        });

        buttonBrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBrowse = new Intent(Intent.ACTION_VIEW);
                intentBrowse.setData(Uri.parse("http://umpo.ac.id"));
                startActivity(intentBrowse);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Pada event onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Pada event onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Pada event onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Pada event onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "Pada event onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Pada event onDestroy()");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "Pada event onSaveInstanceState()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "Pada event onRestoreInstanceState()");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public void onClickEvent(View view) {
        Intent intentMove = new Intent(getApplicationContext(), OtherActivity.class);
        startActivity(intentMove);
    }

    public void onClickAnotherEvent(View view) {
        Intent intentMove = new Intent(MainActivity.this, AnotherOneActivity.class);
        startActivityForResult(intentMove, requestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == this.requestCode) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, data.getData().toString(), Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == 2) {
            if (resultCode == RESULT_OK) {
                // Get the result using getIntExtra()
                Toast.makeText(this, Integer.toString(data.getIntExtra("agethree", 0)), Toast.LENGTH_SHORT).show();
                // Get the result using getData()
                Toast.makeText(this, data.getData().toString(), Toast.LENGTH_SHORT).show();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void onClickIntentEvent(View view) {
        Intent intentMove = new Intent(getApplicationContext(), IntentObjectActivity.class);
        // Using potExtra() to add new name/value pairs
        intentMove.putExtra("strone", "This is a String");
        intentMove.putExtra("ageone", 25);

        // Using a bundle object to add new name/value pairs
        Bundle extras = new Bundle();
        extras.putString("strtwo", "This is another String");
        extras.putInt("agetwo", 35);
        // Attached the bundle object to the intent object
        intentMove.putExtras(extras);
        startActivityForResult(intentMove, 2);

    }

}
