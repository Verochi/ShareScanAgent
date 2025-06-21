package com.igexin.c.a.b.a.a;

/* loaded from: classes22.dex */
public final class b extends com.igexin.c.a.b.a.a.a {
    public static final int a = -2037;
    private static final java.lang.String j = "GS-C";
    private static final int k = 10000;
    private java.net.Socket P;
    private com.igexin.c.a.b.a.a.a.d l;

    public b(com.igexin.c.a.b.a.a.a.d dVar) {
        super(-2037, null);
        this.l = dVar;
    }

    @Override // com.igexin.c.a.b.f, com.igexin.c.a.d.f, com.igexin.c.a.d.a.a
    public final void a() {
        java.net.Socket socket;
        super.a();
        com.igexin.c.a.c.a.a("GS-C|sc dispose", new java.lang.Object[0]);
        if (this.l != null) {
            if (this.g == com.igexin.c.a.b.a.a.a.EnumC0368a.c) {
                this.l.a();
            } else if (this.g == com.igexin.c.a.b.a.a.a.EnumC0368a.b) {
                if (!android.text.TextUtils.isEmpty(this.h)) {
                    this.l.a(new java.lang.Exception(this.h));
                }
            } else if (this.g == com.igexin.c.a.b.a.a.a.EnumC0368a.a && (socket = this.P) != null) {
                this.l.a(socket);
            }
        }
        this.l = null;
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void b_() throws java.lang.Exception {
        super.b_();
        com.igexin.push.c.c.a().d().a();
        java.lang.String connectAddress = com.igexin.push.config.SDKUrlConfig.getConnectAddress();
        try {
            java.lang.String[] a2 = com.igexin.c.a.b.g.a(connectAddress);
            java.lang.String str = a2[1];
            int parseInt = java.lang.Integer.parseInt(a2[2]);
            com.igexin.c.a.c.a.a("GS-C|start connect :  " + connectAddress + " *********", new java.lang.Object[0]);
            com.igexin.c.a.b.a.a.a.d dVar = this.l;
            if (dVar != null) {
                dVar.b();
            }
            java.net.Socket socket = new java.net.Socket();
            this.P = socket;
            try {
                socket.connect(new java.net.InetSocketAddress(str, parseInt), 10000);
                com.igexin.c.a.c.a.a("GS-C|connected :  " + connectAddress + " #########", new java.lang.Object[0]);
                com.igexin.c.a.c.a.a("GS-C|local-" + connectAddress + " port:" + parseInt, new java.lang.Object[0]);
                if (this.g != com.igexin.c.a.b.a.a.a.EnumC0368a.c) {
                    this.g = com.igexin.c.a.b.a.a.a.EnumC0368a.a;
                }
            } catch (java.lang.Exception e) {
                if (this.g != com.igexin.c.a.b.a.a.a.EnumC0368a.c) {
                    this.g = com.igexin.c.a.b.a.a.a.EnumC0368a.b;
                    this.h = e.toString();
                }
            }
            this.f = true;
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            com.igexin.c.a.c.a.a("GS-C|ips invalid, " + e2.toString(), new java.lang.Object[0]);
            throw e2;
        }
    }

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return -2037;
    }

    @Override // com.igexin.c.a.b.a.a.a
    public final void c_() {
        this.g = com.igexin.c.a.b.a.a.a.EnumC0368a.c;
    }
}
