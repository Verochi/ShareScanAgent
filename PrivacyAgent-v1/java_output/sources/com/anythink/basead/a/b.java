package com.anythink.basead.a;

/* loaded from: classes12.dex */
public final class b {
    public static final int A = 8;
    public static final int B = 9;
    public static final int C = 11;
    public static final int D = 12;
    public static final int E = 13;
    public static final int F = 13;
    public static final int G = 14;
    public static final int H = 15;
    public static final int I = 16;
    public static final int J = 17;
    public static final int K = 18;
    public static final int L = 19;
    public static final int M = 20;
    public static final int N = 21;
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 4;
    public static final int e = 6;
    public static final int f = 0;
    public static final int g = 1;
    public static final int h = 1;
    public static final int i = 2;
    public static final int j = 3;
    public static final int k = 4;
    public static final int l = 5;
    public static final int m = 6;
    public static final int n = 7;
    public static final int o = 10;
    public static final int p = 11;
    public static final int q = 12;
    public static final int r = 13;

    /* renamed from: s, reason: collision with root package name */
    public static final int f142s = 13;
    public static final int t = 1;
    public static final int u = 2;
    public static final int v = 3;
    public static final int w = 4;
    public static final int x = 5;
    public static final int y = 6;
    public static final int z = 7;
    com.anythink.core.common.f.l O;
    boolean P;
    boolean Q;
    android.content.Context S;
    boolean T;
    com.anythink.core.common.f.m U;
    com.anythink.basead.a.b.InterfaceC0128b V;
    com.anythink.core.api.IOfferClickHandler W;
    com.anythink.basead.a.b.a X;
    boolean Y;
    private final java.lang.String ab = com.anythink.basead.a.b.class.getSimpleName();
    private final int ac = 0;
    private final int ad = 1;
    private final int ae = 2;
    private final int af = 10;
    boolean R = false;
    boolean Z = false;
    com.anythink.basead.a.b.InterfaceC0128b aa = new com.anythink.basead.a.b.AnonymousClass1();

    /* renamed from: com.anythink.basead.a.b$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.basead.a.b.InterfaceC0128b {
        public AnonymousClass1() {
        }

        @Override // com.anythink.basead.a.b.InterfaceC0128b
        public final void a() {
            com.anythink.basead.a.b.InterfaceC0128b interfaceC0128b;
            com.anythink.basead.a.b bVar = com.anythink.basead.a.b.this;
            if (bVar.R || (interfaceC0128b = bVar.V) == null) {
                return;
            }
            interfaceC0128b.a();
        }

        @Override // com.anythink.basead.a.b.InterfaceC0128b
        public final void a(boolean z) {
            com.anythink.basead.a.b.InterfaceC0128b interfaceC0128b;
            com.anythink.basead.a.b bVar = com.anythink.basead.a.b.this;
            if (bVar.R || (interfaceC0128b = bVar.V) == null) {
                return;
            }
            interfaceC0128b.a(z);
        }

        @Override // com.anythink.basead.a.b.InterfaceC0128b
        public final boolean a(java.lang.String str, com.anythink.core.api.IOfferClickHandler iOfferClickHandler) {
            com.anythink.basead.a.b.InterfaceC0128b interfaceC0128b = com.anythink.basead.a.b.this.V;
            if (interfaceC0128b != null) {
                return interfaceC0128b.a(str, iOfferClickHandler);
            }
            return false;
        }

        @Override // com.anythink.basead.a.b.InterfaceC0128b
        public final void b() {
            com.anythink.basead.a.b.InterfaceC0128b interfaceC0128b;
            com.anythink.basead.a.b bVar = com.anythink.basead.a.b.this;
            if (bVar.R || (interfaceC0128b = bVar.V) == null) {
                return;
            }
            interfaceC0128b.b();
        }

        @Override // com.anythink.basead.a.b.InterfaceC0128b
        public final void c() {
            com.anythink.basead.a.b.InterfaceC0128b interfaceC0128b;
            com.anythink.basead.a.b bVar = com.anythink.basead.a.b.this;
            if (bVar.R || (interfaceC0128b = bVar.V) == null) {
                return;
            }
            interfaceC0128b.c();
        }
    }

    /* renamed from: com.anythink.basead.a.b$10, reason: invalid class name */
    public class AnonymousClass10 implements java.lang.Runnable {
        public AnonymousClass10() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.basead.a.b.InterfaceC0128b interfaceC0128b = com.anythink.basead.a.b.this.aa;
            if (interfaceC0128b != null) {
                interfaceC0128b.c();
            }
        }
    }

    /* renamed from: com.anythink.basead.a.b$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.basead.a.b.InterfaceC0128b interfaceC0128b = com.anythink.basead.a.b.this.aa;
            if (interfaceC0128b != null) {
                interfaceC0128b.c();
            }
        }
    }

    /* renamed from: com.anythink.basead.a.b$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.basead.c.i a;

        /* renamed from: com.anythink.basead.a.b$3$1, reason: invalid class name */
        public class AnonymousClass1 implements com.anythink.core.common.g.a {
            final /* synthetic */ int a;

            /* renamed from: com.anythink.basead.a.b$3$1$1, reason: invalid class name and collision with other inner class name */
            public class RunnableC01271 implements java.lang.Runnable {
                public RunnableC01271() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.anythink.basead.a.b.AnonymousClass3.AnonymousClass1 anonymousClass1 = com.anythink.basead.a.b.AnonymousClass3.AnonymousClass1.this;
                    com.anythink.basead.a.b.AnonymousClass3 anonymousClass3 = com.anythink.basead.a.b.AnonymousClass3.this;
                    com.anythink.basead.a.b.a(com.anythink.basead.a.b.this, anonymousClass1.a, anonymousClass3.a);
                }
            }

            public AnonymousClass1(int i) {
                this.a = i;
            }

            @Override // com.anythink.core.common.g.a
            public final void a(boolean z) {
                if (z) {
                    com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.basead.a.b.AnonymousClass3.AnonymousClass1.RunnableC01271(), 2, true);
                } else {
                    com.anythink.basead.a.b.this.P = false;
                }
            }
        }

        public AnonymousClass3(com.anythink.basead.c.i iVar) {
            this.a = iVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.anythink.basead.a.b.a(com.anythink.basead.a.b.this, this.a)) {
                return;
            }
            int i = 2;
            if (com.anythink.basead.a.b.this.U.n.r() == 2) {
                i = 0;
            } else if (com.anythink.basead.a.b.b(com.anythink.basead.a.b.this, this.a)) {
                i = 1;
            }
            if (i == 1 && com.anythink.basead.a.b.this.U.n.r() == 1) {
                return;
            }
            com.anythink.core.api.IExHandler b = com.anythink.core.common.b.o.a().b();
            if (com.anythink.basead.a.b.this.O.G() != 4 || 1 != com.anythink.basead.a.b.this.U.n.u() || b == null || i == 1) {
                com.anythink.basead.a.b.a(com.anythink.basead.a.b.this, i, this.a);
            } else {
                com.anythink.basead.a.b bVar = com.anythink.basead.a.b.this;
                b.openApkConfirmDialog(bVar.S, bVar.O, bVar.U, new com.anythink.basead.a.b.AnonymousClass3.AnonymousClass1(i));
            }
        }
    }

    /* renamed from: com.anythink.basead.a.b$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ boolean a;

        public AnonymousClass4(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.basead.a.b.InterfaceC0128b interfaceC0128b = com.anythink.basead.a.b.this.aa;
            if (interfaceC0128b != null && !this.a) {
                interfaceC0128b.b();
            }
            com.anythink.basead.a.b.InterfaceC0128b interfaceC0128b2 = com.anythink.basead.a.b.this.aa;
            if (interfaceC0128b2 != null) {
                interfaceC0128b2.c();
            }
        }
    }

    /* renamed from: com.anythink.basead.a.b$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        final /* synthetic */ boolean a;

        public AnonymousClass5(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.basead.a.b.InterfaceC0128b interfaceC0128b = com.anythink.basead.a.b.this.aa;
            if (interfaceC0128b != null && !this.a) {
                interfaceC0128b.b();
            }
            com.anythink.basead.a.b.InterfaceC0128b interfaceC0128b2 = com.anythink.basead.a.b.this.aa;
            if (interfaceC0128b2 != null) {
                interfaceC0128b2.c();
            }
        }
    }

    /* renamed from: com.anythink.basead.a.b$6, reason: invalid class name */
    public class AnonymousClass6 implements java.lang.Runnable {
        public AnonymousClass6() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.basead.a.b.InterfaceC0128b interfaceC0128b = com.anythink.basead.a.b.this.aa;
            if (interfaceC0128b != null) {
                interfaceC0128b.b();
            }
        }
    }

    /* renamed from: com.anythink.basead.a.b$7, reason: invalid class name */
    public class AnonymousClass7 implements java.lang.Runnable {
        public AnonymousClass7() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.basead.a.b.InterfaceC0128b interfaceC0128b = com.anythink.basead.a.b.this.aa;
            if (interfaceC0128b != null) {
                interfaceC0128b.c();
            }
        }
    }

    /* renamed from: com.anythink.basead.a.b$8, reason: invalid class name */
    public class AnonymousClass8 implements java.lang.Runnable {
        public AnonymousClass8() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.basead.a.b.InterfaceC0128b interfaceC0128b = com.anythink.basead.a.b.this.aa;
            if (interfaceC0128b != null) {
                interfaceC0128b.c();
            }
        }
    }

    /* renamed from: com.anythink.basead.a.b$9, reason: invalid class name */
    public class AnonymousClass9 implements java.lang.Runnable {
        public AnonymousClass9() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (android.text.TextUtils.isEmpty(com.anythink.basead.a.b.this.O.D())) {
                    android.content.Context context = com.anythink.basead.a.b.this.S;
                    android.widget.Toast.makeText(context, com.anythink.core.common.o.i.a(context, "basead_click_empty", com.anythink.expressad.foundation.h.i.g), 0).show();
                } else {
                    android.content.Context context2 = com.anythink.basead.a.b.this.S;
                    android.widget.Toast.makeText(context2, com.anythink.core.common.o.i.a(context2, "basead_click_fail", com.anythink.expressad.foundation.h.i.g), 0).show();
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static class a {
        long a;
        long b;
        java.lang.String c;

        public final boolean a() {
            return java.lang.System.currentTimeMillis() - this.a <= this.b;
        }
    }

    /* renamed from: com.anythink.basead.a.b$b, reason: collision with other inner class name */
    public interface InterfaceC0128b {
        void a();

        void a(boolean z);

        boolean a(java.lang.String str, com.anythink.core.api.IOfferClickHandler iOfferClickHandler);

        void b();

        void c();
    }

    public b(android.content.Context context, com.anythink.core.common.f.m mVar, com.anythink.core.common.f.l lVar) {
        this.O = lVar;
        this.U = mVar;
        this.S = context.getApplicationContext();
        com.anythink.core.common.f.n nVar = mVar.n;
        this.T = !(lVar instanceof com.anythink.core.common.f.j) ? !((lVar instanceof com.anythink.core.common.f.z) && ((com.anythink.core.common.f.z) lVar).V() == 1) : !((nVar instanceof com.anythink.core.common.f.aj) && ((com.anythink.core.common.f.aj) nVar).at() == 1);
        this.O.h(mVar.d);
        this.W = new com.anythink.basead.handler.OfferClickHandler();
        this.Y = this.U.n.U() != 2;
    }

    private void a(int i2, com.anythink.basead.c.i iVar) {
        java.lang.String str;
        java.lang.String b2;
        java.lang.String b3;
        com.anythink.basead.c.d a2;
        boolean z2 = true;
        if (i2 != 1) {
            com.anythink.basead.a.b.InterfaceC0128b interfaceC0128b = this.aa;
            if (interfaceC0128b != null) {
                interfaceC0128b.a();
            }
            com.anythink.core.common.b.o.a().b(new com.anythink.basead.a.b.AnonymousClass6());
        }
        str = "";
        java.lang.String D2 = this.O.D() != null ? this.O.D() : "";
        java.lang.String str2 = this.U.d;
        if (str2 == null) {
            str2 = "";
        }
        java.lang.String a3 = com.anythink.basead.a.i.a(D2.replaceAll("\\{req_id\\}", str2), iVar, java.lang.System.currentTimeMillis());
        com.anythink.basead.c.d dVar = (g() && this.O.G() == 4) ? new com.anythink.basead.c.d("", "", "") : new com.anythink.basead.c.d(a3, "", "");
        a(dVar);
        int G2 = this.O.G();
        if (G2 == 1) {
            if (!a3.startsWith(com.alipay.sdk.m.l.a.q)) {
                a(a3, i2, iVar);
                return;
            }
            com.anythink.basead.a.b.a aVar = this.X;
            boolean z3 = aVar != null && aVar.a();
            if (this.T) {
                java.lang.String B2 = this.O.B();
                if (z3) {
                    B2 = this.X.c;
                }
                if (!android.text.TextUtils.isEmpty(B2)) {
                    a(B2, i2, iVar);
                    z2 = false;
                }
            }
            if (z3) {
                b2 = this.X.c;
            } else {
                b2 = b(a3);
                if (!android.text.TextUtils.isEmpty(b2)) {
                    a(b2);
                }
            }
            if (z2) {
                if (android.text.TextUtils.isEmpty(b2)) {
                    b2 = dVar.a;
                }
                a(b2, i2, iVar);
                return;
            }
            return;
        }
        if (G2 == 2 || G2 == 3) {
            if (g() && !android.text.TextUtils.isEmpty(this.O.C())) {
                str = b(a3);
                java.lang.String a4 = com.anythink.basead.d.b.a.a.a(str);
                dVar.b = str;
                dVar.c = a4;
                a(dVar);
            }
            if (android.text.TextUtils.isEmpty(str)) {
                str = dVar.a;
            }
            a(str, i2, iVar);
            return;
        }
        if (G2 != 4) {
            a(android.text.TextUtils.isEmpty("") ? dVar.a : "", i2, iVar);
            return;
        }
        if (g() && android.text.TextUtils.isEmpty(dVar.a) && (a2 = com.anythink.basead.d.b.a.a.a(this.U, this.O, a3)) != null) {
            dVar.a = a2.a;
            dVar.c = a2.c;
        }
        com.anythink.basead.a.b.a aVar2 = this.X;
        if (aVar2 == null || !aVar2.a()) {
            b3 = b(dVar.a);
            if (!android.text.TextUtils.isEmpty(b3)) {
                a(b3);
            }
        } else {
            b3 = this.X.c;
        }
        dVar.b = b3;
        a(dVar);
        if (android.text.TextUtils.isEmpty(b3)) {
            b3 = dVar.a;
        } else {
            iVar.j = true;
        }
        a(b3, i2, iVar);
    }

    public static /* synthetic */ void a(com.anythink.basead.a.b bVar, int i2, com.anythink.basead.c.i iVar) {
        java.lang.String str;
        java.lang.String b2;
        java.lang.String b3;
        com.anythink.basead.c.d a2;
        boolean z2 = true;
        if (i2 != 1) {
            com.anythink.basead.a.b.InterfaceC0128b interfaceC0128b = bVar.aa;
            if (interfaceC0128b != null) {
                interfaceC0128b.a();
            }
            com.anythink.core.common.b.o.a().b(bVar.new AnonymousClass6());
        }
        str = "";
        java.lang.String D2 = bVar.O.D() != null ? bVar.O.D() : "";
        java.lang.String str2 = bVar.U.d;
        if (str2 == null) {
            str2 = "";
        }
        java.lang.String a3 = com.anythink.basead.a.i.a(D2.replaceAll("\\{req_id\\}", str2), iVar, java.lang.System.currentTimeMillis());
        com.anythink.basead.c.d dVar = (bVar.g() && bVar.O.G() == 4) ? new com.anythink.basead.c.d("", "", "") : new com.anythink.basead.c.d(a3, "", "");
        bVar.a(dVar);
        int G2 = bVar.O.G();
        if (G2 == 1) {
            if (!a3.startsWith(com.alipay.sdk.m.l.a.q)) {
                bVar.a(a3, i2, iVar);
                return;
            }
            com.anythink.basead.a.b.a aVar = bVar.X;
            boolean z3 = aVar != null && aVar.a();
            if (bVar.T) {
                java.lang.String B2 = bVar.O.B();
                if (z3) {
                    B2 = bVar.X.c;
                }
                if (!android.text.TextUtils.isEmpty(B2)) {
                    bVar.a(B2, i2, iVar);
                    z2 = false;
                }
            }
            if (z3) {
                b2 = bVar.X.c;
            } else {
                b2 = bVar.b(a3);
                if (!android.text.TextUtils.isEmpty(b2)) {
                    bVar.a(b2);
                }
            }
            if (z2) {
                if (android.text.TextUtils.isEmpty(b2)) {
                    b2 = dVar.a;
                }
                bVar.a(b2, i2, iVar);
                return;
            }
            return;
        }
        if (G2 == 2 || G2 == 3) {
            if (bVar.g() && !android.text.TextUtils.isEmpty(bVar.O.C())) {
                str = bVar.b(a3);
                java.lang.String a4 = com.anythink.basead.d.b.a.a.a(str);
                dVar.b = str;
                dVar.c = a4;
                bVar.a(dVar);
            }
            if (android.text.TextUtils.isEmpty(str)) {
                str = dVar.a;
            }
            bVar.a(str, i2, iVar);
            return;
        }
        if (G2 != 4) {
            bVar.a(android.text.TextUtils.isEmpty("") ? dVar.a : "", i2, iVar);
            return;
        }
        if (bVar.g() && android.text.TextUtils.isEmpty(dVar.a) && (a2 = com.anythink.basead.d.b.a.a.a(bVar.U, bVar.O, a3)) != null) {
            dVar.a = a2.a;
            dVar.c = a2.c;
        }
        com.anythink.basead.a.b.a aVar2 = bVar.X;
        if (aVar2 == null || !aVar2.a()) {
            b3 = bVar.b(dVar.a);
            if (!android.text.TextUtils.isEmpty(b3)) {
                bVar.a(b3);
            }
        } else {
            b3 = bVar.X.c;
        }
        dVar.b = b3;
        bVar.a(dVar);
        if (android.text.TextUtils.isEmpty(b3)) {
            b3 = dVar.a;
        } else {
            iVar.j = true;
        }
        bVar.a(b3, i2, iVar);
    }

    private void a(com.anythink.basead.c.d dVar) {
        com.anythink.basead.a.c.a().a(this.O.d(), this.O.s(), dVar);
    }

    private synchronized void a(java.lang.String str) {
        if (this.X == null) {
            this.X = new com.anythink.basead.a.b.a();
        }
        com.anythink.basead.a.b.a aVar = this.X;
        aVar.c = str;
        aVar.b = this.U.n.T();
        this.X.a = java.lang.System.currentTimeMillis();
    }

    private void a(java.lang.String str, int i2, com.anythink.basead.c.i iVar) {
        com.anythink.basead.a.b.InterfaceC0128b interfaceC0128b;
        com.anythink.basead.a.b.InterfaceC0128b interfaceC0128b2;
        if (i2 == 1) {
            return;
        }
        if (this.Q) {
            this.P = false;
            if ((!android.text.TextUtils.isEmpty(this.O.r()) || !android.text.TextUtils.isEmpty(this.O.C())) && (interfaceC0128b2 = this.aa) != null) {
                interfaceC0128b2.a(false);
            }
            b(iVar);
            com.anythink.core.common.b.o.a().b(new com.anythink.basead.a.b.AnonymousClass7());
            return;
        }
        if (i2 == 0 && b(iVar, true)) {
            return;
        }
        if ((!android.text.TextUtils.isEmpty(this.O.r()) || !android.text.TextUtils.isEmpty(this.O.C())) && (interfaceC0128b = this.aa) != null) {
            interfaceC0128b.a(false);
        }
        if (!android.text.TextUtils.isEmpty(this.O.E()) && (this.O.G() == 1 || this.O.G() == 4)) {
            boolean a2 = a(this.S, this.O.E());
            iVar.i = new com.anythink.basead.c.b();
            com.anythink.basead.c.d e2 = e();
            iVar.i.a = e2 != null ? e2.c : "";
            com.anythink.basead.c.a aVar = iVar.g;
            if (aVar != null) {
                aVar.j = a2 ? 5 : aVar.j;
            }
            if (a2) {
                b(iVar);
                com.anythink.basead.a.a.a(25, this.O, iVar);
                this.P = false;
                com.anythink.core.common.b.o.a().b(new com.anythink.basead.a.b.AnonymousClass8());
                return;
            }
            com.anythink.basead.a.a.a(26, this.O, iVar);
        }
        if (iVar.g != null && this.O.G() == 4) {
            if (iVar.j) {
                com.anythink.core.api.IExHandler b2 = com.anythink.core.common.b.o.a().b();
                com.anythink.basead.c.a aVar2 = iVar.g;
                aVar2.j = b2 != null ? b2.checkDownloadType(this.O, this.U) : aVar2.j;
            } else {
                iVar.g.j = 3;
            }
        }
        b(iVar);
        if (android.text.TextUtils.isEmpty(str)) {
            str = this.O.B();
        }
        if (android.text.TextUtils.isEmpty(str)) {
            com.anythink.core.common.b.o.a().b(new com.anythink.basead.a.b.AnonymousClass9());
            this.P = false;
            com.anythink.core.common.b.o.a().b(new com.anythink.basead.a.b.AnonymousClass10());
            return;
        }
        int G2 = this.O.G();
        if (G2 == 1) {
            boolean z2 = (str == null || str.startsWith(com.alipay.sdk.m.l.a.q)) ? false : true;
            if (!com.anythink.core.basead.a.a.a(this.S, str, z2) && !z2) {
                if (this.U.n.q() == 2) {
                    com.anythink.core.basead.b.c cVar = new com.anythink.core.basead.b.c();
                    cVar.c = this.O;
                    cVar.h = this.U;
                    cVar.f = str;
                    cVar.g = this.W;
                    com.anythink.core.basead.ui.web.WebLandPageActivity.a(this.S, cVar);
                } else {
                    com.anythink.core.common.o.m.a(str);
                }
            }
        } else if (G2 == 2) {
            com.anythink.core.common.o.m.a(str);
        } else if (G2 != 3) {
            if (G2 == 4) {
                a(str, iVar);
            } else if (G2 != 6) {
                if (this.U.n.q() == 2) {
                    com.anythink.core.basead.b.c cVar2 = new com.anythink.core.basead.b.c();
                    cVar2.c = this.O;
                    cVar2.h = this.U;
                    cVar2.f = str;
                    cVar2.g = this.W;
                    com.anythink.core.basead.ui.web.WebLandPageActivity.a(this.S, cVar2);
                } else {
                    com.anythink.core.common.o.m.a(str);
                }
            } else if (!f()) {
                com.anythink.core.basead.b.c cVar3 = new com.anythink.core.basead.b.c();
                cVar3.c = this.O;
                cVar3.h = this.U;
                cVar3.f = str;
                cVar3.g = this.W;
                com.anythink.core.basead.ui.web.WebLandPageActivity.a(this.S, cVar3);
            }
        } else if (!this.aa.a(str, this.W)) {
            com.anythink.core.basead.b.c cVar4 = new com.anythink.core.basead.b.c();
            cVar4.c = this.O;
            cVar4.h = this.U;
            cVar4.f = str;
            cVar4.g = this.W;
            com.anythink.core.basead.ui.web.WebLandPageActivity.a(this.S, cVar4);
        }
        this.P = false;
        com.anythink.core.common.b.o.a().b(new com.anythink.basead.a.b.AnonymousClass2());
    }

    private void a(java.lang.String str, com.anythink.basead.c.i iVar) {
        if (iVar.j) {
            if (android.text.TextUtils.isEmpty(str)) {
                com.anythink.core.common.o.m.a(str);
                return;
            } else if (com.anythink.basead.a.a.a(this.S, this.U, this.O, e(), str, new com.anythink.basead.a.h())) {
                return;
            }
        }
        com.anythink.core.common.o.m.a(str);
    }

    public static boolean a(android.content.Context context, java.lang.String str) {
        try {
            android.content.Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage == null) {
                return false;
            }
            launchIntentForPackage.setFlags(268435456);
            context.startActivity(launchIntentForPackage);
            return true;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static /* synthetic */ boolean a(com.anythink.basead.a.b bVar, com.anythink.basead.c.i iVar) {
        iVar.i = new com.anythink.basead.c.b();
        com.anythink.basead.c.d e2 = bVar.e();
        iVar.i.a = e2 != null ? e2.c : "";
        if (!android.text.TextUtils.isEmpty(bVar.O.r())) {
            java.lang.String r2 = bVar.O.r();
            java.lang.String str = bVar.U.d;
            java.lang.String replaceAll = r2.replaceAll("\\{req_id\\}", str != null ? str : "");
            if (com.anythink.core.basead.a.a.a(bVar.S, replaceAll, false)) {
                com.anythink.basead.c.a aVar = iVar.g;
                if (aVar != null) {
                    aVar.i = true;
                }
                bVar.b(iVar);
                com.anythink.core.common.n.c.a(bVar.U, bVar.O, replaceAll, "1", 1);
                com.anythink.basead.a.b.InterfaceC0128b interfaceC0128b = bVar.aa;
                if (interfaceC0128b != null) {
                    interfaceC0128b.a();
                }
                com.anythink.basead.a.b.InterfaceC0128b interfaceC0128b2 = bVar.aa;
                if (interfaceC0128b2 != null) {
                    interfaceC0128b2.a(true);
                }
                bVar.P = false;
                com.anythink.core.common.b.o.a().b(bVar.new AnonymousClass4(false));
                return true;
            }
            com.anythink.core.common.n.c.a(bVar.U, bVar.O, replaceAll, "0", 1);
        }
        return false;
    }

    private boolean a(com.anythink.basead.c.i iVar, boolean z2) {
        iVar.i = new com.anythink.basead.c.b();
        com.anythink.basead.c.d e2 = e();
        iVar.i.a = e2 != null ? e2.c : "";
        if (!android.text.TextUtils.isEmpty(this.O.r())) {
            java.lang.String r2 = this.O.r();
            java.lang.String str = this.U.d;
            java.lang.String replaceAll = r2.replaceAll("\\{req_id\\}", str != null ? str : "");
            if (com.anythink.core.basead.a.a.a(this.S, replaceAll, false)) {
                com.anythink.basead.c.a aVar = iVar.g;
                if (aVar != null) {
                    aVar.i = true;
                }
                b(iVar);
                com.anythink.core.common.n.c.a(this.U, this.O, replaceAll, "1", 1);
                com.anythink.basead.a.b.InterfaceC0128b interfaceC0128b = this.aa;
                if (interfaceC0128b != null && !z2) {
                    interfaceC0128b.a();
                }
                com.anythink.basead.a.b.InterfaceC0128b interfaceC0128b2 = this.aa;
                if (interfaceC0128b2 != null) {
                    interfaceC0128b2.a(true);
                }
                this.P = false;
                com.anythink.core.common.b.o.a().b(new com.anythink.basead.a.b.AnonymousClass4(z2));
                return true;
            }
            com.anythink.core.common.n.c.a(this.U, this.O, replaceAll, "0", 1);
        }
        return false;
    }

    private java.lang.String b(java.lang.String str) {
        java.lang.String str2;
        java.net.HttpURLConnection httpURLConnection;
        boolean z2 = false;
        java.lang.String str3 = str;
        for (int i2 = 0; i2 < 10; i2++) {
            java.net.HttpURLConnection httpURLConnection2 = null;
            try {
                try {
                    httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str3).openConnection();
                } catch (java.lang.Exception e2) {
                    e = e2;
                    str2 = str3;
                }
            } catch (java.lang.Throwable th) {
                th = th;
            }
            try {
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setInstanceFollowRedirects(false);
                com.anythink.core.common.f.n nVar = this.U.n;
                if (nVar != null && com.anythink.basead.a.a.a(9, nVar)) {
                    java.lang.String i3 = com.anythink.core.common.o.e.i();
                    if (!android.text.TextUtils.isEmpty(i3)) {
                        httpURLConnection.addRequestProperty("User-Agent", i3);
                    }
                }
                httpURLConnection.setConnectTimeout(30000);
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                    str3 = httpURLConnection.getHeaderField("Location");
                    if (!com.anythink.core.basead.a.a.b(str3) && !str3.contains(com.anythink.china.common.a.a.g) && str3.startsWith(com.alipay.sdk.m.l.a.q)) {
                        httpURLConnection.disconnect();
                        httpURLConnection.disconnect();
                    }
                    z2 = true;
                }
                if (z2 || responseCode == 200) {
                    httpURLConnection.disconnect();
                    return str3;
                }
                com.anythink.core.common.n.c.a(this.U, this.O, str, str3, java.lang.String.valueOf(responseCode), "");
                httpURLConnection.disconnect();
                return "";
            } catch (java.lang.Exception e3) {
                e = e3;
                str2 = str3;
                httpURLConnection2 = httpURLConnection;
                com.anythink.core.common.n.c.a(this.U, this.O, str, str2, "", e.getMessage());
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                return "";
            } catch (java.lang.Throwable th2) {
                th = th2;
                httpURLConnection2 = httpURLConnection;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
        }
        return "";
    }

    private void b(com.anythink.basead.c.i iVar) {
        if (this.Y || !this.Z) {
            this.Z = true;
            com.anythink.basead.a.a.a(9, this.O, iVar);
        }
    }

    public static /* synthetic */ boolean b(com.anythink.basead.a.b bVar, com.anythink.basead.c.i iVar) {
        return bVar.b(iVar, false);
    }

    private boolean b(com.anythink.basead.c.i iVar, boolean z2) {
        iVar.i = new com.anythink.basead.c.b();
        com.anythink.basead.c.d e2 = e();
        iVar.i.a = e2 != null ? e2.c : "";
        com.anythink.basead.a.a.a(23, this.O, iVar);
        if (!android.text.TextUtils.isEmpty(this.O.C())) {
            java.lang.String C2 = this.O.C();
            java.lang.String str = this.U.d;
            java.lang.String replaceAll = C2.replaceAll("\\{req_id\\}", str != null ? str : "");
            com.anythink.core.common.o.a().a(this.O);
            if (com.anythink.core.basead.a.a.a(this.S, replaceAll, false)) {
                com.anythink.basead.c.a aVar = iVar.g;
                if (aVar != null) {
                    aVar.i = true;
                }
                b(iVar);
                com.anythink.core.common.n.c.a(this.U, this.O, replaceAll, "1", 0);
                com.anythink.basead.a.b.InterfaceC0128b interfaceC0128b = this.aa;
                if (interfaceC0128b != null && !z2) {
                    interfaceC0128b.a();
                }
                com.anythink.basead.a.b.InterfaceC0128b interfaceC0128b2 = this.aa;
                if (interfaceC0128b2 != null) {
                    interfaceC0128b2.a(true);
                }
                this.P = false;
                com.anythink.core.common.b.o.a().b(new com.anythink.basead.a.b.AnonymousClass5(z2));
                com.anythink.basead.a.a.a(24, this.O, iVar);
                return true;
            }
            com.anythink.core.common.o.a().b(this.O);
            if (com.anythink.basead.a.a.a(this.S, this.O.E())) {
                com.anythink.basead.a.a.a(28, this.O, iVar);
            } else {
                com.anythink.basead.a.a.a(29, this.O, iVar);
            }
            com.anythink.core.common.n.c.a(this.U, this.O, replaceAll, "0", 0);
        }
        return false;
    }

    private com.anythink.basead.c.d e() {
        return com.anythink.basead.a.c.a().a(this.O.d(), this.O.s());
    }

    private boolean f() {
        com.anythink.core.common.f.ax L2 = com.anythink.core.common.b.o.a().L();
        boolean z2 = L2.b() == 1;
        boolean z3 = L2.a() == 1;
        java.lang.String l2 = com.anythink.core.common.o.e.l();
        if (android.text.TextUtils.isEmpty(l2)) {
            com.anythink.core.common.n.c.a(this.U, this.O, 5);
            return false;
        }
        if (!z2) {
            com.anythink.core.common.n.c.a(this.U, this.O, 3);
            return false;
        }
        if (!z3) {
            com.anythink.core.common.n.c.a(this.U, this.O, 1);
            return false;
        }
        java.lang.String h2 = this.O.h();
        java.lang.String i2 = this.O.i();
        if (android.text.TextUtils.isEmpty(h2) || android.text.TextUtils.isEmpty(i2)) {
            com.anythink.core.common.n.c.a(this.U, this.O, 4);
            return false;
        }
        try {
            java.lang.Object c2 = com.anythink.core.common.o.e.c(l2);
            java.lang.Object newInstance = com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram.Req.class.newInstance();
            com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram.Req.class.getField("userName").set(newInstance, h2);
            com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram.Req.class.getField("path").set(newInstance, i2);
            com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram.Req.class.getField("miniprogramType").set(newInstance, com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram.Req.class.getField("MINIPTOGRAM_TYPE_RELEASE").get(null));
            com.tencent.mm.opensdk.openapi.IWXAPI.class.getMethod("sendReq", com.tencent.mm.opensdk.modelbase.BaseReq.class).invoke(c2, newInstance);
            com.anythink.core.common.n.c.a(this.U, this.O, 0);
            return true;
        } catch (java.lang.Throwable th) {
            com.anythink.core.common.f.m mVar = this.U;
            com.anythink.core.common.f.l lVar = this.O;
            th.getMessage();
            com.anythink.core.common.n.c.a(mVar, lVar, 2);
            return false;
        }
    }

    private boolean g() {
        if (this.O.q() == 42) {
            return true;
        }
        com.anythink.core.common.f.l lVar = this.O;
        return (lVar instanceof com.anythink.core.common.f.ah) && ((com.anythink.core.common.f.ah) lVar).a() == 42;
    }

    private void h() {
        this.Q = true;
    }

    public final void a(com.anythink.basead.a.b.InterfaceC0128b interfaceC0128b) {
        this.V = interfaceC0128b;
    }

    public final void a(com.anythink.basead.c.i iVar) {
        if (this.P) {
            return;
        }
        this.P = true;
        this.Q = false;
        com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.basead.a.b.AnonymousClass3(iVar), 2, true);
    }

    public final boolean a() {
        return this.P;
    }

    public final com.anythink.core.common.f.l b() {
        return this.O;
    }

    public final com.anythink.core.common.f.m c() {
        return this.U;
    }

    public final void d() {
        this.R = true;
    }
}
