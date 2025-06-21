package com.anythink.expressad.exoplayer.g;

/* loaded from: classes12.dex */
public final class g extends com.anythink.expressad.exoplayer.a implements android.os.Handler.Callback {
    private static final int n = 0;
    private static final int o = 5;
    private final com.anythink.expressad.exoplayer.g.d p;
    private final com.anythink.expressad.exoplayer.g.f q;
    private final android.os.Handler r;

    /* renamed from: s, reason: collision with root package name */
    private final com.anythink.expressad.exoplayer.n f219s;
    private final com.anythink.expressad.exoplayer.g.e t;
    private final com.anythink.expressad.exoplayer.g.a[] u;
    private final long[] v;
    private int w;
    private int x;
    private com.anythink.expressad.exoplayer.g.b y;
    private boolean z;

    @java.lang.Deprecated
    public interface a extends com.anythink.expressad.exoplayer.g.f {
    }

    public g(com.anythink.expressad.exoplayer.g.f fVar, android.os.Looper looper) {
        this(fVar, looper, com.anythink.expressad.exoplayer.g.d.a);
    }

    private g(com.anythink.expressad.exoplayer.g.f fVar, android.os.Looper looper, com.anythink.expressad.exoplayer.g.d dVar) {
        super(4);
        this.q = (com.anythink.expressad.exoplayer.g.f) com.anythink.expressad.exoplayer.k.a.a(fVar);
        this.r = looper == null ? null : new android.os.Handler(looper, this);
        this.p = (com.anythink.expressad.exoplayer.g.d) com.anythink.expressad.exoplayer.k.a.a(dVar);
        this.f219s = new com.anythink.expressad.exoplayer.n();
        this.t = new com.anythink.expressad.exoplayer.g.e();
        this.u = new com.anythink.expressad.exoplayer.g.a[5];
        this.v = new long[5];
    }

    private void a(com.anythink.expressad.exoplayer.g.a aVar) {
        android.os.Handler handler = this.r;
        if (handler != null) {
            handler.obtainMessage(0, aVar).sendToTarget();
        } else {
            b(aVar);
        }
    }

    private void b(com.anythink.expressad.exoplayer.g.a aVar) {
        this.q.a(aVar);
    }

    private void w() {
        java.util.Arrays.fill(this.u, (java.lang.Object) null);
        this.w = 0;
        this.x = 0;
    }

    @Override // com.anythink.expressad.exoplayer.z
    public final int a(com.anythink.expressad.exoplayer.m mVar) {
        if (this.p.a(mVar)) {
            return com.anythink.expressad.exoplayer.a.a((com.anythink.expressad.exoplayer.d.g<?>) null, mVar.k) ? 4 : 2;
        }
        return 0;
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final void a(long j, long j2) {
        if (!this.z && this.x < 5) {
            this.t.a();
            if (a(this.f219s, (com.anythink.expressad.exoplayer.c.e) this.t, false) == -4) {
                if (this.t.c()) {
                    this.z = true;
                } else if (!this.t.b()) {
                    com.anythink.expressad.exoplayer.g.e eVar = this.t;
                    eVar.g = this.f219s.a.l;
                    eVar.h();
                    try {
                        int i = (this.w + this.x) % 5;
                        this.u[i] = this.y.a(this.t);
                        this.v[i] = this.t.f;
                        this.x++;
                    } catch (com.anythink.expressad.exoplayer.g.c e) {
                        throw com.anythink.expressad.exoplayer.g.a(e, s());
                    }
                }
            }
        }
        if (this.x > 0) {
            long[] jArr = this.v;
            int i2 = this.w;
            if (jArr[i2] <= j) {
                com.anythink.expressad.exoplayer.g.a aVar = this.u[i2];
                android.os.Handler handler = this.r;
                if (handler != null) {
                    handler.obtainMessage(0, aVar).sendToTarget();
                } else {
                    b(aVar);
                }
                com.anythink.expressad.exoplayer.g.a[] aVarArr = this.u;
                int i3 = this.w;
                aVarArr[i3] = null;
                this.w = (i3 + 1) % 5;
                this.x--;
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.a
    public final void a(long j, boolean z) {
        w();
        this.z = false;
    }

    @Override // com.anythink.expressad.exoplayer.a
    public final void a(com.anythink.expressad.exoplayer.m[] mVarArr, long j) {
        this.y = this.p.b(mVarArr[0]);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(android.os.Message message) {
        if (message.what != 0) {
            throw new java.lang.IllegalStateException();
        }
        b((com.anythink.expressad.exoplayer.g.a) message.obj);
        return true;
    }

    @Override // com.anythink.expressad.exoplayer.a
    public final void p() {
        w();
        this.y = null;
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final boolean u() {
        return true;
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final boolean v() {
        return this.z;
    }
}
