/*
 * Copyright (C) 2018 The Superior OS Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.spiceos.settings.fragments;

import android.content.Context;
import android.content.ContentResolver;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.preference.SwitchPreference;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import androidx.preference.PreferenceCategory;
import androidx.preference.Preference.OnPreferenceChangeListener;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.widget.ListView;
import android.view.View;
import android.view.ViewGroup;

import com.android.settings.SettingsPreferenceFragment;
import com.android.internal.logging.nano.MetricsProto;
import com.android.settingslib.search.SearchIndexable;
import com.android.settings.search.BaseSearchIndexProvider;
import java.util.List;
import java.util.ArrayList;
import com.spiceos.settings.fragments.misc.PulseSettings;
import com.android.settings.R;
import com.spiceos.settings.fragments.misc.SmartCharging;

@SearchIndexable
public class MiscSettings extends SettingsPreferenceFragment implements
        Preference.OnPreferenceChangeListener {

    private static final String SMART_CHARGING = "smart_charging";
    private Preference mSmartCharging;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.spiceos_settings_misc);
        ContentResolver resolver = getActivity().getContentResolver();
        final PreferenceScreen prefScreen = getPreferenceScreen();
        final Resources res = getResources();

        mSmartCharging = (Preference) prefScreen.findPreference(SMART_CHARGING);
    boolean mSmartChargingSupported = res.getBoolean(
        com.android.internal.R.bool.config_smartChargingAvailable);
    if (!mSmartChargingSupported)
        prefScreen.removePreference(mSmartCharging);
    }

    @Override
    public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.SPICEOS_SETTINGS;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    public boolean onPreferenceChange(Preference preference, Object newValue) {
        return false;
    }

    public static final BaseSearchIndexProvider SEARCH_INDEX_DATA_PROVIDER =
            new BaseSearchIndexProvider(R.xml.spiceos_settings_misc) {
    @Override
    public List<String> getNonIndexableKeys(Context context) {
    List<String> keys = super.getNonIndexableKeys(context);
    final Resources res = context.getResources();

    boolean mSmartChargingSupported = res.getBoolean(
            com.android.internal.R.bool.config_smartChargingAvailable);
    if (!mSmartChargingSupported)
        keys.add(SMART_CHARGING);
          return keys;
      }
};
}
