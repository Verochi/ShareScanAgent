package com.anythink.expressad.exoplayer.h;

/* loaded from: classes12.dex */
public final class v extends com.anythink.expressad.exoplayer.h.f<java.lang.Integer> {
    private static final int a = -1;
    private final com.anythink.expressad.exoplayer.h.s[] b;
    private final java.util.ArrayList<com.anythink.expressad.exoplayer.h.s> c;
    private final com.anythink.expressad.exoplayer.h.h d;
    private com.anythink.expressad.exoplayer.ae e;
    private java.lang.Object f;
    private int g;
    private com.anythink.expressad.exoplayer.h.v.a h;

    public static final class a extends java.io.IOException {
        public static final int a = 0;
        public final int b = 0;

        @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
        /* renamed from: com.anythink.expressad.exoplayer.h.v$a$a, reason: collision with other inner class name */
        public @interface InterfaceC0199a {
        }
    }

    private v(com.anythink.expressad.exoplayer.h.h hVar, com.anythink.expressad.exoplayer.h.s... sVarArr) {
        this.b = sVarArr;
        this.d = hVar;
        this.c = new java.util.ArrayList<>(java.util.Arrays.asList(sVarArr));
        this.g = -1;
    }

    private v(com.anythink.expressad.exoplayer.h.s... sVarArr) {
        this(new com.anythink.expressad.exoplayer.h.j(), sVarArr);
    }

    private com.anythink.expressad.exoplayer.h.v.a a(com.anythink.expressad.exoplayer.ae aeVar) {
        if (this.g == -1) {
            this.g = aeVar.c();
            return null;
        }
        if (aeVar.c() != this.g) {
            return new com.anythink.expressad.exoplayer.h.v.a();
        }
        return null;
    }

    private void a(com.anythink.expressad.exoplayer.h.s sVar, com.anythink.expressad.exoplayer.ae aeVar, @androidx.annotation.Nullable java.lang.Object obj) {
        com.anythink.expressad.exoplayer.h.v.a aVar;
        if (this.h == null) {
            if (this.g == -1) {
                this.g = aeVar.c();
            } else if (aeVar.c() != this.g) {
                aVar = new com.anythink.expressad.exoplayer.h.v.a();
                this.h = aVar;
            }
            aVar = null;
            this.h = aVar;
        }
        if (this.h != null) {
            return;
        }
        this.c.remove(sVar);
        if (sVar == this.b[0]) {
            this.e = aeVar;
            this.f = obj;
        }
        if (this.c.isEmpty()) {
            a(this.e, this.f);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final com.anythink.expressad.exoplayer.h.r a(com.anythink.expressad.exoplayer.h.s.a aVar, com.anythink.expressad.exoplayer.j.b bVar) {
        int length = this.b.length;
        com.anythink.expressad.exoplayer.h.r[] rVarArr = new com.anythink.expressad.exoplayer.h.r[length];
        for (int i = 0; i < length; i++) {
            rVarArr[i] = this.b[i].a(aVar, bVar);
        }
        return new com.anythink.expressad.exoplayer.h.u(this.d, rVarArr);
    }

    @Override // com.anythink.expressad.exoplayer.h.f, com.anythink.expressad.exoplayer.h.c
    public final void a() {
        super.a();
        this.e = null;
        this.f = null;
        this.g = -1;
        this.h = null;
        this.c.clear();
        java.util.Collections.addAll(this.c, this.b);
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final void a(com.anythink.expressad.exoplayer.h.r rVar) {
        com.anythink.expressad.exoplayer.h.u uVar = (com.anythink.expressad.exoplayer.h.u) rVar;
        int i = 0;
        while (true) {
            com.anythink.expressad.exoplayer.h.s[] sVarArr = this.b;
            if (i >= sVarArr.length) {
                return;
            }
            sVarArr[i].a(uVar.a[i]);
            i++;
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.f, com.anythink.expressad.exoplayer.h.c
    public final void a(com.anythink.expressad.exoplayer.h hVar, boolean z) {
        super.a(hVar, z);
        for (int i = 0; i < this.b.length; i++) {
            a((com.anythink.expressad.exoplayer.h.v) java.lang.Integer.valueOf(i), this.b[i]);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.f
    public final /* synthetic */ void a(java.lang.Integer num, com.anythink.expressad.exoplayer.h.s sVar, com.anythink.expressad.exoplayer.ae aeVar, @androidx.annotation.Nullable java.lang.Object obj) {
        com.anythink.expressad.exoplayer.h.v.a aVar;
        if (this.h == null) {
            if (this.g == -1) {
                this.g = aeVar.c();
            } else if (aeVar.c() != this.g) {
                aVar = new com.anythink.expressad.exoplayer.h.v.a();
                this.h = aVar;
            }
            aVar = null;
            this.h = aVar;
        }
        if (this.h == null) {
            this.c.remove(sVar);
            if (sVar == this.b[0]) {
                this.e = aeVar;
                this.f = obj;
            }
            if (this.c.isEmpty()) {
                a(this.e, this.f);
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.f, com.anythink.expressad.exoplayer.h.s
    public final void b() {
        com.anythink.expressad.exoplayer.h.v.a aVar = this.h;
        if (aVar != null) {
            throw aVar;
        }
        super.b();
    }
}
