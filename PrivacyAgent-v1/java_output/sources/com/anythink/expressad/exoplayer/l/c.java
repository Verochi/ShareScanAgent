package com.anythink.expressad.exoplayer.l;

@android.annotation.TargetApi(17)
/* loaded from: classes12.dex */
public final class c extends android.view.Surface {
    private static final java.lang.String b = "DummySurface";
    private static final java.lang.String c = "EGL_EXT_protected_content";
    private static final java.lang.String d = "EGL_KHR_surfaceless_context";
    private static int e;
    private static boolean f;
    public final boolean a;
    private final com.anythink.expressad.exoplayer.l.c.a g;
    private boolean h;

    public static class a extends android.os.HandlerThread implements android.os.Handler.Callback {
        private static final int a = 1;
        private static final int b = 2;

        @androidx.annotation.Nullable
        private com.anythink.expressad.exoplayer.k.g c;

        @androidx.annotation.Nullable
        private android.os.Handler d;

        @androidx.annotation.Nullable
        private java.lang.Error e;

        @androidx.annotation.Nullable
        private java.lang.RuntimeException f;

        @androidx.annotation.Nullable
        private com.anythink.expressad.exoplayer.l.c g;

        public a() {
            super("dummySurface");
        }

        private void b() {
            com.anythink.expressad.exoplayer.k.a.a(this.c);
            this.c.a();
        }

        private void b(int i) {
            com.anythink.expressad.exoplayer.k.a.a(this.c);
            this.c.a(i);
            this.g = new com.anythink.expressad.exoplayer.l.c(this, this.c.b(), i != 0, (byte) 0);
        }

        public final com.anythink.expressad.exoplayer.l.c a(int i) {
            boolean z;
            start();
            this.d = new android.os.Handler(getLooper(), this);
            this.c = new com.anythink.expressad.exoplayer.k.g(this.d);
            synchronized (this) {
                z = false;
                this.d.obtainMessage(1, i, 0).sendToTarget();
                while (this.g == null && this.f == null && this.e == null) {
                    try {
                        wait();
                    } catch (java.lang.InterruptedException unused) {
                        z = true;
                    }
                }
            }
            if (z) {
                java.lang.Thread.currentThread().interrupt();
            }
            java.lang.RuntimeException runtimeException = this.f;
            if (runtimeException != null) {
                throw runtimeException;
            }
            java.lang.Error error = this.e;
            if (error == null) {
                return (com.anythink.expressad.exoplayer.l.c) com.anythink.expressad.exoplayer.k.a.a(this.g);
            }
            throw error;
        }

        public final void a() {
            com.anythink.expressad.exoplayer.k.a.a(this.d);
            this.d.sendEmptyMessage(2);
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(android.os.Message message) {
            int i = message.what;
            try {
                if (i != 1) {
                    if (i != 2) {
                        return true;
                    }
                    try {
                        com.anythink.expressad.exoplayer.k.a.a(this.c);
                        this.c.a();
                    } catch (java.lang.Throwable unused) {
                    }
                    quit();
                    return true;
                }
                try {
                    int i2 = message.arg1;
                    com.anythink.expressad.exoplayer.k.a.a(this.c);
                    this.c.a(i2);
                    this.g = new com.anythink.expressad.exoplayer.l.c(this, this.c.b(), i2 != 0, (byte) 0);
                    synchronized (this) {
                        notify();
                    }
                } catch (java.lang.Error e) {
                    this.e = e;
                    synchronized (this) {
                        notify();
                    }
                } catch (java.lang.RuntimeException e2) {
                    this.f = e2;
                    synchronized (this) {
                        notify();
                    }
                }
                return true;
            } catch (java.lang.Throwable th) {
                synchronized (this) {
                    notify();
                    throw th;
                }
            }
        }
    }

    private c(com.anythink.expressad.exoplayer.l.c.a aVar, android.graphics.SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.g = aVar;
        this.a = z;
    }

    public /* synthetic */ c(com.anythink.expressad.exoplayer.l.c.a aVar, android.graphics.SurfaceTexture surfaceTexture, boolean z, byte b2) {
        this(aVar, surfaceTexture, z);
    }

    public static com.anythink.expressad.exoplayer.l.c a(android.content.Context context, boolean z) {
        if (com.anythink.expressad.exoplayer.k.af.a < 17) {
            throw new java.lang.UnsupportedOperationException("Unsupported prior to API level 17");
        }
        com.anythink.expressad.exoplayer.k.a.b(!z || a(context));
        return new com.anythink.expressad.exoplayer.l.c.a().a(z ? e : 0);
    }

    private static void a() {
        if (com.anythink.expressad.exoplayer.k.af.a < 17) {
            throw new java.lang.UnsupportedOperationException("Unsupported prior to API level 17");
        }
    }

    public static synchronized boolean a(android.content.Context context) {
        int i;
        java.lang.String eglQueryString;
        int i2;
        synchronized (com.anythink.expressad.exoplayer.l.c.class) {
            if (!f) {
                int i3 = com.anythink.expressad.exoplayer.k.af.a;
                if (i3 >= 24 && ((i3 >= 26 || (!"samsung".equals(com.anythink.expressad.exoplayer.k.af.c) && !"XT1650".equals(com.anythink.expressad.exoplayer.k.af.d))) && ((i3 >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) && (eglQueryString = android.opengl.EGL14.eglQueryString(android.opengl.EGL14.eglGetDisplay(0), 12373)) != null && eglQueryString.contains(c)))) {
                    i2 = eglQueryString.contains(d) ? 1 : 2;
                    e = i2;
                    f = true;
                }
                i2 = 0;
                e = i2;
                f = true;
            }
            i = e;
        }
        return i != 0;
    }

    @android.annotation.TargetApi(24)
    private static int b(android.content.Context context) {
        java.lang.String eglQueryString;
        int i = com.anythink.expressad.exoplayer.k.af.a;
        if (i < 26 && ("samsung".equals(com.anythink.expressad.exoplayer.k.af.c) || "XT1650".equals(com.anythink.expressad.exoplayer.k.af.d))) {
            return 0;
        }
        if ((i >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) && (eglQueryString = android.opengl.EGL14.eglQueryString(android.opengl.EGL14.eglGetDisplay(0), 12373)) != null && eglQueryString.contains(c)) {
            return eglQueryString.contains(d) ? 1 : 2;
        }
        return 0;
    }

    @Override // android.view.Surface
    public final void release() {
        super.release();
        synchronized (this.g) {
            if (!this.h) {
                this.g.a();
                this.h = true;
            }
        }
    }
}
