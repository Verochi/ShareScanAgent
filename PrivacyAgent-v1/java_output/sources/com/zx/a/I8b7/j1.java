package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class j1 implements com.zx.a.I8b7.n0.a {
    public final int a;
    public final java.util.List<com.zx.a.I8b7.n0> b;
    public final com.zx.a.I8b7.q1 c;
    public final java.net.HttpURLConnection d;

    public j1(java.util.List<com.zx.a.I8b7.n0> list, java.net.HttpURLConnection httpURLConnection, int i, com.zx.a.I8b7.q1 q1Var) {
        this.b = list;
        this.d = httpURLConnection;
        this.a = i;
        this.c = q1Var;
    }

    public com.zx.a.I8b7.t1 a(com.zx.a.I8b7.q1 q1Var, java.net.HttpURLConnection httpURLConnection) throws java.io.IOException {
        if (this.a >= this.b.size()) {
            throw new java.lang.AssertionError();
        }
        java.util.List<com.zx.a.I8b7.n0> list = this.b;
        int i = this.a;
        com.zx.a.I8b7.j1 j1Var = new com.zx.a.I8b7.j1(list, httpURLConnection, i + 1, q1Var);
        com.zx.a.I8b7.n0 n0Var = list.get(i);
        com.zx.a.I8b7.t1 a = n0Var.a(j1Var);
        if (a == null) {
            throw new java.lang.NullPointerException("interceptor " + n0Var + " returned null");
        }
        if (a.e != null) {
            return a;
        }
        throw new java.lang.IllegalStateException("interceptor " + n0Var + " returned a response with no body");
    }
}
