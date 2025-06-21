package com.alimm.tanx.core.utils;

/* loaded from: classes.dex */
public class AssetsUtil implements com.alimm.tanx.core.utils.NotConfused {
    public static android.content.res.AssetManager getApplicationAssets(android.content.Context context) {
        if (context != null) {
            return context.getApplicationContext().getAssets();
        }
        return null;
    }
}
