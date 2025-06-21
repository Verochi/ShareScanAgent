package com.anythink.expressad.exoplayer.j;

/* loaded from: classes12.dex */
public final class m implements com.anythink.expressad.exoplayer.j.aa<java.lang.Object>, com.anythink.expressad.exoplayer.j.d {
    public static final long a = 1000000;
    public static final int b = 2000;
    private static final int c = 2000;
    private static final int d = 524288;

    @androidx.annotation.Nullable
    private final android.os.Handler e;

    @androidx.annotation.Nullable
    private final com.anythink.expressad.exoplayer.j.d.a f;
    private final com.anythink.expressad.exoplayer.k.y g;
    private final com.anythink.expressad.exoplayer.k.c h;
    private int i;
    private long j;
    private long k;
    private long l;
    private long m;
    private long n;

    /* renamed from: com.anythink.expressad.exoplayer.j.m$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ long b;
        final /* synthetic */ long c;

        public AnonymousClass1(int i, long j, long j2) {
            this.a = i;
            this.b = j;
            this.c = j2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.exoplayer.j.m.this.f.c();
        }
    }

    public static final class a {

        @androidx.annotation.Nullable
        private android.os.Handler a;

        @androidx.annotation.Nullable
        private com.anythink.expressad.exoplayer.j.d.a b;
        private long c = 1000000;
        private int d = 2000;
        private com.anythink.expressad.exoplayer.k.c e = com.anythink.expressad.exoplayer.k.c.a;

        private com.anythink.expressad.exoplayer.j.m.a a(int i) {
            this.d = i;
            return this;
        }

        private com.anythink.expressad.exoplayer.j.m.a a(long j) {
            this.c = j;
            return this;
        }

        private com.anythink.expressad.exoplayer.j.m.a a(android.os.Handler handler, com.anythink.expressad.exoplayer.j.d.a aVar) {
            com.anythink.expressad.exoplayer.k.a.a((handler == null || aVar == null) ? false : true);
            this.a = handler;
            this.b = aVar;
            return this;
        }

        private com.anythink.expressad.exoplayer.j.m.a a(com.anythink.expressad.exoplayer.k.c cVar) {
            this.e = cVar;
            return this;
        }

        private com.anythink.expressad.exoplayer.j.m a() {
            return new com.anythink.expressad.exoplayer.j.m(this.a, this.b, this.c, this.d, this.e, (byte) 0);
        }
    }

    public m() {
        this(null, null, 1000000L, 2000, com.anythink.expressad.exoplayer.k.c.a);
    }

    @java.lang.Deprecated
    private m(android.os.Handler handler, com.anythink.expressad.exoplayer.j.d.a aVar) {
        this(handler, aVar, 1000000L, 2000, com.anythink.expressad.exoplayer.k.c.a);
    }

    @java.lang.Deprecated
    private m(android.os.Handler handler, com.anythink.expressad.exoplayer.j.d.a aVar, int i) {
        this(handler, aVar, 1000000L, i, com.anythink.expressad.exoplayer.k.c.a);
    }

    private m(@androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.j.d.a aVar, long j, int i, com.anythink.expressad.exoplayer.k.c cVar) {
        this.e = handler;
        this.f = aVar;
        this.g = new com.anythink.expressad.exoplayer.k.y(i);
        this.h = cVar;
        this.n = j;
    }

    public /* synthetic */ m(android.os.Handler handler, com.anythink.expressad.exoplayer.j.d.a aVar, long j, int i, com.anythink.expressad.exoplayer.k.c cVar, byte b2) {
        this(handler, aVar, j, i, cVar);
    }

    private void a(int i, long j, long j2) {
        android.os.Handler handler = this.e;
        if (handler == null || this.f == null) {
            return;
        }
        handler.post(new com.anythink.expressad.exoplayer.j.m.AnonymousClass1(i, j, j2));
    }

    @Override // com.anythink.expressad.exoplayer.j.d
    public final synchronized long a() {
        return this.n;
    }

    @Override // com.anythink.expressad.exoplayer.j.aa
    public final synchronized void a(int i) {
        this.k += i;
    }

    @Override // com.anythink.expressad.exoplayer.j.aa
    public final synchronized void b() {
        if (this.i == 0) {
            this.j = this.h.a();
        }
        this.i++;
    }

    @Override // com.anythink.expressad.exoplayer.j.aa
    public final synchronized void c() {
        com.anythink.expressad.exoplayer.k.a.b(this.i > 0);
        long a2 = this.h.a();
        int i = (int) (a2 - this.j);
        this.l += i;
        long j = this.m;
        long j2 = this.k;
        this.m = j + j2;
        if (i > 0) {
            this.g.a((int) java.lang.Math.sqrt(j2), (8000 * j2) / r6);
            if (this.l >= 2000 || this.m >= android.support.v4.media.session.PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                this.n = (long) this.g.a();
            }
        }
        long j3 = this.k;
        long j4 = this.n;
        android.os.Handler handler = this.e;
        if (handler != null && this.f != null) {
            handler.post(new com.anythink.expressad.exoplayer.j.m.AnonymousClass1(i, j3, j4));
        }
        int i2 = this.i - 1;
        this.i = i2;
        if (i2 > 0) {
            this.j = a2;
        }
        this.k = 0L;
    }
}
