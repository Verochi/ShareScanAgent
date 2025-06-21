package com.igexin.push.core.i;

/* loaded from: classes23.dex */
public abstract class a {
    protected java.lang.Long a = java.lang.Long.valueOf(java.lang.System.currentTimeMillis());
    protected android.app.Activity b;
    protected java.lang.String c;

    private void a(java.lang.Long l) {
        this.a = l;
    }

    private void a(java.lang.String str) {
        this.c = str;
    }

    private android.app.Activity m() {
        return this.b;
    }

    private java.lang.String n() {
        return this.c;
    }

    public final java.lang.Long a() {
        return this.a;
    }

    public final void a(android.app.Activity activity) {
        this.b = activity;
    }

    public abstract void b();

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract void h();

    public abstract boolean i();

    public abstract void j();

    public abstract boolean k();

    public abstract void l();
}
