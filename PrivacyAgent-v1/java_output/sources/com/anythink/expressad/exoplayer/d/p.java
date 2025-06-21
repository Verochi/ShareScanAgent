package com.anythink.expressad.exoplayer.d;

/* loaded from: classes12.dex */
public final class p {
    public static final java.lang.String a = "LicenseDurationRemaining";
    public static final java.lang.String b = "PlaybackDurationRemaining";

    private p() {
    }

    private static long a(java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str) {
        if (map == null) {
            return -9223372036854775807L;
        }
        try {
            java.lang.String str2 = map.get(str);
            if (str2 != null) {
                return java.lang.Long.parseLong(str2);
            }
            return -9223372036854775807L;
        } catch (java.lang.NumberFormatException unused) {
            return -9223372036854775807L;
        }
    }

    public static android.util.Pair<java.lang.Long, java.lang.Long> a(com.anythink.expressad.exoplayer.d.f<?> fVar) {
        java.util.Map<java.lang.String, java.lang.String> h = fVar.h();
        if (h == null) {
            return null;
        }
        return new android.util.Pair<>(java.lang.Long.valueOf(a(h, "LicenseDurationRemaining")), java.lang.Long.valueOf(a(h, "PlaybackDurationRemaining")));
    }
}
