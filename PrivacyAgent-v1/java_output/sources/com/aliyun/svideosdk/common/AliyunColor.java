package com.aliyun.svideosdk.common;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AliyunColor extends com.aliyun.svideosdk.common.AliyunObject {
    private int a;
    private int b;
    private int g;
    private int r;

    public AliyunColor(int i) {
        int i2 = (i >> 24) & 255;
        this.a = i2;
        int i3 = (i >> 16) & 255;
        this.r = i3;
        int i4 = (i >> 8) & 255;
        this.g = i4;
        int i5 = i & 255;
        this.b = i5;
        if ((i3 > 0 || i4 > 0 || i5 > 0) && i2 <= 0) {
            this.a = 255;
        }
    }

    public AliyunColor(int i, int i2, int i3, int i4) {
        this.r = i;
        this.g = i2;
        this.b = i3;
        this.a = i4;
    }

    public void setAlpha(int i) {
        this.a = i;
    }

    public int toArgb() {
        return android.graphics.Color.argb(this.a, this.r, this.g, this.b);
    }
}
