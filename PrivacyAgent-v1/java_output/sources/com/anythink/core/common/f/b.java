package com.anythink.core.common.f;

/* loaded from: classes12.dex */
public class b implements java.lang.Comparable<com.anythink.core.common.f.b> {
    private int b;
    private long c;
    private com.anythink.core.api.ATBaseAdAdapter d;
    private com.anythink.core.api.BaseAd e;
    private int f;
    private long g;
    private int h;
    private long i;
    private boolean j;
    private java.lang.String a = getClass().getSimpleName();
    private java.lang.String k = "1";

    /* renamed from: com.anythink.core.common.f.b$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (com.anythink.core.common.f.b.this.f <= 0) {
                    if (com.anythink.core.common.f.b.this.d != null) {
                        com.anythink.core.common.f.b.this.d.internalDestory();
                    }
                    if (com.anythink.core.common.f.b.this.e != null) {
                        com.anythink.core.common.f.b.this.e.destroy();
                    }
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    private int d(com.anythink.core.common.f.b bVar) {
        com.anythink.core.common.f.au unitGroupInfo = this.d.getUnitGroupInfo();
        com.anythink.core.common.f.au unitGroupInfo2 = bVar.d.getUnitGroupInfo();
        if (com.anythink.core.common.o.h.a(unitGroupInfo) > com.anythink.core.common.o.h.a(unitGroupInfo2)) {
            return -1;
        }
        if (com.anythink.core.common.o.h.a(unitGroupInfo) != com.anythink.core.common.o.h.a(unitGroupInfo2)) {
            return 1;
        }
        int i = unitGroupInfo.n;
        int i2 = unitGroupInfo2.n;
        if (i < i2) {
            return -1;
        }
        if (i != i2) {
            return 1;
        }
        if (b() < bVar.b()) {
            return -1;
        }
        return b() != bVar.b() ? 1 : 0;
    }

    private long o() {
        return this.g;
    }

    private long p() {
        return this.c;
    }

    public final void a(int i) {
        this.f = i;
        if (i > 0) {
            this.h = 0;
        }
    }

    public final void a(long j) {
        this.i = j;
    }

    public final void a(com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter) {
        this.d = aTBaseAdAdapter;
    }

    public final void a(com.anythink.core.api.BaseAd baseAd) {
        this.e = baseAd;
    }

    public final void a(java.lang.String str) {
        this.k = str;
    }

    public final boolean a() {
        return this.h == 1 && java.lang.System.currentTimeMillis() - this.c < this.i;
    }

    public final long b() {
        return this.c + this.i;
    }

    public final void b(long j) {
        this.g = j;
    }

    public final int c() {
        return this.f;
    }

    public final void c(long j) {
        this.h = 1;
        this.c = j;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(com.anythink.core.common.f.b bVar) {
        com.anythink.core.common.f.b bVar2 = bVar;
        com.anythink.core.common.f.au unitGroupInfo = this.d.getUnitGroupInfo();
        com.anythink.core.common.f.au unitGroupInfo2 = bVar2.d.getUnitGroupInfo();
        if (com.anythink.core.common.o.h.a(unitGroupInfo) > com.anythink.core.common.o.h.a(unitGroupInfo2)) {
            return -1;
        }
        if (com.anythink.core.common.o.h.a(unitGroupInfo) != com.anythink.core.common.o.h.a(unitGroupInfo2)) {
            return 1;
        }
        int i = unitGroupInfo.n;
        int i2 = unitGroupInfo2.n;
        if (i < i2) {
            return -1;
        }
        if (i != i2) {
            return 1;
        }
        if (b() < bVar2.b()) {
            return -1;
        }
        return b() != bVar2.b() ? 1 : 0;
    }

    public final com.anythink.core.api.ATBaseAdAdapter d() {
        return this.d;
    }

    public final com.anythink.core.api.BaseAd e() {
        return this.e;
    }

    public final boolean f() {
        try {
        } catch (java.lang.Exception e) {
            new java.lang.StringBuilder("isNetworkAdReady()  >>> ").append(e.getMessage());
        }
        if (this.j || this.f > 0) {
            return false;
        }
        if (this.d != null && this.e != null) {
            return true;
        }
        try {
            if (android.os.Looper.myLooper() == null) {
                android.os.Looper.prepare();
            }
        } catch (java.lang.Throwable unused) {
        }
        com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter = this.d;
        if (aTBaseAdAdapter != null) {
            return aTBaseAdAdapter.internalIsAdReady();
        }
        return false;
    }

    public final boolean g() {
        return this.j;
    }

    public final com.anythink.core.common.f.h h() {
        com.anythink.core.api.BaseAd baseAd = this.e;
        return baseAd != null ? baseAd.getDetail() : this.d.getTrackingInfo();
    }

    public final boolean i() {
        return this.c + this.g > java.lang.System.currentTimeMillis();
    }

    public final boolean j() {
        return i() && f();
    }

    public final java.lang.String k() {
        return this.k;
    }

    public final synchronized void l() {
        if (this.j) {
            return;
        }
        this.j = true;
        if (this.f <= 0) {
            com.anythink.core.common.b.o.a().b(new com.anythink.core.common.f.b.AnonymousClass1());
        }
    }

    public final double m() {
        return com.anythink.core.common.o.h.a(this.d.getUnitGroupInfo());
    }

    public final com.anythink.core.api.ATAdInfo n() {
        com.anythink.core.api.BaseAd baseAd = this.e;
        com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter = this.d;
        if (baseAd != null) {
            return com.anythink.core.common.b.k.a(baseAd);
        }
        if (aTBaseAdAdapter != null) {
            return com.anythink.core.common.b.k.a(aTBaseAdAdapter);
        }
        return null;
    }

    public java.lang.String toString() {
        return "AdCacheInfo{UnitGroupInfo:" + this.d.getUnitGroupInfo().toString() + ", showTime=" + this.f + ", cacheTime=" + this.g + ", upStatus=" + this.h + ", upStatusOutDateTime=" + (this.c + this.i) + ", hasDestroy=" + this.j + '}';
    }
}
