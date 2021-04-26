<?xml version="1.0" encoding="utf-8"?>
<!--
     Copyright (C) 2016-2020 spiceos Android Project

     Licensed under the Apache License, Version 2.0 (the "License");
     you may not use this file except in compliance with the License.
     You may obtain a copy of the License at

          http://www.apache.org/licenses/LICENSE-2.0

     Unless required by applicable law or agreed to in writing, software
     distributed under the License is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
     See the License for the specific language governing permissions and
     limitations under the License.
-->
<PreferenceScreen
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:lineage="http://schemas.android.com/apk/res/lineageos.platform"
    xmlns:settings="http://schemas.android.com/apk/res/com.android.settings">

    <SwitchPreference
        android:key="navbar_visibility"
        android:icon="@drawable/ic_navbar"
        android:title="@string/navbar_visibility"
        android:summary="@string/navbar_visibility_summary" />

    <Preference
        android:key="stock_settings"
        android:icon="@drawable/ic_shapes"
        android:title="@string/navbar_settings_title"
        android:dependency="navbar_visibility"
        android:summary="@string/navbar_settings_summary"
        android:fragment="com.spiceos.settings.fragments.navigation.StockNavBarSettings" />

    <!-- PIE
    <Preference
        android:key="pie_settings"
        android:icon="@drawable/ic_pie"
        android:title="@string/pie_settings"
        android:summary="@string/pie_settings_summary"
        android:fragment="com.spiceos.settings.fragments.navigation.PieSettings" /> -->

    <!--<PreferenceCategory
        android:key="category_navbar_interface"
        android:title="@string/navbar_interface_title" >

       <com.spiceos.settings.preferences.SecureSettingListPreference
            android:key="navigation_bar_mode"
            android:icon="@drawable/ic_navbar_mode"
            android:title="@string/navbar_mode"
            android:summary="@string/navbar_mode_summary"
            android:entries="@array/systemui_navbar_mode_entries"
            android:entryValues="@array/systemui_navbar_mode_values"
            android:dependency="navbar_visibility"
            android:defaultValue="0"/>

        <Preference
            android:key="smartbar_settings"
            android:icon="@drawable/ic_smartbar"
            android:title="@string/smartbar_settings_title"
            android:summary="@string/smartbar_settings_summary"
            android:dependency="navbar_visibility"
            android:fragment="com.spiceos.settings.fragments.navigation.smartnav.SmartbarSettings" />

        <Preference
            android:key="fling_settings"
            android:icon="@drawable/ic_fling"
            android:title="@string/fling_settings"
            android:summary="@string/fling_settings_summary"
            android:dependency="navbar_visibility"
            android:fragment="com.spiceos.settings.fragments.navigation.smartnav.FlingSettings" />

        <com.spiceos.settings.preferences.CustomSeekBarPreference
            android:key="navbar_height_portrait"
            android:icon="@drawable/ic_bar"
            android:title="@string/portrait_title"
            android:max="135"
            settings:min="65"
            settings:units="%"
            android:dependency="navbar_visibility" />

        <com.spiceos.settings.preferences.CustomSeekBarPreference
            android:key="navbar_height_landscape"
            android:icon="@drawable/ic_bar"
            android:title="@string/land_hor_title"
            android:max="135"
            settings:min="65"
            settings:units="%"
            android:dependency="navbar_visibility" />

        <com.spiceos.settings.preferences.CustomSeekBarPreference
            android:key="navbar_width"
            android:icon="@drawable/ic_bar"
            android:title="@string/land_vert_title"
            android:max="135"
            settings:min="65"
            settings:units="%"
            android:dependency="navbar_visibility" />
    </PreferenceCategory>-->

    <!-- Gestures -->
    <PreferenceCategory
        android:key="navbar_gestures_category"
        android:title="@string/gestures_title">

        <!--<com.spiceos.settings.preferences.SecureSettingSwitchPreference
            android:key="one_handed_mode_ui"
            android:icon="@drawable/ic_gesture_swipe_horizontal"
            android:title="@string/one_handed_mode_title"
            android:summary="@string/one_handed_mode_summary"
            android:defaultValue="false" />

        <PreferenceScreen
            android:key="carbon_gestures"
            android:icon="@drawable/ic_gesture_swipe_horizontal"
            android:fragment="com.spiceos.settings.fragments.navigation.CarbonGesturesSettings"
            android:title="@string/carbon_gesture_preference_title"
            android:summary="@string/carbon_gestures_summary" />

        <PreferenceScreen
            android:key="swipeup_gestures"
            android:icon="@drawable/ic_gesture_swipe_up"
            android:fragment="com.spiceos.settings.fragments.navigation.SwipeUpGesturesSettings"
            android:title="@string/use_bottom_gesture_title"
            android:summary="@string/use_bottom_gesture_summary" />

        <PreferenceScreen
            android:key="edge_gestures"
            android:title="@string/edge_gestures_title"
            android:summary="@string/edge_gestures_summary"
            android:fragment="com.spiceos.settings.fragments.navbar.EdgeGestureSettings" />-->

        <org.lineageos.internal.lineageparts.LineagePartsPreference
            android:key="touchscreen_gesture_settings"
            android:icon="@drawable/ic_double_tap"
            lineage:requiresFeature="lineagehardware:FEATURE_TOUCHSCREEN_GESTURES" />

        <!--<lineageos.preference.RemotePreference
            android:key="device_touchscreen_gesture_settings"
            android:icon="@drawable/ic_double_tap"
            android:title="@string/touchscreen_gesture_settings_title"
            android:summary="@string/touchscreen_gesture_settings_summary"
            lineage:replacesKey="touchscreen_gesture_settings"
            lineage:requiresFeature="lineagehardware:FEATURE_TOUCHSCREEN_GESTURES">
                <intent android:action="org.lineageos.settings.device.GESTURE_SETTINGS" />
        </lineageos.preference.RemotePreference>-->

        <Preference
            android:key="system_gesture_settings"
            android:icon="@drawable/ic_settings_gestures"
            android:title="@string/system_gestures_title"
            android:summary="@string/system_gestures_summary"
            android:fragment="com.android.settings.gestures.GestureSettings"
            settings:controller="com.android.settings.gestures.GesturesSettingPreferenceController"/>

        <!--<com.spiceos.settings.preferences.SystemSettingSwitchPreference
            android:key="double_tap_sleep_navbar"
            android:icon="@drawable/ic_double_tap"
            android:title="@string/smartbar_doubletap_sleep_title"
            android:summary="@string/smartbar_doubletap_sleep_summary"
            android:dependency="navbar_visibility"
            android:defaultValue="false" />-->
    </PreferenceCategory>

    <!--<PreferenceCategory
        android:key="category_navbar_general"
        android:title="@string/navbar_general_title" >

        <SwitchPreference
            android:key="navbar_dynamic"
            android:icon="@drawable/ic_color_bucket"
            android:title="@string/navbar_dynamic_title"
            android:summary="@string/navbar_dynamic_summary"
            android:defaultValue="false"/>
    </PreferenceCategory>-->
</PreferenceScreen>
