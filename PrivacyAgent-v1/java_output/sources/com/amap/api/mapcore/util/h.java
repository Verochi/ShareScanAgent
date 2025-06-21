package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class h extends java.lang.Thread {
    private static int c = 0;
    private static int d = 3;
    private static long e = 30000;
    private static boolean g;
    private java.lang.ref.WeakReference<android.content.Context> a;
    private com.autonavi.base.amap.api.mapcore.IAMapDelegate b;
    private com.amap.api.mapcore.util.h.a f = null;
    private android.os.Handler h = new com.amap.api.mapcore.util.h.AnonymousClass1(android.os.Looper.getMainLooper());

    /* renamed from: com.amap.api.mapcore.util.h$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.Handler {
        public AnonymousClass1(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(android.os.Message message) {
            super.handleMessage(message);
            if (com.amap.api.mapcore.util.h.g) {
                return;
            }
            if (com.amap.api.mapcore.util.h.this.f == null) {
                com.amap.api.mapcore.util.h hVar = com.amap.api.mapcore.util.h.this;
                hVar.f = new com.amap.api.mapcore.util.h.a(hVar.b, com.amap.api.mapcore.util.h.this.a == null ? null : (android.content.Context) com.amap.api.mapcore.util.h.this.a.get());
            }
            com.amap.api.mapcore.util.dj.a().a(com.amap.api.mapcore.util.h.this.f);
        }
    }

    public static class a extends com.amap.api.mapcore.util.ij {
        private java.lang.ref.WeakReference<com.autonavi.base.amap.api.mapcore.IAMapDelegate> a;
        private java.lang.ref.WeakReference<android.content.Context> b;
        private com.amap.api.mapcore.util.i c;

        /* renamed from: com.amap.api.mapcore.util.h$a$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ com.autonavi.base.amap.api.mapcore.IAMapDelegate a;

            public AnonymousClass1(com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate) {
                this.a = iAMapDelegate;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate = this.a;
                if (iAMapDelegate == null || iAMapDelegate.getMapConfig() == null) {
                    return;
                }
                com.autonavi.base.amap.mapcore.MapConfig mapConfig = this.a.getMapConfig();
                mapConfig.setProFunctionAuthEnable(false);
                if (mapConfig.isUseProFunction()) {
                    this.a.setMapCustomEnable(mapConfig.isCustomStyleEnable(), true);
                    this.a.reloadMapCustomStyle();
                    com.amap.api.mapcore.util.cr.a(com.amap.api.mapcore.util.h.a.this.b == null ? null : (android.content.Context) com.amap.api.mapcore.util.h.a.this.b.get(), "鉴权失败，当前key没有自定义纹理的使用权限，自定义纹理相关内容，将不会呈现！");
                }
            }
        }

        public a(com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate, android.content.Context context) {
            this.a = null;
            this.b = null;
            this.a = new java.lang.ref.WeakReference<>(iAMapDelegate);
            if (context != null) {
                this.b = new java.lang.ref.WeakReference<>(context);
            }
        }

        private void a() {
            com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate;
            java.lang.ref.WeakReference<com.autonavi.base.amap.api.mapcore.IAMapDelegate> weakReference = this.a;
            if (weakReference == null || weakReference.get() == null || (iAMapDelegate = this.a.get()) == null || iAMapDelegate.getMapConfig() == null) {
                return;
            }
            iAMapDelegate.queueEvent(new com.amap.api.mapcore.util.h.a.AnonymousClass1(iAMapDelegate));
        }

        @Override // com.amap.api.mapcore.util.ij
        public final void runTask() {
            com.amap.api.mapcore.util.i.a d;
            java.lang.ref.WeakReference<android.content.Context> weakReference;
            try {
                if (com.amap.api.mapcore.util.h.g) {
                    return;
                }
                if (this.c == null && (weakReference = this.b) != null && weakReference.get() != null) {
                    this.c = new com.amap.api.mapcore.util.i(this.b.get(), "");
                }
                com.amap.api.mapcore.util.h.b();
                if (com.amap.api.mapcore.util.h.c > com.amap.api.mapcore.util.h.d) {
                    com.amap.api.mapcore.util.h.e();
                    a();
                    return;
                }
                com.amap.api.mapcore.util.i iVar = this.c;
                if (iVar == null || (d = iVar.d()) == null) {
                    return;
                }
                if (!d.d) {
                    a();
                }
                com.amap.api.mapcore.util.h.e();
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.gd.c(th, "authForPro", "loadConfigData_uploadException");
                com.amap.api.mapcore.util.dn.b(com.amap.api.mapcore.util.dm.e, "auth exception get data " + th.getMessage());
            }
        }
    }

    public h(android.content.Context context, com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate) {
        this.a = null;
        if (context != null) {
            this.a = new java.lang.ref.WeakReference<>(context);
        }
        this.b = iAMapDelegate;
        f();
    }

    public static /* synthetic */ int b() {
        int i = c;
        c = i + 1;
        return i;
    }

    public static /* synthetic */ boolean e() {
        g = true;
        return true;
    }

    private static void f() {
        c = 0;
        g = false;
    }

    private void g() {
        if (g) {
            return;
        }
        int i = 0;
        while (i <= d) {
            i++;
            this.h.sendEmptyMessageDelayed(0, i * e);
        }
    }

    @Override // java.lang.Thread
    public final void interrupt() {
        this.b = null;
        this.a = null;
        android.os.Handler handler = this.h;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.h = null;
        this.f = null;
        f();
        super.interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            g();
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "AMapDelegateImpGLSurfaceView", "mVerfy");
            th.printStackTrace();
            com.amap.api.mapcore.util.dn.b(com.amap.api.mapcore.util.dm.e, "auth pro exception " + th.getMessage());
        }
    }
}
