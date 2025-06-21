package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class d extends android.opengl.GLSurfaceView implements com.autonavi.base.amap.api.mapcore.IGLSurfaceView {
    protected boolean a;
    private com.autonavi.base.amap.api.mapcore.IAMapDelegate b;
    private com.autonavi.base.ae.gmap.GLMapRender c;

    /* renamed from: com.amap.api.mapcore.util.d$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.amap.api.mapcore.util.d.this.c != null) {
                try {
                    com.amap.api.mapcore.util.d.this.c.onSurfaceDestory();
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                    com.amap.api.mapcore.util.dl.a(th);
                }
            }
        }
    }

    public d(android.content.Context context, boolean z) {
        this(context, z, (byte) 0);
    }

    private d(android.content.Context context, boolean z, byte b) {
        super(context, null);
        this.b = null;
        this.c = null;
        this.a = false;
        com.amap.api.mapcore.util.cx.a(this);
        this.b = new com.amap.api.mapcore.util.b(this, context, z);
    }

    public final com.autonavi.base.amap.api.mapcore.IAMapDelegate a() {
        return this.b;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.amap.api.mapcore.util.dn.a(com.amap.api.mapcore.util.dm.c, "AMapGLSurfaceView onAttachedToWindow");
        try {
            com.autonavi.base.ae.gmap.GLMapRender gLMapRender = this.c;
            if (gLMapRender != null) {
                gLMapRender.onAttachedToWindow();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            com.amap.api.mapcore.util.dl.a(th);
        }
        onResume();
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public final void onDetachedFromWindow() {
        com.amap.api.mapcore.util.dn.a(com.amap.api.mapcore.util.dm.c, "AMapGLSurfaceView onDetachedFromWindow MapsInitializer.isSupportRecycleView() " + com.amap.api.maps.MapsInitializer.isSupportRecycleView());
        if (com.amap.api.maps.MapsInitializer.isSupportRecycleView()) {
            return;
        }
        onPause();
        try {
            com.autonavi.base.ae.gmap.GLMapRender gLMapRender = this.c;
            if (gLMapRender != null) {
                gLMapRender.onDetachedFromWindow();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        super.onDetachedFromWindow();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void onDetachedGLThread() {
        com.amap.api.mapcore.util.dn.a(com.amap.api.mapcore.util.dm.c, "AMapGLSurfaceView onDetachedGLThread MapsInitializer.isSupportRecycleView() " + com.amap.api.maps.MapsInitializer.isSupportRecycleView());
        if (com.amap.api.maps.MapsInitializer.isSupportRecycleView()) {
            onPause();
            try {
                com.autonavi.base.ae.gmap.GLMapRender gLMapRender = this.c;
                if (gLMapRender != null) {
                    gLMapRender.onDetachedFromWindow();
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                com.amap.api.mapcore.util.dl.a(th);
            }
            super.onDetachedFromWindow();
        }
    }

    @Override // android.opengl.GLSurfaceView
    public final void onPause() {
        com.amap.api.mapcore.util.dn.a(com.amap.api.mapcore.util.dm.c, "AMapGLSurfaceView onPause mMapRender.mSurfacedestoryed " + this.c.mSurfacedestoryed);
        if (!this.c.mSurfacedestoryed) {
            queueEvent(new com.amap.api.mapcore.util.d.AnonymousClass1());
            int i = 0;
            while (!this.c.mSurfacedestoryed) {
                int i2 = i + 1;
                if (i >= 50) {
                    break;
                }
                try {
                    java.lang.Thread.sleep(20L);
                } catch (java.lang.InterruptedException unused) {
                }
                i = i2;
            }
        }
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public final void onResume() {
        super.onResume();
        com.amap.api.mapcore.util.dn.a(com.amap.api.mapcore.util.dm.c, "AMapGLSurfaceView onPause");
    }

    @Override // android.view.View
    public final boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        try {
            return this.b.onTouchEvent(motionEvent);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        com.amap.api.mapcore.util.dn.a(com.amap.api.mapcore.util.dm.c, "AMapGLSurfaceView onWindowVisibilityChanged visibility ".concat(java.lang.String.valueOf(i)));
        try {
            if (i == 8 || i == 4) {
                com.autonavi.base.ae.gmap.GLMapRender gLMapRender = this.c;
                if (gLMapRender != null) {
                    gLMapRender.renderPause();
                    this.a = false;
                }
            } else {
                if (i != 0) {
                    return;
                }
                com.autonavi.base.ae.gmap.GLMapRender gLMapRender2 = this.c;
                if (gLMapRender2 != null) {
                    gLMapRender2.renderResume();
                }
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            com.amap.api.mapcore.util.dl.a(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setEGLConfigChooser(com.amap.api.mapcore.util.cv cvVar) {
        super.setEGLConfigChooser((android.opengl.GLSurfaceView.EGLConfigChooser) cvVar);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setEGLContextFactory(com.amap.api.mapcore.util.cw cwVar) {
        super.setEGLContextFactory((android.opengl.GLSurfaceView.EGLContextFactory) cwVar);
    }

    @Override // android.opengl.GLSurfaceView, com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setRenderer(android.opengl.GLSurfaceView.Renderer renderer) {
        this.c = (com.autonavi.base.ae.gmap.GLMapRender) renderer;
        super.setRenderer(renderer);
    }
}
