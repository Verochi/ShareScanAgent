package com.loc;

/* loaded from: classes23.dex */
public final class e {
    static boolean g;
    android.content.Context e;
    private java.util.List<android.os.Messenger> w;
    private boolean o = false;
    private boolean p = false;
    java.lang.String a = null;
    com.loc.e.b b = null;
    private long q = 0;
    private long r = 0;

    /* renamed from: s, reason: collision with root package name */
    private com.loc.ey f402s = null;
    com.amap.api.location.AMapLocation c = null;
    private long t = 0;
    private int u = 0;
    com.loc.e.a d = null;
    private com.loc.j v = null;
    com.loc.et f = null;
    java.util.HashMap<android.os.Messenger, java.lang.Long> h = new java.util.HashMap<>();
    com.loc.gb i = null;
    long j = 0;
    long k = 0;
    private long x = 0;
    private java.util.HashMap<java.lang.String, java.lang.Boolean> y = new java.util.HashMap<>();
    java.lang.String l = null;
    private boolean z = true;
    private java.lang.String A = "";
    com.amap.api.location.AMapLocationClientOption m = null;
    com.amap.api.location.AMapLocationClientOption n = new com.amap.api.location.AMapLocationClientOption();

    public class a extends android.os.Handler {
        public a(android.os.Looper looper) {
            super(looper);
        }

        /* JADX WARN: Removed duplicated region for block: B:56:0x0158 A[Catch: all -> 0x0166, TryCatch #0 {all -> 0x0166, blocks: (B:7:0x0058, B:12:0x0067, B:14:0x0077, B:16:0x007d, B:17:0x008e, B:19:0x0095, B:21:0x009b, B:22:0x00ad, B:23:0x00bb, B:25:0x00bf, B:27:0x00c7, B:29:0x00d3, B:30:0x00dc, B:32:0x00e4, B:34:0x00f0, B:35:0x00f8, B:37:0x00fc, B:39:0x0104, B:41:0x0110, B:43:0x0125, B:44:0x012b, B:45:0x0131, B:46:0x0137, B:47:0x0142, B:48:0x0162, B:55:0x014d, B:56:0x0158, B:70:0x0051), top: B:69:0x0051 }] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x005c  */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void handleMessage(android.os.Message message) {
            android.os.Messenger messenger;
            java.lang.Throwable th;
            android.os.Bundle bundle;
            int i;
            com.loc.e eVar;
            try {
                bundle = message.getData();
                try {
                    messenger = message.replyTo;
                    if (bundle != null) {
                        try {
                            if (!bundle.isEmpty()) {
                                if (!com.loc.e.this.a(bundle.getString("c"))) {
                                    if (message.what == 1) {
                                        com.loc.gb.a((java.lang.String) null, 2102);
                                        com.loc.ey b = com.loc.e.b("invalid handlder scode!!!#1002");
                                        com.loc.es esVar = new com.loc.es();
                                        esVar.f("#1002");
                                        esVar.e("conitue");
                                        com.loc.e.this.a(messenger, b, b.k(), esVar);
                                        return;
                                    }
                                    return;
                                }
                            }
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            try {
                                com.loc.fv.a(th, "ApsServiceCore", "ActionHandler handlerMessage");
                                i = message.what;
                                if (i != 0) {
                                }
                                super.handleMessage(message);
                            } catch (java.lang.Throwable th3) {
                                com.loc.fv.a(th3, "actionHandler", "handleMessage");
                                return;
                            }
                        }
                    }
                } catch (java.lang.Throwable th4) {
                    messenger = null;
                    th = th4;
                }
            } catch (java.lang.Throwable th5) {
                messenger = null;
                th = th5;
                bundle = null;
            }
            i = message.what;
            if (i != 0) {
                com.loc.e.this.a(bundle);
                com.loc.e.this.a(messenger, bundle);
            } else if (i != 1) {
                switch (i) {
                    case 9:
                        com.loc.e.this.a(bundle);
                        com.loc.e.this.g();
                        break;
                    case 10:
                        com.loc.e.this.a(bundle);
                        com.loc.e.this.a(messenger, bundle, "FINE_LOC", 1);
                        break;
                    case 11:
                        com.loc.e.this.d();
                        break;
                    case 12:
                        com.loc.e.this.a(messenger);
                        break;
                    case 13:
                        android.os.Messenger messenger2 = message.replyTo;
                        if (messenger2 != null && com.loc.e.this.w != null && !com.loc.e.this.w.contains(messenger2)) {
                            com.loc.e.this.w.add(messenger2);
                            if (com.loc.e.this.w.size() == 1) {
                                com.loc.e.this.f();
                                break;
                            }
                        }
                        break;
                    case 14:
                        android.os.Messenger messenger3 = message.replyTo;
                        if (messenger3 != null && com.loc.e.this.w != null && com.loc.e.this.w.contains(messenger3)) {
                            com.loc.e.this.w.remove(messenger3);
                        }
                        if (com.loc.e.this.w != null && com.loc.e.this.w.size() == 0) {
                            com.loc.e.this.f.h();
                            break;
                        }
                        break;
                    case 15:
                        com.loc.e.this.a(bundle);
                        com.loc.e.this.a(messenger, bundle, "COARSE_LOC", 1);
                        break;
                    case 16:
                        if (bundle != null && !bundle.isEmpty()) {
                            com.loc.e.this.y.put(bundle.getString("objHash"), java.lang.Boolean.TRUE);
                            eVar = com.loc.e.this;
                            eVar.c();
                            break;
                        }
                        break;
                    case 17:
                        if (bundle != null && !bundle.isEmpty()) {
                            com.loc.e.this.y.put(bundle.getString("objHash"), java.lang.Boolean.FALSE);
                            eVar = com.loc.e.this;
                            eVar.c();
                            break;
                        }
                        break;
                    case 18:
                        com.loc.e.this.a(bundle);
                        com.loc.e.this.a(messenger, bundle, "FINE_LOC", 12);
                        break;
                }
            } else {
                com.loc.e.this.a(bundle);
                com.loc.e.this.b(messenger, bundle);
            }
            super.handleMessage(message);
        }
    }

    public class b extends android.os.HandlerThread {
        public b(java.lang.String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        public final void onLooperPrepared() {
            try {
                try {
                    com.loc.e.this.v = new com.loc.j(com.loc.e.this.e);
                } catch (java.lang.Throwable th) {
                    com.loc.fv.a(th, "APSManager$ActionThread", "init 2");
                }
                try {
                    com.loc.fu.b(com.loc.e.this.e);
                    com.loc.fu.a(com.loc.e.this.e);
                } catch (java.lang.Throwable th2) {
                    com.loc.fv.a(th2, "APSManager$ActionThread", "init 3");
                }
                com.loc.e.this.f = new com.loc.et(false);
                super.onLooperPrepared();
            } catch (java.lang.Throwable th3) {
                com.loc.fv.a(th3, "APSManager$ActionThread", "onLooperPrepared");
            }
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                super.run();
            } catch (java.lang.Throwable th) {
                com.loc.fv.a(th, "APSManager$ActionThread", "run");
            }
        }
    }

    public e(android.content.Context context) {
        this.e = null;
        this.e = context;
    }

    private static com.loc.ey a(int i, java.lang.String str) {
        try {
            com.loc.ey eyVar = new com.loc.ey("");
            eyVar.setErrorCode(i);
            eyVar.setLocationDetail(str);
            return eyVar;
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "ApsServiceCore", "newInstanceAMapLoc");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(android.os.Bundle bundle) {
        try {
            if (this.o) {
                com.loc.et etVar = this.f;
                if (etVar != null) {
                    etVar.a();
                    return;
                }
                return;
            }
            com.loc.fv.a(this.e);
            if (bundle != null) {
                this.n = com.loc.fv.a(bundle.getBundle("optBundle"));
            }
            this.f.a(this.e);
            this.f.b();
            a(this.n);
            this.f.c();
            this.o = true;
            this.z = true;
            this.A = "";
            java.util.List<android.os.Messenger> list = this.w;
            if (list == null || list.size() <= 0) {
                return;
            }
            f();
        } catch (java.lang.Throwable th) {
            this.z = false;
            th.printStackTrace();
            this.A = th.getMessage();
            com.loc.fv.a(th, "ApsServiceCore", "init");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(android.os.Messenger messenger) {
        this.h.remove(messenger);
    }

    private static void a(android.os.Messenger messenger, int i, android.os.Bundle bundle) {
        if (messenger != null) {
            try {
                android.os.Message obtain = android.os.Message.obtain();
                obtain.setData(bundle);
                obtain.what = i;
                messenger.send(obtain);
            } catch (java.lang.Throwable th) {
                com.loc.fv.a(th, "ApsServiceCore", "sendMessage");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(android.os.Messenger messenger, android.os.Bundle bundle) {
        if (bundle != null) {
            try {
                if (bundle.isEmpty() || this.p) {
                    return;
                }
                this.p = true;
                b(messenger);
            } catch (java.lang.Throwable th) {
                com.loc.fv.a(th, "ApsServiceCore", "doInitAuth");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(android.os.Messenger messenger, com.amap.api.location.AMapLocation aMapLocation, java.lang.String str, com.loc.es esVar) {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.setClassLoader(com.amap.api.location.AMapLocation.class.getClassLoader());
        bundle.putParcelable("loc", aMapLocation);
        bundle.putString("nb", str);
        bundle.putParcelable("statics", esVar);
        this.h.put(messenger, java.lang.Long.valueOf(com.loc.gd.b()));
        a(messenger, 1, bundle);
    }

    private void a(android.os.Messenger messenger, java.lang.String str, int i) {
        int i2;
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.setClassLoader(com.amap.api.location.AMapLocation.class.getClassLoader());
        bundle.putInt("I_MAX_GEO_DIS", com.loc.fu.i() * 3);
        bundle.putInt("I_MIN_GEO_DIS", com.loc.fu.i());
        bundle.putParcelable("loc", this.c);
        if ("COARSE_LOC".equals(str)) {
            i2 = 103;
        } else {
            if (i != 1) {
                if (i == 12) {
                    a(messenger, 18, bundle);
                    return;
                }
                return;
            }
            i2 = 6;
        }
        a(messenger, i2, bundle);
    }

    private void a(com.amap.api.location.AMapLocationClientOption aMapLocationClientOption) {
        try {
            com.loc.et etVar = this.f;
            if (etVar != null) {
                etVar.a(aMapLocationClientOption);
            }
            if (aMapLocationClientOption != null) {
                g = aMapLocationClientOption.isKillProcess();
                if (this.m != null) {
                    if (aMapLocationClientOption.isOffset() != this.m.isOffset() || aMapLocationClientOption.isNeedAddress() != this.m.isNeedAddress() || aMapLocationClientOption.isLocationCacheEnable() != this.m.isLocationCacheEnable() || this.m.getGeoLanguage() != aMapLocationClientOption.getGeoLanguage()) {
                        this.r = 0L;
                    }
                    if (aMapLocationClientOption.isOffset() != this.m.isOffset() || this.m.getGeoLanguage() != aMapLocationClientOption.getGeoLanguage()) {
                        this.c = null;
                    }
                }
                this.m = aMapLocationClientOption;
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "ApsServiceCore", "setExtra");
        }
    }

    private static com.amap.api.location.AMapLocationClientOption b(android.os.Bundle bundle) {
        com.amap.api.location.AMapLocationClientOption aMapLocationClientOption = null;
        try {
            aMapLocationClientOption = com.loc.fv.a(bundle.getBundle("optBundle"));
            try {
                java.lang.String string = bundle.getString("d");
                if (!android.text.TextUtils.isEmpty(string)) {
                    com.loc.p.a(string);
                }
            } catch (java.lang.Throwable th) {
                com.loc.fv.a(th, "APSManager", "doLocation setUmidToken");
            }
        } catch (java.lang.Throwable th2) {
            com.loc.fv.a(th2, "APSManager", "parseBundle");
        }
        return aMapLocationClientOption;
    }

    public static /* synthetic */ com.loc.ey b(java.lang.String str) {
        return a(10, str);
    }

    private void b(android.os.Messenger messenger) {
        try {
            this.f.f();
            if (com.loc.fu.l()) {
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putBoolean("installMockApp", true);
                a(messenger, 9, bundle);
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "ApsServiceCore", "initAuth");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(17:26|27|(2:28|29)|(14:34|(1:36)(2:62|(1:64))|37|38|(1:40)|41|(1:43)|44|(2:46|47)(1:60)|48|49|(2:53|54)|56|57)|65|37|38|(0)|41|(0)|44|(0)(0)|48|49|(3:51|53|54)|56|57) */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0163, code lost:
    
        r13 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0164, code lost:
    
        com.loc.fv.a(r13, "ApsServiceCore", "fixLastLocation");
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0127 A[Catch: all -> 0x016d, TryCatch #2 {all -> 0x016d, blocks: (B:4:0x0008, B:9:0x0010, B:11:0x0029, B:13:0x002f, B:16:0x0047, B:18:0x004c, B:20:0x0079, B:22:0x0086, B:24:0x008f, B:26:0x00a0, B:38:0x011f, B:40:0x0127, B:41:0x012d, B:43:0x0131, B:44:0x013c, B:46:0x0140, B:56:0x0169, B:59:0x0164, B:68:0x00f9, B:49:0x014f, B:51:0x0155, B:53:0x0159, B:29:0x00a9, B:31:0x00b9, B:34:0x00c3, B:36:0x00cb, B:37:0x00eb, B:62:0x00d3, B:64:0x00dc, B:65:0x00e4), top: B:3:0x0008, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0131 A[Catch: all -> 0x016d, TryCatch #2 {all -> 0x016d, blocks: (B:4:0x0008, B:9:0x0010, B:11:0x0029, B:13:0x002f, B:16:0x0047, B:18:0x004c, B:20:0x0079, B:22:0x0086, B:24:0x008f, B:26:0x00a0, B:38:0x011f, B:40:0x0127, B:41:0x012d, B:43:0x0131, B:44:0x013c, B:46:0x0140, B:56:0x0169, B:59:0x0164, B:68:0x00f9, B:49:0x014f, B:51:0x0155, B:53:0x0159, B:29:0x00a9, B:31:0x00b9, B:34:0x00c3, B:36:0x00cb, B:37:0x00eb, B:62:0x00d3, B:64:0x00dc, B:65:0x00e4), top: B:3:0x0008, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0140 A[Catch: all -> 0x016d, TRY_LEAVE, TryCatch #2 {all -> 0x016d, blocks: (B:4:0x0008, B:9:0x0010, B:11:0x0029, B:13:0x002f, B:16:0x0047, B:18:0x004c, B:20:0x0079, B:22:0x0086, B:24:0x008f, B:26:0x00a0, B:38:0x011f, B:40:0x0127, B:41:0x012d, B:43:0x0131, B:44:0x013c, B:46:0x0140, B:56:0x0169, B:59:0x0164, B:68:0x00f9, B:49:0x014f, B:51:0x0155, B:53:0x0159, B:29:0x00a9, B:31:0x00b9, B:34:0x00c3, B:36:0x00cb, B:37:0x00eb, B:62:0x00d3, B:64:0x00dc, B:65:0x00e4), top: B:3:0x0008, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x014e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(android.os.Messenger messenger, android.os.Bundle bundle) {
        com.loc.ey eyVar;
        java.lang.String str;
        com.loc.j jVar;
        com.loc.ey a2;
        if (bundle != null) {
            try {
                if (bundle.isEmpty()) {
                    return;
                }
                com.loc.es esVar = new com.loc.es();
                esVar.e("conitue");
                com.amap.api.location.AMapLocationClientOption b2 = b(bundle);
                a(b2);
                if (this.h.containsKey(messenger) && !b2.isOnceLocation()) {
                    if (com.loc.gd.b() - this.h.get(messenger).longValue() < 800) {
                        return;
                    }
                }
                com.amap.api.location.AMapLocation aMapLocation = null;
                if (!this.z) {
                    this.f402s = a(9, "init error : " + this.A + "#0901");
                    esVar.f("#0901");
                    com.loc.ey eyVar2 = this.f402s;
                    a(messenger, eyVar2, eyVar2.k(), esVar);
                    com.loc.gb.a((java.lang.String) null, 2091);
                    return;
                }
                long b3 = com.loc.gd.b();
                if (com.loc.gd.a(this.f402s) && b3 - this.r < 600) {
                    com.loc.ey eyVar3 = this.f402s;
                    a(messenger, eyVar3, eyVar3.k(), esVar);
                    this.f.a(this.f402s, 3);
                    return;
                }
                esVar.c(com.loc.gd.b());
                try {
                    a2 = this.f.a(esVar);
                    this.f402s = a2;
                } catch (java.lang.Throwable th) {
                    com.loc.gb.a((java.lang.String) null, 2081);
                    esVar.f("#0801");
                    this.f402s = a(8, "loc error : " + th.getMessage() + "#0801");
                    com.loc.fv.a(th, "ApsServiceCore", "run part2");
                }
                if (a2.getLocationType() != 6 && this.f402s.getLocationType() != 5) {
                    if (this.f402s.getLocationType() == 2) {
                        this.f.a(this.f402s, 3);
                    } else if (this.f402s.getLocationType() == 4) {
                        this.f.a(this.f402s, 4);
                    }
                    this.f402s = this.f.a(this.f402s);
                    if (com.loc.gd.a(this.f402s)) {
                        this.r = com.loc.gd.b();
                    }
                    if (this.f402s == null) {
                        this.f402s = a(8, "loc is null#0801");
                        esVar.f("#0801");
                    }
                    eyVar = this.f402s;
                    if (eyVar == null) {
                        java.lang.String k = eyVar.k();
                        aMapLocation = this.f402s.m13clone();
                        str = k;
                    } else {
                        str = null;
                    }
                    if (b2.isLocationCacheEnable() && (jVar = this.v) != null) {
                        aMapLocation = jVar.a(aMapLocation, str, b2.getLastLocationLifeCycle());
                    }
                    a(messenger, aMapLocation, str, esVar);
                }
                this.f.a(this.f402s, 2);
                this.f402s = this.f.a(this.f402s);
                if (com.loc.gd.a(this.f402s)) {
                }
                if (this.f402s == null) {
                }
                eyVar = this.f402s;
                if (eyVar == null) {
                }
                if (b2.isLocationCacheEnable()) {
                    aMapLocation = jVar.a(aMapLocation, str, b2.getLastLocationLifeCycle());
                }
                a(messenger, aMapLocation, str, esVar);
            } catch (java.lang.Throwable th2) {
                com.loc.fv.a(th2, "ApsServiceCore", "doLocation");
            }
        }
    }

    public static void e() {
        g = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (com.loc.gd.m(this.e)) {
            com.loc.fx.a();
            return;
        }
        try {
            com.loc.et etVar = this.f;
            if (etVar == null || etVar == null) {
                return;
            }
            etVar.a(this.d);
            this.f.g();
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "ApsServiceCore", "startColl");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        try {
            com.loc.fu.c(this.e);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "ApsServiceCore", "doCallOtherSer");
        }
    }

    public final void a() {
        try {
            this.i = new com.loc.gb();
            com.loc.e.b bVar = new com.loc.e.b("amapLocCoreThread");
            this.b = bVar;
            bVar.setPriority(5);
            this.b.start();
            this.d = new com.loc.e.a(this.b.getLooper());
            this.w = new java.util.ArrayList();
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "ApsServiceCore", "onCreate");
        }
    }

    public final void a(android.content.Intent intent) {
        com.loc.e.a aVar;
        if (!com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE.equals(intent.getStringExtra("as")) || (aVar = this.d) == null) {
            return;
        }
        aVar.sendEmptyMessageDelayed(9, 100L);
    }

    public final void a(android.os.Messenger messenger, android.os.Bundle bundle, java.lang.String str, int i) {
        com.amap.api.location.AMapLocationClientOption b2;
        float f;
        com.amap.api.location.AMapLocation aMapLocation;
        if (bundle != null) {
            try {
                if (bundle.isEmpty()) {
                    return;
                }
                double d = bundle.getDouble("lat");
                double d2 = bundle.getDouble(com.anythink.core.common.h.c.C);
                float f2 = bundle.getFloat("radius");
                long j = bundle.getLong("time");
                if ("FINE_LOC".equals(str)) {
                    if (i == 1) {
                        aMapLocation = new com.amap.api.location.AMapLocation(com.amap.api.services.geocoder.GeocodeSearch.GPS);
                        aMapLocation.setLocationType(1);
                    } else if (i == 12) {
                        com.amap.api.location.AMapLocation aMapLocation2 = new com.amap.api.location.AMapLocation("network");
                        aMapLocation2.setLocationType(12);
                        aMapLocation = aMapLocation2;
                    } else {
                        aMapLocation = null;
                    }
                    aMapLocation.setLatitude(d);
                    aMapLocation.setLongitude(d2);
                    aMapLocation.setAccuracy(f2);
                    aMapLocation.setTime(j);
                    this.f.a(aMapLocation);
                }
                if (com.loc.fu.h() && (b2 = b(bundle)) != null && b2.isNeedAddress()) {
                    a(b2);
                    com.amap.api.location.AMapLocation aMapLocation3 = this.c;
                    if (aMapLocation3 != null) {
                        f = com.loc.gd.a(new double[]{d, d2, aMapLocation3.getLatitude(), this.c.getLongitude()});
                        if (f < com.loc.fu.i() * 3) {
                            a(messenger, str, i);
                        }
                    } else {
                        f = -1.0f;
                    }
                    if (f == -1.0f || (f > com.loc.fu.i() && com.loc.gd.b() - this.x > com.loc.fu.j() * 1000)) {
                        a(bundle);
                        this.c = this.f.a(d, d2);
                        this.x = com.loc.gd.b();
                        com.amap.api.location.AMapLocation aMapLocation4 = this.c;
                        if (aMapLocation4 == null || android.text.TextUtils.isEmpty(aMapLocation4.getAdCode())) {
                            return;
                        }
                        a(messenger, str, i);
                    }
                }
            } catch (java.lang.Throwable th) {
                com.loc.fv.a(th, "ApsServiceCore", "doLocationGeo");
            }
        }
    }

    public final boolean a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(this.l)) {
            this.l = com.loc.fv.b(this.e);
        }
        return !android.text.TextUtils.isEmpty(str) && str.equals(this.l);
    }

    public final android.os.Handler b() {
        return this.d;
    }

    public final void b(android.content.Intent intent) {
        java.lang.String stringExtra = intent.getStringExtra("a");
        if (!android.text.TextUtils.isEmpty(stringExtra)) {
            com.loc.n.a(this.e, stringExtra);
        }
        java.lang.String stringExtra2 = intent.getStringExtra("b");
        this.a = stringExtra2;
        com.loc.m.a(stringExtra2);
        java.lang.String stringExtra3 = intent.getStringExtra("d");
        if (android.text.TextUtils.isEmpty(stringExtra3)) {
            return;
        }
        com.loc.p.a(stringExtra3);
    }

    public final void c() {
        java.util.HashMap<java.lang.String, java.lang.Boolean> hashMap;
        if (this.f == null || (hashMap = this.y) == null || hashMap.isEmpty()) {
            return;
        }
        java.util.Iterator<java.lang.Boolean> it = this.y.values().iterator();
        while (it.hasNext()) {
            if (it.next().booleanValue()) {
                this.f.a(true);
                return;
            }
        }
        this.f.a(false);
    }

    public final void d() {
        try {
            java.util.HashMap<android.os.Messenger, java.lang.Long> hashMap = this.h;
            if (hashMap != null) {
                hashMap.clear();
                this.h = null;
            }
            try {
                java.util.List<android.os.Messenger> list = this.w;
                if (list != null) {
                    list.clear();
                }
            } catch (java.lang.Throwable th) {
                com.loc.fv.a(th, "apm", "des1");
            }
            com.loc.j jVar = this.v;
            if (jVar != null) {
                jVar.c();
                this.v = null;
            }
            this.o = false;
            this.p = false;
            this.f.e();
            com.loc.e.a aVar = this.d;
            if (aVar != null) {
                aVar.removeCallbacksAndMessages(null);
            }
            this.d = null;
            com.loc.e.b bVar = this.b;
            if (bVar != null) {
                try {
                    com.loc.fz.a(bVar, (java.lang.Class<?>) android.os.HandlerThread.class, "quitSafely", new java.lang.Object[0]);
                } catch (java.lang.Throwable unused) {
                    this.b.quit();
                }
            }
            this.b = null;
            if (this.i != null && this.j != 0 && this.k != 0) {
                long b2 = com.loc.gd.b() - this.j;
                com.loc.gb.a(this.e, this.i.c(this.e), this.i.d(this.e), this.k, b2);
                this.i.e(this.e);
            }
            java.util.HashMap<java.lang.String, java.lang.Boolean> hashMap2 = this.y;
            if (hashMap2 != null) {
                hashMap2.clear();
                this.y = null;
            }
            com.loc.gb.a(this.e);
            com.loc.aw.b();
            if (g) {
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        } catch (java.lang.Throwable th2) {
            com.loc.fv.a(th2, "apm", "tdest");
        }
    }
}
