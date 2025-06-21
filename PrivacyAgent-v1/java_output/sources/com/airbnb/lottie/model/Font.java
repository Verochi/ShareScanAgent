package com.airbnb.lottie.model;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class Font {
    public final java.lang.String a;
    public final java.lang.String b;
    public final java.lang.String c;
    public final float d;

    public Font(java.lang.String str, java.lang.String str2, java.lang.String str3, float f) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = f;
    }

    public java.lang.String getFamily() {
        return this.a;
    }

    public java.lang.String getName() {
        return this.b;
    }

    public java.lang.String getStyle() {
        return this.c;
    }
}
