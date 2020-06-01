package com.dilip.junittest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
/**
* Created by Dilip Birajadar
* 01/06/2020
* */
public class MainActivity extends AppCompatActivity {
    private EditText mEmailText;
    private Button btSubmit;

    // The validator for the email input field.
    private EmailValidator mEmailValidator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEmailText =findViewById(R.id.edEmail);
        btSubmit = findViewById(R.id.btnSubmit);
        // Setup field validators.
        mEmailValidator = new EmailValidator();
        mEmailText.addTextChangedListener(mEmailValidator);

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
                }

            }
        });
    }
}
