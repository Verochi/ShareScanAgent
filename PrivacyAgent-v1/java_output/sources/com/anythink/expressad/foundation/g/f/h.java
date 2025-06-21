package com.anythink.expressad.foundation.g.f;

/* loaded from: classes12.dex */
public class h {
    private static final java.lang.String a = "h";
    private com.anythink.expressad.foundation.g.f.e.a b;
    private com.anythink.expressad.foundation.g.f.g c;
    private com.anythink.expressad.foundation.g.f.c d;

    public h(javax.net.ssl.SSLSocketFactory sSLSocketFactory, com.anythink.expressad.foundation.g.f.c cVar) {
        this.b = new com.anythink.expressad.foundation.g.f.e.b(sSLSocketFactory, null);
        this.c = new com.anythink.expressad.foundation.g.f.f.a(this.b, cVar);
        this.d = cVar;
    }

    private void b(com.anythink.expressad.foundation.g.f.i iVar) {
        try {
            this.d.c(iVar);
            if (iVar.f()) {
                iVar.c();
                this.d.b(iVar);
                this.d.a(iVar);
            } else {
                this.d.d(iVar);
                this.d.a((com.anythink.expressad.foundation.g.f.i<?>) iVar, iVar.a(this.c.a(iVar)));
            }
        } catch (com.anythink.expressad.foundation.g.f.a.a e) {
            this.d.a((com.anythink.expressad.foundation.g.f.i<?>) iVar, com.anythink.expressad.foundation.g.f.i.a(e));
        } catch (java.lang.Exception e2) {
            e2.getMessage();
            this.d.a((com.anythink.expressad.foundation.g.f.i<?>) iVar, new com.anythink.expressad.foundation.g.f.a.a(4, null));
        }
    }

    public final void a(com.anythink.expressad.foundation.g.f.i iVar) {
        android.os.Process.setThreadPriority(10);
        try {
            this.d.c(iVar);
            if (iVar.f()) {
                iVar.c();
                this.d.b(iVar);
                this.d.a(iVar);
            } else {
                this.d.d(iVar);
                this.d.a((com.anythink.expressad.foundation.g.f.i<?>) iVar, iVar.a(this.c.a(iVar)));
            }
        } catch (com.anythink.expressad.foundation.g.f.a.a e) {
            this.d.a((com.anythink.expressad.foundation.g.f.i<?>) iVar, com.anythink.expressad.foundation.g.f.i.a(e));
        } catch (java.lang.Exception e2) {
            e2.getMessage();
            this.d.a((com.anythink.expressad.foundation.g.f.i<?>) iVar, new com.anythink.expressad.foundation.g.f.a.a(4, null));
        }
    }
}
