package com.meizu.cloud.pushsdk.platform.a;

/* loaded from: classes23.dex */
public class b {
    private static com.meizu.cloud.pushsdk.platform.a.b a;
    private java.util.concurrent.ScheduledExecutorService b;
    private final android.content.Context c;
    private final com.meizu.cloud.pushsdk.platform.a.a d;
    private final com.meizu.cloud.pushsdk.platform.b.b e;
    private final com.meizu.cloud.pushsdk.platform.b.g f;
    private final com.meizu.cloud.pushsdk.platform.b.f g;
    private final com.meizu.cloud.pushsdk.platform.b.e h;
    private final com.meizu.cloud.pushsdk.platform.b.d i;
    private final boolean j;

    public b(android.content.Context context, boolean z) {
        this(context, z, true);
    }

    public b(android.content.Context context, boolean z, boolean z2) {
        android.content.Context applicationContext = context.getApplicationContext();
        this.c = applicationContext;
        com.meizu.cloud.pushsdk.platform.a.a aVar = new com.meizu.cloud.pushsdk.platform.a.a(applicationContext);
        this.d = aVar;
        if (z) {
            this.b = (java.util.concurrent.ScheduledExecutorService) com.meizu.cloud.pushsdk.d.b.a.b.a();
        }
        this.j = z2;
        this.e = new com.meizu.cloud.pushsdk.platform.b.b(applicationContext, aVar, this.b, z2);
        this.f = new com.meizu.cloud.pushsdk.platform.b.g(applicationContext, aVar, this.b, z2);
        this.g = new com.meizu.cloud.pushsdk.platform.b.f(applicationContext, aVar, this.b, z2);
        this.h = new com.meizu.cloud.pushsdk.platform.b.e(applicationContext, aVar, this.b, z2);
        this.i = new com.meizu.cloud.pushsdk.platform.b.d(applicationContext, aVar, this.b, z2);
    }

    public static com.meizu.cloud.pushsdk.platform.a.b a(android.content.Context context) {
        if (a == null) {
            synchronized (com.meizu.cloud.pushsdk.platform.a.b.class) {
                if (a == null) {
                    a = new com.meizu.cloud.pushsdk.platform.a.b(context, true);
                }
            }
        }
        return a;
    }

    public com.meizu.cloud.pushsdk.c.a.c<java.lang.String> a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.io.File file) {
        return this.d.a(str, str2, str3, file);
    }

    public void a(boolean z) {
        this.e.a(z);
        this.f.a(z);
        this.g.a(z);
        this.i.a(z);
        this.h.a(z);
    }

    public boolean a(java.lang.String str) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.c, this.b, this.j);
        aVar.a(0);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(java.lang.String str, java.lang.String str2) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.c, this.b, this.j);
        aVar.a(2);
        aVar.a(str2);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.e.b(str);
        this.e.c(str2);
        this.e.d(str3);
        return this.e.m();
    }

    public boolean a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        this.g.b(str);
        this.g.c(str2);
        this.g.d(str3);
        this.g.a(str4);
        this.g.a(2);
        return this.g.m();
    }

    public boolean a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, int i, boolean z) {
        this.g.b(str);
        this.g.c(str2);
        this.g.d(str3);
        this.g.a(str4);
        this.g.a(i);
        this.g.b(z);
        return this.g.m();
    }

    public boolean a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        this.h.b(str);
        this.h.c(str2);
        this.h.d(str3);
        this.h.e(str4);
        this.h.a(0);
        this.h.a(str5);
        return this.h.m();
    }

    public boolean a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, boolean z) {
        this.g.b(str);
        this.g.c(str2);
        this.g.d(str3);
        this.g.a(str4);
        this.g.a(3);
        this.g.b(z);
        return this.g.m();
    }

    public boolean a(java.lang.String str, int... iArr) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.c, this.b, this.j);
        aVar.a(iArr);
        aVar.d(str);
        aVar.a(1);
        return aVar.m();
    }

    public boolean b(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.f.b(str);
        this.f.c(str2);
        this.f.d(str3);
        return this.f.m();
    }

    public boolean b(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        this.h.b(str);
        this.h.c(str2);
        this.h.d(str3);
        this.h.e(str4);
        this.h.a(2);
        return this.h.m();
    }

    public boolean b(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        this.h.b(str);
        this.h.c(str2);
        this.h.d(str3);
        this.h.e(str4);
        this.h.a(1);
        this.h.a(str5);
        return this.h.m();
    }

    public boolean c(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        this.h.b(str);
        this.h.c(str2);
        this.h.d(str3);
        this.h.e(str4);
        this.h.a(3);
        return this.h.m();
    }

    public boolean c(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        this.i.b(str);
        this.i.c(str2);
        this.i.d(str3);
        this.i.e(str4);
        this.i.a(0);
        this.i.a(str5);
        return this.i.m();
    }

    public boolean d(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        this.i.b(str);
        this.i.c(str2);
        this.i.d(str3);
        this.i.e(str4);
        this.i.a(2);
        return this.i.m();
    }

    public boolean d(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        this.i.b(str);
        this.i.c(str2);
        this.i.d(str3);
        this.i.e(str4);
        this.i.a(1);
        this.i.a(str5);
        return this.i.m();
    }
}
