package com.dilip.junittest;

import android.app.Instrumentation;
import android.widget.Button;
import android.widget.EditText;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    public static final String email = "dilip@gmail.com";

    @Rule
    public ActivityTestRule<MainActivity> rule  = new  ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkMail(){
        MainActivity ma = rule.getActivity();
        EditText emaild = ma.findViewById(R.id.edEmail);
        assertThat(emaild,notNullValue());
        emaild.setText(email);

        //Button btnSubmit = ma.findViewById(R.id.btnSubmit);
        //btnSubmit.performClick();
        assertThat(emaild.getText().toString(), is(email));
    }


}
