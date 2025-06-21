package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class n {
    com.autonavi.base.amap.api.mapcore.IAMapDelegate a;
    android.content.Context b;
    android.view.GestureDetector c;
    public com.amap.api.maps.model.AMapGestureListener d;
    private com.amap.api.mapcore.util.ag e;
    private com.amap.api.mapcore.util.ae f;
    private com.amap.api.mapcore.util.ad g;
    private com.amap.api.mapcore.util.ah h;
    private int r;

    /* renamed from: s, reason: collision with root package name */
    private int f139s;
    private boolean i = false;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private int m = 0;
    private int n = 0;
    private boolean o = false;
    private boolean p = false;
    private boolean q = true;
    private android.os.Handler t = new android.os.Handler(android.os.Looper.getMainLooper());

    public class a implements android.view.GestureDetector.OnDoubleTapListener, android.view.GestureDetector.OnGestureListener {
        float a;
        long b;
        private int d;
        private com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo e;

        private a() {
            this.d = 0;
            this.a = 0.0f;
            this.e = new com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo();
            this.b = 0L;
        }

        public /* synthetic */ a(com.amap.api.mapcore.util.n nVar, byte b) {
            this();
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(android.view.MotionEvent motionEvent) {
            com.amap.api.mapcore.util.n.this.c.setIsLongpressEnabled(false);
            this.d = motionEvent.getPointerCount();
            com.amap.api.maps.model.AMapGestureListener aMapGestureListener = com.amap.api.mapcore.util.n.this.d;
            if (aMapGestureListener != null) {
                aMapGestureListener.onDoubleTap(motionEvent.getX(), motionEvent.getY());
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTapEvent(android.view.MotionEvent motionEvent) {
            if (this.d < motionEvent.getPointerCount()) {
                this.d = motionEvent.getPointerCount();
            }
            int action = motionEvent.getAction() & 255;
            if (this.d != 1) {
                return false;
            }
            try {
                if (!com.amap.api.mapcore.util.n.this.a.getUiSettings().isZoomGesturesEnabled()) {
                    return false;
                }
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.gd.c(th, "GLMapGestrureDetector", "onDoubleTapEvent");
                th.printStackTrace();
            }
            if (action == 0) {
                com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.e;
                eAMapPlatformGestureInfo.mGestureState = 1;
                eAMapPlatformGestureInfo.mGestureType = 9;
                eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                int engineIDWithGestureInfo = com.amap.api.mapcore.util.n.this.a.getEngineIDWithGestureInfo(this.e);
                this.a = motionEvent.getY();
                com.amap.api.mapcore.util.n.this.a.addGestureMapMessage(engineIDWithGestureInfo, com.autonavi.base.amap.mapcore.message.ScaleGestureMapMessage.obtain(100, 1.0f, 0, 0));
                this.b = android.os.SystemClock.uptimeMillis();
                return true;
            }
            if (action == 2) {
                com.amap.api.mapcore.util.n.this.o = true;
                float y = this.a - motionEvent.getY();
                if (java.lang.Math.abs(y) < 20.0f) {
                    return true;
                }
                com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo eAMapPlatformGestureInfo2 = this.e;
                eAMapPlatformGestureInfo2.mGestureState = 2;
                eAMapPlatformGestureInfo2.mGestureType = 9;
                eAMapPlatformGestureInfo2.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                com.amap.api.mapcore.util.n.this.a.addGestureMapMessage(com.amap.api.mapcore.util.n.this.a.getEngineIDWithGestureInfo(this.e), com.autonavi.base.amap.mapcore.message.ScaleGestureMapMessage.obtain(101, (y * 4.0f) / com.amap.api.mapcore.util.n.this.a.getMapHeight(), 0, 0));
                this.a = motionEvent.getY();
                return true;
            }
            com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo eAMapPlatformGestureInfo3 = this.e;
            eAMapPlatformGestureInfo3.mGestureState = 3;
            eAMapPlatformGestureInfo3.mGestureType = 9;
            eAMapPlatformGestureInfo3.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
            int engineIDWithGestureInfo2 = com.amap.api.mapcore.util.n.this.a.getEngineIDWithGestureInfo(this.e);
            com.amap.api.mapcore.util.n.this.c.setIsLongpressEnabled(true);
            com.amap.api.mapcore.util.n.this.a.addGestureMapMessage(engineIDWithGestureInfo2, com.autonavi.base.amap.mapcore.message.ScaleGestureMapMessage.obtain(102, 1.0f, 0, 0));
            if (action != 1) {
                com.amap.api.mapcore.util.n.this.o = false;
                return true;
            }
            com.amap.api.mapcore.util.n.this.a.setGestureStatus(engineIDWithGestureInfo2, 3);
            long uptimeMillis = android.os.SystemClock.uptimeMillis() - this.b;
            if (!com.amap.api.mapcore.util.n.this.o || uptimeMillis < 200) {
                return com.amap.api.mapcore.util.n.this.a.onDoubleTap(engineIDWithGestureInfo2, motionEvent);
            }
            com.amap.api.mapcore.util.n.this.o = false;
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final boolean onDown(android.view.MotionEvent motionEvent) {
            com.amap.api.mapcore.util.n.this.o = false;
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final boolean onFling(android.view.MotionEvent motionEvent, android.view.MotionEvent motionEvent2, float f, float f2) {
            com.amap.api.maps.model.AMapGestureListener aMapGestureListener = com.amap.api.mapcore.util.n.this.d;
            if (aMapGestureListener != null) {
                aMapGestureListener.onFling(f, f2);
            }
            try {
                if (com.amap.api.mapcore.util.n.this.a.getUiSettings().isScrollGesturesEnabled() && com.amap.api.mapcore.util.n.this.m <= 0 && com.amap.api.mapcore.util.n.this.k <= 0 && com.amap.api.mapcore.util.n.this.l == 0 && !com.amap.api.mapcore.util.n.this.q) {
                    com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.e;
                    eAMapPlatformGestureInfo.mGestureState = 3;
                    eAMapPlatformGestureInfo.mGestureType = 3;
                    eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent2.getX(), motionEvent2.getY()};
                    int engineIDWithGestureInfo = com.amap.api.mapcore.util.n.this.a.getEngineIDWithGestureInfo(this.e);
                    com.amap.api.mapcore.util.n.this.a.onFling();
                    com.amap.api.mapcore.util.n.this.a.getGLMapEngine().startMapSlidAnim(engineIDWithGestureInfo, new android.graphics.Point((int) motionEvent2.getX(), (int) motionEvent2.getY()), f, f2);
                }
                return true;
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.gd.c(th, "GLMapGestrureDetector", "onFling");
                th.printStackTrace();
                return true;
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final void onLongPress(android.view.MotionEvent motionEvent) {
            if (com.amap.api.mapcore.util.n.this.n == 1) {
                com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.e;
                eAMapPlatformGestureInfo.mGestureState = 3;
                eAMapPlatformGestureInfo.mGestureType = 7;
                eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                com.amap.api.mapcore.util.n.this.a.onLongPress(com.amap.api.mapcore.util.n.this.a.getEngineIDWithGestureInfo(this.e), motionEvent);
                com.amap.api.maps.model.AMapGestureListener aMapGestureListener = com.amap.api.mapcore.util.n.this.d;
                if (aMapGestureListener != null) {
                    aMapGestureListener.onLongPress(motionEvent.getX(), motionEvent.getY());
                }
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(android.view.MotionEvent motionEvent, android.view.MotionEvent motionEvent2, float f, float f2) {
            com.amap.api.maps.model.AMapGestureListener aMapGestureListener = com.amap.api.mapcore.util.n.this.d;
            if (aMapGestureListener == null) {
                return false;
            }
            aMapGestureListener.onScroll(f, f2);
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final void onShowPress(android.view.MotionEvent motionEvent) {
            try {
                com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.e;
                eAMapPlatformGestureInfo.mGestureState = 3;
                eAMapPlatformGestureInfo.mGestureType = 7;
                eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                com.amap.api.mapcore.util.n.this.a.getGLMapEngine().clearAnimations(com.amap.api.mapcore.util.n.this.a.getEngineIDWithGestureInfo(this.e), false);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(android.view.MotionEvent motionEvent) {
            if (com.amap.api.mapcore.util.n.this.n != 1) {
                return false;
            }
            com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.e;
            eAMapPlatformGestureInfo.mGestureState = 3;
            eAMapPlatformGestureInfo.mGestureType = 8;
            eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
            int engineIDWithGestureInfo = com.amap.api.mapcore.util.n.this.a.getEngineIDWithGestureInfo(this.e);
            com.amap.api.maps.model.AMapGestureListener aMapGestureListener = com.amap.api.mapcore.util.n.this.d;
            if (aMapGestureListener != null) {
                try {
                    aMapGestureListener.onSingleTap(motionEvent.getX(), motionEvent.getY());
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
            }
            return com.amap.api.mapcore.util.n.this.a.onSingleTapConfirmed(engineIDWithGestureInfo, motionEvent);
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(android.view.MotionEvent motionEvent) {
            return false;
        }
    }

    public class b implements com.amap.api.mapcore.util.ad.a {
        private com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo b;

        private b() {
            this.b = new com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo();
        }

        public /* synthetic */ b(com.amap.api.mapcore.util.n nVar, byte b) {
            this();
        }

        @Override // com.amap.api.mapcore.util.ad.a
        public final boolean a(com.amap.api.mapcore.util.ad adVar) {
            com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.b;
            eAMapPlatformGestureInfo.mGestureState = 2;
            eAMapPlatformGestureInfo.mGestureType = 6;
            boolean z = false;
            eAMapPlatformGestureInfo.mLocation = new float[]{adVar.c().getX(), adVar.c().getY()};
            try {
                if (!com.amap.api.mapcore.util.n.this.a.getUiSettings().isTiltGesturesEnabled()) {
                    return true;
                }
                int engineIDWithGestureInfo = com.amap.api.mapcore.util.n.this.a.getEngineIDWithGestureInfo(this.b);
                if (com.amap.api.mapcore.util.n.this.a.isLockMapCameraDegree(engineIDWithGestureInfo) || com.amap.api.mapcore.util.n.this.l > 3) {
                    return false;
                }
                float f = adVar.d().x;
                float f2 = adVar.d().y;
                if (!com.amap.api.mapcore.util.n.this.i) {
                    android.graphics.PointF a = adVar.a(0);
                    android.graphics.PointF a2 = adVar.a(1);
                    float f3 = a.y;
                    if ((f3 > 10.0f && a2.y > 10.0f) || (f3 < -10.0f && a2.y < -10.0f)) {
                        z = true;
                    }
                    if (z && java.lang.Math.abs(f2) > 10.0f && java.lang.Math.abs(f) < 10.0f) {
                        com.amap.api.mapcore.util.n.this.i = true;
                    }
                }
                if (com.amap.api.mapcore.util.n.this.i) {
                    com.amap.api.mapcore.util.n.this.i = true;
                    float f4 = f2 / 6.0f;
                    if (java.lang.Math.abs(f4) > 1.0f) {
                        com.amap.api.mapcore.util.n.this.a.addGestureMapMessage(engineIDWithGestureInfo, com.autonavi.base.amap.mapcore.message.HoverGestureMapMessage.obtain(101, f4));
                        com.amap.api.mapcore.util.n.m(com.amap.api.mapcore.util.n.this);
                    }
                }
                return true;
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.gd.c(th, "GLMapGestrureDetector", "onHove");
                th.printStackTrace();
                return true;
            }
        }

        @Override // com.amap.api.mapcore.util.ad.a
        public final boolean b(com.amap.api.mapcore.util.ad adVar) {
            com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.b;
            eAMapPlatformGestureInfo.mGestureState = 1;
            eAMapPlatformGestureInfo.mGestureType = 6;
            eAMapPlatformGestureInfo.mLocation = new float[]{adVar.c().getX(), adVar.c().getY()};
            try {
                if (!com.amap.api.mapcore.util.n.this.a.getUiSettings().isTiltGesturesEnabled()) {
                    return true;
                }
                int engineIDWithGestureInfo = com.amap.api.mapcore.util.n.this.a.getEngineIDWithGestureInfo(this.b);
                if (com.amap.api.mapcore.util.n.this.a.isLockMapCameraDegree(engineIDWithGestureInfo)) {
                    return false;
                }
                com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate = com.amap.api.mapcore.util.n.this.a;
                iAMapDelegate.addGestureMapMessage(engineIDWithGestureInfo, com.autonavi.base.amap.mapcore.message.HoverGestureMapMessage.obtain(100, iAMapDelegate.getCameraDegree(engineIDWithGestureInfo)));
                return true;
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.gd.c(th, "GLMapGestrureDetector", "onHoveBegin");
                th.printStackTrace();
                return true;
            }
        }

        @Override // com.amap.api.mapcore.util.ad.a
        public final void c(com.amap.api.mapcore.util.ad adVar) {
            com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.b;
            eAMapPlatformGestureInfo.mGestureState = 3;
            eAMapPlatformGestureInfo.mGestureType = 6;
            eAMapPlatformGestureInfo.mLocation = new float[]{adVar.c().getX(), adVar.c().getY()};
            try {
                if (com.amap.api.mapcore.util.n.this.a.getUiSettings().isTiltGesturesEnabled()) {
                    int engineIDWithGestureInfo = com.amap.api.mapcore.util.n.this.a.getEngineIDWithGestureInfo(this.b);
                    if (com.amap.api.mapcore.util.n.this.a.isLockMapCameraDegree(engineIDWithGestureInfo)) {
                        return;
                    }
                    if (com.amap.api.mapcore.util.n.this.a.getCameraDegree(engineIDWithGestureInfo) >= 0.0f && com.amap.api.mapcore.util.n.this.m > 0) {
                        com.amap.api.mapcore.util.n.this.a.setGestureStatus(engineIDWithGestureInfo, 7);
                    }
                    com.amap.api.mapcore.util.n.this.i = false;
                    com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate = com.amap.api.mapcore.util.n.this.a;
                    iAMapDelegate.addGestureMapMessage(engineIDWithGestureInfo, com.autonavi.base.amap.mapcore.message.HoverGestureMapMessage.obtain(102, iAMapDelegate.getCameraDegree(engineIDWithGestureInfo)));
                }
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.gd.c(th, "GLMapGestrureDetector", "onHoveEnd");
                th.printStackTrace();
            }
        }
    }

    public class c implements com.amap.api.mapcore.util.ae.a {
        private com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo b;

        private c() {
            this.b = new com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo();
        }

        public /* synthetic */ c(com.amap.api.mapcore.util.n nVar, byte b) {
            this();
        }

        @Override // com.amap.api.mapcore.util.ae.a
        public final boolean a(com.amap.api.mapcore.util.ae aeVar) {
            if (com.amap.api.mapcore.util.n.this.i) {
                return true;
            }
            try {
                if (com.amap.api.mapcore.util.n.this.a.getUiSettings().isScrollGesturesEnabled()) {
                    if (!com.amap.api.mapcore.util.n.this.p) {
                        com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.b;
                        eAMapPlatformGestureInfo.mGestureState = 2;
                        eAMapPlatformGestureInfo.mGestureType = 3;
                        eAMapPlatformGestureInfo.mLocation = new float[]{aeVar.c().getX(), aeVar.c().getY()};
                        int engineIDWithGestureInfo = com.amap.api.mapcore.util.n.this.a.getEngineIDWithGestureInfo(this.b);
                        android.graphics.PointF d = aeVar.d();
                        float f = com.amap.api.mapcore.util.n.this.j == 0 ? 4.0f : 1.0f;
                        if (java.lang.Math.abs(d.x) <= f && java.lang.Math.abs(d.y) <= f) {
                            return false;
                        }
                        if (com.amap.api.mapcore.util.n.this.j == 0) {
                            com.amap.api.mapcore.util.n.this.a.getGLMapEngine().clearAnimations(engineIDWithGestureInfo, false);
                        }
                        com.amap.api.mapcore.util.n.this.a.addGestureMapMessage(engineIDWithGestureInfo, com.autonavi.base.amap.mapcore.message.MoveGestureMapMessage.obtain(101, d.x, d.y, aeVar.c().getX(), aeVar.c().getY()));
                        com.amap.api.mapcore.util.n.l(com.amap.api.mapcore.util.n.this);
                    }
                }
                return true;
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.gd.c(th, "GLMapGestrureDetector", "onMove");
                th.printStackTrace();
                return true;
            }
        }

        @Override // com.amap.api.mapcore.util.ae.a
        public final boolean b(com.amap.api.mapcore.util.ae aeVar) {
            try {
                if (!com.amap.api.mapcore.util.n.this.a.getUiSettings().isScrollGesturesEnabled()) {
                    return true;
                }
                com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.b;
                eAMapPlatformGestureInfo.mGestureState = 1;
                eAMapPlatformGestureInfo.mGestureType = 3;
                eAMapPlatformGestureInfo.mLocation = new float[]{aeVar.c().getX(), aeVar.c().getY()};
                com.amap.api.mapcore.util.n.this.a.addGestureMapMessage(com.amap.api.mapcore.util.n.this.a.getEngineIDWithGestureInfo(this.b), com.autonavi.base.amap.mapcore.message.MoveGestureMapMessage.obtain(100, 0.0f, 0.0f, aeVar.c().getX(), aeVar.c().getY()));
                return true;
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.gd.c(th, "GLMapGestrureDetector", "onMoveBegin");
                th.printStackTrace();
                return true;
            }
        }

        @Override // com.amap.api.mapcore.util.ae.a
        public final void c(com.amap.api.mapcore.util.ae aeVar) {
            try {
                if (com.amap.api.mapcore.util.n.this.a.getUiSettings().isScrollGesturesEnabled()) {
                    com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.b;
                    eAMapPlatformGestureInfo.mGestureState = 3;
                    eAMapPlatformGestureInfo.mGestureType = 3;
                    eAMapPlatformGestureInfo.mLocation = new float[]{aeVar.c().getX(), aeVar.c().getY()};
                    int engineIDWithGestureInfo = com.amap.api.mapcore.util.n.this.a.getEngineIDWithGestureInfo(this.b);
                    if (com.amap.api.mapcore.util.n.this.j > 0) {
                        com.amap.api.mapcore.util.n.this.a.setGestureStatus(engineIDWithGestureInfo, 5);
                    }
                    com.amap.api.mapcore.util.n.this.a.addGestureMapMessage(engineIDWithGestureInfo, com.autonavi.base.amap.mapcore.message.MoveGestureMapMessage.obtain(102, 0.0f, 0.0f, aeVar.c().getX(), aeVar.c().getY()));
                }
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.gd.c(th, "GLMapGestrureDetector", "onMoveEnd");
                th.printStackTrace();
            }
        }
    }

    public class d extends com.amap.api.mapcore.util.ag.a {
        private boolean b;
        private boolean c;
        private boolean d;
        private android.graphics.Point e;
        private float[] f;
        private float g;
        private float[] h;
        private float i;
        private com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo j;

        private d() {
            this.b = false;
            this.c = false;
            this.d = false;
            this.e = new android.graphics.Point();
            this.f = new float[10];
            this.g = 0.0f;
            this.h = new float[10];
            this.i = 0.0f;
            this.j = new com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo();
        }

        public /* synthetic */ d(com.amap.api.mapcore.util.n nVar, byte b) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x00f3 A[Catch: all -> 0x0106, TryCatch #0 {all -> 0x0106, blocks: (B:28:0x00cb, B:30:0x00f3, B:70:0x00fc, B:74:0x00b6), top: B:73:0x00b6 }] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0124 A[Catch: all -> 0x019c, TryCatch #2 {all -> 0x019c, blocks: (B:32:0x0116, B:34:0x0124, B:36:0x012e, B:38:0x0132, B:40:0x013c, B:42:0x0144, B:43:0x0146, B:45:0x014a, B:53:0x016b, B:63:0x015c), top: B:31:0x0116 }] */
        /* JADX WARN: Removed duplicated region for block: B:53:0x016b A[Catch: all -> 0x019c, TRY_LEAVE, TryCatch #2 {all -> 0x019c, blocks: (B:32:0x0116, B:34:0x0124, B:36:0x012e, B:38:0x0132, B:40:0x013c, B:42:0x0144, B:43:0x0146, B:45:0x014a, B:53:0x016b, B:63:0x015c), top: B:31:0x0116 }] */
        /* JADX WARN: Removed duplicated region for block: B:70:0x00fc A[Catch: all -> 0x0106, TRY_LEAVE, TryCatch #0 {all -> 0x0106, blocks: (B:28:0x00cb, B:30:0x00f3, B:70:0x00fc, B:74:0x00b6), top: B:73:0x00b6 }] */
        @Override // com.amap.api.mapcore.util.ag.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean a(com.amap.api.mapcore.util.ag agVar) {
            java.lang.Throwable th;
            boolean z;
            boolean z2;
            float j;
            boolean z3;
            com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.j;
            eAMapPlatformGestureInfo.mGestureState = 2;
            eAMapPlatformGestureInfo.mGestureType = 4;
            boolean z4 = true;
            eAMapPlatformGestureInfo.mLocation = new float[]{agVar.a().getX(), agVar.a().getY()};
            int engineIDWithGestureInfo = com.amap.api.mapcore.util.n.this.a.getEngineIDWithGestureInfo(this.j);
            float h = agVar.h();
            float i = agVar.i();
            int b = (int) agVar.b();
            int c = (int) agVar.c();
            float abs = java.lang.Math.abs(b - this.e.x);
            float abs2 = java.lang.Math.abs(c - this.e.y);
            android.graphics.Point point = this.e;
            point.x = b;
            point.y = c;
            float log = (float) java.lang.Math.log(h);
            if (com.amap.api.mapcore.util.n.this.k <= 0 && java.lang.Math.abs(log) > 0.2f) {
                this.d = true;
            }
            try {
            } catch (java.lang.Throwable th2) {
                th = th2;
                z = false;
            }
            try {
                if (com.amap.api.mapcore.util.n.this.a.getUiSettings().isZoomGesturesEnabled()) {
                    if (!this.b && 0.06f < java.lang.Math.abs(log)) {
                        this.b = true;
                    }
                    if (this.b) {
                        if (0.01f < java.lang.Math.abs(log)) {
                            if (abs > 2.0f || abs2 > 2.0f) {
                                try {
                                } catch (java.lang.Throwable th3) {
                                    th = th3;
                                    z = true;
                                    com.amap.api.mapcore.util.gd.c(th, "GLMapGestrureDetector", "onScaleRotate");
                                    th.printStackTrace();
                                    z2 = z;
                                    if (com.amap.api.mapcore.util.n.this.a.getUiSettings().isRotateGesturesEnabled()) {
                                    }
                                    return z2;
                                }
                                if (java.lang.Math.abs(log) < 0.02f) {
                                    z3 = true;
                                    if (!z3 && i > 0.0f) {
                                        float f = log / i;
                                        this.g = f;
                                        this.f[com.amap.api.mapcore.util.n.this.k % 10] = java.lang.Math.abs(f);
                                        com.amap.api.mapcore.util.n.g(com.amap.api.mapcore.util.n.this);
                                        com.amap.api.mapcore.util.n.this.a.addGestureMapMessage(engineIDWithGestureInfo, com.autonavi.base.amap.mapcore.message.ScaleGestureMapMessage.obtain(101, log, b, c));
                                        if (log <= 0.0f) {
                                            com.amap.api.mapcore.util.n.this.a.setGestureStatus(engineIDWithGestureInfo, 1);
                                            z2 = true;
                                            if (com.amap.api.mapcore.util.n.this.a.getUiSettings().isRotateGesturesEnabled() && !com.amap.api.mapcore.util.n.this.a.isLockMapAngle(engineIDWithGestureInfo) && !this.d) {
                                                j = agVar.j();
                                                if (!this.c && java.lang.Math.abs(j) >= 4.0f) {
                                                    this.c = true;
                                                }
                                                if (this.c && 1.0f < java.lang.Math.abs(j)) {
                                                    if (!((abs <= 4.0f || abs2 > 4.0f) && java.lang.Math.abs(j) < 2.0f)) {
                                                        float f2 = j / i;
                                                        this.i = f2;
                                                        this.h[com.amap.api.mapcore.util.n.this.l % 10] = java.lang.Math.abs(f2);
                                                        com.amap.api.mapcore.util.n.h(com.amap.api.mapcore.util.n.this);
                                                        com.amap.api.mapcore.util.n.this.a.addGestureMapMessage(engineIDWithGestureInfo, com.autonavi.base.amap.mapcore.message.RotateGestureMapMessage.obtain(101, j, b, c));
                                                        try {
                                                            com.amap.api.mapcore.util.n.this.a.setGestureStatus(engineIDWithGestureInfo, 6);
                                                            return true;
                                                        } catch (java.lang.Throwable th4) {
                                                            th = th4;
                                                            com.amap.api.mapcore.util.gd.c(th, "GLMapGestrureDetector", "onScaleRotate");
                                                            th.printStackTrace();
                                                            return z4;
                                                        }
                                                    }
                                                }
                                            }
                                            return z2;
                                        }
                                        com.amap.api.mapcore.util.n.this.a.setGestureStatus(engineIDWithGestureInfo, 2);
                                    }
                                    z = true;
                                    z2 = z;
                                    if (com.amap.api.mapcore.util.n.this.a.getUiSettings().isRotateGesturesEnabled()) {
                                        j = agVar.j();
                                        if (!this.c) {
                                            this.c = true;
                                        }
                                        if (this.c) {
                                            if (!((abs <= 4.0f || abs2 > 4.0f) && java.lang.Math.abs(j) < 2.0f)) {
                                            }
                                        }
                                    }
                                    return z2;
                                }
                            }
                            z3 = false;
                            if (!z3) {
                                float f3 = log / i;
                                this.g = f3;
                                this.f[com.amap.api.mapcore.util.n.this.k % 10] = java.lang.Math.abs(f3);
                                com.amap.api.mapcore.util.n.g(com.amap.api.mapcore.util.n.this);
                                com.amap.api.mapcore.util.n.this.a.addGestureMapMessage(engineIDWithGestureInfo, com.autonavi.base.amap.mapcore.message.ScaleGestureMapMessage.obtain(101, log, b, c));
                                if (log <= 0.0f) {
                                }
                            }
                            z = true;
                            z2 = z;
                            if (com.amap.api.mapcore.util.n.this.a.getUiSettings().isRotateGesturesEnabled()) {
                            }
                            return z2;
                        }
                    }
                }
                if (com.amap.api.mapcore.util.n.this.a.getUiSettings().isRotateGesturesEnabled()) {
                }
                return z2;
            } catch (java.lang.Throwable th5) {
                th = th5;
                z4 = z2;
            }
            z = false;
            z2 = z;
        }

        @Override // com.amap.api.mapcore.util.ag.a
        public final boolean b(com.amap.api.mapcore.util.ag agVar) {
            com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.j;
            eAMapPlatformGestureInfo.mGestureState = 1;
            eAMapPlatformGestureInfo.mGestureType = 4;
            eAMapPlatformGestureInfo.mLocation = new float[]{agVar.a().getX(), agVar.a().getY()};
            int engineIDWithGestureInfo = com.amap.api.mapcore.util.n.this.a.getEngineIDWithGestureInfo(this.j);
            int b = (int) agVar.b();
            int c = (int) agVar.c();
            this.d = false;
            android.graphics.Point point = this.e;
            point.x = b;
            point.y = c;
            this.b = false;
            this.c = false;
            com.amap.api.mapcore.util.n.this.a.addGestureMapMessage(engineIDWithGestureInfo, com.autonavi.base.amap.mapcore.message.ScaleGestureMapMessage.obtain(100, 1.0f, b, c));
            try {
                if (com.amap.api.mapcore.util.n.this.a.getUiSettings().isRotateGesturesEnabled() && !com.amap.api.mapcore.util.n.this.a.isLockMapAngle(engineIDWithGestureInfo)) {
                    com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate = com.amap.api.mapcore.util.n.this.a;
                    iAMapDelegate.addGestureMapMessage(engineIDWithGestureInfo, com.autonavi.base.amap.mapcore.message.RotateGestureMapMessage.obtain(100, iAMapDelegate.getMapAngle(engineIDWithGestureInfo), b, c));
                }
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.gd.c(th, "GLMapGestrureDetector", "onScaleRotateBegin");
                th.printStackTrace();
            }
            return true;
        }

        @Override // com.amap.api.mapcore.util.ag.a
        public final void c(com.amap.api.mapcore.util.ag agVar) {
            float f;
            float f2;
            float f3;
            com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.j;
            eAMapPlatformGestureInfo.mGestureState = 3;
            eAMapPlatformGestureInfo.mGestureType = 4;
            eAMapPlatformGestureInfo.mLocation = new float[]{agVar.a().getX(), agVar.a().getY()};
            int engineIDWithGestureInfo = com.amap.api.mapcore.util.n.this.a.getEngineIDWithGestureInfo(this.j);
            this.d = false;
            com.amap.api.mapcore.util.n.this.a.addGestureMapMessage(engineIDWithGestureInfo, com.autonavi.base.amap.mapcore.message.ScaleGestureMapMessage.obtain(102, 1.0f, 0, 0));
            if (com.amap.api.mapcore.util.n.this.k > 0) {
                int i = com.amap.api.mapcore.util.n.this.k > 10 ? 10 : com.amap.api.mapcore.util.n.this.k;
                float f4 = 0.0f;
                for (int i2 = 0; i2 < 10; i2++) {
                    float[] fArr = this.f;
                    f4 += fArr[i2];
                    fArr[i2] = 0.0f;
                }
                float f5 = f4 / i;
                if (0.004f <= f5) {
                    float f6 = f5 * 300.0f;
                    if (f6 >= 1.5f) {
                        f6 = 1.5f;
                    }
                    if (this.g < 0.0f) {
                        f6 = -f6;
                    }
                    f3 = com.amap.api.mapcore.util.n.this.a.getPreciseLevel(engineIDWithGestureInfo) + f6;
                } else {
                    f3 = -9999.0f;
                }
                this.g = 0.0f;
                f = f3;
            } else {
                f = -9999.0f;
            }
            if (com.amap.api.mapcore.util.n.this.a.isLockMapAngle(engineIDWithGestureInfo)) {
                f2 = -9999.0f;
            } else {
                try {
                    if (com.amap.api.mapcore.util.n.this.a.getUiSettings().isRotateGesturesEnabled()) {
                        com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate = com.amap.api.mapcore.util.n.this.a;
                        iAMapDelegate.addGestureMapMessage(engineIDWithGestureInfo, com.autonavi.base.amap.mapcore.message.RotateGestureMapMessage.obtain(102, iAMapDelegate.getMapAngle(engineIDWithGestureInfo), 0, 0));
                    }
                } catch (java.lang.Throwable th) {
                    com.amap.api.mapcore.util.gd.c(th, "GLMapGestrureDetector", "onScaleRotateEnd");
                    th.printStackTrace();
                }
                if (com.amap.api.mapcore.util.n.this.l > 0) {
                    com.amap.api.mapcore.util.n.this.a.setGestureStatus(engineIDWithGestureInfo, 6);
                    int i3 = com.amap.api.mapcore.util.n.this.l > 10 ? 10 : com.amap.api.mapcore.util.n.this.l;
                    float f7 = 0.0f;
                    for (int i4 = 0; i4 < 10; i4++) {
                        float[] fArr2 = this.h;
                        f7 += fArr2[i4];
                        fArr2[i4] = 0.0f;
                    }
                    float f8 = f7 / i3;
                    if (0.1f <= f8) {
                        float f9 = f8 * 200.0f;
                        int mapAngle = ((int) com.amap.api.mapcore.util.n.this.a.getMapAngle(engineIDWithGestureInfo)) % com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE;
                        if (f9 >= 60.0f) {
                            f9 = 60.0f;
                        }
                        if (this.i < 0.0f) {
                            f9 = -f9;
                        }
                        f2 = ((int) (mapAngle + f9)) % com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE;
                        this.g = 0.0f;
                    }
                }
                f2 = -9999.0f;
                this.g = 0.0f;
            }
            if ((f == -9999.0f && f2 == -9999.0f) ? false : true) {
                com.amap.api.mapcore.util.n.this.a.getGLMapEngine().startPivotZoomRotateAnim(engineIDWithGestureInfo, this.e, f, (int) f2, 500);
            }
        }
    }

    public class e extends com.amap.api.mapcore.util.ah.b {
        com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo a;

        private e() {
            this.a = new com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo();
        }

        public /* synthetic */ e(com.amap.api.mapcore.util.n nVar, byte b) {
            this();
        }

        @Override // com.amap.api.mapcore.util.ah.b, com.amap.api.mapcore.util.ah.a
        public final void a(com.amap.api.mapcore.util.ah ahVar) {
            try {
                if (com.amap.api.mapcore.util.n.this.a.getUiSettings().isZoomGesturesEnabled() && java.lang.Math.abs(ahVar.d()) <= 10.0f && java.lang.Math.abs(ahVar.e()) <= 10.0f && ahVar.b() < 200) {
                    com.amap.api.mapcore.util.n.n(com.amap.api.mapcore.util.n.this);
                    com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.a;
                    eAMapPlatformGestureInfo.mGestureState = 2;
                    eAMapPlatformGestureInfo.mGestureType = 2;
                    eAMapPlatformGestureInfo.mLocation = new float[]{ahVar.c().getX(), ahVar.c().getY()};
                    int engineIDWithGestureInfo = com.amap.api.mapcore.util.n.this.a.getEngineIDWithGestureInfo(this.a);
                    com.amap.api.mapcore.util.n.this.a.setGestureStatus(engineIDWithGestureInfo, 4);
                    com.amap.api.mapcore.util.n.this.a.zoomOut(engineIDWithGestureInfo);
                }
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.gd.c(th, "GLMapGestrureDetector", "onZoomOut");
                th.printStackTrace();
            }
        }
    }

    public n(com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate) {
        this.b = iAMapDelegate.getContext();
        this.a = iAMapDelegate;
        com.amap.api.mapcore.util.n.a aVar = new com.amap.api.mapcore.util.n.a(this, (byte) 0);
        android.view.GestureDetector gestureDetector = new android.view.GestureDetector(this.b, aVar, this.t);
        this.c = gestureDetector;
        gestureDetector.setOnDoubleTapListener(aVar);
        this.e = new com.amap.api.mapcore.util.ag(this.b, new com.amap.api.mapcore.util.n.d(this, (byte) 0));
        this.f = new com.amap.api.mapcore.util.ae(this.b, new com.amap.api.mapcore.util.n.c(this, (byte) 0));
        this.g = new com.amap.api.mapcore.util.ad(this.b, new com.amap.api.mapcore.util.n.b(this, (byte) 0));
        this.h = new com.amap.api.mapcore.util.ah(this.b, new com.amap.api.mapcore.util.n.e(this, (byte) 0));
    }

    public static /* synthetic */ int g(com.amap.api.mapcore.util.n nVar) {
        int i = nVar.k;
        nVar.k = i + 1;
        return i;
    }

    public static /* synthetic */ int h(com.amap.api.mapcore.util.n nVar) {
        int i = nVar.l;
        nVar.l = i + 1;
        return i;
    }

    public static /* synthetic */ int l(com.amap.api.mapcore.util.n nVar) {
        int i = nVar.j;
        nVar.j = i + 1;
        return i;
    }

    public static /* synthetic */ int m(com.amap.api.mapcore.util.n nVar) {
        int i = nVar.m;
        nVar.m = i + 1;
        return i;
    }

    public static /* synthetic */ boolean n(com.amap.api.mapcore.util.n nVar) {
        nVar.q = true;
        return true;
    }

    public final void a() {
        this.j = 0;
        this.l = 0;
        this.k = 0;
        this.m = 0;
        this.n = 0;
    }

    public final void a(int i, int i2) {
        this.r = i;
        this.f139s = i2;
        com.amap.api.mapcore.util.ag agVar = this.e;
        if (agVar != null) {
            agVar.a(i, i2);
        }
        com.amap.api.mapcore.util.ae aeVar = this.f;
        if (aeVar != null) {
            aeVar.a(i, i2);
        }
        com.amap.api.mapcore.util.ad adVar = this.g;
        if (adVar != null) {
            adVar.a(i, i2);
        }
        com.amap.api.mapcore.util.ah ahVar = this.h;
        if (ahVar != null) {
            ahVar.a(i, i2);
        }
    }

    public final void a(com.amap.api.maps.model.AMapGestureListener aMapGestureListener) {
        this.d = aMapGestureListener;
    }

    public final boolean a(android.view.MotionEvent motionEvent) {
        if (this.n < motionEvent.getPointerCount()) {
            this.n = motionEvent.getPointerCount();
        }
        if ((motionEvent.getAction() & 255) == 0) {
            this.p = false;
            this.q = false;
        }
        if (motionEvent.getAction() == 6 && motionEvent.getPointerCount() > 0) {
            this.p = true;
        }
        if (this.o && this.n >= 2) {
            this.o = false;
        }
        try {
            int[] iArr = {0, 0};
            com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate = this.a;
            if (iAMapDelegate != null && iAMapDelegate.getGLMapView() != null) {
                this.a.getGLMapView().getLocationOnScreen(iArr);
            }
            if (this.d != null) {
                if (motionEvent.getAction() == 0) {
                    this.d.onDown(motionEvent.getX(), motionEvent.getY());
                } else if (motionEvent.getAction() == 1) {
                    this.d.onUp(motionEvent.getX(), motionEvent.getY());
                }
            }
            this.c.onTouchEvent(motionEvent);
            this.g.b(motionEvent, iArr[0], iArr[1]);
            if (!this.i || this.m <= 0) {
                this.h.b(motionEvent, iArr[0], iArr[1]);
                if (!this.o) {
                    this.e.a(motionEvent);
                    this.f.b(motionEvent, iArr[0], iArr[1]);
                }
            }
            return true;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final int b() {
        return this.r;
    }

    public final int c() {
        return this.f139s;
    }
}
