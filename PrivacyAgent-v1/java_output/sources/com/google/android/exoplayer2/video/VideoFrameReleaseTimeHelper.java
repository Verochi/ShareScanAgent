package com.google.android.exoplayer2.video;

/* loaded from: classes22.dex */
public final class VideoFrameReleaseTimeHelper {

    @androidx.annotation.Nullable
    public final android.view.WindowManager a;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.video.VideoFrameReleaseTimeHelper.VSyncSampler b;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.video.VideoFrameReleaseTimeHelper.DefaultDisplayListener c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;
    public boolean i;
    public long j;
    public long k;
    public long l;

    @androidx.annotation.RequiresApi(17)
    public final class DefaultDisplayListener implements android.hardware.display.DisplayManager.DisplayListener {
        public final android.hardware.display.DisplayManager a;

        public DefaultDisplayListener(android.hardware.display.DisplayManager displayManager) {
            this.a = displayManager;
        }

        public void a() {
            this.a.registerDisplayListener(this, null);
        }

        public void b() {
            this.a.unregisterDisplayListener(this);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i) {
            if (i == 0) {
                com.google.android.exoplayer2.video.VideoFrameReleaseTimeHelper.this.e();
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i) {
        }
    }

    public static final class VSyncSampler implements android.view.Choreographer.FrameCallback, android.os.Handler.Callback {
        public static final com.google.android.exoplayer2.video.VideoFrameReleaseTimeHelper.VSyncSampler x = new com.google.android.exoplayer2.video.VideoFrameReleaseTimeHelper.VSyncSampler();
        public volatile long n = -9223372036854775807L;
        public final android.os.Handler t;
        public final android.os.HandlerThread u;
        public android.view.Choreographer v;
        public int w;

        public VSyncSampler() {
            android.os.HandlerThread handlerThread = new android.os.HandlerThread("ExoPlayer:FrameReleaseChoreographer");
            this.u = handlerThread;
            handlerThread.start();
            android.os.Handler createHandler = com.google.android.exoplayer2.util.Util.createHandler(handlerThread.getLooper(), this);
            this.t = createHandler;
            createHandler.sendEmptyMessage(0);
        }

        public static com.google.android.exoplayer2.video.VideoFrameReleaseTimeHelper.VSyncSampler d() {
            return x;
        }

        public void a() {
            this.t.sendEmptyMessage(1);
        }

        public final void b() {
            int i = this.w + 1;
            this.w = i;
            if (i == 1) {
                this.v.postFrameCallback(this);
            }
        }

        public final void c() {
            this.v = android.view.Choreographer.getInstance();
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            this.n = j;
            this.v.postFrameCallbackDelayed(this, 500L);
        }

        public void e() {
            this.t.sendEmptyMessage(2);
        }

        public final void f() {
            int i = this.w - 1;
            this.w = i;
            if (i == 0) {
                this.v.removeFrameCallback(this);
                this.n = -9223372036854775807L;
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(android.os.Message message) {
            int i = message.what;
            if (i == 0) {
                c();
                return true;
            }
            if (i == 1) {
                b();
                return true;
            }
            if (i != 2) {
                return false;
            }
            f();
            return true;
        }
    }

    public VideoFrameReleaseTimeHelper() {
        this(null);
    }

    public VideoFrameReleaseTimeHelper(@androidx.annotation.Nullable android.content.Context context) {
        if (context != null) {
            context = context.getApplicationContext();
            this.a = (android.view.WindowManager) context.getSystemService("window");
        } else {
            this.a = null;
        }
        if (this.a != null) {
            this.c = com.google.android.exoplayer2.util.Util.SDK_INT >= 17 ? d(context) : null;
            this.b = com.google.android.exoplayer2.video.VideoFrameReleaseTimeHelper.VSyncSampler.d();
        } else {
            this.c = null;
            this.b = null;
        }
        this.d = -9223372036854775807L;
        this.e = -9223372036854775807L;
    }

    public static long b(long j, long j2, long j3) {
        long j4;
        long j5 = j2 + (((j - j2) / j3) * j3);
        if (j <= j5) {
            j4 = j5 - j3;
        } else {
            j5 = j3 + j5;
            j4 = j5;
        }
        return j5 - j < j - j4 ? j5 : j4;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long adjustReleaseTime(long j, long j2) {
        long j3;
        long j4;
        com.google.android.exoplayer2.video.VideoFrameReleaseTimeHelper.VSyncSampler vSyncSampler;
        long j5 = 1000 * j;
        if (this.i) {
            if (j != this.f) {
                this.l++;
                this.g = this.h;
            }
            long j6 = this.l;
            if (j6 >= 6) {
                j4 = this.g + ((j5 - this.k) / j6);
                if (!c(j4, j2)) {
                    j3 = (this.j + j4) - this.k;
                    if (!this.i) {
                        this.k = j5;
                        this.j = j2;
                        this.l = 0L;
                        this.i = true;
                    }
                    this.f = j;
                    this.h = j4;
                    vSyncSampler = this.b;
                    if (vSyncSampler != null || this.d == -9223372036854775807L) {
                        return j3;
                    }
                    long j7 = vSyncSampler.n;
                    return j7 == -9223372036854775807L ? j3 : b(j3, j7, this.d) - this.e;
                }
                this.i = false;
            } else if (c(j5, j2)) {
                this.i = false;
            }
        }
        j3 = j2;
        j4 = j5;
        if (!this.i) {
        }
        this.f = j;
        this.h = j4;
        vSyncSampler = this.b;
        if (vSyncSampler != null) {
        }
        return j3;
    }

    public final boolean c(long j, long j2) {
        return java.lang.Math.abs((j2 - this.j) - (j - this.k)) > 20000000;
    }

    @androidx.annotation.RequiresApi(17)
    public final com.google.android.exoplayer2.video.VideoFrameReleaseTimeHelper.DefaultDisplayListener d(android.content.Context context) {
        android.hardware.display.DisplayManager displayManager = (android.hardware.display.DisplayManager) context.getSystemService("display");
        if (displayManager == null) {
            return null;
        }
        return new com.google.android.exoplayer2.video.VideoFrameReleaseTimeHelper.DefaultDisplayListener(displayManager);
    }

    @android.annotation.TargetApi(17)
    public void disable() {
        if (this.a != null) {
            com.google.android.exoplayer2.video.VideoFrameReleaseTimeHelper.DefaultDisplayListener defaultDisplayListener = this.c;
            if (defaultDisplayListener != null) {
                defaultDisplayListener.b();
            }
            this.b.e();
        }
    }

    public final void e() {
        if (this.a.getDefaultDisplay() != null) {
            long refreshRate = (long) (1.0E9d / r0.getRefreshRate());
            this.d = refreshRate;
            this.e = (refreshRate * 80) / 100;
        }
    }

    @android.annotation.TargetApi(17)
    public void enable() {
        this.i = false;
        if (this.a != null) {
            this.b.a();
            com.google.android.exoplayer2.video.VideoFrameReleaseTimeHelper.DefaultDisplayListener defaultDisplayListener = this.c;
            if (defaultDisplayListener != null) {
                defaultDisplayListener.a();
            }
            e();
        }
    }
}
