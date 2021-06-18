/*
 * Copyright 2016-2019 Paranoid Android
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

package com.android.settings.deviceinfo.firmwareversion;

import android.content.Context;
import android.os.SystemProperties;

import com.android.settings.R;
import com.android.settings.core.BasePreferenceController;

public class SpiceOSAndroidVersionPreferenceController extends BasePreferenceController {

    private static final String SPICEOS_VERSION_FLAVOR_PROP = "ro.spiceos.version.flavor";
    private static final String SPICEOS_VERSION_CODE_PROP = "ro.spiceos.version.code";
    private static final String SPICEOS_BUILD_VARIANT_PROP = "ro.spiceos.build.variant";

    private final Context mContext;

    public SpiceOSAndroidVersionPreferenceController(Context context, String key) {
        super(context, key);
        mContext = context;
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE_UNSEARCHABLE;
    }

    @Override
    public CharSequence getSummary() {
        String spiceosVersionFlavor = SystemProperties.get(SPICEOS_VERSION_FLAVOR_PROP,
                mContext.getResources().getString(R.string.device_info_default));
        String spiceosVersionCode = SystemProperties.get(SPICEOS_VERSION_CODE_PROP,
               mContext.getResources().getString(R.string.device_info_default));
        String spiceosBuildVariant = SystemProperties.get(SPICEOS_BUILD_VARIANT_PROP,
              mContext.getResources().getString(R.string.device_info_default));

        if ((spiceosBuildVariant.equals("OFFICIAL")) || (spiceosBuildVariant.equals("UNOFFICIAL"))) {
           return spiceosVersionFlavor + " " + spiceosVersionCode + " " + spiceosBuildVariant;
        } else {
           return spiceosVersionFlavor + " " + spiceosVersionCode;
        }
    }
}
