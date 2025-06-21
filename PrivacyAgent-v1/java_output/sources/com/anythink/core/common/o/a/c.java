package com.anythink.core.common.o.a;

/* loaded from: classes12.dex */
public class c {
    private final com.anythink.core.common.o.a.f a;
    private final java.util.Map<android.view.View, com.anythink.core.common.o.a.b> b;
    private final java.util.Map<android.view.View, com.anythink.core.common.o.a.d<com.anythink.core.common.o.a.b>> c;
    private final com.anythink.core.common.o.a.f.b d;
    private com.anythink.core.common.o.a.f.d e;

    /* renamed from: com.anythink.core.common.o.a.c$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.core.common.o.a.f.d {
        public AnonymousClass1() {
        }

        @Override // com.anythink.core.common.o.a.f.d
        public final void a(java.util.List<android.view.View> list) {
            for (android.view.View view : list) {
                com.anythink.core.common.o.a.b bVar = (com.anythink.core.common.o.a.b) com.anythink.core.common.o.a.c.this.b.get(view);
                if (bVar == null) {
                    com.anythink.core.common.o.a.c.this.a(view);
                } else {
                    bVar.recordImpression(view);
                    bVar.setImpressionRecorded();
                }
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c() {
        this(r0, r1, r2, r3);
        java.util.WeakHashMap weakHashMap = new java.util.WeakHashMap();
        java.util.WeakHashMap weakHashMap2 = new java.util.WeakHashMap();
        com.anythink.core.common.o.a.f.b bVar = new com.anythink.core.common.o.a.f.b();
        com.anythink.core.common.o.a.f fVar = new com.anythink.core.common.o.a.f();
        new android.os.Handler(android.os.Looper.getMainLooper());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c(int i) {
        this(r0, r1, r2, r3);
        java.util.WeakHashMap weakHashMap = new java.util.WeakHashMap();
        java.util.WeakHashMap weakHashMap2 = new java.util.WeakHashMap();
        com.anythink.core.common.o.a.f.b bVar = new com.anythink.core.common.o.a.f.b();
        com.anythink.core.common.o.a.f fVar = new com.anythink.core.common.o.a.f(i);
        new android.os.Handler(android.os.Looper.getMainLooper());
    }

    private c(java.util.Map<android.view.View, com.anythink.core.common.o.a.b> map, java.util.Map<android.view.View, com.anythink.core.common.o.a.d<com.anythink.core.common.o.a.b>> map2, com.anythink.core.common.o.a.f.b bVar, com.anythink.core.common.o.a.f fVar) {
        this.b = map;
        this.c = map2;
        this.d = bVar;
        this.a = fVar;
        com.anythink.core.common.o.a.c.AnonymousClass1 anonymousClass1 = new com.anythink.core.common.o.a.c.AnonymousClass1();
        this.e = anonymousClass1;
        fVar.a(anonymousClass1);
    }

    private void b(android.view.View view) {
        this.c.remove(view);
    }

    @java.lang.Deprecated
    private com.anythink.core.common.o.a.f.d c() {
        return this.e;
    }

    public final void a() {
        this.b.clear();
        this.c.clear();
        this.a.a();
    }

    public final void a(android.view.View view) {
        this.b.remove(view);
        b(view);
        this.a.a(view);
    }

    public final void a(android.view.View view, com.anythink.core.common.o.a.b bVar) {
        if (this.b.get(view) == bVar) {
            return;
        }
        a(view);
        if (bVar.isImpressionRecorded()) {
            return;
        }
        this.b.put(view, bVar);
        com.anythink.core.common.o.a.f fVar = this.a;
        int impressionMinPercentageViewed = bVar.getImpressionMinPercentageViewed();
        fVar.a(view, view, impressionMinPercentageViewed, impressionMinPercentageViewed, bVar.getImpressionMinVisiblePx());
    }

    public final void b() {
        a();
        this.a.b();
        this.e = null;
    }
}
