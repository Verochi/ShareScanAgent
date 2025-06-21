package com.qq.e.ads.hybrid;

/* loaded from: classes19.dex */
public class HybridADSetting {
    public static final int TYPE_REWARD_VIDEO = 1;
    private java.lang.String f;
    private java.lang.String g;
    private java.lang.String h;
    private int a = 1;
    private int b = 44;
    private int c = -1;
    private int d = -14013133;
    private int e = 16;
    private int i = -1776153;
    private int j = 16;

    public com.qq.e.ads.hybrid.HybridADSetting backButtonImage(java.lang.String str) {
        this.g = str;
        return this;
    }

    public com.qq.e.ads.hybrid.HybridADSetting backSeparatorLength(int i) {
        this.j = i;
        return this;
    }

    public com.qq.e.ads.hybrid.HybridADSetting closeButtonImage(java.lang.String str) {
        this.h = str;
        return this;
    }

    public java.lang.String getBackButtonImage() {
        return this.g;
    }

    public int getBackSeparatorLength() {
        return this.j;
    }

    public java.lang.String getCloseButtonImage() {
        return this.h;
    }

    public int getSeparatorColor() {
        return this.i;
    }

    public java.lang.String getTitle() {
        return this.f;
    }

    public int getTitleBarColor() {
        return this.c;
    }

    public int getTitleBarHeight() {
        return this.b;
    }

    public int getTitleColor() {
        return this.d;
    }

    public int getTitleSize() {
        return this.e;
    }

    public int getType() {
        return this.a;
    }

    public com.qq.e.ads.hybrid.HybridADSetting separatorColor(int i) {
        this.i = i;
        return this;
    }

    public com.qq.e.ads.hybrid.HybridADSetting title(java.lang.String str) {
        this.f = str;
        return this;
    }

    public com.qq.e.ads.hybrid.HybridADSetting titleBarColor(int i) {
        this.c = i;
        return this;
    }

    public com.qq.e.ads.hybrid.HybridADSetting titleBarHeight(int i) {
        this.b = i;
        return this;
    }

    public com.qq.e.ads.hybrid.HybridADSetting titleColor(int i) {
        this.d = i;
        return this;
    }

    public com.qq.e.ads.hybrid.HybridADSetting titleSize(int i) {
        this.e = i;
        return this;
    }

    public com.qq.e.ads.hybrid.HybridADSetting type(int i) {
        this.a = i;
        return this;
    }
}
