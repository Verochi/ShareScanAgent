package com.anythink.expressad.exoplayer.d;

@android.annotation.TargetApi(18)
/* loaded from: classes12.dex */
final class b<T extends com.anythink.expressad.exoplayer.d.i> implements com.anythink.expressad.exoplayer.d.f<T> {
    private static final java.lang.String i = "DefaultDrmSession";
    private static final int j = 0;
    private static final int k = 1;
    private static final int l = 60;
    private byte[] A;
    private java.lang.Object B;
    private java.lang.Object C;
    final com.anythink.expressad.exoplayer.d.n a;
    final java.util.UUID b;
    final com.anythink.expressad.exoplayer.d.b<T>.HandlerC0187b c;
    private final com.anythink.expressad.exoplayer.d.j<T> m;
    private final com.anythink.expressad.exoplayer.d.b.c<T> n;
    private final com.anythink.expressad.exoplayer.d.e.a o;
    private final int p;
    private final java.util.HashMap<java.lang.String, java.lang.String> q;
    private final com.anythink.expressad.exoplayer.d.c.a r;

    /* renamed from: s, reason: collision with root package name */
    private final int f211s;
    private int t;
    private int u;
    private android.os.HandlerThread v;
    private com.anythink.expressad.exoplayer.d.b<T>.a w;
    private T x;
    private com.anythink.expressad.exoplayer.d.f.a y;
    private byte[] z;

    @android.annotation.SuppressLint({"HandlerLeak"})
    public class a extends android.os.Handler {
        public a(android.os.Looper looper) {
            super(looper);
        }

        private static long a(int i) {
            return java.lang.Math.min((i - 1) * 1000, 5000);
        }

        private boolean a(android.os.Message message) {
            int i;
            if (!(message.arg1 == 1) || (i = message.arg2 + 1) > com.anythink.expressad.exoplayer.d.b.this.f211s) {
                return false;
            }
            android.os.Message obtain = android.os.Message.obtain(message);
            obtain.arg2 = i;
            sendMessageDelayed(obtain, java.lang.Math.min((i - 1) * 1000, 5000));
            return true;
        }

        public final void a(int i, java.lang.Object obj, boolean z) {
            obtainMessage(i, z ? 1 : 0, 0, obj).sendToTarget();
        }

        @Override // android.os.Handler
        public final void handleMessage(android.os.Message message) {
            int i;
            java.lang.Object obj;
            java.lang.Object obj2 = message.obj;
            boolean z = true;
            try {
                int i2 = message.what;
                if (i2 == 0) {
                    obj = com.anythink.expressad.exoplayer.d.b.this.a.a();
                } else {
                    if (i2 != 1) {
                        throw new java.lang.RuntimeException();
                    }
                    java.lang.Object obj3 = ((android.util.Pair) obj2).first;
                    obj = com.anythink.expressad.exoplayer.d.b.this.a.b();
                }
            } catch (java.lang.Exception e) {
                if ((message.arg1 == 1) && (i = message.arg2 + 1) <= com.anythink.expressad.exoplayer.d.b.this.f211s) {
                    android.os.Message obtain = android.os.Message.obtain(message);
                    obtain.arg2 = i;
                    sendMessageDelayed(obtain, java.lang.Math.min((i - 1) * 1000, 5000));
                } else {
                    z = false;
                }
                if (z) {
                    return;
                } else {
                    obj = e;
                }
            }
            com.anythink.expressad.exoplayer.d.b.this.c.obtainMessage(message.what, android.util.Pair.create(obj2, obj)).sendToTarget();
        }
    }

    @android.annotation.SuppressLint({"HandlerLeak"})
    /* renamed from: com.anythink.expressad.exoplayer.d.b$b, reason: collision with other inner class name */
    public class HandlerC0187b extends android.os.Handler {
        public HandlerC0187b(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(android.os.Message message) {
            android.util.Pair pair = (android.util.Pair) message.obj;
            java.lang.Object obj = pair.first;
            java.lang.Object obj2 = pair.second;
            int i = message.what;
            if (i == 0) {
                com.anythink.expressad.exoplayer.d.b.a(com.anythink.expressad.exoplayer.d.b.this, obj, obj2);
            } else {
                if (i != 1) {
                    return;
                }
                com.anythink.expressad.exoplayer.d.b.b(com.anythink.expressad.exoplayer.d.b.this, obj, obj2);
            }
        }
    }

    public interface c<T extends com.anythink.expressad.exoplayer.d.i> {
        void a();

        void a(com.anythink.expressad.exoplayer.d.b<T> bVar);

        void a(java.lang.Exception exc);
    }

    public b(java.util.UUID uuid, com.anythink.expressad.exoplayer.d.j<T> jVar, com.anythink.expressad.exoplayer.d.b.c<T> cVar, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.d.e.a aVar, int i2, @androidx.annotation.Nullable byte[] bArr, java.util.HashMap<java.lang.String, java.lang.String> hashMap, com.anythink.expressad.exoplayer.d.n nVar, android.os.Looper looper, com.anythink.expressad.exoplayer.d.c.a aVar2, int i3) {
        this.b = uuid;
        this.n = cVar;
        this.m = jVar;
        this.p = i2;
        this.A = bArr;
        this.o = bArr != null ? null : aVar;
        this.q = hashMap;
        this.a = nVar;
        this.f211s = i3;
        this.r = aVar2;
        this.t = 2;
        this.c = new com.anythink.expressad.exoplayer.d.b.HandlerC0187b(looper);
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("DrmRequestHandler");
        this.v = handlerThread;
        handlerThread.start();
        this.w = new com.anythink.expressad.exoplayer.d.b.a(this.v.getLooper());
    }

    private void a(int i2, boolean z) {
        java.lang.String str;
        byte[] bArr;
        java.lang.String str2;
        byte[] bArr2 = i2 == 3 ? this.A : this.z;
        com.anythink.expressad.exoplayer.d.e.a aVar = this.o;
        if (aVar != null) {
            byte[] bArr3 = aVar.c;
            java.lang.String str3 = aVar.b;
            str = aVar.a;
            str2 = str3;
            bArr = bArr3;
        } else {
            str = null;
            bArr = null;
            str2 = null;
        }
        try {
            android.util.Pair create = android.util.Pair.create(this.m.a(bArr2, bArr, str2, i2, this.q), str);
            this.B = create;
            this.w.a(1, create, z);
        } catch (java.lang.Exception e) {
            b(e);
        }
    }

    public static /* synthetic */ void a(com.anythink.expressad.exoplayer.d.b bVar, java.lang.Object obj, java.lang.Object obj2) {
        if (obj == bVar.C) {
            if (bVar.t == 2 || bVar.n()) {
                bVar.C = null;
                if (obj2 instanceof java.lang.Exception) {
                    bVar.n.a((java.lang.Exception) obj2);
                    return;
                }
                try {
                    bVar.m.b((byte[]) obj2);
                    bVar.n.a();
                } catch (java.lang.Exception e) {
                    bVar.n.a(e);
                }
            }
        }
    }

    private void a(java.lang.Object obj, java.lang.Object obj2) {
        if (obj == this.C) {
            if (this.t == 2 || n()) {
                this.C = null;
                if (obj2 instanceof java.lang.Exception) {
                    this.n.a((java.lang.Exception) obj2);
                    return;
                }
                try {
                    this.m.b((byte[]) obj2);
                    this.n.a();
                } catch (java.lang.Exception e) {
                    this.n.a(e);
                }
            }
        }
    }

    private void a(boolean z) {
        int i2 = this.p;
        if (i2 != 0 && i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3 && k()) {
                    a(3, z);
                    return;
                }
                return;
            }
            if (this.A == null) {
                a(2, z);
                return;
            } else {
                if (k()) {
                    a(2, z);
                    return;
                }
                return;
            }
        }
        if (this.A == null) {
            a(1, z);
            return;
        }
        if (this.t == 4 || k()) {
            long l2 = l();
            if (this.p == 0 && l2 <= 60) {
                "Offline license has expired or will expire soon. Remaining seconds: ".concat(java.lang.String.valueOf(l2));
                a(2, z);
            } else if (l2 <= 0) {
                c(new com.anythink.expressad.exoplayer.d.m());
            } else {
                this.t = 4;
                this.r.b();
            }
        }
    }

    public static /* synthetic */ void b(com.anythink.expressad.exoplayer.d.b bVar, java.lang.Object obj, java.lang.Object obj2) {
        if (obj == bVar.B && bVar.n()) {
            bVar.B = null;
            if (obj2 instanceof java.lang.Exception) {
                bVar.b((java.lang.Exception) obj2);
                return;
            }
            try {
                byte[] bArr = (byte[]) obj2;
                if (bVar.p == 3) {
                    bVar.m.a(bVar.A, bArr);
                    bVar.r.c();
                    return;
                }
                byte[] a2 = bVar.m.a(bVar.z, bArr);
                int i2 = bVar.p;
                if ((i2 == 2 || (i2 == 0 && bVar.A != null)) && a2 != null && a2.length != 0) {
                    bVar.A = a2;
                }
                bVar.t = 4;
                bVar.r.a();
            } catch (java.lang.Exception e) {
                bVar.b(e);
            }
        }
    }

    private void b(java.lang.Exception exc) {
        if (exc instanceof android.media.NotProvisionedException) {
            this.n.a(this);
        } else {
            c(exc);
        }
    }

    private void b(java.lang.Object obj, java.lang.Object obj2) {
        if (obj == this.B && n()) {
            this.B = null;
            if (obj2 instanceof java.lang.Exception) {
                b((java.lang.Exception) obj2);
                return;
            }
            try {
                byte[] bArr = (byte[]) obj2;
                if (this.p == 3) {
                    this.m.a(this.A, bArr);
                    this.r.c();
                    return;
                }
                byte[] a2 = this.m.a(this.z, bArr);
                int i2 = this.p;
                if ((i2 == 2 || (i2 == 0 && this.A != null)) && a2 != null && a2.length != 0) {
                    this.A = a2;
                }
                this.t = 4;
                this.r.a();
            } catch (java.lang.Exception e) {
                b(e);
            }
        }
    }

    private void c(java.lang.Exception exc) {
        this.y = new com.anythink.expressad.exoplayer.d.f.a(exc);
        this.r.a(exc);
        if (this.t != 4) {
            this.t = 1;
        }
    }

    private boolean j() {
        if (n()) {
            return true;
        }
        try {
            byte[] a2 = this.m.a();
            this.z = a2;
            this.x = this.m.d(a2);
            this.t = 3;
            return true;
        } catch (java.lang.Exception e) {
            c(e);
            return false;
        }
    }

    private boolean k() {
        try {
            this.m.b(this.z, this.A);
            return true;
        } catch (java.lang.Exception e) {
            c(e);
            return false;
        }
    }

    private long l() {
        if (!com.anythink.expressad.exoplayer.b.bk.equals(this.b)) {
            return Long.MAX_VALUE;
        }
        android.util.Pair<java.lang.Long, java.lang.Long> a2 = com.anythink.expressad.exoplayer.d.p.a(this);
        return java.lang.Math.min(((java.lang.Long) a2.first).longValue(), ((java.lang.Long) a2.second).longValue());
    }

    private void m() {
        if (this.t == 4) {
            this.t = 3;
            c(new com.anythink.expressad.exoplayer.d.m());
        }
    }

    private boolean n() {
        int i2 = this.t;
        return i2 == 3 || i2 == 4;
    }

    public final void a() {
        int i2 = this.u + 1;
        this.u = i2;
        if (i2 == 1 && this.t != 1 && j()) {
            a(true);
        }
    }

    public final void a(int i2) {
        if (n()) {
            if (i2 == 1) {
                this.t = 3;
                this.n.a(this);
            } else if (i2 == 2) {
                a(false);
            } else if (i2 == 3 && this.t == 4) {
                this.t = 3;
                c(new com.anythink.expressad.exoplayer.d.m());
            }
        }
    }

    public final void a(java.lang.Exception exc) {
        c(exc);
    }

    public final boolean a(byte[] bArr) {
        com.anythink.expressad.exoplayer.d.e.a aVar = this.o;
        return java.util.Arrays.equals(aVar != null ? aVar.c : null, bArr);
    }

    public final boolean b() {
        int i2 = this.u - 1;
        this.u = i2;
        if (i2 != 0) {
            return false;
        }
        this.t = 0;
        this.c.removeCallbacksAndMessages(null);
        this.w.removeCallbacksAndMessages(null);
        this.w = null;
        this.v.quit();
        this.v = null;
        this.x = null;
        this.y = null;
        this.B = null;
        this.C = null;
        byte[] bArr = this.z;
        if (bArr != null) {
            this.m.a(bArr);
            this.z = null;
        }
        return true;
    }

    public final boolean b(byte[] bArr) {
        return java.util.Arrays.equals(this.z, bArr);
    }

    public final void c() {
        com.anythink.expressad.exoplayer.d.j.h b = this.m.b();
        this.C = b;
        this.w.a(0, b, true);
    }

    public final void d() {
        if (j()) {
            a(true);
        }
    }

    @Override // com.anythink.expressad.exoplayer.d.f
    public final int e() {
        return this.t;
    }

    @Override // com.anythink.expressad.exoplayer.d.f
    public final com.anythink.expressad.exoplayer.d.f.a f() {
        if (this.t == 1) {
            return this.y;
        }
        return null;
    }

    @Override // com.anythink.expressad.exoplayer.d.f
    public final T g() {
        return this.x;
    }

    @Override // com.anythink.expressad.exoplayer.d.f
    public final java.util.Map<java.lang.String, java.lang.String> h() {
        byte[] bArr = this.z;
        if (bArr == null) {
            return null;
        }
        return this.m.c(bArr);
    }

    @Override // com.anythink.expressad.exoplayer.d.f
    public final byte[] i() {
        return this.A;
    }
}
