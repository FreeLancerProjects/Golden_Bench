package com.endpoint.golden_bench.share;


import android.content.Context;

import androidx.multidex.MultiDexApplication;

import com.endpoint.golden_bench.language.Language;
import com.endpoint.golden_bench.preferences.Preferences;


public class App extends MultiDexApplication {
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(Language.updateResources(newBase, Preferences.getInstance().getLanguage(newBase)));    }
    @Override
    public void onCreate() {
        super.onCreate();
        TypefaceUtil.overrideFont(this, "SERIF", "font/Ara Hamah Kilania_0.ttf"); // font from assets: "assets/fonts/Roboto-Regular.ttf
        TypefaceUtil.overrideFont(this, "DEFAULT", "font/Ara Hamah Kilania_0.ttf");
        TypefaceUtil.overrideFont(this, "MONOSPACE", "font/Ara Hamah Kilania_0.ttf");
        TypefaceUtil.overrideFont(this, "SANS_SERIF", "font/Ara Hamah Kilania_0.ttf");
    }
}

