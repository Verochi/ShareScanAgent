package com.xiaomi.push;

/* loaded from: classes19.dex */
public class ew implements java.lang.Cloneable {
    public static java.lang.String a = "wcc-ml-test10.bj";
    public static final java.lang.String b = com.xiaomi.push.i.b;
    public static java.lang.String c;
    public java.lang.String d;
    public java.lang.String g;
    private java.lang.String h;
    public boolean f = com.xiaomi.push.ev.a;
    private boolean i = true;
    int e = 5222;
    private com.xiaomi.push.fa j = null;

    public ew(java.lang.String str) {
        this.h = str;
    }

    public static final java.lang.String a() {
        java.lang.String str = c;
        return str != null ? str : com.xiaomi.push.f.a() ? "sandbox.xmpush.xiaomi.com" : com.xiaomi.push.f.b() ? b : "app.chat.xiaomi.net";
    }

    public static final void a(java.lang.String str) {
        if (com.xiaomi.push.iu.a(com.xiaomi.push.jc.a()) && com.xiaomi.push.f.b()) {
            return;
        }
        c = str;
    }

    public byte[] b() {
        return null;
    }

    public final java.lang.String c() {
        if (this.d == null) {
            this.d = a();
        }
        return this.d;
    }
}
