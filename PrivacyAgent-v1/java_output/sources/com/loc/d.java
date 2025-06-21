package com.loc;

/* loaded from: classes23.dex */
public final class d {
    private static boolean J = true;
    private static boolean L;
    private static java.util.concurrent.atomic.AtomicBoolean N = new java.util.concurrent.atomic.AtomicBoolean(false);
    public static volatile boolean g;
    private android.content.Context E;
    private com.loc.g G;
    com.loc.ey a;
    public com.loc.d.c c;
    com.loc.j l;
    android.content.Intent o;
    com.amap.api.location.AMapLocationClientOption b = new com.amap.api.location.AMapLocationClientOption();
    com.loc.h d = null;
    private com.loc.k F = null;
    private boolean H = false;
    private volatile boolean I = false;
    java.util.ArrayList<com.amap.api.location.AMapLocationListener> e = new java.util.ArrayList<>();
    boolean f = false;
    public boolean h = true;
    public boolean i = true;
    public boolean j = true;
    public boolean k = true;
    android.os.Messenger m = null;
    android.os.Messenger n = null;
    int p = 0;
    private boolean K = true;
    com.loc.d.b q = null;
    boolean r = false;

    /* renamed from: s, reason: collision with root package name */
    com.amap.api.location.AMapLocationClientOption.AMapLocationMode f401s = com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;
    java.lang.Object t = new java.lang.Object();
    com.loc.gb u = null;
    boolean v = false;
    com.loc.e w = null;
    private boolean M = false;
    private com.amap.api.location.AMapLocationClientOption O = new com.amap.api.location.AMapLocationClientOption();
    private com.loc.i P = null;
    java.lang.String x = null;
    private android.content.ServiceConnection Q = new com.loc.d.AnonymousClass2();
    com.amap.api.location.AMapLocationQualityReport y = null;
    boolean z = false;
    boolean A = false;
    private volatile boolean R = false;
    com.loc.d.a B = null;
    java.lang.String C = null;
    boolean D = false;

    /* renamed from: com.loc.d$1, reason: invalid class name */
    public static class AnonymousClass1 extends com.loc.cu {
        final /* synthetic */ android.content.Context a;

        public AnonymousClass1(android.content.Context context) {
            this.a = context;
        }

        @Override // com.loc.cu
        public final void a() {
            com.loc.p.l();
            com.loc.p.a(this.a);
            com.loc.p.f(this.a);
        }
    }

    /* renamed from: com.loc.d$2, reason: invalid class name */
    public class AnonymousClass2 implements android.content.ServiceConnection {
        public AnonymousClass2() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            try {
                com.loc.d.this.m = new android.os.Messenger(iBinder);
                com.loc.d.this.H = true;
                com.loc.d.this.v = true;
            } catch (java.lang.Throwable th) {
                com.loc.fv.a(th, "ALManager", "onServiceConnected");
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(android.content.ComponentName componentName) {
            com.loc.d dVar = com.loc.d.this;
            dVar.m = null;
            dVar.H = false;
        }
    }

    /* renamed from: com.loc.d$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.amap.api.location.AMapLocationClientOption.AMapLocationMode.values().length];
            a = iArr;
            try {
                iArr[com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Battery_Saving.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Device_Sensors.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Hight_Accuracy.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    public class a extends android.os.Handler {
        public a(android.os.Looper looper) {
            super(looper);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0 */
        /* JADX WARN: Type inference failed for: r0v1 */
        /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v8 */
        @Override // android.os.Handler
        public final void handleMessage(android.os.Message message) {
            ?? r0 = 0;
            try {
                super.handleMessage(message);
                if (com.loc.fu.h) {
                }
                int i = message.what;
                if (i == 11) {
                    com.loc.d.this.a(message.getData());
                    return;
                }
                if (i == 12) {
                    com.loc.d.this.b(message);
                    return;
                }
                if (i == 16) {
                    com.loc.d.this.c(message);
                    return;
                }
                if (i == 1011) {
                    com.loc.d.this.a(14, (android.os.Bundle) null);
                    com.loc.d.this.g();
                    return;
                }
                try {
                    switch (i) {
                        case 1002:
                            com.loc.d.this.c((com.amap.api.location.AMapLocationListener) message.obj);
                            break;
                        case 1003:
                            com.loc.d.this.j();
                            com.loc.d.this.a(13, (android.os.Bundle) null);
                            break;
                        case 1004:
                            com.loc.d.this.l();
                            com.loc.d.this.a(14, (android.os.Bundle) null);
                            break;
                        case 1005:
                            com.loc.d.this.d((com.amap.api.location.AMapLocationListener) message.obj);
                            break;
                        default:
                            switch (i) {
                                case 1014:
                                    com.loc.d.this.a(message);
                                    break;
                                case 1015:
                                    com.loc.d dVar = com.loc.d.this;
                                    dVar.d.a(dVar.b);
                                    com.loc.d.this.a(1025, (java.lang.Object) null, 300000L);
                                    break;
                                case 1016:
                                    if (!com.loc.gd.m(com.loc.d.this.E)) {
                                        if (!com.loc.d.this.d.b()) {
                                            com.loc.d.this.n();
                                            break;
                                        } else {
                                            com.loc.d.this.a(1016, (java.lang.Object) null, 1000L);
                                            break;
                                        }
                                    } else {
                                        com.loc.fx.a();
                                        com.loc.d.this.r();
                                        break;
                                    }
                                case 1017:
                                    com.loc.d.this.d.a();
                                    com.loc.d.this.a(1025);
                                    break;
                                case 1018:
                                    com.loc.d dVar2 = com.loc.d.this;
                                    com.amap.api.location.AMapLocationClientOption aMapLocationClientOption = (com.amap.api.location.AMapLocationClientOption) message.obj;
                                    dVar2.b = aMapLocationClientOption;
                                    if (aMapLocationClientOption != null) {
                                        dVar2.s();
                                        break;
                                    }
                                    break;
                                default:
                                    switch (i) {
                                        case 1023:
                                            com.loc.d.this.d(message);
                                            break;
                                        case 1024:
                                            com.loc.d.this.e(message);
                                            break;
                                        case 1025:
                                            if (com.loc.d.this.d.f()) {
                                                com.loc.d.this.d.a();
                                                com.loc.d dVar3 = com.loc.d.this;
                                                dVar3.d.a(dVar3.b);
                                            }
                                            com.loc.d.this.a(1025, (java.lang.Object) null, 300000L);
                                            break;
                                        case 1026:
                                            com.loc.fx.b();
                                            com.loc.d.this.G.a(com.loc.d.this.b);
                                            break;
                                        case 1027:
                                            com.loc.d.this.G.a();
                                            break;
                                        case 1028:
                                            com.loc.d.this.g((com.amap.api.location.AMapLocation) message.obj);
                                            break;
                                        case 1029:
                                            android.os.Bundle bundle = new android.os.Bundle();
                                            bundle.putString("objHash", java.lang.Integer.toString(java.lang.System.identityHashCode(this)));
                                            com.loc.d.this.a(16, bundle);
                                            break;
                                        case 1030:
                                            android.os.Bundle bundle2 = new android.os.Bundle();
                                            bundle2.putString("objHash", java.lang.Integer.toString(java.lang.System.identityHashCode(this)));
                                            com.loc.d.this.a(17, bundle2);
                                            break;
                                        case com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_SAVE_PATH_NOT_DIRECTORY /* 1031 */:
                                            if (com.loc.d.this.b.isSysNetworkLocEnable()) {
                                                com.loc.d.this.F.a(com.loc.d.this.b);
                                                com.loc.d.this.a(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_CHUNK_NOT_EQUALS_CACHE, (java.lang.Object) null, 300000L);
                                                break;
                                            }
                                            break;
                                        case 1032:
                                            com.loc.d.this.F.a();
                                            com.loc.d.this.a(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_CHUNK_NOT_EQUALS_CACHE);
                                            break;
                                        case com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_CHUNK_NOT_EQUALS_CACHE /* 1033 */:
                                            if (com.loc.d.this.F.b()) {
                                                com.loc.d.this.F.a();
                                                com.loc.d.this.F.a(com.loc.d.this.b);
                                            }
                                            com.loc.d.this.a(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_CHUNK_NOT_EQUALS_CACHE, (java.lang.Object) null, 300000L);
                                            break;
                                        case com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_MD5_INVALID /* 1034 */:
                                            android.os.Bundle data = message.getData();
                                            com.amap.api.location.AMapLocation aMapLocation = (com.amap.api.location.AMapLocation) data.getParcelable("mapLoc");
                                            com.loc.es esVar = (com.loc.es) data.getParcelable("entity");
                                            data.getSerializable("ex");
                                            com.loc.d.this.a(aMapLocation, esVar);
                                            break;
                                    }
                            }
                    }
                } catch (java.lang.Throwable th) {
                    r0 = message;
                    th = th;
                    if (r0 == 0) {
                        r0 = "handleMessage";
                    }
                    com.loc.fv.a(th, "AMapLocationManage$MHandlerr", r0);
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        }
    }

    public static class b extends android.os.HandlerThread {
        com.loc.d a;

        public b(java.lang.String str, com.loc.d dVar) {
            super(str);
            this.a = dVar;
        }

        @Override // android.os.HandlerThread
        public final void onLooperPrepared() {
            try {
                this.a.l.a();
                com.loc.ga.a(this.a.E);
                this.a.p();
                com.loc.d dVar = this.a;
                if (dVar != null && dVar.E != null) {
                    com.loc.fu.b(this.a.E);
                    com.loc.fu.a(this.a.E);
                }
                super.onLooperPrepared();
            } catch (java.lang.Throwable unused) {
            }
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                super.run();
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public class c extends android.os.Handler {
        public c() {
        }

        public c(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(android.os.Message message) {
            com.loc.d.c cVar;
            com.loc.d.c cVar2;
            try {
                super.handleMessage(message);
                com.loc.d dVar = com.loc.d.this;
                if (dVar.r) {
                    return;
                }
                int i = message.what;
                if (i == 1) {
                    android.os.Message obtainMessage = dVar.B.obtainMessage();
                    obtainMessage.what = 11;
                    obtainMessage.setData(message.getData());
                    com.loc.d.this.B.sendMessage(obtainMessage);
                    return;
                }
                if (i != 2) {
                    if (i != 17) {
                        if (i == 18) {
                            android.os.Bundle data = message.getData();
                            if (com.loc.d.this.F != null) {
                                com.loc.d.this.F.a(data);
                                return;
                            }
                            return;
                        }
                        switch (i) {
                            case 5:
                                android.os.Bundle data2 = message.getData();
                                data2.putBundle("optBundle", com.loc.fv.a(com.loc.d.this.b));
                                com.loc.d.this.a(10, data2);
                                break;
                            case 6:
                                android.os.Bundle data3 = message.getData();
                                com.loc.h hVar = com.loc.d.this.d;
                                if (hVar != null) {
                                    hVar.a(data3);
                                    break;
                                }
                                break;
                            case 7:
                                com.loc.d.this.K = message.getData().getBoolean("ngpsAble");
                                break;
                            case 8:
                                com.loc.gb.a((java.lang.String) null, 2141);
                                break;
                            case 9:
                                boolean unused = com.loc.d.L = message.getData().getBoolean("installMockApp");
                                break;
                            case 10:
                                dVar.a((com.amap.api.location.AMapLocation) message.obj);
                                break;
                            default:
                                switch (i) {
                                    case 13:
                                        com.loc.ey eyVar = dVar.a;
                                        if (eyVar == null) {
                                            com.amap.api.location.AMapLocation aMapLocation = new com.amap.api.location.AMapLocation("LBS");
                                            aMapLocation.setErrorCode(33);
                                            com.loc.d.this.a(aMapLocation);
                                            break;
                                        } else {
                                            dVar.a(eyVar);
                                            break;
                                        }
                                    case 14:
                                        android.os.Bundle data4 = message.getData();
                                        data4.putBundle("optBundle", com.loc.fv.a(com.loc.d.this.b));
                                        com.loc.d.this.a(18, data4);
                                        break;
                                    case 15:
                                        break;
                                    default:
                                        switch (i) {
                                            case 100:
                                                com.loc.gb.a((java.lang.String) null, 2155);
                                                break;
                                            case 102:
                                                android.os.Bundle data5 = message.getData();
                                                data5.putBundle("optBundle", com.loc.fv.a(com.loc.d.this.b));
                                                com.loc.d.this.a(15, data5);
                                                break;
                                            case 103:
                                                android.os.Bundle data6 = message.getData();
                                                if (com.loc.d.this.G != null) {
                                                    com.loc.d.this.G.a(data6);
                                                    break;
                                                }
                                                break;
                                        }
                                        android.os.Message obtain = android.os.Message.obtain();
                                        obtain.what = 1028;
                                        obtain.obj = message.obj;
                                        com.loc.d.this.B.sendMessage(obtain);
                                        if (com.loc.d.this.O != null && com.loc.d.this.O.getCacheCallBack() && (cVar2 = com.loc.d.this.c) != null) {
                                            cVar2.removeMessages(13);
                                            break;
                                        }
                                        break;
                                }
                        }
                        return;
                    }
                    com.loc.gb.a((java.lang.String) null, 2131);
                    android.os.Message obtain2 = android.os.Message.obtain();
                    obtain2.what = 16;
                    obtain2.obj = message.obj;
                    com.loc.d.this.B.sendMessage(obtain2);
                    return;
                }
                android.os.Message obtain3 = android.os.Message.obtain();
                obtain3.what = 12;
                obtain3.obj = message.obj;
                com.loc.d.this.B.sendMessage(obtain3);
                if (com.loc.d.this.O == null || !com.loc.d.this.O.getCacheCallBack() || (cVar = com.loc.d.this.c) == null) {
                    return;
                }
                cVar.removeMessages(13);
            } catch (java.lang.Throwable th) {
                com.loc.fv.a(th, "AmapLocationManager$MainHandler", 0 == 0 ? "handleMessage" : null);
            }
        }
    }

    public d(android.content.Context context, android.content.Intent intent, android.os.Looper looper) {
        this.o = null;
        this.E = context;
        this.o = intent;
        b(looper);
    }

    private com.loc.d.a a(android.os.Looper looper) {
        com.loc.d.a aVar;
        synchronized (this.t) {
            aVar = new com.loc.d.a(looper);
            this.B = aVar;
        }
        return aVar;
    }

    private com.loc.ey a(com.loc.et etVar, boolean z) {
        if (!this.b.isLocationCacheEnable()) {
            return null;
        }
        try {
            return etVar.b(z);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "ALManager", "doFirstCacheLoc");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        synchronized (this.t) {
            com.loc.d.a aVar = this.B;
            if (aVar != null) {
                aVar.removeMessages(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, android.os.Bundle bundle) {
        if (bundle == null) {
            try {
                bundle = new android.os.Bundle();
            } catch (java.lang.Throwable th) {
                boolean z = (th instanceof java.lang.IllegalStateException) && th.getMessage().contains("sending message to a Handler on a dead thread");
                if ((th instanceof android.os.RemoteException) || z) {
                    this.m = null;
                    this.H = false;
                }
                com.loc.fv.a(th, "ALManager", "sendLocMessage");
                return;
            }
        }
        if (android.text.TextUtils.isEmpty(this.x)) {
            this.x = com.loc.fv.b(this.E);
        }
        bundle.putString("c", this.x);
        android.os.Message obtain = android.os.Message.obtain();
        obtain.what = i;
        obtain.setData(bundle);
        obtain.replyTo = this.n;
        android.os.Messenger messenger = this.m;
        if (messenger != null) {
            messenger.send(obtain);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, java.lang.Object obj, long j) {
        synchronized (this.t) {
            if (this.B != null) {
                android.os.Message obtain = android.os.Message.obtain();
                obtain.what = i;
                if (obj instanceof android.os.Bundle) {
                    obtain.setData((android.os.Bundle) obj);
                } else {
                    obtain.obj = obj;
                }
                this.B.sendMessageDelayed(obtain, j);
            }
        }
    }

    private static void a(android.content.Context context) {
        if (N.compareAndSet(false, true)) {
            com.loc.ct.a().b(new com.loc.d.AnonymousClass1(context));
        }
    }

    private void a(android.content.Intent intent) {
        try {
            this.E.bindService(intent, this.Q, 1);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "ALManager", "startServiceImpl");
        }
    }

    private void a(android.content.Intent intent, boolean z) {
        android.content.Context context = this.E;
        if (context != null) {
            if (android.os.Build.VERSION.SDK_INT < 26 || !z) {
                context.startService(intent);
            } else {
                if (!t()) {
                    return;
                }
                try {
                    this.E.getClass().getMethod("startForegroundService", android.content.Intent.class).invoke(this.E, intent);
                } catch (java.lang.Throwable unused) {
                    this.E.startService(intent);
                }
            }
            this.D = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(android.os.Bundle bundle) {
        com.loc.es esVar;
        com.amap.api.location.AMapLocation aMapLocation;
        com.loc.h hVar;
        com.amap.api.location.AMapLocation aMapLocation2 = null;
        if (bundle != null) {
            try {
                bundle.setClassLoader(com.amap.api.location.AMapLocation.class.getClassLoader());
                aMapLocation = (com.amap.api.location.AMapLocation) bundle.getParcelable("loc");
                aMapLocation.getLongitude();
                aMapLocation.getLatitude();
                com.loc.fx.c();
                aMapLocation.setProvider("lbs");
                this.C = bundle.getString("nb");
                esVar = (com.loc.es) bundle.getParcelable("statics");
                try {
                    if (aMapLocation.getErrorCode() == 0 && (hVar = this.d) != null) {
                        hVar.c();
                        if (!android.text.TextUtils.isEmpty(aMapLocation.getAdCode())) {
                            com.loc.h.y = aMapLocation;
                            com.loc.k.y = aMapLocation;
                        }
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    com.loc.fv.a(th, "AmapLocationManager", "resultLbsLocationSuccess");
                    if (com.loc.gd.a(aMapLocation2)) {
                    }
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                esVar = null;
                com.loc.fv.a(th, "AmapLocationManager", "resultLbsLocationSuccess");
                if (com.loc.gd.a(aMapLocation2)) {
                }
            }
        } else {
            esVar = null;
            aMapLocation = null;
        }
        com.loc.h hVar2 = this.d;
        if (hVar2 != null) {
            aMapLocation = hVar2.a(aMapLocation, this.C);
        }
        if (this.F != null && (!com.loc.gd.a(aMapLocation) || (this.b.isNeedAddress() && android.text.TextUtils.isEmpty(aMapLocation.getAdCode())))) {
            aMapLocation = this.F.a(aMapLocation, this.C);
        }
        com.amap.api.location.AMapLocation aMapLocation3 = aMapLocation;
        th = null;
        aMapLocation2 = aMapLocation3;
        if (com.loc.gd.a(aMapLocation2)) {
            this.M = false;
            a(aMapLocation2, esVar);
            return;
        }
        this.M = true;
        android.os.Bundle bundle2 = new android.os.Bundle();
        bundle2.putParcelable("mapLoc", aMapLocation2);
        bundle2.putParcelable("entity", esVar);
        bundle2.putSerializable("ex", th);
        a(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_MD5_INVALID, bundle2, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(android.os.Message message) {
        try {
            android.os.Bundle data = message.getData();
            com.amap.api.location.AMapLocation aMapLocation = (com.amap.api.location.AMapLocation) data.getParcelable("loc");
            java.lang.String string = data.getString("lastLocNb");
            f(aMapLocation);
            if (this.l.a(aMapLocation, string)) {
                this.l.d();
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "ALManager", "doSaveLastLocation");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.amap.api.location.AMapLocation aMapLocation) {
        try {
            if (aMapLocation.getErrorCode() != 0) {
                aMapLocation.setLocationType(0);
            }
            if (aMapLocation.getErrorCode() == 0) {
                double latitude = aMapLocation.getLatitude();
                double longitude = aMapLocation.getLongitude();
                if ((latitude == 0.0d && longitude == 0.0d) || latitude < -90.0d || latitude > 90.0d || longitude < -180.0d || longitude > 180.0d) {
                    com.loc.gb.a("errorLatLng", aMapLocation.toStr());
                    aMapLocation.setLocationType(0);
                    aMapLocation.setErrorCode(8);
                    aMapLocation.setLocationDetail("LatLng is error#0802");
                }
            }
            if (com.amap.api.services.geocoder.GeocodeSearch.GPS.equalsIgnoreCase(aMapLocation.getProvider()) || !this.d.b() || "network".equalsIgnoreCase(aMapLocation.getProvider()) || !this.F.c()) {
                aMapLocation.setAltitude(com.loc.gd.c(aMapLocation.getAltitude()));
                aMapLocation.setBearing(com.loc.gd.a(aMapLocation.getBearing()));
                aMapLocation.setSpeed(com.loc.gd.a(aMapLocation.getSpeed()));
                c(aMapLocation);
                b(aMapLocation);
                aMapLocation.getProvider();
                aMapLocation.getLongitude();
                aMapLocation.getLatitude();
                com.loc.fx.c();
                java.util.Iterator<com.amap.api.location.AMapLocationListener> it = this.e.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().onLocationChanged(aMapLocation);
                    } catch (java.lang.Throwable unused) {
                    }
                }
            }
        } catch (java.lang.Throwable unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(com.amap.api.location.AMapLocation aMapLocation, com.loc.es esVar) {
        try {
            com.loc.fx.c();
            if (aMapLocation == null) {
                aMapLocation = new com.amap.api.location.AMapLocation("");
                aMapLocation.setErrorCode(8);
                aMapLocation.setLocationDetail("amapLocation is null#0801");
            }
            if (this.y == null) {
                this.y = new com.amap.api.location.AMapLocationQualityReport();
            }
            this.y.setLocationMode(this.b.getLocationMode());
            com.loc.h hVar = this.d;
            if (hVar != null) {
                this.y.setGPSSatellites(hVar.e());
                this.y.setGpsStatus(this.d.d());
            }
            this.y.setWifiAble(com.loc.gd.g(this.E));
            this.y.setNetworkType(com.loc.gd.h(this.E));
            if (aMapLocation.getLocationType() == 1 || com.amap.api.services.geocoder.GeocodeSearch.GPS.equalsIgnoreCase(aMapLocation.getProvider())) {
                this.y.setNetUseTime(0L);
            }
            if (esVar != null) {
                this.y.setNetUseTime(esVar.a());
            }
            this.y.setInstallHighDangerMockApp(L);
            aMapLocation.setLocationQualityReport(this.y);
            try {
                if (this.I) {
                    a(aMapLocation, this.C);
                    if (esVar != null) {
                        esVar.d(com.loc.gd.b());
                    }
                    com.loc.gb.a(this.E, aMapLocation, esVar);
                    com.loc.gb.a(this.E, aMapLocation);
                    d(aMapLocation.m13clone());
                    com.loc.ga.a(this.E).a(aMapLocation);
                    com.loc.ga.a(this.E).b();
                }
            } catch (java.lang.Throwable th) {
                com.loc.fv.a(th, "ALManager", "handlerLocation part2");
            }
            if (this.r) {
                return;
            }
            if (this.b.isOnceLocation()) {
                l();
                a(14, (android.os.Bundle) null);
            }
        } catch (java.lang.Throwable th2) {
            com.loc.fv.a(th2, "ALManager", "handlerLocation part3");
        }
    }

    private void a(com.amap.api.location.AMapLocation aMapLocation, java.lang.String str) {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putParcelable("loc", aMapLocation);
        bundle.putString("lastLocNb", str);
        a(1014, bundle, 0L);
    }

    private static void a(com.loc.et etVar) {
        try {
            etVar.d();
            etVar.a(new com.amap.api.location.AMapLocationClientOption().setNeedAddress(false));
            etVar.a(true, new com.loc.es());
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "ALManager", "apsLocation:doFirstNetLocate 2");
        }
    }

    private void a(com.loc.et etVar, com.loc.es esVar) {
        try {
            etVar.a(this.E);
            etVar.a(this.b);
            etVar.b(esVar);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "ALManager", "initApsBase");
        }
    }

    private static void a(com.loc.et etVar, com.loc.ey eyVar) {
        if (eyVar != null) {
            try {
                if (eyVar.getErrorCode() == 0) {
                    etVar.b(eyVar);
                }
            } catch (java.lang.Throwable th) {
                com.loc.fv.a(th, "ALManager", "apsLocation:doFirstAddCache");
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(22:0|1|(14:2|3|4|5|(1:7)|9|10|(1:12)|14|15|16|17|(3:19|(2:21|(2:100|(2:102|(1:106)))(1:23))|107)(1:108)|24)|(21:(1:27)(1:98)|28|29|(2:31|(1:33))|35|(3:87|88|89)(1:37)|38|39|(1:43)|45|46|(1:50)|52|53|(1:55)|56|(1:58)|(1:64)|66|67|68)(1:99)|94|(0)(0)|38|39|(2:41|43)|45|46|(2:48|50)|52|53|(0)|56|(0)|(2:62|64)|66|67|68|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0123, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0124, code lost:
    
        com.loc.fv.a(r1, "ALManager", "apsLocation:callback");
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00e9, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00ea, code lost:
    
        com.loc.fv.a(r8, "ALManager", "fixLastLocation");
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0107 A[Catch: all -> 0x0123, TryCatch #3 {all -> 0x0123, blocks: (B:53:0x0100, B:55:0x0107, B:56:0x011a, B:58:0x011f), top: B:52:0x0100, outer: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x011f A[Catch: all -> 0x0123, TRY_LEAVE, TryCatch #3 {all -> 0x0123, blocks: (B:53:0x0100, B:55:0x0107, B:56:0x011a, B:58:0x011f), top: B:52:0x0100, outer: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.loc.ey b(com.loc.et etVar) {
        com.loc.ey eyVar;
        java.lang.Throwable th;
        boolean m;
        boolean z;
        com.loc.ey eyVar2;
        boolean z2;
        java.lang.String k;
        com.loc.d.c cVar;
        com.loc.j jVar;
        com.amap.api.location.AMapLocation aMapLocation = null;
        this.a = null;
        com.loc.es esVar = new com.loc.es();
        try {
            esVar.c(com.loc.gd.b());
            try {
                java.lang.String apikey = com.amap.api.location.AMapLocationClientOption.getAPIKEY();
                if (!android.text.TextUtils.isEmpty(apikey)) {
                    com.loc.n.a(this.E, apikey);
                }
            } catch (java.lang.Throwable th2) {
                com.loc.fv.a(th2, "ALManager", "apsLocation setAuthKey");
            }
            try {
                java.lang.String umidtoken = com.amap.api.location.UmidtokenInfo.getUmidtoken();
                if (!android.text.TextUtils.isEmpty(umidtoken)) {
                    com.loc.p.a(umidtoken);
                }
            } catch (java.lang.Throwable th3) {
                com.loc.fv.a(th3, "ALManager", "apsLocation setUmidToken");
            }
            a(etVar, esVar);
            m = com.loc.fu.m();
            z = false;
            try {
            } catch (java.lang.Throwable th4) {
                com.loc.fv.a(th4, "ALManager", "apscach");
            }
            if (this.O.getCacheCallBack()) {
                eyVar2 = a(etVar, this.O.getCacheCallBack());
                if (eyVar2 != null) {
                    if (!com.loc.fu.a(eyVar2.getTime())) {
                        if (this.O.getCacheCallBack()) {
                            int cacheTimeOut = this.O.getCacheTimeOut();
                            long a2 = com.loc.gd.a() - eyVar2.getTime();
                            if (a2 > 0 && a2 < cacheTimeOut) {
                                this.a = eyVar2;
                                eyVar2.setLocationType(10);
                            }
                        }
                    }
                }
                eyVar2 = null;
            } else {
                eyVar2 = a(etVar, false);
            }
        } catch (java.lang.Throwable th5) {
            eyVar = null;
            th = th5;
            try {
                com.loc.fv.a(th, "ALManager", "apsLocation");
                return eyVar;
            } finally {
                try {
                    etVar.e();
                } catch (java.lang.Throwable unused) {
                }
            }
        }
        if (eyVar2 == null) {
            try {
                eyVar2 = etVar.a(!m, esVar);
                if (eyVar2 != null) {
                    if (eyVar2.getErrorCode() == 0) {
                        z = true;
                    }
                }
                eyVar = eyVar2;
                z2 = z;
                z = true;
            } catch (java.lang.Throwable th6) {
                try {
                    com.loc.fv.a(th6, "ALManager", "apsLocation:doFirstNetLocate");
                    eyVar = eyVar2;
                    z = true;
                } catch (java.lang.Throwable th7) {
                    th = th7;
                    eyVar = eyVar2;
                    com.loc.fv.a(th, "ALManager", "apsLocation");
                    return eyVar;
                }
            }
            if (eyVar == null) {
                try {
                    k = eyVar.k();
                    aMapLocation = eyVar.m13clone();
                } catch (java.lang.Throwable th8) {
                    th = th8;
                    com.loc.fv.a(th, "ALManager", "apsLocation");
                    return eyVar;
                }
            } else {
                k = null;
            }
            if (this.b.isLocationCacheEnable() && (jVar = this.l) != null) {
                aMapLocation = jVar.a(aMapLocation, k, this.b.getLastLocationLifeCycle());
            }
            if (this.O.getCacheCallBack() && (cVar = this.c) != null) {
                cVar.removeMessages(13);
            }
            android.os.Bundle bundle = new android.os.Bundle();
            if (aMapLocation != null) {
                bundle.putParcelable("loc", aMapLocation);
                bundle.putString("nb", eyVar.k());
                bundle.putParcelable("statics", esVar);
            }
            a(bundle);
            if (z2) {
                a(etVar, eyVar);
            }
            if (z && m && !g) {
                g = true;
                a(etVar);
            }
            return eyVar;
        }
        eyVar = eyVar2;
        z2 = false;
        if (eyVar == null) {
        }
        if (this.b.isLocationCacheEnable()) {
            aMapLocation = jVar.a(aMapLocation, k, this.b.getLastLocationLifeCycle());
        }
        if (this.O.getCacheCallBack()) {
            cVar.removeMessages(13);
        }
        android.os.Bundle bundle2 = new android.os.Bundle();
        if (aMapLocation != null) {
        }
        a(bundle2);
        if (z2) {
        }
        if (z) {
            g = true;
            a(etVar);
        }
        return eyVar;
    }

    private void b(android.os.Looper looper) {
        try {
            if (looper == null) {
                this.c = android.os.Looper.myLooper() == null ? new com.loc.d.c(this.E.getMainLooper()) : new com.loc.d.c();
            } else {
                this.c = new com.loc.d.c(looper);
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "ALManager", "init 1");
        }
        try {
            try {
                this.l = new com.loc.j(this.E);
            } catch (java.lang.Throwable th2) {
                com.loc.fv.a(th2, "ALManager", "init 2");
            }
            com.loc.d.b bVar = new com.loc.d.b("amapLocManagerThread", this);
            this.q = bVar;
            bVar.setPriority(5);
            this.q.start();
            this.B = a(this.q.getLooper());
        } catch (java.lang.Throwable th3) {
            com.loc.fv.a(th3, "ALManager", "init 5");
        }
        try {
            this.d = new com.loc.h(this.E, this.c);
            this.F = new com.loc.k(this.E, this.c);
            this.G = new com.loc.g(this.E, this.c);
        } catch (java.lang.Throwable th4) {
            com.loc.fv.a(th4, "ALManager", "init 3");
        }
        if (this.u == null) {
            this.u = new com.loc.gb();
        }
        a(this.E);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(android.os.Message message) {
        try {
            com.amap.api.location.AMapLocation aMapLocation = (com.amap.api.location.AMapLocation) message.obj;
            aMapLocation.getLongitude();
            aMapLocation.getLatitude();
            com.loc.fx.c();
            if (this.h && this.m != null) {
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putBundle("optBundle", com.loc.fv.a(this.b));
                a(0, bundle);
                if (this.I) {
                    a(13, (android.os.Bundle) null);
                }
                this.h = false;
            }
            a(aMapLocation, (com.loc.es) null);
            a(1025);
            a(1025, (java.lang.Object) null, 300000L);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "ALManager", "resultGpsLocationSuccess");
        }
    }

    private static void b(com.amap.api.location.AMapLocation aMapLocation) {
        if (aMapLocation == null) {
            return;
        }
        try {
            if (2 == aMapLocation.getLocationType() || 4 == aMapLocation.getLocationType()) {
                long time = aMapLocation.getTime();
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                if (currentTimeMillis > time) {
                    aMapLocation.setTime(currentTimeMillis);
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(android.os.Message message) {
        try {
            com.amap.api.location.AMapLocation aMapLocation = (com.amap.api.location.AMapLocation) message.obj;
            aMapLocation.getLongitude();
            aMapLocation.getLatitude();
            com.loc.fx.c();
            if (this.j && this.m != null) {
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putBundle("optBundle", com.loc.fv.a(this.b));
                a(0, bundle);
                if (this.I) {
                    a(13, (android.os.Bundle) null);
                }
                this.j = false;
            }
            if (this.M) {
                a(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_MD5_INVALID);
                a(aMapLocation, (com.loc.es) null);
            }
            a(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_CHUNK_NOT_EQUALS_CACHE);
            a(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_CHUNK_NOT_EQUALS_CACHE, (java.lang.Object) null, 300000L);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "ALManager", "resultNetworkLocationSuccess");
        }
    }

    private void c(com.amap.api.location.AMapLocation aMapLocation) {
        if (aMapLocation != null) {
            try {
                java.lang.String locationDetail = aMapLocation.getLocationDetail();
                java.lang.StringBuilder sb = android.text.TextUtils.isEmpty(locationDetail) ? new java.lang.StringBuilder() : new java.lang.StringBuilder(locationDetail);
                boolean c2 = com.loc.gd.c(this.E, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF");
                boolean c3 = com.loc.gd.c(this.E, "WYW5kcm9pZC5wZXJtaXNzaW9uLkNIQU5HRV9XSUZJX1NUQVRF");
                boolean c4 = com.loc.gd.c(this.E, "WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19MT0NBVElPTl9FWFRSQV9DT01NQU5EUw==");
                boolean c5 = com.loc.gd.c(this.E, "EYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=");
                boolean c6 = com.loc.gd.c(this.E, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O");
                boolean c7 = com.loc.gd.c(this.E, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=");
                sb.append(c2 ? "#pm1" : "#pm0");
                java.lang.String str = "1";
                sb.append(c3 ? "1" : "0");
                sb.append(c4 ? "1" : "0");
                sb.append(c5 ? "1" : "0");
                sb.append(c6 ? "1" : "0");
                if (!c7) {
                    str = "0";
                }
                sb.append(str);
                aMapLocation.setLocationDetail(sb.toString());
            } catch (java.lang.Throwable unused) {
                com.loc.fx.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.amap.api.location.AMapLocationListener aMapLocationListener) {
        if (aMapLocationListener == null) {
            throw new java.lang.IllegalArgumentException("listener参数不能为null");
        }
        if (this.e == null) {
            this.e = new java.util.ArrayList<>();
        }
        if (this.e.contains(aMapLocationListener)) {
            return;
        }
        this.e.add(aMapLocationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(android.os.Message message) {
        if (message == null) {
            return;
        }
        try {
            android.os.Bundle data = message.getData();
            if (data == null) {
                return;
            }
            int i = data.getInt("i", 0);
            android.app.Notification notification = (android.app.Notification) data.getParcelable("h");
            android.content.Intent q = q();
            q.putExtra("i", i);
            q.putExtra("h", notification);
            q.putExtra("g", 1);
            a(q, true);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "ALManager", "doEnableBackgroundLocation");
        }
    }

    private void d(com.amap.api.location.AMapLocation aMapLocation) {
        android.os.Message obtainMessage = this.c.obtainMessage();
        obtainMessage.what = 10;
        obtainMessage.obj = aMapLocation;
        this.c.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.amap.api.location.AMapLocationListener aMapLocationListener) {
        if (!this.e.isEmpty() && this.e.contains(aMapLocationListener)) {
            this.e.remove(aMapLocationListener);
        }
        if (this.e.isEmpty()) {
            l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(android.os.Message message) {
        if (message == null) {
            return;
        }
        try {
            android.os.Bundle data = message.getData();
            if (data == null) {
                return;
            }
            boolean z = data.getBoolean("j", true);
            android.content.Intent q = q();
            q.putExtra("j", z);
            q.putExtra("g", 2);
            a(q, false);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "ALManager", "doDisableBackgroundLocation");
        }
    }

    private synchronized void e(com.amap.api.location.AMapLocation aMapLocation) {
        if (aMapLocation == null) {
            try {
                aMapLocation = new com.amap.api.location.AMapLocation("");
                aMapLocation.setErrorCode(8);
                aMapLocation.setLocationDetail("coarse amapLocation is null#2005");
            } catch (java.lang.Throwable th) {
                com.loc.fv.a(th, "ALManager", "handlerCoarseLocation part2");
                return;
            }
        }
        if (this.y == null) {
            this.y = new com.amap.api.location.AMapLocationQualityReport();
        }
        this.y.setLocationMode(this.b.getLocationMode());
        if (this.G != null) {
            this.y.setGPSSatellites(aMapLocation.getSatellites());
            this.y.setGpsStatus(this.G.b());
        }
        this.y.setWifiAble(com.loc.gd.g(this.E));
        this.y.setNetworkType(com.loc.gd.h(this.E));
        this.y.setNetUseTime(0L);
        this.y.setInstallHighDangerMockApp(L);
        aMapLocation.setLocationQualityReport(this.y);
        try {
            if (this.I) {
                com.loc.gb.a(this.E, aMapLocation);
                d(aMapLocation.m13clone());
                com.loc.ga.a(this.E).a(aMapLocation);
                com.loc.ga.a(this.E).b();
            }
        } catch (java.lang.Throwable th2) {
            com.loc.fv.a(th2, "ALManager", "handlerCoarseLocation part");
        }
        if (this.r) {
            return;
        }
        if (this.G != null) {
            l();
        }
        a(14, (android.os.Bundle) null);
    }

    private void f(com.amap.api.location.AMapLocation aMapLocation) {
        com.amap.api.location.AMapLocation a2;
        if (aMapLocation == null) {
            return;
        }
        try {
            com.loc.fm fmVar = com.loc.j.b;
            if (fmVar == null) {
                com.loc.j jVar = this.l;
                a2 = jVar != null ? jVar.b() : null;
            } else {
                a2 = fmVar.a();
            }
            com.loc.gb.a(a2, aMapLocation);
        } catch (java.lang.Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(com.amap.api.location.AMapLocation aMapLocation) {
        try {
            if (this.i && this.m != null) {
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putBundle("optBundle", com.loc.fv.a(this.b));
                a(0, bundle);
                if (this.I) {
                    a(13, (android.os.Bundle) null);
                }
                this.i = false;
            }
            e(aMapLocation);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "ALManager", "resultGpsLocationSuccess");
        }
    }

    private void h() {
        synchronized (this.t) {
            com.loc.d.a aVar = this.B;
            if (aVar != null) {
                aVar.removeCallbacksAndMessages(null);
            }
            this.B = null;
        }
    }

    private boolean i() {
        boolean z = false;
        int i = 0;
        while (this.m == null) {
            try {
                java.lang.Thread.sleep(100L);
                i++;
                if (i >= 50) {
                    break;
                }
            } catch (java.lang.Throwable th) {
                com.loc.fv.a(th, "ALManager", "checkAPSManager");
            }
        }
        if (this.m == null) {
            android.os.Message obtain = android.os.Message.obtain();
            android.os.Bundle bundle = new android.os.Bundle();
            com.amap.api.location.AMapLocation aMapLocation = new com.amap.api.location.AMapLocation("");
            aMapLocation.setErrorCode(10);
            aMapLocation.setLocationDetail(!com.loc.gd.k(this.E.getApplicationContext()) ? "请检查配置文件是否配置服务，并且manifest中service标签是否配置在application标签内#1003" : "启动ApsServcie失败#1001");
            bundle.putParcelable("loc", aMapLocation);
            obtain.setData(bundle);
            obtain.what = 1;
            this.c.sendMessage(obtain);
        } else {
            z = true;
        }
        if (!z) {
            com.loc.gb.a((java.lang.String) null, !com.loc.gd.k(this.E.getApplicationContext()) ? 2103 : com.amap.api.services.core.AMapException.CODE_AMAP_NEARBY_KEY_NOT_BIND);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void j() {
        int i = android.os.Build.VERSION.SDK_INT;
        if ((i < 29 && i >= 23 && !com.loc.gd.c(this.E, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=") && !com.loc.gd.c(this.E, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O")) || ((i < 31 && i >= 29 && this.E.getApplicationInfo().targetSdkVersion >= 29 && !com.loc.gd.c(this.E, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O")) || ((i < 31 && i >= 29 && this.E.getApplicationInfo().targetSdkVersion < 29 && !com.loc.gd.c(this.E, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=") && !com.loc.gd.c(this.E, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O")) || (i >= 31 && !com.loc.gd.c(this.E, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=") && !com.loc.gd.c(this.E, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O"))))) {
            k();
            return;
        }
        if (this.b == null) {
            this.b = new com.amap.api.location.AMapLocationClientOption();
        }
        if (this.I) {
            return;
        }
        this.I = true;
        com.loc.fx.c();
        long j = 0;
        a(1029, (java.lang.Object) null, 0L);
        int i2 = com.loc.d.AnonymousClass3.a[this.b.getLocationMode().ordinal()];
        if (i2 == 1) {
            a(1027, (java.lang.Object) null, 0L);
            a(1017, (java.lang.Object) null, 0L);
            a(1016, (java.lang.Object) null, 0L);
            a(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_SAVE_PATH_NOT_DIRECTORY, (java.lang.Object) null, 0L);
            return;
        }
        if (i2 == 2) {
            if (com.loc.gd.m(this.E)) {
                a(1016);
                a(1017, (java.lang.Object) null, 0L);
                a(1032, (java.lang.Object) null, 0L);
                a(1026, (java.lang.Object) null, 0L);
                return;
            }
            a(1016);
            a(1027, (java.lang.Object) null, 0L);
            a(1032, (java.lang.Object) null, 0L);
            a(1015, (java.lang.Object) null, 0L);
            return;
        }
        if (i2 == 3) {
            if (com.loc.gd.m(this.E)) {
                a(1016);
                a(1017, (java.lang.Object) null, 0L);
                a(1032, (java.lang.Object) null, 0L);
                a(1026, (java.lang.Object) null, 0L);
                return;
            }
            a(1027, (java.lang.Object) null, 0L);
            a(1015, (java.lang.Object) null, 0L);
            if (this.b.isGpsFirst() && this.b.isOnceLocation()) {
                j = this.b.getGpsFirstTimeout();
            }
            a(1016, (java.lang.Object) null, j);
            a(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_SAVE_PATH_NOT_DIRECTORY, (java.lang.Object) null, j);
        }
    }

    private void k() {
        com.amap.api.location.AMapLocation aMapLocation = new com.amap.api.location.AMapLocation("");
        aMapLocation.setErrorCode(12);
        aMapLocation.setLocationDetail("定位权限被禁用,请授予应用定位权限 #1201");
        if (this.y == null) {
            this.y = new com.amap.api.location.AMapLocationQualityReport();
        }
        com.amap.api.location.AMapLocationQualityReport aMapLocationQualityReport = new com.amap.api.location.AMapLocationQualityReport();
        this.y = aMapLocationQualityReport;
        aMapLocationQualityReport.setGpsStatus(4);
        this.y.setGPSSatellites(0);
        this.y.setLocationMode(this.b.getLocationMode());
        this.y.setWifiAble(com.loc.gd.g(this.E));
        this.y.setNetworkType(com.loc.gd.h(this.E));
        this.y.setNetUseTime(0L);
        aMapLocation.setLocationQualityReport(this.y);
        com.loc.gb.a((java.lang.String) null, 2121);
        d(aMapLocation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        try {
            com.loc.fx.c();
            a(1025);
            a(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_CHUNK_NOT_EQUALS_CACHE);
            com.loc.h hVar = this.d;
            if (hVar != null) {
                hVar.a();
            }
            com.loc.k kVar = this.F;
            if (kVar != null) {
                kVar.a();
            }
            com.loc.g gVar = this.G;
            if (gVar != null) {
                gVar.a();
            }
            a(1016);
            a(1030, (java.lang.Object) null, 0L);
            this.I = false;
            this.p = 0;
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "ALManager", "stopLocation");
        }
    }

    private void m() {
        com.loc.ey b2 = b(new com.loc.et(true));
        if (i()) {
            android.os.Bundle bundle = new android.os.Bundle();
            java.lang.String str = (b2 == null || !(b2.getLocationType() == 2 || b2.getLocationType() == 4)) ? "0" : "1";
            bundle.putBundle("optBundle", com.loc.fv.a(this.b));
            bundle.putString("isCacheLoc", str);
            a(0, bundle);
            if (this.I) {
                a(13, (android.os.Bundle) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        try {
            if (J || !(this.v || this.R)) {
                J = false;
                this.R = true;
                m();
            } else {
                try {
                    if (this.v && !a() && !this.A) {
                        this.A = true;
                        p();
                    }
                } catch (java.lang.Throwable th) {
                    this.A = true;
                    com.loc.fv.a(th, "ALManager", "doLBSLocation reStartService");
                }
                if (i()) {
                    this.A = false;
                    android.os.Bundle bundle = new android.os.Bundle();
                    bundle.putBundle("optBundle", com.loc.fv.a(this.b));
                    bundle.putString("d", com.amap.api.location.UmidtokenInfo.getUmidtoken());
                    if (!this.d.b()) {
                        a(1, bundle);
                    }
                }
            }
        } catch (java.lang.Throwable th2) {
            try {
                com.loc.fv.a(th2, "ALManager", "doLBSLocation");
                try {
                    if (this.b.isOnceLocation()) {
                        return;
                    }
                    o();
                } catch (java.lang.Throwable unused) {
                }
            } finally {
                try {
                    if (!this.b.isOnceLocation()) {
                        o();
                    }
                } catch (java.lang.Throwable unused2) {
                }
            }
        }
    }

    private void o() {
        if (this.b.getLocationMode() != com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Device_Sensors) {
            a(1016, (java.lang.Object) null, this.b.getInterval() >= 1000 ? this.b.getInterval() : 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        try {
            if (this.n == null) {
                this.n = new android.os.Messenger(this.c);
            }
            a(q());
        } catch (java.lang.Throwable unused) {
        }
    }

    private android.content.Intent q() {
        java.lang.String str;
        if (this.o == null) {
            this.o = new android.content.Intent(this.E, (java.lang.Class<?>) com.amap.api.location.APSService.class);
        }
        try {
            str = !android.text.TextUtils.isEmpty(com.amap.api.location.AMapLocationClientOption.getAPIKEY()) ? com.amap.api.location.AMapLocationClientOption.getAPIKEY() : com.loc.m.f(this.E);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "ALManager", "startServiceImpl p2");
            str = "";
        }
        this.o.putExtra("a", str);
        this.o.putExtra("b", com.loc.m.c(this.E));
        this.o.putExtra("d", com.amap.api.location.UmidtokenInfo.getUmidtoken());
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            new com.loc.es().f("#2001");
            sb.append("模糊权限下不支持低功耗定位#2001");
            com.loc.gb.a((java.lang.String) null, 2153);
            com.loc.ey eyVar = new com.loc.ey("");
            eyVar.setErrorCode(20);
            eyVar.setLocationDetail(sb.toString());
            g(eyVar);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "ALManager", "apsLocation:callback");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        com.loc.gb gbVar;
        android.content.Context context;
        int i;
        this.d.b(this.b);
        this.G.b(this.b);
        if (this.I && !this.b.getLocationMode().equals(this.f401s)) {
            l();
            j();
        }
        this.f401s = this.b.getLocationMode();
        if (this.u != null) {
            if (this.b.isOnceLocation()) {
                gbVar = this.u;
                context = this.E;
                i = 0;
            } else {
                gbVar = this.u;
                context = this.E;
                i = 1;
            }
            gbVar.a(context, i);
            this.u.a(this.E, this.b);
        }
    }

    private boolean t() {
        int i;
        if (com.loc.gd.j(this.E)) {
            try {
                i = com.loc.fz.b(((android.app.Application) this.E.getApplicationContext()).getBaseContext(), "checkSelfPermission", "android.permission.FOREGROUND_SERVICE");
            } catch (java.lang.Throwable unused) {
                i = -1;
            }
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public final void a(int i, android.app.Notification notification) {
        if (i == 0 || notification == null) {
            return;
        }
        try {
            if (this.k && this.m != null) {
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putBundle("optBundle", com.loc.fv.a(this.b));
                a(0, bundle);
                this.k = false;
            }
            android.os.Bundle bundle2 = new android.os.Bundle();
            bundle2.putInt("i", i);
            bundle2.putParcelable("h", notification);
            a(1023, bundle2, 0L);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "ALManager", "disableBackgroundLocation");
        }
    }

    public final void a(android.webkit.WebView webView) {
        if (this.P == null) {
            this.P = new com.loc.i(this.E, webView);
        }
        this.P.a();
    }

    public final void a(com.amap.api.location.AMapLocationClientOption aMapLocationClientOption) {
        try {
            this.O = aMapLocationClientOption.m14clone();
            a(1018, aMapLocationClientOption.m14clone(), 0L);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "ALManager", "setLocationOption");
        }
    }

    public final void a(com.amap.api.location.AMapLocationListener aMapLocationListener) {
        try {
            a(1002, aMapLocationListener, 0L);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "ALManager", "setLocationListener");
        }
    }

    public final void a(boolean z) {
        try {
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putBoolean("j", z);
            a(1024, bundle, 0L);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "ALManager", "disableBackgroundLocation");
        }
    }

    public final boolean a() {
        return this.H;
    }

    public final void b() {
        com.loc.d.c cVar;
        try {
            if (this.O.getCacheCallBack() && (cVar = this.c) != null) {
                cVar.sendEmptyMessageDelayed(13, this.O.getCacheCallBackTime());
            }
        } catch (java.lang.Throwable unused) {
        }
        try {
            a(1003, (java.lang.Object) null, 0L);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "ALManager", "startLocation");
        }
    }

    public final void b(com.amap.api.location.AMapLocationListener aMapLocationListener) {
        try {
            a(1005, aMapLocationListener, 0L);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "ALManager", "unRegisterLocationListener");
        }
    }

    public final void c() {
        try {
            a(1004, (java.lang.Object) null, 0L);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "ALManager", "stopLocation");
        }
    }

    public final void d() {
        try {
            com.loc.i iVar = this.P;
            if (iVar != null) {
                iVar.b();
                this.P = null;
            }
            a(1011, (java.lang.Object) null, 0L);
            this.r = true;
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "ALManager", "onDestroy");
        }
    }

    public final com.amap.api.location.AMapLocation e() {
        com.amap.api.location.AMapLocation aMapLocation = null;
        try {
            com.loc.j jVar = this.l;
            if (jVar != null && (aMapLocation = jVar.b()) != null) {
                aMapLocation.setTrustedLevel(3);
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "ALManager", "getLastKnownLocation");
        }
        return aMapLocation;
    }

    public final void f() {
        try {
            com.loc.i iVar = this.P;
            if (iVar != null) {
                iVar.b();
                this.P = null;
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "ALManager", "stopAssistantLocation");
        }
    }

    public final void g() {
        a(12, (android.os.Bundle) null);
        this.h = true;
        this.j = true;
        this.i = true;
        this.k = true;
        this.H = false;
        this.v = false;
        l();
        com.loc.gb gbVar = this.u;
        if (gbVar != null) {
            gbVar.b(this.E);
        }
        com.loc.ga.a(this.E).a();
        com.loc.gb.a(this.E);
        com.loc.e eVar = this.w;
        if (eVar != null) {
            eVar.b().sendEmptyMessage(11);
        } else {
            android.content.ServiceConnection serviceConnection = this.Q;
            if (serviceConnection != null) {
                this.E.unbindService(serviceConnection);
            }
        }
        try {
            if (this.D) {
                this.E.stopService(q());
            }
        } catch (java.lang.Throwable unused) {
        }
        this.D = false;
        java.util.ArrayList<com.amap.api.location.AMapLocationListener> arrayList = this.e;
        if (arrayList != null) {
            arrayList.clear();
            this.e = null;
        }
        this.Q = null;
        h();
        com.loc.d.b bVar = this.q;
        if (bVar != null) {
            try {
                com.loc.fz.a(bVar, (java.lang.Class<?>) android.os.HandlerThread.class, "quitSafely", new java.lang.Object[0]);
            } catch (java.lang.Throwable unused2) {
                this.q.quit();
            }
        }
        this.q = null;
        com.loc.d.c cVar = this.c;
        if (cVar != null) {
            cVar.removeCallbacksAndMessages(null);
        }
        com.loc.j jVar = this.l;
        if (jVar != null) {
            jVar.c();
            this.l = null;
        }
    }
}
