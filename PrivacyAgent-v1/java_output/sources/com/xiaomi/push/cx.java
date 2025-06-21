package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class cx {

    public static final class a extends com.xiaomi.push.da {
        boolean b;
        boolean g;
        boolean i;
        public boolean l;
        private boolean o;
        private boolean p;
        private boolean q;
        private boolean r;

        /* renamed from: s, reason: collision with root package name */
        private boolean f460s;
        private boolean u;
        private boolean v;
        public int a = 0;
        long c = 0;
        java.lang.String d = "";
        java.lang.String e = "";
        public java.lang.String f = "";
        public java.lang.String h = "";
        java.lang.String j = "";
        private int t = 1;
        int k = 0;
        public int m = 0;
        public java.lang.String n = "";
        private int w = -1;

        @Override // com.xiaomi.push.da
        public final int a() {
            if (this.w < 0) {
                b();
            }
            return this.w;
        }

        public final com.xiaomi.push.cx.a a(int i) {
            this.o = true;
            this.a = i;
            return this;
        }

        public final com.xiaomi.push.cx.a a(long j) {
            this.b = true;
            this.c = j;
            return this;
        }

        public final com.xiaomi.push.cx.a a(java.lang.String str) {
            this.p = true;
            this.d = str;
            return this;
        }

        @Override // com.xiaomi.push.da
        public final void a(com.xiaomi.push.az azVar) {
            if (this.o) {
                azVar.a(1, this.a);
            }
            if (this.b) {
                long j = this.c;
                azVar.c(2, 0);
                azVar.b(j);
            }
            if (this.p) {
                azVar.a(3, this.d);
            }
            if (this.q) {
                azVar.a(4, this.e);
            }
            if (this.r) {
                azVar.a(5, this.f);
            }
            if (this.g) {
                azVar.a(6, this.h);
            }
            if (this.i) {
                azVar.a(7, this.j);
            }
            if (this.f460s) {
                azVar.a(8, this.t);
            }
            if (this.u) {
                azVar.a(9, this.k);
            }
            if (this.l) {
                azVar.a(10, this.m);
            }
            if (this.v) {
                azVar.a(11, this.n);
            }
        }

        @Override // com.xiaomi.push.da
        public final int b() {
            int b = this.o ? 0 + com.xiaomi.push.az.b(1, this.a) : 0;
            if (this.b) {
                b += com.xiaomi.push.az.a(this.c);
            }
            if (this.p) {
                b += com.xiaomi.push.az.b(3, this.d);
            }
            if (this.q) {
                b += com.xiaomi.push.az.b(4, this.e);
            }
            if (this.r) {
                b += com.xiaomi.push.az.b(5, this.f);
            }
            if (this.g) {
                b += com.xiaomi.push.az.b(6, this.h);
            }
            if (this.i) {
                b += com.xiaomi.push.az.b(7, this.j);
            }
            if (this.f460s) {
                b += com.xiaomi.push.az.b(8, this.t);
            }
            if (this.u) {
                b += com.xiaomi.push.az.b(9, this.k);
            }
            if (this.l) {
                b += com.xiaomi.push.az.b(10, this.m);
            }
            if (this.v) {
                b += com.xiaomi.push.az.b(11, this.n);
            }
            this.w = b;
            return b;
        }

        public final com.xiaomi.push.cx.a b(int i) {
            this.u = true;
            this.k = i;
            return this;
        }

        public final com.xiaomi.push.cx.a b(java.lang.String str) {
            this.q = true;
            this.e = str;
            return this;
        }

        @Override // com.xiaomi.push.da
        public final /* synthetic */ com.xiaomi.push.da b(com.xiaomi.push.z zVar) {
            while (true) {
                int a = zVar.a();
                switch (a) {
                    case 0:
                        return this;
                    case 8:
                        a(zVar.e());
                        break;
                    case 16:
                        a(zVar.f());
                        break;
                    case 26:
                        a(zVar.c());
                        break;
                    case 34:
                        b(zVar.c());
                        break;
                    case 42:
                        c(zVar.c());
                        break;
                    case 50:
                        d(zVar.c());
                        break;
                    case 58:
                        e(zVar.c());
                        break;
                    case 64:
                        int e = zVar.e();
                        this.f460s = true;
                        this.t = e;
                        break;
                    case 72:
                        b(zVar.e());
                        break;
                    case 80:
                        int e2 = zVar.e();
                        this.l = true;
                        this.m = e2;
                        break;
                    case 90:
                        java.lang.String c = zVar.c();
                        this.v = true;
                        this.n = c;
                        break;
                    default:
                        if (!zVar.b(a)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public final com.xiaomi.push.cx.a c(java.lang.String str) {
            this.r = true;
            this.f = str;
            return this;
        }

        public final com.xiaomi.push.cx.a d(java.lang.String str) {
            this.g = true;
            this.h = str;
            return this;
        }

        public final com.xiaomi.push.cx.a e(java.lang.String str) {
            this.i = true;
            this.j = str;
            return this;
        }
    }

    public static final class b extends com.xiaomi.push.da {
        public boolean a;
        public boolean c;
        boolean e;
        private boolean g;
        public boolean b = false;
        private int h = 0;
        public int d = 0;
        int f = 0;
        private int i = -1;

        public static com.xiaomi.push.cx.b a(byte[] bArr) {
            return (com.xiaomi.push.cx.b) new com.xiaomi.push.cx.b().b(bArr);
        }

        @Override // com.xiaomi.push.da
        public final int a() {
            if (this.i < 0) {
                b();
            }
            return this.i;
        }

        public final com.xiaomi.push.cx.b a(int i) {
            this.g = true;
            this.h = i;
            return this;
        }

        @Override // com.xiaomi.push.da
        public final void a(com.xiaomi.push.az azVar) {
            if (this.a) {
                azVar.a(1, this.b);
            }
            if (this.g) {
                azVar.a(3, this.h);
            }
            if (this.c) {
                azVar.a(4, this.d);
            }
            if (this.e) {
                azVar.a(5, this.f);
            }
        }

        @Override // com.xiaomi.push.da
        public final int b() {
            int c = this.a ? 0 + com.xiaomi.push.az.c(1) + 1 : 0;
            if (this.g) {
                c += com.xiaomi.push.az.b(3, this.h);
            }
            if (this.c) {
                c += com.xiaomi.push.az.b(4, this.d);
            }
            if (this.e) {
                c += com.xiaomi.push.az.b(5, this.f);
            }
            this.i = c;
            return c;
        }

        @Override // com.xiaomi.push.da
        public final /* synthetic */ com.xiaomi.push.da b(com.xiaomi.push.z zVar) {
            while (true) {
                int a = zVar.a();
                if (a == 0) {
                    return this;
                }
                if (a == 8) {
                    boolean b = zVar.b();
                    this.a = true;
                    this.b = b;
                } else if (a == 24) {
                    a(zVar.e());
                } else if (a == 32) {
                    int e = zVar.e();
                    this.c = true;
                    this.d = e;
                } else if (a == 40) {
                    int e2 = zVar.e();
                    this.e = true;
                    this.f = e2;
                } else if (!zVar.b(a)) {
                    return this;
                }
            }
        }
    }

    public static final class c extends com.xiaomi.push.da {
        private boolean a;
        private boolean c;
        private boolean e;
        private boolean g;
        private boolean i;
        private boolean k;
        private java.lang.String b = "";
        private java.lang.String d = "";
        private java.lang.String f = "";
        private java.lang.String h = "";
        private java.lang.String j = "";
        private java.lang.String l = "";
        private int m = -1;

        @Override // com.xiaomi.push.da
        public final int a() {
            if (this.m < 0) {
                b();
            }
            return this.m;
        }

        public final com.xiaomi.push.cx.c a(java.lang.String str) {
            this.a = true;
            this.b = str;
            return this;
        }

        @Override // com.xiaomi.push.da
        public final void a(com.xiaomi.push.az azVar) {
            if (this.a) {
                azVar.a(1, this.b);
            }
            if (this.c) {
                azVar.a(2, this.d);
            }
            if (this.e) {
                azVar.a(3, this.f);
            }
            if (this.g) {
                azVar.a(4, this.h);
            }
            if (this.i) {
                azVar.a(5, this.j);
            }
            if (this.k) {
                azVar.a(6, this.l);
            }
        }

        @Override // com.xiaomi.push.da
        public final int b() {
            int b = this.a ? 0 + com.xiaomi.push.az.b(1, this.b) : 0;
            if (this.c) {
                b += com.xiaomi.push.az.b(2, this.d);
            }
            if (this.e) {
                b += com.xiaomi.push.az.b(3, this.f);
            }
            if (this.g) {
                b += com.xiaomi.push.az.b(4, this.h);
            }
            if (this.i) {
                b += com.xiaomi.push.az.b(5, this.j);
            }
            if (this.k) {
                b += com.xiaomi.push.az.b(6, this.l);
            }
            this.m = b;
            return b;
        }

        public final com.xiaomi.push.cx.c b(java.lang.String str) {
            this.c = true;
            this.d = str;
            return this;
        }

        @Override // com.xiaomi.push.da
        public final /* synthetic */ com.xiaomi.push.da b(com.xiaomi.push.z zVar) {
            while (true) {
                int a = zVar.a();
                if (a == 0) {
                    return this;
                }
                if (a == 10) {
                    a(zVar.c());
                } else if (a == 18) {
                    b(zVar.c());
                } else if (a == 26) {
                    c(zVar.c());
                } else if (a == 34) {
                    d(zVar.c());
                } else if (a == 42) {
                    e(zVar.c());
                } else if (a == 50) {
                    f(zVar.c());
                } else if (!zVar.b(a)) {
                    return this;
                }
            }
        }

        public final com.xiaomi.push.cx.c c(java.lang.String str) {
            this.e = true;
            this.f = str;
            return this;
        }

        public final com.xiaomi.push.cx.c d(java.lang.String str) {
            this.g = true;
            this.h = str;
            return this;
        }

        public final com.xiaomi.push.cx.c e(java.lang.String str) {
            this.i = true;
            this.j = str;
            return this;
        }

        public final com.xiaomi.push.cx.c f(java.lang.String str) {
            this.k = true;
            this.l = str;
            return this;
        }
    }

    public static final class d extends com.xiaomi.push.da {
        private boolean d;
        private boolean e;
        private boolean f;
        private boolean g;
        public boolean a = false;
        public java.lang.String b = "";
        public java.lang.String c = "";
        private java.lang.String h = "";
        private int i = -1;

        @Override // com.xiaomi.push.da
        public final int a() {
            if (this.i < 0) {
                b();
            }
            return this.i;
        }

        public final com.xiaomi.push.cx.d a(java.lang.String str) {
            this.e = true;
            this.b = str;
            return this;
        }

        public final com.xiaomi.push.cx.d a(boolean z) {
            this.d = true;
            this.a = z;
            return this;
        }

        @Override // com.xiaomi.push.da
        public final void a(com.xiaomi.push.az azVar) {
            if (this.d) {
                azVar.a(1, this.a);
            }
            if (this.e) {
                azVar.a(2, this.b);
            }
            if (this.f) {
                azVar.a(3, this.c);
            }
            if (this.g) {
                azVar.a(4, this.h);
            }
        }

        @Override // com.xiaomi.push.da
        public final int b() {
            int c = this.d ? 0 + com.xiaomi.push.az.c(1) + 1 : 0;
            if (this.e) {
                c += com.xiaomi.push.az.b(2, this.b);
            }
            if (this.f) {
                c += com.xiaomi.push.az.b(3, this.c);
            }
            if (this.g) {
                c += com.xiaomi.push.az.b(4, this.h);
            }
            this.i = c;
            return c;
        }

        public final com.xiaomi.push.cx.d b(java.lang.String str) {
            this.f = true;
            this.c = str;
            return this;
        }

        @Override // com.xiaomi.push.da
        public final /* synthetic */ com.xiaomi.push.da b(com.xiaomi.push.z zVar) {
            while (true) {
                int a = zVar.a();
                if (a == 0) {
                    return this;
                }
                if (a == 8) {
                    a(zVar.b());
                } else if (a == 18) {
                    a(zVar.c());
                } else if (a == 26) {
                    b(zVar.c());
                } else if (a == 34) {
                    c(zVar.c());
                } else if (!zVar.b(a)) {
                    return this;
                }
            }
        }

        public final com.xiaomi.push.cx.d c(java.lang.String str) {
            this.g = true;
            this.h = str;
            return this;
        }
    }

    public static final class e extends com.xiaomi.push.da {
        private boolean a;
        private boolean c;
        private boolean e;
        private boolean g;
        private boolean i;
        private boolean k;
        private boolean m;
        private boolean o;
        private boolean q;

        /* renamed from: s, reason: collision with root package name */
        private boolean f461s;
        private int b = 0;
        private java.lang.String d = "";
        private java.lang.String f = "";
        private java.lang.String h = "";
        private int j = 0;
        private java.lang.String l = "";
        private java.lang.String n = "";
        private java.lang.String p = "";
        private com.xiaomi.push.cx.b r = null;
        private int t = 0;
        private int u = -1;

        @Override // com.xiaomi.push.da
        public final int a() {
            if (this.u < 0) {
                b();
            }
            return this.u;
        }

        public final com.xiaomi.push.cx.e a(int i) {
            this.a = true;
            this.b = i;
            return this;
        }

        public final com.xiaomi.push.cx.e a(com.xiaomi.push.cx.b bVar) {
            bVar.getClass();
            this.q = true;
            this.r = bVar;
            return this;
        }

        public final com.xiaomi.push.cx.e a(java.lang.String str) {
            this.c = true;
            this.d = str;
            return this;
        }

        @Override // com.xiaomi.push.da
        public final void a(com.xiaomi.push.az azVar) {
            if (this.a) {
                azVar.a(this.b);
            }
            if (this.c) {
                azVar.a(2, this.d);
            }
            if (this.e) {
                azVar.a(3, this.f);
            }
            if (this.g) {
                azVar.a(4, this.h);
            }
            if (this.i) {
                azVar.a(5, this.j);
            }
            if (this.k) {
                azVar.a(6, this.l);
            }
            if (this.m) {
                azVar.a(7, this.n);
            }
            if (this.o) {
                azVar.a(8, this.p);
            }
            if (this.q) {
                azVar.a(9, this.r);
            }
            if (this.f461s) {
                azVar.a(10, this.t);
            }
        }

        @Override // com.xiaomi.push.da
        public final int b() {
            int b = this.a ? 0 + com.xiaomi.push.az.b(this.b) : 0;
            if (this.c) {
                b += com.xiaomi.push.az.b(2, this.d);
            }
            if (this.e) {
                b += com.xiaomi.push.az.b(3, this.f);
            }
            if (this.g) {
                b += com.xiaomi.push.az.b(4, this.h);
            }
            if (this.i) {
                b += com.xiaomi.push.az.b(5, this.j);
            }
            if (this.k) {
                b += com.xiaomi.push.az.b(6, this.l);
            }
            if (this.m) {
                b += com.xiaomi.push.az.b(7, this.n);
            }
            if (this.o) {
                b += com.xiaomi.push.az.b(8, this.p);
            }
            if (this.q) {
                b += com.xiaomi.push.az.b(9, this.r);
            }
            if (this.f461s) {
                b += com.xiaomi.push.az.b(10, this.t);
            }
            this.u = b;
            return b;
        }

        public final com.xiaomi.push.cx.e b(int i) {
            this.i = true;
            this.j = i;
            return this;
        }

        public final com.xiaomi.push.cx.e b(java.lang.String str) {
            this.e = true;
            this.f = str;
            return this;
        }

        @Override // com.xiaomi.push.da
        public final /* synthetic */ com.xiaomi.push.da b(com.xiaomi.push.z zVar) {
            while (true) {
                int a = zVar.a();
                switch (a) {
                    case 0:
                        return this;
                    case 8:
                        a(zVar.e());
                        break;
                    case 18:
                        a(zVar.c());
                        break;
                    case 26:
                        b(zVar.c());
                        break;
                    case 34:
                        c(zVar.c());
                        break;
                    case 40:
                        b(zVar.e());
                        break;
                    case 50:
                        d(zVar.c());
                        break;
                    case 58:
                        e(zVar.c());
                        break;
                    case 66:
                        f(zVar.c());
                        break;
                    case 74:
                        com.xiaomi.push.cx.b bVar = new com.xiaomi.push.cx.b();
                        zVar.a(bVar);
                        a(bVar);
                        break;
                    case 80:
                        c(zVar.e());
                        break;
                    default:
                        if (!zVar.b(a)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public final com.xiaomi.push.cx.e c(int i) {
            this.f461s = true;
            this.t = i;
            return this;
        }

        public final com.xiaomi.push.cx.e c(java.lang.String str) {
            this.g = true;
            this.h = str;
            return this;
        }

        public final com.xiaomi.push.cx.e d(java.lang.String str) {
            this.k = true;
            this.l = str;
            return this;
        }

        public final com.xiaomi.push.cx.e e(java.lang.String str) {
            this.m = true;
            this.n = str;
            return this;
        }

        public final com.xiaomi.push.cx.e f(java.lang.String str) {
            this.o = true;
            this.p = str;
            return this;
        }
    }

    public static final class f extends com.xiaomi.push.da {
        boolean a;
        boolean d;
        private boolean f;
        java.lang.String b = "";
        java.lang.String c = "";
        com.xiaomi.push.cx.b e = null;
        private int g = -1;

        @Override // com.xiaomi.push.da
        public final int a() {
            if (this.g < 0) {
                b();
            }
            return this.g;
        }

        @Override // com.xiaomi.push.da
        public final void a(com.xiaomi.push.az azVar) {
            if (this.a) {
                azVar.a(1, this.b);
            }
            if (this.f) {
                azVar.a(2, this.c);
            }
            if (this.d) {
                azVar.a(3, this.e);
            }
        }

        @Override // com.xiaomi.push.da
        public final int b() {
            int b = this.a ? 0 + com.xiaomi.push.az.b(1, this.b) : 0;
            if (this.f) {
                b += com.xiaomi.push.az.b(2, this.c);
            }
            if (this.d) {
                b += com.xiaomi.push.az.b(3, this.e);
            }
            this.g = b;
            return b;
        }

        @Override // com.xiaomi.push.da
        public final /* synthetic */ com.xiaomi.push.da b(com.xiaomi.push.z zVar) {
            while (true) {
                int a = zVar.a();
                if (a == 0) {
                    return this;
                }
                if (a == 10) {
                    java.lang.String c = zVar.c();
                    this.a = true;
                    this.b = c;
                } else if (a == 18) {
                    java.lang.String c2 = zVar.c();
                    this.f = true;
                    this.c = c2;
                } else if (a == 26) {
                    com.xiaomi.push.cx.b bVar = new com.xiaomi.push.cx.b();
                    zVar.a(bVar);
                    this.d = true;
                    this.e = bVar;
                } else if (!zVar.b(a)) {
                    return this;
                }
            }
        }
    }

    public static final class g extends com.xiaomi.push.da {
        private boolean c;
        private boolean d;
        private boolean e;
        public java.lang.String a = "";
        public java.lang.String b = "";
        private java.lang.String f = "";
        private int g = -1;

        @Override // com.xiaomi.push.da
        public final int a() {
            if (this.g < 0) {
                b();
            }
            return this.g;
        }

        @Override // com.xiaomi.push.da
        public final void a(com.xiaomi.push.az azVar) {
            if (this.c) {
                azVar.a(1, this.a);
            }
            if (this.d) {
                azVar.a(2, this.b);
            }
            if (this.e) {
                azVar.a(3, this.f);
            }
        }

        @Override // com.xiaomi.push.da
        public final int b() {
            int b = this.c ? 0 + com.xiaomi.push.az.b(1, this.a) : 0;
            if (this.d) {
                b += com.xiaomi.push.az.b(2, this.b);
            }
            if (this.e) {
                b += com.xiaomi.push.az.b(3, this.f);
            }
            this.g = b;
            return b;
        }

        @Override // com.xiaomi.push.da
        public final /* synthetic */ com.xiaomi.push.da b(com.xiaomi.push.z zVar) {
            while (true) {
                int a = zVar.a();
                if (a == 0) {
                    return this;
                }
                if (a == 10) {
                    java.lang.String c = zVar.c();
                    this.c = true;
                    this.a = c;
                } else if (a == 18) {
                    java.lang.String c2 = zVar.c();
                    this.d = true;
                    this.b = c2;
                } else if (a == 26) {
                    java.lang.String c3 = zVar.c();
                    this.e = true;
                    this.f = c3;
                } else if (!zVar.b(a)) {
                    return this;
                }
            }
        }
    }

    public static final class h extends com.xiaomi.push.da {
        private boolean c;
        private boolean d;
        public int a = 0;
        public java.lang.String b = "";
        private int e = -1;

        @Override // com.xiaomi.push.da
        public final int a() {
            if (this.e < 0) {
                b();
            }
            return this.e;
        }

        @Override // com.xiaomi.push.da
        public final void a(com.xiaomi.push.az azVar) {
            if (this.c) {
                azVar.a(1, this.a);
            }
            if (this.d) {
                azVar.a(2, this.b);
            }
        }

        @Override // com.xiaomi.push.da
        public final int b() {
            int b = this.c ? 0 + com.xiaomi.push.az.b(1, this.a) : 0;
            if (this.d) {
                b += com.xiaomi.push.az.b(2, this.b);
            }
            this.e = b;
            return b;
        }

        @Override // com.xiaomi.push.da
        public final /* synthetic */ com.xiaomi.push.da b(com.xiaomi.push.z zVar) {
            while (true) {
                int a = zVar.a();
                if (a == 0) {
                    return this;
                }
                if (a == 8) {
                    int e = zVar.e();
                    this.c = true;
                    this.a = e;
                } else if (a == 18) {
                    java.lang.String c = zVar.c();
                    this.d = true;
                    this.b = c;
                } else if (!zVar.b(a)) {
                    return this;
                }
            }
        }
    }

    public static final class i extends com.xiaomi.push.da {
        public boolean a;
        public com.xiaomi.push.a b = com.xiaomi.push.a.b;
        private int c = -1;

        @Override // com.xiaomi.push.da
        public final int a() {
            if (this.c < 0) {
                b();
            }
            return this.c;
        }

        public final com.xiaomi.push.cx.i a(com.xiaomi.push.a aVar) {
            this.a = true;
            this.b = aVar;
            return this;
        }

        @Override // com.xiaomi.push.da
        public final void a(com.xiaomi.push.az azVar) {
            if (this.a) {
                azVar.a(this.b);
            }
        }

        @Override // com.xiaomi.push.da
        public final int b() {
            int b = this.a ? 0 + com.xiaomi.push.az.b(this.b) : 0;
            this.c = b;
            return b;
        }

        @Override // com.xiaomi.push.da
        public final /* synthetic */ com.xiaomi.push.da b(com.xiaomi.push.z zVar) {
            while (true) {
                int a = zVar.a();
                if (a == 0) {
                    return this;
                }
                if (a == 10) {
                    a(zVar.d());
                } else if (!zVar.b(a)) {
                    return this;
                }
            }
        }
    }

    public static final class j extends com.xiaomi.push.da {
        public boolean a;
        private boolean c;
        private com.xiaomi.push.a d = com.xiaomi.push.a.b;
        public com.xiaomi.push.cx.b b = null;
        private int e = -1;

        @Override // com.xiaomi.push.da
        public final int a() {
            if (this.e < 0) {
                b();
            }
            return this.e;
        }

        public final com.xiaomi.push.cx.j a(com.xiaomi.push.a aVar) {
            this.c = true;
            this.d = aVar;
            return this;
        }

        @Override // com.xiaomi.push.da
        public final void a(com.xiaomi.push.az azVar) {
            if (this.c) {
                azVar.a(this.d);
            }
            if (this.a) {
                azVar.a(2, this.b);
            }
        }

        @Override // com.xiaomi.push.da
        public final int b() {
            int b = this.c ? 0 + com.xiaomi.push.az.b(this.d) : 0;
            if (this.a) {
                b += com.xiaomi.push.az.b(2, this.b);
            }
            this.e = b;
            return b;
        }

        @Override // com.xiaomi.push.da
        public final /* synthetic */ com.xiaomi.push.da b(com.xiaomi.push.z zVar) {
            while (true) {
                int a = zVar.a();
                if (a == 0) {
                    return this;
                }
                if (a == 10) {
                    a(zVar.d());
                } else if (a == 18) {
                    com.xiaomi.push.cx.b bVar = new com.xiaomi.push.cx.b();
                    zVar.a(bVar);
                    this.a = true;
                    this.b = bVar;
                } else if (!zVar.b(a)) {
                    return this;
                }
            }
        }
    }

    public static final class k extends com.xiaomi.push.da {
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;
        private boolean l;
        public java.lang.String a = "";
        public java.lang.String b = "";
        public long c = 0;
        public long d = 0;
        public boolean e = false;
        public int f = 0;
        private int m = -1;

        @Override // com.xiaomi.push.da
        public final int a() {
            if (this.m < 0) {
                b();
            }
            return this.m;
        }

        @Override // com.xiaomi.push.da
        public final void a(com.xiaomi.push.az azVar) {
            if (this.g) {
                azVar.a(1, this.a);
            }
            if (this.h) {
                azVar.a(2, this.b);
            }
            if (this.i) {
                azVar.a(3, this.c);
            }
            if (this.j) {
                azVar.a(4, this.d);
            }
            if (this.k) {
                azVar.a(5, this.e);
            }
            if (this.l) {
                azVar.a(6, this.f);
            }
        }

        @Override // com.xiaomi.push.da
        public final int b() {
            int b = this.g ? 0 + com.xiaomi.push.az.b(1, this.a) : 0;
            if (this.h) {
                b += com.xiaomi.push.az.b(2, this.b);
            }
            if (this.i) {
                b += com.xiaomi.push.az.b(3, this.c);
            }
            if (this.j) {
                b += com.xiaomi.push.az.b(4, this.d);
            }
            if (this.k) {
                b += com.xiaomi.push.az.c(5) + 1;
            }
            if (this.l) {
                b += com.xiaomi.push.az.b(6, this.f);
            }
            this.m = b;
            return b;
        }

        @Override // com.xiaomi.push.da
        public final /* synthetic */ com.xiaomi.push.da b(com.xiaomi.push.z zVar) {
            while (true) {
                int a = zVar.a();
                if (a == 0) {
                    return this;
                }
                if (a == 10) {
                    java.lang.String c = zVar.c();
                    this.g = true;
                    this.a = c;
                } else if (a == 18) {
                    java.lang.String c2 = zVar.c();
                    this.h = true;
                    this.b = c2;
                } else if (a == 24) {
                    long f = zVar.f();
                    this.i = true;
                    this.c = f;
                } else if (a == 32) {
                    long f2 = zVar.f();
                    this.j = true;
                    this.d = f2;
                } else if (a == 40) {
                    boolean b = zVar.b();
                    this.k = true;
                    this.e = b;
                } else if (a == 48) {
                    int e = zVar.e();
                    this.l = true;
                    this.f = e;
                } else if (!zVar.b(a)) {
                    return this;
                }
            }
        }
    }
}
