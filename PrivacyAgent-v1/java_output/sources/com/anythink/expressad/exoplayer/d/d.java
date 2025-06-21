package com.anythink.expressad.exoplayer.d;

@android.annotation.TargetApi(18)
/* loaded from: classes12.dex */
public final class d<T extends com.anythink.expressad.exoplayer.d.i> implements com.anythink.expressad.exoplayer.d.b.c<T>, com.anythink.expressad.exoplayer.d.g<T> {
    public static final java.lang.String a = "PRCustomData";
    public static final int b = 0;
    public static final int c = 1;
    public static final int d = 2;
    public static final int e = 3;
    public static final int f = 3;
    private static final java.lang.String h = "DefaultDrmSessionMgr";
    volatile com.anythink.expressad.exoplayer.d.d<T>.c g;
    private final java.util.UUID i;
    private final com.anythink.expressad.exoplayer.d.j<T> j;
    private final com.anythink.expressad.exoplayer.d.n k;
    private final java.util.HashMap<java.lang.String, java.lang.String> l;
    private final com.anythink.expressad.exoplayer.d.c.a m;
    private final boolean n;
    private final int o;
    private final java.util.List<com.anythink.expressad.exoplayer.d.b<T>> p;
    private final java.util.List<com.anythink.expressad.exoplayer.d.b<T>> q;
    private android.os.Looper r;

    /* renamed from: s, reason: collision with root package name */
    private int f212s;
    private byte[] t;

    @java.lang.Deprecated
    public interface a extends com.anythink.expressad.exoplayer.d.c {
    }

    public class b implements com.anythink.expressad.exoplayer.d.j.f<T> {
        private b() {
        }

        public /* synthetic */ b(com.anythink.expressad.exoplayer.d.d dVar, byte b) {
            this();
        }

        @Override // com.anythink.expressad.exoplayer.d.j.f
        public final void a(byte[] bArr, int i) {
            if (com.anythink.expressad.exoplayer.d.d.this.f212s == 0) {
                com.anythink.expressad.exoplayer.d.d.this.g.obtainMessage(i, bArr).sendToTarget();
            }
        }
    }

    @android.annotation.SuppressLint({"HandlerLeak"})
    public class c extends android.os.Handler {
        public c(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(android.os.Message message) {
            byte[] bArr = (byte[]) message.obj;
            for (com.anythink.expressad.exoplayer.d.b bVar : com.anythink.expressad.exoplayer.d.d.this.p) {
                if (bVar.b(bArr)) {
                    bVar.a(message.what);
                    return;
                }
            }
        }
    }

    /* renamed from: com.anythink.expressad.exoplayer.d.d$d, reason: collision with other inner class name */
    public static final class C0189d extends java.lang.Exception {
        private C0189d(java.util.UUID uuid) {
            super("Media does not support uuid: ".concat(java.lang.String.valueOf(uuid)));
        }

        public /* synthetic */ C0189d(java.util.UUID uuid, byte b) {
            this(uuid);
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface e {
    }

    private d(java.util.UUID uuid, com.anythink.expressad.exoplayer.d.j<T> jVar, com.anythink.expressad.exoplayer.d.n nVar, java.util.HashMap<java.lang.String, java.lang.String> hashMap) {
        this(uuid, (com.anythink.expressad.exoplayer.d.j) jVar, nVar, hashMap, false, 3);
    }

    @java.lang.Deprecated
    private d(java.util.UUID uuid, com.anythink.expressad.exoplayer.d.j<T> jVar, com.anythink.expressad.exoplayer.d.n nVar, java.util.HashMap<java.lang.String, java.lang.String> hashMap, android.os.Handler handler, com.anythink.expressad.exoplayer.d.c cVar) {
        this(uuid, jVar, nVar, hashMap);
        if (handler == null || cVar == null) {
            return;
        }
        a(handler, cVar);
    }

    @java.lang.Deprecated
    private d(java.util.UUID uuid, com.anythink.expressad.exoplayer.d.j<T> jVar, com.anythink.expressad.exoplayer.d.n nVar, java.util.HashMap<java.lang.String, java.lang.String> hashMap, android.os.Handler handler, com.anythink.expressad.exoplayer.d.c cVar, boolean z) {
        this(uuid, jVar, nVar, hashMap, z);
        if (handler == null || cVar == null) {
            return;
        }
        a(handler, cVar);
    }

    @java.lang.Deprecated
    private d(java.util.UUID uuid, com.anythink.expressad.exoplayer.d.j<T> jVar, com.anythink.expressad.exoplayer.d.n nVar, java.util.HashMap<java.lang.String, java.lang.String> hashMap, android.os.Handler handler, com.anythink.expressad.exoplayer.d.c cVar, boolean z, int i) {
        this(uuid, jVar, nVar, hashMap, z, i);
        if (handler == null || cVar == null) {
            return;
        }
        a(handler, cVar);
    }

    private d(java.util.UUID uuid, com.anythink.expressad.exoplayer.d.j<T> jVar, com.anythink.expressad.exoplayer.d.n nVar, java.util.HashMap<java.lang.String, java.lang.String> hashMap, boolean z) {
        this(uuid, jVar, nVar, hashMap, z, 3);
    }

    private d(java.util.UUID uuid, com.anythink.expressad.exoplayer.d.j<T> jVar, com.anythink.expressad.exoplayer.d.n nVar, java.util.HashMap<java.lang.String, java.lang.String> hashMap, boolean z, int i) {
        com.anythink.expressad.exoplayer.k.a.a(uuid);
        com.anythink.expressad.exoplayer.k.a.a(jVar);
        com.anythink.expressad.exoplayer.k.a.a(!com.anythink.expressad.exoplayer.b.bi.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.i = uuid;
        this.j = jVar;
        this.k = nVar;
        this.l = hashMap;
        this.m = new com.anythink.expressad.exoplayer.d.c.a();
        this.n = z;
        this.o = i;
        this.f212s = 0;
        this.p = new java.util.ArrayList();
        this.q = new java.util.ArrayList();
        if (z) {
            jVar.a("sessionSharing", "enable");
        }
        jVar.a(new com.anythink.expressad.exoplayer.d.d.b(this, (byte) 0));
    }

    private static com.anythink.expressad.exoplayer.d.d<com.anythink.expressad.exoplayer.d.k> a(com.anythink.expressad.exoplayer.d.n nVar, java.lang.String str) {
        java.util.HashMap hashMap;
        if (android.text.TextUtils.isEmpty(str)) {
            hashMap = null;
        } else {
            hashMap = new java.util.HashMap();
            hashMap.put("PRCustomData", str);
        }
        return a(com.anythink.expressad.exoplayer.b.bl, nVar, (java.util.HashMap<java.lang.String, java.lang.String>) hashMap);
    }

    @java.lang.Deprecated
    private static com.anythink.expressad.exoplayer.d.d<com.anythink.expressad.exoplayer.d.k> a(com.anythink.expressad.exoplayer.d.n nVar, java.lang.String str, android.os.Handler handler, com.anythink.expressad.exoplayer.d.c cVar) {
        java.util.HashMap hashMap;
        if (android.text.TextUtils.isEmpty(str)) {
            hashMap = null;
        } else {
            hashMap = new java.util.HashMap();
            hashMap.put("PRCustomData", str);
        }
        com.anythink.expressad.exoplayer.d.d<com.anythink.expressad.exoplayer.d.k> a2 = a(com.anythink.expressad.exoplayer.b.bl, nVar, (java.util.HashMap<java.lang.String, java.lang.String>) hashMap);
        if (handler != null && cVar != null) {
            a2.a(handler, cVar);
        }
        return a2;
    }

    private static com.anythink.expressad.exoplayer.d.d<com.anythink.expressad.exoplayer.d.k> a(com.anythink.expressad.exoplayer.d.n nVar, java.util.HashMap<java.lang.String, java.lang.String> hashMap) {
        return a(com.anythink.expressad.exoplayer.b.bk, nVar, hashMap);
    }

    @java.lang.Deprecated
    private static com.anythink.expressad.exoplayer.d.d<com.anythink.expressad.exoplayer.d.k> a(com.anythink.expressad.exoplayer.d.n nVar, java.util.HashMap<java.lang.String, java.lang.String> hashMap, android.os.Handler handler, com.anythink.expressad.exoplayer.d.c cVar) {
        com.anythink.expressad.exoplayer.d.d<com.anythink.expressad.exoplayer.d.k> a2 = a(com.anythink.expressad.exoplayer.b.bk, nVar, hashMap);
        if (handler != null && cVar != null) {
            a2.a(handler, cVar);
        }
        return a2;
    }

    private static com.anythink.expressad.exoplayer.d.d<com.anythink.expressad.exoplayer.d.k> a(java.util.UUID uuid, com.anythink.expressad.exoplayer.d.n nVar, java.util.HashMap<java.lang.String, java.lang.String> hashMap) {
        return new com.anythink.expressad.exoplayer.d.d<>(uuid, (com.anythink.expressad.exoplayer.d.j) com.anythink.expressad.exoplayer.d.l.a(uuid), nVar, hashMap, false, 3);
    }

    @java.lang.Deprecated
    private static com.anythink.expressad.exoplayer.d.d<com.anythink.expressad.exoplayer.d.k> a(java.util.UUID uuid, com.anythink.expressad.exoplayer.d.n nVar, java.util.HashMap<java.lang.String, java.lang.String> hashMap, android.os.Handler handler, com.anythink.expressad.exoplayer.d.c cVar) {
        com.anythink.expressad.exoplayer.d.d<com.anythink.expressad.exoplayer.d.k> a2 = a(uuid, nVar, hashMap);
        if (handler != null && cVar != null) {
            a2.a(handler, cVar);
        }
        return a2;
    }

    private static com.anythink.expressad.exoplayer.d.e.a a(com.anythink.expressad.exoplayer.d.e eVar, java.util.UUID uuid, boolean z) {
        java.util.ArrayList arrayList = new java.util.ArrayList(eVar.b);
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= eVar.b) {
                break;
            }
            com.anythink.expressad.exoplayer.d.e.a a2 = eVar.a(i);
            if (!a2.a(uuid) && (!com.anythink.expressad.exoplayer.b.bj.equals(uuid) || !a2.a(com.anythink.expressad.exoplayer.b.bi))) {
                z2 = false;
            }
            if (z2 && (a2.c != null || z)) {
                arrayList.add(a2);
            }
            i++;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (com.anythink.expressad.exoplayer.b.bk.equals(uuid)) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                com.anythink.expressad.exoplayer.d.e.a aVar = (com.anythink.expressad.exoplayer.d.e.a) arrayList.get(i2);
                int b2 = aVar.a() ? com.anythink.expressad.exoplayer.e.a.h.b(aVar.c) : -1;
                int i3 = com.anythink.expressad.exoplayer.k.af.a;
                if (i3 < 23 && b2 == 0) {
                    return aVar;
                }
                if (i3 >= 23 && b2 == 1) {
                    return aVar;
                }
            }
        }
        return (com.anythink.expressad.exoplayer.d.e.a) arrayList.get(0);
    }

    private java.lang.String a(java.lang.String str) {
        return this.j.a(str);
    }

    private void a(int i, byte[] bArr) {
        com.anythink.expressad.exoplayer.k.a.b(this.p.isEmpty());
        if (i == 1 || i == 3) {
            com.anythink.expressad.exoplayer.k.a.a(bArr);
        }
        this.f212s = i;
        this.t = bArr;
    }

    private void a(com.anythink.expressad.exoplayer.d.c cVar) {
        this.m.a(cVar);
    }

    private void a(java.lang.String str, java.lang.String str2) {
        this.j.a(str, str2);
    }

    private void a(java.lang.String str, byte[] bArr) {
        this.j.a(str, bArr);
    }

    private byte[] b(java.lang.String str) {
        return this.j.b(str);
    }

    @Override // com.anythink.expressad.exoplayer.d.g
    public final com.anythink.expressad.exoplayer.d.f<T> a(android.os.Looper looper, com.anythink.expressad.exoplayer.d.e eVar) {
        com.anythink.expressad.exoplayer.d.e.a aVar;
        android.os.Looper looper2 = this.r;
        com.anythink.expressad.exoplayer.k.a.b(looper2 == null || looper2 == looper);
        if (this.p.isEmpty()) {
            this.r = looper;
            if (this.g == null) {
                this.g = new com.anythink.expressad.exoplayer.d.d.c(looper);
            }
        }
        com.anythink.expressad.exoplayer.d.b<T> bVar = null;
        if (this.t == null) {
            com.anythink.expressad.exoplayer.d.e.a a2 = a(eVar, this.i, false);
            if (a2 == null) {
                com.anythink.expressad.exoplayer.d.d.C0189d c0189d = new com.anythink.expressad.exoplayer.d.d.C0189d(this.i, (byte) 0);
                this.m.a(c0189d);
                return new com.anythink.expressad.exoplayer.d.h(new com.anythink.expressad.exoplayer.d.f.a(c0189d));
            }
            aVar = a2;
        } else {
            aVar = null;
        }
        if (this.n) {
            byte[] bArr = aVar != null ? aVar.c : null;
            java.util.Iterator<com.anythink.expressad.exoplayer.d.b<T>> it = this.p.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.anythink.expressad.exoplayer.d.b<T> next = it.next();
                if (next.a(bArr)) {
                    bVar = next;
                    break;
                }
            }
        } else if (!this.p.isEmpty()) {
            bVar = this.p.get(0);
        }
        if (bVar == null) {
            com.anythink.expressad.exoplayer.d.b<T> bVar2 = new com.anythink.expressad.exoplayer.d.b<>(this.i, this.j, this, aVar, this.f212s, this.t, this.l, this.k, looper, this.m, this.o);
            this.p.add(bVar2);
            bVar = bVar2;
        }
        bVar.a();
        return bVar;
    }

    @Override // com.anythink.expressad.exoplayer.d.b.c
    public final void a() {
        java.util.Iterator<com.anythink.expressad.exoplayer.d.b<T>> it = this.q.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
        this.q.clear();
    }

    public final void a(android.os.Handler handler, com.anythink.expressad.exoplayer.d.c cVar) {
        this.m.a(handler, cVar);
    }

    @Override // com.anythink.expressad.exoplayer.d.b.c
    public final void a(com.anythink.expressad.exoplayer.d.b<T> bVar) {
        this.q.add(bVar);
        if (this.q.size() == 1) {
            bVar.c();
        }
    }

    @Override // com.anythink.expressad.exoplayer.d.g
    public final void a(com.anythink.expressad.exoplayer.d.f<T> fVar) {
        if (fVar instanceof com.anythink.expressad.exoplayer.d.h) {
            return;
        }
        com.anythink.expressad.exoplayer.d.b<T> bVar = (com.anythink.expressad.exoplayer.d.b) fVar;
        if (bVar.b()) {
            this.p.remove(bVar);
            if (this.q.size() > 1 && this.q.get(0) == bVar) {
                this.q.get(1).c();
            }
            this.q.remove(bVar);
        }
    }

    @Override // com.anythink.expressad.exoplayer.d.b.c
    public final void a(java.lang.Exception exc) {
        java.util.Iterator<com.anythink.expressad.exoplayer.d.b<T>> it = this.q.iterator();
        while (it.hasNext()) {
            it.next().a(exc);
        }
        this.q.clear();
    }

    @Override // com.anythink.expressad.exoplayer.d.g
    public final boolean a(@androidx.annotation.NonNull com.anythink.expressad.exoplayer.d.e eVar) {
        if (this.t != null) {
            return true;
        }
        if (a(eVar, this.i, true) == null) {
            if (eVar.b != 1 || !eVar.a(0).a(com.anythink.expressad.exoplayer.b.bi)) {
                return false;
            }
            new java.lang.StringBuilder("DrmInitData only contains common PSSH SchemeData. Assuming support for: ").append(this.i);
        }
        java.lang.String str = eVar.a;
        if (str == null || "cenc".equals(str)) {
            return true;
        }
        return !("cbc1".equals(str) || "cbcs".equals(str) || "cens".equals(str)) || com.anythink.expressad.exoplayer.k.af.a >= 25;
    }
}
