package com.sijla.mla.a;

/* loaded from: classes19.dex */
public class o extends com.sijla.mla.a.r implements com.sijla.mla.a.s {
    private static final com.sijla.mla.a.n a = com.sijla.mla.a.n.c(com.sijla.mla.L2.s36118());
    private static final com.sijla.mla.a.o.g[] f = new com.sijla.mla.a.o.g[0];
    private com.sijla.mla.a.r[] b;
    private com.sijla.mla.a.o.g[] c;
    private int d;
    private com.sijla.mla.a.s e;

    public static class a implements com.sijla.mla.a.o.g {
        private final java.lang.Object a;
        private com.sijla.mla.a.o.g b;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.ref.WeakReference] */
        private a(com.sijla.mla.a.r rVar, com.sijla.mla.a.o.g gVar) {
            this.a = com.sijla.mla.a.o.t(rVar) ? new java.lang.ref.WeakReference(rVar) : rVar;
            this.b = gVar;
        }

        public /* synthetic */ a(com.sijla.mla.a.r rVar, com.sijla.mla.a.o.g gVar, byte b) {
            this(rVar, gVar);
        }

        private com.sijla.mla.a.r c() {
            java.lang.Object obj = this.a;
            if (obj instanceof java.lang.ref.WeakReference) {
                obj = ((java.lang.ref.WeakReference) obj).get();
            }
            return (com.sijla.mla.a.r) obj;
        }

        @Override // com.sijla.mla.a.o.g
        public final int a(int i) {
            return 0;
        }

        @Override // com.sijla.mla.a.o.g
        public final com.sijla.mla.a.o.g a(com.sijla.mla.a.o.g gVar) {
            com.sijla.mla.a.o.g gVar2 = this.b;
            return gVar2 != null ? gVar2.a(gVar) : gVar;
        }

        @Override // com.sijla.mla.a.o.g
        public final com.sijla.mla.a.o.g a(com.sijla.mla.a.o.h hVar) {
            if (c() == null) {
                return this.b;
            }
            this.b = this.b.a(hVar);
            return this;
        }

        @Override // com.sijla.mla.a.o.g
        public final com.sijla.mla.a.o.g a(com.sijla.mla.a.o.h hVar, com.sijla.mla.a.r rVar) {
            com.sijla.mla.a.o.g gVar = this.b;
            com.sijla.mla.a.o.g a = gVar != null ? gVar.a(hVar, rVar) : null;
            if (c() == null) {
                return a;
            }
            this.b = a;
            return this;
        }

        @Override // com.sijla.mla.a.o.g
        public final com.sijla.mla.a.o.h a() {
            return null;
        }

        @Override // com.sijla.mla.a.o.g
        public final com.sijla.mla.a.o.h a(com.sijla.mla.a.r rVar) {
            return null;
        }

        @Override // com.sijla.mla.a.o.g
        public final int b(int i) {
            return -1;
        }

        @Override // com.sijla.mla.a.o.g
        public final com.sijla.mla.a.o.g b(com.sijla.mla.a.o.g gVar) {
            return gVar;
        }

        @Override // com.sijla.mla.a.o.g
        public final boolean b(com.sijla.mla.a.r rVar) {
            com.sijla.mla.a.r c = c();
            return c != null && rVar.d(c);
        }

        @Override // com.sijla.mla.a.o.g
        public final com.sijla.mla.a.o.g l_() {
            return this.b;
        }

        public final java.lang.String toString() {
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            stringBuffer.append("<dead");
            com.sijla.mla.a.r c = c();
            if (c != null) {
                stringBuffer.append(": ");
                stringBuffer.append(c.toString());
            }
            stringBuffer.append(kotlin.text.Typography.greater);
            if (this.b != null) {
                stringBuffer.append("; ");
                stringBuffer.append(this.b.toString());
            }
            return stringBuffer.toString();
        }
    }

    public static abstract class b extends com.sijla.mla.a.y implements com.sijla.mla.a.o.h {
        @Override // com.sijla.mla.a.o.g
        public abstract int a(int i);

        @Override // com.sijla.mla.a.o.g
        public final com.sijla.mla.a.o.g a(com.sijla.mla.a.o.g gVar) {
            return new com.sijla.mla.a.o.d(this, gVar);
        }

        @Override // com.sijla.mla.a.o.g
        public final com.sijla.mla.a.o.g a(com.sijla.mla.a.o.h hVar) {
            return new com.sijla.mla.a.o.a(c(), null, (byte) 0);
        }

        @Override // com.sijla.mla.a.o.g
        public final com.sijla.mla.a.o.g a(com.sijla.mla.a.o.h hVar, com.sijla.mla.a.r rVar) {
            return c(rVar);
        }

        @Override // com.sijla.mla.a.o.g
        public final com.sijla.mla.a.o.h a() {
            return this;
        }

        @Override // com.sijla.mla.a.o.g
        public final com.sijla.mla.a.o.h a(com.sijla.mla.a.r rVar) {
            if (b(rVar)) {
                return this;
            }
            return null;
        }

        @Override // com.sijla.mla.a.o.g
        public int b(int i) {
            return 0;
        }

        @Override // com.sijla.mla.a.o.g
        public final com.sijla.mla.a.o.g b(com.sijla.mla.a.o.g gVar) {
            return gVar != null ? new com.sijla.mla.a.o.d(this, gVar) : this;
        }

        @Override // com.sijla.mla.a.o.g
        public abstract boolean b(com.sijla.mla.a.r rVar);

        @Override // com.sijla.mla.a.y
        public final com.sijla.mla.a.y b_(int i) {
            return i != 1 ? i != 2 ? com.sijla.mla.a.r.n : d() : this;
        }

        public abstract com.sijla.mla.a.o.b c(com.sijla.mla.a.r rVar);

        public abstract com.sijla.mla.a.r c();

        @Override // com.sijla.mla.a.y
        public final com.sijla.mla.a.r c(int i) {
            return i != 1 ? i != 2 ? com.sijla.mla.a.r.k : d() : c();
        }

        @Override // com.sijla.mla.a.o.h
        public abstract com.sijla.mla.a.r d();

        @Override // com.sijla.mla.a.y
        public final int e() {
            return 2;
        }

        @Override // com.sijla.mla.a.o.h
        public com.sijla.mla.a.y f() {
            return com.sijla.mla.a.r.a(c(), (com.sijla.mla.a.y) d());
        }

        @Override // com.sijla.mla.a.y
        public final com.sijla.mla.a.r h() {
            return c();
        }

        @Override // com.sijla.mla.a.o.g
        public final com.sijla.mla.a.o.g l_() {
            return null;
        }
    }

    public static class c extends com.sijla.mla.a.o.b {
        private final int a;
        private com.sijla.mla.a.r b;

        public c(int i, com.sijla.mla.a.r rVar) {
            this.a = i;
            this.b = rVar;
        }

        @Override // com.sijla.mla.a.o.b, com.sijla.mla.a.o.g
        public final int a(int i) {
            return com.sijla.mla.a.o.a(com.sijla.mla.a.k.d_(this.a), i);
        }

        @Override // com.sijla.mla.a.o.b, com.sijla.mla.a.o.g
        public final int b(int i) {
            int i2 = this.a;
            if (i2 <= 0 || i2 > i) {
                return 0;
            }
            return i2;
        }

        @Override // com.sijla.mla.a.o.b, com.sijla.mla.a.o.g
        public final boolean b(com.sijla.mla.a.r rVar) {
            return rVar.b(this.a);
        }

        @Override // com.sijla.mla.a.o.b
        public final com.sijla.mla.a.o.b c(com.sijla.mla.a.r rVar) {
            this.b = rVar;
            return this;
        }

        @Override // com.sijla.mla.a.o.b
        public final com.sijla.mla.a.r c() {
            return com.sijla.mla.a.r.o(this.a);
        }

        @Override // com.sijla.mla.a.o.b, com.sijla.mla.a.o.h
        public final com.sijla.mla.a.r d() {
            return this.b;
        }
    }

    public static class d implements com.sijla.mla.a.o.h {
        private com.sijla.mla.a.o.b a;
        private com.sijla.mla.a.o.g b;

        public d(com.sijla.mla.a.o.b bVar, com.sijla.mla.a.o.g gVar) {
            this.a = bVar;
            this.b = gVar;
        }

        private com.sijla.mla.a.o.g c(com.sijla.mla.a.o.g gVar) {
            if (gVar == null) {
                return this.a;
            }
            this.b = gVar;
            return this;
        }

        @Override // com.sijla.mla.a.o.g
        public final int a(int i) {
            return this.a.a(i);
        }

        @Override // com.sijla.mla.a.o.g
        public final com.sijla.mla.a.o.g a(com.sijla.mla.a.o.g gVar) {
            return c(this.b.a(gVar));
        }

        @Override // com.sijla.mla.a.o.g
        public final com.sijla.mla.a.o.g a(com.sijla.mla.a.o.h hVar) {
            if (this == hVar) {
                return new com.sijla.mla.a.o.a(this.a.c(), this.b, (byte) 0);
            }
            this.b = this.b.a(hVar);
            return this;
        }

        @Override // com.sijla.mla.a.o.g
        public final com.sijla.mla.a.o.g a(com.sijla.mla.a.o.h hVar, com.sijla.mla.a.r rVar) {
            if (hVar != this) {
                return c(this.b.a(hVar, rVar));
            }
            this.a = this.a.c(rVar);
            return this;
        }

        @Override // com.sijla.mla.a.o.g
        public final com.sijla.mla.a.o.h a() {
            return this.a;
        }

        @Override // com.sijla.mla.a.o.g
        public final com.sijla.mla.a.o.h a(com.sijla.mla.a.r rVar) {
            if (this.a.b(rVar)) {
                return this;
            }
            return null;
        }

        @Override // com.sijla.mla.a.o.g
        public final int b(int i) {
            return this.a.b(i);
        }

        @Override // com.sijla.mla.a.o.g
        public final com.sijla.mla.a.o.g b(com.sijla.mla.a.o.g gVar) {
            return gVar != null ? new com.sijla.mla.a.o.d(this.a, gVar) : this.a;
        }

        @Override // com.sijla.mla.a.o.g
        public final boolean b(com.sijla.mla.a.r rVar) {
            return this.a.b(rVar);
        }

        @Override // com.sijla.mla.a.o.h
        public final com.sijla.mla.a.r d() {
            return this.a.d();
        }

        @Override // com.sijla.mla.a.o.h
        public final com.sijla.mla.a.y f() {
            return this.a.f();
        }

        @Override // com.sijla.mla.a.o.g
        public final com.sijla.mla.a.o.g l_() {
            return this.b;
        }

        public final java.lang.String toString() {
            return this.a + "; " + this.b;
        }
    }

    public static class e extends com.sijla.mla.a.o.b {
        private final com.sijla.mla.a.r a;
        private com.sijla.mla.a.r b;

        public e(com.sijla.mla.a.r rVar, com.sijla.mla.a.r rVar2) {
            this.a = rVar;
            this.b = rVar2;
        }

        @Override // com.sijla.mla.a.o.b, com.sijla.mla.a.o.g
        public final int a(int i) {
            return com.sijla.mla.a.o.a(this.a, i);
        }

        @Override // com.sijla.mla.a.o.b, com.sijla.mla.a.o.g
        public final boolean b(com.sijla.mla.a.r rVar) {
            return rVar.d(this.a);
        }

        @Override // com.sijla.mla.a.o.b
        public final com.sijla.mla.a.o.b c(com.sijla.mla.a.r rVar) {
            this.b = rVar;
            return this;
        }

        @Override // com.sijla.mla.a.o.b
        public final com.sijla.mla.a.r c() {
            return this.a;
        }

        @Override // com.sijla.mla.a.o.b, com.sijla.mla.a.o.h
        public final com.sijla.mla.a.r d() {
            return this.b;
        }

        @Override // com.sijla.mla.a.o.b, com.sijla.mla.a.o.h
        public final com.sijla.mla.a.y f() {
            return this;
        }
    }

    public static class f extends com.sijla.mla.a.o.b {
        private double a;
        private final com.sijla.mla.a.r b;

        public f(com.sijla.mla.a.r rVar, double d) {
            this.b = rVar;
            this.a = d;
        }

        @Override // com.sijla.mla.a.o.b, com.sijla.mla.a.o.g
        public final int a(int i) {
            return com.sijla.mla.a.o.a(this.b, i);
        }

        @Override // com.sijla.mla.a.o.b, com.sijla.mla.a.o.g
        public final boolean b(com.sijla.mla.a.r rVar) {
            return rVar.d(this.b);
        }

        @Override // com.sijla.mla.a.o.b
        public final com.sijla.mla.a.o.b c(com.sijla.mla.a.r rVar) {
            com.sijla.mla.a.r w = rVar.w();
            if (w.J()) {
                return new com.sijla.mla.a.o.e(this.b, rVar);
            }
            this.a = w.o();
            return this;
        }

        @Override // com.sijla.mla.a.o.b
        public final com.sijla.mla.a.r c() {
            return this.b;
        }

        @Override // com.sijla.mla.a.o.b, com.sijla.mla.a.o.h
        public final com.sijla.mla.a.r d() {
            return com.sijla.mla.a.r.l(this.a);
        }
    }

    public interface g {
        int a(int i);

        com.sijla.mla.a.o.g a(com.sijla.mla.a.o.g gVar);

        com.sijla.mla.a.o.g a(com.sijla.mla.a.o.h hVar);

        com.sijla.mla.a.o.g a(com.sijla.mla.a.o.h hVar, com.sijla.mla.a.r rVar);

        com.sijla.mla.a.o.h a();

        com.sijla.mla.a.o.h a(com.sijla.mla.a.r rVar);

        int b(int i);

        com.sijla.mla.a.o.g b(com.sijla.mla.a.o.g gVar);

        boolean b(com.sijla.mla.a.r rVar);

        com.sijla.mla.a.o.g l_();
    }

    public interface h extends com.sijla.mla.a.o.g {
        com.sijla.mla.a.r d();

        com.sijla.mla.a.y f();
    }

    public o() {
        this.b = com.sijla.mla.a.r.q;
        this.c = f;
    }

    public o(int i, int i2) {
        d(i, i2);
    }

    public o(com.sijla.mla.a.y yVar) {
        int max = java.lang.Math.max(yVar.e(), 0);
        d(max, 1);
        a((com.sijla.mla.a.r) a, (com.sijla.mla.a.r) com.sijla.mla.a.k.c_(max));
        for (int i = 1; i <= max; i++) {
            a(i, yVar.c(i));
        }
    }

    public o(com.sijla.mla.a.r[] rVarArr) {
        d(0, 1);
        if (rVarArr[1].J()) {
            return;
        }
        c(rVarArr[0], rVarArr[1]);
    }

    private int A(com.sijla.mla.a.r rVar) {
        return a(rVar, this.c.length - 1);
    }

    private void A(int i) {
        com.sijla.mla.a.r[] rVarArr;
        com.sijla.mla.a.o.g[] gVarArr;
        int i2;
        com.sijla.mla.a.o.g e2;
        com.sijla.mla.a.s sVar = this.e;
        if (sVar != null && (sVar.i_() || this.e.j_())) {
            this.d = af();
            if (this.e.j_()) {
                ag();
            }
        }
        int[] iArr = new int[32];
        int a2 = a(iArr);
        if (i > 0) {
            a2++;
            int z = z(i);
            iArr[z] = iArr[z] + 1;
        }
        int i3 = iArr[0];
        int i4 = 0;
        for (int i5 = 1; i5 < 32; i5++) {
            i3 += iArr[i5];
            int i6 = 1 << i5;
            if ((a2 << 1) < i6) {
                break;
            }
            if (i3 >= (1 << (i5 - 1))) {
                i4 = i6;
            }
        }
        com.sijla.mla.a.r[] rVarArr2 = this.b;
        com.sijla.mla.a.o.g[] gVarArr2 = this.c;
        int i7 = (i <= 0 || i > i4) ? 0 : -1;
        if (i4 != rVarArr2.length) {
            rVarArr = new com.sijla.mla.a.r[i4];
            if (i4 > rVarArr2.length) {
                int z2 = z(i4) + 1;
                for (int z3 = z(rVarArr2.length + 1); z3 < z2; z3++) {
                    i7 += iArr[z3];
                }
            } else if (rVarArr2.length > i4) {
                int z4 = z(rVarArr2.length) + 1;
                for (int z5 = z(i4 + 1); z5 < z4; z5++) {
                    i7 -= iArr[z5];
                }
            }
            java.lang.System.arraycopy(rVarArr2, 0, rVarArr, 0, java.lang.Math.min(rVarArr2.length, i4));
        } else {
            rVarArr = rVarArr2;
        }
        int i8 = (this.d - i7) + ((i < 0 || i > i4) ? 1 : 0);
        if (i8 > 0) {
            int z6 = i8 >= 2 ? 1 << z(i8) : 2;
            i2 = z6 - 1;
            gVarArr = new com.sijla.mla.a.o.g[z6];
        } else {
            gVarArr = f;
            i2 = 0;
        }
        for (com.sijla.mla.a.o.g gVar : gVarArr2) {
            for (; gVar != null; gVar = gVar.l_()) {
                int b2 = gVar.b(i4);
                if (b2 > 0) {
                    com.sijla.mla.a.o.h a3 = gVar.a();
                    if (a3 != null) {
                        rVarArr[b2 - 1] = a3.d();
                    }
                } else {
                    int a4 = gVar.a(i2);
                    gVarArr[a4] = gVar.b(gVarArr[a4]);
                }
            }
        }
        while (i4 < rVarArr2.length) {
            int i9 = i4 + 1;
            com.sijla.mla.a.r rVar = rVarArr2[i4];
            if (rVar != null) {
                int d_ = (com.sijla.mla.a.k.d_(i9) & Integer.MAX_VALUE) % i2;
                com.sijla.mla.a.s sVar2 = this.e;
                if (sVar2 != null) {
                    e2 = sVar2.d(com.sijla.mla.a.k.c_(i9), rVar);
                    if (e2 == null) {
                    }
                } else {
                    e2 = e(com.sijla.mla.a.k.c_(i9), rVar);
                }
                com.sijla.mla.a.o.g gVar2 = gVarArr[d_];
                if (gVar2 != null) {
                    e2 = gVar2.a(e2);
                }
                gVarArr[d_] = e2;
            }
            i4 = i9;
        }
        this.c = gVarArr;
        this.b = rVarArr;
        this.d -= i7;
    }

    private void B(com.sijla.mla.a.r rVar) {
        if (this.c.length > 0) {
            int A = A(rVar);
            for (com.sijla.mla.a.o.g gVar = this.c[A]; gVar != null; gVar = gVar.l_()) {
                com.sijla.mla.a.o.h a2 = gVar.a(rVar);
                if (a2 != null) {
                    com.sijla.mla.a.o.g[] gVarArr = this.c;
                    gVarArr[A] = gVarArr[A].a(a2);
                    this.d--;
                    return;
                }
            }
        }
    }

    public static int a(int i, int i2) {
        return (i & Integer.MAX_VALUE) % i2;
    }

    public static int a(com.sijla.mla.a.r rVar, int i) {
        int a_ = rVar.a_();
        return (a_ == 2 || a_ == 3 || a_ == 5 || a_ == 7 || a_ == 8) ? (rVar.hashCode() & Integer.MAX_VALUE) % i : rVar.hashCode() & i;
    }

    private int a(int[] iArr) {
        int i = 0;
        int i2 = 1;
        int i3 = 0;
        for (int i4 = 0; i4 < 31; i4++) {
            com.sijla.mla.a.r[] rVarArr = this.b;
            if (i2 > rVarArr.length) {
                break;
            }
            int min = java.lang.Math.min(rVarArr.length, 1 << i4);
            int i5 = 0;
            while (i2 <= min) {
                int i6 = i2 + 1;
                if (this.b[i2 - 1] != null) {
                    i5++;
                }
                i2 = i6;
            }
            iArr[i4] = i5;
            i3 += i5;
        }
        while (true) {
            com.sijla.mla.a.o.g[] gVarArr = this.c;
            if (i >= gVarArr.length) {
                return i3;
            }
            for (com.sijla.mla.a.o.g gVar = gVarArr[i]; gVar != null; gVar = gVar.l_()) {
                int b2 = gVar.b(Integer.MAX_VALUE);
                if (b2 > 0) {
                    int z = z(b2);
                    iArr[z] = iArr[z] + 1;
                    i3++;
                }
            }
            i++;
        }
    }

    private void a(int i, int i2, com.sijla.mla.a.r rVar) {
        while (true) {
            int i3 = (i << 1) + 1;
            if (i3 > i2) {
                return;
            }
            if (i3 < i2) {
                int i4 = i3 + 1;
                if (b(i3, i4, rVar)) {
                    i3 = i4;
                }
            }
            if (!b(i, i3, rVar)) {
                return;
            }
            e(i, i3);
            i = i3;
        }
    }

    private boolean ae() {
        return this.d >= this.c.length;
    }

    private int af() {
        int i = 0;
        int i2 = 0;
        while (true) {
            com.sijla.mla.a.o.g[] gVarArr = this.c;
            if (i >= gVarArr.length) {
                return i2;
            }
            for (com.sijla.mla.a.o.g gVar = gVarArr[i]; gVar != null; gVar = gVar.l_()) {
                if (gVar.a() != null) {
                    i2++;
                }
            }
            i++;
        }
    }

    private void ag() {
        int i = 0;
        while (true) {
            com.sijla.mla.a.r[] rVarArr = this.b;
            if (i >= rVarArr.length) {
                return;
            }
            this.e.a(rVarArr, i);
            i++;
        }
    }

    private boolean b(int i, int i2, com.sijla.mla.a.r rVar) {
        com.sijla.mla.a.r a2;
        com.sijla.mla.a.r a3;
        com.sijla.mla.a.s sVar = this.e;
        if (sVar == null) {
            com.sijla.mla.a.r[] rVarArr = this.b;
            a2 = rVarArr[i];
            a3 = rVarArr[i2];
        } else {
            a2 = sVar.a(this.b, i);
            a3 = this.e.a(this.b, i2);
        }
        if (a2 == null || a3 == null) {
            return false;
        }
        return !rVar.J() ? rVar.b(a2, a3).f() : a2.k(a3);
    }

    private void d(int i, int i2) {
        if (i2 > 0 && i2 < 2) {
            i2 = 2;
        }
        this.b = i > 0 ? new com.sijla.mla.a.r[1 << z(i)] : com.sijla.mla.a.r.q;
        this.c = i2 > 0 ? new com.sijla.mla.a.o.g[1 << z(i2)] : f;
        this.d = 0;
    }

    public static com.sijla.mla.a.o.b e(com.sijla.mla.a.r rVar, com.sijla.mla.a.r rVar2) {
        return rVar.I() ? new com.sijla.mla.a.o.c(rVar.p(), rVar2) : rVar2.a_() == 3 ? new com.sijla.mla.a.o.f(rVar, rVar2.o()) : new com.sijla.mla.a.o.e(rVar, rVar2);
    }

    private void e(int i, int i2) {
        com.sijla.mla.a.r[] rVarArr = this.b;
        com.sijla.mla.a.r rVar = rVarArr[i];
        rVarArr[i] = rVarArr[i2];
        rVarArr[i2] = rVar;
    }

    private boolean e(int i, com.sijla.mla.a.r rVar) {
        if (i <= 0) {
            return false;
        }
        com.sijla.mla.a.r[] rVarArr = this.b;
        if (i > rVarArr.length) {
            return false;
        }
        int i2 = i - 1;
        if (rVar.J()) {
            rVar = null;
        } else {
            com.sijla.mla.a.s sVar = this.e;
            if (sVar != null) {
                rVar = sVar.v(rVar);
            }
        }
        rVarArr[i2] = rVar;
        return true;
    }

    private void h(com.sijla.mla.a.r rVar, com.sijla.mla.a.r rVar2) {
        int i;
        if (rVar2.J()) {
            B(rVar);
            return;
        }
        if (this.c.length > 0) {
            i = A(rVar);
            for (com.sijla.mla.a.o.g gVar = this.c[i]; gVar != null; gVar = gVar.l_()) {
                com.sijla.mla.a.o.h a2 = gVar.a(rVar);
                if (a2 != null) {
                    com.sijla.mla.a.o.g[] gVarArr = this.c;
                    gVarArr[i] = gVarArr[i].a(a2, rVar2);
                    return;
                }
            }
        } else {
            i = 0;
        }
        if (ae()) {
            if (!rVar.I() || rVar.p() <= 0) {
                A(-1);
            } else {
                A(rVar.p());
                if (e(rVar.p(), rVar2)) {
                    return;
                }
            }
            i = A(rVar);
        }
        com.sijla.mla.a.s sVar = this.e;
        com.sijla.mla.a.o.g d2 = sVar != null ? sVar.d(rVar, rVar2) : e(rVar, rVar2);
        com.sijla.mla.a.o.g[] gVarArr2 = this.c;
        com.sijla.mla.a.o.g gVar2 = gVarArr2[i];
        if (gVar2 != null) {
            d2 = gVar2.a(d2);
        }
        gVarArr2[i] = d2;
        this.d++;
    }

    public static boolean t(com.sijla.mla.a.r rVar) {
        int a_ = rVar.a_();
        return (a_ == 1 || a_ == 3 || (a_ == 4 && rVar.O() <= 32)) ? false : true;
    }

    private static int z(int i) {
        int i2;
        int i3 = i - 1;
        if (i3 < 0) {
            return Integer.MIN_VALUE;
        }
        if (((-65536) & i3) != 0) {
            i3 >>>= 16;
            i2 = 16;
        } else {
            i2 = 0;
        }
        if ((65280 & i3) != 0) {
            i2 += 8;
            i3 >>>= 8;
        }
        if ((i3 & 240) != 0) {
            i2 += 4;
            i3 >>>= 4;
        }
        switch (i3) {
            case 0:
                return 0;
            case 1:
                return i2 + 1;
            case 2:
            case 3:
                return i2 + 2;
            case 4:
            case 5:
            case 6:
            case 7:
                return i2 + 3;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return i2 + 4;
            default:
                return i2;
        }
    }

    private com.sijla.mla.a.r z(com.sijla.mla.a.r rVar) {
        if (this.d > 0) {
            for (com.sijla.mla.a.o.g gVar = this.c[A(rVar)]; gVar != null; gVar = gVar.l_()) {
                com.sijla.mla.a.o.h a2 = gVar.a(rVar);
                if (a2 != null) {
                    return a2.d();
                }
            }
        }
        return com.sijla.mla.a.r.k;
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.o L() {
        return this;
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r M() {
        com.sijla.mla.a.r y = y(com.sijla.mla.a.r.D);
        return y.f() ? y.b((com.sijla.mla.a.r) this) : com.sijla.mla.a.k.c_(O());
    }

    @Override // com.sijla.mla.a.r
    public final int N() {
        return this.e != null ? M().p() : O();
    }

    @Override // com.sijla.mla.a.r
    public final int O() {
        int length = this.b.length;
        int i = length + 1;
        int i2 = 0;
        while (!l(i).J()) {
            i2 = i;
            i = this.c.length + length + 1 + i;
        }
        while (i > i2 + 1) {
            int i3 = (i + i2) / 2;
            if (l(i3).J()) {
                i = i3;
            } else {
                i2 = i3;
            }
        }
        return i2;
    }

    @Override // com.sijla.mla.a.r
    public final boolean P() {
        return true;
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.o Q() {
        return this;
    }

    public final com.sijla.mla.a.r a(com.sijla.mla.a.n nVar, int i, int i2) {
        com.sijla.mla.a.a aVar = new com.sijla.mla.a.a();
        if (i <= i2) {
            while (true) {
                aVar.a(i(i).C());
                i++;
                if (i > i2) {
                    break;
                }
                aVar.a(nVar);
            }
        }
        return aVar.b();
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r a(com.sijla.mla.a.r rVar) {
        com.sijla.mla.a.r q = q(rVar);
        return (!q.J() || this.e == null) ? q : com.sijla.mla.a.r.g(this, rVar);
    }

    @Override // com.sijla.mla.a.s
    public final com.sijla.mla.a.r a(com.sijla.mla.a.r[] rVarArr, int i) {
        return rVarArr[i];
    }

    @Override // com.sijla.mla.a.r
    public final void a(int i, com.sijla.mla.a.r rVar) {
        if (this.e != null && l(i).J() && com.sijla.mla.a.r.b(this, com.sijla.mla.a.k.c_(i), rVar)) {
            return;
        }
        b(i, rVar);
    }

    @Override // com.sijla.mla.a.r
    public final void a(com.sijla.mla.a.r rVar, com.sijla.mla.a.r rVar2) {
        if (!rVar.D() && !y(com.sijla.mla.a.r.t).E()) {
            f("table index");
        }
        if (this.e != null && q(rVar).J() && com.sijla.mla.a.r.b(this, rVar, rVar2)) {
            return;
        }
        c(rVar, rVar2);
    }

    @Override // com.sijla.mla.a.r
    public final int a_() {
        return 5;
    }

    public final com.sijla.mla.a.y b(int i, int i2) {
        int i3 = (i2 + 1) - i;
        if (i3 == 0) {
            return com.sijla.mla.a.r.n;
        }
        if (i3 == 1) {
            return i(i);
        }
        if (i3 == 2) {
            return com.sijla.mla.a.r.a(i(i), (com.sijla.mla.a.y) i(i + 1));
        }
        if (i3 < 0) {
            return com.sijla.mla.a.r.n;
        }
        com.sijla.mla.a.r[] rVarArr = new com.sijla.mla.a.r[i3];
        while (true) {
            i3--;
            if (i3 < 0) {
                return com.sijla.mla.a.r.a(rVarArr);
            }
            rVarArr[i3] = i(i + i3);
        }
    }

    @Override // com.sijla.mla.a.r
    public final void b(int i, com.sijla.mla.a.r rVar) {
        if (e(i, rVar)) {
            return;
        }
        h(com.sijla.mla.a.k.c_(i), rVar);
    }

    @Override // com.sijla.mla.a.r
    public final java.lang.String c() {
        return com.sijla.mla.L2.s771023690();
    }

    public final void c(int i, com.sijla.mla.a.r rVar) {
        if (i == 0) {
            i = O() + 1;
        }
        while (!rVar.J()) {
            com.sijla.mla.a.r l = l(i);
            b(i, rVar);
            rVar = l;
            i++;
        }
    }

    @Override // com.sijla.mla.a.r
    public final void c(com.sijla.mla.a.r rVar, com.sijla.mla.a.r rVar2) {
        if (rVar.I() && e(rVar.p(), rVar2)) {
            return;
        }
        h(rVar, rVar2);
    }

    @Override // com.sijla.mla.a.r
    public final boolean c(com.sijla.mla.a.r rVar) {
        com.sijla.mla.a.r j;
        if (this == rVar) {
            return true;
        }
        return this.e != null && rVar.P() && (j = rVar.j()) != null && com.sijla.mla.a.r.a(this, this.e.k_(), rVar, j);
    }

    @Override // com.sijla.mla.a.s
    public final com.sijla.mla.a.o.g d(com.sijla.mla.a.r rVar, com.sijla.mla.a.r rVar2) {
        return e(rVar, rVar2);
    }

    @Override // com.sijla.mla.a.r
    public final void f_(int i) {
        com.sijla.mla.a.r[] rVarArr = this.b;
        if (i > rVarArr.length) {
            com.sijla.mla.a.r[] rVarArr2 = new com.sijla.mla.a.r[1 << z(i)];
            java.lang.System.arraycopy(rVarArr, 0, rVarArr2, 0, rVarArr.length);
            this.b = rVarArr2;
        }
    }

    public final com.sijla.mla.a.r[] g_() {
        java.util.Vector vector = new java.util.Vector();
        com.sijla.mla.a.r rVar = com.sijla.mla.a.r.k;
        while (true) {
            rVar = r(rVar).h();
            if (rVar.J()) {
                com.sijla.mla.a.r[] rVarArr = new com.sijla.mla.a.r[vector.size()];
                vector.copyInto(rVarArr);
                return rVarArr;
            }
            vector.addElement(rVar);
        }
    }

    public final com.sijla.mla.a.y h_() {
        return b(1, O());
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r i(int i) {
        com.sijla.mla.a.r l = l(i);
        return (!l.J() || this.e == null) ? l : com.sijla.mla.a.r.g(this, com.sijla.mla.a.k.c_(i));
    }

    @Override // com.sijla.mla.a.s
    public final boolean i_() {
        return false;
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r j() {
        com.sijla.mla.a.s sVar = this.e;
        if (sVar != null) {
            return sVar.k_();
        }
        return null;
    }

    @Override // com.sijla.mla.a.s
    public final boolean j_() {
        return false;
    }

    @Override // com.sijla.mla.a.s
    public final com.sijla.mla.a.r k_() {
        return this;
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r l(int i) {
        if (i > 0) {
            com.sijla.mla.a.r[] rVarArr = this.b;
            if (i <= rVarArr.length) {
                com.sijla.mla.a.s sVar = this.e;
                int i2 = i - 1;
                com.sijla.mla.a.r a2 = sVar == null ? rVarArr[i2] : sVar.a(rVarArr, i2);
                return a2 != null ? a2 : com.sijla.mla.a.r.k;
            }
        }
        return z(com.sijla.mla.a.k.c_(i));
    }

    public final com.sijla.mla.a.r m(int i) {
        int O = O();
        if (i == 0) {
            i = O;
        } else if (i > O) {
            return com.sijla.mla.a.r.n;
        }
        com.sijla.mla.a.r l = l(i);
        com.sijla.mla.a.r rVar = l;
        while (!rVar.J()) {
            int i2 = i + 1;
            com.sijla.mla.a.r l2 = l(i2);
            b(i, l2);
            i = i2;
            rVar = l2;
        }
        return l.J() ? com.sijla.mla.a.r.n : l;
    }

    public final com.sijla.mla.a.y n(int i) {
        return b(i, O());
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x007c, code lost:
    
        if (r3 != (r8 != null && r8.j_())) goto L48;
     */
    @Override // com.sijla.mla.a.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final com.sijla.mla.a.r p(com.sijla.mla.a.r rVar) {
        com.sijla.mla.a.s tVar;
        com.sijla.mla.a.s sVar = this.e;
        boolean z = sVar != null && sVar.i_();
        com.sijla.mla.a.s sVar2 = this.e;
        boolean z2 = sVar2 != null && sVar2.j_();
        if (rVar == null || !rVar.P()) {
            tVar = rVar != null ? new com.sijla.mla.a.t(rVar) : null;
        } else {
            com.sijla.mla.a.r q = rVar.q(com.sijla.mla.a.r.u);
            if (q.v()) {
                java.lang.String g2 = q.g();
                boolean z3 = g2.indexOf(107) >= 0;
                boolean z4 = g2.indexOf(118) >= 0;
                if (z3 || z4) {
                    tVar = new com.sijla.mla.a.z(z3, z4, rVar);
                }
            }
            tVar = (com.sijla.mla.a.o) rVar;
        }
        this.e = tVar;
        if (z == (tVar != null && tVar.i_())) {
            com.sijla.mla.a.s sVar3 = this.e;
        }
        A(0);
        return this;
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r q(com.sijla.mla.a.r rVar) {
        int p;
        if (rVar.I() && (p = rVar.p()) > 0) {
            com.sijla.mla.a.r[] rVarArr = this.b;
            if (p <= rVarArr.length) {
                com.sijla.mla.a.s sVar = this.e;
                int i = p - 1;
                com.sijla.mla.a.r a2 = sVar == null ? rVarArr[i] : sVar.a(rVarArr, i);
                return a2 != null ? a2 : com.sijla.mla.a.r.k;
            }
        }
        return z(rVar);
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.y r(com.sijla.mla.a.r rVar) {
        int p;
        int i = 0;
        if (!rVar.J()) {
            if (!rVar.I() || (p = rVar.p()) <= 0 || p > this.b.length) {
                if (this.c.length == 0) {
                    com.sijla.mla.a.r.d("invalid key to 'next'");
                }
                int A = A(rVar);
                for (com.sijla.mla.a.o.g gVar = this.c[A]; gVar != null; gVar = gVar.l_()) {
                    if (i != 0) {
                        com.sijla.mla.a.o.h a2 = gVar.a();
                        if (a2 != null) {
                            return a2.f();
                        }
                    } else if (gVar.b(rVar)) {
                        i = 1;
                    }
                }
                if (i == 0) {
                    com.sijla.mla.a.r.d("invalid key to 'next'");
                }
                i = A + this.b.length + 1;
            } else {
                i = p;
            }
        }
        while (true) {
            com.sijla.mla.a.r[] rVarArr = this.b;
            if (i < rVarArr.length) {
                com.sijla.mla.a.r rVar2 = rVarArr[i];
                if (rVar2 != null) {
                    com.sijla.mla.a.s sVar = this.e;
                    if (sVar != null) {
                        rVar2 = sVar.a(rVarArr, i);
                    }
                    if (rVar2 != null) {
                        return com.sijla.mla.a.r.a((com.sijla.mla.a.r) com.sijla.mla.a.k.c_(i + 1), (com.sijla.mla.a.y) rVar2);
                    }
                }
                i++;
            } else {
                int length = i - rVarArr.length;
                while (true) {
                    com.sijla.mla.a.o.g[] gVarArr = this.c;
                    if (length >= gVarArr.length) {
                        return com.sijla.mla.a.r.k;
                    }
                    for (com.sijla.mla.a.o.g gVar2 = gVarArr[length]; gVar2 != null; gVar2 = gVar2.l_()) {
                        com.sijla.mla.a.o.h a3 = gVar2.a();
                        if (a3 != null) {
                            return a3.f();
                        }
                    }
                    length++;
                }
            }
        }
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.y s(com.sijla.mla.a.r rVar) {
        int x = rVar.x() + 1;
        com.sijla.mla.a.r l = l(x);
        return l.J() ? com.sijla.mla.a.r.n : com.sijla.mla.a.r.a((com.sijla.mla.a.r) com.sijla.mla.a.k.c_(x), (com.sijla.mla.a.y) l);
    }

    public final void u(com.sijla.mla.a.r rVar) {
        com.sijla.mla.a.s sVar = this.e;
        if (sVar != null && sVar.j_()) {
            ag();
        }
        int length = this.b.length;
        while (length > 0 && this.b[length - 1] == null) {
            length--;
        }
        if (length > 1) {
            for (int i = (length / 2) - 1; i >= 0; i--) {
                a(i, length - 1, rVar);
            }
            int i2 = length - 1;
            while (i2 > 0) {
                e(i2, 0);
                i2--;
                a(0, i2, rVar);
            }
        }
    }

    @Override // com.sijla.mla.a.s
    public final com.sijla.mla.a.r v(com.sijla.mla.a.r rVar) {
        return rVar;
    }
}
