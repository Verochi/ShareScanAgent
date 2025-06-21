package com.airbnb.lottie.model;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class FontCharacter {
    public final java.util.List<com.airbnb.lottie.model.content.ShapeGroup> a;
    public final char b;
    public final double c;
    public final double d;
    public final java.lang.String e;
    public final java.lang.String f;

    public FontCharacter(java.util.List<com.airbnb.lottie.model.content.ShapeGroup> list, char c, double d, double d2, java.lang.String str, java.lang.String str2) {
        this.a = list;
        this.b = c;
        this.c = d;
        this.d = d2;
        this.e = str;
        this.f = str2;
    }

    public static int hashFor(char c, java.lang.String str, java.lang.String str2) {
        return ((((0 + c) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public java.util.List<com.airbnb.lottie.model.content.ShapeGroup> getShapes() {
        return this.a;
    }

    public double getWidth() {
        return this.d;
    }

    public int hashCode() {
        return hashFor(this.b, this.f, this.e);
    }
}
