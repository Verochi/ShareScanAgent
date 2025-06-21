package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
public final class ExoPlayerLibraryInfo {
    public static final boolean ASSERTIONS_ENABLED = true;
    public static final java.lang.String DEFAULT_USER_AGENT;
    public static final boolean GL_ASSERTIONS_ENABLED = false;
    public static final java.lang.String TAG = "ExoPlayer";
    public static final boolean TRACE_ENABLED = true;
    public static final java.lang.String VERSION = "2.12.1";
    public static final int VERSION_INT = 2012001;
    public static final java.lang.String VERSION_SLASHY = "ExoPlayerLib/2.12.1";
    public static final java.util.HashSet<java.lang.String> a;
    public static java.lang.String b;

    static {
        java.lang.String str = android.os.Build.VERSION.RELEASE;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 56);
        sb.append("ExoPlayerLib/2.12.1 (Linux;Android ");
        sb.append(str);
        sb.append(") ");
        sb.append(VERSION_SLASHY);
        DEFAULT_USER_AGENT = sb.toString();
        a = new java.util.HashSet<>();
        b = "goog.exo.core";
    }

    public static synchronized void registerModule(java.lang.String str) {
        synchronized (com.google.android.exoplayer2.ExoPlayerLibraryInfo.class) {
            if (a.add(str)) {
                java.lang.String str2 = b;
                java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str2).length() + 2 + java.lang.String.valueOf(str).length());
                sb.append(str2);
                sb.append(", ");
                sb.append(str);
                b = sb.toString();
            }
        }
    }

    public static synchronized java.lang.String registeredModules() {
        java.lang.String str;
        synchronized (com.google.android.exoplayer2.ExoPlayerLibraryInfo.class) {
            str = b;
        }
        return str;
    }
}
