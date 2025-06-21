package com.airbnb.lottie.model;

/* loaded from: classes.dex */
public class Marker {
    public static java.lang.String b = "\r";
    public final java.lang.String a;
    public final float durationFrames;
    public final float startFrame;

    public Marker(java.lang.String str, float f, float f2) {
        this.a = str;
        this.durationFrames = f2;
        this.startFrame = f;
    }

    public boolean matchesName(java.lang.String str) {
        if (this.a.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.a.endsWith(b)) {
            java.lang.String str2 = this.a;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
