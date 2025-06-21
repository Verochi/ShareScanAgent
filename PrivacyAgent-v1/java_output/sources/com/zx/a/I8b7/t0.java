package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class t0 {
    public final java.util.List<com.zx.a.I8b7.j0> a = new java.util.ArrayList();

    public void a(int i, java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        for (com.zx.a.I8b7.j0 j0Var : this.a) {
            try {
                if (j0Var.a(i, null)) {
                    j0Var.a(i, null, str2, th);
                }
            } catch (java.lang.Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public void a(com.zx.a.I8b7.j0 j0Var) {
        this.a.add(j0Var);
    }
}
