package com.dilip.junittest;
/**
 * Created by Dilip Birajadar
 * 12/06/2020
 * */
public class SharedPreferenceEntry {

    // Email address of the user.
    private final String mEmail;

    public SharedPreferenceEntry(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmEmail() {
        return mEmail;
    }
}
