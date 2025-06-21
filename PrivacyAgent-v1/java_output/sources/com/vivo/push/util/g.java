package com.vivo.push.util;

/* loaded from: classes19.dex */
public final class g {
    public static void a(java.lang.String str) {
        if (com.vivo.push.util.p.a() && android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("Operation: ");
            sb.append(str);
            sb.append(" in main thread!");
            new java.lang.Throwable();
        }
    }
}
