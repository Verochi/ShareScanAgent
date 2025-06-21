package com.anythink.expressad.foundation.g.g;

/* loaded from: classes12.dex */
public abstract class a implements java.lang.Runnable {
    public static long b;
    public com.anythink.expressad.foundation.g.g.a.EnumC0213a c = com.anythink.expressad.foundation.g.g.a.EnumC0213a.READY;
    public com.anythink.expressad.foundation.g.g.a.b d;

    /* renamed from: com.anythink.expressad.foundation.g.g.a$a, reason: collision with other inner class name */
    public enum EnumC0213a {
        READY,
        RUNNING,
        PAUSE,
        CANCEL,
        FINISH
    }

    public interface b {
        void a(com.anythink.expressad.foundation.g.g.a.EnumC0213a enumC0213a);
    }

    public a() {
        b++;
    }

    private void a(com.anythink.expressad.foundation.g.g.a.EnumC0213a enumC0213a) {
        this.c = enumC0213a;
        com.anythink.expressad.foundation.g.g.a.b bVar = this.d;
        if (bVar != null) {
            bVar.a(enumC0213a);
        }
    }

    private void a(com.anythink.expressad.foundation.g.g.a.b bVar) {
        this.d = bVar;
    }

    private com.anythink.expressad.foundation.g.g.a.EnumC0213a d() {
        return this.c;
    }

    public static long e() {
        return b;
    }

    public abstract void a();

    public abstract void b();

    public abstract void c();

    public final void f() {
        com.anythink.expressad.foundation.g.g.a.EnumC0213a enumC0213a = this.c;
        com.anythink.expressad.foundation.g.g.a.EnumC0213a enumC0213a2 = com.anythink.expressad.foundation.g.g.a.EnumC0213a.CANCEL;
        if (enumC0213a != enumC0213a2) {
            a(enumC0213a2);
        }
    }

    public final void g() {
        com.anythink.expressad.foundation.g.g.a.EnumC0213a enumC0213a = this.c;
        if (enumC0213a == com.anythink.expressad.foundation.g.g.a.EnumC0213a.PAUSE || enumC0213a == com.anythink.expressad.foundation.g.g.a.EnumC0213a.CANCEL || enumC0213a == com.anythink.expressad.foundation.g.g.a.EnumC0213a.FINISH) {
            return;
        }
        a(com.anythink.expressad.foundation.g.g.a.EnumC0213a.RUNNING);
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.c == com.anythink.expressad.foundation.g.g.a.EnumC0213a.READY) {
                a(com.anythink.expressad.foundation.g.g.a.EnumC0213a.RUNNING);
                a();
                a(com.anythink.expressad.foundation.g.g.a.EnumC0213a.FINISH);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
