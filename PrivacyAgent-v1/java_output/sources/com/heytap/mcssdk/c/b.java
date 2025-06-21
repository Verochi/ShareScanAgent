package com.heytap.mcssdk.c;

/* loaded from: classes22.dex */
public class b extends com.heytap.msp.push.mode.BaseMode {
    private static final java.lang.String a = "&";
    private java.lang.String b;
    private java.lang.String c;
    private java.lang.String d;
    private java.lang.String e;
    private int f;
    private java.lang.String g;
    private int h = -2;
    private java.lang.String i;

    public static <T> java.lang.String a(java.util.List<T> list) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.util.Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append("&");
        }
        return sb.toString();
    }

    public java.lang.String a() {
        return this.b;
    }

    public void a(int i) {
        this.f = i;
    }

    public void a(java.lang.String str) {
        this.b = str;
    }

    public java.lang.String b() {
        return this.c;
    }

    public void b(int i) {
        this.h = i;
    }

    public void b(java.lang.String str) {
        this.c = str;
    }

    public java.lang.String c() {
        return this.d;
    }

    public void c(java.lang.String str) {
        this.d = str;
    }

    public java.lang.String d() {
        return this.e;
    }

    public void d(java.lang.String str) {
        this.e = str;
    }

    public int e() {
        return this.f;
    }

    public void e(java.lang.String str) {
        this.g = str;
    }

    public java.lang.String f() {
        return this.g;
    }

    public void f(java.lang.String str) {
        this.i = str;
    }

    public int g() {
        return this.h;
    }

    @Override // com.heytap.msp.push.mode.BaseMode
    public int getType() {
        return 4105;
    }

    public java.lang.String h() {
        return this.i;
    }

    public java.lang.String toString() {
        return "CallBackResult{, mRegisterID='" + this.d + "', mSdkVersion='" + this.e + "', mCommand=" + this.f + "', mContent='" + this.g + "', mAppPackage=" + this.i + "', mResponseCode=" + this.h + '}';
    }
}
