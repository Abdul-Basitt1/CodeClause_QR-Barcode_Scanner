package com.czlucius.scan.preferences;

import android.content.Context;
import android.content.SharedPreferences;

public class Settings {
    private final SharedPreferences globalPrefs;
    private static Settings INSTANCE;

    private static final String SHOULD_SHOW_ONBOARDING = "SHOULD_SHOW_ONBOARDING";

    private Settings(Context context) {
        this.globalPrefs = context.getApplicationContext().getSharedPreferences("APP_PREF_VALS", Context.MODE_PRIVATE);
    }

    public static Settings getInstance(Context appCtx) {
        if (INSTANCE == null) {
            INSTANCE = new Settings(appCtx);
        }
        return INSTANCE;
    }


    public boolean getShouldShowOnboarding() {
        return globalPrefs.getBoolean(SHOULD_SHOW_ONBOARDING, true);
    }

    public void setShouldShowOnboarding(boolean value) {
        globalPrefs.edit()
                .putBoolean(SHOULD_SHOW_ONBOARDING, value)
                .apply();
    }


}
