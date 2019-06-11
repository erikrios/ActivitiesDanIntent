package com.erikriosetiawan.activitiesdanintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AnotherOneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another_one);
    }

    public void onClickButtonName(View view) {
        Intent data = new Intent();
        //get the edit text view data
        EditText editTextName = findViewById(R.id.edit_text_name);
        //set the data to pass back
        data.setData(Uri.parse(editTextName.getText().toString()));
        setResult(RESULT_OK, data);
        //close the activity
        finish();
    }
}
