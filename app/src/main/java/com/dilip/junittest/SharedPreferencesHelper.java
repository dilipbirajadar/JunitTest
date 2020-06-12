package com.dilip.junittest;

import android.content.SharedPreferences;
/**
 * Created by Dilip Birajadar
 * 12/06/2020
 * */
public class SharedPreferencesHelper {
    // Keys for saving values in SharedPreferences.
    static final String KEY_EMAIL = "key_email";


    // The injected SharedPreferences implementation to use for persistence.
    private final SharedPreferences mSharedPreferences;


    /**
     * Constructor with dependency injection.
     *
     *  {@link SharedPreferences} that will be used in this DAO.
     */
    public SharedPreferencesHelper(SharedPreferences mSharedPreferences) {
        this.mSharedPreferences = mSharedPreferences;
    }

    /**
     * Saves the given {@link SharedPreferenceEntry} that contains the user's settings to
     * {@link SharedPreferences}.
     *
     * @param sharedPreferenceEntry contains data to save to {@link SharedPreferences}.
     * @return {@code true} if writing to {@link SharedPreferences} succeeded. {@code false}
     *         otherwise.
     */
    public boolean savePersonalInfo(SharedPreferenceEntry sharedPreferenceEntry){
        //start the shared prefrences transaction.
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(KEY_EMAIL, sharedPreferenceEntry.getmEmail());
        return editor.commit();
    }

    /**
     * Retrieves the {@link SharedPreferenceEntry} containing the user's personal information from
     * {@link SharedPreferences}.
     *
     * @return the Retrieved {@link SharedPreferenceEntry}.
     */
    public SharedPreferenceEntry getPersonalInfo() {
        // Get data from the SharedPreferences.
        String email = mSharedPreferences.getString(KEY_EMAIL, "");

        // Create and fill a SharedPreferenceEntry model object.
        return new SharedPreferenceEntry(email);
    }

}
