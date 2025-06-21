package com.umeng.commonsdk.statistics.idtracking;

/* loaded from: classes19.dex */
public class f {
    public static final long a = 86400000;
    public static com.umeng.commonsdk.statistics.idtracking.f b;
    private static final java.lang.String c = com.umeng.analytics.pro.ay.b().b("id");
    private static java.lang.Object j = new java.lang.Object();
    private java.io.File d;
    private long f;
    private com.umeng.commonsdk.statistics.idtracking.f.a i;
    private com.umeng.commonsdk.statistics.proto.c e = null;
    private java.util.Set<com.umeng.commonsdk.statistics.idtracking.a> h = new java.util.HashSet();
    private long g = 86400000;

    public static class a {
        private android.content.Context a;
        private java.util.Set<java.lang.String> b = new java.util.HashSet();

        public a(android.content.Context context) {
            this.a = context;
        }

        public synchronized void a() {
            if (!this.b.isEmpty()) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                java.util.Iterator<java.lang.String> it = this.b.iterator();
                while (it.hasNext()) {
                    sb.append(it.next());
                    sb.append(',');
                }
                sb.deleteCharAt(sb.length() - 1);
                com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(this.a).edit().putString("invld_id", sb.toString()).commit();
            }
        }

        public synchronized boolean a(java.lang.String str) {
            return !this.b.contains(str);
        }

        public synchronized void b() {
            java.lang.String[] split;
            java.lang.String string = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(this.a).getString("invld_id", null);
            if (!android.text.TextUtils.isEmpty(string) && (split = string.split(",")) != null) {
                for (java.lang.String str : split) {
                    if (!android.text.TextUtils.isEmpty(str)) {
                        this.b.add(str);
                    }
                }
            }
        }

        public synchronized void b(java.lang.String str) {
            this.b.add(str);
        }

        public void c(java.lang.String str) {
            this.b.remove(str);
        }
    }

    public f(android.content.Context context) {
        this.i = null;
        this.d = new java.io.File(context.getFilesDir(), c);
        com.umeng.commonsdk.statistics.idtracking.f.a aVar = new com.umeng.commonsdk.statistics.idtracking.f.a(context);
        this.i = aVar;
        aVar.b();
    }

    public static synchronized com.umeng.commonsdk.statistics.idtracking.f a(android.content.Context context) {
        com.umeng.commonsdk.statistics.idtracking.f fVar;
        synchronized (com.umeng.commonsdk.statistics.idtracking.f.class) {
            if (b == null) {
                com.umeng.commonsdk.statistics.idtracking.f fVar2 = new com.umeng.commonsdk.statistics.idtracking.f(context);
                b = fVar2;
                fVar2.a(new com.umeng.commonsdk.statistics.idtracking.g(context));
                b.a(new com.umeng.commonsdk.statistics.idtracking.b(context));
                b.a(new com.umeng.commonsdk.statistics.idtracking.k(context));
                b.a(new com.umeng.commonsdk.statistics.idtracking.e(context));
                b.a(new com.umeng.commonsdk.statistics.idtracking.d(context));
                b.a(new com.umeng.commonsdk.statistics.idtracking.h(context));
                b.a(new com.umeng.commonsdk.statistics.idtracking.j());
                if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
                    b.a(new com.umeng.commonsdk.statistics.idtracking.i(context));
                    if (com.umeng.commonsdk.statistics.common.DeviceConfig.isHonorDevice()) {
                        b.a(new com.umeng.commonsdk.statistics.idtracking.c(context));
                    }
                }
                b.f();
            }
            fVar = b;
        }
        return fVar;
    }

    public static synchronized void a() {
        synchronized (com.umeng.commonsdk.statistics.idtracking.f.class) {
            com.umeng.commonsdk.statistics.idtracking.f fVar = b;
            if (fVar != null) {
                fVar.e();
                b = null;
            }
        }
    }

    private void a(com.umeng.commonsdk.statistics.proto.c cVar) {
        java.util.Map<java.lang.String, com.umeng.commonsdk.statistics.proto.b> map;
        if (cVar == null || (map = cVar.a) == null) {
            return;
        }
        if (map.containsKey("mac") && !com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.h)) {
            cVar.a.remove("mac");
        }
        if (cVar.a.containsKey("imei") && !com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.g)) {
            cVar.a.remove("imei");
        }
        if (cVar.a.containsKey("android_id") && !com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.i)) {
            cVar.a.remove("android_id");
        }
        if (cVar.a.containsKey("serial") && !com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.j)) {
            cVar.a.remove("serial");
        }
        if (cVar.a.containsKey(com.anythink.expressad.foundation.g.a.bj) && !com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.w)) {
            cVar.a.remove(com.anythink.expressad.foundation.g.a.bj);
        }
        if (!cVar.a.containsKey("oaid") || com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            return;
        }
        cVar.a.remove("oaid");
    }

    private boolean a(com.umeng.commonsdk.statistics.idtracking.a aVar) {
        if (this.i.a(aVar.b())) {
            return this.h.add(aVar);
        }
        if (!com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
            return false;
        }
        com.umeng.commonsdk.statistics.common.MLog.w("invalid domain: " + aVar.b());
        return false;
    }

    private void b(com.umeng.commonsdk.statistics.proto.c cVar) {
        byte[] a2;
        synchronized (j) {
            if (cVar != null) {
                try {
                    synchronized (this) {
                        a(cVar);
                        a2 = new com.umeng.analytics.pro.cl().a(cVar);
                    }
                    if (a2 != null) {
                        com.umeng.commonsdk.statistics.common.HelperUtils.writeFile(this.d, a2);
                    }
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private synchronized void h() {
        com.umeng.commonsdk.statistics.proto.c cVar = new com.umeng.commonsdk.statistics.proto.c();
        java.util.HashMap hashMap = new java.util.HashMap();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.h) {
            if (aVar.c()) {
                if (aVar.d() != null) {
                    hashMap.put(aVar.b(), aVar.d());
                }
                if (aVar.e() != null && !aVar.e().isEmpty()) {
                    arrayList.addAll(aVar.e());
                }
            }
        }
        cVar.a(arrayList);
        cVar.a(hashMap);
        synchronized (this) {
            this.e = cVar;
        }
    }

    private com.umeng.commonsdk.statistics.proto.c i() {
        java.lang.Throwable th;
        java.io.FileInputStream fileInputStream;
        synchronized (j) {
            if (!this.d.exists()) {
                return null;
            }
            try {
                fileInputStream = new java.io.FileInputStream(this.d);
                try {
                    try {
                        byte[] readStreamToByteArray = com.umeng.commonsdk.statistics.common.HelperUtils.readStreamToByteArray(fileInputStream);
                        com.umeng.commonsdk.statistics.proto.c cVar = new com.umeng.commonsdk.statistics.proto.c();
                        new com.umeng.analytics.pro.cf().a(cVar, readStreamToByteArray);
                        com.umeng.commonsdk.statistics.common.HelperUtils.safeClose(fileInputStream);
                        return cVar;
                    } catch (java.lang.Exception e) {
                        e = e;
                        e.printStackTrace();
                        com.umeng.commonsdk.statistics.common.HelperUtils.safeClose(fileInputStream);
                        return null;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    com.umeng.commonsdk.statistics.common.HelperUtils.safeClose(fileInputStream);
                    throw th;
                }
            } catch (java.lang.Exception e2) {
                e = e2;
                fileInputStream = null;
            } catch (java.lang.Throwable th3) {
                th = th3;
                fileInputStream = null;
                com.umeng.commonsdk.statistics.common.HelperUtils.safeClose(fileInputStream);
                throw th;
            }
        }
    }

    public void a(long j2) {
        this.g = j2;
    }

    public synchronized void b() {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        if (currentTimeMillis - this.f >= this.g) {
            boolean z = false;
            for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.h) {
                if (aVar.c() && aVar.a()) {
                    if (!aVar.c()) {
                        this.i.b(aVar.b());
                    }
                    z = true;
                }
            }
            if (z) {
                h();
                this.i.a();
                g();
            }
            this.f = currentTimeMillis;
        }
    }

    public synchronized com.umeng.commonsdk.statistics.proto.c c() {
        return this.e;
    }

    public java.lang.String d() {
        return null;
    }

    public synchronized void e() {
        if (b == null) {
            return;
        }
        boolean z = false;
        for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.h) {
            if (aVar.c() && aVar.e() != null && !aVar.e().isEmpty()) {
                aVar.a((java.util.List<com.umeng.commonsdk.statistics.proto.a>) null);
                z = true;
            }
        }
        if (z) {
            this.e.b(false);
            g();
        }
    }

    public synchronized void f() {
        com.umeng.commonsdk.statistics.proto.c i = i();
        if (i == null) {
            return;
        }
        a(i);
        java.util.ArrayList arrayList = new java.util.ArrayList(this.h.size());
        synchronized (this) {
            this.e = i;
            for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.h) {
                aVar.a(this.e);
                if (!aVar.c()) {
                    arrayList.add(aVar);
                }
            }
            java.util.Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.h.remove((com.umeng.commonsdk.statistics.idtracking.a) it.next());
            }
            h();
        }
    }

    public synchronized void g() {
        com.umeng.commonsdk.statistics.proto.c cVar = this.e;
        if (cVar != null) {
            b(cVar);
        }
    }
}
