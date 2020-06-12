package com.dilip.junittest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
/**
* Created by Dilip Birajadar
* 01/06/2020
* */
public class MainActivity extends AppCompatActivity {
    private EditText mEmailText;
    private Button btSubmit;
    private TextView loadEmail;

    // The validator for the email input field.
    private EmailValidator mEmailValidator;

    // The helper that manages writing to SharedPreferences.
    private SharedPreferencesHelper mSharedPreferencesHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEmailText =findViewById(R.id.edEmail);
        btSubmit = findViewById(R.id.btnSubmit);
        loadEmail = findViewById(R.id.loadEmail);
        // Setup field validators.
        mEmailValidator = new EmailValidator();
        mEmailText.addTextChangedListener(mEmailValidator);

        // Instantiate a SharedPreferencesHelper.
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mSharedPreferencesHelper = new SharedPreferencesHelper(sharedPreferences);

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Don't save if the fields do not validate.
                if (!mEmailValidator.isValid()) {
                    mEmailText.setError("Invalid email");
                    Log.w("TAG", "Invalid email");
                    return;
                }else {
                    Log.w("TAG", "Valid email");
                    Toast.makeText(getApplicationContext(),"Valid email...",Toast.LENGTH_SHORT).show();

                    // Create a Setting model class to persist.
                    SharedPreferenceEntry sharedPreferenceEntry =
                            new SharedPreferenceEntry(mEmailText.getText().toString());
                    // Persist the personal information.
                    boolean isSuccess = mSharedPreferencesHelper.savePersonalInfo(sharedPreferenceEntry);
                    if (isSuccess) {
                        Toast.makeText(getApplicationContext(), "Personal information saved", Toast.LENGTH_LONG).show();

                        sharedPreferenceEntry = mSharedPreferencesHelper.getPersonalInfo();
                        loadEmail.setText(sharedPreferenceEntry.getmEmail());
                        Log.i("TAG", "Personal information saved");
                    } else {
                        Log.e("TAG", "Failed to write personal information to SharedPreferences");
                    }
                }

            }
        });
    }
}
