package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public enum CpuLpFontSize {
    SMALL("sml"),
    REGULAR("reg"),
    LARGE("lrg"),
    EXTRA_LARGE("xlg"),
    XX_LARGE("xxl");

    java.lang.String mValue;

    CpuLpFontSize(java.lang.String str) {
        this.mValue = str;
    }

    public java.lang.String getValue() {
        return this.mValue;
    }
}
