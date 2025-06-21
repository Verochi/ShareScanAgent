package com.airbnb.lottie;

/* loaded from: classes.dex */
public class LottieImageAsset {
    public final int a;
    public final int b;
    public final java.lang.String c;
    public final java.lang.String d;
    public final java.lang.String e;

    @androidx.annotation.Nullable
    public android.graphics.Bitmap f;

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public LottieImageAsset(int i, int i2, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.a = i;
        this.b = i2;
        this.c = str;
        this.d = str2;
        this.e = str3;
    }

    @androidx.annotation.Nullable
    public android.graphics.Bitmap getBitmap() {
        return this.f;
    }

    public java.lang.String getDirName() {
        return this.e;
    }

    public java.lang.String getFileName() {
        return this.d;
    }

    public int getHeight() {
        return this.b;
    }

    public java.lang.String getId() {
        return this.c;
    }

    public int getWidth() {
        return this.a;
    }

    public boolean hasBitmap() {
        return this.f != null || (this.d.startsWith("data:") && this.d.indexOf("base64,") > 0);
    }

    public void setBitmap(@androidx.annotation.Nullable android.graphics.Bitmap bitmap) {
        this.f = bitmap;
    }
}
