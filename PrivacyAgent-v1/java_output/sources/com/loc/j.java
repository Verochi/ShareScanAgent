package com.loc;

/* loaded from: classes23.dex */
public final class j {
    static com.loc.fm b;
    static com.loc.ba e;
    static long g;
    java.lang.String a = null;
    com.loc.fm c = null;
    com.loc.fm d = null;
    long f = 0;
    boolean h = false;
    private android.content.Context i;

    public j(android.content.Context context) {
        this.i = context.getApplicationContext();
    }

    private void e() {
        if (b == null || com.loc.gd.b() - g > org.apache.tools.ant.taskdefs.WaitFor.DEFAULT_MAX_WAIT_MILLIS) {
            com.loc.fm f = f();
            g = com.loc.gd.b();
            if (f == null || !com.loc.gd.a(f.a())) {
                return;
            }
            b = f;
        }
    }

    private com.loc.fm f() {
        java.lang.Throwable th;
        com.loc.fm fmVar;
        com.loc.ba baVar;
        byte[] b2;
        byte[] b3;
        java.lang.String str = null;
        if (this.i == null) {
            return null;
        }
        a();
        try {
            baVar = e;
        } catch (java.lang.Throwable th2) {
            th = th2;
            fmVar = null;
        }
        if (baVar == null) {
            return null;
        }
        java.util.List a = baVar.a("_id=1", com.loc.fm.class);
        if (a == null || a.size() <= 0) {
            fmVar = null;
        } else {
            fmVar = (com.loc.fm) a.get(0);
            try {
                byte[] b4 = com.loc.q.b(fmVar.c());
                java.lang.String str2 = (b4 == null || b4.length <= 0 || (b3 = com.loc.fk.b(b4, this.a)) == null || b3.length <= 0) ? null : new java.lang.String(b3, "UTF-8");
                byte[] b5 = com.loc.q.b(fmVar.b());
                if (b5 != null && b5.length > 0 && (b2 = com.loc.fk.b(b5, this.a)) != null && b2.length > 0) {
                    str = new java.lang.String(b2, "UTF-8");
                }
                fmVar.a(str);
                str = str2;
            } catch (java.lang.Throwable th3) {
                th = th3;
                com.loc.fv.a(th, "LastLocationManager", "readLastFix");
                return fmVar;
            }
        }
        if (!android.text.TextUtils.isEmpty(str)) {
            com.amap.api.location.AMapLocation aMapLocation = new com.amap.api.location.AMapLocation("");
            com.loc.fv.a(aMapLocation, new org.json.JSONObject(str));
            if (com.loc.gd.b(aMapLocation)) {
                fmVar.a(aMapLocation);
            }
        }
        return fmVar;
    }

    public final com.amap.api.location.AMapLocation a(com.amap.api.location.AMapLocation aMapLocation, java.lang.String str, long j) {
        boolean a;
        if (aMapLocation == null || aMapLocation.getErrorCode() == 0 || aMapLocation.getLocationType() == 1 || aMapLocation.getErrorCode() == 7) {
            return aMapLocation;
        }
        try {
            e();
            com.loc.fm fmVar = b;
            if (fmVar != null && fmVar.a() != null) {
                if (android.text.TextUtils.isEmpty(str)) {
                    long b2 = com.loc.gd.b() - b.d();
                    a = b2 >= 0 && b2 <= j;
                    aMapLocation.setTrustedLevel(3);
                } else {
                    a = com.loc.gd.a(b.b(), str);
                    aMapLocation.setTrustedLevel(2);
                }
                if (!a) {
                    return aMapLocation;
                }
                com.amap.api.location.AMapLocation a2 = b.a();
                try {
                    a2.setLocationType(9);
                    a2.setFixLastLocation(true);
                    a2.setLocationDetail(aMapLocation.getLocationDetail());
                    return a2;
                } catch (java.lang.Throwable th) {
                    th = th;
                    aMapLocation = a2;
                    com.loc.fv.a(th, "LastLocationManager", "fixLastLocation");
                    return aMapLocation;
                }
            }
            return aMapLocation;
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public final void a() {
        if (this.h) {
            return;
        }
        try {
            if (this.a == null) {
                this.a = com.loc.fk.a("MD5", com.loc.p.k());
            }
            if (e == null) {
                e = new com.loc.ba(this.i, com.loc.ba.a((java.lang.Class<? extends com.loc.az>) com.loc.fn.class));
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "LastLocationManager", "<init>:DBOperation");
        }
        this.h = true;
    }

    public final boolean a(com.amap.api.location.AMapLocation aMapLocation, java.lang.String str) {
        if (this.i != null && aMapLocation != null && com.loc.gd.a(aMapLocation) && aMapLocation.getLocationType() != 2 && !aMapLocation.isMock() && !aMapLocation.isFixLastLocation()) {
            com.loc.fm fmVar = new com.loc.fm();
            fmVar.a(aMapLocation);
            if (aMapLocation.getLocationType() == 1) {
                fmVar.a((java.lang.String) null);
            } else {
                fmVar.a(str);
            }
            try {
                b = fmVar;
                g = com.loc.gd.b();
                this.c = fmVar;
                com.loc.fm fmVar2 = this.d;
                if (fmVar2 != null && com.loc.gd.a(fmVar2.a(), fmVar.a()) <= 500.0f) {
                    return false;
                }
                if (com.loc.gd.b() - this.f > 30000) {
                    return true;
                }
            } catch (java.lang.Throwable th) {
                com.loc.fv.a(th, "LastLocationManager", "setLastFix");
            }
        }
        return false;
    }

    public final com.amap.api.location.AMapLocation b() {
        e();
        com.loc.fm fmVar = b;
        if (fmVar != null && com.loc.gd.a(fmVar.a())) {
            return b.a();
        }
        return null;
    }

    public final void c() {
        try {
            d();
            this.f = 0L;
            this.h = false;
            this.c = null;
            this.d = null;
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "LastLocationManager", "destroy");
        }
    }

    public final void d() {
        com.loc.fm fmVar;
        java.lang.String str;
        try {
            a();
            com.loc.fm fmVar2 = this.c;
            if (fmVar2 != null && com.loc.gd.a(fmVar2.a()) && e != null && (fmVar = this.c) != this.d && fmVar.d() == 0) {
                java.lang.String str2 = this.c.a().toStr();
                java.lang.String b2 = this.c.b();
                this.d = this.c;
                if (android.text.TextUtils.isEmpty(str2)) {
                    str = null;
                } else {
                    java.lang.String b3 = com.loc.q.b(com.loc.fk.a(str2.getBytes("UTF-8"), this.a));
                    str = android.text.TextUtils.isEmpty(b2) ? null : com.loc.q.b(com.loc.fk.a(b2.getBytes("UTF-8"), this.a));
                    r4 = b3;
                }
                if (android.text.TextUtils.isEmpty(r4)) {
                    return;
                }
                com.loc.fm fmVar3 = new com.loc.fm();
                fmVar3.b(r4);
                fmVar3.a(com.loc.gd.b());
                fmVar3.a(str);
                e.a(fmVar3, "_id=1");
                this.f = com.loc.gd.b();
                com.loc.fm fmVar4 = b;
                if (fmVar4 != null) {
                    fmVar4.a(com.loc.gd.b());
                }
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "LastLocationManager", "saveLastFix");
        }
    }
}
