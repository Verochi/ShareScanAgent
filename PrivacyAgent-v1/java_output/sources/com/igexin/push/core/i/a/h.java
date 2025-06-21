package com.igexin.push.core.i.a;

/* loaded from: classes23.dex */
public final class h {
    final com.igexin.push.core.i.a.d a;
    final java.util.List<com.igexin.push.core.i.a.h.b> b;
    public boolean c;
    public boolean d;
    com.igexin.push.core.i.a.h.a e;
    boolean f;
    com.igexin.push.core.i.a.h.a g;
    android.graphics.Bitmap h;
    public com.igexin.push.core.i.a.h.a i;
    int j;
    int k;
    int l;
    private final android.os.Handler m;
    private boolean n;
    private com.igexin.push.core.i.a.h.d o;

    public static class a {
        final int a;
        android.graphics.Bitmap b;
        private final android.os.Handler c;
        private final long d;

        public a(android.os.Handler handler, int i, long j) {
            this.c = handler;
            this.a = i;
            this.d = j;
        }

        private android.graphics.Bitmap a() {
            return this.b;
        }

        private void b() {
            this.b = null;
        }

        public final void a(android.graphics.Bitmap bitmap) {
            this.b = bitmap;
            this.c.sendMessageAtTime(this.c.obtainMessage(1, this), this.d);
        }
    }

    public interface b {
        void b();
    }

    public class c implements android.os.Handler.Callback {
        static final int a = 1;
        static final int b = 2;

        public c() {
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(android.os.Message message) {
            if (message.what != 1) {
                return false;
            }
            try {
                com.igexin.push.core.i.a.h.this.a((com.igexin.push.core.i.a.h.a) message.obj);
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
            return true;
        }
    }

    public interface d {
        void a();
    }

    public h(com.igexin.push.core.i.a.d dVar, android.graphics.Bitmap bitmap) {
        this(dVar, bitmap, (byte) 0);
    }

    private h(com.igexin.push.core.i.a.d dVar, android.graphics.Bitmap bitmap, byte b2) {
        this.b = new java.util.ArrayList();
        this.m = new android.os.Handler(android.os.Looper.getMainLooper(), new com.igexin.push.core.i.a.h.c());
        this.a = dVar;
        this.h = (android.graphics.Bitmap) com.igexin.push.core.i.a.k.a(bitmap);
        this.j = com.igexin.push.core.i.a.k.a(bitmap);
        this.k = bitmap.getWidth();
        this.l = bitmap.getHeight();
    }

    private void a(android.graphics.Bitmap bitmap) {
        this.h = (android.graphics.Bitmap) com.igexin.push.core.i.a.k.a(bitmap);
        this.j = com.igexin.push.core.i.a.k.a(bitmap);
        this.k = bitmap.getWidth();
        this.l = bitmap.getHeight();
    }

    private android.graphics.Bitmap c() {
        return this.h;
    }

    private int d() {
        return this.k;
    }

    private int e() {
        return this.l;
    }

    private int f() {
        return this.a.m() + this.j;
    }

    private int g() {
        com.igexin.push.core.i.a.h.a aVar = this.e;
        if (aVar != null) {
            return aVar.a;
        }
        return -1;
    }

    private java.nio.ByteBuffer h() {
        return this.a.c().asReadOnlyBuffer();
    }

    private int i() {
        return this.a.l();
    }

    private void j() {
        if (this.c) {
            return;
        }
        this.c = true;
        this.f = false;
        n();
    }

    private void k() {
        this.c = false;
    }

    private void l() {
        this.b.clear();
        b();
        this.c = false;
        if (this.e != null) {
            this.e = null;
        }
        if (this.g != null) {
            this.g = null;
        }
        if (this.i != null) {
            this.i = null;
        }
        this.a.o();
        this.f = true;
    }

    private android.graphics.Bitmap m() {
        com.igexin.push.core.i.a.h.a aVar = this.e;
        return aVar != null ? aVar.b : this.h;
    }

    private void n() {
        if (!this.c || this.n) {
            return;
        }
        if (this.d) {
            com.igexin.push.core.i.a.k.a(this.i == null, "Pending target must be null when starting from the first frame");
            this.a.i();
            this.d = false;
        }
        com.igexin.push.core.i.a.h.a aVar = this.i;
        if (aVar != null) {
            this.i = null;
            a(aVar);
            return;
        }
        this.n = true;
        long uptimeMillis = android.os.SystemClock.uptimeMillis() + this.a.f();
        this.a.e();
        this.g = new com.igexin.push.core.i.a.h.a(this.m, this.a.h(), uptimeMillis);
        android.graphics.Bitmap n = this.a.n();
        com.igexin.push.core.i.a.k.a(n != null, "nextFrame is null");
        this.g.a(n);
    }

    private void o() {
        com.igexin.push.core.i.a.k.a(!this.c, "Can't restart a running animation");
        this.d = true;
        if (this.i != null) {
            this.i = null;
        }
    }

    public final int a() {
        return this.a.g();
    }

    public final void a(com.igexin.push.core.i.a.h.a aVar) {
        this.n = false;
        if (!this.f) {
            if (this.c) {
                if (aVar.b != null) {
                    b();
                    com.igexin.push.core.i.a.h.a aVar2 = this.e;
                    this.e = aVar;
                    for (int size = this.b.size() - 1; size >= 0; size--) {
                        this.b.get(size).b();
                    }
                    if (aVar2 != null) {
                        this.m.obtainMessage(2, aVar2).sendToTarget();
                    }
                }
                n();
                return;
            }
            if (!this.d) {
                this.i = aVar;
                return;
            }
        }
        this.m.obtainMessage(2, aVar).sendToTarget();
    }

    public final void a(com.igexin.push.core.i.a.h.b bVar) {
        if (this.f) {
            throw new java.lang.IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        if (this.b.contains(bVar)) {
            throw new java.lang.IllegalStateException("Cannot subscribe twice in a row");
        }
        boolean isEmpty = this.b.isEmpty();
        this.b.add(bVar);
        if (isEmpty) {
            j();
        }
    }

    public final void b() {
        if (this.h != null) {
            this.h = null;
        }
    }

    public final void b(com.igexin.push.core.i.a.h.b bVar) {
        this.b.remove(bVar);
        if (this.b.isEmpty()) {
            this.c = false;
        }
    }
}
