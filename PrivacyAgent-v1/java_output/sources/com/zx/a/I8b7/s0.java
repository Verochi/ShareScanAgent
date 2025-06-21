package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class s0 implements com.zx.a.I8b7.n0 {
    public com.zx.a.I8b7.r0 a;

    public s0(com.zx.a.I8b7.r0 r0Var, int i) {
        this.a = r0Var;
    }

    @Override // com.zx.a.I8b7.n0
    public com.zx.a.I8b7.t1 a(com.zx.a.I8b7.n0.a aVar) throws java.io.IOException {
        com.zx.a.I8b7.j1 j1Var = (com.zx.a.I8b7.j1) aVar;
        com.zx.a.I8b7.q1 q1Var = j1Var.c;
        com.zx.a.I8b7.q1.a aVar2 = new com.zx.a.I8b7.q1.a(q1Var);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(q1Var.b + " " + q1Var.a.toString() + " " + q1Var.e + "\n");
        com.zx.a.I8b7.s1 s1Var = q1Var.d;
        if (s1Var != null && ((com.zx.a.I8b7.r1) s1Var).a.a() != null) {
            if (((com.zx.a.I8b7.r1) q1Var.d).b > 2147483647L) {
                java.lang.StringBuilder a = com.zx.a.I8b7.f3.a("request body content length: ");
                a.append(((com.zx.a.I8b7.r1) q1Var.d).b);
                a.append("\n");
                sb.append(a.toString());
            } else {
                java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                com.zx.a.I8b7.r1 r1Var = (com.zx.a.I8b7.r1) q1Var.d;
                byteArrayOutputStream.write(r1Var.c, r1Var.d, r1Var.b);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                sb.append(new java.lang.String(byteArray, java.nio.charset.StandardCharsets.UTF_8) + "\n");
                aVar2.d = com.zx.a.I8b7.s1.a(((com.zx.a.I8b7.r1) q1Var.d).a, byteArray);
            }
        }
        this.a.a(sb.toString());
        com.zx.a.I8b7.t1 a2 = j1Var.a(new com.zx.a.I8b7.q1(aVar2), j1Var.d);
        com.zx.a.I8b7.t1.a aVar3 = new com.zx.a.I8b7.t1.a(a2);
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append(a2.b + " " + a2.c + " " + q1Var.a.toString() + " " + q1Var.e + "\n");
        com.zx.a.I8b7.u1 u1Var = a2.e;
        if (u1Var != null && ((com.zx.a.I8b7.u1.a) u1Var).a.a() != null) {
            com.zx.a.I8b7.u1 u1Var2 = a2.e;
            if (((com.zx.a.I8b7.u1.a) u1Var2).b > 2147483647L) {
                java.lang.StringBuilder a3 = com.zx.a.I8b7.f3.a("response body content length: ");
                a3.append(((com.zx.a.I8b7.u1.a) a2.e).b);
                a3.append("\n");
                sb2.append(a3.toString());
            } else {
                byte[] a4 = u1Var2.a();
                sb2.append("response body size: ");
                sb2.append(a4.length);
                sb2.append(", ");
                sb2.append(new java.lang.String(a4, java.nio.charset.StandardCharsets.UTF_8) + "\n");
                aVar3.e = com.zx.a.I8b7.u1.a(((com.zx.a.I8b7.u1.a) a2.e).a, (long) a4.length, new java.io.ByteArrayInputStream(a4));
            }
        }
        this.a.a(sb2.toString());
        return aVar3.a();
    }
}
