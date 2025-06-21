package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class k1 implements java.lang.Runnable {
    @Override // java.lang.Runnable
    public void run() {
        try {
            com.zx.a.I8b7.h1 h1Var = com.zx.a.I8b7.h1.b.a;
            h1Var.getClass();
            if (com.zx.a.I8b7.h1.i != null && com.zx.a.I8b7.h1.i.length() > 0) {
                com.zx.a.I8b7.h1.i.a(h1Var.c - 1);
                h1Var.c = com.zx.a.I8b7.h1.i.length();
            }
            if (com.zx.a.I8b7.h1.j == null || com.zx.a.I8b7.h1.j.length() <= 0) {
                return;
            }
            com.zx.a.I8b7.h1.j.a(h1Var.d - 1);
            h1Var.d = com.zx.a.I8b7.h1.j.length();
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r2.a(th);
        }
    }
}
