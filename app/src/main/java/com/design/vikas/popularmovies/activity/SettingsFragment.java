package com.design.vikas.popularmovies.activity;

import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.design.vikas.popularmovies.R;

/**
 * Created by vikas kumar on 6/19/2016.
 */
public class SettingsFragment extends PreferenceFragment {

    public static String SORT_ORDER = "sort_order";
    ListPreference listPreference;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        listPreference = (ListPreference)findPreference(SORT_ORDER);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
