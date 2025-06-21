package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class e extends com.amap.api.mapcore.util.m implements com.autonavi.base.amap.api.mapcore.IGLSurfaceView {
    protected boolean a;
    private com.autonavi.base.amap.api.mapcore.IAMapDelegate b;
    private com.autonavi.base.ae.gmap.GLMapRender c;

    /* renamed from: com.amap.api.mapcore.util.e$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (com.amap.api.mapcore.util.e.this.c != null) {
                    com.amap.api.mapcore.util.e.this.c.onSurfaceDestory();
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                com.amap.api.mapcore.util.dl.a(th);
            }
        }
    }

    public e(android.content.Context context, boolean z) {
        super(context);
        this.b = null;
        this.c = null;
        this.a = false;
        com.amap.api.mapcore.util.cx.a(this);
        this.b = new com.amap.api.mapcore.util.b(this, context, z);
    }

    public final com.autonavi.base.amap.api.mapcore.IAMapDelegate a() {
        return this.b;
    }

    @Override // com.amap.api.mapcore.util.m
    public final void b() {
        com.amap.api.mapcore.util.dn.a(com.amap.api.mapcore.util.dm.c, "AMapGLTextureView onPause mMapRender.mSurfacedestoryed " + this.c.mSurfacedestoryed);
        if (!this.c.mSurfacedestoryed) {
            queueEvent(new com.amap.api.mapcore.util.e.AnonymousClass1());
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
        super.b();
    }

    @Override // com.amap.api.mapcore.util.m
    public final void c() {
        super.c();
        com.amap.api.mapcore.util.dn.a(com.amap.api.mapcore.util.dm.c, "AMapGLTextureView onResume");
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final android.view.SurfaceHolder getHolder() {
        return null;
    }

    @Override // com.amap.api.mapcore.util.m, android.view.TextureView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.amap.api.mapcore.util.dn.a(com.amap.api.mapcore.util.dm.c, "AMapGLTextureView onAttachedToWindow");
        try {
            com.autonavi.base.ae.gmap.GLMapRender gLMapRender = this.c;
            if (gLMapRender != null) {
                gLMapRender.onAttachedToWindow();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        c();
    }

    @Override // com.amap.api.mapcore.util.m, android.view.View
    public final void onDetachedFromWindow() {
        com.amap.api.mapcore.util.dn.a(com.amap.api.mapcore.util.dm.c, "AMapGLTextureView onDetachedFromWindow MapsInitializer.isSupportRecycleView() " + com.amap.api.maps.MapsInitializer.isSupportRecycleView());
        if (com.amap.api.maps.MapsInitializer.isSupportRecycleView()) {
            return;
        }
        b();
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
        com.amap.api.mapcore.util.dn.a(com.amap.api.mapcore.util.dm.c, "AMapGLTextureView onDetachedGLThread MapsInitializer.isSupportRecycleView() " + com.amap.api.maps.MapsInitializer.isSupportRecycleView());
        if (com.amap.api.maps.MapsInitializer.isSupportRecycleView()) {
            b();
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
    }

    @Override // com.amap.api.mapcore.util.m, android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(android.graphics.SurfaceTexture surfaceTexture) {
        com.amap.api.mapcore.util.dn.a(com.amap.api.mapcore.util.dm.c, "AMapGLTextureView onSurfaceTextureDestroyed");
        requestRender();
        try {
            if (com.amap.api.maps.MapsInitializer.getTextureDestroyRender()) {
                java.lang.Thread.sleep(100L);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            com.amap.api.mapcore.util.dl.a(th);
        }
        return super.onSurfaceTextureDestroyed(surfaceTexture);
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

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        com.autonavi.base.ae.gmap.GLMapRender gLMapRender;
        super.onWindowVisibilityChanged(i);
        com.amap.api.mapcore.util.dn.a(com.amap.api.mapcore.util.dm.c, "AMapGLTextureView onWindowVisibilityChanged visibility ".concat(java.lang.String.valueOf(i)));
        try {
            if (i != 8 && i != 4) {
                if (i != 0 || (gLMapRender = this.c) == null) {
                    return;
                }
                gLMapRender.renderResume();
                return;
            }
            com.autonavi.base.ae.gmap.GLMapRender gLMapRender2 = this.c;
            if (gLMapRender2 != null) {
                gLMapRender2.renderPause();
                this.a = false;
            }
            requestRender();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            com.amap.api.mapcore.util.dl.a(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setEGLConfigChooser(com.amap.api.mapcore.util.cv cvVar) {
        super.a(cvVar);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setEGLContextFactory(com.amap.api.mapcore.util.cw cwVar) {
        super.a(cwVar);
    }

    @Override // com.amap.api.mapcore.util.m, com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setRenderer(android.opengl.GLSurfaceView.Renderer renderer) {
        this.c = (com.autonavi.base.ae.gmap.GLMapRender) renderer;
        super.setRenderer(renderer);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IGLSurfaceView
    public final void setZOrderOnTop(boolean z) {
    }
}
