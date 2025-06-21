package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class i1 {
    public com.zx.a.I8b7.q1 a;
    public com.zx.a.I8b7.o2 b;
    public boolean c;

    public final class a implements java.lang.Runnable {
        /* JADX WARN: Code restructure failed: missing block: B:10:?, code lost:
        
            throw null;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void run() {
            try {
                throw null;
            } catch (java.lang.Throwable th) {
                new java.lang.Exception(th.getMessage(), th.getCause());
                throw null;
            }
        }
    }

    public i1(com.zx.a.I8b7.o2 o2Var, com.zx.a.I8b7.q1 q1Var) {
        this.b = o2Var;
        this.a = q1Var;
    }

    public com.zx.a.I8b7.t1 a() throws java.lang.Exception {
        synchronized (this) {
            if (this.c) {
                throw new java.lang.IllegalStateException("Already Executed");
            }
            this.c = true;
        }
        try {
            com.zx.a.I8b7.x xVar = this.b.a;
            synchronized (xVar) {
                xVar.d.add(this);
            }
            return b();
        } finally {
            com.zx.a.I8b7.x xVar2 = this.b.a;
            xVar2.a(xVar2.d, this, false);
        }
    }

    public com.zx.a.I8b7.t1 b() throws java.lang.Exception {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.addAll(this.b.b);
        this.a.getClass();
        arrayList.add(new com.zx.a.I8b7.e());
        arrayList.add(new com.zx.a.I8b7.o(this.b));
        arrayList.add(new com.zx.a.I8b7.j());
        com.zx.a.I8b7.q1 q1Var = this.a;
        if (arrayList.size() <= 0) {
            throw new java.lang.AssertionError();
        }
        com.zx.a.I8b7.j1 j1Var = new com.zx.a.I8b7.j1(arrayList, null, 1, q1Var);
        com.zx.a.I8b7.n0 n0Var = (com.zx.a.I8b7.n0) arrayList.get(0);
        com.zx.a.I8b7.t1 a2 = n0Var.a(j1Var);
        if (a2 == null) {
            throw new java.lang.NullPointerException("interceptor " + n0Var + " returned null");
        }
        if (a2.e != null) {
            return a2;
        }
        throw new java.lang.IllegalStateException("interceptor " + n0Var + " returned a response with no body");
    }
}
