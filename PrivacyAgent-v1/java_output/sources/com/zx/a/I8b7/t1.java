package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class t1 implements java.io.Closeable {
    public final com.zx.a.I8b7.q1 a;
    public final int b;
    public final java.lang.String c;
    public final java.util.Map<java.lang.String, java.util.List<java.lang.String>> d;
    public final com.zx.a.I8b7.u1 e;

    public static class a {
        public com.zx.a.I8b7.q1 a;
        public int b;
        public java.lang.String c;
        public java.util.Map<java.lang.String, java.util.List<java.lang.String>> d;
        public com.zx.a.I8b7.u1 e;

        public a() {
            this.b = -1;
            this.d = new java.util.HashMap();
        }

        public a(com.zx.a.I8b7.t1 t1Var) {
            this.b = -1;
            this.a = t1Var.a;
            this.b = t1Var.b;
            this.c = t1Var.c;
            this.d = new java.util.HashMap(t1Var.d);
            this.e = t1Var.e;
        }

        public com.zx.a.I8b7.t1 a() {
            if (this.a == null) {
                throw new java.lang.IllegalStateException("request == null");
            }
            if (this.b >= 0) {
                if (this.c != null) {
                    return new com.zx.a.I8b7.t1(this);
                }
                throw new java.lang.IllegalStateException("message == null");
            }
            java.lang.StringBuilder a = com.zx.a.I8b7.f3.a("code < 0: ");
            a.append(this.b);
            throw new java.lang.IllegalStateException(a.toString());
        }
    }

    public t1(com.zx.a.I8b7.t1.a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = new java.util.HashMap(aVar.d);
        this.e = aVar.e;
    }

    public java.lang.String a(java.lang.String str) {
        java.util.List<java.lang.String> list = this.d.get(str);
        if (list == null) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.util.Iterator<java.lang.String> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append("; ");
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.zx.a.I8b7.u1 u1Var = this.e;
        if (u1Var == null) {
            throw new java.lang.IllegalStateException("response is not eligible for a body and must not be closed");
        }
        u1Var.close();
    }
}
