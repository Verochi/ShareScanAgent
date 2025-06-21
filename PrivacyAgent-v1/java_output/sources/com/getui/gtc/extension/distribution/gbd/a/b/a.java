package com.getui.gtc.extension.distribution.gbd.a.b;

/* loaded from: classes22.dex */
public final class a {
    protected static final java.lang.String b = "none";
    private static final java.lang.String e = "GBD_LA";
    private static final java.lang.String f = "android.permission.ACCESS_FINE_LOCATION";
    private static final java.lang.String g = "android.permission.ACCESS_COARSE_LOCATION";
    private static final java.lang.String h = "com.huawei.android.hwouc";
    private static final int i = 3;
    com.getui.gtc.extension.distribution.gbd.a.b.c a;
    protected android.location.Location c;
    private android.content.Context j;
    private android.location.LocationManager k;
    long d = 0;
    private long l = 0;
    private int m = 0;
    private android.location.GpsStatus.Listener n = new com.getui.gtc.extension.distribution.gbd.a.b.a.AnonymousClass3();

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.b.a$1, reason: invalid class name */
    public class AnonymousClass1 extends android.location.GnssStatus.Callback {
        public AnonymousClass1() {
        }

        @Override // android.location.GnssStatus.Callback
        public final void onFirstFix(int i) {
            super.onFirstFix(i);
        }

        @Override // android.location.GnssStatus.Callback
        public final void onSatelliteStatusChanged(android.location.GnssStatus gnssStatus) {
            try {
                com.getui.gtc.extension.distribution.gbd.a.b.a.a(com.getui.gtc.extension.distribution.gbd.a.b.a.this);
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
        }

        @Override // android.location.GnssStatus.Callback
        public final void onStarted() {
            super.onStarted();
        }

        @Override // android.location.GnssStatus.Callback
        public final void onStopped() {
            super.onStopped();
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.b.a$2, reason: invalid class name */
    public class AnonymousClass2 extends com.getui.gtc.extension.distribution.gbd.f.f {
        public AnonymousClass2() {
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.f
        public final void a(com.getui.gtc.dim.DimRequest.Builder builder) {
            builder.ramCacheValidTime(0L).storageCacheValidTime(0L);
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.b.a$3, reason: invalid class name */
    public class AnonymousClass3 implements android.location.GpsStatus.Listener {
        public AnonymousClass3() {
        }

        @Override // android.location.GpsStatus.Listener
        public final void onGpsStatusChanged(int i) {
            try {
                if (i == 1) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(com.getui.gtc.extension.distribution.gbd.a.b.a.e, "g statusListener started");
                    com.getui.gtc.extension.distribution.gbd.a.b.a.this.d = java.lang.System.currentTimeMillis();
                } else {
                    if (i == 2) {
                        com.getui.gtc.extension.distribution.gbd.n.j.a(com.getui.gtc.extension.distribution.gbd.a.b.a.e, "g statusListener stopped");
                        return;
                    }
                    if (i == 3) {
                        com.getui.gtc.extension.distribution.gbd.n.j.a(com.getui.gtc.extension.distribution.gbd.a.b.a.e, "g statusListener firstfix");
                    } else if (i != 4) {
                        com.getui.gtc.extension.distribution.gbd.n.j.a(com.getui.gtc.extension.distribution.gbd.a.b.a.e, "g statusListener default");
                    } else {
                        com.getui.gtc.extension.distribution.gbd.a.b.a.a(com.getui.gtc.extension.distribution.gbd.a.b.a.this);
                    }
                }
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.b.a$4, reason: invalid class name */
    public class AnonymousClass4 extends com.getui.gtc.extension.distribution.gbd.f.f {
        public AnonymousClass4() {
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.f
        public final void a(com.getui.gtc.dim.DimRequest.Builder builder) {
            builder.ramCacheValidTime(0L).storageCacheValidTime(0L);
        }
    }

    @android.annotation.SuppressLint({"MissingPermission"})
    public a(android.content.Context context) {
        java.lang.String str;
        java.lang.String str2;
        try {
            this.j = context;
            if (!com.getui.gtc.extension.distribution.gbd.n.l.c(111) && com.getui.gtc.extension.distribution.gbd.d.d.aQ) {
                this.k = (android.location.LocationManager) com.getui.gtc.extension.distribution.gbd.d.c.d.getSystemService(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION);
                com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
                if (!com.getui.gtc.extension.distribution.gbd.f.c.a(com.getui.gtc.extension.distribution.gbd.d.d.l, com.getui.gtc.extension.distribution.gbd.f.e.b.A)) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(e, "gps disable, abort.");
                    return;
                }
                boolean c = com.getui.gtc.extension.distribution.gbd.e.b.a().c();
                com.getui.gtc.extension.distribution.gbd.n.j.a(e, "LA init checkSafeStatus = " + c + ", g=" + com.getui.gtc.extension.distribution.gbd.d.d.l);
                if (!c) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(e, "check safe not passed");
                    return;
                }
                if (com.getui.gtc.extension.distribution.gbd.f.g.a.a.a("loc-gps-listener") && this.k != null) {
                    if (b(true)) {
                        if (com.getui.gtc.extension.distribution.gbd.d.h.h >= 31) {
                            this.k.registerGnssStatusCallback(new com.getui.gtc.extension.distribution.gbd.a.b.a.AnonymousClass1());
                            str2 = "regi g 12.";
                        } else {
                            this.k.addGpsStatusListener(this.n);
                            str2 = "regi g old.";
                        }
                        com.getui.gtc.extension.distribution.gbd.n.j.a(e, str2);
                        str = "add g listener s.";
                    } else {
                        str = "add g listener f.";
                    }
                    com.getui.gtc.extension.distribution.gbd.n.j.a(e, str);
                }
                com.getui.gtc.extension.distribution.gbd.n.j.a(e, "init addgstatusl");
                return;
            }
            com.getui.gtc.extension.distribution.gbd.n.j.a(e, "type 11 in type bl or 11 disable, abort.");
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
    }

    private void a() {
        android.location.Location a;
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        if (currentTimeMillis - this.d > com.getui.gtc.extension.distribution.gbd.d.d.aW * 1000) {
            this.d = currentTimeMillis;
            this.m = 0;
        }
        int i2 = this.m;
        if (i2 >= 3 || currentTimeMillis - this.l < com.getui.gtc.extension.distribution.gbd.d.d.aY * 1000) {
            return;
        }
        this.m = i2 + 1;
        this.l = currentTimeMillis;
        boolean c = com.getui.gtc.extension.distribution.gbd.e.b.a().c();
        com.getui.gtc.extension.distribution.gbd.n.j.b(e, "g statuslistener checkSafeStatus = ".concat(java.lang.String.valueOf(c)));
        if (c && (a = a(true)) != null && com.amap.api.services.geocoder.GeocodeSearch.GPS.equals(a.getProvider())) {
            android.location.Location location = this.c;
            if (location != null) {
                float distanceTo = a.distanceTo(location);
                if (distanceTo < com.getui.gtc.extension.distribution.gbd.d.d.aX) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(e, "g statusListener distance = " + distanceTo + " <= g_distance= " + com.getui.gtc.extension.distribution.gbd.d.d.aX);
                    return;
                }
            }
            this.a.a(a);
            this.c = new android.location.Location(a);
        }
    }

    public static /* synthetic */ void a(com.getui.gtc.extension.distribution.gbd.a.b.a aVar) {
        android.location.Location a;
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        if (currentTimeMillis - aVar.d > com.getui.gtc.extension.distribution.gbd.d.d.aW * 1000) {
            aVar.d = currentTimeMillis;
            aVar.m = 0;
        }
        int i2 = aVar.m;
        if (i2 >= 3 || currentTimeMillis - aVar.l < com.getui.gtc.extension.distribution.gbd.d.d.aY * 1000) {
            return;
        }
        aVar.m = i2 + 1;
        aVar.l = currentTimeMillis;
        boolean c = com.getui.gtc.extension.distribution.gbd.e.b.a().c();
        com.getui.gtc.extension.distribution.gbd.n.j.b(e, "g statuslistener checkSafeStatus = ".concat(java.lang.String.valueOf(c)));
        if (c && (a = aVar.a(true)) != null && com.amap.api.services.geocoder.GeocodeSearch.GPS.equals(a.getProvider())) {
            android.location.Location location = aVar.c;
            if (location != null) {
                float distanceTo = a.distanceTo(location);
                if (distanceTo < com.getui.gtc.extension.distribution.gbd.d.d.aX) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(e, "g statusListener distance = " + distanceTo + " <= g_distance= " + com.getui.gtc.extension.distribution.gbd.d.d.aX);
                    return;
                }
            }
            aVar.a.a(a);
            aVar.c = new android.location.Location(a);
        }
    }

    private void a(com.getui.gtc.extension.distribution.gbd.a.b.c cVar) {
        this.a = cVar;
    }

    private static boolean a(android.location.Location location) {
        return com.getui.gtc.extension.distribution.gbd.n.l.I() && location != null && location.getLatitude() == 0.0d && location.getLongitude() == 0.0d && location.getTime() == 0 && !location.hasAccuracy();
    }

    private static boolean b() {
        return com.getui.gtc.extension.distribution.gbd.n.l.I();
    }

    private boolean b(boolean z) {
        java.lang.String str;
        java.lang.String str2;
        com.getui.gtc.extension.distribution.gbd.n.j.b(e, "type11 lEnable = " + com.getui.gtc.extension.distribution.gbd.d.d.ak + ", lEnableOnHw = " + com.getui.gtc.extension.distribution.gbd.d.d.al);
        if (!z || com.getui.gtc.extension.distribution.gbd.n.l.k()) {
            if (!com.getui.gtc.extension.distribution.gbd.n.l.e(h) || com.getui.gtc.extension.distribution.gbd.d.d.al) {
                str2 = "type11 lEnable t.";
            } else {
                long currentTimeMillis = java.lang.System.currentTimeMillis() - com.getui.gtc.extension.distribution.gbd.d.h.E;
                long j = com.getui.gtc.extension.distribution.gbd.d.d.bx * 24 * 60 * 60 * 1000;
                if (com.getui.gtc.extension.distribution.gbd.d.d.bw && currentTimeMillis > j) {
                    boolean z2 = com.getui.gtc.extension.distribution.gbd.d.d.ak && com.getui.gtc.extension.distribution.gbd.n.l.I();
                    com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
                    if (a((android.location.Location) com.getui.gtc.extension.distribution.gbd.f.c.b(z2, com.getui.gtc.extension.distribution.gbd.f.e.b.B, new com.getui.gtc.extension.distribution.gbd.a.b.a.AnonymousClass4()))) {
                        com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                        com.getui.gtc.extension.distribution.gbd.f.a.b.g(java.lang.System.currentTimeMillis());
                        str = "type11 lEnableOnHw f.";
                        com.getui.gtc.extension.distribution.gbd.n.j.b(e, str);
                        return false;
                    }
                    str2 = "type11 lEnableOnHw t.";
                }
            }
            com.getui.gtc.extension.distribution.gbd.n.j.b(e, str2);
            return true;
        }
        str = "type11 lEnable f(no p).";
        com.getui.gtc.extension.distribution.gbd.n.j.b(e, str);
        return false;
    }

    public final android.location.Location a(boolean z) {
        try {
            com.getui.gtc.extension.distribution.gbd.n.j.b(e, "start refresh li, ".concat(java.lang.String.valueOf(z)));
            if (this.k == null || !b(false)) {
                return null;
            }
            com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
            return (android.location.Location) com.getui.gtc.extension.distribution.gbd.f.c.b(com.getui.gtc.extension.distribution.gbd.n.l.I(), z ? com.getui.gtc.extension.distribution.gbd.f.e.b.A : com.getui.gtc.extension.distribution.gbd.f.e.b.B, new com.getui.gtc.extension.distribution.gbd.a.b.a.AnonymousClass2());
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return null;
        }
    }
}
