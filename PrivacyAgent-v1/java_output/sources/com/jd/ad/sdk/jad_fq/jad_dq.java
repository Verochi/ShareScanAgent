package com.jd.ad.sdk.jad_fq;

/* loaded from: classes23.dex */
public class jad_dq {
    public static boolean jad_an(android.content.Context context) {
        if (context == null) {
            return false;
        }
        if (!(context instanceof android.app.Activity)) {
            return true;
        }
        android.app.Activity activity = (android.app.Activity) context;
        return (activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }
}
