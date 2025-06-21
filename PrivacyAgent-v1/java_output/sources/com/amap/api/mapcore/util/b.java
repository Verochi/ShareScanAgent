package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class b implements com.amap.api.mapcore.util.a.InterfaceC0118a, com.amap.api.mapcore.util.ci.a, com.autonavi.base.amap.api.mapcore.IAMapDelegate, com.autonavi.base.amap.mapcore.interfaces.IAMapListener {
    private boolean A;
    private final com.autonavi.base.amap.api.mapcore.IGLSurfaceView B;
    private com.amap.api.mapcore.util.dw C;
    private final com.amap.api.maps.interfaces.IGlOverlayLayer D;
    private boolean E;
    private int F;
    private boolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private com.amap.api.mapcore.util.bz K;
    private com.amap.api.maps.LocationSource L;
    private boolean M;
    private com.amap.api.maps.model.Marker N;
    private com.autonavi.base.amap.api.mapcore.BaseOverlayImp O;
    private com.amap.api.maps.model.Marker P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private boolean U;
    private boolean V;
    private android.graphics.Rect W;
    private int X;
    private com.amap.api.maps.model.MyTrafficStyle Y;
    private java.lang.Thread Z;
    protected boolean a;
    private int aA;
    private int aB;
    private com.amap.api.mapcore.util.b.C0119b aC;
    private com.amap.api.mapcore.util.ce aD;
    private com.amap.api.maps.AMap.OnMultiPointClickListener aE;
    private com.amap.api.mapcore.util.a aF;
    private long aG;
    private com.amap.api.mapcore.util.b.a aH;
    private com.amap.api.mapcore.util.b.a aI;
    private com.amap.api.mapcore.util.b.a aJ;
    private com.amap.api.mapcore.util.b.a aK;
    private com.amap.api.mapcore.util.b.a aL;
    private com.amap.api.mapcore.util.b.a aM;
    private com.amap.api.mapcore.util.b.a aN;
    private com.amap.api.mapcore.util.b.a aO;
    private com.amap.api.mapcore.util.b.a aP;
    private com.amap.api.mapcore.util.b.a aQ;
    private com.amap.api.mapcore.util.b.a aR;
    private com.amap.api.mapcore.util.b.a aS;
    private java.lang.Runnable aT;
    private com.amap.api.mapcore.util.b.a aU;
    private com.autonavi.extra.b aV;
    private java.lang.String aW;
    private java.lang.String aX;
    private boolean aY;
    private boolean aZ;
    private java.lang.Thread aa;
    private boolean ab;
    private boolean ac;
    private int ad;
    private com.amap.api.maps.CustomRenderer ae;
    private int af;
    private int ag;
    private java.util.List<com.amap.api.mapcore.util.q> ah;
    private com.amap.api.mapcore.util.cg ai;
    private com.amap.api.mapcore.util.ci aj;
    private long ak;
    private com.autonavi.base.ae.gmap.GLMapRender al;
    private com.amap.api.mapcore.util.n am;
    private boolean an;
    private float ao;
    private float ap;
    private float aq;
    private boolean ar;
    private boolean as;
    private boolean at;
    private volatile boolean au;
    private volatile boolean av;
    private boolean aw;
    private boolean ax;
    private java.util.concurrent.locks.Lock ay;
    private int az;
    protected com.autonavi.base.amap.mapcore.MapConfig b;
    private int ba;
    private com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo bb;
    private long bc;
    private com.amap.api.mapcore.util.ai bd;
    private com.autonavi.amap.mapcore.IPoint[] be;
    protected com.amap.api.mapcore.util.ai c;
    com.amap.api.mapcore.util.dc d;
    protected android.content.Context e;
    protected com.autonavi.base.ae.gmap.GLMapEngine f;
    public int g;
    public int h;
    boolean i;
    protected final android.os.Handler j;
    android.graphics.Point k;
    protected java.lang.String l;
    float[] m;
    float[] n;
    float[] o;
    float[] p;
    java.lang.String q;
    java.lang.String r;

    /* renamed from: s, reason: collision with root package name */
    int f121s;
    private com.amap.api.mapcore.util.f t;
    private com.amap.api.mapcore.util.g u;
    private com.amap.api.maps.model.AMapGestureListener v;
    private com.amap.api.mapcore.util.aj w;
    private com.amap.api.maps.UiSettings x;
    private com.autonavi.base.amap.api.mapcore.IProjectionDelegate y;
    private final com.amap.api.mapcore.util.u z;

    /* renamed from: com.amap.api.mapcore.util.b$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.Handler {
        public AnonymousClass1(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(android.os.Message message) {
            int i;
            if (message == null || com.amap.api.mapcore.util.b.this.G) {
                return;
            }
            try {
                i = message.what;
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.gd.c(th, "AMapDelegateImp", "handleMessage");
                th.printStackTrace();
            }
            if (i == 2) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Key验证失败：[");
                java.lang.Object obj = message.obj;
                if (obj != null) {
                    sb.append(obj);
                } else {
                    sb.append(com.amap.api.mapcore.util.ew.b);
                }
                sb.append("]");
                return;
            }
            int i2 = 0;
            switch (i) {
                case 10:
                    com.amap.api.maps.model.CameraPosition cameraPosition = (com.amap.api.maps.model.CameraPosition) message.obj;
                    try {
                        java.util.List a = com.amap.api.mapcore.util.b.this.u.a(com.amap.api.maps.AMap.OnCameraChangeListener.class.hashCode());
                        if (cameraPosition != null && a != null && a.size() > 0) {
                            synchronized (a) {
                                java.util.Iterator it = a.iterator();
                                while (it.hasNext()) {
                                    ((com.amap.api.maps.AMap.OnCameraChangeListener) it.next()).onCameraChange(cameraPosition);
                                }
                            }
                        }
                    } catch (java.lang.Throwable th2) {
                        com.amap.api.mapcore.util.dl.a(th2);
                    }
                    com.amap.api.mapcore.util.b.this.b.addChangedCounter();
                    return;
                case 11:
                    try {
                        com.amap.api.maps.model.CameraPosition cameraPosition2 = com.amap.api.mapcore.util.b.this.getCameraPosition();
                        if (cameraPosition2 != null && com.amap.api.mapcore.util.b.this.C != null) {
                            com.amap.api.mapcore.util.b.this.C.a(cameraPosition2);
                        }
                        com.amap.api.mapcore.util.b.this.b(cameraPosition2);
                        if (com.amap.api.mapcore.util.b.this.at) {
                            com.amap.api.mapcore.util.b.e(com.amap.api.mapcore.util.b.this);
                            if (com.amap.api.mapcore.util.b.this.D != null) {
                                com.amap.api.mapcore.util.b.this.D.setFlingState(false);
                            }
                            com.amap.api.mapcore.util.b.this.b();
                        }
                        if (com.amap.api.mapcore.util.b.this.T) {
                            com.amap.api.mapcore.util.b.this.redrawInfoWindow();
                            com.amap.api.mapcore.util.b.h(com.amap.api.mapcore.util.b.this);
                        }
                        com.amap.api.mapcore.util.b.this.a(cameraPosition2);
                        return;
                    } catch (java.lang.Throwable th3) {
                        com.amap.api.mapcore.util.gd.c(th3, "AMapDelegateImp", "CameraUpdateFinish");
                        com.amap.api.mapcore.util.dl.a(th3);
                        return;
                    }
                case 12:
                    if (com.amap.api.mapcore.util.b.this.C != null) {
                        com.amap.api.mapcore.util.b.this.C.a(java.lang.Float.valueOf(com.amap.api.mapcore.util.b.this.getZoomLevel()));
                        return;
                    }
                    return;
                case 13:
                    if (com.amap.api.mapcore.util.b.this.C != null) {
                        com.amap.api.mapcore.util.b.this.C.h();
                        return;
                    }
                    return;
                case 14:
                    try {
                        java.util.List a2 = com.amap.api.mapcore.util.b.this.u.a(com.amap.api.maps.AMap.OnMapTouchListener.class.hashCode());
                        if (a2 == null || a2.size() <= 0) {
                            return;
                        }
                        synchronized (a2) {
                            java.util.Iterator it2 = a2.iterator();
                            while (it2.hasNext()) {
                                ((com.amap.api.maps.AMap.OnMapTouchListener) it2.next()).onTouch((android.view.MotionEvent) message.obj);
                            }
                        }
                        return;
                    } catch (java.lang.Throwable th4) {
                        com.amap.api.mapcore.util.gd.c(th4, "AMapDelegateImp", "onTouchHandler");
                        th4.printStackTrace();
                        return;
                    }
                case 15:
                    android.graphics.Bitmap bitmap = (android.graphics.Bitmap) message.obj;
                    int i3 = message.arg1;
                    if (bitmap == null || com.amap.api.mapcore.util.b.this.C == null) {
                        try {
                            java.util.List a3 = com.amap.api.mapcore.util.b.this.u.a(com.amap.api.maps.AMap.onMapPrintScreenListener.class.hashCode());
                            java.util.ArrayList arrayList = a3 != null ? new java.util.ArrayList(a3) : null;
                            java.util.List a4 = com.amap.api.mapcore.util.b.this.u.a(com.amap.api.maps.AMap.OnMapScreenShotListener.class.hashCode());
                            java.util.ArrayList arrayList2 = a4 != null ? new java.util.ArrayList(a4) : null;
                            com.amap.api.mapcore.util.b.this.u.a(java.lang.Integer.valueOf(com.amap.api.maps.AMap.onMapPrintScreenListener.class.hashCode()));
                            com.amap.api.mapcore.util.b.this.u.a(java.lang.Integer.valueOf(com.amap.api.maps.AMap.OnMapScreenShotListener.class.hashCode()));
                            if (arrayList != null && arrayList.size() > 0) {
                                synchronized (arrayList) {
                                    for (int i4 = 0; i4 < arrayList.size(); i4++) {
                                        ((com.amap.api.maps.AMap.onMapPrintScreenListener) arrayList.get(i4)).onMapPrint(null);
                                    }
                                }
                            }
                            if (arrayList2 == null || arrayList2.size() <= 0) {
                                return;
                            }
                            synchronized (arrayList2) {
                                while (i2 < arrayList2.size()) {
                                    ((com.amap.api.maps.AMap.OnMapScreenShotListener) arrayList2.get(i2)).onMapScreenShot(null);
                                    ((com.amap.api.maps.AMap.OnMapScreenShotListener) arrayList2.get(i2)).onMapScreenShot(null, i3);
                                    i2++;
                                }
                            }
                            return;
                        } catch (java.lang.Throwable th5) {
                            th5.printStackTrace();
                            return;
                        }
                    }
                    android.graphics.Canvas canvas = new android.graphics.Canvas(bitmap);
                    com.amap.api.mapcore.util.dz f = com.amap.api.mapcore.util.b.this.C.f();
                    if (f != null) {
                        f.onDraw(canvas);
                    }
                    com.amap.api.mapcore.util.b.this.C.a(canvas);
                    try {
                        java.util.List a5 = com.amap.api.mapcore.util.b.this.u.a(com.amap.api.maps.AMap.onMapPrintScreenListener.class.hashCode());
                        java.util.ArrayList arrayList3 = a5 != null ? new java.util.ArrayList(a5) : null;
                        java.util.List a6 = com.amap.api.mapcore.util.b.this.u.a(com.amap.api.maps.AMap.OnMapScreenShotListener.class.hashCode());
                        java.util.ArrayList arrayList4 = a6 != null ? new java.util.ArrayList(a6) : null;
                        com.amap.api.mapcore.util.b.this.u.a(java.lang.Integer.valueOf(com.amap.api.maps.AMap.onMapPrintScreenListener.class.hashCode()));
                        com.amap.api.mapcore.util.b.this.u.a(java.lang.Integer.valueOf(com.amap.api.maps.AMap.OnMapScreenShotListener.class.hashCode()));
                        if (arrayList3 != null && arrayList3.size() > 0) {
                            synchronized (arrayList3) {
                                for (int i5 = 0; i5 < arrayList3.size(); i5++) {
                                    ((com.amap.api.maps.AMap.onMapPrintScreenListener) arrayList3.get(i5)).onMapPrint(new android.graphics.drawable.BitmapDrawable(com.amap.api.mapcore.util.b.this.e.getResources(), bitmap));
                                }
                            }
                        }
                        if (arrayList4 == null || arrayList4.size() <= 0) {
                            return;
                        }
                        synchronized (arrayList4) {
                            while (i2 < arrayList4.size()) {
                                ((com.amap.api.maps.AMap.OnMapScreenShotListener) arrayList4.get(i2)).onMapScreenShot(bitmap);
                                ((com.amap.api.maps.AMap.OnMapScreenShotListener) arrayList4.get(i2)).onMapScreenShot(bitmap, i3);
                                i2++;
                            }
                        }
                        return;
                    } catch (java.lang.Throwable th6) {
                        th6.printStackTrace();
                        return;
                    }
                case 16:
                    try {
                        java.util.List a7 = com.amap.api.mapcore.util.b.this.u.a(com.amap.api.maps.AMap.OnMapLoadedListener.class.hashCode());
                        if (a7 != null) {
                            synchronized (a7) {
                                while (i2 < a7.size()) {
                                    ((com.amap.api.maps.AMap.OnMapLoadedListener) a7.get(i2)).onMapLoaded();
                                    i2++;
                                }
                            }
                        }
                    } catch (java.lang.Throwable th7) {
                        com.amap.api.mapcore.util.gd.c(th7, "AMapDelegateImp", "onMapLoaded");
                        th7.printStackTrace();
                        com.amap.api.mapcore.util.dl.a(th7);
                    }
                    if (com.amap.api.mapcore.util.b.this.C != null) {
                        com.amap.api.mapcore.util.b.this.C.i();
                        return;
                    }
                    return;
                case 17:
                    com.amap.api.mapcore.util.b bVar = com.amap.api.mapcore.util.b.this;
                    if (!bVar.f.isInMapAnimation(bVar.F) || com.amap.api.mapcore.util.b.this.D == null) {
                        return;
                    }
                    com.amap.api.mapcore.util.b.this.D.setFlingState(false);
                    return;
                case 18:
                    if (com.amap.api.mapcore.util.b.this.w != null) {
                        com.amap.api.mapcore.util.b.this.w.b();
                        return;
                    }
                    return;
                case 19:
                    java.util.List a8 = com.amap.api.mapcore.util.b.this.u.a(com.amap.api.maps.AMap.OnMapClickListener.class.hashCode());
                    if (a8 != null) {
                        com.autonavi.amap.mapcore.DPoint obtain = com.autonavi.amap.mapcore.DPoint.obtain();
                        com.amap.api.mapcore.util.b.this.getPixel2LatLng(message.arg1, message.arg2, obtain);
                        try {
                            synchronized (a8) {
                                java.util.Iterator it3 = a8.iterator();
                                while (it3.hasNext()) {
                                    ((com.amap.api.maps.AMap.OnMapClickListener) it3.next()).onMapClick(new com.amap.api.maps.model.LatLng(obtain.y, obtain.x));
                                }
                            }
                            obtain.recycle();
                            return;
                        } catch (java.lang.Throwable th8) {
                            com.amap.api.mapcore.util.gd.c(th8, "AMapDelegateImp", "OnMapClickListener.onMapClick");
                            th8.printStackTrace();
                            return;
                        }
                    }
                    return;
                case 20:
                    try {
                        java.util.List a9 = com.amap.api.mapcore.util.b.this.u.a(com.amap.api.maps.AMap.OnPOIClickListener.class.hashCode());
                        if (a9 == null || a9.size() <= 0) {
                            return;
                        }
                        synchronized (a9) {
                            while (i2 < a9.size()) {
                                ((com.amap.api.maps.AMap.OnPOIClickListener) a9.get(i2)).onPOIClick((com.amap.api.maps.model.Poi) message.obj);
                                i2++;
                            }
                        }
                        return;
                    } catch (java.lang.Throwable th9) {
                        com.amap.api.mapcore.util.gd.c(th9, "AMapDelegateImp", "OnPOIClickListener.onPOIClick");
                        th9.printStackTrace();
                        return;
                    }
                default:
                    return;
            }
            com.amap.api.mapcore.util.gd.c(th, "AMapDelegateImp", "handleMessage");
            th.printStackTrace();
        }
    }

    /* renamed from: com.amap.api.mapcore.util.b$10, reason: invalid class name */
    public class AnonymousClass10 implements java.lang.Runnable {
        final /* synthetic */ com.amap.api.mapcore.util.dr a;

        public AnonymousClass10(com.amap.api.mapcore.util.dr drVar) {
            this.a = drVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.amap.api.mapcore.util.b.this.H) {
                return;
            }
            try {
                com.amap.api.mapcore.util.b bVar = com.amap.api.mapcore.util.b.this;
                com.amap.api.mapcore.util.ai aiVar = bVar.c;
                if (aiVar != null) {
                    bVar.setIndoorBuildingInfo(aiVar);
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
            this.a.a();
        }
    }

    /* renamed from: com.amap.api.mapcore.util.b$11, reason: invalid class name */
    public class AnonymousClass11 extends com.amap.api.mapcore.util.b.a {
        public AnonymousClass11() {
            super((byte) 0);
        }

        @Override // com.amap.api.mapcore.util.b.a, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                com.amap.api.mapcore.util.b.this.setTrafficEnabled(this.c);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.b$12, reason: invalid class name */
    public class AnonymousClass12 implements java.lang.Runnable {
        final /* synthetic */ int a;

        public AnonymousClass12(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.autonavi.base.ae.gmap.GLMapEngine gLMapEngine;
            if (!com.amap.api.mapcore.util.b.this.au || (gLMapEngine = com.amap.api.mapcore.util.b.this.f) == null) {
                return;
            }
            gLMapEngine.setHighlightSubwayEnable(this.a, false);
        }
    }

    /* renamed from: com.amap.api.mapcore.util.b$13, reason: invalid class name */
    public class AnonymousClass13 implements java.lang.Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;
        final /* synthetic */ int d;
        final /* synthetic */ boolean e;
        final /* synthetic */ boolean f;
        final /* synthetic */ com.autonavi.base.ae.gmap.style.StyleItem[] g;

        public AnonymousClass13(int i, int i2, int i3, int i4, boolean z, boolean z2, com.autonavi.base.ae.gmap.style.StyleItem[] styleItemArr) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = z;
            this.f = z2;
            this.g = styleItemArr;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.amap.api.mapcore.util.b.this.f.setMapModeAndStyle(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.b$14, reason: invalid class name */
    public class AnonymousClass14 implements java.lang.Runnable {
        final /* synthetic */ int a;

        public AnonymousClass14(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.amap.api.mapcore.util.b.this.f.clearAllMessages(this.a);
                com.amap.api.mapcore.util.b.this.f.clearAnimations(this.a, true);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.b$15, reason: invalid class name */
    public class AnonymousClass15 implements java.lang.Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ boolean b;

        public AnonymousClass15(int i, boolean z) {
            this.a = i;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.amap.api.mapcore.util.b.this.f.setBuildingEnable(this.a, this.b);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.b$16, reason: invalid class name */
    public class AnonymousClass16 implements java.lang.Runnable {
        final /* synthetic */ boolean a;
        final /* synthetic */ int b;

        public AnonymousClass16(boolean z, int i) {
            this.a = z;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.autonavi.base.ae.gmap.GLMapEngine gLMapEngine = com.amap.api.mapcore.util.b.this.f;
            if (gLMapEngine != null) {
                if (this.a) {
                    gLMapEngine.setAllContentEnable(this.b, true);
                } else {
                    gLMapEngine.setAllContentEnable(this.b, false);
                }
                com.amap.api.mapcore.util.b.this.f.setSimple3DEnable(this.b, false);
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.b$17, reason: invalid class name */
    public class AnonymousClass17 implements java.lang.Runnable {
        final /* synthetic */ boolean a;
        final /* synthetic */ int b;

        public AnonymousClass17(boolean z, int i) {
            this.a = z;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (this.a) {
                    com.amap.api.mapcore.util.b.this.f.setBuildingTextureEnable(this.b, true);
                } else {
                    com.amap.api.mapcore.util.b.this.f.setBuildingTextureEnable(this.b, false);
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.b$18, reason: invalid class name */
    public class AnonymousClass18 implements java.lang.Runnable {
        final /* synthetic */ com.amap.api.maps.model.LatLngBounds.Builder a;

        public AnonymousClass18(com.amap.api.maps.model.LatLngBounds.Builder builder) {
            this.a = builder;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.amap.api.mapcore.util.b.this.moveCamera(com.amap.api.mapcore.util.z.a(this.a.build(), 50));
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.b$19, reason: invalid class name */
    public class AnonymousClass19 implements java.lang.Runnable {
        public AnonymousClass19() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.amap.api.mapcore.util.b bVar = com.amap.api.mapcore.util.b.this;
            if (bVar.f == null || bVar.G) {
                return;
            }
            com.amap.api.mapcore.util.b bVar2 = com.amap.api.mapcore.util.b.this;
            bVar2.f.removeNativeAllOverlay(bVar2.F);
        }
    }

    /* renamed from: com.amap.api.mapcore.util.b$2, reason: invalid class name */
    public class AnonymousClass2 extends com.amap.api.mapcore.util.b.a {
        public AnonymousClass2() {
            super((byte) 0);
        }

        @Override // com.amap.api.mapcore.util.b.a, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                com.amap.api.mapcore.util.b.this.setConstructingRoadEnable(this.c);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.b$20, reason: invalid class name */
    public class AnonymousClass20 implements java.lang.Runnable {
        final /* synthetic */ boolean a;
        final /* synthetic */ boolean b;

        public AnonymousClass20(boolean z, boolean z2) {
            this.a = z;
            this.b = z2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (com.amap.api.mapcore.util.b.this.b.isTrafficEnabled() != this.a) {
                    com.amap.api.mapcore.util.b.this.b.setTrafficEnabled(this.b);
                    com.amap.api.mapcore.util.b.this.al.setTrafficMode(this.a);
                    com.amap.api.mapcore.util.b bVar = com.amap.api.mapcore.util.b.this;
                    bVar.f.setTrafficEnable(bVar.F, this.a);
                    com.amap.api.mapcore.util.b.this.resetRenderTime();
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                com.amap.api.mapcore.util.dl.a(th);
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.b$21, reason: invalid class name */
    public class AnonymousClass21 extends com.amap.api.mapcore.util.b.a {
        public AnonymousClass21() {
            super((byte) 0);
        }

        @Override // com.amap.api.mapcore.util.b.a, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                com.amap.api.mapcore.util.b bVar = com.amap.api.mapcore.util.b.this;
                bVar.setCenterToPixel(bVar.aA, com.amap.api.mapcore.util.b.this.aB);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.b$22, reason: invalid class name */
    public class AnonymousClass22 implements java.lang.Runnable {
        final /* synthetic */ boolean a;

        public AnonymousClass22(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.a) {
                com.amap.api.mapcore.util.b.this.showIndoorSwitchControlsEnabled(true);
            } else if (com.amap.api.mapcore.util.b.this.C != null) {
                com.amap.api.mapcore.util.b.this.C.i(java.lang.Boolean.FALSE);
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.b$23, reason: invalid class name */
    public class AnonymousClass23 implements java.lang.Runnable {
        final /* synthetic */ boolean a;

        public AnonymousClass23(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.amap.api.mapcore.util.b bVar = com.amap.api.mapcore.util.b.this;
            com.autonavi.base.ae.gmap.GLMapEngine gLMapEngine = bVar.f;
            if (gLMapEngine != null) {
                gLMapEngine.setOfflineDataEnable(bVar.F, this.a);
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.b$24, reason: invalid class name */
    public class AnonymousClass24 implements java.lang.Runnable {
        final /* synthetic */ boolean a;

        public AnonymousClass24(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.amap.api.mapcore.util.b bVar = com.amap.api.mapcore.util.b.this;
                bVar.f.setLabelEnable(bVar.F, this.a);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.b$25, reason: invalid class name */
    public class AnonymousClass25 implements java.lang.Runnable {
        final /* synthetic */ boolean a;

        public AnonymousClass25(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.amap.api.mapcore.util.b bVar = com.amap.api.mapcore.util.b.this;
                bVar.f.setRoadArrowEnable(bVar.F, this.a);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.b$26, reason: invalid class name */
    public class AnonymousClass26 implements java.lang.Runnable {
        final /* synthetic */ boolean a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;

        public AnonymousClass26(boolean z, int i, int i2) {
            this.a = z;
            this.b = i;
            this.c = i2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.amap.api.mapcore.util.b bVar = com.amap.api.mapcore.util.b.this;
                bVar.f.setNaviLabelEnable(bVar.F, this.a, this.b, this.c);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.b$27, reason: invalid class name */
    public class AnonymousClass27 implements java.lang.Runnable {
        final /* synthetic */ boolean a;

        public AnonymousClass27(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.amap.api.mapcore.util.b.this.f.setMapOpenLayerEnable(this.a);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.b$28, reason: invalid class name */
    public class AnonymousClass28 implements java.lang.Runnable {
        final /* synthetic */ byte[] a;

        public AnonymousClass28(byte[] bArr) {
            this.a = bArr;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.amap.api.mapcore.util.b bVar = com.amap.api.mapcore.util.b.this;
                bVar.f.setTrafficStyleWithTextureData(bVar.F, this.a);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.b$29, reason: invalid class name */
    public class AnonymousClass29 implements java.lang.Runnable {
        public AnonymousClass29() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.amap.api.mapcore.util.b bVar = com.amap.api.mapcore.util.b.this;
                bVar.b.setAnchorX(java.lang.Math.max(0, java.lang.Math.min(bVar.aA, com.amap.api.mapcore.util.b.this.g)));
                com.amap.api.mapcore.util.b bVar2 = com.amap.api.mapcore.util.b.this;
                bVar2.b.setAnchorY(java.lang.Math.max(0, java.lang.Math.min(bVar2.aB, com.amap.api.mapcore.util.b.this.h)));
                com.amap.api.mapcore.util.b bVar3 = com.amap.api.mapcore.util.b.this;
                bVar3.f.setProjectionCenter(bVar3.F, com.amap.api.mapcore.util.b.this.b.getAnchorX(), com.amap.api.mapcore.util.b.this.b.getAnchorY());
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.b$3, reason: invalid class name */
    public class AnonymousClass3 extends com.amap.api.mapcore.util.b.a {
        public AnonymousClass3() {
            super((byte) 0);
        }

        @Override // com.amap.api.mapcore.util.b.a, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                com.amap.api.mapcore.util.b.this.setTrafficStyleWithTextureData(this.j);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.b$30, reason: invalid class name */
    public class AnonymousClass30 implements java.lang.Runnable {
        public AnonymousClass30() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.amap.api.mapcore.util.b bVar = com.amap.api.mapcore.util.b.this;
            com.autonavi.base.ae.gmap.GLMapEngine gLMapEngine = bVar.f;
            if (gLMapEngine != null) {
                int i = bVar.F;
                com.amap.api.mapcore.util.ai aiVar = com.amap.api.mapcore.util.b.this.c;
                gLMapEngine.setIndoorBuildingToBeActive(i, aiVar.activeFloorName, aiVar.activeFloorIndex, aiVar.poiid);
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.b$31, reason: invalid class name */
    public class AnonymousClass31 implements java.lang.Runnable {
        public AnonymousClass31() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.amap.api.mapcore.util.b.this.aC != null) {
                com.amap.api.mapcore.util.b.this.aC.a(com.amap.api.mapcore.util.b.this.bd);
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.b$32, reason: invalid class name */
    public class AnonymousClass32 extends com.amap.api.mapcore.util.b.a {
        public AnonymousClass32() {
            super((byte) 0);
        }

        @Override // com.amap.api.mapcore.util.b.a, java.lang.Runnable
        public final void run() {
            super.run();
            com.amap.api.mapcore.util.b.this.a(this.g, this.d, this.e, this.f);
        }
    }

    /* renamed from: com.amap.api.mapcore.util.b$33, reason: invalid class name */
    public class AnonymousClass33 implements java.lang.Runnable {
        public AnonymousClass33() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.amap.api.mapcore.util.b bVar = com.amap.api.mapcore.util.b.this;
                bVar.destroySurface(bVar.F);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                com.amap.api.mapcore.util.dl.a(th);
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.b$34, reason: invalid class name */
    public class AnonymousClass34 implements java.lang.Runnable {
        final /* synthetic */ com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay a;

        public AnonymousClass34(com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay crossVectorOverlay) {
            this.a = crossVectorOverlay;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.autonavi.base.ae.gmap.gloverlay.GLOverlayBundle overlayBundle;
            com.amap.api.mapcore.util.b bVar = com.amap.api.mapcore.util.b.this;
            com.autonavi.base.ae.gmap.GLMapEngine gLMapEngine = bVar.f;
            if (gLMapEngine == null || (overlayBundle = gLMapEngine.getOverlayBundle(bVar.F)) == null) {
                return;
            }
            overlayBundle.addOverlay(this.a);
        }
    }

    /* renamed from: com.amap.api.mapcore.util.b$35, reason: invalid class name */
    public class AnonymousClass35 implements java.lang.Runnable {
        final /* synthetic */ com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay a;

        public AnonymousClass35(com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay baseMapOverlay) {
            this.a = baseMapOverlay;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.amap.api.mapcore.util.b bVar = com.amap.api.mapcore.util.b.this;
            bVar.f.getOverlayBundle(bVar.F).removeOverlay(this.a);
        }
    }

    /* renamed from: com.amap.api.mapcore.util.b$36, reason: invalid class name */
    public class AnonymousClass36 extends com.amap.api.mapcore.util.b.a {
        public AnonymousClass36() {
            super((byte) 0);
        }

        @Override // com.amap.api.mapcore.util.b.a, java.lang.Runnable
        public final void run() {
            super.run();
            com.amap.api.mapcore.util.b.this.setMapCustomEnable(this.c);
        }
    }

    /* renamed from: com.amap.api.mapcore.util.b$37, reason: invalid class name */
    public class AnonymousClass37 extends com.amap.api.mapcore.util.b.a {
        public AnonymousClass37() {
            super((byte) 0);
        }

        @Override // com.amap.api.mapcore.util.b.a, java.lang.Runnable
        public final void run() {
            super.run();
            com.amap.api.mapcore.util.b.this.a(this.g, this.c);
        }
    }

    /* renamed from: com.amap.api.mapcore.util.b$38, reason: invalid class name */
    public class AnonymousClass38 extends com.amap.api.mapcore.util.b.a {
        public AnonymousClass38() {
            super((byte) 0);
        }

        @Override // com.amap.api.mapcore.util.b.a, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                com.amap.api.mapcore.util.b.this.setMapTextEnable(this.c);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.b$39, reason: invalid class name */
    public class AnonymousClass39 extends com.amap.api.mapcore.util.b.a {
        public AnonymousClass39() {
            super((byte) 0);
        }

        @Override // com.amap.api.mapcore.util.b.a, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                com.amap.api.mapcore.util.b.this.setRoadArrowEnable(this.c);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.b$4, reason: invalid class name */
    public class AnonymousClass4 extends com.amap.api.mapcore.util.b.a {
        public AnonymousClass4() {
            super((byte) 0);
        }

        @Override // com.amap.api.mapcore.util.b.a, java.lang.Runnable
        public final void run() {
            super.run();
            com.amap.api.mapcore.util.b.this.b(this.g, this.c);
        }
    }

    /* renamed from: com.amap.api.mapcore.util.b$40, reason: invalid class name */
    public class AnonymousClass40 extends com.amap.api.mapcore.util.b.a {
        public AnonymousClass40() {
            super((byte) 0);
        }

        @Override // com.amap.api.mapcore.util.b.a, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                com.amap.api.mapcore.util.b.this.setNaviLabelEnable(this.c, this.h, this.i);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.b$5, reason: invalid class name */
    public class AnonymousClass5 extends com.amap.api.mapcore.util.b.a {
        public AnonymousClass5() {
            super((byte) 0);
        }

        @Override // com.amap.api.mapcore.util.b.a, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                com.amap.api.mapcore.util.b.this.setIndoorEnabled(this.c);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.b$6, reason: invalid class name */
    public class AnonymousClass6 implements java.lang.Runnable {
        public AnonymousClass6() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.amap.api.mapcore.util.dz f;
            if (com.amap.api.mapcore.util.b.this.C == null || (f = com.amap.api.mapcore.util.b.this.C.f()) == null) {
                return;
            }
            f.c();
        }
    }

    /* renamed from: com.amap.api.mapcore.util.b$7, reason: invalid class name */
    public class AnonymousClass7 extends com.amap.api.mapcore.util.b.a {
        public AnonymousClass7() {
            super((byte) 0);
        }

        @Override // com.amap.api.mapcore.util.b.a, java.lang.Runnable
        public final void run() {
            super.run();
            com.amap.api.mapcore.util.b.this.c(this.g, this.c);
        }
    }

    /* renamed from: com.amap.api.mapcore.util.b$8, reason: invalid class name */
    public class AnonymousClass8 implements java.lang.Runnable {
        final /* synthetic */ android.view.MotionEvent a;

        public AnonymousClass8(android.view.MotionEvent motionEvent) {
            this.a = motionEvent;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                android.os.Message obtain = android.os.Message.obtain();
                com.autonavi.base.amap.mapcore.MapConfig mapConfig = com.amap.api.mapcore.util.b.this.b;
                com.amap.api.maps.model.Poi b = (mapConfig == null || !mapConfig.isTouchPoiEnable()) ? null : com.amap.api.mapcore.util.b.this.b((int) this.a.getX(), (int) this.a.getY());
                java.util.List a = com.amap.api.mapcore.util.b.this.u.a(com.amap.api.maps.AMap.OnPOIClickListener.class.hashCode());
                if (a == null || a.size() <= 0 || b == null) {
                    com.amap.api.mapcore.util.b.this.c(this.a);
                    return;
                }
                obtain.what = 20;
                obtain.obj = b;
                com.amap.api.mapcore.util.b.this.j.sendMessage(obtain);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.b$9, reason: invalid class name */
    public class AnonymousClass9 implements java.lang.Runnable {
        final /* synthetic */ android.view.MotionEvent a;

        public AnonymousClass9(android.view.MotionEvent motionEvent) {
            this.a = motionEvent;
        }

        @Override // java.lang.Runnable
        public final void run() {
            android.os.Message obtain = android.os.Message.obtain();
            obtain.what = 19;
            obtain.arg1 = (int) this.a.getX();
            obtain.arg2 = (int) this.a.getY();
            com.amap.api.mapcore.util.b.this.j.sendMessage(obtain);
        }
    }

    public static abstract class a implements java.lang.Runnable {
        boolean b;
        boolean c;
        int d;
        int e;
        int f;
        int g;
        int h;
        int i;
        byte[] j;

        private a() {
            this.b = false;
            this.c = false;
            this.h = 0;
            this.i = 0;
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b = false;
        }
    }

    /* renamed from: com.amap.api.mapcore.util.b$b, reason: collision with other inner class name */
    public class C0119b {

        /* renamed from: com.amap.api.mapcore.util.b$b$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ com.amap.api.mapcore.util.dt a;

            public AnonymousClass1(com.amap.api.mapcore.util.dt dtVar) {
                this.a = dtVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.a(false);
            }
        }

        /* renamed from: com.amap.api.mapcore.util.b$b$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            final /* synthetic */ com.amap.api.mapcore.util.dt a;

            public AnonymousClass2(com.amap.api.mapcore.util.dt dtVar) {
                this.a = dtVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    this.a.a(com.amap.api.mapcore.util.b.this.c.floor_names);
                    this.a.a(com.amap.api.mapcore.util.b.this.c.activeFloorName);
                    if (this.a.b()) {
                        return;
                    }
                    this.a.a(true);
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        public C0119b() {
        }

        public final void a(com.amap.api.mapcore.util.ai aiVar) {
            java.util.List a;
            java.util.List a2;
            com.amap.api.mapcore.util.ai aiVar2;
            com.amap.api.mapcore.util.ai aiVar3;
            int[] iArr;
            java.lang.String[] strArr;
            com.autonavi.base.amap.mapcore.MapConfig mapConfig = com.amap.api.mapcore.util.b.this.b;
            if (mapConfig == null || !mapConfig.isIndoorEnable()) {
                return;
            }
            com.amap.api.mapcore.util.dt e = com.amap.api.mapcore.util.b.this.C.e();
            if (aiVar == null) {
                try {
                    java.util.List a3 = com.amap.api.mapcore.util.b.this.u.a(com.amap.api.maps.AMap.OnIndoorBuildingActiveListener.class.hashCode());
                    if (a3 != null && a3.size() > 0) {
                        synchronized (a3) {
                            for (int i = 0; i < a3.size(); i++) {
                                ((com.amap.api.maps.AMap.OnIndoorBuildingActiveListener) a3.get(i)).OnIndoorBuilding(aiVar);
                            }
                        }
                    }
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
                com.amap.api.mapcore.util.ai aiVar4 = com.amap.api.mapcore.util.b.this.c;
                if (aiVar4 != null) {
                    aiVar4.g = null;
                }
                if (e.b()) {
                    com.amap.api.mapcore.util.b.this.j.post(new com.amap.api.mapcore.util.b.C0119b.AnonymousClass1(e));
                }
                com.autonavi.base.amap.mapcore.MapConfig mapConfig2 = com.amap.api.mapcore.util.b.this.b;
                mapConfig2.maxZoomLevel = mapConfig2.isSetLimitZoomLevel() ? com.amap.api.mapcore.util.b.this.b.getMaxZoomLevel() : 20.0f;
                try {
                    if (!com.amap.api.mapcore.util.b.this.z.isZoomControlsEnabled() || (a = com.amap.api.mapcore.util.b.this.u.a(com.autonavi.base.ae.gmap.listener.AMapWidgetListener.class.hashCode())) == null || a.size() <= 0) {
                        return;
                    }
                    synchronized (a) {
                        for (int i2 = 0; i2 < a.size(); i2++) {
                            ((com.autonavi.base.ae.gmap.listener.AMapWidgetListener) a.get(i2)).invalidateZoomController(com.amap.api.mapcore.util.b.this.b.getSZ());
                        }
                    }
                    return;
                } catch (java.lang.Throwable th2) {
                    th2.printStackTrace();
                }
            }
            if (aiVar != null && (iArr = aiVar.floor_indexs) != null && (strArr = aiVar.floor_names) != null && iArr.length == strArr.length) {
                int i3 = 0;
                while (true) {
                    int[] iArr2 = aiVar.floor_indexs;
                    if (i3 >= iArr2.length) {
                        break;
                    }
                    if (aiVar.activeFloorIndex == iArr2[i3]) {
                        aiVar.activeFloorName = aiVar.floor_names[i3];
                        break;
                    }
                    i3++;
                }
            }
            if (aiVar == null || (aiVar3 = com.amap.api.mapcore.util.b.this.c) == null || aiVar3.activeFloorIndex == aiVar.activeFloorIndex || !e.b()) {
                if (aiVar != null && ((aiVar2 = com.amap.api.mapcore.util.b.this.c) == null || !aiVar2.poiid.equals(aiVar.poiid) || com.amap.api.mapcore.util.b.this.c.g == null)) {
                    com.amap.api.mapcore.util.b bVar = com.amap.api.mapcore.util.b.this;
                    bVar.c = aiVar;
                    if (bVar.b != null) {
                        if (aiVar.g == null) {
                            aiVar.g = new android.graphics.Point();
                        }
                        com.autonavi.amap.mapcore.DPoint mapGeoCenter = com.amap.api.mapcore.util.b.this.b.getMapGeoCenter();
                        if (mapGeoCenter != null) {
                            android.graphics.Point point = com.amap.api.mapcore.util.b.this.c.g;
                            point.x = (int) mapGeoCenter.x;
                            point.y = (int) mapGeoCenter.y;
                        }
                    }
                }
                try {
                    java.util.List a4 = com.amap.api.mapcore.util.b.this.u.a(com.amap.api.maps.AMap.OnIndoorBuildingActiveListener.class.hashCode());
                    if (a4 != null && a4.size() > 0) {
                        synchronized (a4) {
                            for (int i4 = 0; i4 < a4.size(); i4++) {
                                ((com.amap.api.maps.AMap.OnIndoorBuildingActiveListener) a4.get(i4)).OnIndoorBuilding(aiVar);
                            }
                        }
                    }
                    com.autonavi.base.amap.mapcore.MapConfig mapConfig3 = com.amap.api.mapcore.util.b.this.b;
                    mapConfig3.maxZoomLevel = mapConfig3.isSetLimitZoomLevel() ? com.amap.api.mapcore.util.b.this.b.getMaxZoomLevel() : 20.0f;
                    if (com.amap.api.mapcore.util.b.this.z.isZoomControlsEnabled() && (a2 = com.amap.api.mapcore.util.b.this.u.a(com.autonavi.base.ae.gmap.listener.AMapWidgetListener.class.hashCode())) != null && a2.size() > 0) {
                        synchronized (a2) {
                            for (int i5 = 0; i5 < a2.size(); i5++) {
                                ((com.autonavi.base.ae.gmap.listener.AMapWidgetListener) a2.get(i5)).invalidateZoomController(com.amap.api.mapcore.util.b.this.b.getSZ());
                            }
                        }
                    }
                    if (com.amap.api.mapcore.util.b.this.z.isIndoorSwitchEnabled()) {
                        if (!e.b()) {
                            com.amap.api.mapcore.util.b.this.z.setIndoorSwitchEnabled(true);
                        }
                        com.amap.api.mapcore.util.b.this.j.post(new com.amap.api.mapcore.util.b.C0119b.AnonymousClass2(e));
                    } else {
                        if (com.amap.api.mapcore.util.b.this.z.isIndoorSwitchEnabled() || !e.b()) {
                            return;
                        }
                        com.amap.api.mapcore.util.b.this.z.setIndoorSwitchEnabled(false);
                    }
                } catch (java.lang.Throwable th3) {
                    th3.printStackTrace();
                }
            }
        }
    }

    public class c implements com.amap.api.mapcore.util.dt.a {
        private c() {
        }

        public /* synthetic */ c(com.amap.api.mapcore.util.b bVar, byte b) {
            this();
        }

        @Override // com.amap.api.mapcore.util.dt.a
        public final void a(int i) {
            com.amap.api.mapcore.util.b bVar = com.amap.api.mapcore.util.b.this;
            com.amap.api.mapcore.util.ai aiVar = bVar.c;
            if (aiVar != null) {
                aiVar.activeFloorIndex = aiVar.floor_indexs[i];
                aiVar.activeFloorName = aiVar.floor_names[i];
                try {
                    bVar.setIndoorBuildingInfo(aiVar);
                } catch (android.os.RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public class d implements java.lang.Runnable {
        private android.content.Context b;
        private com.amap.api.maps.AMap.OnCacheRemoveListener c;

        public d(android.content.Context context, com.amap.api.maps.AMap.OnCacheRemoveListener onCacheRemoveListener) {
            this.b = context;
            this.c = onCacheRemoveListener;
        }

        public final boolean equals(java.lang.Object obj) {
            return obj instanceof com.amap.api.mapcore.util.b.d;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x003a, code lost:
        
            if (com.amap.api.mapcore.util.dl.e(r2) != false) goto L20;
         */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0046 A[Catch: all -> 0x0062, TRY_LEAVE, TryCatch #2 {all -> 0x0062, blocks: (B:3:0x0002, B:5:0x001b, B:11:0x003e, B:13:0x0046), top: B:2:0x0002 }] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0036 A[Catch: all -> 0x0030, TRY_LEAVE, TryCatch #1 {all -> 0x0030, blocks: (B:61:0x0023, B:9:0x0036), top: B:60:0x0023 }] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void run() {
            com.amap.api.maps.AMap.OnCacheRemoveListener onCacheRemoveListener;
            com.amap.api.maps.AMap.OnCacheRemoveListener onCacheRemoveListener2;
            com.amap.api.maps.AMap.OnCacheRemoveListener onCacheRemoveListener3;
            boolean z = true;
            try {
                android.content.Context applicationContext = this.b.getApplicationContext();
                java.lang.String c = com.amap.api.mapcore.util.dl.c(applicationContext);
                java.lang.String a = com.amap.api.mapcore.util.dl.a(applicationContext);
                java.io.File file = new java.io.File(c);
                boolean deleteFile = file.exists() ? com.autonavi.base.amap.mapcore.FileUtil.deleteFile(file) : true;
                try {
                    if (deleteFile) {
                        try {
                            if (com.autonavi.base.amap.mapcore.FileUtil.deleteFile(new java.io.File(a))) {
                                deleteFile = true;
                                if (deleteFile) {
                                }
                                z = false;
                                if (com.amap.api.mapcore.util.b.this.D != null) {
                                    com.amap.api.mapcore.util.b.this.D.clearTileCache();
                                }
                                if (com.amap.api.mapcore.util.b.this.f != null || (onCacheRemoveListener3 = this.c) == null) {
                                    return;
                                }
                                onCacheRemoveListener3.onRemoveCacheFinish(z);
                                return;
                            }
                        } catch (java.lang.Throwable th) {
                            th = th;
                            z = deleteFile;
                            try {
                                com.amap.api.mapcore.util.dl.a(th);
                                com.amap.api.mapcore.util.gd.c(th, "AMapDelegateImp", "RemoveCacheRunnable");
                                try {
                                    if (com.amap.api.mapcore.util.b.this.f == null || (onCacheRemoveListener2 = this.c) == null) {
                                        return;
                                    }
                                    onCacheRemoveListener2.onRemoveCacheFinish(false);
                                    return;
                                } catch (java.lang.Throwable th2) {
                                    th2.printStackTrace();
                                    return;
                                }
                            } catch (java.lang.Throwable th3) {
                                try {
                                    if (com.amap.api.mapcore.util.b.this.f != null && (onCacheRemoveListener = this.c) != null) {
                                        onCacheRemoveListener.onRemoveCacheFinish(z);
                                    }
                                } catch (java.lang.Throwable th4) {
                                    th4.printStackTrace();
                                }
                                throw th3;
                            }
                        }
                    }
                    if (com.amap.api.mapcore.util.b.this.f != null) {
                        return;
                    } else {
                        return;
                    }
                } catch (java.lang.Throwable th5) {
                    th5.printStackTrace();
                    return;
                }
                deleteFile = false;
                if (deleteFile) {
                }
                z = false;
                if (com.amap.api.mapcore.util.b.this.D != null) {
                }
            } catch (java.lang.Throwable th6) {
                th = th6;
            }
        }
    }

    public b(com.autonavi.base.amap.api.mapcore.IGLSurfaceView iGLSurfaceView, android.content.Context context) {
        this(iGLSurfaceView, context, false);
    }

    public b(com.autonavi.base.amap.api.mapcore.IGLSurfaceView iGLSurfaceView, android.content.Context context, boolean z) {
        this.t = null;
        this.u = new com.amap.api.mapcore.util.g();
        this.a = false;
        this.A = false;
        this.E = false;
        this.G = false;
        this.H = false;
        this.b = new com.autonavi.base.amap.mapcore.MapConfig(true);
        this.I = false;
        this.J = false;
        this.M = false;
        this.N = null;
        this.O = null;
        this.P = null;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = true;
        this.W = new android.graphics.Rect();
        this.X = 1;
        this.Y = null;
        this.ab = false;
        this.ac = false;
        this.ad = 0;
        this.af = -1;
        this.ag = -1;
        this.ah = new java.util.ArrayList();
        this.d = null;
        this.ak = -1L;
        this.an = false;
        this.ao = 0.0f;
        this.ap = 1.0f;
        this.aq = 1.0f;
        this.ar = true;
        this.as = false;
        this.at = false;
        this.au = false;
        this.av = false;
        this.aw = false;
        this.ax = false;
        this.ay = new java.util.concurrent.locks.ReentrantLock();
        this.az = 0;
        this.i = true;
        this.j = new com.amap.api.mapcore.util.b.AnonymousClass1(android.os.Looper.getMainLooper());
        this.aH = new com.amap.api.mapcore.util.b.AnonymousClass11();
        this.aI = new com.amap.api.mapcore.util.b.AnonymousClass21();
        this.aJ = new com.amap.api.mapcore.util.b.AnonymousClass32();
        this.aK = new com.amap.api.mapcore.util.b.AnonymousClass36();
        this.aL = new com.amap.api.mapcore.util.b.AnonymousClass37();
        this.aM = new com.amap.api.mapcore.util.b.AnonymousClass38();
        this.aN = new com.amap.api.mapcore.util.b.AnonymousClass39();
        this.aO = new com.amap.api.mapcore.util.b.AnonymousClass40();
        this.aP = new com.amap.api.mapcore.util.b.AnonymousClass2();
        this.aQ = new com.amap.api.mapcore.util.b.AnonymousClass3();
        this.aR = new com.amap.api.mapcore.util.b.AnonymousClass4();
        this.aS = new com.amap.api.mapcore.util.b.AnonymousClass5();
        this.aT = new com.amap.api.mapcore.util.b.AnonymousClass6();
        this.aU = new com.amap.api.mapcore.util.b.AnonymousClass7();
        this.aW = "";
        this.aX = "";
        this.aY = false;
        this.aZ = false;
        this.ba = 0;
        this.bb = new com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo();
        this.k = new android.graphics.Point();
        this.bc = 0L;
        this.l = null;
        this.bd = null;
        this.m = new float[16];
        this.n = new float[16];
        this.o = new float[16];
        this.be = null;
        this.p = new float[12];
        this.q = "precision highp float;\nattribute vec3 aVertex;//顶点数组,三维坐标\nuniform mat4 aMVPMatrix;//mvp矩阵\nvoid main(){\n  gl_Position = aMVPMatrix * vec4(aVertex, 1.0);\n}";
        this.r = "//有颜色 没有纹理\nprecision highp float;\nvoid main(){\n  gl_FragColor = vec4(1.0,0,0,1.0);\n}";
        this.f121s = -1;
        this.e = context;
        com.amap.api.mapcore.util.ff a2 = com.amap.api.mapcore.util.fe.a(context, com.amap.api.mapcore.util.dl.a());
        com.amap.api.mapcore.util.fe.c cVar = a2.a;
        com.amap.api.mapcore.util.fe.c cVar2 = com.amap.api.mapcore.util.fe.c.SuccessCode;
        if (cVar == cVar2) {
            com.amap.api.mapcore.util.dn.a(context);
            com.amap.api.mapcore.util.dn.a(com.amap.api.mapcore.util.dm.c, "init map delegate");
        }
        com.autonavi.extra.b bVar = new com.autonavi.extra.b();
        this.aV = bVar;
        bVar.a();
        this.aV.b();
        com.amap.api.mapcore.util.gd.a(this.e);
        com.amap.api.mapcore.util.cz.a().a(this.e);
        com.amap.api.mapcore.util.l.b = com.amap.api.mapcore.util.ev.c(context);
        com.amap.api.mapcore.util.cq.a(this.e);
        this.am = new com.amap.api.mapcore.util.n(this);
        com.autonavi.base.ae.gmap.GLMapRender gLMapRender = new com.autonavi.base.ae.gmap.GLMapRender(this);
        this.al = gLMapRender;
        this.B = iGLSurfaceView;
        iGLSurfaceView.setRenderer(gLMapRender);
        com.amap.api.mapcore.util.o oVar = new com.amap.api.mapcore.util.o(this, this.e);
        this.D = oVar;
        this.f = new com.autonavi.base.ae.gmap.GLMapEngine(this.e, this);
        this.C = new com.amap.api.mapcore.util.dv(this.e, this, oVar);
        this.z = new com.amap.api.mapcore.util.u(this);
        this.C.a(new com.amap.api.mapcore.util.b.c(this, (byte) 0));
        this.aC = new com.amap.api.mapcore.util.b.C0119b();
        iGLSurfaceView.setRenderMode(0);
        this.al.setRenderFps(15.0f);
        this.f.setMapListener(this);
        this.y = new com.amap.api.mapcore.util.r(this);
        this.t = new com.amap.api.mapcore.util.f(this);
        com.amap.api.mapcore.util.aj ajVar = new com.amap.api.mapcore.util.aj(this.e);
        this.w = ajVar;
        ajVar.a(this.C);
        this.w.b(new com.amap.api.mapcore.util.cb(oVar, context));
        this.Z = new com.amap.api.mapcore.util.j(this.e, this);
        this.L = new com.amap.api.mapcore.util.ak(this.e);
        this.ai = new com.amap.api.mapcore.util.cg(this.e, this);
        com.amap.api.mapcore.util.ci ciVar = new com.amap.api.mapcore.util.ci(this.e);
        this.aj = ciVar;
        ciVar.a(this);
        a(z);
        com.autonavi.base.amap.mapcore.MapConfig mapConfig = this.b;
        com.amap.api.mapcore.util.a aVar = new com.amap.api.mapcore.util.a(this, this.e, mapConfig != null ? mapConfig.isAbroadEnable() : false);
        this.aF = aVar;
        aVar.a(this);
        if (a2.a != cVar2) {
            this.b.setMapEnable(false);
        }
        this.F = this.f.getEngineIDWithType(1);
    }

    private int a(int i, android.graphics.Rect rect, int i2, int i3) {
        com.autonavi.base.ae.gmap.GLMapEngine gLMapEngine = this.f;
        if (gLMapEngine == null || i < 0) {
            return 0;
        }
        int engineIDWithType = gLMapEngine.getEngineIDWithType(i);
        if (this.f.isEngineCreated(engineIDWithType)) {
            a(engineIDWithType, rect.left, rect.top, rect.width(), rect.height(), i2, i3);
            return engineIDWithType;
        }
        int i4 = this.e.getResources().getDisplayMetrics().densityDpi;
        float f = this.e.getResources().getDisplayMetrics().density;
        this.ap = com.autonavi.base.ae.gmap.GLMapState.calMapZoomScalefactor(i2, i3, i4);
        com.autonavi.base.ae.gmap.bean.NativeTextGenerate.getInstance().setDensity(f);
        com.autonavi.base.ae.gmap.GLMapEngine.MapViewInitParam mapViewInitParam = new com.autonavi.base.ae.gmap.GLMapEngine.MapViewInitParam();
        mapViewInitParam.engineId = engineIDWithType;
        mapViewInitParam.x = rect.left;
        mapViewInitParam.y = rect.top;
        mapViewInitParam.width = rect.width();
        mapViewInitParam.height = rect.height();
        mapViewInitParam.screenWidth = i2;
        mapViewInitParam.screenHeight = i3;
        mapViewInitParam.screenScale = f;
        mapViewInitParam.textScale = this.aq * f;
        mapViewInitParam.mapZoomScale = this.ap;
        mapViewInitParam.taskThreadCount = 3;
        this.f.createAMapEngineWithFrame(mapViewInitParam);
        com.autonavi.base.ae.gmap.GLMapState mapState = this.f.getMapState(engineIDWithType);
        mapState.setMapZoomer(this.b.getSZ());
        mapState.setCameraDegree(this.b.getSC());
        mapState.setMapAngle(this.b.getSR());
        mapState.setMapGeoCenter(this.b.getSX(), this.b.getSY());
        this.f.setMapState(engineIDWithType, mapState);
        this.f.setOvelayBundle(engineIDWithType, new com.autonavi.base.ae.gmap.gloverlay.GLOverlayBundle<>(engineIDWithType, this));
        return engineIDWithType;
    }

    private java.util.ArrayList<com.autonavi.base.ae.gmap.glinterface.MapLabelItem> a(int i, int i2, int i3) {
        if (!this.au) {
            return null;
        }
        java.util.ArrayList<com.autonavi.base.ae.gmap.glinterface.MapLabelItem> arrayList = new java.util.ArrayList<>();
        byte[] labelBuffer = this.f.getLabelBuffer(i, i2, i3, 25);
        if (labelBuffer == null) {
            return null;
        }
        int i4 = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(labelBuffer, 0) > 0 ? 1 : 0;
        int i5 = 0;
        int i6 = 4;
        while (i5 < i4) {
            com.autonavi.base.ae.gmap.glinterface.MapLabelItem mapLabelItem = new com.autonavi.base.ae.gmap.glinterface.MapLabelItem();
            int i7 = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(labelBuffer, i6);
            int i8 = i6 + 4;
            int i9 = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(labelBuffer, i8);
            int i10 = i8 + 4;
            mapLabelItem.x = i7;
            mapLabelItem.y = this.B.getHeight() - i9;
            mapLabelItem.pixel20X = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(labelBuffer, i10);
            int i11 = i10 + 4;
            mapLabelItem.pixel20Y = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(labelBuffer, i11);
            int i12 = i11 + 4;
            mapLabelItem.pixel20Z = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(labelBuffer, i12);
            int i13 = i12 + 4;
            mapLabelItem.type = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(labelBuffer, i13);
            int i14 = i13 + 4;
            mapLabelItem.mSublayerId = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(labelBuffer, i14);
            int i15 = i14 + 4;
            mapLabelItem.timeStamp = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(labelBuffer, i15);
            int i16 = i15 + 4;
            mapLabelItem.mIsFouces = labelBuffer[i16] != 0;
            int i17 = i16 + 1;
            if (labelBuffer[i17] == 0) {
                mapLabelItem.poiid = null;
            } else {
                java.lang.String str = "";
                for (int i18 = 0; i18 < 20; i18++) {
                    int i19 = i18 + i17;
                    if (labelBuffer[i19] == 0) {
                        break;
                    }
                    str = str + ((char) labelBuffer[i19]);
                }
                mapLabelItem.poiid = str;
            }
            int i20 = i17 + 20;
            int i21 = i20 + 1;
            byte b = labelBuffer[i20];
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            for (int i22 = 0; i22 < b; i22++) {
                stringBuffer.append((char) com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getShort(labelBuffer, i21));
                i21 += 2;
            }
            mapLabelItem.name = stringBuffer.toString();
            arrayList.add(mapLabelItem);
            i5++;
            i6 = i21;
        }
        return arrayList;
    }

    private void a(int i) {
        int i2 = this.ag;
        if (i2 != -1) {
            this.al.setRenderFps(i2);
            resetRenderTime();
        } else if (this.f.isInMapAction(i) || this.as) {
            this.al.setRenderFps(40.0f);
        } else if (this.f.isInMapAnimation(i)) {
            this.al.setRenderFps(30.0f);
            this.al.resetTickCount(15);
        } else {
            this.al.setRenderFps(15.0f);
        }
        if (this.b.isWorldMapEnable() != com.amap.api.maps.MapsInitializer.isLoadWorldGridMap()) {
            b();
            this.b.setWorldMapEnable(com.amap.api.maps.MapsInitializer.isLoadWorldGridMap());
        }
    }

    private void a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        com.autonavi.base.ae.gmap.GLMapEngine gLMapEngine = this.f;
        if (gLMapEngine != null) {
            gLMapEngine.setServiceViewRect(i, i2, i3, i4, i5, i6, i7);
        }
    }

    private synchronized void a(int i, int i2, int i3, int i4, boolean z, boolean z2, com.autonavi.base.ae.gmap.style.StyleItem[] styleItemArr) {
        if (this.av && this.au && this.a) {
            e(i3);
            queueEvent(new com.amap.api.mapcore.util.b.AnonymousClass13(i, i2, i3, i4, z, z2, styleItemArr));
            return;
        }
        com.amap.api.mapcore.util.b.a aVar = this.aJ;
        aVar.g = i;
        aVar.d = i2;
        aVar.e = i3;
        aVar.f = i4;
        aVar.b = true;
    }

    private void a(int i, int i2, com.autonavi.base.amap.mapcore.FPoint fPoint) {
        com.autonavi.base.ae.gmap.GLMapEngine gLMapEngine;
        com.autonavi.base.ae.gmap.GLMapState mapState;
        if (!this.au || (gLMapEngine = this.f) == null || (mapState = gLMapEngine.getMapState(this.F)) == null) {
            return;
        }
        mapState.p20ToScreenPoint(i, i2, fPoint);
    }

    private void a(android.view.MotionEvent motionEvent) throws android.os.RemoteException {
        if (!this.M || this.P == null) {
            return;
        }
        int x = (int) motionEvent.getX();
        int y = (int) (motionEvent.getY() - 60.0f);
        if (this.P.getPosition() != null) {
            com.autonavi.amap.mapcore.DPoint obtain = com.autonavi.amap.mapcore.DPoint.obtain();
            getPixel2LatLng(x, y, obtain);
            com.amap.api.maps.model.LatLng latLng = new com.amap.api.maps.model.LatLng(obtain.y, obtain.x);
            obtain.recycle();
            this.P.setPosition(latLng);
            try {
                java.util.List a2 = this.u.a(com.amap.api.maps.AMap.OnMarkerDragListener.class.hashCode());
                if (a2 == null || a2.size() <= 0) {
                    return;
                }
                synchronized (a2) {
                    for (int i = 0; i < a2.size(); i++) {
                        ((com.amap.api.maps.AMap.OnMarkerDragListener) a2.get(i)).onMarkerDrag(this.P);
                    }
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    private void a(com.autonavi.amap.mapcore.AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
        boolean z = this.I;
        abstractCameraUpdateMessage.isUseAnchor = z;
        if (z) {
            abstractCameraUpdateMessage.anchorX = this.b.getAnchorX();
            abstractCameraUpdateMessage.anchorY = this.b.getAnchorY();
        }
        if (abstractCameraUpdateMessage.width == 0) {
            abstractCameraUpdateMessage.width = getMapWidth();
        }
        if (abstractCameraUpdateMessage.height == 0) {
            abstractCameraUpdateMessage.height = getMapHeight();
        }
        abstractCameraUpdateMessage.mapConfig = this.b;
    }

    private void a(com.autonavi.base.ae.gmap.GLMapState gLMapState, int i, int i2, com.autonavi.amap.mapcore.DPoint dPoint) {
        if (!this.au || this.f == null) {
            return;
        }
        gLMapState.screenToP20Point(i, i2, new android.graphics.Point());
        com.autonavi.amap.mapcore.DPoint pixelsToLatLong = com.autonavi.amap.mapcore.VirtualEarthProjection.pixelsToLatLong(r0.x, r0.y, 20);
        dPoint.x = pixelsToLatLong.x;
        dPoint.y = pixelsToLatLong.y;
        pixelsToLatLong.recycle();
    }

    private void a(boolean z) {
        com.autonavi.extra.b bVar = this.aV;
        if (bVar != null) {
            java.lang.Object j = bVar.j();
            if (j != null && (j instanceof java.lang.Boolean)) {
                com.autonavi.base.amap.mapcore.MapConfig mapConfig = this.b;
                if (mapConfig != null) {
                    mapConfig.setAbroadEnable(z && ((java.lang.Boolean) j).booleanValue());
                }
                if (z && ((java.lang.Boolean) j).booleanValue()) {
                    com.amap.api.maps.MapsInitializer.setSupportRecycleView(false);
                }
            }
            java.lang.Object j2 = this.aV.j();
            if (j2 != null && (j2 instanceof java.lang.Boolean)) {
                this.C.a(((java.lang.Boolean) j2).booleanValue());
            }
            java.lang.Object j3 = this.aV.j();
            if (j2 == null || !(j2 instanceof java.lang.Integer)) {
                return;
            }
            this.ad = ((java.lang.Integer) j3).intValue();
        }
    }

    private void a(boolean z, byte[] bArr, boolean z2) {
        com.amap.api.mapcore.util.co coVar;
        try {
            this.b.setCustomStyleEnable(z);
            boolean z3 = false;
            if (this.b.isHideLogoEnable()) {
                this.z.setLogoEnable(!z);
            }
            if (!z) {
                c(this.F, false);
                a(this.F, this.b.getMapStyleMode(), this.b.getMapStyleTime(), this.b.getMapStyleState(), true, false, (com.autonavi.base.ae.gmap.style.StyleItem[]) null);
                return;
            }
            c(this.F, true);
            com.amap.api.mapcore.util.cn cnVar = new com.amap.api.mapcore.util.cn();
            com.amap.api.maps.model.MyTrafficStyle myTrafficStyle = this.Y;
            if (myTrafficStyle != null && myTrafficStyle.getTrafficRoadBackgroundColor() != -1) {
                cnVar.a(this.Y.getTrafficRoadBackgroundColor());
            }
            if (this.b.isProFunctionAuthEnable() && !android.text.TextUtils.isEmpty(this.b.getCustomTextureResourcePath())) {
                z3 = true;
            }
            com.autonavi.base.ae.gmap.style.StyleItem[] styleItemArr = null;
            if (bArr != null) {
                coVar = cnVar.a(bArr, z3);
                if (coVar != null && (styleItemArr = coVar.c()) != null) {
                    this.b.setUseProFunction(true);
                }
            } else {
                coVar = null;
            }
            if (styleItemArr == null && (coVar = cnVar.a(this.b.getCustomStylePath(), z3)) != null) {
                styleItemArr = coVar.c();
            }
            if (cnVar.a() != 0) {
                this.b.setCustomBackgroundColor(cnVar.a());
            }
            if (coVar == null || coVar.d() == null) {
                a(styleItemArr, z2);
            } else if (this.aj != null) {
                this.aj.a((java.lang.String) coVar.d());
                this.aj.a(coVar);
                this.aj.b();
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
        }
    }

    private void a(com.autonavi.base.ae.gmap.style.StyleItem[] styleItemArr, boolean z) {
        if (!(z || (styleItemArr != null && styleItemArr.length > 0))) {
            com.amap.api.mapcore.util.di.a(this.e, false);
        } else {
            a(this.F, 0, 0, 0, true, true, styleItemArr);
            com.amap.api.mapcore.util.di.a(this.e, true);
        }
    }

    private boolean a(int i, int i2) {
        com.autonavi.amap.mapcore.AbstractCameraUpdateMessage a2;
        if (!this.au || ((int) c()) >= this.b.getMaxZoomLevel()) {
            return false;
        }
        try {
            if (this.I || this.z.isZoomInByScreenCenter()) {
                a2 = com.amap.api.mapcore.util.z.a(1.0f, (android.graphics.Point) null);
            } else {
                android.graphics.Point point = this.k;
                point.x = i;
                point.y = i2;
                a2 = com.amap.api.mapcore.util.z.a(1.0f, point);
            }
            animateCamera(a2);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "AMapDelegateImp", "onDoubleTap");
            th.printStackTrace();
        }
        resetRenderTime();
        return true;
    }

    private static boolean a(com.amap.api.maps.model.LatLngBounds latLngBounds) {
        return (latLngBounds == null || latLngBounds.northeast == null || latLngBounds.southwest == null) ? false : true;
    }

    private boolean a(boolean z, boolean z2) {
        if (z) {
            if (this.aZ) {
                com.amap.api.mapcore.util.cr.a("setCustomMapStyle 和 setWorldVectorMapStyle 不能同时使用，setCustomMapStyle将不会生效");
                return true;
            }
            this.aY = true;
        }
        if (!z2) {
            return false;
        }
        if (this.aY) {
            com.amap.api.mapcore.util.cr.a("setCustomMapStyle 和 setWorldVectorMapStyle 不能同时使用，setWorldVectorMapStyle将不会生效");
            return true;
        }
        this.aZ = true;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.amap.api.maps.model.Poi b(int i, int i2) {
        if (!this.au) {
            return null;
        }
        try {
            java.util.ArrayList<com.autonavi.base.ae.gmap.glinterface.MapLabelItem> a2 = a(this.F, i, i2);
            com.autonavi.base.ae.gmap.glinterface.MapLabelItem mapLabelItem = (a2 == null || a2.size() <= 0) ? null : a2.get(0);
            if (mapLabelItem != null) {
                com.autonavi.amap.mapcore.DPoint pixelsToLatLong = com.autonavi.amap.mapcore.VirtualEarthProjection.pixelsToLatLong(mapLabelItem.pixel20X, mapLabelItem.pixel20Y, 20);
                com.amap.api.maps.model.Poi poi = new com.amap.api.maps.model.Poi(mapLabelItem.name, new com.amap.api.maps.model.LatLng(pixelsToLatLong.y, pixelsToLatLong.x, false), mapLabelItem.poiid);
                pixelsToLatLong.recycle();
                return poi;
            }
        } catch (java.lang.Throwable unused) {
        }
        return null;
    }

    private void b(int i) {
        queueEvent(new com.amap.api.mapcore.util.b.AnonymousClass12(i));
    }

    private void b(android.view.MotionEvent motionEvent) {
        queueEvent(new com.amap.api.mapcore.util.b.AnonymousClass8(motionEvent));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.amap.api.maps.model.CameraPosition cameraPosition) {
        if (!this.b.getMapLanguage().equals("en")) {
            if (this.V) {
                return;
            }
            this.V = true;
            b(this.F, true);
            return;
        }
        boolean c2 = c(cameraPosition);
        if (c2 != this.V) {
            this.V = c2;
            b(this.F, c2);
        }
    }

    private float c() {
        if (this.b != null) {
            return getMapConfig().getSZ();
        }
        return 0.0f;
    }

    private void c(int i) {
        com.autonavi.base.ae.gmap.GLMapRender gLMapRender = this.al;
        if (gLMapRender != null) {
            gLMapRender.renderPause();
        }
        f(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(android.view.MotionEvent motionEvent) {
        this.j.post(new com.amap.api.mapcore.util.b.AnonymousClass9(motionEvent));
    }

    private boolean c(com.amap.api.maps.model.CameraPosition cameraPosition) {
        if (cameraPosition.zoom < 6.0f) {
            return false;
        }
        if (cameraPosition.isAbroad) {
            return true;
        }
        if (this.b == null) {
            return false;
        }
        try {
            return !com.amap.api.mapcore.util.de.a(r4.getGeoRectangle().getClipRect());
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            com.amap.api.mapcore.util.dl.a(th);
            return false;
        }
    }

    private void d() {
        if (this.au) {
            this.am.a();
            this.an = true;
            this.as = true;
            try {
                stopAnimation();
            } catch (android.os.RemoteException unused) {
            }
        }
    }

    private void d(int i) {
        f(i);
        com.autonavi.base.ae.gmap.GLMapRender gLMapRender = this.al;
        if (gLMapRender != null) {
            gLMapRender.renderResume();
        }
    }

    private boolean d(android.view.MotionEvent motionEvent) {
        try {
            java.util.List a2 = this.u.a(com.amap.api.maps.AMap.OnPolylineClickListener.class.hashCode());
            if (a2 != null && a2.size() > 0) {
                com.autonavi.amap.mapcore.DPoint obtain = com.autonavi.amap.mapcore.DPoint.obtain();
                getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
                com.amap.api.maps.model.LatLng latLng = new com.amap.api.maps.model.LatLng(obtain.y, obtain.x);
                obtain.recycle();
                com.amap.api.maps.model.Polyline hitOverlay = this.D.getHitOverlay(latLng, 2);
                if (hitOverlay != null) {
                    synchronized (a2) {
                        java.util.Iterator it = a2.iterator();
                        while (it.hasNext()) {
                            ((com.amap.api.maps.AMap.OnPolylineClickListener) it.next()).onPolylineClick(hitOverlay);
                        }
                    }
                    return false;
                }
            }
        } catch (java.lang.Throwable unused) {
        }
        return false;
    }

    private void e() {
        this.an = true;
        this.as = false;
        if (this.R) {
            this.R = false;
        }
        if (this.Q) {
            this.Q = false;
        }
        if (this.S) {
            this.S = false;
        }
        try {
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "AMapDelegateImp", "OnMarkerDragListener.onMarkerDragEnd");
            th.printStackTrace();
        }
        if (this.M) {
            java.util.List a2 = this.u.a(com.amap.api.maps.AMap.OnMarkerDragListener.class.hashCode());
            if (a2 != null && a2.size() > 0 && (this.N != null || this.P != null)) {
                synchronized (a2) {
                    for (int i = 0; i < a2.size(); i++) {
                        ((com.amap.api.maps.AMap.OnMarkerDragListener) a2.get(i)).onMarkerDragEnd(this.P);
                    }
                }
                this.N = null;
                this.P = null;
            }
            this.M = false;
        }
    }

    private void e(int i) {
        com.amap.api.mapcore.util.dw dwVar = this.C;
        if (dwVar != null) {
            if (i == 0) {
                if (dwVar.b()) {
                    this.C.g(java.lang.Boolean.FALSE);
                    this.C.c();
                    return;
                }
                return;
            }
            if (dwVar.b()) {
                return;
            }
            this.C.g(java.lang.Boolean.TRUE);
            this.C.c();
        }
    }

    private boolean e(android.view.MotionEvent motionEvent) throws android.os.RemoteException {
        com.amap.api.maps.model.LatLng position;
        com.autonavi.amap.mapcore.DPoint obtain = com.autonavi.amap.mapcore.DPoint.obtain();
        getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
        com.amap.api.maps.model.LatLng latLng = new com.amap.api.maps.model.LatLng(obtain.y, obtain.x);
        obtain.recycle();
        boolean z = true;
        com.amap.api.maps.model.BaseOverlay hitBaseOverlay = this.D.getHitBaseOverlay(latLng, 1);
        if ((hitBaseOverlay instanceof com.amap.api.maps.model.Marker) && ((com.amap.api.maps.model.Marker) hitBaseOverlay).getId().contains("MARKER")) {
            try {
                com.amap.api.maps.model.Marker marker = (com.amap.api.maps.model.Marker) hitBaseOverlay;
                this.D.set2Top(marker.getId());
                java.util.List a2 = this.u.a(com.amap.api.maps.AMap.OnMarkerClickListener.class.hashCode());
                if (a2 != null && a2.size() > 0) {
                    synchronized (a2) {
                        if (a2.size() == 1) {
                            boolean onMarkerClick = ((com.amap.api.maps.AMap.OnMarkerClickListener) a2.get(0)).onMarkerClick(marker);
                            if (onMarkerClick) {
                                return true;
                            }
                            z = onMarkerClick;
                        } else {
                            java.util.Iterator it = a2.iterator();
                            boolean z2 = false;
                            while (it.hasNext()) {
                                z2 |= ((com.amap.api.maps.AMap.OnMarkerClickListener) it.next()).onMarkerClick(marker);
                            }
                            if (z2) {
                                return true;
                            }
                            z = z2;
                        }
                    }
                }
                this.D.showInfoWindow(marker.getId());
                if (!marker.isViewMode() && (position = marker.getPosition()) != null) {
                    com.autonavi.amap.mapcore.IPoint obtain2 = com.autonavi.amap.mapcore.IPoint.obtain();
                    latlon2Geo(position.latitude, position.longitude, obtain2);
                    moveCamera(com.amap.api.mapcore.util.z.a(obtain2));
                }
                return z;
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.gd.c(th, "AMapDelegateImp", "onMarkerTap");
                th.printStackTrace();
            }
        }
        return false;
    }

    public static /* synthetic */ boolean e(com.amap.api.mapcore.util.b bVar) {
        bVar.at = false;
        return false;
    }

    private void f() {
        com.autonavi.base.ae.gmap.GLMapState gLMapState;
        com.autonavi.base.ae.gmap.GLMapEngine gLMapEngine = this.f;
        if (gLMapEngine == null || (gLMapState = (com.autonavi.base.ae.gmap.GLMapState) gLMapEngine.getNewMapState(this.F)) == null) {
            return;
        }
        com.autonavi.amap.mapcore.IPoint obtain = com.autonavi.amap.mapcore.IPoint.obtain();
        gLMapState.recalculate();
        gLMapState.getMapGeoCenter(obtain);
        this.b.setSX(((android.graphics.Point) obtain).x);
        this.b.setSY(((android.graphics.Point) obtain).y);
        this.b.setSZ(gLMapState.getMapZoomer());
        this.b.setSC(gLMapState.getCameraDegree());
        this.b.setSR(gLMapState.getMapAngle());
        gLMapState.recycle();
        obtain.recycle();
    }

    private void f(int i) {
        queueEvent(new com.amap.api.mapcore.util.b.AnonymousClass14(i));
    }

    private boolean f(android.view.MotionEvent motionEvent) {
        if (this.D != null && this.aE != null) {
            com.autonavi.amap.mapcore.DPoint obtain = com.autonavi.amap.mapcore.DPoint.obtain();
            if (this.f != null) {
                getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
                com.amap.api.maps.model.MultiPointItem multiPointItem = this.D.getMultiPointItem(new com.amap.api.maps.model.LatLng(obtain.y, obtain.x));
                if (multiPointItem == null) {
                    return false;
                }
                boolean onPointClick = this.aE.onPointClick(multiPointItem);
                obtain.recycle();
                return onPointClick;
            }
        }
        return false;
    }

    private com.amap.api.maps.model.LatLng g() {
        com.autonavi.base.amap.mapcore.MapConfig mapConfig = this.b;
        if (mapConfig == null) {
            return null;
        }
        com.autonavi.amap.mapcore.DPoint pixelsToLatLong = com.autonavi.amap.mapcore.VirtualEarthProjection.pixelsToLatLong(mapConfig.getSX(), this.b.getSY(), 20);
        com.amap.api.maps.model.LatLng latLng = new com.amap.api.maps.model.LatLng(pixelsToLatLong.y, pixelsToLatLong.x, false);
        pixelsToLatLong.recycle();
        return latLng;
    }

    private boolean g(int i) {
        com.autonavi.base.ae.gmap.GLMapEngine gLMapEngine = this.f;
        if (gLMapEngine != null) {
            return gLMapEngine.getSrvViewStateBoolValue(i, 7);
        }
        return false;
    }

    private boolean g(android.view.MotionEvent motionEvent) throws android.os.RemoteException {
        try {
            java.util.List a2 = this.u.a(com.amap.api.maps.AMap.OnInfoWindowClickListener.class.hashCode());
            com.amap.api.maps.model.BaseOverlay a3 = this.w.a(motionEvent);
            if (a3 != null && (a3 instanceof com.amap.api.maps.model.Marker)) {
                synchronized (a2) {
                    for (int i = 0; i < a2.size(); i++) {
                        ((com.amap.api.maps.AMap.OnInfoWindowClickListener) a2.get(i)).onInfoWindowClick((com.amap.api.maps.model.Marker) a3);
                    }
                }
                return true;
            }
        } catch (java.lang.Throwable unused) {
        }
        return false;
    }

    private synchronized void h() {
        synchronized (this.ah) {
            int size = this.ah.size();
            for (int i = 0; i < size; i++) {
                this.ah.get(i).a().recycle();
            }
            this.ah.clear();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005f A[Catch: all -> 0x007b, TryCatch #0 {all -> 0x007b, blocks: (B:5:0x0024, B:7:0x003b, B:9:0x003f, B:11:0x0045, B:12:0x0059, B:13:0x0077, B:20:0x004b, B:21:0x005f, B:23:0x006d, B:24:0x0072, B:38:0x0021), top: B:37:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x003b A[Catch: all -> 0x007b, TryCatch #0 {all -> 0x007b, blocks: (B:5:0x0024, B:7:0x003b, B:9:0x003f, B:11:0x0045, B:12:0x0059, B:13:0x0077, B:20:0x004b, B:21:0x005f, B:23:0x006d, B:24:0x0072, B:38:0x0021), top: B:37:0x0021 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void h(int i) {
        int i2;
        int i3;
        int i4;
        this.X = i;
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    i2 = 0;
                    i3 = 1;
                } else if (i == 4) {
                    i2 = 0;
                    i3 = 0;
                } else if (i == 5) {
                    i2 = 2;
                } else {
                    try {
                        this.X = 1;
                    } catch (java.lang.Throwable th) {
                        com.amap.api.mapcore.util.gd.c(th, "AMapDelegateImp", "setMaptype");
                        th.printStackTrace();
                        com.amap.api.mapcore.util.dl.a(th);
                        return;
                    }
                }
                i4 = 4;
                this.b.setMapStyleMode(i2);
                this.b.setMapStyleTime(i3);
                this.b.setMapStyleState(i4);
                if (this.b.isCustomStyleEnable()) {
                    com.amap.api.mapcore.util.a aVar = this.aF;
                    if (aVar == null || !aVar.d()) {
                        a(this.F, i2, i3, i4, true, false, (com.autonavi.base.ae.gmap.style.StyleItem[]) null);
                        this.b.setCustomStyleEnable(false);
                    } else {
                        this.aF.e();
                    }
                    this.z.setLogoEnable(true);
                } else {
                    if (this.b.getMapLanguage().equals("en")) {
                        setMapLanguage("zh_cn");
                    }
                    a(this.F, i2, i3, i4);
                }
                resetRenderTime();
            }
            i2 = 1;
            i3 = 0;
            i4 = 0;
            this.b.setMapStyleMode(i2);
            this.b.setMapStyleTime(i3);
            this.b.setMapStyleState(i4);
            if (this.b.isCustomStyleEnable()) {
            }
            resetRenderTime();
        }
        i2 = 0;
        i3 = 0;
        i4 = 0;
        this.b.setMapStyleMode(i2);
        this.b.setMapStyleTime(i3);
        this.b.setMapStyleState(i4);
        if (this.b.isCustomStyleEnable()) {
        }
        resetRenderTime();
    }

    public static /* synthetic */ boolean h(com.amap.api.mapcore.util.b bVar) {
        bVar.T = false;
        return false;
    }

    private void i() {
        if (this.U) {
            boolean canStopMapRender = this.f.canStopMapRender(this.F);
            android.os.Message obtainMessage = this.j.obtainMessage(15, this.f.getScreenShot(this.F, 0, 0, getMapWidth(), getMapHeight()));
            obtainMessage.arg1 = canStopMapRender ? 1 : 0;
            obtainMessage.sendToTarget();
            this.U = false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0114, code lost:
    
        r0 = r9.u.a(com.autonavi.base.ae.gmap.listener.AMapWidgetListener.class.hashCode());
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0120, code lost:
    
        if (r0 == null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0126, code lost:
    
        if (r0.size() <= 0) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0128, code lost:
    
        monitor-enter(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0129, code lost:
    
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x012e, code lost:
    
        if (r1 >= r0.size()) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0130, code lost:
    
        ((com.autonavi.base.ae.gmap.listener.AMapWidgetListener) r0.get(r1)).invalidateCompassView();
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x013c, code lost:
    
        monitor-exit(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void j() {
        java.util.List a2;
        java.util.List a3;
        com.autonavi.base.ae.gmap.GLMapState mapState = this.f.getMapState(this.F);
        if (mapState != null) {
            mapState.getViewMatrix(this.b.getViewMatrix());
            mapState.getProjectionMatrix(this.b.getProjectionMatrix());
            this.b.updateFinalMatrix();
            com.autonavi.amap.mapcore.DPoint mapGeoCenter = mapState.getMapGeoCenter();
            this.b.setSX(mapGeoCenter.x);
            this.b.setSY(mapGeoCenter.y);
            this.b.setSZ(mapState.getMapZoomer());
            this.b.setSC(mapState.getCameraDegree());
            this.b.setSR(mapState.getMapAngle());
            if (!this.b.isMapStateChange()) {
                if (!this.as && this.f.getAnimateionsCount() == 0 && this.f.getStateMessageCount() == 0) {
                    onChangeFinish();
                    return;
                }
                return;
            }
            this.b.setSkyHeight(mapState.getSkyHeight());
            com.autonavi.amap.mapcore.DPoint pixelsToLatLong = com.autonavi.amap.mapcore.VirtualEarthProjection.pixelsToLatLong(mapGeoCenter.x, mapGeoCenter.y, 20);
            com.amap.api.maps.model.CameraPosition cameraPosition = new com.amap.api.maps.model.CameraPosition(new com.amap.api.maps.model.LatLng(pixelsToLatLong.y, pixelsToLatLong.x, false), this.b.getSZ(), this.b.getSC(), this.b.getSR());
            pixelsToLatLong.recycle();
            android.os.Message obtainMessage = this.j.obtainMessage();
            obtainMessage.what = 10;
            obtainMessage.obj = cameraPosition;
            this.j.sendMessage(obtainMessage);
            boolean z = true;
            this.at = true;
            redrawInfoWindow();
            try {
                if (this.z.isZoomControlsEnabled() && this.b.isNeedUpdateZoomControllerState() && (a3 = this.u.a(com.autonavi.base.ae.gmap.listener.AMapWidgetListener.class.hashCode())) != null && a3.size() > 0) {
                    synchronized (a3) {
                        for (int i = 0; i < a3.size(); i++) {
                            ((com.autonavi.base.ae.gmap.listener.AMapWidgetListener) a3.get(i)).invalidateZoomController(this.b.getSZ());
                        }
                    }
                }
                if (this.b.getChangeGridRatio() != 1.0d) {
                    b();
                }
                if (!this.z.isCompassEnabled() || (!this.b.isTiltChanged() && !this.b.isBearingChanged())) {
                    z = false;
                }
                if (!this.z.isScaleControlsEnabled() || (a2 = this.u.a(com.autonavi.base.ae.gmap.listener.AMapWidgetListener.class.hashCode())) == null || a2.size() <= 0) {
                    return;
                }
                synchronized (a2) {
                    for (int i2 = 0; i2 < a2.size(); i2++) {
                        ((com.autonavi.base.ae.gmap.listener.AMapWidgetListener) a2.get(i2)).invalidateScaleView();
                    }
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void k() {
        if (!this.J) {
            this.j.sendEmptyMessage(16);
            this.J = true;
            b();
        }
        long j = this.bc;
        if (j < 2) {
            this.bc = j + 1;
            return;
        }
        com.amap.api.mapcore.util.dr d2 = this.C.d();
        if (d2 == null || d2.getVisibility() == 8) {
            return;
        }
        com.amap.api.mapcore.util.di.a(this.e, java.lang.System.currentTimeMillis() - this.aG);
        this.j.post(new com.amap.api.mapcore.util.b.AnonymousClass10(d2));
        this.f.setStyleChangeGradualEnable(this.F, true);
    }

    private void l() {
        com.autonavi.base.ae.gmap.GLMapRender gLMapRender = this.al;
        if (gLMapRender != null) {
            gLMapRender.resetTickCount(2);
        }
    }

    private void m() {
        com.autonavi.base.ae.gmap.GLMapRender gLMapRender;
        if (!this.au || (gLMapRender = this.al) == null || gLMapRender.isRenderPause()) {
            return;
        }
        requestRender();
    }

    private void n() {
        if (this.ab) {
            return;
        }
        try {
            this.Z.setName("AuthThread");
            this.Z.start();
            this.ab = true;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            com.amap.api.mapcore.util.dl.a(th);
        }
    }

    private void o() {
        if (this.ac) {
            return;
        }
        try {
            if (this.aa == null) {
                this.aa = new com.amap.api.mapcore.util.h(this.e, this);
            }
            this.aa.setName("AuthProThread");
            this.aa.start();
            this.ac = true;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            com.amap.api.mapcore.util.dl.a(th);
        }
    }

    private void p() {
        try {
            com.amap.api.maps.model.LatLngBounds limitLatLngBounds = this.b.getLimitLatLngBounds();
            if (this.f != null && a(limitLatLngBounds)) {
                com.autonavi.base.ae.gmap.GLMapState gLMapState = new com.autonavi.base.ae.gmap.GLMapState(this.F, this.f.getNativeInstance());
                com.autonavi.amap.mapcore.IPoint obtain = com.autonavi.amap.mapcore.IPoint.obtain();
                com.amap.api.maps.model.LatLng latLng = limitLatLngBounds.northeast;
                com.autonavi.base.ae.gmap.GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, obtain);
                com.autonavi.amap.mapcore.IPoint obtain2 = com.autonavi.amap.mapcore.IPoint.obtain();
                com.amap.api.maps.model.LatLng latLng2 = limitLatLngBounds.southwest;
                com.autonavi.base.ae.gmap.GLMapState.lonlat2Geo(latLng2.longitude, latLng2.latitude, obtain2);
                this.b.setLimitIPoints(new com.autonavi.amap.mapcore.IPoint[]{obtain, obtain2});
                gLMapState.recycle();
                return;
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        this.b.setLimitIPoints(null);
    }

    private void q() {
        com.amap.api.mapcore.util.g gVar = this.u;
        if (gVar != null) {
            gVar.a();
        }
    }

    private void r() {
        com.amap.api.mapcore.util.ce ceVar = this.aD;
        if (ceVar != null) {
            ceVar.a();
            this.aD = null;
        }
    }

    @Override // com.amap.api.mapcore.util.a.InterfaceC0118a
    public final void a() {
        com.autonavi.extra.b bVar = this.aV;
        if (bVar != null) {
            bVar.i();
        }
    }

    public final synchronized void a(int i, int i2, int i3, int i4) {
        a(i, i2, i3, i4, false, false, (com.autonavi.base.ae.gmap.style.StyleItem[]) null);
    }

    public final void a(int i, boolean z) {
        if (this.au && this.av) {
            resetRenderTime();
            queueEvent(new com.amap.api.mapcore.util.b.AnonymousClass15(i, z));
        } else {
            com.amap.api.mapcore.util.b.a aVar = this.aL;
            aVar.c = z;
            aVar.b = true;
            aVar.g = i;
        }
    }

    public final void a(com.amap.api.maps.model.CameraPosition cameraPosition) {
        com.autonavi.base.amap.mapcore.MapConfig mapConfig = this.b;
        if (mapConfig == null || mapConfig.getChangedCounter() == 0) {
            return;
        }
        try {
            if (!this.as && this.f.getAnimateionsCount() == 0 && this.f.getStateMessageCount() == 0) {
                com.amap.api.maps.model.AMapGestureListener aMapGestureListener = this.v;
                if (aMapGestureListener != null) {
                    aMapGestureListener.onMapStable();
                }
                if (this.B.isEnabled()) {
                    try {
                        java.util.List a2 = this.u.a(com.amap.api.maps.AMap.OnCameraChangeListener.class.hashCode());
                        if (a2 != null && a2.size() != 0) {
                            if (cameraPosition == null) {
                                try {
                                    cameraPosition = getCameraPosition();
                                } catch (java.lang.Throwable th) {
                                    com.amap.api.mapcore.util.gd.c(th, "AMapDelegateImp", "cameraChangeFinish");
                                    th.printStackTrace();
                                }
                            }
                            synchronized (a2) {
                                java.util.Iterator it = a2.iterator();
                                while (it.hasNext()) {
                                    ((com.amap.api.maps.AMap.OnCameraChangeListener) it.next()).onCameraChangeFinish(cameraPosition);
                                }
                            }
                        }
                    } catch (java.lang.Throwable unused) {
                    }
                    this.b.resetChangedCounter();
                }
            }
        } catch (java.lang.Throwable th2) {
            th2.printStackTrace();
            com.amap.api.mapcore.util.dl.a(th2);
        }
    }

    @Override // com.amap.api.mapcore.util.ci.a
    public final void a(java.lang.String str, com.amap.api.mapcore.util.co coVar) {
        setCustomTextureResourcePath(str);
        if (!this.b.isCustomStyleEnable() || coVar == null) {
            return;
        }
        a(coVar.c(), false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void accelerateNetworkInChinese(boolean z) {
        com.autonavi.extra.b bVar = this.aV;
        if (bVar != null) {
            bVar.i();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final com.amap.api.maps.model.Arc addArc(com.amap.api.maps.model.ArcOptions arcOptions) throws android.os.RemoteException {
        if (arcOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            com.amap.api.maps.model.ArcOptions m16clone = arcOptions.m16clone();
            java.lang.String createId = this.D.createId("ARC");
            com.amap.api.maps.model.Arc arc = new com.amap.api.maps.model.Arc(this.D, m16clone, createId);
            com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer = this.D;
            return iGlOverlayLayer != null ? (com.amap.api.maps.model.Arc) iGlOverlayLayer.addOverlayObject(createId, arc, m16clone) : arc;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final com.amap.api.maps.model.BuildingOverlay addBuildingOverlay() {
        try {
            com.amap.api.mapcore.util.di.h(this.e);
            java.lang.String createId = this.D.createId("BUILDINGOVERLAY");
            com.amap.api.maps.model.BuildingOverlay buildingOverlay = new com.amap.api.maps.model.BuildingOverlay(this.D, createId);
            java.lang.reflect.Field declaredField = com.amap.api.maps.model.BuildingOverlay.class.getDeclaredField("buildingOverlayTotalOptions");
            if (declaredField == null) {
                return null;
            }
            resetRenderTime();
            declaredField.setAccessible(true);
            java.lang.Object obj = declaredField.get(buildingOverlay);
            com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer = this.D;
            return (iGlOverlayLayer == null || !(obj instanceof com.amap.api.maps.model.BaseOptions)) ? buildingOverlay : (com.amap.api.maps.model.BuildingOverlay) iGlOverlayLayer.addOverlayObject(createId, buildingOverlay, (com.amap.api.maps.model.BaseOptions) obj);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.amap.api.mapcore.util.dl.a(e);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final com.amap.api.maps.model.Circle addCircle(com.amap.api.maps.model.CircleOptions circleOptions) throws android.os.RemoteException {
        if (circleOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            com.amap.api.maps.model.CircleOptions m18clone = circleOptions.m18clone();
            java.lang.String createId = this.D.createId("CIRCLE");
            com.amap.api.maps.model.Circle circle = new com.amap.api.maps.model.Circle(this.D, m18clone, createId);
            com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer = this.D;
            return iGlOverlayLayer != null ? (com.amap.api.maps.model.Circle) iGlOverlayLayer.addOverlayObject(createId, circle, m18clone) : circle;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final com.amap.api.maps.model.CrossOverlay addCrossVector(com.amap.api.maps.model.CrossOverlayOptions crossOverlayOptions) {
        if (crossOverlayOptions == null || crossOverlayOptions.getRes() == null) {
            return null;
        }
        com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay crossVectorOverlay = new com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay(this.F, getContext(), this);
        crossVectorOverlay.setAttribute(crossOverlayOptions.getAttribute());
        queueEvent(new com.amap.api.mapcore.util.b.AnonymousClass34(crossVectorOverlay));
        crossVectorOverlay.resumeMarker(crossOverlayOptions.getRes());
        return new com.amap.api.maps.model.CrossOverlay(crossOverlayOptions, crossVectorOverlay);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final com.amap.api.maps.model.GL3DModel addGLModel(com.amap.api.maps.model.GL3DModelOptions gL3DModelOptions) {
        resetRenderTime();
        java.lang.String createId = this.D.createId("GL3DMODEL");
        com.amap.api.maps.model.GL3DModel gL3DModel = new com.amap.api.maps.model.GL3DModel(this.D, gL3DModelOptions, createId);
        this.D.addOverlayObject(createId, gL3DModel, gL3DModelOptions);
        return gL3DModel;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void addGestureMapMessage(int i, com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage abstractGestureMapMessage) {
        if (!this.au || this.f == null) {
            return;
        }
        try {
            abstractGestureMapMessage.isUseAnchor = this.I;
            abstractGestureMapMessage.anchorX = this.b.getAnchorX();
            abstractGestureMapMessage.anchorY = this.b.getAnchorY();
            this.f.addGestureMessage(i, abstractGestureMapMessage, this.z.isGestureScaleByMapCenter(), this.b.getAnchorX(), this.b.getAnchorY());
        } catch (android.os.RemoteException unused) {
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final com.amap.api.maps.model.GroundOverlay addGroundOverlay(com.amap.api.maps.model.GroundOverlayOptions groundOverlayOptions) throws android.os.RemoteException {
        if (groundOverlayOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            com.amap.api.maps.model.GroundOverlayOptions m19clone = groundOverlayOptions.m19clone();
            java.lang.String createId = this.D.createId("GROUNDOVERLAY");
            com.amap.api.maps.model.GroundOverlay groundOverlay = new com.amap.api.maps.model.GroundOverlay(this.D, m19clone, createId);
            com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer = this.D;
            return iGlOverlayLayer != null ? (com.amap.api.maps.model.GroundOverlay) iGlOverlayLayer.addOverlayObject(createId, groundOverlay, m19clone) : groundOverlay;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final com.amap.api.maps.model.HeatMapLayer addHeatMapLayer(com.amap.api.maps.model.HeatMapLayerOptions heatMapLayerOptions) throws android.os.RemoteException {
        try {
            resetRenderTime();
            if (heatMapLayerOptions == null) {
                return null;
            }
            java.lang.String createId = this.D.createId("HEATMAPLAYER");
            return (com.amap.api.maps.model.HeatMapLayer) this.D.addOverlayObject(createId, new com.amap.api.maps.model.HeatMapLayer(this.D, heatMapLayerOptions, createId), heatMapLayerOptions);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final com.amap.api.maps.model.Marker addMarker(com.amap.api.maps.model.MarkerOptions markerOptions) throws android.os.RemoteException {
        try {
            resetRenderTime();
            com.amap.api.maps.model.MarkerOptions m21clone = markerOptions.m21clone();
            java.lang.String createId = this.D.createId("MARKER");
            com.amap.api.maps.model.Marker marker = new com.amap.api.maps.model.Marker(this.D, m21clone, createId);
            this.D.addOverlayObject(createId, marker, m21clone);
            return marker;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
            com.amap.api.mapcore.util.dn.a(com.amap.api.mapcore.util.dm.d, "addMarker failed " + th.getMessage(), markerOptions);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final java.util.ArrayList<com.amap.api.maps.model.Marker> addMarkers(java.util.ArrayList<com.amap.api.maps.model.MarkerOptions> arrayList, boolean z) throws android.os.RemoteException {
        try {
            resetRenderTime();
            java.util.ArrayList<com.amap.api.maps.model.Marker> arrayList2 = new java.util.ArrayList<>();
            com.amap.api.maps.model.LatLngBounds.Builder builder = com.amap.api.maps.model.LatLngBounds.builder();
            for (int i = 0; i < arrayList.size(); i++) {
                com.amap.api.maps.model.MarkerOptions markerOptions = arrayList.get(i);
                if (arrayList.get(i) != null) {
                    arrayList2.add(addMarker(markerOptions));
                    if (markerOptions.getPosition() != null) {
                        builder.include(markerOptions.getPosition());
                    }
                }
            }
            if (z && arrayList2.size() > 0) {
                getMainHandler().postDelayed(new com.amap.api.mapcore.util.b.AnonymousClass18(builder), 50L);
            }
            return arrayList2;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
            com.amap.api.mapcore.util.dn.a(com.amap.api.mapcore.util.dm.d, "addMarkers failed " + th.getMessage(), arrayList);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final com.amap.api.maps.model.MultiPointOverlay addMultiPointOverlay(com.amap.api.maps.model.MultiPointOverlayOptions multiPointOverlayOptions) throws android.os.RemoteException {
        if (multiPointOverlayOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            com.amap.api.maps.model.MultiPointOverlayOptions m22clone = multiPointOverlayOptions.m22clone();
            java.lang.String createId = this.D.createId("MULTIOVERLAY");
            com.amap.api.maps.model.MultiPointOverlay multiPointOverlay = new com.amap.api.maps.model.MultiPointOverlay(this.D, m22clone, createId);
            com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer = this.D;
            return iGlOverlayLayer != null ? (com.amap.api.maps.model.MultiPointOverlay) iGlOverlayLayer.addOverlayObject(createId, multiPointOverlay, m22clone) : multiPointOverlay;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final com.amap.api.maps.model.RouteOverlay addNaviRouteOverlay() {
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final com.amap.api.maps.model.NavigateArrow addNavigateArrow(com.amap.api.maps.model.NavigateArrowOptions navigateArrowOptions) throws android.os.RemoteException {
        if (navigateArrowOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            com.amap.api.maps.model.NavigateArrowOptions m23clone = navigateArrowOptions.m23clone();
            java.lang.String createId = this.D.createId("NAVIGATEARROW");
            com.amap.api.maps.model.NavigateArrow navigateArrow = new com.amap.api.maps.model.NavigateArrow(this.D, m23clone, createId);
            com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer = this.D;
            return iGlOverlayLayer != null ? (com.amap.api.maps.model.NavigateArrow) iGlOverlayLayer.addOverlayObject(createId, navigateArrow, m23clone) : navigateArrow;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnCameraChangeListener(com.amap.api.maps.AMap.OnCameraChangeListener onCameraChangeListener) throws android.os.RemoteException {
        com.amap.api.mapcore.util.g gVar = this.u;
        if (gVar != null) {
            gVar.a(java.lang.Integer.valueOf(com.amap.api.maps.AMap.OnCameraChangeListener.class.hashCode()), (java.lang.Integer) onCameraChangeListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnIndoorBuildingActiveListener(com.amap.api.maps.AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) throws android.os.RemoteException {
        com.amap.api.mapcore.util.g gVar = this.u;
        if (gVar != null) {
            gVar.a(java.lang.Integer.valueOf(com.amap.api.maps.AMap.OnIndoorBuildingActiveListener.class.hashCode()), (java.lang.Integer) onIndoorBuildingActiveListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnInfoWindowClickListener(com.amap.api.maps.AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws android.os.RemoteException {
        com.amap.api.mapcore.util.g gVar = this.u;
        if (gVar != null) {
            gVar.a(java.lang.Integer.valueOf(com.amap.api.maps.AMap.OnInfoWindowClickListener.class.hashCode()), (java.lang.Integer) onInfoWindowClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnMapClickListener(com.amap.api.maps.AMap.OnMapClickListener onMapClickListener) throws android.os.RemoteException {
        com.amap.api.mapcore.util.g gVar = this.u;
        if (gVar != null) {
            gVar.a(java.lang.Integer.valueOf(com.amap.api.maps.AMap.OnMapClickListener.class.hashCode()), (java.lang.Integer) onMapClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnMapLoadedListener(com.amap.api.maps.AMap.OnMapLoadedListener onMapLoadedListener) {
        com.amap.api.mapcore.util.g gVar = this.u;
        if (gVar != null) {
            gVar.a(java.lang.Integer.valueOf(com.amap.api.maps.AMap.OnMapLoadedListener.class.hashCode()), (java.lang.Integer) onMapLoadedListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnMapLongClickListener(com.amap.api.maps.AMap.OnMapLongClickListener onMapLongClickListener) throws android.os.RemoteException {
        com.amap.api.mapcore.util.g gVar = this.u;
        if (gVar != null) {
            gVar.a(java.lang.Integer.valueOf(com.amap.api.maps.AMap.OnMapLongClickListener.class.hashCode()), (java.lang.Integer) onMapLongClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnMapTouchListener(com.amap.api.maps.AMap.OnMapTouchListener onMapTouchListener) throws android.os.RemoteException {
        com.amap.api.mapcore.util.g gVar = this.u;
        if (gVar != null) {
            gVar.a(java.lang.Integer.valueOf(com.amap.api.maps.AMap.OnMapTouchListener.class.hashCode()), (java.lang.Integer) onMapTouchListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnMarkerClickListener(com.amap.api.maps.AMap.OnMarkerClickListener onMarkerClickListener) throws android.os.RemoteException {
        com.amap.api.mapcore.util.g gVar = this.u;
        if (gVar != null) {
            gVar.a(java.lang.Integer.valueOf(com.amap.api.maps.AMap.OnMarkerClickListener.class.hashCode()), (java.lang.Integer) onMarkerClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnMarkerDragListener(com.amap.api.maps.AMap.OnMarkerDragListener onMarkerDragListener) {
        com.amap.api.mapcore.util.g gVar = this.u;
        if (gVar != null) {
            gVar.a(java.lang.Integer.valueOf(com.amap.api.maps.AMap.OnMarkerDragListener.class.hashCode()), (java.lang.Integer) onMarkerDragListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnMyLocationChangeListener(com.amap.api.maps.AMap.OnMyLocationChangeListener onMyLocationChangeListener) throws android.os.RemoteException {
        com.amap.api.mapcore.util.g gVar = this.u;
        if (gVar != null) {
            gVar.a(java.lang.Integer.valueOf(com.amap.api.maps.AMap.OnMyLocationChangeListener.class.hashCode()), (java.lang.Integer) onMyLocationChangeListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnPOIClickListener(com.amap.api.maps.AMap.OnPOIClickListener onPOIClickListener) throws android.os.RemoteException {
        com.amap.api.mapcore.util.g gVar = this.u;
        if (gVar != null) {
            gVar.a(java.lang.Integer.valueOf(com.amap.api.maps.AMap.OnPOIClickListener.class.hashCode()), (java.lang.Integer) onPOIClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnPolylineClickListener(com.amap.api.maps.AMap.OnPolylineClickListener onPolylineClickListener) throws android.os.RemoteException {
        com.amap.api.mapcore.util.g gVar = this.u;
        if (gVar != null) {
            gVar.a(java.lang.Integer.valueOf(com.amap.api.maps.AMap.OnPolylineClickListener.class.hashCode()), (java.lang.Integer) onPolylineClickListener);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void addOverlayTexture(int i, com.autonavi.base.ae.gmap.gloverlay.GLTextureProperty gLTextureProperty) {
        com.autonavi.base.ae.gmap.gloverlay.GLOverlayBundle overlayBundle;
        try {
            com.autonavi.base.ae.gmap.GLMapEngine gLMapEngine = this.f;
            if (gLMapEngine != null && (overlayBundle = gLMapEngine.getOverlayBundle(i)) != null && gLTextureProperty != null && gLTextureProperty.mBitmap != null) {
                this.f.addOverlayTexture(i, gLTextureProperty);
                overlayBundle.addOverlayTextureItem(gLTextureProperty.mId, gLTextureProperty.mAnchor, gLTextureProperty.mXRatio, gLTextureProperty.mYRatio, gLTextureProperty.mBitmap.getWidth(), gLTextureProperty.mBitmap.getHeight());
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final com.amap.api.maps.model.particle.ParticleOverlay addParticleOverlay(com.amap.api.maps.model.particle.ParticleOverlayOptions particleOverlayOptions) {
        if (particleOverlayOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            com.amap.api.mapcore.util.di.c(this.e);
            java.lang.String createId = this.D.createId("PARTICLEOVERLAY");
            return (com.amap.api.maps.model.particle.ParticleOverlay) this.D.addOverlayObject(createId, new com.amap.api.maps.model.particle.ParticleOverlay(this.D, particleOverlayOptions, createId), particleOverlayOptions);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final com.amap.api.maps.model.Polygon addPolygon(com.amap.api.maps.model.PolygonOptions polygonOptions) throws android.os.RemoteException {
        if (polygonOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            com.amap.api.maps.model.PolygonOptions m24clone = polygonOptions.m24clone();
            java.lang.String createId = this.D.createId("POLYGON");
            com.amap.api.maps.model.Polygon polygon = new com.amap.api.maps.model.Polygon(this.D, m24clone, createId);
            com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer = this.D;
            return iGlOverlayLayer != null ? (com.amap.api.maps.model.Polygon) iGlOverlayLayer.addOverlayObject(createId, polygon, m24clone) : polygon;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
            com.amap.api.mapcore.util.dn.a(com.amap.api.mapcore.util.dm.d, "addPolygon failed " + th.getMessage(), polygonOptions);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final com.amap.api.maps.model.Polyline addPolyline(com.amap.api.maps.model.PolylineOptions polylineOptions) throws android.os.RemoteException {
        if (polylineOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            java.lang.String createId = this.D.createId("POLYLINE");
            return (com.amap.api.maps.model.Polyline) this.D.addOverlayObject(createId, new com.amap.api.maps.model.Polyline(this.D, polylineOptions, createId), polylineOptions);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
            com.amap.api.mapcore.util.dn.a(com.amap.api.mapcore.util.dm.d, "addPolyline failed " + th.getMessage(), polylineOptions);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final com.amap.api.maps.model.Text addText(com.amap.api.maps.model.TextOptions textOptions) throws android.os.RemoteException {
        try {
            resetRenderTime();
            java.lang.String createId = this.D.createId("TEXT");
            com.amap.api.maps.model.TextOptions m25clone = textOptions.m25clone();
            com.amap.api.maps.model.MarkerOptions a2 = com.amap.api.mapcore.util.cc.a(m25clone);
            com.amap.api.maps.model.Marker marker = new com.amap.api.maps.model.Marker(this.D, a2, createId);
            marker.setObject(m25clone.getObject());
            this.D.addOverlayObject(createId, marker, a2);
            return new com.amap.api.maps.model.Text(marker, m25clone);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final com.amap.api.maps.model.TileOverlay addTileOverlay(com.amap.api.maps.model.TileOverlayOptions tileOverlayOptions) throws android.os.RemoteException {
        try {
            com.amap.api.maps.model.TileProvider tileProvider = tileOverlayOptions.getTileProvider();
            if (tileProvider != null && (tileProvider instanceof com.amap.api.maps.model.HeatmapTileProvider)) {
                com.amap.api.mapcore.util.di.a(this.e);
            }
            java.lang.String createId = this.D.createId("TILEOVERLAY");
            com.amap.api.maps.model.TileOverlay tileOverlay = new com.amap.api.maps.model.TileOverlay(this.D, tileOverlayOptions, createId);
            this.D.addOverlayObject(createId, tileOverlay, tileOverlayOptions);
            return tileOverlay;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
            return null;
        }
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public final void afterAnimation() {
        redrawInfoWindow();
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public final void afterDrawFrame(int i, com.autonavi.base.ae.gmap.GLMapState gLMapState) {
        float mapZoomer = gLMapState.getMapZoomer();
        com.autonavi.base.ae.gmap.GLMapEngine gLMapEngine = this.f;
        if (!(gLMapEngine != null && (gLMapEngine.isInMapAction(i) || this.f.isInMapAnimation(i)))) {
            int i2 = this.ag;
            if (i2 != -1) {
                this.al.setRenderFps(i2);
            } else {
                this.al.setRenderFps(15.0f);
            }
            if (this.ao != mapZoomer) {
                this.ao = mapZoomer;
            }
        }
        if (this.ax) {
            return;
        }
        this.ax = true;
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public final void afterDrawLabel(int i, com.autonavi.base.ae.gmap.GLMapState gLMapState) {
        j();
        com.autonavi.extra.b bVar = this.aV;
        if (bVar != null) {
            bVar.e();
        }
        com.autonavi.base.ae.gmap.GLMapEngine gLMapEngine = this.f;
        if (gLMapEngine != null) {
            gLMapEngine.pushRendererState();
        }
        this.ba = this.D.draw(1, this.ad, this.i) ? this.ba : this.ba + 1;
        com.autonavi.base.ae.gmap.GLMapEngine gLMapEngine2 = this.f;
        if (gLMapEngine2 != null) {
            gLMapEngine2.popRendererState();
        }
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public final void afterRendererOver(int i, com.autonavi.base.ae.gmap.GLMapState gLMapState) {
        com.autonavi.base.ae.gmap.GLMapEngine gLMapEngine = this.f;
        if (gLMapEngine != null) {
            gLMapEngine.pushRendererState();
        }
        this.D.draw(2, this.ad, this.i);
        com.autonavi.base.ae.gmap.GLMapEngine gLMapEngine2 = this.f;
        if (gLMapEngine2 != null) {
            gLMapEngine2.popRendererState();
        }
        com.amap.api.maps.CustomRenderer customRenderer = this.ae;
        if (customRenderer != null) {
            customRenderer.onDrawFrame(null);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void animateCamera(com.amap.api.maps.CameraUpdate cameraUpdate) throws android.os.RemoteException {
        if (cameraUpdate == null) {
            return;
        }
        animateCamera(cameraUpdate.getCameraUpdateFactoryDelegate());
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void animateCamera(com.autonavi.amap.mapcore.AbstractCameraUpdateMessage abstractCameraUpdateMessage) throws android.os.RemoteException {
        animateCameraWithDurationAndCallback(abstractCameraUpdateMessage, 250L, (com.amap.api.maps.AMap.CancelableCallback) null);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void animateCameraWithCallback(com.amap.api.maps.CameraUpdate cameraUpdate, com.amap.api.maps.AMap.CancelableCallback cancelableCallback) throws android.os.RemoteException {
        if (cameraUpdate == null) {
            return;
        }
        animateCameraWithDurationAndCallback(cameraUpdate, 250L, cancelableCallback);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void animateCameraWithDurationAndCallback(com.amap.api.maps.CameraUpdate cameraUpdate, long j, com.amap.api.maps.AMap.CancelableCallback cancelableCallback) {
        if (cameraUpdate == null) {
            return;
        }
        animateCameraWithDurationAndCallback(cameraUpdate.getCameraUpdateFactoryDelegate(), j, cancelableCallback);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void animateCameraWithDurationAndCallback(com.autonavi.amap.mapcore.AbstractCameraUpdateMessage abstractCameraUpdateMessage, long j, com.amap.api.maps.AMap.CancelableCallback cancelableCallback) {
        if (abstractCameraUpdateMessage == null || this.G || this.f == null) {
            return;
        }
        abstractCameraUpdateMessage.mCallback = cancelableCallback;
        abstractCameraUpdateMessage.mDuration = j;
        if (!this.H && getMapHeight() != 0 && getMapWidth() != 0) {
            try {
                this.f.interruptAnimation();
                resetRenderTime();
                a(abstractCameraUpdateMessage);
                this.f.addMessage(abstractCameraUpdateMessage, true);
                return;
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.dl.a(th);
                th.printStackTrace();
                return;
            }
        }
        try {
            moveCamera(abstractCameraUpdateMessage);
            com.amap.api.maps.AMap.CancelableCallback cancelableCallback2 = abstractCameraUpdateMessage.mCallback;
            if (cancelableCallback2 != null) {
                cancelableCallback2.onFinish();
            }
        } catch (java.lang.Throwable th2) {
            th2.printStackTrace();
            com.amap.api.mapcore.util.dl.a(th2);
        }
    }

    public final void b() {
        this.j.obtainMessage(17, 1, 0).sendToTarget();
    }

    public final void b(int i, boolean z) {
        if (this.au && this.av) {
            resetRenderTime();
            queueEvent(new com.amap.api.mapcore.util.b.AnonymousClass16(z, i));
        } else {
            com.amap.api.mapcore.util.b.a aVar = this.aR;
            aVar.c = z;
            aVar.b = true;
            aVar.g = i;
        }
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public final void beforeDrawLabel(int i, com.autonavi.base.ae.gmap.GLMapState gLMapState) {
        j();
        com.autonavi.base.ae.gmap.GLMapEngine gLMapEngine = this.f;
        if (gLMapEngine != null) {
            gLMapEngine.pushRendererState();
        }
        this.ba = this.D.draw(0, this.ad, this.i) ? this.ba : this.ba + 1;
        com.autonavi.base.ae.gmap.GLMapEngine gLMapEngine2 = this.f;
        if (gLMapEngine2 != null) {
            gLMapEngine2.popRendererState();
        }
    }

    public final void c(int i, boolean z) {
        if (this.au && this.av) {
            resetRenderTime();
            queueEvent(new com.amap.api.mapcore.util.b.AnonymousClass17(z, i));
        } else {
            com.amap.api.mapcore.util.b.a aVar = this.aU;
            aVar.c = z;
            aVar.b = true;
            aVar.g = i;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final android.util.Pair<java.lang.Float, com.amap.api.maps.model.LatLng> calculateZoomToSpanLevel(int i, int i2, int i3, int i4, com.amap.api.maps.model.LatLng latLng, com.amap.api.maps.model.LatLng latLng2) {
        if (latLng != null && latLng2 != null && i == i2 && i2 == i3 && i3 == i4 && latLng.latitude == latLng2.latitude && latLng.longitude == latLng2.longitude) {
            return new android.util.Pair<>(java.lang.Float.valueOf(getMaxZoomLevel()), latLng);
        }
        com.autonavi.base.amap.mapcore.MapConfig mapConfig = getMapConfig();
        if (latLng == null || latLng2 == null || !this.au || this.G) {
            com.autonavi.amap.mapcore.DPoint obtain = com.autonavi.amap.mapcore.DPoint.obtain();
            com.autonavi.base.ae.gmap.GLMapState.geo2LonLat((int) mapConfig.getSX(), (int) mapConfig.getSY(), obtain);
            android.util.Pair<java.lang.Float, com.amap.api.maps.model.LatLng> pair = new android.util.Pair<>(java.lang.Float.valueOf(mapConfig.getSZ()), new com.amap.api.maps.model.LatLng(obtain.y, obtain.x));
            obtain.recycle();
            return pair;
        }
        com.amap.api.maps.model.LatLngBounds.Builder builder = new com.amap.api.maps.model.LatLngBounds.Builder();
        builder.include(latLng);
        builder.include(latLng2);
        com.autonavi.base.ae.gmap.GLMapState gLMapState = new com.autonavi.base.ae.gmap.GLMapState(this.F, this.f.getNativeInstance());
        android.util.Pair<java.lang.Float, com.autonavi.amap.mapcore.IPoint> a2 = com.amap.api.mapcore.util.dl.a(mapConfig, i, i2, i3, i4, builder.build(), getMapWidth(), getMapHeight());
        gLMapState.recycle();
        if (a2 == null) {
            return null;
        }
        com.autonavi.amap.mapcore.DPoint obtain2 = com.autonavi.amap.mapcore.DPoint.obtain();
        java.lang.Object obj = a2.second;
        com.autonavi.base.ae.gmap.GLMapState.geo2LonLat(((android.graphics.Point) ((com.autonavi.amap.mapcore.IPoint) obj)).x, ((android.graphics.Point) ((com.autonavi.amap.mapcore.IPoint) obj)).y, obtain2);
        android.util.Pair<java.lang.Float, com.amap.api.maps.model.LatLng> pair2 = new android.util.Pair<>(a2.first, new com.amap.api.maps.model.LatLng(obtain2.y, obtain2.x));
        obtain2.recycle();
        return pair2;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean canShowIndoorSwitch() {
        com.amap.api.mapcore.util.ai aiVar;
        if (getZoomLevel() < 17.0f || (aiVar = this.c) == null || aiVar.g == null) {
            return false;
        }
        com.autonavi.base.amap.mapcore.FPoint obtain = com.autonavi.base.amap.mapcore.FPoint.obtain();
        android.graphics.Point point = this.c.g;
        a(point.x, point.y, obtain);
        return this.W.contains((int) ((android.graphics.PointF) obtain).x, (int) ((android.graphics.PointF) obtain).y);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean canStopMapRender() {
        com.autonavi.base.ae.gmap.GLMapEngine gLMapEngine = this.f;
        if (gLMapEngine == null) {
            return true;
        }
        gLMapEngine.canStopMapRender(this.F);
        return true;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void changeGLOverlayIndex() {
        this.D.changeOverlayIndex();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void changeLogoIconStyle(java.lang.String str, boolean z, int i) {
        com.amap.api.mapcore.util.dw dwVar = this.C;
        if (dwVar != null) {
            dwVar.a(str, java.lang.Boolean.valueOf(z), java.lang.Integer.valueOf(i));
        }
        com.amap.api.mapcore.util.u uVar = this.z;
        if (uVar != null) {
            uVar.requestRefreshLogo();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void changeMapLogo(int i, boolean z) {
        if (this.G) {
            return;
        }
        try {
            java.util.List a2 = this.u.a(com.autonavi.base.ae.gmap.listener.AMapWidgetListener.class.hashCode());
            if (a2 == null || a2.size() <= 0) {
                return;
            }
            this.C.g(java.lang.Boolean.valueOf(!z));
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void changeSize(int i, int i2) {
        com.autonavi.base.amap.mapcore.MapConfig mapConfig = this.b;
        if (mapConfig != null) {
            this.g = i;
            this.h = i2;
            mapConfig.setMapWidth(i);
            this.b.setMapHeight(i2);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void changeSurface(int i, javax.microedition.khronos.opengles.GL10 gl10, int i2, int i3) {
        android.view.WindowManager windowManager;
        com.amap.api.mapcore.util.dn.a(com.amap.api.mapcore.util.dm.c, "changeSurface " + i2 + " " + i3);
        this.ax = false;
        if (!this.au) {
            createSurface(i, gl10, null);
        }
        com.amap.api.mapcore.util.n nVar = this.am;
        if (nVar != null && this.e != null && ((this.g != nVar.b() || this.h != this.am.c()) && (windowManager = (android.view.WindowManager) this.e.getSystemService("window")) != null)) {
            android.view.Display defaultDisplay = windowManager.getDefaultDisplay();
            android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
            if (defaultDisplay != null) {
                defaultDisplay.getRealMetrics(displayMetrics);
                this.am.a(displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
        }
        this.g = i2;
        this.h = i3;
        this.W = new android.graphics.Rect(0, 0, i2, i3);
        this.F = a(i, new android.graphics.Rect(0, 0, this.g, this.h), this.g, this.h);
        com.amap.api.mapcore.util.dn.a(com.amap.api.mapcore.util.dm.c, "create engine with frame complete");
        if (!this.av) {
            com.autonavi.base.amap.mapcore.MapConfig mapConfig = this.b;
            if (mapConfig != null) {
                mapConfig.setMapZoomScale(this.ap);
                this.b.setMapWidth(i2);
                this.b.setMapHeight(i3);
            }
            this.f.setIndoorEnable(this.F, false);
            this.f.setSimple3DEnable(this.F, false);
            this.f.setStyleChangeGradualEnable(this.F, false);
            this.f.initMapOpenLayer("{\"bounds\" : [{\"x2\" : 235405312,\"x1\" : 188874751,\"y2\" : 85065727,\"y1\" : 122421247}],\"sublyr\" : [{\"type\" : 4,\"sid\" : 9000006,\"zlevel\" : 2}],\"id\" : 9006,\"minzoom\" : 6,\"update_period\" : 90,\"maxzoom\" : 20,\"cachemode\" : 2,\"url\" : \"http://mpsapi.amap.com/ws/mps/lyrdata/ugc/\"}");
            com.autonavi.base.ae.gmap.GLMapEngine.InitParam initParam = new com.autonavi.base.ae.gmap.GLMapEngine.InitParam();
            com.autonavi.base.amap.mapcore.AeUtil.initIntersectionRes(this.e, initParam);
            this.f.setVectorOverlayPath(initParam.mIntersectionResPath);
        }
        synchronized (this) {
            this.av = true;
        }
        if (this.I) {
            this.b.setAnchorX(java.lang.Math.max(1, java.lang.Math.min(this.aA, i2 - 1)));
            this.b.setAnchorY(java.lang.Math.max(1, java.lang.Math.min(this.aB, i3 - 1)));
        } else {
            this.b.setAnchorX(i2 >> 1);
            this.b.setAnchorY(i3 >> 1);
        }
        this.f.setProjectionCenter(this.F, this.b.getAnchorX(), this.b.getAnchorY());
        this.a = true;
        com.amap.api.mapcore.util.b.a aVar = this.aR;
        if (aVar.b) {
            aVar.run();
        }
        com.amap.api.mapcore.util.b.a aVar2 = this.aJ;
        if (aVar2.b) {
            aVar2.run();
        }
        com.amap.api.mapcore.util.b.a aVar3 = this.aK;
        if (aVar3.b) {
            aVar3.run();
        }
        com.amap.api.mapcore.util.b.a aVar4 = this.aH;
        if (aVar4.b) {
            aVar4.run();
        }
        com.amap.api.mapcore.util.b.a aVar5 = this.aL;
        if (aVar5.b) {
            aVar5.run();
        }
        com.amap.api.mapcore.util.b.a aVar6 = this.aU;
        if (aVar6.b) {
            aVar6.run();
        }
        com.amap.api.mapcore.util.b.a aVar7 = this.aM;
        if (aVar7.b) {
            aVar7.run();
        }
        com.amap.api.mapcore.util.b.a aVar8 = this.aN;
        if (aVar8.b) {
            aVar8.run();
        }
        com.amap.api.mapcore.util.b.a aVar9 = this.aO;
        if (aVar9.b) {
            aVar9.run();
        }
        com.amap.api.mapcore.util.b.a aVar10 = this.aS;
        if (aVar10.b) {
            aVar10.run();
        }
        com.amap.api.mapcore.util.b.a aVar11 = this.aI;
        if (aVar11.b) {
            aVar11.run();
        }
        com.amap.api.mapcore.util.b.a aVar12 = this.aP;
        if (aVar12.b) {
            aVar12.run();
        }
        com.amap.api.mapcore.util.b.a aVar13 = this.aQ;
        if (aVar13 != null) {
            aVar13.run();
        }
        com.amap.api.maps.CustomRenderer customRenderer = this.ae;
        if (customRenderer != null) {
            customRenderer.onSurfaceChanged(gl10, i2, i3);
        }
        com.autonavi.extra.b bVar = this.aV;
        if (bVar != null) {
            bVar.d();
        }
        android.os.Handler handler = this.j;
        if (handler != null) {
            handler.post(this.aT);
        }
        redrawInfoWindow();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void changeSurface(javax.microedition.khronos.opengles.GL10 gl10, int i, int i2) {
        try {
            changeSurface(1, gl10, i, i2);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            com.amap.api.mapcore.util.dl.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void checkMapState(com.autonavi.amap.api.mapcore.IGLMapState iGLMapState) {
        com.autonavi.base.amap.mapcore.MapConfig mapConfig = this.b;
        if (mapConfig == null || this.G) {
            return;
        }
        com.amap.api.maps.model.LatLngBounds limitLatLngBounds = mapConfig.getLimitLatLngBounds();
        try {
            if (limitLatLngBounds == null) {
                if (this.b.isSetLimitZoomLevel()) {
                    iGLMapState.setMapZoomer(java.lang.Math.max(this.b.getMinZoomLevel(), java.lang.Math.min(iGLMapState.getMapZoomer(), this.b.getMaxZoomLevel())));
                    return;
                }
                return;
            }
            com.autonavi.amap.mapcore.IPoint[] limitIPoints = this.b.getLimitIPoints();
            if (limitIPoints == null) {
                com.autonavi.amap.mapcore.IPoint obtain = com.autonavi.amap.mapcore.IPoint.obtain();
                com.amap.api.maps.model.LatLng latLng = limitLatLngBounds.northeast;
                com.autonavi.base.ae.gmap.GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, obtain);
                com.autonavi.amap.mapcore.IPoint obtain2 = com.autonavi.amap.mapcore.IPoint.obtain();
                com.amap.api.maps.model.LatLng latLng2 = limitLatLngBounds.southwest;
                com.autonavi.base.ae.gmap.GLMapState.lonlat2Geo(latLng2.longitude, latLng2.latitude, obtain2);
                com.autonavi.amap.mapcore.IPoint[] iPointArr = {obtain, obtain2};
                this.b.setLimitIPoints(iPointArr);
                limitIPoints = iPointArr;
            }
            com.autonavi.base.amap.mapcore.MapConfig mapConfig2 = this.b;
            com.autonavi.amap.mapcore.IPoint iPoint = limitIPoints[0];
            int i = ((android.graphics.Point) iPoint).x;
            int i2 = ((android.graphics.Point) iPoint).y;
            com.autonavi.amap.mapcore.IPoint iPoint2 = limitIPoints[1];
            float a2 = com.amap.api.mapcore.util.dl.a(mapConfig2, i, i2, ((android.graphics.Point) iPoint2).x, ((android.graphics.Point) iPoint2).y, getMapWidth(), getMapHeight());
            float mapZoomer = iGLMapState.getMapZoomer();
            if (this.b.isSetLimitZoomLevel()) {
                float maxZoomLevel = this.b.getMaxZoomLevel();
                float minZoomLevel = this.b.getMinZoomLevel();
                float max = java.lang.Math.max(a2, java.lang.Math.min(mapZoomer, maxZoomLevel));
                if (a2 <= maxZoomLevel) {
                    maxZoomLevel = max;
                }
                a2 = maxZoomLevel < minZoomLevel ? minZoomLevel : maxZoomLevel;
            } else if (a2 <= 0.0f || mapZoomer >= a2) {
                a2 = mapZoomer;
            }
            iGLMapState.setMapZoomer(a2);
            com.autonavi.amap.mapcore.IPoint obtain3 = com.autonavi.amap.mapcore.IPoint.obtain();
            iGLMapState.getMapGeoCenter(obtain3);
            int i3 = ((android.graphics.Point) obtain3).x;
            int i4 = ((android.graphics.Point) obtain3).y;
            com.autonavi.amap.mapcore.IPoint iPoint3 = limitIPoints[0];
            int i5 = ((android.graphics.Point) iPoint3).x;
            int i6 = ((android.graphics.Point) iPoint3).y;
            com.autonavi.amap.mapcore.IPoint iPoint4 = limitIPoints[1];
            int[] a3 = com.amap.api.mapcore.util.dl.a(i5, i6, ((android.graphics.Point) iPoint4).x, ((android.graphics.Point) iPoint4).y, this.b, iGLMapState, i3, i4);
            iGLMapState.setMapGeoCenter(a3[0], a3[1]);
            obtain3.recycle();
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float checkZoomLevel(float f) throws android.os.RemoteException {
        return com.amap.api.mapcore.util.dl.a(this.b, f);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void clear() throws android.os.RemoteException {
        try {
            clear(false);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "AMapDelegateImp", "clear");
            com.amap.api.mapcore.util.dl.a(th);
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void clear(boolean z) throws android.os.RemoteException {
        java.lang.String str;
        try {
            hideInfoWindow();
            java.lang.String str2 = "";
            com.amap.api.mapcore.util.bz bzVar = this.K;
            if (bzVar != null) {
                if (z) {
                    str = bzVar.d();
                    str2 = this.K.e();
                    this.D.clear(str, str2);
                    queueEvent(new com.amap.api.mapcore.util.b.AnonymousClass19());
                    resetRenderTime();
                }
                bzVar.f();
            }
            str = null;
            this.D.clear(str, str2);
            queueEvent(new com.amap.api.mapcore.util.b.AnonymousClass19());
            resetRenderTime();
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "AMapDelegateImp", "clear");
            com.amap.api.mapcore.util.dl.a(th);
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void clearTileCache() {
        this.D.clearTileCache();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final long createGLOverlay(int i) {
        com.autonavi.base.ae.gmap.GLMapEngine gLMapEngine = this.f;
        if (gLMapEngine != null) {
            return gLMapEngine.createOverlay(this.F, i);
        }
        return 0L;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final java.lang.String createId(java.lang.String str) {
        com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer = this.D;
        if (iGlOverlayLayer != null) {
            return iGlOverlayLayer.createId(str);
        }
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final synchronized void createSurface(int i, javax.microedition.khronos.opengles.GL10 gl10, javax.microedition.khronos.egl.EGLConfig eGLConfig) {
        com.amap.api.mapcore.util.dn.a(com.amap.api.mapcore.util.dm.c, "createSurface");
        this.aG = java.lang.System.currentTimeMillis();
        if (this.X == 3) {
            this.C.d().a(com.amap.api.mapcore.util.dr.b);
        } else {
            this.C.d().a(com.amap.api.mapcore.util.dr.a);
        }
        this.av = false;
        this.g = this.B.getWidth();
        this.h = this.B.getHeight();
        this.ax = false;
        try {
            com.autonavi.base.amap.mapcore.AeUtil.loadLib(this.e);
            com.amap.api.mapcore.util.dn.a(com.amap.api.mapcore.util.dm.c, "load lib complete");
            com.autonavi.base.amap.mapcore.AeUtil.initCrashHandle(this.e);
            com.autonavi.base.ae.gmap.GLMapEngine.InitParam initResource = com.autonavi.base.amap.mapcore.AeUtil.initResource(this.e);
            com.amap.api.mapcore.util.dn.a(com.amap.api.mapcore.util.dm.c, "load res complete");
            this.f.createAMapInstance(initResource);
            com.amap.api.mapcore.util.dn.a(com.amap.api.mapcore.util.dm.c, "create engine complete");
            this.aD = new com.amap.api.mapcore.util.ce();
            com.amap.api.mapcore.util.dn.a(com.amap.api.mapcore.util.dm.c, "init shader complete");
            com.autonavi.extra.b bVar = this.aV;
            if (bVar != null) {
                bVar.i();
            }
            this.au = true;
            this.l = gl10.glGetString(com.badlogic.gdx.graphics.GL20.GL_RENDERER);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
            com.amap.api.mapcore.util.gd.c(th, "AMapDElegateImp", "createSurface");
            com.amap.api.mapcore.util.dn.b(com.amap.api.mapcore.util.dm.c, "createSurface failed " + th.getMessage());
            com.amap.api.mapcore.util.di.b(this.e, "init failed:" + th.getMessage());
        }
        com.autonavi.base.ae.gmap.GLMapState mapState = this.f.getMapState(this.F);
        if (mapState != null && mapState.getNativeInstance() != 0) {
            mapState.setMapGeoCenter((int) this.b.getSX(), (int) this.b.getSY());
            mapState.setMapAngle(this.b.getSR());
            mapState.setMapZoomer(this.b.getSZ());
            mapState.setCameraDegree(this.b.getSC());
        }
        n();
        com.amap.api.maps.CustomRenderer customRenderer = this.ae;
        if (customRenderer != null) {
            customRenderer.onSurfaceCreated(gl10, eGLConfig);
        }
        com.autonavi.extra.b bVar2 = this.aV;
        if (bVar2 != null) {
            bVar2.c();
        }
        this.D.onCreateAMapInstance();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void createSurface(javax.microedition.khronos.opengles.GL10 gl10, javax.microedition.khronos.egl.EGLConfig eGLConfig) {
        try {
            this.ak = java.lang.Thread.currentThread().getId();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            com.amap.api.mapcore.util.dl.a(th);
        }
        try {
            createSurface(1, gl10, eGLConfig);
        } catch (java.lang.Throwable th2) {
            th2.printStackTrace();
            com.amap.api.mapcore.util.dl.a(th2);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void destroy() {
        this.G = true;
        com.amap.api.mapcore.util.dn.a(com.amap.api.mapcore.util.dm.c, "destroy map");
        try {
            com.amap.api.maps.LocationSource locationSource = this.L;
            if (locationSource != null) {
                locationSource.deactivate();
            }
            this.L = null;
            this.aC = null;
            com.autonavi.base.ae.gmap.GLMapRender gLMapRender = this.al;
            if (gLMapRender != null) {
                gLMapRender.renderPause();
            }
            com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer = this.D;
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.destroy();
            }
            h();
            java.lang.Thread thread = this.Z;
            if (thread != null) {
                thread.interrupt();
                this.Z = null;
            }
            java.lang.Thread thread2 = this.aa;
            if (thread2 != null) {
                thread2.interrupt();
                this.aa = null;
            }
            com.amap.api.mapcore.util.cg cgVar = this.ai;
            if (cgVar != null) {
                cgVar.a();
                this.ai = null;
            }
            com.amap.api.mapcore.util.ci ciVar = this.aj;
            if (ciVar != null) {
                ciVar.a((com.amap.api.mapcore.util.ci.a) null);
                this.aj.a();
                this.aj = null;
            }
            com.amap.api.mapcore.util.cz.b();
            com.autonavi.base.ae.gmap.GLMapEngine gLMapEngine = this.f;
            if (gLMapEngine != null) {
                gLMapEngine.setMapListener(null);
                this.f.releaseNetworkState();
                queueEvent(new com.amap.api.mapcore.util.b.AnonymousClass33());
                int i = 0;
                while (this.f != null) {
                    int i2 = i + 1;
                    if (i >= 50) {
                        break;
                    }
                    try {
                        java.lang.Thread.sleep(20L);
                    } catch (java.lang.InterruptedException e) {
                        com.amap.api.mapcore.util.dl.a(e);
                    }
                    i = i2;
                }
            }
            com.autonavi.base.amap.api.mapcore.IGLSurfaceView iGLSurfaceView = this.B;
            if (iGLSurfaceView != null) {
                try {
                    iGLSurfaceView.onDetachedGLThread();
                } catch (java.lang.Exception e2) {
                    e2.printStackTrace();
                    com.amap.api.mapcore.util.dl.a(e2);
                }
            }
            com.amap.api.mapcore.util.dw dwVar = this.C;
            if (dwVar != null) {
                dwVar.g();
                this.C = null;
            }
            com.amap.api.mapcore.util.bz bzVar = this.K;
            if (bzVar != null) {
                bzVar.c();
                this.K = null;
            }
            this.L = null;
            this.t = null;
            q();
            this.Y = null;
            com.amap.api.mapcore.util.dn.a();
            com.amap.api.mapcore.util.gd.b();
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "AMapDelegateImp", "destroy");
            com.amap.api.mapcore.util.dl.a(th);
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void destroySurface(int i) {
        this.ay.lock();
        try {
            if (this.au) {
                android.opengl.EGL14.eglGetCurrentContext();
                android.opengl.EGLContext eGLContext = android.opengl.EGL14.EGL_NO_CONTEXT;
                r();
                com.autonavi.base.ae.gmap.GLMapEngine gLMapEngine = this.f;
                if (gLMapEngine != null) {
                    if (gLMapEngine.getOverlayBundle(this.F) != null) {
                        this.f.getOverlayBundle(this.F).removeAll(true);
                    }
                    this.f.destroyAMapEngine();
                    this.f = null;
                    int i2 = this.ba;
                    if (i2 > 0) {
                        com.amap.api.mapcore.util.di.a(this.e, i2);
                    }
                }
                com.autonavi.extra.b bVar = this.aV;
                if (bVar != null) {
                    bVar.f();
                }
            }
            this.au = false;
            this.av = false;
            this.ax = false;
        } catch (java.lang.Throwable th) {
            try {
                com.amap.api.mapcore.util.dl.a(th);
            } finally {
                this.ay.unlock();
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void drawFrame(javax.microedition.khronos.opengles.GL10 gl10) {
        if (this.G || this.f == null || android.opengl.EGL14.eglGetCurrentContext() == android.opengl.EGL14.EGL_NO_CONTEXT) {
            return;
        }
        com.autonavi.base.amap.mapcore.MapConfig mapConfig = this.b;
        if (mapConfig != null && !mapConfig.isMapEnable()) {
            android.opengl.GLES20.glClear(com.uc.crashsdk.export.LogType.UNEXP_RESTART);
            return;
        }
        a(this.F);
        this.f.renderAMap();
        this.f.pushRendererState();
        com.amap.api.mapcore.util.a aVar = this.aF;
        if (aVar != null) {
            aVar.a();
        }
        i();
        k();
        if (!this.aw) {
            this.aw = true;
        }
        this.f.popRendererState();
        if (com.amap.api.mapcore.util.dc.a()) {
            try {
                if (this.B instanceof com.amap.api.mapcore.util.e) {
                    if (this.d == null) {
                        this.d = new com.amap.api.mapcore.util.dc();
                    }
                    this.d.e();
                    if (!this.d.f() || this.d.d()) {
                        return;
                    }
                    if (this.d.a(((com.amap.api.mapcore.util.e) this.B).getBitmap())) {
                        if (com.amap.api.mapcore.util.dc.b()) {
                            removecache();
                        }
                        if (com.amap.api.mapcore.util.dc.c()) {
                            com.amap.api.mapcore.util.dc.g();
                        }
                        com.amap.api.mapcore.util.dn.b(com.amap.api.mapcore.util.dm.g, "pure screen: found pure check");
                    }
                }
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.gd.c(th, "AMapDelegateImp", "PureScreenCheckTool.checkBlackScreen");
            }
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void geo2Latlng(int i, int i2, com.autonavi.amap.mapcore.DPoint dPoint) {
        com.autonavi.amap.mapcore.DPoint pixelsToLatLong = com.autonavi.amap.mapcore.VirtualEarthProjection.pixelsToLatLong(i, i2, 20);
        dPoint.x = pixelsToLatLong.x;
        dPoint.y = pixelsToLatLong.y;
        pixelsToLatLong.recycle();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void geo2Map(int i, int i2, com.autonavi.base.amap.mapcore.FPoint fPoint) {
        ((android.graphics.PointF) fPoint).x = (int) (i - this.b.getSX());
        ((android.graphics.PointF) fPoint).y = (int) (i2 - this.b.getSY());
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final com.autonavi.extra.b getAMapExtraInterfaceManager() {
        return this.aV;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final com.amap.api.maps.Projection getAMapProjection() throws android.os.RemoteException {
        return new com.amap.api.maps.Projection(this.y);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final com.amap.api.maps.UiSettings getAMapUiSettings() throws android.os.RemoteException {
        if (this.x == null) {
            this.x = new com.amap.api.maps.UiSettings(this.z);
        }
        return this.x;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final com.amap.api.maps.model.AMapCameraInfo getCamerInfo() {
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float getCameraAngle() {
        return getCameraDegree(this.F);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float getCameraDegree(int i) {
        com.autonavi.base.amap.mapcore.MapConfig mapConfig = this.b;
        if (mapConfig != null) {
            return mapConfig.getSC();
        }
        return 0.0f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final com.amap.api.maps.model.CameraPosition getCameraPosition() throws android.os.RemoteException {
        return getCameraPositionPrj(this.I);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final com.amap.api.maps.model.CameraPosition getCameraPositionPrj(boolean z) {
        com.amap.api.maps.model.LatLng g;
        try {
            if (this.b == null) {
                return null;
            }
            if (!this.au || this.H || this.f == null) {
                com.autonavi.amap.mapcore.DPoint obtain = com.autonavi.amap.mapcore.DPoint.obtain();
                geo2Latlng((int) this.b.getSX(), (int) this.b.getSY(), obtain);
                com.amap.api.maps.model.LatLng latLng = new com.amap.api.maps.model.LatLng(obtain.y, obtain.x);
                obtain.recycle();
                return com.amap.api.maps.model.CameraPosition.builder().target(latLng).bearing(this.b.getSR()).tilt(this.b.getSC()).zoom(this.b.getSZ()).build();
            }
            if (z) {
                com.autonavi.amap.mapcore.DPoint obtain2 = com.autonavi.amap.mapcore.DPoint.obtain();
                getPixel2LatLng(this.b.getAnchorX(), this.b.getAnchorY(), obtain2);
                g = new com.amap.api.maps.model.LatLng(obtain2.y, obtain2.x, false);
                obtain2.recycle();
            } else {
                g = g();
            }
            return com.amap.api.maps.model.CameraPosition.builder().target(g).bearing(this.b.getSR()).tilt(this.b.getSC()).zoom(this.b.getSZ()).build();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final android.content.Context getContext() {
        return this.e;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final java.lang.String getCurrentWorldVectorMapStyle() {
        try {
            com.autonavi.extra.b bVar = this.aV;
            if (bVar == null) {
                return "";
            }
            java.lang.Object j = bVar.j();
            return j instanceof java.lang.String ? (java.lang.String) j : "";
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
            return "";
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final com.amap.api.mapcore.util.a getCustomStyleManager() {
        return this.aF;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final int getEngineIDWithGestureInfo(com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo eAMapPlatformGestureInfo) {
        com.autonavi.base.ae.gmap.GLMapEngine gLMapEngine = this.f;
        return gLMapEngine != null ? gLMapEngine.getEngineIDWithGestureInfo(eAMapPlatformGestureInfo) : this.F;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float[] getFinalMatrix() {
        com.autonavi.base.amap.mapcore.MapConfig mapConfig = this.b;
        return mapConfig != null ? mapConfig.getMvpMatrix() : this.m;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final com.autonavi.base.ae.gmap.GLMapEngine getGLMapEngine() {
        return this.f;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final android.view.View getGLMapView() {
        java.lang.Object obj = this.B;
        if (obj instanceof android.view.View) {
            return (android.view.View) obj;
        }
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void getGeoCenter(int i, com.autonavi.amap.mapcore.IPoint iPoint) {
        com.autonavi.base.amap.mapcore.MapConfig mapConfig = this.b;
        if (mapConfig != null) {
            ((android.graphics.Point) iPoint).x = (int) mapConfig.getSX();
            ((android.graphics.Point) iPoint).y = (int) this.b.getSY();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final com.amap.api.maps.interfaces.IGlOverlayLayer getGlOverlayLayer() {
        return this.D;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final long getGlOverlayMgrPtr() {
        com.autonavi.base.ae.gmap.GLMapEngine gLMapEngine = this.f;
        if (gLMapEngine != null) {
            return gLMapEngine.getGlOverlayMgrPtr(this.F);
        }
        return 0L;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final com.amap.api.maps.InfoWindowAnimationManager getInfoWindowAnimationManager() {
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final com.amap.api.mapcore.util.aj getInfoWindowDelegate() {
        return this.w;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void getLatLng2Map(double d2, double d3, com.autonavi.base.amap.mapcore.FPoint fPoint) {
        com.autonavi.amap.mapcore.IPoint obtain = com.autonavi.amap.mapcore.IPoint.obtain();
        latlon2Geo(d2, d3, obtain);
        geo2Map(((android.graphics.Point) obtain).x, ((android.graphics.Point) obtain).y, fPoint);
        obtain.recycle();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void getLatLng2Pixel(double d2, double d3, com.autonavi.amap.mapcore.IPoint iPoint) {
        if (!this.au || this.f == null) {
            return;
        }
        try {
            android.graphics.Point latLongToPixels = com.autonavi.amap.mapcore.VirtualEarthProjection.latLongToPixels(d2, d3, 20);
            com.autonavi.base.amap.mapcore.FPoint obtain = com.autonavi.base.amap.mapcore.FPoint.obtain();
            a(latLongToPixels.x, latLongToPixels.y, obtain);
            if (((android.graphics.PointF) obtain).x == -10000.0f && ((android.graphics.PointF) obtain).y == -10000.0f) {
                com.autonavi.base.ae.gmap.GLMapState gLMapState = (com.autonavi.base.ae.gmap.GLMapState) this.f.getNewMapState(this.F);
                gLMapState.setCameraDegree(0.0f);
                gLMapState.recalculate();
                gLMapState.p20ToScreenPoint(latLongToPixels.x, latLongToPixels.y, obtain);
                gLMapState.recycle();
            }
            ((android.graphics.Point) iPoint).x = (int) ((android.graphics.PointF) obtain).x;
            ((android.graphics.Point) iPoint).y = (int) ((android.graphics.PointF) obtain).y;
            obtain.recycle();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void getLatLngRect(com.autonavi.amap.mapcore.DPoint[] dPointArr) {
        try {
            com.autonavi.base.amap.mapcore.Rectangle geoRectangle = this.b.getGeoRectangle();
            if (geoRectangle != null) {
                com.autonavi.amap.mapcore.IPoint[] clipRect = geoRectangle.getClipRect();
                for (int i = 0; i < 4; i++) {
                    com.autonavi.amap.mapcore.IPoint iPoint = clipRect[i];
                    com.autonavi.base.ae.gmap.GLMapState.geo2LonLat(((android.graphics.Point) iPoint).x, ((android.graphics.Point) iPoint).y, dPointArr[i]);
                }
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float getLogoMarginRate(int i) {
        com.amap.api.mapcore.util.dw dwVar = this.C;
        if (dwVar != null) {
            return dwVar.a(i);
        }
        return 0.0f;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final int getLogoPosition() {
        try {
            return this.z.getLogoPosition();
        } catch (android.os.RemoteException e) {
            com.amap.api.mapcore.util.gd.c(e, "AMapDelegateImp", "getLogoPosition");
            e.printStackTrace();
            return 0;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final android.os.Handler getMainHandler() {
        return this.j;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float getMapAngle(int i) {
        com.autonavi.base.amap.mapcore.MapConfig mapConfig = this.b;
        if (mapConfig != null) {
            return mapConfig.getSR();
        }
        return 0.0f;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final com.amap.api.maps.model.LatLngBounds getMapBounds(com.amap.api.maps.model.LatLng latLng, float f, float f2, float f3) {
        int mapWidth = getMapWidth();
        int mapHeight = getMapHeight();
        if (mapWidth <= 0 || mapHeight <= 0 || this.G) {
            return null;
        }
        float a2 = com.amap.api.mapcore.util.dl.a(this.b, f);
        com.autonavi.base.ae.gmap.GLMapState gLMapState = new com.autonavi.base.ae.gmap.GLMapState(this.F, this.f.getNativeInstance());
        if (latLng != null) {
            com.autonavi.amap.mapcore.IPoint obtain = com.autonavi.amap.mapcore.IPoint.obtain();
            latlon2Geo(latLng.latitude, latLng.longitude, obtain);
            gLMapState.setCameraDegree(f3);
            gLMapState.setMapAngle(f2);
            gLMapState.setMapGeoCenter(((android.graphics.Point) obtain).x, ((android.graphics.Point) obtain).y);
            gLMapState.setMapZoomer(a2);
            gLMapState.recalculate();
            obtain.recycle();
        }
        com.autonavi.amap.mapcore.DPoint obtain2 = com.autonavi.amap.mapcore.DPoint.obtain();
        a(gLMapState, 0, 0, obtain2);
        com.amap.api.maps.model.LatLng latLng2 = new com.amap.api.maps.model.LatLng(obtain2.y, obtain2.x, false);
        a(gLMapState, mapWidth, mapHeight, obtain2);
        com.amap.api.maps.model.LatLng latLng3 = new com.amap.api.maps.model.LatLng(obtain2.y, obtain2.x, false);
        obtain2.recycle();
        gLMapState.recycle();
        return com.amap.api.maps.model.LatLngBounds.builder().include(latLng3).include(latLng2).build();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final com.autonavi.base.amap.mapcore.MapConfig getMapConfig() {
        return this.b;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final java.lang.String getMapContentApprovalNumber() {
        com.autonavi.base.amap.mapcore.MapConfig mapConfig = this.b;
        if (mapConfig == null || mapConfig.isCustomStyleEnable()) {
            return null;
        }
        com.amap.api.mapcore.util.di.d(this.e);
        java.lang.String a2 = com.amap.api.mapcore.util.db.a(this.e, "approval_number", com.umeng.analytics.pro.bo.A, "");
        return !android.text.TextUtils.isEmpty(a2) ? a2 : "GS(2021)5875号 | GS(2020)2189号";
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getMapHeight() {
        return this.h;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void getMapPrintScreen(com.amap.api.maps.AMap.onMapPrintScreenListener onmapprintscreenlistener) {
        try {
            this.u.a(java.lang.Integer.valueOf(com.amap.api.maps.AMap.onMapPrintScreenListener.class.hashCode()), (java.lang.Integer) onmapprintscreenlistener);
            this.U = true;
            resetRenderTime();
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final com.autonavi.base.ae.gmap.GLMapState getMapProjection() {
        com.autonavi.base.ae.gmap.GLMapEngine gLMapEngine = this.f;
        if (gLMapEngine != null) {
            return gLMapEngine.getMapState(this.F);
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final java.util.List<com.amap.api.maps.model.Marker> getMapScreenMarkers() throws android.os.RemoteException {
        return !com.amap.api.mapcore.util.dl.a(getMapWidth(), getMapHeight()) ? new java.util.ArrayList() : this.D.getMapScreenMarkers();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void getMapScreenShot(com.amap.api.maps.AMap.OnMapScreenShotListener onMapScreenShotListener) {
        try {
            this.u.a(java.lang.Integer.valueOf(com.amap.api.maps.AMap.OnMapScreenShotListener.class.hashCode()), (java.lang.Integer) onMapScreenShotListener);
            this.U = true;
            resetRenderTime();
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getMapTextZIndex() throws android.os.RemoteException {
        return this.ad;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getMapType() throws android.os.RemoteException {
        return this.X;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getMapWidth() {
        return this.g;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float getMapZoomScale() {
        return this.ap;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final int getMaskLayerType() {
        return this.af;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float getMaxZoomLevel() {
        try {
            com.autonavi.base.amap.mapcore.MapConfig mapConfig = this.b;
            if (mapConfig != null) {
                return mapConfig.getMaxZoomLevel();
            }
            return 20.0f;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
            return 20.0f;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float getMinZoomLevel() {
        try {
            com.autonavi.base.amap.mapcore.MapConfig mapConfig = this.b;
            if (mapConfig != null) {
                return mapConfig.getMinZoomLevel();
            }
            return 3.0f;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
            return 3.0f;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final android.location.Location getMyLocation() throws android.os.RemoteException {
        if (this.L != null) {
            return this.t.a;
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final com.amap.api.maps.model.MyLocationStyle getMyLocationStyle() throws android.os.RemoteException {
        com.amap.api.mapcore.util.bz bzVar = this.K;
        if (bzVar != null) {
            return bzVar.a();
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getNativeEngineID() {
        return this.F;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final long getNativeMapController() {
        com.autonavi.base.ae.gmap.GLMapEngine gLMapEngine = this.f;
        if (gLMapEngine != null) {
            return gLMapEngine.getNativeMapController(this.F);
        }
        return 0L;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final com.amap.api.maps.AMap.OnCameraChangeListener getOnCameraChangeListener() throws android.os.RemoteException {
        try {
            java.util.List a2 = this.u.a(com.amap.api.maps.AMap.OnCameraChangeListener.class.hashCode());
            if (a2 == null && a2.size() != 0) {
                return (com.amap.api.maps.AMap.OnCameraChangeListener) a2.get(0);
            }
        } catch (java.lang.Throwable unused) {
        }
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void getPixel2Geo(int i, int i2, com.autonavi.amap.mapcore.IPoint iPoint) {
        com.autonavi.base.ae.gmap.GLMapEngine gLMapEngine;
        com.autonavi.base.ae.gmap.GLMapState mapState;
        if (!this.au || (gLMapEngine = this.f) == null || (mapState = gLMapEngine.getMapState(this.F)) == null) {
            return;
        }
        mapState.screenToP20Point(i, i2, iPoint);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void getPixel2LatLng(int i, int i2, com.autonavi.amap.mapcore.DPoint dPoint) {
        com.autonavi.base.ae.gmap.GLMapEngine gLMapEngine;
        com.autonavi.base.ae.gmap.GLMapState mapState;
        if (!this.au || (gLMapEngine = this.f) == null || (mapState = gLMapEngine.getMapState(this.F)) == null) {
            return;
        }
        com.autonavi.amap.mapcore.IPoint obtain = com.autonavi.amap.mapcore.IPoint.obtain();
        mapState.screenToP20Point(i, i2, obtain);
        com.autonavi.amap.mapcore.DPoint pixelsToLatLong = com.autonavi.amap.mapcore.VirtualEarthProjection.pixelsToLatLong(((android.graphics.Point) obtain).x, ((android.graphics.Point) obtain).y, 20);
        dPoint.x = pixelsToLatLong.x;
        dPoint.y = pixelsToLatLong.y;
        obtain.recycle();
        pixelsToLatLong.recycle();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float getPreciseLevel(int i) {
        com.autonavi.base.amap.mapcore.MapConfig mapConfig = this.b;
        if (mapConfig != null) {
            return mapConfig.getSZ();
        }
        return 0.0f;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final com.autonavi.base.amap.api.mapcore.IProjectionDelegate getProjection() throws android.os.RemoteException {
        return this.y;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float[] getProjectionMatrix() {
        com.autonavi.base.amap.mapcore.MapConfig mapConfig = this.b;
        return mapConfig != null ? mapConfig.getProjectionMatrix() : this.o;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final android.graphics.Rect getRect() {
        return this.W;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getRenderMode() {
        return this.B.getRenderMode();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getSX() {
        com.autonavi.base.amap.mapcore.MapConfig mapConfig = this.b;
        if (mapConfig != null) {
            return (int) mapConfig.getSX();
        }
        return -1;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getSY() {
        com.autonavi.base.amap.mapcore.MapConfig mapConfig = this.b;
        if (mapConfig != null) {
            return (int) mapConfig.getSY();
        }
        return -1;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final java.lang.String getSatelliteImageApprovalNumber() {
        com.amap.api.mapcore.util.di.e(this.e);
        java.lang.String a2 = com.amap.api.mapcore.util.db.a(this.e, "approval_number", "si", "");
        return !android.text.TextUtils.isEmpty(a2) ? a2 : "GS(2021)1328号";
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float getScalePerPixel() throws android.os.RemoteException {
        try {
            return ((float) ((((java.lang.Math.cos((getCameraPosition().target.latitude * 3.141592653589793d) / 180.0d) * 2.0d) * 3.141592653589793d) * 6378137.0d) / (java.lang.Math.pow(2.0d, getZoomLevel()) * 256.0d))) * getMapZoomScale();
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "AMapDelegateImp", "getScalePerPixel");
            com.amap.api.mapcore.util.dl.a(th);
            th.printStackTrace();
            return 0.0f;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float getSkyHeight() {
        return this.b.getSkyHeight();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final java.lang.String getTerrainApprovalNumber() {
        com.amap.api.mapcore.util.di.f(this.e);
        java.lang.String a2 = com.amap.api.mapcore.util.db.a(this.e, "approval_number", "te", "");
        return !android.text.TextUtils.isEmpty(a2) ? a2 : "GS(2021)6352号";
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final com.autonavi.base.amap.api.mapcore.IUiSettingsDelegate getUiSettings() {
        return this.z;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float getUnitLengthByZoom(int i) {
        com.autonavi.base.ae.gmap.GLMapState gLMapState = new com.autonavi.base.ae.gmap.GLMapState(this.F, this.f.getNativeInstance());
        gLMapState.setMapZoomer(i);
        gLMapState.recalculate();
        float gLUnitWithWin = gLMapState.getGLUnitWithWin(1);
        gLMapState.recycle();
        return gLUnitWithWin;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final android.view.View getView() throws android.os.RemoteException {
        com.amap.api.mapcore.util.dw dwVar = this.C;
        if (dwVar != null) {
            return dwVar.j();
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float[] getViewMatrix() {
        com.autonavi.base.amap.mapcore.MapConfig mapConfig = this.b;
        return mapConfig != null ? mapConfig.getViewMatrix() : this.n;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final android.graphics.Point getWaterMarkerPositon() {
        com.amap.api.mapcore.util.dw dwVar = this.C;
        return dwVar != null ? dwVar.a() : new android.graphics.Point();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final java.lang.String getWorldVectorMapLanguage() {
        return this.aW;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final java.lang.String getWorldVectorMapStyle() {
        return this.aX;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float getZoomLevel() {
        return c();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float getZoomToSpanLevel(com.amap.api.maps.model.LatLng latLng, com.amap.api.maps.model.LatLng latLng2) {
        try {
            com.autonavi.base.amap.mapcore.MapConfig mapConfig = getMapConfig();
            if (latLng == null || latLng2 == null || !this.au || this.G) {
                return mapConfig.getSZ();
            }
            com.amap.api.maps.model.LatLngBounds.Builder builder = new com.amap.api.maps.model.LatLngBounds.Builder();
            builder.include(latLng);
            builder.include(latLng2);
            com.autonavi.base.ae.gmap.GLMapState gLMapState = new com.autonavi.base.ae.gmap.GLMapState(this.F, this.f.getNativeInstance());
            android.util.Pair<java.lang.Float, com.autonavi.amap.mapcore.IPoint> a2 = com.amap.api.mapcore.util.dl.a(mapConfig, 0, 0, 0, 0, builder.build(), getMapWidth(), getMapHeight());
            gLMapState.recycle();
            return a2 != null ? ((java.lang.Float) a2.first).floatValue() : gLMapState.getMapZoomer();
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
            return 0.0f;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void hideInfoWindow() {
        com.amap.api.mapcore.util.aj ajVar = this.w;
        if (ajVar != null) {
            ajVar.c();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean isIndoorEnabled() throws android.os.RemoteException {
        return this.b.isIndoorEnable();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean isLockMapAngle(int i) {
        return g(i);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean isLockMapCameraDegree(int i) {
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean isMaploaded() {
        return this.J;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean isMyLocationEnabled() throws android.os.RemoteException {
        return this.E;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean isTouchPoiEnable() {
        com.autonavi.base.amap.mapcore.MapConfig mapConfig = this.b;
        if (mapConfig != null) {
            return mapConfig.isTouchPoiEnable();
        }
        return true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean isTrafficEnabled() throws android.os.RemoteException {
        return this.b.isTrafficEnabled();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean isUseAnchor() {
        return this.I;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void latlon2Geo(double d2, double d3, com.autonavi.amap.mapcore.IPoint iPoint) {
        android.graphics.Point latLongToPixels = com.autonavi.amap.mapcore.VirtualEarthProjection.latLongToPixels(d2, d3, 20);
        ((android.graphics.Point) iPoint).x = latLongToPixels.x;
        ((android.graphics.Point) iPoint).y = latLongToPixels.y;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void loadWorldVectorMap(boolean z) {
        com.autonavi.base.amap.mapcore.MapConfig mapConfig = this.b;
        if (mapConfig != null) {
            mapConfig.setAbroadEnable(z);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void map2Geo(float f, float f2, com.autonavi.amap.mapcore.IPoint iPoint) {
        ((android.graphics.Point) iPoint).x = (int) (f + this.b.getSX());
        ((android.graphics.Point) iPoint).y = (int) (f2 + this.b.getSY());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void moveCamera(com.amap.api.maps.CameraUpdate cameraUpdate) throws android.os.RemoteException {
        if (cameraUpdate == null) {
            return;
        }
        try {
            moveCamera(cameraUpdate.getCameraUpdateFactoryDelegate());
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void moveCamera(com.autonavi.amap.mapcore.AbstractCameraUpdateMessage abstractCameraUpdateMessage) throws android.os.RemoteException {
        com.autonavi.base.ae.gmap.GLMapEngine gLMapEngine = this.f;
        if (gLMapEngine == null || this.G) {
            return;
        }
        try {
            if (this.H && gLMapEngine.getStateMessageCount() > 0) {
                com.autonavi.amap.mapcore.AbstractCameraUpdateMessage c2 = com.amap.api.mapcore.util.z.c();
                c2.nowType = com.autonavi.amap.mapcore.AbstractCameraUpdateMessage.Type.changeGeoCenterZoomTiltBearing;
                c2.geoPoint = new com.autonavi.amap.mapcore.DPoint(this.b.getSX(), this.b.getSY());
                c2.zoom = this.b.getSZ();
                c2.bearing = this.b.getSR();
                c2.tilt = this.b.getSC();
                this.f.addMessage(abstractCameraUpdateMessage, false);
                while (this.f.getStateMessageCount() > 0) {
                    com.autonavi.amap.mapcore.AbstractCameraUpdateMessage stateMessage = this.f.getStateMessage();
                    if (stateMessage != null) {
                        stateMessage.mergeCameraUpdateDelegate(c2);
                    }
                }
                abstractCameraUpdateMessage = c2;
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
        }
        resetRenderTime();
        this.f.clearAnimations(this.F, false);
        abstractCameraUpdateMessage.isChangeFinished = true;
        a(abstractCameraUpdateMessage);
        this.f.addMessage(abstractCameraUpdateMessage, false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void onActivityPause() {
        this.H = true;
        c(this.F);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void onActivityResume() {
        this.H = false;
        d(this.F);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void onChangeFinish() {
        android.os.Message obtainMessage = this.j.obtainMessage();
        obtainMessage.what = 11;
        this.j.sendMessage(obtainMessage);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean onDoubleTap(int i, android.view.MotionEvent motionEvent) {
        if (!this.au) {
            return false;
        }
        a((int) motionEvent.getX(), (int) motionEvent.getY());
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void onFling() {
        com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer = this.D;
        if (iGlOverlayLayer != null) {
            iGlOverlayLayer.setFlingState(true);
        }
        this.T = true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void onIndoorBuildingActivity(int i, byte[] bArr) {
        com.amap.api.mapcore.util.ai aiVar;
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    aiVar = new com.amap.api.mapcore.util.ai();
                    byte b = bArr[0];
                    aiVar.a = new java.lang.String(bArr, 1, b, "utf-8");
                    int i2 = b + 1;
                    int i3 = i2 + 1;
                    byte b2 = bArr[i2];
                    aiVar.b = new java.lang.String(bArr, i3, b2, "utf-8");
                    int i4 = i3 + b2;
                    int i5 = i4 + 1;
                    byte b3 = bArr[i4];
                    aiVar.activeFloorName = new java.lang.String(bArr, i5, b3, "utf-8");
                    int i6 = i5 + b3;
                    aiVar.activeFloorIndex = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(bArr, i6);
                    int i7 = i6 + 4;
                    int i8 = i7 + 1;
                    byte b4 = bArr[i7];
                    aiVar.poiid = new java.lang.String(bArr, i8, b4, "utf-8");
                    int i9 = i8 + b4;
                    int i10 = i9 + 1;
                    byte b5 = bArr[i9];
                    aiVar.h = new java.lang.String(bArr, i10, b5, "utf-8");
                    int i11 = i10 + b5;
                    int i12 = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(bArr, i11);
                    aiVar.c = i12;
                    int i13 = i11 + 4;
                    aiVar.floor_indexs = new int[i12];
                    aiVar.floor_names = new java.lang.String[i12];
                    aiVar.d = new java.lang.String[i12];
                    for (int i14 = 0; i14 < aiVar.c; i14++) {
                        aiVar.floor_indexs[i14] = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(bArr, i13);
                        int i15 = i13 + 4;
                        int i16 = i15 + 1;
                        byte b6 = bArr[i15];
                        if (b6 > 0) {
                            aiVar.floor_names[i14] = new java.lang.String(bArr, i16, b6, "utf-8");
                            i16 += b6;
                        }
                        i13 = i16 + 1;
                        byte b7 = bArr[i16];
                        if (b7 > 0) {
                            aiVar.d[i14] = new java.lang.String(bArr, i13, b7, "utf-8");
                            i13 += b7;
                        }
                    }
                    int i17 = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(bArr, i13);
                    aiVar.e = i17;
                    int i18 = i13 + 4;
                    if (i17 > 0) {
                        aiVar.f = new int[i17];
                        for (int i19 = 0; i19 < aiVar.e; i19++) {
                            aiVar.f[i19] = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(bArr, i18);
                            i18 += 4;
                        }
                    }
                    this.bd = aiVar;
                    post(new com.amap.api.mapcore.util.b.AnonymousClass31());
                }
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.dl.a(th);
                th.printStackTrace();
                return;
            }
        }
        aiVar = null;
        this.bd = aiVar;
        post(new com.amap.api.mapcore.util.b.AnonymousClass31());
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void onLongPress(int i, android.view.MotionEvent motionEvent) {
        int i2 = 0;
        try {
            this.Q = false;
            b(i);
            com.amap.api.maps.model.BaseOverlay hitBaseOverlay = this.D.getHitBaseOverlay(motionEvent, 1);
            if (hitBaseOverlay instanceof com.amap.api.maps.model.Marker) {
                this.P = (com.amap.api.maps.model.Marker) hitBaseOverlay;
            }
            com.amap.api.maps.model.Marker marker = this.P;
            if (marker == null || !marker.isDraggable()) {
                java.util.List a2 = this.u.a(com.amap.api.maps.AMap.OnMapLongClickListener.class.hashCode());
                if (a2 != null && a2.size() > 0) {
                    com.autonavi.amap.mapcore.DPoint obtain = com.autonavi.amap.mapcore.DPoint.obtain();
                    getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
                    synchronized (a2) {
                        while (i2 < a2.size()) {
                            ((com.amap.api.maps.AMap.OnMapLongClickListener) a2.get(i2)).onMapLongClick(new com.amap.api.maps.model.LatLng(obtain.y, obtain.x));
                            i2++;
                        }
                    }
                    this.R = true;
                    obtain.recycle();
                }
                this.al.resetTickCount(30);
            }
            com.amap.api.maps.model.LatLng position = this.P.getPosition();
            if (position != null) {
                com.autonavi.amap.mapcore.IPoint obtain2 = com.autonavi.amap.mapcore.IPoint.obtain();
                getLatLng2Pixel(position.latitude, position.longitude, obtain2);
                ((android.graphics.Point) obtain2).y -= 60;
                com.autonavi.amap.mapcore.DPoint obtain3 = com.autonavi.amap.mapcore.DPoint.obtain();
                getPixel2LatLng(((android.graphics.Point) obtain2).x, ((android.graphics.Point) obtain2).y, obtain3);
                this.P.setPosition(new com.amap.api.maps.model.LatLng(obtain3.y, obtain3.x));
                this.D.set2Top(this.P.getId());
                try {
                    java.util.List a3 = this.u.a(com.amap.api.maps.AMap.OnMarkerDragListener.class.hashCode());
                    if (a3 != null && a3.size() > 0) {
                        synchronized (a3) {
                            while (i2 < a3.size()) {
                                ((com.amap.api.maps.AMap.OnMarkerDragListener) a3.get(i2)).onMarkerDragStart(this.P);
                                i2++;
                            }
                        }
                    }
                } catch (java.lang.Throwable th) {
                    com.amap.api.mapcore.util.gd.c(th, "AMapDelegateImp", "onMarkerDragStart");
                    th.printStackTrace();
                }
                this.M = true;
                obtain2.recycle();
                obtain3.recycle();
            }
            this.al.resetTickCount(30);
        } catch (java.lang.Throwable th2) {
            com.amap.api.mapcore.util.gd.c(th2, "AMapDelegateImp", "onLongPress");
            th2.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void onPause() {
        f();
        com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer = this.D;
        if (iGlOverlayLayer != null) {
            iGlOverlayLayer.setFlingState(false);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void onResume() {
        try {
            this.al.setRenderFps(15.0f);
            this.B.setRenderMode(0);
            com.amap.api.maps.interfaces.IGlOverlayLayer iGlOverlayLayer = this.D;
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.setFlingState(true);
            }
            com.amap.api.mapcore.util.bz bzVar = this.K;
            if (bzVar != null) {
                bzVar.b();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean onSingleTapConfirmed(int i, android.view.MotionEvent motionEvent) {
        if (!this.au) {
            return false;
        }
        try {
            b(i);
            if (g(motionEvent) || e(motionEvent) || f(motionEvent)) {
                return true;
            }
            d(motionEvent);
            b(motionEvent);
            return true;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "AMapDelegateImp", "onSingleTapUp");
            th.printStackTrace();
            return true;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (this.H || !this.au || !this.ar) {
            return false;
        }
        com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.bb;
        eAMapPlatformGestureInfo.mGestureState = 3;
        eAMapPlatformGestureInfo.mGestureType = 8;
        eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
        getEngineIDWithGestureInfo(this.bb);
        l();
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            m();
            d();
        } else if (action == 1) {
            e();
        }
        if (motionEvent.getAction() == 2 && this.M) {
            try {
                a(motionEvent);
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.gd.c(th, "AMapDelegateImp", "onDragMarker");
                th.printStackTrace();
            }
            return true;
        }
        if (this.an) {
            try {
                this.am.a(motionEvent);
            } catch (java.lang.Throwable th2) {
                th2.printStackTrace();
            }
        }
        try {
            java.util.List a2 = this.u.a(com.amap.api.maps.AMap.OnMapTouchListener.class.hashCode());
            if (a2 != null && a2.size() > 0) {
                this.j.removeMessages(14);
                android.os.Message obtainMessage = this.j.obtainMessage();
                obtainMessage.what = 14;
                obtainMessage.obj = android.view.MotionEvent.obtain(motionEvent);
                obtainMessage.sendToTarget();
            }
        } catch (java.lang.Throwable unused) {
        }
        return true;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void pixel2Map(int i, int i2, android.graphics.PointF pointF) {
        if (!this.au || this.H || this.f == null) {
            return;
        }
        com.autonavi.amap.mapcore.IPoint obtain = com.autonavi.amap.mapcore.IPoint.obtain();
        getPixel2Geo(i, i2, obtain);
        pointF.x = ((android.graphics.Point) obtain).x - ((float) this.b.getSX());
        pointF.y = ((android.graphics.Point) obtain).y - ((float) this.b.getSY());
        obtain.recycle();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void post(java.lang.Runnable runnable) {
        com.autonavi.base.amap.api.mapcore.IGLSurfaceView iGLSurfaceView = this.B;
        if (iGLSurfaceView != null) {
            iGLSurfaceView.post(runnable);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void queueEvent(java.lang.Runnable runnable) {
        long j;
        try {
            try {
                j = java.lang.Thread.currentThread().getId();
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.dl.a(th);
                com.amap.api.mapcore.util.gd.c(th, "AMapdelegateImp", "queueEvent");
                j = -1;
            }
            if (j != -1 && j == this.ak) {
                runnable.run();
            } else if (this.f != null) {
                this.B.queueEvent(runnable);
            }
        } catch (java.lang.Throwable th2) {
            com.amap.api.mapcore.util.dl.a(th2);
            com.amap.api.mapcore.util.gd.c(th2, "AMapdelegateImp", "queueEvent");
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void redrawInfoWindow() {
        if (this.au) {
            this.j.sendEmptyMessage(18);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void refreshLogo() {
        com.amap.api.mapcore.util.dw dwVar = this.C;
        if (dwVar != null) {
            dwVar.c();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void reloadMap() {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void reloadMapCustomStyle() {
        com.amap.api.mapcore.util.a aVar = this.aF;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void removeEngineGLOverlay(com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay baseMapOverlay) {
        if (this.f != null) {
            queueEvent(new com.amap.api.mapcore.util.b.AnonymousClass35(baseMapOverlay));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean removeGLModel(java.lang.String str) {
        try {
            this.D.removeOverlay(str);
            return false;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "AMapDelegateImp", "removeGLModel");
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean removeGLOverlay(java.lang.String str) throws android.os.RemoteException {
        resetRenderTime();
        return this.D.removeOverlay(str);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnCameraChangeListener(com.amap.api.maps.AMap.OnCameraChangeListener onCameraChangeListener) throws android.os.RemoteException {
        com.amap.api.mapcore.util.g gVar = this.u;
        if (gVar != null) {
            gVar.b(java.lang.Integer.valueOf(com.amap.api.maps.AMap.OnCameraChangeListener.class.hashCode()), onCameraChangeListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnIndoorBuildingActiveListener(com.amap.api.maps.AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) throws android.os.RemoteException {
        com.amap.api.mapcore.util.g gVar = this.u;
        if (gVar != null) {
            gVar.b(java.lang.Integer.valueOf(com.amap.api.maps.AMap.OnIndoorBuildingActiveListener.class.hashCode()), onIndoorBuildingActiveListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnInfoWindowClickListener(com.amap.api.maps.AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws android.os.RemoteException {
        com.amap.api.mapcore.util.g gVar = this.u;
        if (gVar != null) {
            gVar.b(java.lang.Integer.valueOf(com.amap.api.maps.AMap.OnInfoWindowClickListener.class.hashCode()), onInfoWindowClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnMapClickListener(com.amap.api.maps.AMap.OnMapClickListener onMapClickListener) throws android.os.RemoteException {
        com.amap.api.mapcore.util.g gVar = this.u;
        if (gVar != null) {
            gVar.b(java.lang.Integer.valueOf(com.amap.api.maps.AMap.OnMapClickListener.class.hashCode()), onMapClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnMapLoadedListener(com.amap.api.maps.AMap.OnMapLoadedListener onMapLoadedListener) {
        com.amap.api.mapcore.util.g gVar = this.u;
        if (gVar != null) {
            gVar.b(java.lang.Integer.valueOf(com.amap.api.maps.AMap.OnMapLoadedListener.class.hashCode()), onMapLoadedListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnMapLongClickListener(com.amap.api.maps.AMap.OnMapLongClickListener onMapLongClickListener) throws android.os.RemoteException {
        com.amap.api.mapcore.util.g gVar = this.u;
        if (gVar != null) {
            gVar.b(java.lang.Integer.valueOf(com.amap.api.maps.AMap.OnMapLongClickListener.class.hashCode()), onMapLongClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnMapTouchListener(com.amap.api.maps.AMap.OnMapTouchListener onMapTouchListener) throws android.os.RemoteException {
        com.amap.api.mapcore.util.g gVar = this.u;
        if (gVar != null) {
            gVar.b(java.lang.Integer.valueOf(com.amap.api.maps.AMap.OnMapTouchListener.class.hashCode()), onMapTouchListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnMarkerClickListener(com.amap.api.maps.AMap.OnMarkerClickListener onMarkerClickListener) throws android.os.RemoteException {
        com.amap.api.mapcore.util.g gVar = this.u;
        if (gVar != null) {
            gVar.b(java.lang.Integer.valueOf(com.amap.api.maps.AMap.OnMarkerClickListener.class.hashCode()), onMarkerClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnMarkerDragListener(com.amap.api.maps.AMap.OnMarkerDragListener onMarkerDragListener) {
        com.amap.api.mapcore.util.g gVar = this.u;
        if (gVar != null) {
            gVar.b(java.lang.Integer.valueOf(com.amap.api.maps.AMap.OnMarkerDragListener.class.hashCode()), onMarkerDragListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnMyLocationChangeListener(com.amap.api.maps.AMap.OnMyLocationChangeListener onMyLocationChangeListener) throws android.os.RemoteException {
        com.amap.api.mapcore.util.g gVar = this.u;
        if (gVar != null) {
            gVar.b(java.lang.Integer.valueOf(com.amap.api.maps.AMap.OnMyLocationChangeListener.class.hashCode()), onMyLocationChangeListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnPOIClickListener(com.amap.api.maps.AMap.OnPOIClickListener onPOIClickListener) throws android.os.RemoteException {
        com.amap.api.mapcore.util.g gVar = this.u;
        if (gVar != null) {
            gVar.b(java.lang.Integer.valueOf(com.amap.api.maps.AMap.OnPOIClickListener.class.hashCode()), onPOIClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnPolylineClickListener(com.amap.api.maps.AMap.OnPolylineClickListener onPolylineClickListener) throws android.os.RemoteException {
        com.amap.api.mapcore.util.g gVar = this.u;
        if (gVar != null) {
            gVar.b(java.lang.Integer.valueOf(com.amap.api.maps.AMap.OnPolylineClickListener.class.hashCode()), onPolylineClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removecache() throws android.os.RemoteException {
        removecache(null);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removecache(com.amap.api.maps.AMap.OnCacheRemoveListener onCacheRemoveListener) throws android.os.RemoteException {
        if (this.j == null || this.f == null) {
            return;
        }
        try {
            com.amap.api.mapcore.util.b.d dVar = new com.amap.api.mapcore.util.b.d(this.e, onCacheRemoveListener);
            this.j.removeCallbacks(dVar);
            this.j.post(dVar);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "AMapDelegateImp", "removecache");
            th.printStackTrace();
            com.amap.api.mapcore.util.dl.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void renderSurface(javax.microedition.khronos.opengles.GL10 gl10) {
        drawFrame(gl10);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void requestRender() {
        com.autonavi.base.ae.gmap.GLMapRender gLMapRender = this.al;
        if (gLMapRender == null || gLMapRender.isRenderPause()) {
            return;
        }
        this.B.requestRender();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void resetMinMaxZoomPreference() {
        java.util.List a2;
        this.b.resetMinMaxZoomPreference();
        try {
            if (!this.z.isZoomControlsEnabled() || !this.b.isNeedUpdateZoomControllerState() || (a2 = this.u.a(com.autonavi.base.ae.gmap.listener.AMapWidgetListener.class.hashCode())) == null || a2.size() <= 0) {
                return;
            }
            synchronized (a2) {
                for (int i = 0; i < a2.size(); i++) {
                    ((com.autonavi.base.ae.gmap.listener.AMapWidgetListener) a2.get(i)).invalidateZoomController(this.b.getSZ());
                }
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void resetRenderTime() {
        com.autonavi.base.ae.gmap.GLMapRender gLMapRender = this.al;
        if (gLMapRender != null) {
            gLMapRender.resetTickCount(2);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void resetRenderTimeLongLong() {
        com.autonavi.base.ae.gmap.GLMapRender gLMapRender = this.al;
        if (gLMapRender != null) {
            gLMapRender.resetTickCount(30);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void set3DBuildingEnabled(boolean z) throws android.os.RemoteException {
        try {
            c(this.F);
            a(this.F, z);
            d(this.F);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setAMapGestureListener(com.amap.api.maps.model.AMapGestureListener aMapGestureListener) {
        com.amap.api.mapcore.util.n nVar = this.am;
        if (nVar != null) {
            this.v = aMapGestureListener;
            nVar.a(aMapGestureListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setCenterToPixel(int i, int i2) throws android.os.RemoteException {
        this.I = true;
        this.aA = i;
        this.aB = i2;
        if (this.av && this.au) {
            if (this.b.getAnchorX() == this.aA && this.b.getAnchorY() == this.aB) {
                return;
            }
            this.b.setAnchorX(this.aA);
            this.b.setAnchorY(this.aB);
            queueEvent(new com.amap.api.mapcore.util.b.AnonymousClass29());
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setConstructingRoadEnable(boolean z) {
        try {
            if (this.au && this.av) {
                resetRenderTime();
                queueEvent(new com.amap.api.mapcore.util.b.AnonymousClass27(z));
            } else {
                com.amap.api.mapcore.util.b.a aVar = this.aP;
                aVar.c = z;
                aVar.b = true;
                aVar.g = this.F;
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setCustomMapStyle(com.amap.api.maps.model.CustomMapStyleOptions customMapStyleOptions) {
        if (customMapStyleOptions != null) {
            try {
                if (a(true, false)) {
                    return;
                }
                if (customMapStyleOptions.isEnable() && (customMapStyleOptions.getStyleId() != null || customMapStyleOptions.getStyleTexturePath() != null || customMapStyleOptions.getStyleTextureData() != null || customMapStyleOptions.getStyleResDataPath() != null || customMapStyleOptions.getStyleResData() != null)) {
                    o();
                }
                this.aF.c();
                this.aF.a(customMapStyleOptions);
                com.autonavi.extra.b bVar = this.aV;
                if (bVar != null) {
                    bVar.i();
                }
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.dl.a(th);
                return;
            }
        }
        resetRenderTime();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setCustomMapStyle(boolean z, byte[] bArr) {
        a(z, bArr, false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setCustomMapStyleID(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str) || str.equals(this.b.getCustomStyleID())) {
            return;
        }
        this.b.setCustomStyleID(str);
        this.A = true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setCustomMapStylePath(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str) || str.equals(this.b.getCustomStylePath())) {
            return;
        }
        this.b.setCustomStylePath(str);
        this.A = true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setCustomRenderer(com.amap.api.maps.CustomRenderer customRenderer) throws android.os.RemoteException {
        this.ae = customRenderer;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setCustomTextureResourcePath(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.b.setCustomTextureResourcePath(str);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setGestureStatus(int i, int i2) {
        if (this.az == 0 || i2 != 5) {
            this.az = i2;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setHideLogoEnble(boolean z) {
        com.autonavi.base.amap.mapcore.MapConfig mapConfig = this.b;
        if (mapConfig != null) {
            mapConfig.setHideLogoEnble(z);
            if (this.b.isCustomStyleEnable()) {
                this.z.setLogoEnable(!z);
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setIndoorBuildingInfo(com.amap.api.maps.model.IndoorBuildingInfo indoorBuildingInfo) throws android.os.RemoteException {
        if (this.G || indoorBuildingInfo == null || indoorBuildingInfo.activeFloorName == null || indoorBuildingInfo.poiid == null) {
            return;
        }
        this.c = (com.amap.api.mapcore.util.ai) indoorBuildingInfo;
        resetRenderTime();
        queueEvent(new com.amap.api.mapcore.util.b.AnonymousClass30());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setIndoorEnabled(boolean z) throws android.os.RemoteException {
        java.util.List a2;
        try {
            if (!this.au || this.G) {
                com.amap.api.mapcore.util.b.a aVar = this.aS;
                aVar.c = z;
                aVar.b = true;
                aVar.g = this.F;
                return;
            }
            this.b.setIndoorEnable(z);
            resetRenderTime();
            if (z) {
                com.autonavi.base.ae.gmap.GLMapEngine gLMapEngine = this.f;
                if (gLMapEngine != null) {
                    gLMapEngine.setIndoorEnable(this.F, true);
                }
            } else {
                com.autonavi.base.ae.gmap.GLMapEngine gLMapEngine2 = this.f;
                if (gLMapEngine2 != null) {
                    gLMapEngine2.setIndoorEnable(this.F, false);
                }
                com.autonavi.base.amap.mapcore.MapConfig mapConfig = this.b;
                mapConfig.maxZoomLevel = mapConfig.isSetLimitZoomLevel() ? this.b.getMaxZoomLevel() : 20.0f;
                try {
                    if (this.z.isZoomControlsEnabled() && (a2 = this.u.a(com.autonavi.base.ae.gmap.listener.AMapWidgetListener.class.hashCode())) != null && a2.size() > 0) {
                        synchronized (a2) {
                            for (int i = 0; i < a2.size(); i++) {
                                ((com.autonavi.base.ae.gmap.listener.AMapWidgetListener) a2.get(i)).invalidateZoomController(this.b.getSZ());
                            }
                        }
                    }
                } catch (java.lang.Throwable unused) {
                }
            }
            com.amap.api.mapcore.util.di.c(this.e, z);
            if (this.z.isIndoorSwitchEnabled()) {
                this.j.post(new com.amap.api.mapcore.util.b.AnonymousClass22(z));
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setInfoWindowAdapter(com.amap.api.maps.AMap.CommonInfoWindowAdapter commonInfoWindowAdapter) throws android.os.RemoteException {
        com.amap.api.mapcore.util.aj ajVar;
        if (this.G || (ajVar = this.w) == null) {
            return;
        }
        ajVar.a(commonInfoWindowAdapter);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setInfoWindowAdapter(com.amap.api.maps.AMap.InfoWindowAdapter infoWindowAdapter) throws android.os.RemoteException {
        com.amap.api.mapcore.util.aj ajVar;
        if (this.G || (ajVar = this.w) == null) {
            return;
        }
        ajVar.a(infoWindowAdapter);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setLoadOfflineData(boolean z) throws android.os.RemoteException {
        queueEvent(new com.amap.api.mapcore.util.b.AnonymousClass23(z));
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setLocationSource(com.amap.api.maps.LocationSource locationSource) throws android.os.RemoteException {
        try {
            if (this.G) {
                return;
            }
            com.amap.api.maps.LocationSource locationSource2 = this.L;
            if (locationSource2 != null && (locationSource2 instanceof com.amap.api.mapcore.util.ak)) {
                locationSource2.deactivate();
            }
            this.L = locationSource;
            if (locationSource != null) {
                this.C.h(java.lang.Boolean.TRUE);
            } else {
                this.C.h(java.lang.Boolean.FALSE);
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "AMapDelegateImp", "setLocationSource");
            th.printStackTrace();
            com.amap.api.mapcore.util.dl.a(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setLogoBottomMargin(int i) {
        com.amap.api.mapcore.util.dw dwVar = this.C;
        if (dwVar != null) {
            dwVar.c(java.lang.Integer.valueOf(i));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setLogoLeftMargin(int i) {
        com.amap.api.mapcore.util.dw dwVar = this.C;
        if (dwVar != null) {
            dwVar.d(java.lang.Integer.valueOf(i));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setLogoMarginRate(int i, float f) {
        com.amap.api.mapcore.util.dw dwVar = this.C;
        if (dwVar != null) {
            dwVar.a(java.lang.Integer.valueOf(i), java.lang.Float.valueOf(f));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setLogoPosition(int i) {
        com.amap.api.mapcore.util.dw dwVar = this.C;
        if (dwVar != null) {
            dwVar.b(java.lang.Integer.valueOf(i));
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMapCustomEnable(boolean z) {
        if (z) {
            o();
        }
        setMapCustomEnable(z, false);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setMapCustomEnable(boolean z, boolean z2) {
        com.amap.api.mapcore.util.cg cgVar;
        if (!this.au || this.G) {
            com.amap.api.mapcore.util.b.a aVar = this.aK;
            aVar.b = true;
            aVar.c = z;
            return;
        }
        boolean z3 = z2 ? z2 : false;
        if (android.text.TextUtils.isEmpty(this.b.getCustomStylePath()) && android.text.TextUtils.isEmpty(this.b.getCustomStyleID())) {
            return;
        }
        if (z) {
            try {
                if (this.b.isProFunctionAuthEnable() && !android.text.TextUtils.isEmpty(this.b.getCustomStyleID()) && (cgVar = this.ai) != null) {
                    cgVar.a(this.b.getCustomStyleID());
                    this.ai.b();
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                com.amap.api.mapcore.util.dl.a(th);
                return;
            }
        }
        if (z2 || this.A || (this.b.isCustomStyleEnable() ^ z)) {
            a(z, (byte[]) null, z3);
        }
        this.A = false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setMapEnable(boolean z) {
        com.autonavi.base.amap.mapcore.MapConfig mapConfig = this.b;
        if (mapConfig != null) {
            mapConfig.setMapEnable(z);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMapLanguage(java.lang.String str) {
        com.autonavi.base.amap.mapcore.MapConfig mapConfig;
        if (android.text.TextUtils.isEmpty(str) || (mapConfig = this.b) == null || mapConfig.isCustomStyleEnable() || this.b.getMapLanguage().equals(str)) {
            return;
        }
        if (!str.equals("en")) {
            this.b.setMapLanguage("zh_cn");
            this.ad = 0;
        } else {
            if (this.X != 1) {
                try {
                    setMapType(1);
                } catch (java.lang.Throwable th) {
                    com.amap.api.mapcore.util.dl.a(th);
                    th.printStackTrace();
                }
            }
            this.b.setMapLanguage("en");
            this.ad = com.anythink.core.common.h.i.k;
        }
        try {
            b(getCameraPosition());
        } catch (java.lang.Throwable th2) {
            com.amap.api.mapcore.util.dl.a(th2);
            th2.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMapStatusLimits(com.amap.api.maps.model.LatLngBounds latLngBounds) {
        try {
            this.b.setLimitLatLngBounds(latLngBounds);
            p();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            com.amap.api.mapcore.util.dl.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMapTextEnable(boolean z) throws android.os.RemoteException {
        try {
            if (this.au && this.av) {
                resetRenderTime();
                queueEvent(new com.amap.api.mapcore.util.b.AnonymousClass24(z));
            } else {
                com.amap.api.mapcore.util.b.a aVar = this.aM;
                aVar.c = z;
                aVar.b = true;
                aVar.g = this.F;
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMapTextZIndex(int i) throws android.os.RemoteException {
        this.ad = i;
        this.i = false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMapType(int i) throws android.os.RemoteException {
        com.autonavi.base.amap.mapcore.MapConfig mapConfig;
        if (i != this.X || ((mapConfig = this.b) != null && mapConfig.isCustomStyleEnable())) {
            this.X = i;
            h(i);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setMapWidgetListener(com.autonavi.base.ae.gmap.listener.AMapWidgetListener aMapWidgetListener) {
        try {
            com.amap.api.mapcore.util.g gVar = this.u;
            if (gVar != null) {
                gVar.a(com.autonavi.base.ae.gmap.listener.AMapWidgetListener.class.hashCode(), (int) aMapWidgetListener);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMaskLayerParams(int i, int i2, int i3, int i4, int i5, long j) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMaxZoomLevel(float f) {
        this.b.setMaxZoomLevel(f);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMinZoomLevel(float f) {
        this.b.setMinZoomLevel(f);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMyLocationEnabled(boolean z) throws android.os.RemoteException {
        if (this.G) {
            return;
        }
        try {
            com.amap.api.mapcore.util.dw dwVar = this.C;
            if (dwVar != null) {
                com.amap.api.maps.LocationSource locationSource = this.L;
                if (locationSource == null) {
                    dwVar.h(java.lang.Boolean.FALSE);
                } else if (z) {
                    locationSource.activate(this.t);
                    this.C.h(java.lang.Boolean.TRUE);
                    if (this.K == null) {
                        this.K = new com.amap.api.mapcore.util.bz(this, this.e);
                    }
                } else {
                    com.amap.api.mapcore.util.bz bzVar = this.K;
                    if (bzVar != null) {
                        bzVar.c();
                        this.K = null;
                    }
                    this.L.deactivate();
                }
            }
            if (!z) {
                this.z.setMyLocationButtonEnabled(z);
            }
            this.E = z;
            resetRenderTime();
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "AMapDelegateImp", "setMyLocationEnabled");
            th.printStackTrace();
            com.amap.api.mapcore.util.dl.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMyLocationRotateAngle(float f) throws android.os.RemoteException {
        try {
            com.amap.api.mapcore.util.bz bzVar = this.K;
            if (bzVar != null) {
                bzVar.a(f);
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMyLocationStyle(com.amap.api.maps.model.MyLocationStyle myLocationStyle) throws android.os.RemoteException {
        if (this.G) {
            return;
        }
        try {
            if (this.K == null) {
                this.K = new com.amap.api.mapcore.util.bz(this, this.e);
            }
            if (this.K != null) {
                if (myLocationStyle.getInterval() < 1000) {
                    myLocationStyle.interval(1000L);
                }
                com.amap.api.maps.LocationSource locationSource = this.L;
                if (locationSource != null && (locationSource instanceof com.amap.api.mapcore.util.ak)) {
                    ((com.amap.api.mapcore.util.ak) locationSource).a(myLocationStyle.getInterval());
                    ((com.amap.api.mapcore.util.ak) this.L).a(myLocationStyle.getMyLocationType());
                }
                this.K.a(myLocationStyle);
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMyLocationType(int i) throws android.os.RemoteException {
        try {
            com.amap.api.mapcore.util.bz bzVar = this.K;
            if (bzVar == null || bzVar.a() == null) {
                return;
            }
            this.K.a().myLocationType(i);
            setMyLocationStyle(this.K.a());
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setNaviLabelEnable(boolean z, int i, int i2) throws android.os.RemoteException {
        try {
            if (this.au && this.av) {
                resetRenderTime();
                queueEvent(new com.amap.api.mapcore.util.b.AnonymousClass26(z, i, i2));
                return;
            }
            com.amap.api.mapcore.util.b.a aVar = this.aO;
            aVar.c = z;
            aVar.h = i;
            aVar.i = i2;
            aVar.b = true;
            aVar.g = this.F;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnCameraChangeListener(com.amap.api.maps.AMap.OnCameraChangeListener onCameraChangeListener) throws android.os.RemoteException {
        com.amap.api.mapcore.util.g gVar = this.u;
        if (gVar != null) {
            gVar.a(com.amap.api.maps.AMap.OnCameraChangeListener.class.hashCode(), (int) onCameraChangeListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnIndoorBuildingActiveListener(com.amap.api.maps.AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) throws android.os.RemoteException {
        com.amap.api.mapcore.util.g gVar = this.u;
        if (gVar != null) {
            gVar.a(com.amap.api.maps.AMap.OnIndoorBuildingActiveListener.class.hashCode(), (int) onIndoorBuildingActiveListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnInfoWindowClickListener(com.amap.api.maps.AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws android.os.RemoteException {
        com.amap.api.mapcore.util.g gVar = this.u;
        if (gVar != null) {
            gVar.a(com.amap.api.maps.AMap.OnInfoWindowClickListener.class.hashCode(), (int) onInfoWindowClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMapClickListener(com.amap.api.maps.AMap.OnMapClickListener onMapClickListener) throws android.os.RemoteException {
        com.amap.api.mapcore.util.g gVar = this.u;
        if (gVar != null) {
            gVar.a(com.amap.api.maps.AMap.OnMapClickListener.class.hashCode(), (int) onMapClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMapLongClickListener(com.amap.api.maps.AMap.OnMapLongClickListener onMapLongClickListener) throws android.os.RemoteException {
        com.amap.api.mapcore.util.g gVar = this.u;
        if (gVar != null) {
            gVar.a(com.amap.api.maps.AMap.OnMapLongClickListener.class.hashCode(), (int) onMapLongClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMapTouchListener(com.amap.api.maps.AMap.OnMapTouchListener onMapTouchListener) throws android.os.RemoteException {
        com.amap.api.mapcore.util.g gVar = this.u;
        if (gVar != null) {
            gVar.a(com.amap.api.maps.AMap.OnMapTouchListener.class.hashCode(), (int) onMapTouchListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMaploadedListener(com.amap.api.maps.AMap.OnMapLoadedListener onMapLoadedListener) throws android.os.RemoteException {
        com.amap.api.mapcore.util.g gVar = this.u;
        if (gVar != null) {
            gVar.a(com.amap.api.maps.AMap.OnMapLoadedListener.class.hashCode(), (int) onMapLoadedListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMarkerClickListener(com.amap.api.maps.AMap.OnMarkerClickListener onMarkerClickListener) throws android.os.RemoteException {
        com.amap.api.mapcore.util.g gVar = this.u;
        if (gVar != null) {
            gVar.a(com.amap.api.maps.AMap.OnMarkerClickListener.class.hashCode(), (int) onMarkerClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMarkerDragListener(com.amap.api.maps.AMap.OnMarkerDragListener onMarkerDragListener) throws android.os.RemoteException {
        com.amap.api.mapcore.util.g gVar = this.u;
        if (gVar != null) {
            gVar.a(com.amap.api.maps.AMap.OnMarkerDragListener.class.hashCode(), (int) onMarkerDragListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMultiPointClickListener(com.amap.api.maps.AMap.OnMultiPointClickListener onMultiPointClickListener) {
        this.aE = onMultiPointClickListener;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMyLocationChangeListener(com.amap.api.maps.AMap.OnMyLocationChangeListener onMyLocationChangeListener) {
        com.amap.api.mapcore.util.g gVar = this.u;
        if (gVar != null) {
            gVar.a(com.amap.api.maps.AMap.OnMyLocationChangeListener.class.hashCode(), (int) onMyLocationChangeListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnPOIClickListener(com.amap.api.maps.AMap.OnPOIClickListener onPOIClickListener) throws android.os.RemoteException {
        com.amap.api.mapcore.util.g gVar = this.u;
        if (gVar != null) {
            gVar.a(com.amap.api.maps.AMap.OnPOIClickListener.class.hashCode(), (int) onPOIClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnPolylineClickListener(com.amap.api.maps.AMap.OnPolylineClickListener onPolylineClickListener) throws android.os.RemoteException {
        com.amap.api.mapcore.util.g gVar = this.u;
        if (gVar != null) {
            gVar.a(com.amap.api.maps.AMap.OnPolylineClickListener.class.hashCode(), (int) onPolylineClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setRenderFps(int i) {
        try {
            if (i == -1) {
                this.ag = i;
            } else {
                this.ag = java.lang.Math.max(10, java.lang.Math.min(i, 40));
            }
            com.amap.api.mapcore.util.di.g(this.e);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setRenderMode(int i) {
        try {
            com.autonavi.base.amap.api.mapcore.IGLSurfaceView iGLSurfaceView = this.B;
            if (iGLSurfaceView != null) {
                iGLSurfaceView.setRenderMode(i);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setRoadArrowEnable(boolean z) throws android.os.RemoteException {
        try {
            if (this.au && this.av) {
                resetRenderTime();
                queueEvent(new com.amap.api.mapcore.util.b.AnonymousClass25(z));
            } else {
                com.amap.api.mapcore.util.b.a aVar = this.aN;
                aVar.c = z;
                aVar.b = true;
                aVar.g = this.F;
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setRunLowFrame(boolean z) {
        if (z) {
            return;
        }
        try {
            if (this.ag == -1) {
                m();
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setTouchPoiEnable(boolean z) {
        com.autonavi.base.amap.mapcore.MapConfig mapConfig = this.b;
        if (mapConfig != null) {
            mapConfig.setTouchPoiEnable(z);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setTrafficEnabled(boolean z) throws android.os.RemoteException {
        try {
            if (this.au && !this.G) {
                queueEvent(new com.amap.api.mapcore.util.b.AnonymousClass20(z, z));
                return;
            }
            com.amap.api.mapcore.util.b.a aVar = this.aH;
            aVar.c = z;
            aVar.b = true;
            aVar.g = this.F;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setTrafficStyleWithTextureData(byte[] bArr) {
        if (this.G) {
            return;
        }
        try {
            if (this.au && this.av && bArr != null) {
                resetRenderTime();
                queueEvent(new com.amap.api.mapcore.util.b.AnonymousClass28(bArr));
            } else {
                com.amap.api.mapcore.util.b.a aVar = this.aQ;
                aVar.j = bArr;
                aVar.b = true;
                aVar.g = this.F;
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setVisibilityEx(int i) {
        com.autonavi.base.amap.api.mapcore.IGLSurfaceView iGLSurfaceView = this.B;
        if (iGLSurfaceView != null) {
            try {
                iGLSurfaceView.setVisibility(i);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setWorldVectorMapStyle(java.lang.String str) {
        if (a(false, true) || android.text.TextUtils.isEmpty(str) || this.b == null || this.aX.equals(str)) {
            return;
        }
        this.aX = str;
        com.autonavi.extra.b bVar = this.aV;
        if (bVar != null) {
            bVar.i();
        }
        resetRenderTime();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setZOrderOnTop(boolean z) throws android.os.RemoteException {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setZoomPosition(int i) {
        com.amap.api.mapcore.util.dw dwVar;
        if (this.G || (dwVar = this.C) == null) {
            return;
        }
        dwVar.a(java.lang.Integer.valueOf(i));
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setZoomScaleParam(float f) {
        this.ap = f;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showCompassEnabled(boolean z) {
        com.amap.api.mapcore.util.dw dwVar;
        if (this.G || (dwVar = this.C) == null) {
            return;
        }
        dwVar.d(java.lang.Boolean.valueOf(z));
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showIndoorSwitchControlsEnabled(boolean z) {
        com.amap.api.mapcore.util.dw dwVar;
        if (this.G || (dwVar = this.C) == null) {
            return;
        }
        dwVar.a(java.lang.Boolean.valueOf(z));
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showInfoWindow(com.amap.api.maps.model.BaseOverlay baseOverlay) throws android.os.RemoteException {
        com.amap.api.mapcore.util.aj ajVar;
        if (baseOverlay == null || (ajVar = this.w) == null) {
            return;
        }
        try {
            ajVar.a(baseOverlay);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showInfoWindow(com.autonavi.base.amap.api.mapcore.BaseOverlayImp baseOverlayImp) throws android.os.RemoteException {
        com.amap.api.mapcore.util.aj ajVar;
        if (baseOverlayImp == null || (ajVar = this.w) == null) {
            return;
        }
        try {
            ajVar.a(baseOverlayImp);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showLogoEnabled(boolean z) {
        if (this.G) {
            return;
        }
        this.C.f(java.lang.Boolean.valueOf(z));
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showMyLocationButtonEnabled(boolean z) {
        com.amap.api.mapcore.util.dw dwVar;
        if (this.G || (dwVar = this.C) == null) {
            return;
        }
        dwVar.c(java.lang.Boolean.valueOf(z));
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showMyLocationOverlay(android.location.Location location) throws android.os.RemoteException {
        if (location == null) {
            return;
        }
        try {
            if (this.E && this.L != null) {
                if (this.K == null) {
                    this.K = new com.amap.api.mapcore.util.bz(this, this.e);
                }
                if (location.getLongitude() != 0.0d && location.getLatitude() != 0.0d) {
                    this.K.a(location);
                }
                java.util.List a2 = this.u.a(com.amap.api.maps.AMap.OnMyLocationChangeListener.class.hashCode());
                if (a2 != null && a2.size() > 0) {
                    synchronized (a2) {
                        for (int i = 0; i < a2.size(); i++) {
                            ((com.amap.api.maps.AMap.OnMyLocationChangeListener) a2.get(i)).onMyLocationChange(location);
                        }
                    }
                }
                resetRenderTime();
                return;
            }
            com.amap.api.mapcore.util.bz bzVar = this.K;
            if (bzVar != null) {
                bzVar.c();
            }
            this.K = null;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "AMapDelegateImp", "showMyLocationOverlay");
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showScaleEnabled(boolean z) {
        com.amap.api.mapcore.util.dw dwVar;
        if (this.G || (dwVar = this.C) == null) {
            return;
        }
        dwVar.e(java.lang.Boolean.valueOf(z));
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showZoomControlsEnabled(boolean z) {
        com.amap.api.mapcore.util.dw dwVar;
        if (this.G || (dwVar = this.C) == null) {
            return;
        }
        dwVar.b(java.lang.Boolean.valueOf(z));
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void stopAnimation() throws android.os.RemoteException {
        try {
            com.autonavi.base.ae.gmap.GLMapEngine gLMapEngine = this.f;
            if (gLMapEngine != null) {
                gLMapEngine.interruptAnimation();
            }
            resetRenderTime();
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float toMapLenWithWin(int i) {
        com.autonavi.base.ae.gmap.GLMapEngine gLMapEngine;
        if (!this.au || this.H || (gLMapEngine = this.f) == null) {
            return 0.0f;
        }
        return gLMapEngine.getMapState(this.F).getGLUnitWithWin(i);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void zoomOut(int i) {
        if (this.au && ((int) c()) > this.b.getMinZoomLevel()) {
            try {
                animateCamera(com.amap.api.mapcore.util.z.b());
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.gd.c(th, "AMapDelegateImp", "onDoubleTap");
                th.printStackTrace();
            }
            resetRenderTime();
        }
    }
}
