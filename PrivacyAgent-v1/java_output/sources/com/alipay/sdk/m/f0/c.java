package com.alipay.sdk.m.f0;

/* loaded from: classes.dex */
public class c extends com.alipay.sdk.m.f0.a {
    public static final int l = 1;
    public static final int m = 2;
    public static final int n = 3;
    public static final java.lang.String o = "APPKEY_ERROR";
    public static final java.lang.String p = "SUCCESS";
    public java.lang.String c;
    public java.lang.String d;
    public java.lang.String e;
    public java.lang.String f;
    public java.lang.String g;
    public java.lang.String h;
    public java.lang.String i;
    public java.lang.String j;
    public java.lang.String k = "";

    public java.lang.String a() {
        java.lang.String str = this.f;
        return str == null ? "0" : str;
    }

    public boolean b() {
        return "1".equals(this.e);
    }

    public int c() {
        return this.a ? com.alipay.sdk.m.z.a.a(this.c) ? 2 : 1 : o.equals(this.b) ? 3 : 2;
    }
}
