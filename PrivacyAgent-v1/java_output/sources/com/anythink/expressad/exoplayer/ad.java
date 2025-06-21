package com.anythink.expressad.exoplayer;

@android.annotation.TargetApi(16)
/* loaded from: classes12.dex */
public class ad implements com.anythink.expressad.exoplayer.h, com.anythink.expressad.exoplayer.w.e, com.anythink.expressad.exoplayer.w.g {
    private static final java.lang.String x = "SimpleExoPlayer";
    private final com.anythink.expressad.exoplayer.ad.a A;
    private final java.util.concurrent.CopyOnWriteArraySet<com.anythink.expressad.exoplayer.l.g> B;
    private final java.util.concurrent.CopyOnWriteArraySet<com.anythink.expressad.exoplayer.g.f> C;
    private final java.util.concurrent.CopyOnWriteArraySet<com.anythink.expressad.exoplayer.l.h> D;
    private final java.util.concurrent.CopyOnWriteArraySet<com.anythink.expressad.exoplayer.b.g> E;
    private final com.anythink.expressad.exoplayer.a.a F;
    private com.anythink.expressad.exoplayer.m G;
    private com.anythink.expressad.exoplayer.m H;
    private android.view.Surface I;
    private boolean J;
    private int K;
    private android.view.SurfaceHolder L;
    private android.view.TextureView M;
    private com.anythink.expressad.exoplayer.c.d N;
    private com.anythink.expressad.exoplayer.c.d O;
    private int P;
    private com.anythink.expressad.exoplayer.b.b Q;
    private float R;
    private com.anythink.expressad.exoplayer.h.s S;
    protected final com.anythink.expressad.exoplayer.y[] w;
    private final com.anythink.expressad.exoplayer.h y;
    private final android.os.Handler z;

    public final class a implements android.view.SurfaceHolder.Callback, android.view.TextureView.SurfaceTextureListener, com.anythink.expressad.exoplayer.b.g, com.anythink.expressad.exoplayer.g.f, com.anythink.expressad.exoplayer.l.h {
        private a() {
        }

        public /* synthetic */ a(com.anythink.expressad.exoplayer.ad adVar, byte b) {
            this();
        }

        @Override // com.anythink.expressad.exoplayer.b.g
        public final void a(int i) {
            com.anythink.expressad.exoplayer.ad.this.P = i;
            java.util.Iterator it = com.anythink.expressad.exoplayer.ad.this.E.iterator();
            while (it.hasNext()) {
                ((com.anythink.expressad.exoplayer.b.g) it.next()).a(i);
            }
        }

        @Override // com.anythink.expressad.exoplayer.l.h
        public final void a(int i, int i2, int i3, float f) {
            java.util.Iterator it = com.anythink.expressad.exoplayer.ad.this.B.iterator();
            while (it.hasNext()) {
                ((com.anythink.expressad.exoplayer.l.g) it.next()).a(i, i2);
            }
            java.util.Iterator it2 = com.anythink.expressad.exoplayer.ad.this.D.iterator();
            while (it2.hasNext()) {
                ((com.anythink.expressad.exoplayer.l.h) it2.next()).a(i, i2, i3, f);
            }
        }

        @Override // com.anythink.expressad.exoplayer.l.h
        public final void a(int i, long j) {
            java.util.Iterator it = com.anythink.expressad.exoplayer.ad.this.D.iterator();
            while (it.hasNext()) {
                ((com.anythink.expressad.exoplayer.l.h) it.next()).a(i, j);
            }
        }

        @Override // com.anythink.expressad.exoplayer.b.g
        public final void a(int i, long j, long j2) {
            java.util.Iterator it = com.anythink.expressad.exoplayer.ad.this.E.iterator();
            while (it.hasNext()) {
                ((com.anythink.expressad.exoplayer.b.g) it.next()).a(i, j, j2);
            }
        }

        @Override // com.anythink.expressad.exoplayer.l.h
        public final void a(android.view.Surface surface) {
            if (com.anythink.expressad.exoplayer.ad.this.I == surface) {
                java.util.Iterator it = com.anythink.expressad.exoplayer.ad.this.B.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
            java.util.Iterator it2 = com.anythink.expressad.exoplayer.ad.this.D.iterator();
            while (it2.hasNext()) {
                ((com.anythink.expressad.exoplayer.l.h) it2.next()).a(surface);
            }
        }

        @Override // com.anythink.expressad.exoplayer.l.h
        public final void a(com.anythink.expressad.exoplayer.c.d dVar) {
            com.anythink.expressad.exoplayer.ad.this.N = dVar;
            java.util.Iterator it = com.anythink.expressad.exoplayer.ad.this.D.iterator();
            while (it.hasNext()) {
                ((com.anythink.expressad.exoplayer.l.h) it.next()).a(dVar);
            }
        }

        @Override // com.anythink.expressad.exoplayer.g.f
        public final void a(com.anythink.expressad.exoplayer.g.a aVar) {
            java.util.Iterator it = com.anythink.expressad.exoplayer.ad.this.C.iterator();
            while (it.hasNext()) {
                ((com.anythink.expressad.exoplayer.g.f) it.next()).a(aVar);
            }
        }

        @Override // com.anythink.expressad.exoplayer.l.h
        public final void a(com.anythink.expressad.exoplayer.m mVar) {
            com.anythink.expressad.exoplayer.ad.this.G = mVar;
            java.util.Iterator it = com.anythink.expressad.exoplayer.ad.this.D.iterator();
            while (it.hasNext()) {
                ((com.anythink.expressad.exoplayer.l.h) it.next()).a(mVar);
            }
        }

        @Override // com.anythink.expressad.exoplayer.l.h
        public final void a(java.lang.String str, long j, long j2) {
            java.util.Iterator it = com.anythink.expressad.exoplayer.ad.this.D.iterator();
            while (it.hasNext()) {
                ((com.anythink.expressad.exoplayer.l.h) it.next()).a(str, j, j2);
            }
        }

        @Override // com.anythink.expressad.exoplayer.l.h
        public final void b(com.anythink.expressad.exoplayer.c.d dVar) {
            java.util.Iterator it = com.anythink.expressad.exoplayer.ad.this.D.iterator();
            while (it.hasNext()) {
                ((com.anythink.expressad.exoplayer.l.h) it.next()).b(dVar);
            }
            com.anythink.expressad.exoplayer.ad.this.G = null;
            com.anythink.expressad.exoplayer.ad.this.N = null;
        }

        @Override // com.anythink.expressad.exoplayer.b.g
        public final void b(com.anythink.expressad.exoplayer.m mVar) {
            com.anythink.expressad.exoplayer.ad.this.H = mVar;
            java.util.Iterator it = com.anythink.expressad.exoplayer.ad.this.E.iterator();
            while (it.hasNext()) {
                ((com.anythink.expressad.exoplayer.b.g) it.next()).b(mVar);
            }
        }

        @Override // com.anythink.expressad.exoplayer.b.g
        public final void b(java.lang.String str, long j, long j2) {
            java.util.Iterator it = com.anythink.expressad.exoplayer.ad.this.E.iterator();
            while (it.hasNext()) {
                ((com.anythink.expressad.exoplayer.b.g) it.next()).b(str, j, j2);
            }
        }

        @Override // com.anythink.expressad.exoplayer.b.g
        public final void c(com.anythink.expressad.exoplayer.c.d dVar) {
            com.anythink.expressad.exoplayer.ad.this.O = dVar;
            java.util.Iterator it = com.anythink.expressad.exoplayer.ad.this.E.iterator();
            while (it.hasNext()) {
                ((com.anythink.expressad.exoplayer.b.g) it.next()).c(dVar);
            }
        }

        @Override // com.anythink.expressad.exoplayer.b.g
        public final void d(com.anythink.expressad.exoplayer.c.d dVar) {
            java.util.Iterator it = com.anythink.expressad.exoplayer.ad.this.E.iterator();
            while (it.hasNext()) {
                ((com.anythink.expressad.exoplayer.b.g) it.next()).d(dVar);
            }
            com.anythink.expressad.exoplayer.ad.this.H = null;
            com.anythink.expressad.exoplayer.ad.this.O = null;
            com.anythink.expressad.exoplayer.ad.this.P = 0;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
            com.anythink.expressad.exoplayer.ad.this.a(new android.view.Surface(surfaceTexture), true);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final boolean onSurfaceTextureDestroyed(android.graphics.SurfaceTexture surfaceTexture) {
            com.anythink.expressad.exoplayer.ad.this.a((android.view.Surface) null, true);
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureSizeChanged(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureUpdated(android.graphics.SurfaceTexture surfaceTexture) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceChanged(android.view.SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceCreated(android.view.SurfaceHolder surfaceHolder) {
            com.anythink.expressad.exoplayer.ad.this.a(surfaceHolder.getSurface(), false);
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceDestroyed(android.view.SurfaceHolder surfaceHolder) {
            com.anythink.expressad.exoplayer.ad.this.a((android.view.Surface) null, false);
        }
    }

    @java.lang.Deprecated
    public interface b extends com.anythink.expressad.exoplayer.l.g {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ad(com.anythink.expressad.exoplayer.ab abVar, com.anythink.expressad.exoplayer.i.h hVar, com.anythink.expressad.exoplayer.p pVar, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar) {
        this(abVar, hVar, pVar, gVar, (byte) 0);
        new com.anythink.expressad.exoplayer.a.a.C0183a();
    }

    public ad(com.anythink.expressad.exoplayer.ab abVar, com.anythink.expressad.exoplayer.i.h hVar, com.anythink.expressad.exoplayer.p pVar, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar, byte b2) {
        this(abVar, hVar, pVar, gVar, com.anythink.expressad.exoplayer.k.c.a);
    }

    private ad(com.anythink.expressad.exoplayer.ab abVar, com.anythink.expressad.exoplayer.i.h hVar, com.anythink.expressad.exoplayer.p pVar, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar, com.anythink.expressad.exoplayer.k.c cVar) {
        com.anythink.expressad.exoplayer.ad.a aVar = new com.anythink.expressad.exoplayer.ad.a(this, (byte) 0);
        this.A = aVar;
        this.B = new java.util.concurrent.CopyOnWriteArraySet<>();
        this.C = new java.util.concurrent.CopyOnWriteArraySet<>();
        java.util.concurrent.CopyOnWriteArraySet<com.anythink.expressad.exoplayer.l.h> copyOnWriteArraySet = new java.util.concurrent.CopyOnWriteArraySet<>();
        this.D = copyOnWriteArraySet;
        java.util.concurrent.CopyOnWriteArraySet<com.anythink.expressad.exoplayer.b.g> copyOnWriteArraySet2 = new java.util.concurrent.CopyOnWriteArraySet<>();
        this.E = copyOnWriteArraySet2;
        android.os.Handler handler = new android.os.Handler(android.os.Looper.myLooper() != null ? android.os.Looper.myLooper() : android.os.Looper.getMainLooper());
        this.z = handler;
        com.anythink.expressad.exoplayer.y[] a2 = abVar.a(handler, aVar, aVar, aVar, gVar);
        this.w = a2;
        this.R = 1.0f;
        this.P = 0;
        this.Q = com.anythink.expressad.exoplayer.b.b.a;
        this.K = 1;
        com.anythink.expressad.exoplayer.j jVar = new com.anythink.expressad.exoplayer.j(a2, hVar, pVar, cVar);
        this.y = jVar;
        com.anythink.expressad.exoplayer.a.a a3 = com.anythink.expressad.exoplayer.a.a.C0183a.a(jVar, cVar);
        this.F = a3;
        a((com.anythink.expressad.exoplayer.w.c) a3);
        copyOnWriteArraySet.add(a3);
        copyOnWriteArraySet2.add(a3);
        a((com.anythink.expressad.exoplayer.g.f) a3);
        if (gVar instanceof com.anythink.expressad.exoplayer.d.d) {
            ((com.anythink.expressad.exoplayer.d.d) gVar).a(handler, a3);
        }
    }

    @java.lang.Deprecated
    private int K() {
        return com.anythink.expressad.exoplayer.k.af.f(this.Q.d);
    }

    private com.anythink.expressad.exoplayer.a.a L() {
        return this.F;
    }

    private com.anythink.expressad.exoplayer.b.b M() {
        return this.Q;
    }

    private float N() {
        return this.R;
    }

    private com.anythink.expressad.exoplayer.m O() {
        return this.G;
    }

    private com.anythink.expressad.exoplayer.m P() {
        return this.H;
    }

    private int Q() {
        return this.P;
    }

    private com.anythink.expressad.exoplayer.c.d R() {
        return this.N;
    }

    private com.anythink.expressad.exoplayer.c.d S() {
        return this.O;
    }

    private void T() {
        android.view.TextureView textureView = this.M;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() == this.A) {
                this.M.setSurfaceTextureListener(null);
            }
            this.M = null;
        }
        android.view.SurfaceHolder surfaceHolder = this.L;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.A);
            this.L = null;
        }
    }

    private static com.anythink.expressad.exoplayer.h a(com.anythink.expressad.exoplayer.y[] yVarArr, com.anythink.expressad.exoplayer.i.h hVar, com.anythink.expressad.exoplayer.p pVar, com.anythink.expressad.exoplayer.k.c cVar) {
        return new com.anythink.expressad.exoplayer.j(yVarArr, hVar, pVar, cVar);
    }

    @android.annotation.TargetApi(23)
    @java.lang.Deprecated
    private void a(@androidx.annotation.Nullable android.media.PlaybackParams playbackParams) {
        com.anythink.expressad.exoplayer.v vVar;
        float speed;
        float pitch;
        if (playbackParams != null) {
            playbackParams.allowDefaults();
            speed = playbackParams.getSpeed();
            pitch = playbackParams.getPitch();
            vVar = new com.anythink.expressad.exoplayer.v(speed, pitch);
        } else {
            vVar = null;
        }
        a(vVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(android.view.Surface surface, boolean z) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.anythink.expressad.exoplayer.y yVar : this.w) {
            if (yVar.a() == 2) {
                arrayList.add(this.y.a(yVar).a(1).a(surface).i());
            }
        }
        android.view.Surface surface2 = this.I;
        if (surface2 != null && surface2 != surface) {
            try {
                java.util.Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((com.anythink.expressad.exoplayer.x) it.next()).k();
                }
            } catch (java.lang.InterruptedException unused) {
                java.lang.Thread.currentThread().interrupt();
            } catch (java.util.concurrent.TimeoutException unused2) {
                this.y.c(false);
            }
            if (this.J) {
                this.I.release();
            }
        }
        this.I = surface;
        this.J = z;
    }

    private void a(com.anythink.expressad.exoplayer.a.b bVar) {
        this.F.a(bVar);
    }

    @java.lang.Deprecated
    private void a(com.anythink.expressad.exoplayer.ad.b bVar) {
        this.B.clear();
        if (bVar != null) {
            a((com.anythink.expressad.exoplayer.l.g) bVar);
        }
    }

    private void a(com.anythink.expressad.exoplayer.b.b bVar) {
        this.Q = bVar;
        for (com.anythink.expressad.exoplayer.y yVar : this.w) {
            if (yVar.a() == 1) {
                this.y.a(yVar).a(3).a(bVar).i();
            }
        }
    }

    @java.lang.Deprecated
    private void a(com.anythink.expressad.exoplayer.b.g gVar) {
        this.E.retainAll(java.util.Collections.singleton(this.F));
        if (gVar != null) {
            this.E.add(gVar);
        }
    }

    private void a(com.anythink.expressad.exoplayer.g.f fVar) {
        this.C.add(fVar);
    }

    @java.lang.Deprecated
    private void a(com.anythink.expressad.exoplayer.l.h hVar) {
        this.D.retainAll(java.util.Collections.singleton(this.F));
        if (hVar != null) {
            this.D.add(hVar);
        }
    }

    private void b(com.anythink.expressad.exoplayer.a.b bVar) {
        this.F.b(bVar);
    }

    @java.lang.Deprecated
    private void b(com.anythink.expressad.exoplayer.ad.b bVar) {
        b((com.anythink.expressad.exoplayer.l.g) bVar);
    }

    @java.lang.Deprecated
    private void b(com.anythink.expressad.exoplayer.b.g gVar) {
        this.E.add(gVar);
    }

    private void b(com.anythink.expressad.exoplayer.g.f fVar) {
        this.C.remove(fVar);
    }

    @java.lang.Deprecated
    private void b(com.anythink.expressad.exoplayer.l.h hVar) {
        this.D.add(hVar);
    }

    @java.lang.Deprecated
    private void c(com.anythink.expressad.exoplayer.b.g gVar) {
        this.E.remove(gVar);
    }

    @java.lang.Deprecated
    private void c(com.anythink.expressad.exoplayer.g.f fVar) {
        this.C.retainAll(java.util.Collections.singleton(this.F));
        if (fVar != null) {
            a(fVar);
        }
    }

    @java.lang.Deprecated
    private void c(com.anythink.expressad.exoplayer.l.h hVar) {
        this.D.remove(hVar);
    }

    @java.lang.Deprecated
    private void d(com.anythink.expressad.exoplayer.g.f fVar) {
        this.C.remove(fVar);
    }

    @java.lang.Deprecated
    private void e(int i) {
        com.anythink.expressad.exoplayer.b.b a2 = new com.anythink.expressad.exoplayer.b.b.a().b(com.anythink.expressad.exoplayer.k.af.d(i)).a(com.anythink.expressad.exoplayer.k.af.e(i)).a();
        this.Q = a2;
        for (com.anythink.expressad.exoplayer.y yVar : this.w) {
            if (yVar.a() == 1) {
                this.y.a(yVar).a(3).a(a2).i();
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int A() {
        return this.y.A();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final long B() {
        return this.y.B();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int C() {
        return this.y.C();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final com.anythink.expressad.exoplayer.h.af D() {
        return this.y.D();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final com.anythink.expressad.exoplayer.i.g E() {
        return this.y.E();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final com.anythink.expressad.exoplayer.ae F() {
        return this.y.F();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final java.lang.Object G() {
        return this.y.G();
    }

    @Override // com.anythink.expressad.exoplayer.w.g
    public final int H() {
        return this.K;
    }

    @Override // com.anythink.expressad.exoplayer.w.g
    public final void I() {
        a((android.view.Surface) null);
    }

    public final boolean J() {
        return d() == 3 && f();
    }

    @Override // com.anythink.expressad.exoplayer.h
    public final android.os.Looper a() {
        return this.y.a();
    }

    @Override // com.anythink.expressad.exoplayer.h
    public final com.anythink.expressad.exoplayer.x a(com.anythink.expressad.exoplayer.x.b bVar) {
        return this.y.a(bVar);
    }

    public final void a(float f) {
        this.R = f;
        for (com.anythink.expressad.exoplayer.y yVar : this.w) {
            if (yVar.a() == 1) {
                this.y.a(yVar).a(2).a(java.lang.Float.valueOf(f)).i();
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void a(int i) {
        this.y.a(i);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void a(int i, long j) {
        this.F.a();
        this.y.a(i, j);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void a(long j) {
        this.F.a();
        this.y.a(j);
    }

    @Override // com.anythink.expressad.exoplayer.w.g
    public final void a(android.view.Surface surface) {
        T();
        a(surface, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0017, code lost:
    
        if (r2.isValid() != false) goto L11;
     */
    @Override // com.anythink.expressad.exoplayer.w.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(android.view.SurfaceHolder surfaceHolder) {
        android.view.Surface surface;
        T();
        this.L = surfaceHolder;
        if (surfaceHolder != null) {
            surfaceHolder.addCallback(this.A);
            surface = surfaceHolder.getSurface();
            if (surface != null) {
            }
        }
        surface = null;
        a(surface, false);
    }

    @Override // com.anythink.expressad.exoplayer.w.g
    public final void a(android.view.SurfaceView surfaceView) {
        a(surfaceView == null ? null : surfaceView.getHolder());
    }

    @Override // com.anythink.expressad.exoplayer.w.g
    public final void a(android.view.TextureView textureView) {
        T();
        this.M = textureView;
        android.view.Surface surface = null;
        if (textureView != null) {
            textureView.getSurfaceTextureListener();
            textureView.setSurfaceTextureListener(this.A);
            android.graphics.SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
            if (surfaceTexture != null) {
                surface = new android.view.Surface(surfaceTexture);
            }
        }
        a(surface, true);
    }

    @Override // com.anythink.expressad.exoplayer.h
    public final void a(@androidx.annotation.Nullable com.anythink.expressad.exoplayer.ac acVar) {
        this.y.a(acVar);
    }

    @Override // com.anythink.expressad.exoplayer.h
    public final void a(com.anythink.expressad.exoplayer.h.s sVar) {
        a(sVar, true, true);
    }

    @Override // com.anythink.expressad.exoplayer.h
    public final void a(com.anythink.expressad.exoplayer.h.s sVar, boolean z, boolean z2) {
        com.anythink.expressad.exoplayer.h.s sVar2 = this.S;
        if (sVar2 != sVar) {
            if (sVar2 != null) {
                sVar2.a(this.F);
                this.F.b();
            }
            sVar.a(this.z, this.F);
            this.S = sVar;
        }
        this.y.a(sVar, z, z2);
    }

    @Override // com.anythink.expressad.exoplayer.w.g
    public final void a(com.anythink.expressad.exoplayer.l.g gVar) {
        this.B.add(gVar);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void a(@androidx.annotation.Nullable com.anythink.expressad.exoplayer.v vVar) {
        this.y.a(vVar);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void a(com.anythink.expressad.exoplayer.w.c cVar) {
        this.y.a(cVar);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void a(boolean z) {
        this.y.a(z);
    }

    @Override // com.anythink.expressad.exoplayer.h
    public final void a(com.anythink.expressad.exoplayer.h.c... cVarArr) {
        this.y.a(cVarArr);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final com.anythink.expressad.exoplayer.w.g b() {
        return this;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void b(int i) {
        this.F.a();
        this.y.b(i);
    }

    @Override // com.anythink.expressad.exoplayer.w.g
    public final void b(android.view.Surface surface) {
        if (surface == null || surface != this.I) {
            return;
        }
        a((android.view.Surface) null);
    }

    @Override // com.anythink.expressad.exoplayer.w.g
    public final void b(android.view.SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null || surfaceHolder != this.L) {
            return;
        }
        a((android.view.SurfaceHolder) null);
    }

    @Override // com.anythink.expressad.exoplayer.w.g
    public final void b(android.view.SurfaceView surfaceView) {
        android.view.SurfaceHolder holder = surfaceView == null ? null : surfaceView.getHolder();
        if (holder == null || holder != this.L) {
            return;
        }
        a((android.view.SurfaceHolder) null);
    }

    @Override // com.anythink.expressad.exoplayer.w.g
    public final void b(android.view.TextureView textureView) {
        if (textureView == null || textureView != this.M) {
            return;
        }
        a((android.view.TextureView) null);
    }

    @Override // com.anythink.expressad.exoplayer.w.g
    public final void b(com.anythink.expressad.exoplayer.l.g gVar) {
        this.B.remove(gVar);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void b(com.anythink.expressad.exoplayer.w.c cVar) {
        this.y.b(cVar);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void b(boolean z) {
        this.y.b(z);
    }

    @Override // com.anythink.expressad.exoplayer.h
    public final void b(com.anythink.expressad.exoplayer.h.c... cVarArr) {
        this.y.b(cVarArr);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int c(int i) {
        return this.y.c(i);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final com.anythink.expressad.exoplayer.w.e c() {
        return this;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void c(boolean z) {
        this.y.c(z);
        com.anythink.expressad.exoplayer.h.s sVar = this.S;
        if (sVar != null) {
            sVar.a(this.F);
            this.S = null;
            this.F.b();
        }
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int d() {
        return this.y.d();
    }

    @Override // com.anythink.expressad.exoplayer.w.g
    public final void d(int i) {
        this.K = i;
        for (com.anythink.expressad.exoplayer.y yVar : this.w) {
            if (yVar.a() == 2) {
                this.y.a(yVar).a(4).a(java.lang.Integer.valueOf(i)).i();
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final com.anythink.expressad.exoplayer.g e() {
        return this.y.e();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final boolean f() {
        return this.y.f();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int g() {
        return this.y.g();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final boolean h() {
        return this.y.h();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final boolean i() {
        return this.y.i();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void j() {
        this.F.a();
        this.y.j();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final com.anythink.expressad.exoplayer.v k() {
        return this.y.k();
    }

    @Override // com.anythink.expressad.exoplayer.w
    @androidx.annotation.Nullable
    public final java.lang.Object l() {
        return this.y.l();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void m() {
        c(false);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void n() {
        this.y.n();
        T();
        android.view.Surface surface = this.I;
        if (surface != null) {
            if (this.J) {
                surface.release();
            }
            this.I = null;
        }
        com.anythink.expressad.exoplayer.h.s sVar = this.S;
        if (sVar != null) {
            sVar.a(this.F);
        }
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int o() {
        return this.y.o();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int p() {
        return this.y.p();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int q() {
        return this.y.q();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int r() {
        return this.y.r();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final long s() {
        return this.y.s();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final long t() {
        return this.y.t();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final long u() {
        return this.y.u();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int v() {
        return this.y.v();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final boolean w() {
        return this.y.w();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final boolean x() {
        return this.y.x();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final boolean y() {
        return this.y.y();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int z() {
        return this.y.z();
    }
}
