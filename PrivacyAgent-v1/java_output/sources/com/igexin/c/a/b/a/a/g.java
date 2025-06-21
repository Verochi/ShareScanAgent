package com.igexin.c.a.b.a.a;

/* loaded from: classes22.dex */
public final class g extends com.igexin.c.a.b.a.a.a {
    private static final java.lang.String P = "GS-W";
    public static final int a = -2036;
    com.igexin.c.a.b.a.a.a.c j;
    protected com.igexin.c.a.b.d k;
    protected com.igexin.c.a.b.a.a.i l;

    public g(com.igexin.c.a.b.a.a.i iVar, com.igexin.c.a.b.d dVar) {
        super(-2036, dVar);
        this.k = dVar;
        this.l = iVar;
    }

    private void a(com.igexin.c.a.b.a.a.a.c cVar) {
        this.j = cVar;
    }

    @Override // com.igexin.c.a.b.f, com.igexin.c.a.d.f, com.igexin.c.a.d.a.a
    public final void a() {
        super.a();
        com.igexin.c.a.c.a.a(P, "wt dispose");
        com.igexin.c.a.c.a.a("GS-W|wt dispose", new java.lang.Object[0]);
        if (this.j != null) {
            if (this.g != com.igexin.c.a.b.a.a.a.EnumC0368a.b) {
                this.j.a();
            } else if (!android.text.TextUtils.isEmpty(this.h)) {
                this.j.a(new java.lang.Exception(this.h));
            }
        }
        this.j = null;
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void b_() throws java.lang.Exception {
        super.b_();
        java.lang.Thread currentThread = java.lang.Thread.currentThread();
        com.igexin.c.a.c.a.a("GS-W|" + currentThread + " running", new java.lang.Object[0]);
        com.igexin.c.a.b.a.a.d a2 = com.igexin.c.a.b.a.a.d.a();
        while (this.i && !currentThread.isInterrupted() && !this.f) {
            try {
                a2.g.lock();
                if (a2.k.isEmpty() && this.i) {
                    a2.h.await();
                }
                com.igexin.c.a.b.a.a.f poll = a2.k.poll();
                if (poll != null && this.i && this.l != null && this.i) {
                    this.g = com.igexin.c.a.b.a.a.a.EnumC0368a.a;
                    if (this.j != null && this.i) {
                        this.j.a(poll);
                    }
                    java.lang.Object obj = poll.d;
                    if (obj != null) {
                        com.igexin.c.a.b.a.a.i iVar = this.l;
                        byte[] bArr = (byte[]) this.k.a(null, obj);
                        iVar.a.write(bArr, 0, bArr.length);
                        iVar.a.flush();
                    }
                    if (poll.d != null) {
                        com.igexin.c.a.c.a.a("GS-W|" + poll.d.getClass().getName() + " -- send success", new java.lang.Object[0]);
                    }
                }
                a2.g.unlock();
            } finally {
                try {
                } finally {
                }
            }
        }
        this.f = true;
        com.igexin.c.a.c.a.a("GS-W|finish ~~~~~~", new java.lang.Object[0]);
    }

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return -2036;
    }

    @Override // com.igexin.c.a.b.a.a.a
    public final void c_() {
        this.i = false;
        this.g = com.igexin.c.a.b.a.a.a.EnumC0368a.c;
        com.igexin.c.a.b.a.a.d a2 = com.igexin.c.a.b.a.a.d.a();
        try {
            try {
                if (!this.f) {
                    a2.g.lock();
                    a2.h.signalAll();
                }
            } finally {
                try {
                    a2.g.unlock();
                } catch (java.lang.Exception e) {
                    com.igexin.c.a.c.a.a(e);
                }
            }
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            com.igexin.c.a.c.a.a(P, e2.toString());
            try {
                a2.g.unlock();
            } catch (java.lang.Exception e3) {
                com.igexin.c.a.c.a.a(e3);
            }
        }
    }
}
