package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public class bb {
    private static volatile com.amap.api.mapcore.util.bb a;
    private static com.amap.api.mapcore.util.gh b;
    private android.content.Context c;

    private bb(android.content.Context context) {
        this.c = context;
        b = b(context);
    }

    public static com.amap.api.mapcore.util.bb a(android.content.Context context) {
        if (a == null) {
            synchronized (com.amap.api.mapcore.util.bb.class) {
                if (a == null) {
                    a = new com.amap.api.mapcore.util.bb(context);
                }
            }
        }
        return a;
    }

    private static java.util.List<java.lang.String> a(java.util.List<com.amap.api.mapcore.util.ay> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (list.size() > 0) {
            java.util.Iterator<com.amap.api.mapcore.util.ay> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().a());
            }
        }
        return arrayList;
    }

    private synchronized void a(java.lang.String str, int i, long j, long[] jArr, long[] jArr2) {
        if (b()) {
            b.a(new com.amap.api.mapcore.util.ax(str, j, i, jArr[0], jArr2[0]), com.amap.api.mapcore.util.ax.a(str));
        }
    }

    private static void a(java.lang.String str, java.lang.String str2) {
        if (str2 == null || str2.length() <= 0) {
            return;
        }
        java.lang.String a2 = com.amap.api.mapcore.util.ay.a(str);
        if (b.b(a2, com.amap.api.mapcore.util.ay.class).size() > 0) {
            b.a(a2, com.amap.api.mapcore.util.ay.class);
        }
        java.lang.String[] split = str2.split(com.alipay.sdk.m.u.i.b);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.String str3 : split) {
            arrayList.add(new com.amap.api.mapcore.util.ay(str, str3));
        }
        b.a((java.util.List) arrayList);
    }

    private static com.amap.api.mapcore.util.gh b(android.content.Context context) {
        try {
            return new com.amap.api.mapcore.util.gh(context, com.amap.api.mapcore.util.ba.a());
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "OfflineDB", "getDB");
            th.printStackTrace();
            return null;
        }
    }

    private boolean b() {
        if (b == null) {
            b = b(this.c);
        }
        return b != null;
    }

    public final synchronized com.amap.api.mapcore.util.aw a(java.lang.String str) {
        if (!b()) {
            return null;
        }
        java.util.List b2 = b.b(com.amap.api.mapcore.util.az.e(str), com.amap.api.mapcore.util.aw.class);
        if (b2.size() <= 0) {
            return null;
        }
        return (com.amap.api.mapcore.util.aw) b2.get(0);
    }

    public final java.util.ArrayList<com.amap.api.mapcore.util.aw> a() {
        java.util.ArrayList<com.amap.api.mapcore.util.aw> arrayList = new java.util.ArrayList<>();
        if (!b()) {
            return arrayList;
        }
        java.util.Iterator it = b.b("", com.amap.api.mapcore.util.aw.class).iterator();
        while (it.hasNext()) {
            arrayList.add((com.amap.api.mapcore.util.aw) it.next());
        }
        return arrayList;
    }

    public final synchronized void a(com.amap.api.mapcore.util.aw awVar) {
        if (b()) {
            b.a(awVar, com.amap.api.mapcore.util.az.f(awVar.h()));
            a(awVar.e(), awVar.a());
        }
    }

    public final void a(java.lang.String str, int i, long j, long j2, long j3) {
        if (b()) {
            a(str, i, j, new long[]{j2, 0, 0, 0, 0}, new long[]{j3, 0, 0, 0, 0});
        }
    }

    public final synchronized java.util.List<java.lang.String> b(java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (!b()) {
            return arrayList;
        }
        arrayList.addAll(a((java.util.List<com.amap.api.mapcore.util.ay>) b.b(com.amap.api.mapcore.util.ay.a(str), com.amap.api.mapcore.util.ay.class)));
        return arrayList;
    }

    public final synchronized void b(com.amap.api.mapcore.util.aw awVar) {
        if (b()) {
            b.a(com.amap.api.mapcore.util.az.f(awVar.h()), com.amap.api.mapcore.util.az.class);
            b.a(com.amap.api.mapcore.util.ay.a(awVar.e()), com.amap.api.mapcore.util.ay.class);
            b.a(com.amap.api.mapcore.util.ax.a(awVar.e()), com.amap.api.mapcore.util.ax.class);
        }
    }

    public final synchronized void c(java.lang.String str) {
        if (b()) {
            b.a(com.amap.api.mapcore.util.az.e(str), com.amap.api.mapcore.util.az.class);
            b.a(com.amap.api.mapcore.util.ay.a(str), com.amap.api.mapcore.util.ay.class);
            b.a(com.amap.api.mapcore.util.ax.a(str), com.amap.api.mapcore.util.ax.class);
        }
    }

    public final synchronized java.lang.String d(java.lang.String str) {
        if (!b()) {
            return null;
        }
        java.util.List b2 = b.b(com.amap.api.mapcore.util.az.f(str), com.amap.api.mapcore.util.az.class);
        return b2.size() > 0 ? ((com.amap.api.mapcore.util.az) b2.get(0)).d() : null;
    }
}
