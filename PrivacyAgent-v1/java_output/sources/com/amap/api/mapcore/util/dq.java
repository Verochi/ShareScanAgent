package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class dq implements com.amap.api.mapcore.util.Cdo {
    private static java.util.Map<java.lang.String, com.amap.api.mapcore.util.dq.a> a = new java.util.concurrent.ConcurrentHashMap();

    public class a {
        java.lang.String a;
        java.lang.String b;
        int c;
        final java.util.concurrent.atomic.AtomicInteger d = new java.util.concurrent.atomic.AtomicInteger(0);

        public a(int i, java.lang.String str, java.lang.String str2) {
            this.a = str;
            this.b = str2;
            this.c = i;
        }

        public final int a() {
            return this.d.incrementAndGet();
        }
    }

    private static void a(int i, java.lang.String str, java.lang.String str2, int i2) {
        if (i == 0) {
            com.amap.api.mapcore.util.ft.a(com.amap.api.mapcore.util.dl.a()).a(com.amap.api.mapcore.util.fs.a(str, str2 + " counter " + i2));
        } else {
            com.amap.api.mapcore.util.ft.a(com.amap.api.mapcore.util.dl.a()).a(com.amap.api.mapcore.util.fs.a(str, str2 + " counter " + i2));
        }
        if (com.amap.api.mapcore.util.dm.b) {
            c(i, str, str2 + " counter " + i2);
        }
    }

    private static java.lang.String b(int i, java.lang.String str, java.lang.String str2) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(i);
        if (str == null) {
            str = "";
        }
        sb.append(str);
        if (str2 == null) {
            str2 = "";
        }
        sb.append(str2);
        return sb.toString();
    }

    private static void c(int i, java.lang.String str, java.lang.String str2) {
        if (i == 0) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(str);
            sb.append(" ");
            sb.append(str2);
            return;
        }
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append(str);
        sb2.append(" ");
        sb2.append(str2);
    }

    @Override // com.amap.api.mapcore.util.Cdo
    public final void a() {
        try {
            java.util.Iterator<java.util.Map.Entry<java.lang.String, com.amap.api.mapcore.util.dq.a>> it = a.entrySet().iterator();
            while (it.hasNext()) {
                com.amap.api.mapcore.util.dq.a value = it.next().getValue();
                if (value != null) {
                    a(value.c, value.a, value.b, value.d.get());
                }
            }
            a.clear();
            com.amap.api.mapcore.util.ft.a(com.amap.api.mapcore.util.dl.a()).a();
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.amap.api.mapcore.util.Cdo
    public final void a(int i, java.lang.String str, java.lang.String str2) {
        try {
            java.lang.String b = b(i, str, str2);
            com.amap.api.mapcore.util.dq.a aVar = a.get(b);
            if (aVar == null) {
                aVar = new com.amap.api.mapcore.util.dq.a(i, str, str2);
                a.put(b, aVar);
            }
            if (aVar.a() > 100) {
                a(aVar.c, aVar.a, aVar.b, aVar.d.get());
                a.remove(b);
            }
        } catch (java.lang.Throwable unused) {
        }
    }
}
