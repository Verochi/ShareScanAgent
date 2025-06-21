package com.anythink.expressad.exoplayer;

/* loaded from: classes12.dex */
public final class l {
    public static final java.lang.String a = "ExoPlayer";
    public static final java.lang.String b = "2.8.4";
    public static final java.lang.String c = "ExoPlayerLib/2.8.4";
    public static final int d = 2008004;
    public static final boolean e = true;
    public static final boolean f = true;
    private static final java.util.HashSet<java.lang.String> g = new java.util.HashSet<>();
    private static java.lang.String h = "goog.exo.core";

    private l() {
    }

    public static synchronized java.lang.String a() {
        java.lang.String str;
        synchronized (com.anythink.expressad.exoplayer.l.class) {
            str = h;
        }
        return str;
    }

    private static synchronized void a(java.lang.String str) {
        synchronized (com.anythink.expressad.exoplayer.l.class) {
            if (g.add(str)) {
                h += ", " + str;
            }
        }
    }
}
