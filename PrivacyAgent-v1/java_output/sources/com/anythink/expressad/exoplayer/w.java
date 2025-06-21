package com.anythink.expressad.exoplayer;

/* loaded from: classes12.dex */
public interface w {
    public static final int h = 1;
    public static final int i = 2;
    public static final int j = 3;
    public static final int k = 4;
    public static final int l = 0;
    public static final int m = 1;
    public static final int n = 2;
    public static final int o = 0;
    public static final int p = 1;
    public static final int q = 2;
    public static final int r = 3;

    /* renamed from: s, reason: collision with root package name */
    public static final int f232s = 4;
    public static final int t = 0;
    public static final int u = 1;
    public static final int v = 2;

    public static abstract class a implements com.anythink.expressad.exoplayer.w.c {
        @java.lang.Deprecated
        private static void a() {
        }

        @Override // com.anythink.expressad.exoplayer.w.c
        public void onLoadingChanged(boolean z) {
        }

        @Override // com.anythink.expressad.exoplayer.w.c
        public void onPlaybackParametersChanged(com.anythink.expressad.exoplayer.v vVar) {
        }

        @Override // com.anythink.expressad.exoplayer.w.c
        public void onPlayerError(com.anythink.expressad.exoplayer.g gVar) {
        }

        @Override // com.anythink.expressad.exoplayer.w.c
        public void onPlayerStateChanged(boolean z, int i) {
        }

        @Override // com.anythink.expressad.exoplayer.w.c
        public void onPositionDiscontinuity(int i) {
        }

        @Override // com.anythink.expressad.exoplayer.w.c
        public void onRepeatModeChanged(int i) {
        }

        @Override // com.anythink.expressad.exoplayer.w.c
        public void onSeekProcessed() {
        }

        @Override // com.anythink.expressad.exoplayer.w.c
        public void onShuffleModeEnabledChanged(boolean z) {
        }

        @Override // com.anythink.expressad.exoplayer.w.c
        public void onTimelineChanged(com.anythink.expressad.exoplayer.ae aeVar, @androidx.annotation.Nullable java.lang.Object obj, int i) {
        }

        @Override // com.anythink.expressad.exoplayer.w.c
        public void onTracksChanged(com.anythink.expressad.exoplayer.h.af afVar, com.anythink.expressad.exoplayer.i.g gVar) {
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface b {
    }

    public interface c {
        void onLoadingChanged(boolean z);

        void onPlaybackParametersChanged(com.anythink.expressad.exoplayer.v vVar);

        void onPlayerError(com.anythink.expressad.exoplayer.g gVar);

        void onPlayerStateChanged(boolean z, int i);

        void onPositionDiscontinuity(int i);

        void onRepeatModeChanged(int i);

        void onSeekProcessed();

        void onShuffleModeEnabledChanged(boolean z);

        void onTimelineChanged(com.anythink.expressad.exoplayer.ae aeVar, @androidx.annotation.Nullable java.lang.Object obj, int i);

        void onTracksChanged(com.anythink.expressad.exoplayer.h.af afVar, com.anythink.expressad.exoplayer.i.g gVar);
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface d {
    }

    public interface e {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface f {
    }

    public interface g {
        int H();

        void I();

        void a(android.view.Surface surface);

        void a(android.view.SurfaceHolder surfaceHolder);

        void a(android.view.SurfaceView surfaceView);

        void a(android.view.TextureView textureView);

        void a(com.anythink.expressad.exoplayer.l.g gVar);

        void b(android.view.Surface surface);

        void b(android.view.SurfaceHolder surfaceHolder);

        void b(android.view.SurfaceView surfaceView);

        void b(android.view.TextureView textureView);

        void b(com.anythink.expressad.exoplayer.l.g gVar);

        void d(int i);
    }

    int A();

    long B();

    int C();

    com.anythink.expressad.exoplayer.h.af D();

    com.anythink.expressad.exoplayer.i.g E();

    com.anythink.expressad.exoplayer.ae F();

    @androidx.annotation.Nullable
    java.lang.Object G();

    void a(int i2);

    void a(int i2, long j2);

    void a(long j2);

    void a(@androidx.annotation.Nullable com.anythink.expressad.exoplayer.v vVar);

    void a(com.anythink.expressad.exoplayer.w.c cVar);

    void a(boolean z);

    @androidx.annotation.Nullable
    com.anythink.expressad.exoplayer.w.g b();

    void b(int i2);

    void b(com.anythink.expressad.exoplayer.w.c cVar);

    void b(boolean z);

    int c(int i2);

    @androidx.annotation.Nullable
    com.anythink.expressad.exoplayer.w.e c();

    void c(boolean z);

    int d();

    @androidx.annotation.Nullable
    com.anythink.expressad.exoplayer.g e();

    boolean f();

    int g();

    boolean h();

    boolean i();

    void j();

    com.anythink.expressad.exoplayer.v k();

    @androidx.annotation.Nullable
    java.lang.Object l();

    void m();

    void n();

    int o();

    int p();

    int q();

    int r();

    long s();

    long t();

    long u();

    int v();

    boolean w();

    boolean x();

    boolean y();

    int z();
}
