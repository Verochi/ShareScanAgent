package com.anythink.expressad.exoplayer.l;

@android.annotation.TargetApi(16)
/* loaded from: classes12.dex */
public final class f {
    private static final long a = 500;
    private static final long b = 20000000;
    private static final long c = 80;
    private static final int d = 6;
    private final android.view.WindowManager e;
    private final com.anythink.expressad.exoplayer.l.f.b f;
    private final com.anythink.expressad.exoplayer.l.f.a g;
    private long h;
    private long i;
    private long j;
    private long k;
    private long l;
    private boolean m;
    private long n;
    private long o;
    private long p;

    @android.annotation.TargetApi(17)
    public final class a implements android.hardware.display.DisplayManager.DisplayListener {
        private final android.hardware.display.DisplayManager b;

        public a(android.hardware.display.DisplayManager displayManager) {
            this.b = displayManager;
        }

        public final void a() {
            this.b.registerDisplayListener(this, null);
        }

        public final void b() {
            this.b.unregisterDisplayListener(this);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayAdded(int i) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayChanged(int i) {
            if (i == 0) {
                com.anythink.expressad.exoplayer.l.f.this.c();
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayRemoved(int i) {
        }
    }

    public static final class b implements android.os.Handler.Callback, android.view.Choreographer.FrameCallback {
        private static final int b = 0;
        private static final int c = 1;
        private static final int d = 2;
        private static final com.anythink.expressad.exoplayer.l.f.b e = new com.anythink.expressad.exoplayer.l.f.b();
        public volatile long a = -9223372036854775807L;
        private final android.os.Handler f;
        private final android.os.HandlerThread g;
        private android.view.Choreographer h;
        private int i;

        private b() {
            android.os.HandlerThread handlerThread = new android.os.HandlerThread("ChoreographerOwner:Handler");
            this.g = handlerThread;
            handlerThread.start();
            android.os.Handler handler = new android.os.Handler(handlerThread.getLooper(), this);
            this.f = handler;
            handler.sendEmptyMessage(0);
        }

        public static com.anythink.expressad.exoplayer.l.f.b a() {
            return e;
        }

        private void d() {
            this.h = android.view.Choreographer.getInstance();
        }

        private void e() {
            android.view.Choreographer choreographer = this.h;
            if (choreographer != null) {
                int i = this.i + 1;
                this.i = i;
                if (i == 1) {
                    choreographer.postFrameCallback(this);
                }
            }
        }

        private void f() {
            android.view.Choreographer choreographer = this.h;
            if (choreographer != null) {
                int i = this.i - 1;
                this.i = i;
                if (i == 0) {
                    choreographer.removeFrameCallback(this);
                    this.a = -9223372036854775807L;
                }
            }
        }

        public final void b() {
            this.f.sendEmptyMessage(1);
        }

        public final void c() {
            this.f.sendEmptyMessage(2);
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long j) {
            if (this.h != null) {
                this.a = j;
                this.h.postFrameCallbackDelayed(this, 500L);
            }
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(android.os.Message message) {
            int i = message.what;
            if (i == 0) {
                try {
                    this.h = android.view.Choreographer.getInstance();
                } catch (java.lang.Throwable unused) {
                }
                return true;
            }
            if (i == 1) {
                android.view.Choreographer choreographer = this.h;
                if (choreographer != null) {
                    int i2 = this.i + 1;
                    this.i = i2;
                    if (i2 == 1) {
                        choreographer.postFrameCallback(this);
                    }
                }
                return true;
            }
            if (i != 2) {
                return false;
            }
            android.view.Choreographer choreographer2 = this.h;
            if (choreographer2 != null) {
                int i3 = this.i - 1;
                this.i = i3;
                if (i3 == 0) {
                    choreographer2.removeFrameCallback(this);
                    this.a = -9223372036854775807L;
                }
            }
            return true;
        }
    }

    public f() {
        this(null);
    }

    public f(@androidx.annotation.Nullable android.content.Context context) {
        android.hardware.display.DisplayManager displayManager;
        com.anythink.expressad.exoplayer.l.f.a aVar = null;
        if (context != null) {
            context = context.getApplicationContext();
            this.e = (android.view.WindowManager) context.getSystemService("window");
        } else {
            this.e = null;
        }
        if (this.e != null) {
            if (com.anythink.expressad.exoplayer.k.af.a >= 17 && (displayManager = (android.hardware.display.DisplayManager) context.getSystemService("display")) != null) {
                aVar = new com.anythink.expressad.exoplayer.l.f.a(displayManager);
            }
            this.g = aVar;
            this.f = com.anythink.expressad.exoplayer.l.f.b.a();
        } else {
            this.g = null;
            this.f = null;
        }
        this.h = -9223372036854775807L;
        this.i = -9223372036854775807L;
    }

    private static long a(long j, long j2, long j3) {
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

    @android.annotation.TargetApi(17)
    private com.anythink.expressad.exoplayer.l.f.a a(android.content.Context context) {
        android.hardware.display.DisplayManager displayManager = (android.hardware.display.DisplayManager) context.getSystemService("display");
        if (displayManager == null) {
            return null;
        }
        return new com.anythink.expressad.exoplayer.l.f.a(displayManager);
    }

    private boolean b(long j, long j2) {
        return java.lang.Math.abs((j2 - this.n) - (j - this.o)) > b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            if (this.e.getDefaultDisplay() != null) {
                long refreshRate = (long) (1.0E9d / r0.getRefreshRate());
                this.h = refreshRate;
                this.i = (refreshRate * c) / 100;
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long a(long j, long j2) {
        long j3;
        long j4;
        com.anythink.expressad.exoplayer.l.f.b bVar;
        long j5;
        long j6 = 1000 * j;
        if (this.m) {
            if (j != this.j) {
                this.p++;
                this.k = this.l;
            }
            long j7 = this.p;
            if (j7 >= 6) {
                j4 = this.k + ((j6 - this.o) / j7);
                if (!b(j4, j2)) {
                    j3 = (this.n + j4) - this.o;
                    if (!this.m) {
                        this.o = j6;
                        this.n = j2;
                        this.p = 0L;
                        this.m = true;
                    }
                    this.j = j;
                    this.l = j4;
                    bVar = this.f;
                    if (bVar != null || this.h == -9223372036854775807L) {
                        return j3;
                    }
                    long j8 = bVar.a;
                    if (j8 == -9223372036854775807L) {
                        return j3;
                    }
                    long j9 = this.h;
                    long j10 = j8 + (((j3 - j8) / j9) * j9);
                    if (j3 <= j10) {
                        j5 = j10 - j9;
                    } else {
                        j10 = j9 + j10;
                        j5 = j10;
                    }
                    if (j10 - j3 >= j3 - j5) {
                        j10 = j5;
                    }
                    return j10 - this.i;
                }
                this.m = false;
            } else if (b(j6, j2)) {
                this.m = false;
            }
        }
        j3 = j2;
        j4 = j6;
        if (!this.m) {
        }
        this.j = j;
        this.l = j4;
        bVar = this.f;
        if (bVar != null) {
        }
        return j3;
    }

    public final void a() {
        this.m = false;
        if (this.e != null) {
            this.f.b();
            com.anythink.expressad.exoplayer.l.f.a aVar = this.g;
            if (aVar != null) {
                aVar.a();
            }
            c();
        }
    }

    public final void b() {
        if (this.e != null) {
            com.anythink.expressad.exoplayer.l.f.a aVar = this.g;
            if (aVar != null) {
                aVar.b();
            }
            this.f.c();
        }
    }
}
