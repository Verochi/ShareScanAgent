package com.sijla.mla.a.b;

/* loaded from: classes19.dex */
public final class o extends com.sijla.mla.a.b.s {
    private static final com.sijla.mla.a.n L;
    private static final com.sijla.mla.a.n M;
    private static final com.sijla.mla.a.n Q;
    private static final java.lang.String R;
    private static java.lang.String f;
    private static final com.sijla.mla.a.n g;
    private static final com.sijla.mla.a.n h;
    private static final com.sijla.mla.a.n i;
    private static final com.sijla.mla.a.n j;
    private com.sijla.mla.a.b.o.d N;
    private com.sijla.mla.a.b.o.c O;
    private com.sijla.mla.a.b.o.a P;
    com.sijla.mla.a.b a;
    com.sijla.mla.a.o b;

    public class a extends com.sijla.mla.a.b.t {
        public a() {
        }

        @Override // com.sijla.mla.a.b.t, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.y a(com.sijla.mla.a.y yVar) {
            java.lang.String str;
            java.lang.String c = com.sijla.mla.a.b.o.c(yVar.v(1));
            try {
                return com.sijla.mla.a.r.a((com.sijla.mla.a.r) java.lang.Class.forName(c).newInstance(), (com.sijla.mla.a.y) com.sijla.mla.a.b.o.this.a);
            } catch (java.lang.ClassNotFoundException unused) {
                str = "\n\tno class '" + c + "'";
                return com.sijla.mla.a.n.c(str);
            } catch (java.lang.Exception e) {
                str = "\n\tjava load failed on '" + c + "', " + e;
                return com.sijla.mla.a.n.c(str);
            }
        }
    }

    public static class b extends com.sijla.mla.a.b.t {
    }

    public class c extends com.sijla.mla.a.b.t {
        public c() {
        }

        @Override // com.sijla.mla.a.b.t, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.y a(com.sijla.mla.a.y yVar) {
            com.sijla.mla.a.n w = yVar.w(1);
            com.sijla.mla.a.r a = com.sijla.mla.a.b.o.this.b.a((com.sijla.mla.a.r) com.sijla.mla.a.b.o.j);
            if (!a.v()) {
                return com.sijla.mla.a.n.c("package.path is not a string");
            }
            com.sijla.mla.a.y a2 = com.sijla.mla.a.b.o.this.b.a((com.sijla.mla.a.r) com.sijla.mla.a.b.o.L).a(com.sijla.mla.a.r.a((com.sijla.mla.a.r) w, (com.sijla.mla.a.y) a));
            if (!a2.aa()) {
                return a2.c(2).t();
            }
            com.sijla.mla.a.n s2 = a2.h().s();
            com.sijla.mla.a.r a3 = com.sijla.mla.a.b.o.this.a.a(s2.g());
            if (a3.h().E()) {
                return com.sijla.mla.a.r.a(a3.h(), (com.sijla.mla.a.y) s2);
            }
            return com.sijla.mla.a.r.a(com.sijla.mla.a.r.k, (com.sijla.mla.a.y) com.sijla.mla.a.n.c("'" + s2 + "': " + a3.c(2).g()));
        }
    }

    public class d extends com.sijla.mla.a.b.t {
        public d() {
        }

        @Override // com.sijla.mla.a.b.t, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.y a(com.sijla.mla.a.y yVar) {
            com.sijla.mla.a.n w = yVar.w(1);
            com.sijla.mla.a.r a = com.sijla.mla.a.b.o.this.b.a((com.sijla.mla.a.r) com.sijla.mla.a.b.o.i).a((com.sijla.mla.a.r) w);
            if (!a.J()) {
                return a;
            }
            return com.sijla.mla.a.n.c("\n\tno field package.preload['" + w + "']");
        }
    }

    public class e extends com.sijla.mla.a.b.l {
        public e() {
        }

        @Override // com.sijla.mla.a.b.l, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.r b(com.sijla.mla.a.r rVar) {
            com.sijla.mla.a.y a;
            com.sijla.mla.a.n C = rVar.C();
            com.sijla.mla.a.r a2 = com.sijla.mla.a.b.o.this.b.a((com.sijla.mla.a.r) com.sijla.mla.a.b.o.g);
            com.sijla.mla.a.r a3 = a2.a((com.sijla.mla.a.r) C);
            if (a3.f()) {
                if (a3 == com.sijla.mla.a.b.o.Q) {
                    com.sijla.mla.a.r.d("loop or previous error loading module '" + C + "'");
                }
                return a3;
            }
            com.sijla.mla.a.o Q = com.sijla.mla.a.b.o.this.b.a((com.sijla.mla.a.r) com.sijla.mla.a.b.o.M).Q();
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            int i = 1;
            while (true) {
                com.sijla.mla.a.r i2 = Q.i(i);
                if (i2.J()) {
                    com.sijla.mla.a.r.d("module '" + C + "' not found: " + C + ((java.lang.Object) stringBuffer));
                }
                a = i2.a((com.sijla.mla.a.y) C);
                if (a.c(1).E()) {
                    break;
                }
                if (a.aa()) {
                    stringBuffer.append(a.y(1));
                }
                i++;
            }
            a2.a((com.sijla.mla.a.r) C, (com.sijla.mla.a.r) com.sijla.mla.a.b.o.Q);
            com.sijla.mla.a.r b = a.h().b(C, a.c(2));
            if (b.J()) {
                b = a2.a((com.sijla.mla.a.r) C);
                if (b == com.sijla.mla.a.b.o.Q) {
                    b = com.sijla.mla.a.r.l;
                }
                return b;
            }
            a2.a((com.sijla.mla.a.r) C, b);
            return b;
        }
    }

    public class f extends com.sijla.mla.a.b.t {
        public f() {
        }

        @Override // com.sijla.mla.a.b.t, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.y a(com.sijla.mla.a.y yVar) {
            java.lang.String v = yVar.v(1);
            java.lang.String v2 = yVar.v(2);
            java.lang.String b = yVar.b(3, com.sijla.mla.L2.s34134());
            java.lang.String b2 = yVar.b(4, com.sijla.mla.a.b.o.R);
            int length = v2.length();
            java.lang.String replace = v.replace(b.charAt(0), b2.charAt(0));
            int i = -1;
            java.lang.StringBuffer stringBuffer = null;
            while (i < length) {
                int i2 = i + 1;
                int indexOf = v2.indexOf(59, i2);
                if (indexOf < 0) {
                    indexOf = v2.length();
                }
                java.lang.String substring = v2.substring(i2, indexOf);
                int indexOf2 = substring.indexOf(63);
                if (indexOf2 >= 0) {
                    substring = substring.substring(0, indexOf2) + replace + substring.substring(indexOf2 + 1);
                }
                java.io.InputStream a = com.sijla.mla.a.b.o.this.a.c.a(substring);
                if (a != null) {
                    try {
                        a.close();
                    } catch (java.io.IOException unused) {
                    }
                    return com.sijla.mla.a.n.c(substring);
                }
                if (stringBuffer == null) {
                    stringBuffer = new java.lang.StringBuffer();
                }
                stringBuffer.append("\n\t".concat(java.lang.String.valueOf(substring)));
                i = indexOf;
            }
            return com.sijla.mla.a.r.a(com.sijla.mla.a.r.k, (com.sijla.mla.a.y) com.sijla.mla.a.n.c(stringBuffer.toString()));
        }
    }

    static {
        try {
            f = java.lang.System.getProperty(com.sijla.mla.L2.s2126616347());
        } catch (java.lang.Exception e2) {
            java.lang.System.out.println(e2.toString());
        }
        if (f == null) {
            f = "?.lua";
        }
        g = com.sijla.mla.a.n.c(com.sijla.mla.L2.s537344421());
        h = com.sijla.mla.a.n.c(com.sijla.mla.L2.s522407493());
        i = com.sijla.mla.a.n.c(com.sijla.mla.L2.s1688211803());
        j = com.sijla.mla.a.n.c(com.sijla.mla.L2.s1079829947());
        L = com.sijla.mla.a.n.c(com.sijla.mla.L2.s430245229());
        M = com.sijla.mla.a.n.c(com.sijla.mla.L2.s1676758330());
        Q = com.sijla.mla.a.n.c("\u0001");
        R = java.lang.System.getProperty(com.sijla.mla.L2.s1376523565());
    }

    private static final boolean a(char c2) {
        return (c2 >= 'a' && c2 <= 'z') || (c2 >= 'A' && c2 <= 'Z') || ((c2 >= '0' && c2 <= '9') || c2 == '$' || c2 == '.' || c2 == '_');
    }

    public static final java.lang.String c(java.lang.String str) {
        int length = str.length();
        int i2 = str.endsWith(com.sijla.mla.L2.s1019206006()) ? length - 4 : length;
        for (int i3 = 0; i3 < i2; i3++) {
            char charAt = str.charAt(i3);
            if (!a(charAt) || charAt == '/' || charAt == '\\') {
                java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(i2);
                for (int i4 = 0; i4 < i2; i4++) {
                    char charAt2 = str.charAt(i4);
                    if (!a(charAt2)) {
                        charAt2 = (charAt2 == '/' || charAt2 == '\\') ? '.' : '_';
                    }
                    stringBuffer.append(charAt2);
                }
                return stringBuffer.toString();
            }
        }
        return length == i2 ? str : str.substring(0, i2);
    }

    @Override // com.sijla.mla.a.b.s, com.sijla.mla.a.b.j, com.sijla.mla.a.r
    public final com.sijla.mla.a.r b(com.sijla.mla.a.r rVar, com.sijla.mla.a.r rVar2) {
        com.sijla.mla.a.b a2 = rVar2.a();
        this.a = a2;
        a2.a(com.sijla.mla.L2.s1717048961(), new com.sijla.mla.a.b.o.e());
        com.sijla.mla.a.o oVar = new com.sijla.mla.a.o();
        this.b = oVar;
        com.sijla.mla.a.n nVar = g;
        oVar.a((com.sijla.mla.a.r) nVar, (com.sijla.mla.a.r) new com.sijla.mla.a.o());
        this.b.a((com.sijla.mla.a.r) i, (com.sijla.mla.a.r) new com.sijla.mla.a.o());
        this.b.a((com.sijla.mla.a.r) j, (com.sijla.mla.a.r) com.sijla.mla.a.n.c(f));
        this.b.a((com.sijla.mla.a.r) h, (com.sijla.mla.a.r) new com.sijla.mla.a.b.o.b());
        this.b.a((com.sijla.mla.a.r) L, (com.sijla.mla.a.r) new com.sijla.mla.a.b.o.f());
        com.sijla.mla.a.r oVar2 = new com.sijla.mla.a.o();
        com.sijla.mla.a.b.o.d dVar = new com.sijla.mla.a.b.o.d();
        this.N = dVar;
        oVar2.a(1, dVar);
        com.sijla.mla.a.b.o.c cVar = new com.sijla.mla.a.b.o.c();
        this.O = cVar;
        oVar2.a(2, cVar);
        com.sijla.mla.a.b.o.a aVar = new com.sijla.mla.a.b.o.a();
        this.P = aVar;
        oVar2.a(3, aVar);
        this.b.a((com.sijla.mla.a.r) M, oVar2);
        this.b.a((com.sijla.mla.a.r) nVar).a(com.sijla.mla.L2.s573041986(), this.b);
        rVar2.a(com.sijla.mla.L2.s573041986(), this.b);
        this.a.f = this;
        return rVar2;
    }

    @Override // com.sijla.mla.a.b.j, com.sijla.mla.a.j, com.sijla.mla.a.r, com.sijla.mla.a.y
    public final java.lang.String g() {
        return com.sijla.mla.L2.s573041986();
    }
}
