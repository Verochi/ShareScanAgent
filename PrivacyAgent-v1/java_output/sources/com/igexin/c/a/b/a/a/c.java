package com.igexin.c.a.b.a.a;

import com.igexin.c.a.b.a.a.d.AnonymousClass1;

/* loaded from: classes22.dex */
public final class c extends android.os.Handler {

    /* renamed from: com.igexin.c.a.b.a.a.c$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.igexin.c.a.b.a.a.j.a().length];
            a = iArr;
            try {
                iArr[com.igexin.c.a.b.a.a.j.d - 1] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.igexin.c.a.b.a.a.j.e - 1] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[com.igexin.c.a.b.a.a.j.c - 1] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                a[com.igexin.c.a.b.a.a.j.f - 1] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                a[com.igexin.c.a.b.a.a.j.g - 1] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                a[com.igexin.c.a.b.a.a.j.a - 1] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                a[com.igexin.c.a.b.a.a.j.h - 1] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
        }
    }

    public c(android.os.Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public final void handleMessage(android.os.Message message) {
        try {
            int i = com.igexin.c.a.b.a.a.c.AnonymousClass1.a[com.igexin.c.a.b.a.a.j.a()[message.what] - 1];
            if (i == 1) {
                com.igexin.c.a.b.a.a.d a = com.igexin.c.a.b.a.a.d.a();
                java.net.Socket socket = a.a;
                boolean z = (socket == null || socket.isClosed()) ? false : true;
                if (!z && a.d == null) {
                    com.igexin.c.a.c.a.a("GS-M|disconnect = true, reconnect", new java.lang.Object[0]);
                    a.d = new com.igexin.c.a.b.a.a.b(a.new AnonymousClass1());
                    com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) a.d, true);
                    return;
                }
                com.igexin.c.a.c.a.a("GS-Mstart connect, isConnected = " + z + ", ctask = " + a.d, new java.lang.Object[0]);
                return;
            }
            if (i == 3) {
                com.igexin.c.a.b.a.a.d.a().a((java.net.Socket) message.obj);
                return;
            }
            if (i == 4) {
                com.igexin.c.a.b.a.a.d a2 = com.igexin.c.a.b.a.a.d.a();
                if (!a2.i() || a2.f) {
                    return;
                }
                a2.b();
                a2.f = true;
                return;
            }
            if (i == 5) {
                com.igexin.c.a.b.a.a.d a3 = com.igexin.c.a.b.a.a.d.a();
                a3.j();
                if ((a3.d == null && a3.c == null && a3.b == null) || a3.i()) {
                    a3.b();
                    return;
                } else {
                    a3.h();
                    return;
                }
            }
            if (i == 6) {
                com.igexin.c.a.b.a.a.d.a();
                com.igexin.push.core.d unused = com.igexin.push.core.d.a.a;
                com.igexin.push.e.a.a(com.igexin.c.a.b.a.a.j.a);
            } else {
                if (i != 7) {
                    return;
                }
                com.igexin.c.a.b.a.a.d a4 = com.igexin.c.a.b.a.a.d.a();
                com.igexin.c.a.c.a.b("GS-M", ((java.lang.String) message.obj) + " write task response timeout");
                a4.c();
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }
}
