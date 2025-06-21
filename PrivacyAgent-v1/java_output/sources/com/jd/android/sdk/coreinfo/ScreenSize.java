package com.jd.android.sdk.coreinfo;

/* loaded from: classes23.dex */
public class ScreenSize {
    public int heightPixels;
    public int widthPixels;

    public ScreenSize(int i, int i2) {
        this.widthPixels = i;
        this.heightPixels = i2;
    }

    public java.lang.String toString() {
        return this.widthPixels + "," + this.heightPixels;
    }
}
