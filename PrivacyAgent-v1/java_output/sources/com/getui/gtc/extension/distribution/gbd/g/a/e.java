package com.getui.gtc.extension.distribution.gbd.g.a;

/* loaded from: classes22.dex */
public final class e extends com.getui.gtc.extension.distribution.gbd.g.d {
    private static final java.lang.String y = "GBD_PnHttp";
    private com.getui.gtc.extension.distribution.gbd.c.o A;
    private int z;

    private e(java.lang.String str, int i, com.getui.gtc.extension.distribution.gbd.c.o oVar) {
        super(str);
        this.z = i;
        this.t = true;
        this.A = oVar;
    }

    public e(java.lang.String str, com.getui.gtc.extension.distribution.gbd.c.o oVar, android.net.Network network) {
        super(str);
        this.z = 1;
        this.t = true;
        this.A = oVar;
        this.i = network;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.g.d
    public final void a(int i) {
        try {
            com.getui.gtc.extension.distribution.gbd.n.j.a(y, "requestFailed type = ".concat(java.lang.String.valueOf(i)));
            if (this.m != null) {
                com.getui.gtc.extension.distribution.gbd.c.n nVar = new com.getui.gtc.extension.distribution.gbd.c.n();
                nVar.c = this.z;
                nVar.d = this.A;
                this.m.a(nVar);
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
    }

    @Override // com.getui.gtc.extension.distribution.gbd.g.d
    public final void a(java.lang.Throwable th) {
        try {
            com.getui.gtc.extension.distribution.gbd.n.j.a(y, "exceptionHandler type = " + this.z);
            if (this.m != null) {
                com.getui.gtc.extension.distribution.gbd.c.n nVar = new com.getui.gtc.extension.distribution.gbd.c.n();
                nVar.c = this.z;
                nVar.d = this.A;
                this.m.a(nVar);
            }
        } catch (java.lang.Throwable th2) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th2);
        }
    }

    @Override // com.getui.gtc.extension.distribution.gbd.g.d
    public final void a(java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, byte[] bArr) {
        try {
            java.lang.String str = new java.lang.String(bArr, "UTF-8");
            if (this.m != null) {
                com.getui.gtc.extension.distribution.gbd.c.n nVar = new com.getui.gtc.extension.distribution.gbd.c.n();
                nVar.c = this.z;
                nVar.d = this.A;
                nVar.a = map;
                nVar.b = str;
                this.m.a(nVar);
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
    }
}
