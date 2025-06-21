package com.google.android.exoplayer2.video;

@androidx.annotation.RequiresApi(17)
/* loaded from: classes22.dex */
public final class DummySurface extends android.view.Surface {
    private static final java.lang.String TAG = "DummySurface";
    private static int secureMode;
    private static boolean secureModeInitialized;
    public final boolean secure;
    private final com.google.android.exoplayer2.video.DummySurface.DummySurfaceThread thread;
    private boolean threadReleased;

    public static class DummySurfaceThread extends android.os.HandlerThread implements android.os.Handler.Callback {
        public com.google.android.exoplayer2.util.EGLSurfaceTexture n;
        public android.os.Handler t;

        @androidx.annotation.Nullable
        public java.lang.Error u;

        @androidx.annotation.Nullable
        public java.lang.RuntimeException v;

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.video.DummySurface w;

        public DummySurfaceThread() {
            super("ExoPlayer:DummySurface");
        }

        public com.google.android.exoplayer2.video.DummySurface a(int i) {
            boolean z;
            start();
            this.t = new android.os.Handler(getLooper(), this);
            this.n = new com.google.android.exoplayer2.util.EGLSurfaceTexture(this.t);
            synchronized (this) {
                z = false;
                this.t.obtainMessage(1, i, 0).sendToTarget();
                while (this.w == null && this.v == null && this.u == null) {
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
            java.lang.RuntimeException runtimeException = this.v;
            if (runtimeException != null) {
                throw runtimeException;
            }
            java.lang.Error error = this.u;
            if (error == null) {
                return (com.google.android.exoplayer2.video.DummySurface) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.w);
            }
            throw error;
        }

        public final void b(int i) {
            com.google.android.exoplayer2.util.Assertions.checkNotNull(this.n);
            this.n.init(i);
            this.w = new com.google.android.exoplayer2.video.DummySurface(this, this.n.getSurfaceTexture(), i != 0, null);
        }

        public void c() {
            com.google.android.exoplayer2.util.Assertions.checkNotNull(this.t);
            this.t.sendEmptyMessage(2);
        }

        public final void d() {
            com.google.android.exoplayer2.util.Assertions.checkNotNull(this.n);
            this.n.release();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(android.os.Message message) {
            int i = message.what;
            try {
                if (i != 1) {
                    if (i != 2) {
                        return true;
                    }
                    try {
                        d();
                    } finally {
                        try {
                            return true;
                        } finally {
                        }
                    }
                    return true;
                }
                try {
                    b(message.arg1);
                    synchronized (this) {
                        notify();
                    }
                } catch (java.lang.Error e) {
                    com.google.android.exoplayer2.util.Log.e(com.google.android.exoplayer2.video.DummySurface.TAG, "Failed to initialize dummy surface", e);
                    this.u = e;
                    synchronized (this) {
                        notify();
                    }
                } catch (java.lang.RuntimeException e2) {
                    com.google.android.exoplayer2.util.Log.e(com.google.android.exoplayer2.video.DummySurface.TAG, "Failed to initialize dummy surface", e2);
                    this.v = e2;
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

    private DummySurface(com.google.android.exoplayer2.video.DummySurface.DummySurfaceThread dummySurfaceThread, android.graphics.SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.thread = dummySurfaceThread;
        this.secure = z;
    }

    public /* synthetic */ DummySurface(com.google.android.exoplayer2.video.DummySurface.DummySurfaceThread dummySurfaceThread, android.graphics.SurfaceTexture surfaceTexture, boolean z, com.google.android.exoplayer2.video.DummySurface.AnonymousClass1 anonymousClass1) {
        this(dummySurfaceThread, surfaceTexture, z);
    }

    private static int getSecureMode(android.content.Context context) {
        if (com.google.android.exoplayer2.util.GlUtil.isProtectedContentExtensionSupported(context)) {
            return com.google.android.exoplayer2.util.GlUtil.isSurfacelessContextExtensionSupported() ? 1 : 2;
        }
        return 0;
    }

    public static synchronized boolean isSecureSupported(android.content.Context context) {
        boolean z;
        synchronized (com.google.android.exoplayer2.video.DummySurface.class) {
            if (!secureModeInitialized) {
                secureMode = getSecureMode(context);
                secureModeInitialized = true;
            }
            z = secureMode != 0;
        }
        return z;
    }

    public static com.google.android.exoplayer2.video.DummySurface newInstanceV17(android.content.Context context, boolean z) {
        com.google.android.exoplayer2.util.Assertions.checkState(!z || isSecureSupported(context));
        return new com.google.android.exoplayer2.video.DummySurface.DummySurfaceThread().a(z ? secureMode : 0);
    }

    @Override // android.view.Surface
    public void release() {
        super.release();
        synchronized (this.thread) {
            if (!this.threadReleased) {
                this.thread.c();
                this.threadReleased = true;
            }
        }
    }
}
