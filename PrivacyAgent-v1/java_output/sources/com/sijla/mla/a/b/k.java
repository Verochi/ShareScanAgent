package com.sijla.mla.a.b;

/* loaded from: classes19.dex */
public final class k extends com.sijla.mla.a.b.s {
    private static com.sijla.mla.a.b.k a;

    public static abstract class a extends com.sijla.mla.a.b.s {
        public abstract double a(double d, double d2);

        @Override // com.sijla.mla.a.b.s, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.r b(com.sijla.mla.a.r rVar, com.sijla.mla.a.r rVar2) {
            return com.sijla.mla.a.h.a(a(rVar.A(), rVar2.A()));
        }
    }

    public static abstract class b extends com.sijla.mla.a.b.l {
        public abstract double a(double d);

        @Override // com.sijla.mla.a.b.l, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.r b(com.sijla.mla.a.r rVar) {
            return com.sijla.mla.a.h.a(a(rVar.A()));
        }
    }

    public static final class c extends com.sijla.mla.a.b.k.b {
        @Override // com.sijla.mla.a.b.k.b
        public final double a(double d) {
            return java.lang.Math.abs(d);
        }
    }

    public static final class d extends com.sijla.mla.a.b.k.b {
        @Override // com.sijla.mla.a.b.k.b
        public final double a(double d) {
            return java.lang.Math.ceil(d);
        }
    }

    public static final class e extends com.sijla.mla.a.b.k.b {
        @Override // com.sijla.mla.a.b.k.b
        public final double a(double d) {
            return java.lang.Math.cos(d);
        }
    }

    public static final class f extends com.sijla.mla.a.b.k.b {
        @Override // com.sijla.mla.a.b.k.b
        public final double a(double d) {
            return java.lang.Math.toDegrees(d);
        }
    }

    public static final class g extends com.sijla.mla.a.b.k.b {
        private com.sijla.mla.a.b.k a;

        public g(com.sijla.mla.a.b.k kVar) {
            this.a = kVar;
        }

        @Override // com.sijla.mla.a.b.k.b
        public final double a(double d) {
            return com.sijla.mla.a.b.k.m(d);
        }
    }

    public static final class h extends com.sijla.mla.a.b.k.b {
        @Override // com.sijla.mla.a.b.k.b
        public final double a(double d) {
            return java.lang.Math.floor(d);
        }
    }

    public static final class i extends com.sijla.mla.a.b.k.a {
        @Override // com.sijla.mla.a.b.k.a
        public final double a(double d, double d2) {
            double d3 = d / d2;
            return d - (d2 * (d3 >= 0.0d ? java.lang.Math.floor(d3) : java.lang.Math.ceil(d3)));
        }
    }

    public static class j extends com.sijla.mla.a.b.t {
        @Override // com.sijla.mla.a.b.t, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.y a(com.sijla.mla.a.y yVar) {
            double s2 = yVar.s(1);
            if (s2 == 0.0d) {
                com.sijla.mla.a.m mVar = com.sijla.mla.a.r.o;
                return com.sijla.mla.a.r.a((com.sijla.mla.a.r) mVar, (com.sijla.mla.a.y) mVar);
            }
            return com.sijla.mla.a.r.a((com.sijla.mla.a.r) com.sijla.mla.a.h.a(((4503599627370495L & r0) + 4503599627370496L) * (java.lang.Double.doubleToLongBits(s2) >= 0 ? 1.1102230246251565E-16d : -1.1102230246251565E-16d)), (com.sijla.mla.a.y) com.sijla.mla.a.h.a((((int) (r0 >> 52)) & 2047) - 1022));
        }
    }

    /* renamed from: com.sijla.mla.a.b.k$k, reason: collision with other inner class name */
    public static final class C0462k extends com.sijla.mla.a.b.k.a {
        @Override // com.sijla.mla.a.b.k.a
        public final double a(double d, double d2) {
            return d * java.lang.Double.longBitsToDouble((((long) d2) + 1023) << 52);
        }
    }

    public static class l extends com.sijla.mla.a.b.t {
        @Override // com.sijla.mla.a.b.t, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.y a(com.sijla.mla.a.y yVar) {
            double s2 = yVar.s(1);
            int e = yVar.e();
            for (int i = 2; i <= e; i++) {
                s2 = java.lang.Math.max(s2, yVar.s(i));
            }
            return com.sijla.mla.a.h.a(s2);
        }
    }

    public static class m extends com.sijla.mla.a.b.t {
        @Override // com.sijla.mla.a.b.t, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.y a(com.sijla.mla.a.y yVar) {
            double s2 = yVar.s(1);
            int e = yVar.e();
            for (int i = 2; i <= e; i++) {
                s2 = java.lang.Math.min(s2, yVar.s(i));
            }
            return com.sijla.mla.a.h.a(s2);
        }
    }

    public static class n extends com.sijla.mla.a.b.t {
        @Override // com.sijla.mla.a.b.t, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.y a(com.sijla.mla.a.y yVar) {
            double s2 = yVar.s(1);
            double floor = s2 > 0.0d ? java.lang.Math.floor(s2) : java.lang.Math.ceil(s2);
            return com.sijla.mla.a.r.a((com.sijla.mla.a.r) com.sijla.mla.a.h.a(floor), (com.sijla.mla.a.y) com.sijla.mla.a.h.a(s2 - floor));
        }
    }

    public static final class o extends com.sijla.mla.a.b.k.a {
        @Override // com.sijla.mla.a.b.k.a
        public final double a(double d, double d2) {
            return com.sijla.mla.a.b.k.b(d, d2);
        }
    }

    public static final class p extends com.sijla.mla.a.b.k.b {
        @Override // com.sijla.mla.a.b.k.b
        public final double a(double d) {
            return java.lang.Math.toRadians(d);
        }
    }

    public static class q extends com.sijla.mla.a.b.j {
        java.util.Random a = new java.util.Random();

        @Override // com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.r b(com.sijla.mla.a.r rVar) {
            int x = rVar.x();
            if (x <= 0) {
                com.sijla.mla.a.r.a(1, "interval is empty");
            }
            return com.sijla.mla.a.k.c_(this.a.nextInt(x) + 1);
        }

        @Override // com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.r b(com.sijla.mla.a.r rVar, com.sijla.mla.a.r rVar2) {
            int x = rVar.x();
            int x2 = rVar2.x();
            if (x2 < x) {
                com.sijla.mla.a.r.a(2, "interval is empty");
            }
            return com.sijla.mla.a.k.c_(x + this.a.nextInt((x2 + 1) - x));
        }

        @Override // com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.r m() {
            return com.sijla.mla.a.h.a(this.a.nextDouble());
        }
    }

    public static class r extends com.sijla.mla.a.b.l {
        private com.sijla.mla.a.b.k.q a;

        public r(com.sijla.mla.a.b.k.q qVar) {
            this.a = qVar;
        }

        @Override // com.sijla.mla.a.b.l, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.r b(com.sijla.mla.a.r rVar) {
            long y = rVar.y();
            this.a.a = new java.util.Random(y);
            return com.sijla.mla.a.r.n;
        }
    }

    public static final class s extends com.sijla.mla.a.b.k.b {
        @Override // com.sijla.mla.a.b.k.b
        public final double a(double d) {
            return java.lang.Math.sin(d);
        }
    }

    public static final class t extends com.sijla.mla.a.b.k.b {
        @Override // com.sijla.mla.a.b.k.b
        public final double a(double d) {
            return java.lang.Math.sqrt(d);
        }
    }

    public static final class u extends com.sijla.mla.a.b.k.b {
        @Override // com.sijla.mla.a.b.k.b
        public final double a(double d) {
            return java.lang.Math.tan(d);
        }
    }

    public k() {
        a = this;
    }

    public static double a(double d2) {
        com.sijla.mla.a.b.k kVar = a;
        return b(2.0d, d2);
    }

    public static com.sijla.mla.a.r a(double d2, double d3) {
        return com.sijla.mla.a.h.a(b(d2, d3));
    }

    public static double b(double d2, double d3) {
        double d4 = 1.0d;
        if (d3 < 0.0d) {
            return 1.0d / b(d2, -d3);
        }
        int i2 = (int) d3;
        double d5 = d2;
        while (i2 > 0) {
            if ((i2 & 1) != 0) {
                d4 *= d5;
            }
            i2 >>= 1;
            d5 *= d5;
        }
        double d6 = d3 - i2;
        if (d6 > 0.0d) {
            for (int i3 = (int) (d6 * 65536.0d); (65535 & i3) != 0; i3 <<= 1) {
                d2 = java.lang.Math.sqrt(d2);
                if ((32768 & i3) != 0) {
                    d4 *= d2;
                }
            }
        }
        return d4;
    }

    public static double m(double d2) {
        return b(2.718281828459045d, d2);
    }

    @Override // com.sijla.mla.a.b.s, com.sijla.mla.a.b.j, com.sijla.mla.a.r
    public final com.sijla.mla.a.r b(com.sijla.mla.a.r rVar, com.sijla.mla.a.r rVar2) {
        com.sijla.mla.a.r oVar = new com.sijla.mla.a.o(0, 30);
        oVar.a(com.sijla.mla.L2.s34387218(), new com.sijla.mla.a.b.k.c());
        oVar.a(com.sijla.mla.L2.s1067932891(), new com.sijla.mla.a.b.k.d());
        oVar.a(com.sijla.mla.L2.s34459293(), new com.sijla.mla.a.b.k.e());
        oVar.a(com.sijla.mla.L2.s34479102(), new com.sijla.mla.a.b.k.f());
        oVar.a(com.sijla.mla.L2.s34527431(), new com.sijla.mla.a.b.k.g(this));
        oVar.a(com.sijla.mla.L2.s1161282504(), new com.sijla.mla.a.b.k.h());
        oVar.a(com.sijla.mla.L2.s1070947300(), new com.sijla.mla.a.b.k.i());
        oVar.a(com.sijla.mla.L2.s1156030701(), new com.sijla.mla.a.b.k.j());
        oVar.a(com.sijla.mla.L2.s1073025013(), com.sijla.mla.a.h.a);
        oVar.a(com.sijla.mla.L2.s997185089(), new com.sijla.mla.a.b.k.C0462k());
        oVar.a(com.sijla.mla.L2.s34743904(), new com.sijla.mla.a.b.k.l());
        oVar.a(com.sijla.mla.L2.s34751282(), new com.sijla.mla.a.b.k.m());
        oVar.a(com.sijla.mla.L2.s1077461020(), new com.sijla.mla.a.b.k.n());
        oVar.a(com.sijla.mla.a.n.c(com.sijla.mla.L2.s1123815()), com.sijla.mla.a.h.a(3.141592653589793d));
        oVar.a(com.sijla.mla.L2.s34846700(), new com.sijla.mla.a.b.k.o());
        java.lang.String s103917917 = com.sijla.mla.L2.s103917917();
        com.sijla.mla.a.b.k.q qVar = new com.sijla.mla.a.b.k.q();
        oVar.a(s103917917, qVar);
        oVar.a(com.sijla.mla.L2.s587689076(), new com.sijla.mla.a.b.k.r(qVar));
        oVar.a(com.sijla.mla.L2.s34892239(), new com.sijla.mla.a.b.k.p());
        oVar.a(com.sijla.mla.L2.s34930028(), new com.sijla.mla.a.b.k.s());
        oVar.a(com.sijla.mla.L2.s1083075616(), new com.sijla.mla.a.b.k.t());
        oVar.a(com.sijla.mla.L2.s34952131(), new com.sijla.mla.a.b.k.u());
        rVar2.a(com.sijla.mla.L2.s1077059384(), oVar);
        rVar2.g(com.sijla.mla.L2.s573041986()).g(com.sijla.mla.L2.s537344421()).a(com.sijla.mla.L2.s1077059384(), oVar);
        return oVar;
    }
}
