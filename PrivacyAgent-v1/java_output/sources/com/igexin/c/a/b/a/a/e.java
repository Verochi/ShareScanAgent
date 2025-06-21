package com.igexin.c.a.b.a.a;

/* loaded from: classes22.dex */
public final class e extends com.igexin.c.a.b.a.a.a {
    private static final java.lang.String P = "GS-R";
    public static final int a = -2035;
    private byte[] Q;
    protected com.igexin.c.a.b.a.a.h j;
    com.igexin.c.a.b.a.a.a.b k;
    protected com.igexin.c.a.b.d l;

    public e(com.igexin.c.a.b.a.a.h hVar, com.igexin.c.a.b.d dVar) {
        super(-2035, dVar);
        this.l = dVar;
        this.j = hVar;
    }

    private void a(com.igexin.c.a.b.a.a.a.b bVar) {
        this.k = bVar;
    }

    @Override // com.igexin.c.a.b.f, com.igexin.c.a.d.f, com.igexin.c.a.d.a.a
    public final void a() {
        super.a();
        com.igexin.c.a.c.a.a(P, "rt dispose");
        com.igexin.c.a.c.a.a("GS-R|rt dispose", new java.lang.Object[0]);
        if (this.k != null) {
            if (this.g != com.igexin.c.a.b.a.a.a.EnumC0368a.b) {
                this.k.a();
            } else if (!android.text.TextUtils.isEmpty(this.h)) {
                this.k.a(new java.lang.Exception(this.h));
            }
        }
        if (this.Q != null) {
            this.Q = null;
        }
        this.k = null;
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void b_() throws java.lang.Exception {
        super.b_();
        java.lang.Thread currentThread = java.lang.Thread.currentThread();
        com.igexin.c.a.c.a.a("GS-R|" + currentThread + " running", new java.lang.Object[0]);
        while (this.i && !currentThread.isInterrupted() && !this.f) {
            try {
                com.igexin.c.a.d.a.e b = this.l.b(null, this.j);
                if (b != null) {
                    com.igexin.c.a.b.e.a().a(b);
                    com.igexin.c.a.b.e.a().b();
                } else {
                    com.igexin.c.a.c.a.a(P, "read error data");
                    com.igexin.c.a.c.a.a("GS-R|read error data", new java.lang.Object[0]);
                }
                this.g = com.igexin.c.a.b.a.a.a.EnumC0368a.a;
            } catch (java.lang.Throwable th) {
                this.i = false;
                if (this.g != com.igexin.c.a.b.a.a.a.EnumC0368a.c) {
                    this.g = com.igexin.c.a.b.a.a.a.EnumC0368a.b;
                    this.h = (th.getMessage() == null || !th.getMessage().equals("read = -1, end of stream !")) ? th.toString() : "end of stream";
                }
                com.igexin.c.a.c.a.a(th);
            }
        }
        currentThread.isInterrupted();
        this.f = true;
        com.igexin.c.a.c.a.a("GS-R|finish ~~~~~~", new java.lang.Object[0]);
    }

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return -2035;
    }

    @Override // com.igexin.c.a.b.a.a.a
    public final void c_() {
        this.i = false;
        this.g = com.igexin.c.a.b.a.a.a.EnumC0368a.c;
    }
}
