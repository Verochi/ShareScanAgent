package com.anythink.expressad.foundation.h;

/* loaded from: classes12.dex */
public class d {
    private static void a() {
    }

    public static void a(android.content.Context context) {
        if (context == null) {
            return;
        }
        try {
            com.anythink.expressad.atsignalcommon.webEnvCheck.WebEnvCheckEntry.class.getMethod("check", android.content.Context.class).invoke(com.anythink.expressad.atsignalcommon.webEnvCheck.WebEnvCheckEntry.class.newInstance(), context);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
