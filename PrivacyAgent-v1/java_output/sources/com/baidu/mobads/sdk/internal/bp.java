package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public enum bp {
    INTERFACE_USE_PROBLEM(1010001, "接口使用问题"),
    SHOW_STANDARD_UNFIT(3040001, "容器大小不达标");

    public static final java.lang.String c = "msg";
    private int d;
    private java.lang.String e;

    bp(int i, java.lang.String str) {
        this.d = i;
        this.e = str;
    }

    public int b() {
        return this.d;
    }

    public java.lang.String c() {
        return this.e;
    }
}
