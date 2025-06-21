package com.getui.gtc.extension.distribution.gbd.a.b;

/* loaded from: classes22.dex */
public final class e implements com.getui.gtc.extension.distribution.gbd.a.a {
    private static final java.lang.String c = "GBD_151A";
    private static final int d = 2;
    private static final int e = 1;
    private static final int f = 2;
    private static final int g = 3;
    final android.location.GnssStatus.Callback a;
    final android.location.GpsStatus.Listener b;
    private android.location.LocationManager h;
    private android.content.Context i;
    private int j;
    private final java.util.Comparator<com.getui.gtc.extension.distribution.gbd.c.k> k;
    private boolean l;
    private boolean m;
    private final java.util.Map<java.lang.Long, com.getui.gtc.extension.distribution.gbd.c.k> n;
    private final java.util.Map<java.lang.Long, com.getui.gtc.extension.distribution.gbd.c.k> o;
    private long p;
    private long q;
    private int r;

    /* renamed from: s, reason: collision with root package name */
    private int f316s;
    private long t;
    private final java.util.List<android.location.Location> u;
    private java.io.File v;
    private java.io.File w;
    private long x;
    private long y;

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.b.e$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.Comparator<com.getui.gtc.extension.distribution.gbd.c.k> {
        public AnonymousClass1() {
        }

        private static int a(com.getui.gtc.extension.distribution.gbd.c.k kVar, com.getui.gtc.extension.distribution.gbd.c.k kVar2) {
            long j = kVar.c - kVar2.c;
            if (j > 0) {
                return -1;
            }
            return j == 0 ? 0 : 1;
        }

        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(com.getui.gtc.extension.distribution.gbd.c.k kVar, com.getui.gtc.extension.distribution.gbd.c.k kVar2) {
            long j = kVar.c - kVar2.c;
            if (j > 0) {
                return -1;
            }
            return j == 0 ? 0 : 1;
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.b.e$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.getui.gtc.extension.distribution.gbd.a.b.e.a(com.getui.gtc.extension.distribution.gbd.a.b.e.this);
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.b.e$3, reason: invalid class name */
    public class AnonymousClass3 extends android.location.GnssStatus.Callback {
        public AnonymousClass3() {
        }

        @Override // android.location.GnssStatus.Callback
        public final void onFirstFix(int i) {
            super.onFirstFix(i);
        }

        @Override // android.location.GnssStatus.Callback
        public final void onSatelliteStatusChanged(android.location.GnssStatus gnssStatus) {
            try {
                com.getui.gtc.extension.distribution.gbd.a.b.e.b(com.getui.gtc.extension.distribution.gbd.a.b.e.this);
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

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.b.e$4, reason: invalid class name */
    public class AnonymousClass4 implements android.location.GpsStatus.Listener {
        public AnonymousClass4() {
        }

        @Override // android.location.GpsStatus.Listener
        public final void onGpsStatusChanged(int i) {
            if (i != 4) {
                return;
            }
            try {
                com.getui.gtc.extension.distribution.gbd.a.b.e.b(com.getui.gtc.extension.distribution.gbd.a.b.e.this);
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.b.e$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        public AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.getui.gtc.extension.distribution.gbd.a.b.e.a(com.getui.gtc.extension.distribution.gbd.a.b.e.this);
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.b.e$6, reason: invalid class name */
    public class AnonymousClass6 extends com.getui.gtc.extension.distribution.gbd.f.f {
        public AnonymousClass6() {
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.f
        public final void a(com.getui.gtc.dim.DimRequest.Builder builder) {
            builder.ramCacheValidTime(0L).storageCacheValidTime(0L);
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.b.e$7, reason: invalid class name */
    public class AnonymousClass7 implements com.getui.gtc.extension.distribution.gbd.f.j<android.location.Location, java.lang.String> {
        public AnonymousClass7() {
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static java.lang.String a2(android.location.Location location) {
            try {
                return com.getui.gtc.extension.distribution.gbd.a.b.e.a(location);
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                return "";
            }
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* bridge */ /* synthetic */ java.lang.String a(android.location.Location location) {
            return a2(location);
        }
    }

    public static class a {
        private static final com.getui.gtc.extension.distribution.gbd.a.b.e a = new com.getui.gtc.extension.distribution.gbd.a.b.e((byte) 0);

        private a() {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00ee A[Catch: all -> 0x0192, TryCatch #0 {all -> 0x0192, blocks: (B:3:0x004b, B:5:0x0058, B:7:0x005c, B:9:0x0064, B:12:0x006d, B:15:0x0073, B:18:0x0079, B:20:0x007d, B:23:0x008c, B:25:0x00aa, B:30:0x00ea, B:32:0x00ee, B:39:0x0135, B:41:0x0152, B:44:0x015d, B:46:0x0161, B:48:0x0167, B:49:0x016c, B:50:0x0176, B:52:0x0170, B:53:0x017c, B:57:0x00f8, B:59:0x00b4), top: B:2:0x004b }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0152 A[Catch: all -> 0x0192, TryCatch #0 {all -> 0x0192, blocks: (B:3:0x004b, B:5:0x0058, B:7:0x005c, B:9:0x0064, B:12:0x006d, B:15:0x0073, B:18:0x0079, B:20:0x007d, B:23:0x008c, B:25:0x00aa, B:30:0x00ea, B:32:0x00ee, B:39:0x0135, B:41:0x0152, B:44:0x015d, B:46:0x0161, B:48:0x0167, B:49:0x016c, B:50:0x0176, B:52:0x0170, B:53:0x017c, B:57:0x00f8, B:59:0x00b4), top: B:2:0x004b }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0132  */
    @android.annotation.SuppressLint({"MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private e() {
        boolean z;
        boolean z2;
        boolean k;
        android.location.LocationManager locationManager;
        java.lang.String str;
        boolean exists;
        boolean exists2;
        int i = 0;
        this.j = 0;
        this.k = new com.getui.gtc.extension.distribution.gbd.a.b.e.AnonymousClass1();
        this.l = false;
        this.m = false;
        com.getui.gtc.extension.distribution.gbd.a.b.e.AnonymousClass3 anonymousClass3 = new com.getui.gtc.extension.distribution.gbd.a.b.e.AnonymousClass3();
        this.a = anonymousClass3;
        com.getui.gtc.extension.distribution.gbd.a.b.e.AnonymousClass4 anonymousClass4 = new com.getui.gtc.extension.distribution.gbd.a.b.e.AnonymousClass4();
        this.b = anonymousClass4;
        this.n = new java.util.HashMap();
        this.o = new java.util.HashMap();
        this.p = 0L;
        this.q = 0L;
        this.r = 0;
        this.f316s = 0;
        this.t = 5L;
        this.u = new java.util.ArrayList();
        this.v = null;
        this.w = null;
        this.x = 0L;
        this.y = 0L;
        try {
            this.i = com.getui.gtc.extension.distribution.gbd.d.c.d;
            boolean z3 = !com.getui.gtc.extension.distribution.gbd.n.l.c(151) && com.getui.gtc.extension.distribution.gbd.d.d.aZ && com.getui.gtc.extension.distribution.gbd.n.l.o(this.i) && g();
            this.l = z3;
            if (!z3) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(c, "151 in bl or 151 dis or check not s, init abort.");
                return;
            }
            boolean z4 = com.getui.gtc.extension.distribution.gbd.d.d.l && com.getui.gtc.extension.distribution.gbd.f.g.a.a.a("loc-gps-listener");
            this.h = (android.location.LocationManager) this.i.getSystemService(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION);
            com.getui.gtc.extension.distribution.gbd.n.j.b(c, " is allow cb =".concat(java.lang.String.valueOf(z4)));
            if (com.getui.gtc.extension.distribution.gbd.d.d.bc) {
                if (com.getui.gtc.extension.distribution.gbd.d.h.at.size() < 2) {
                    exists2 = false;
                } else {
                    java.io.File file = new java.io.File(this.i.getFilesDir().getParent() + "/shared_prefs/" + com.getui.gtc.extension.distribution.gbd.d.h.at.get(0));
                    this.v = file;
                    exists2 = file.exists();
                }
                if (exists2) {
                    z = true;
                    if (com.getui.gtc.extension.distribution.gbd.d.d.bd) {
                        if (com.getui.gtc.extension.distribution.gbd.d.h.at.size() < 2) {
                            exists = false;
                        } else {
                            java.io.File file2 = new java.io.File(this.i.getFilesDir().getParent() + "/databases/" + com.getui.gtc.extension.distribution.gbd.d.h.at.get(1));
                            this.w = file2;
                            exists = file2.exists();
                        }
                        if (exists) {
                            z2 = true;
                            if (z2) {
                                i = 2;
                            } else if (z) {
                                i = 1;
                            }
                            this.j = i;
                            com.getui.gtc.extension.distribution.gbd.n.j.b(c, "gcp = " + this.j);
                            k = com.getui.gtc.extension.distribution.gbd.n.l.k();
                            this.m = k;
                            if (!k) {
                                com.getui.gtc.extension.distribution.gbd.n.j.b(c, "151 only one.");
                                a(true);
                                return;
                            }
                            if (!z4 || (locationManager = this.h) == null) {
                                com.getui.gtc.extension.distribution.gbd.n.j.b(c, "gl not allow.");
                                com.getui.gtc.extension.distribution.gbd.d.h.b.postDelayed(new com.getui.gtc.extension.distribution.gbd.a.b.e.AnonymousClass2(), com.getui.gtc.extension.distribution.gbd.d.d.be * 1000);
                                return;
                            }
                            if (com.getui.gtc.extension.distribution.gbd.d.h.h >= 31) {
                                locationManager.registerGnssStatusCallback(anonymousClass3);
                                str = "reg g new.";
                            } else {
                                locationManager.addGpsStatusListener(anonymousClass4);
                                str = "reg g old.";
                            }
                            com.getui.gtc.extension.distribution.gbd.n.j.a(c, str);
                            com.getui.gtc.extension.distribution.gbd.n.j.b(c, "add gl su.");
                            return;
                        }
                    }
                    z2 = false;
                    if (z2) {
                    }
                    this.j = i;
                    com.getui.gtc.extension.distribution.gbd.n.j.b(c, "gcp = " + this.j);
                    k = com.getui.gtc.extension.distribution.gbd.n.l.k();
                    this.m = k;
                    if (!k) {
                    }
                }
            }
            z = false;
            if (com.getui.gtc.extension.distribution.gbd.d.d.bd) {
            }
            z2 = false;
            if (z2) {
            }
            this.j = i;
            com.getui.gtc.extension.distribution.gbd.n.j.b(c, "gcp = " + this.j);
            k = com.getui.gtc.extension.distribution.gbd.n.l.k();
            this.m = k;
            if (!k) {
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
    }

    public /* synthetic */ e(byte b) {
        this();
    }

    private static double a(com.getui.gtc.extension.distribution.gbd.c.k kVar, com.getui.gtc.extension.distribution.gbd.c.k kVar2) {
        if (kVar == null || kVar2 == null) {
            return 0.0d;
        }
        double d2 = kVar.a - kVar2.a;
        double d3 = kVar.b;
        double d4 = d3 - kVar2.b;
        double cos = java.lang.Math.cos(java.lang.Math.toRadians(d3));
        return (java.lang.Math.sqrt((((cos * cos) * d2) * d2) + (d4 * d4)) * 2.0037508342789244E7d) / 180.0d;
    }

    public static java.lang.String a(android.location.Location location) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (location != null) {
            sb.append(location.getLongitude());
            sb.append("#");
            sb.append(location.getLatitude());
            sb.append("#");
            sb.append(com.getui.gtc.extension.distribution.gbd.d.h.h >= 17 ? (((location.getElapsedRealtimeNanos() - android.os.SystemClock.elapsedRealtimeNanos()) / 1000) / 1000) + java.lang.System.currentTimeMillis() : 0L);
            sb.append("#");
            sb.append(location.getAccuracy());
            sb.append("#");
            sb.append(location.getProvider());
        }
        return sb.toString();
    }

    private static java.lang.String a(java.lang.String str) {
        return android.text.TextUtils.isEmpty(str) ? "" : com.getui.gtc.extension.distribution.gbd.d.d.bj ? com.getui.gtc.extension.distribution.gbd.n.y.d(str) : str;
    }

    private synchronized java.lang.String a(java.util.Map<java.lang.Long, com.getui.gtc.extension.distribution.gbd.c.k> map) {
        boolean z;
        java.io.File file = this.v;
        long lastModified = file == null ? 0L : file.lastModified();
        com.getui.gtc.extension.distribution.gbd.n.j.b(c, "last mtb: ".concat(java.lang.String.valueOf(lastModified)));
        if (this.x != lastModified) {
            this.x = lastModified;
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(c, "bd no change.");
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.util.List<com.getui.gtc.extension.distribution.gbd.c.k> a2 = com.getui.gtc.extension.distribution.gbd.a.b.a.a.C0307a.a.a();
        java.util.Collections.sort(a2, this.k);
        if (!a2.isEmpty() && map != null) {
            for (com.getui.gtc.extension.distribution.gbd.c.k kVar : a2) {
                if (!map.containsKey(java.lang.Long.valueOf(kVar.c))) {
                    sb.append(kVar.a());
                    sb.append(",");
                    map.put(java.lang.Long.valueOf(kVar.c), kVar);
                }
            }
            if (map.size() > 50) {
                map.clear();
            }
        }
        if (sb.toString().endsWith(",")) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private void a(long j) {
        com.getui.gtc.extension.distribution.gbd.n.j.b(c, "gt gs cb.");
        if (j - this.q > this.t * 1000) {
            this.q = j;
            android.location.Location b = b(true);
            if (b != null) {
                int size = this.u.size();
                if (size > 0) {
                    android.location.Location location = this.u.get(size - 1);
                    this.u.clear();
                    this.u.add(location);
                }
                com.getui.gtc.extension.distribution.gbd.n.j.b(c, "sample size = ".concat(java.lang.String.valueOf(size)));
                int size2 = this.u.size();
                android.location.Location location2 = size2 == 0 ? null : this.u.get(size2 - 1);
                this.u.add(b);
                long j2 = this.t * com.getui.gtc.extension.distribution.gbd.d.d.bb;
                double distanceTo = location2 == null ? j2 : b.distanceTo(location2);
                com.getui.gtc.extension.distribution.gbd.n.j.b(c, "gs d = " + distanceTo + ", cb in = " + this.t + ", lowC = " + this.r + ", highC = " + this.f316s);
                long j3 = this.t;
                if (j3 == 5 && distanceTo < j2) {
                    this.r++;
                } else if (j3 == 15 && distanceTo > j2) {
                    this.f316s++;
                }
                boolean z = distanceTo != 0.0d;
                if (distanceTo == 0.0d && com.getui.gtc.extension.distribution.gbd.d.h.h >= 17) {
                    z = (location2 == null ? 0L : location2.getElapsedRealtimeNanos()) != b.getElapsedRealtimeNanos();
                }
                if (z) {
                    java.lang.String b2 = b(b);
                    if (!android.text.TextUtils.isEmpty(b2)) {
                        a(b2, "", "", "", "", 2);
                    }
                }
                if (this.r >= 2) {
                    this.t = 15L;
                    this.r = 0;
                    this.f316s = 0;
                }
                if (this.f316s >= 2) {
                    this.t = 5L;
                    this.r = 0;
                    this.f316s = 0;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void a(com.getui.gtc.extension.distribution.gbd.a.b.e eVar) {
        java.lang.String a2;
        java.lang.String str;
        java.lang.String str2;
        com.getui.gtc.extension.distribution.gbd.e.a aVar;
        if (eVar.j == 0) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(c, "lcp = " + eVar.j + ", terminate.");
            return;
        }
        com.getui.gtc.extension.distribution.gbd.n.j.b(c, "ctr.");
        int i = eVar.j;
        if (i == 1) {
            a2 = eVar.a(eVar.n);
            str = "";
        } else {
            if (i == 2) {
                java.util.Map<java.lang.String, java.lang.String> j = eVar.j();
                java.lang.String str3 = j.get("l");
                str2 = j.get(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH);
                str = str3;
                a2 = "";
                if (android.text.TextUtils.isEmpty(a2) || !android.text.TextUtils.isEmpty(str)) {
                    eVar.a("", a2, str, "", str2, 3);
                }
                aVar = com.getui.gtc.extension.distribution.gbd.d.h.b;
                if (aVar == null) {
                    aVar.postDelayed(eVar.new AnonymousClass5(), com.getui.gtc.extension.distribution.gbd.d.d.be * 1000);
                    return;
                }
                return;
            }
            a2 = "";
            str = a2;
        }
        str2 = str;
        if (android.text.TextUtils.isEmpty(a2)) {
        }
        eVar.a("", a2, str, "", str2, 3);
        aVar = com.getui.gtc.extension.distribution.gbd.d.h.b;
        if (aVar == null) {
        }
    }

    private void a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, int i) {
        java.lang.String str6;
        com.getui.gtc.extension.distribution.gbd.n.j.b(c, "assemble d, 151");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault()).format(new java.util.Date(java.lang.System.currentTimeMillis())));
        sb.append("|");
        sb.append(com.getui.gtc.extension.distribution.gbd.d.c.e);
        sb.append("|");
        sb.append(com.getui.gtc.extension.distribution.gbd.d.c.a);
        sb.append("|");
        sb.append(a(str));
        sb.append("|");
        sb.append(a(str2));
        sb.append("|");
        sb.append(a(str3));
        sb.append("|");
        sb.append(a(str4));
        sb.append("|");
        sb.append(i);
        sb.append("|");
        sb.append(this.m ? 1 : 0);
        sb.append("|");
        sb.append(a(str5));
        sb.append("|");
        if (com.getui.gtc.extension.distribution.gbd.d.d.bj) {
            str6 = "2#" + com.getui.gtc.extension.distribution.gbd.n.y.a();
        } else {
            str6 = "";
        }
        sb.append(str6);
        java.lang.String sb2 = sb.toString();
        boolean d2 = com.getui.gtc.extension.distribution.gbd.n.l.d(151);
        boolean z = i != 1 && com.getui.gtc.extension.distribution.gbd.d.d.bg;
        com.getui.gtc.extension.distribution.gbd.n.j.b(c, "isIn: " + d2 + ", isInG: " + z + ", save 151, c = " + sb2);
        if (d2 || z) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(c, "instant r 151");
            com.getui.gtc.extension.distribution.gbd.f.a.a.a().a(sb2, 151);
        } else {
            com.getui.gtc.extension.distribution.gbd.n.j.b(c, "s ral, type = 151");
            com.getui.gtc.extension.distribution.gbd.f.a.a.a().b(sb2, 151);
        }
    }

    private void a(boolean z) {
        java.lang.String a2;
        java.lang.String str;
        java.lang.String str2;
        if (!this.l) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(c, "151 in bl or 151 dis or check not s, timer abort.");
            return;
        }
        if (!z && !this.m) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(c, "151 not perm, timer abort.");
            return;
        }
        java.lang.String b = b(com.getui.gtc.extension.distribution.gbd.d.d.bh && !z ? b(false) : null);
        int i = this.j;
        if (i == 1) {
            a2 = a(this.o);
            str = "";
        } else {
            if (i == 2) {
                java.util.Map<java.lang.String, java.lang.String> j = j();
                java.lang.String str3 = j.get("l");
                str2 = j.get(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH);
                a2 = "";
                str = str3;
                a(b, a2, str, "", str2, 1);
            }
            a2 = "";
            str = a2;
        }
        str2 = str;
        a(b, a2, str, "", str2, 1);
    }

    private android.location.Location b(boolean z) {
        try {
            com.getui.gtc.extension.distribution.gbd.n.j.b(c, "refresh li, ".concat(java.lang.String.valueOf(z)));
            if (this.h == null) {
                return null;
            }
            com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
            return (android.location.Location) com.getui.gtc.extension.distribution.gbd.f.c.b(com.getui.gtc.extension.distribution.gbd.n.l.I(), z ? com.getui.gtc.extension.distribution.gbd.f.e.b.A : com.getui.gtc.extension.distribution.gbd.f.e.b.B, new com.getui.gtc.extension.distribution.gbd.a.b.e.AnonymousClass6());
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return null;
        }
    }

    private java.lang.String b(android.location.Location location) {
        java.lang.String a2;
        try {
            com.getui.gtc.extension.distribution.gbd.n.j.b(c, "get li new");
            if (location != null) {
                boolean I = com.getui.gtc.extension.distribution.gbd.n.l.I();
                com.getui.gtc.extension.distribution.gbd.n.j.b(c, "get li new : ".concat(java.lang.String.valueOf(I)));
                com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
                a2 = (java.lang.String) com.getui.gtc.extension.distribution.gbd.f.c.a(I, "loc", location, new com.getui.gtc.extension.distribution.gbd.a.b.e.AnonymousClass7());
            } else {
                a2 = a((android.location.Location) null);
            }
            return a2;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return "";
        }
    }

    public static /* synthetic */ void b(com.getui.gtc.extension.distribution.gbd.a.b.e eVar) {
        java.lang.String a2;
        java.lang.String str;
        java.lang.String str2;
        com.getui.gtc.extension.distribution.gbd.n.j.b(c, "on sa change.");
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        if (com.getui.gtc.extension.distribution.gbd.d.d.bi) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(c, "gt gs cb.");
            if (currentTimeMillis - eVar.q > eVar.t * 1000) {
                eVar.q = currentTimeMillis;
                android.location.Location b = eVar.b(true);
                if (b != null) {
                    int size = eVar.u.size();
                    if (size > 0) {
                        android.location.Location location = eVar.u.get(size - 1);
                        eVar.u.clear();
                        eVar.u.add(location);
                    }
                    com.getui.gtc.extension.distribution.gbd.n.j.b(c, "sample size = ".concat(java.lang.String.valueOf(size)));
                    int size2 = eVar.u.size();
                    android.location.Location location2 = size2 == 0 ? null : eVar.u.get(size2 - 1);
                    eVar.u.add(b);
                    long j = eVar.t * com.getui.gtc.extension.distribution.gbd.d.d.bb;
                    double distanceTo = location2 == null ? j : b.distanceTo(location2);
                    com.getui.gtc.extension.distribution.gbd.n.j.b(c, "gs d = " + distanceTo + ", cb in = " + eVar.t + ", lowC = " + eVar.r + ", highC = " + eVar.f316s);
                    long j2 = eVar.t;
                    if (j2 == 5 && distanceTo < j) {
                        eVar.r++;
                    } else if (j2 == 15 && distanceTo > j) {
                        eVar.f316s++;
                    }
                    boolean z = distanceTo != 0.0d;
                    if (distanceTo == 0.0d && com.getui.gtc.extension.distribution.gbd.d.h.h >= 17) {
                        z = (location2 == null ? 0L : location2.getElapsedRealtimeNanos()) != b.getElapsedRealtimeNanos();
                    }
                    if (z) {
                        java.lang.String b2 = eVar.b(b);
                        if (!android.text.TextUtils.isEmpty(b2)) {
                            eVar.a(b2, "", "", "", "", 2);
                        }
                    }
                    if (eVar.r >= 2) {
                        eVar.t = 15L;
                        eVar.r = 0;
                        eVar.f316s = 0;
                    }
                    if (eVar.f316s >= 2) {
                        eVar.t = 5L;
                        eVar.r = 0;
                        eVar.f316s = 0;
                    }
                }
            }
        }
        if (currentTimeMillis - eVar.p >= com.getui.gtc.extension.distribution.gbd.d.d.be * 1000) {
            eVar.p = currentTimeMillis;
            int i = eVar.j;
            if (i == 1) {
                a2 = eVar.a(eVar.n);
                str = "";
            } else {
                if (i == 2) {
                    java.util.Map<java.lang.String, java.lang.String> j3 = eVar.j();
                    java.lang.String str3 = j3.get("l");
                    str2 = j3.get(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH);
                    str = str3;
                    a2 = "";
                    if (android.text.TextUtils.isEmpty(a2) || !android.text.TextUtils.isEmpty(str)) {
                        eVar.a("", a2, str, "", str2, 2);
                    }
                    return;
                }
                a2 = "";
                str = a2;
            }
            str2 = str;
            if (android.text.TextUtils.isEmpty(a2)) {
            }
            eVar.a("", a2, str, "", str2, 2);
        }
    }

    private static com.getui.gtc.extension.distribution.gbd.a.b.e f() {
        return com.getui.gtc.extension.distribution.gbd.a.b.e.a.a;
    }

    private static boolean g() {
        try {
            if (!android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.d.bk) && !"none".equalsIgnoreCase(com.getui.gtc.extension.distribution.gbd.d.d.bk)) {
                java.lang.String[] split = com.getui.gtc.extension.distribution.gbd.d.d.bk.split(",");
                if (split.length < 3) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(c, "hc config len err.");
                    return false;
                }
                boolean z = com.getui.gtc.extension.distribution.gbd.d.h.bb >= java.lang.Integer.parseInt(split[0]);
                long currentTimeMillis = java.lang.System.currentTimeMillis() - com.getui.gtc.extension.distribution.gbd.d.h.bc;
                boolean z2 = currentTimeMillis >= java.lang.Long.parseLong(split[1]) * 1000;
                boolean z3 = com.getui.gtc.extension.distribution.gbd.d.h.be >= java.lang.Long.parseLong(split[2]) * 1000;
                com.getui.gtc.extension.distribution.gbd.n.j.b(c, "LT: " + com.getui.gtc.extension.distribution.gbd.d.h.bb + ", IT: " + currentTimeMillis + ", RT: " + com.getui.gtc.extension.distribution.gbd.d.h.be);
                return z && z2 && z3;
            }
            com.getui.gtc.extension.distribution.gbd.n.j.b(c, "hc config empty.");
            return false;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void h() {
        java.lang.String a2;
        java.lang.String str;
        java.lang.String str2;
        com.getui.gtc.extension.distribution.gbd.e.a aVar;
        if (this.j == 0) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(c, "lcp = " + this.j + ", terminate.");
            return;
        }
        com.getui.gtc.extension.distribution.gbd.n.j.b(c, "ctr.");
        int i = this.j;
        if (i == 1) {
            a2 = a(this.n);
            str = "";
        } else {
            if (i == 2) {
                java.util.Map<java.lang.String, java.lang.String> j = j();
                java.lang.String str3 = j.get("l");
                str2 = j.get(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH);
                str = str3;
                a2 = "";
                if (android.text.TextUtils.isEmpty(a2) || !android.text.TextUtils.isEmpty(str)) {
                    a("", a2, str, "", str2, 3);
                }
                aVar = com.getui.gtc.extension.distribution.gbd.d.h.b;
                if (aVar == null) {
                    aVar.postDelayed(new com.getui.gtc.extension.distribution.gbd.a.b.e.AnonymousClass5(), com.getui.gtc.extension.distribution.gbd.d.d.be * 1000);
                    return;
                }
                return;
            }
            a2 = "";
            str = a2;
        }
        str2 = str;
        if (android.text.TextUtils.isEmpty(a2)) {
        }
        a("", a2, str, "", str2, 3);
        aVar = com.getui.gtc.extension.distribution.gbd.d.h.b;
        if (aVar == null) {
        }
    }

    private void i() {
        java.lang.String a2;
        java.lang.String str;
        java.lang.String str2;
        com.getui.gtc.extension.distribution.gbd.n.j.b(c, "on sa change.");
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        if (com.getui.gtc.extension.distribution.gbd.d.d.bi) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(c, "gt gs cb.");
            if (currentTimeMillis - this.q > this.t * 1000) {
                this.q = currentTimeMillis;
                android.location.Location b = b(true);
                if (b != null) {
                    int size = this.u.size();
                    if (size > 0) {
                        android.location.Location location = this.u.get(size - 1);
                        this.u.clear();
                        this.u.add(location);
                    }
                    com.getui.gtc.extension.distribution.gbd.n.j.b(c, "sample size = ".concat(java.lang.String.valueOf(size)));
                    int size2 = this.u.size();
                    android.location.Location location2 = size2 == 0 ? null : this.u.get(size2 - 1);
                    this.u.add(b);
                    long j = this.t * com.getui.gtc.extension.distribution.gbd.d.d.bb;
                    double distanceTo = location2 == null ? j : b.distanceTo(location2);
                    com.getui.gtc.extension.distribution.gbd.n.j.b(c, "gs d = " + distanceTo + ", cb in = " + this.t + ", lowC = " + this.r + ", highC = " + this.f316s);
                    long j2 = this.t;
                    if (j2 == 5 && distanceTo < j) {
                        this.r++;
                    } else if (j2 == 15 && distanceTo > j) {
                        this.f316s++;
                    }
                    boolean z = distanceTo != 0.0d;
                    if (distanceTo == 0.0d && com.getui.gtc.extension.distribution.gbd.d.h.h >= 17) {
                        z = (location2 == null ? 0L : location2.getElapsedRealtimeNanos()) != b.getElapsedRealtimeNanos();
                    }
                    if (z) {
                        java.lang.String b2 = b(b);
                        if (!android.text.TextUtils.isEmpty(b2)) {
                            a(b2, "", "", "", "", 2);
                        }
                    }
                    if (this.r >= 2) {
                        this.t = 15L;
                        this.r = 0;
                        this.f316s = 0;
                    }
                    if (this.f316s >= 2) {
                        this.t = 5L;
                        this.r = 0;
                        this.f316s = 0;
                    }
                }
            }
        }
        if (currentTimeMillis - this.p >= com.getui.gtc.extension.distribution.gbd.d.d.be * 1000) {
            this.p = currentTimeMillis;
            int i = this.j;
            if (i == 1) {
                a2 = a(this.n);
                str = "";
            } else {
                if (i == 2) {
                    java.util.Map<java.lang.String, java.lang.String> j3 = j();
                    java.lang.String str3 = j3.get("l");
                    str2 = j3.get(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH);
                    str = str3;
                    a2 = "";
                    if (android.text.TextUtils.isEmpty(a2) || !android.text.TextUtils.isEmpty(str)) {
                        a("", a2, str, "", str2, 2);
                    }
                    return;
                }
                a2 = "";
                str = a2;
            }
            str2 = str;
            if (android.text.TextUtils.isEmpty(a2)) {
            }
            a("", a2, str, "", str2, 2);
        }
    }

    private synchronized java.util.Map<java.lang.String, java.lang.String> j() {
        boolean z;
        int lastIndexOf;
        java.util.HashMap hashMap = new java.util.HashMap();
        java.io.File file = this.w;
        long lastModified = file == null ? 0L : file.lastModified();
        com.getui.gtc.extension.distribution.gbd.n.j.b(c, "last mtg: ".concat(java.lang.String.valueOf(lastModified)));
        if (this.y != lastModified) {
            this.y = lastModified;
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(c, "gd no change.");
            return hashMap;
        }
        try {
            com.getui.gtc.extension.distribution.gbd.a.b.a.c cVar = com.getui.gtc.extension.distribution.gbd.a.b.a.c.a.a;
            java.util.Map<java.lang.String, java.lang.String> b = com.getui.gtc.extension.distribution.gbd.a.b.a.b.a().b();
            java.lang.String str = b.get("a2");
            java.lang.String str2 = b.get("a4");
            java.lang.String a2 = cVar.a(str);
            java.lang.String a3 = cVar.a(str2);
            b.put("a2", a2);
            b.put("a4", a3);
            java.lang.String str3 = b.get("a2");
            java.lang.String str4 = b.get("a4");
            if (!android.text.TextUtils.isEmpty(str3)) {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str3);
                java.util.ArrayList arrayList = new java.util.ArrayList();
                arrayList.add(jSONObject.optString(com.anythink.core.common.h.c.C));
                arrayList.add(jSONObject.optString("lat"));
                arrayList.add(jSONObject.optString("time"));
                hashMap.put("l", new com.getui.gtc.extension.distribution.gbd.c.k(arrayList, 2).a());
            }
            if (!android.text.TextUtils.isEmpty(str4) && (lastIndexOf = str4.lastIndexOf("|")) < str4.length() - 1) {
                hashMap.put(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, str4.substring(lastIndexOf + 1));
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
        return hashMap;
    }

    private boolean k() {
        if (com.getui.gtc.extension.distribution.gbd.d.h.at.size() < 2) {
            return false;
        }
        java.io.File file = new java.io.File(this.i.getFilesDir().getParent() + "/shared_prefs/" + com.getui.gtc.extension.distribution.gbd.d.h.at.get(0));
        this.v = file;
        return file.exists();
    }

    private boolean l() {
        if (com.getui.gtc.extension.distribution.gbd.d.h.at.size() < 2) {
            return false;
        }
        java.io.File file = new java.io.File(this.i.getFilesDir().getParent() + "/databases/" + com.getui.gtc.extension.distribution.gbd.d.h.at.get(1));
        this.w = file;
        return file.exists();
    }

    private boolean m() {
        java.io.File file = this.v;
        long lastModified = file == null ? 0L : file.lastModified();
        com.getui.gtc.extension.distribution.gbd.n.j.b(c, "last mtb: ".concat(java.lang.String.valueOf(lastModified)));
        if (this.x == lastModified) {
            return false;
        }
        this.x = lastModified;
        return true;
    }

    private boolean n() {
        java.io.File file = this.w;
        long lastModified = file == null ? 0L : file.lastModified();
        com.getui.gtc.extension.distribution.gbd.n.j.b(c, "last mtg: ".concat(java.lang.String.valueOf(lastModified)));
        if (this.y == lastModified) {
            return false;
        }
        this.y = lastModified;
        return true;
    }

    private static boolean o() {
        return com.getui.gtc.extension.distribution.gbd.n.l.I();
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final void a() {
        a(false);
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final void b() {
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final int c() {
        return 151;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final java.lang.String d() {
        return null;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final java.lang.String e() {
        return null;
    }
}
