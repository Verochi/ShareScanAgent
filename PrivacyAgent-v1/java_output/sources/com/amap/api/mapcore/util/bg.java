package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class bg implements com.amap.api.mapcore.util.hd.a {
    com.amap.api.mapcore.util.bh a;
    long d;
    com.amap.api.mapcore.util.bb f;
    com.amap.api.mapcore.util.bg.a h;
    private android.content.Context i;
    private com.amap.api.mapcore.util.bm j;
    private java.lang.String k;
    private com.amap.api.mapcore.util.hk l;
    private com.amap.api.mapcore.util.bc m;
    long b = 0;
    long c = 0;
    boolean e = true;
    long g = 0;
    private boolean n = false;

    public interface a {
        void c();
    }

    public static class b extends com.amap.api.mapcore.util.cp {
        private final java.lang.String a;

        public b(java.lang.String str) {
            this.a = str;
        }

        @Override // com.amap.api.mapcore.util.hi
        public final java.lang.String getIPV6URL() {
            return getURL();
        }

        @Override // com.amap.api.mapcore.util.hi
        public final java.util.Map<java.lang.String, java.lang.String> getRequestHead() {
            return null;
        }

        @Override // com.amap.api.mapcore.util.hi
        public final java.lang.String getURL() {
            return this.a;
        }

        @Override // com.amap.api.mapcore.util.hi
        public final boolean isSupportIPV6() {
            return false;
        }
    }

    public bg(com.amap.api.mapcore.util.bh bhVar, java.lang.String str, android.content.Context context, com.amap.api.mapcore.util.bm bmVar) throws java.io.IOException {
        this.a = null;
        this.f = com.amap.api.mapcore.util.bb.a(context.getApplicationContext());
        this.a = bhVar;
        this.i = context;
        this.k = str;
        this.j = bmVar;
        d();
    }

    private void a(long j) {
        com.amap.api.mapcore.util.bm bmVar;
        long j2 = this.d;
        if (j2 <= 0 || (bmVar = this.j) == null) {
            return;
        }
        bmVar.a(j2, j);
        this.g = java.lang.System.currentTimeMillis();
    }

    private void c() throws java.io.IOException {
        com.amap.api.mapcore.util.bn bnVar = new com.amap.api.mapcore.util.bn(this.k);
        bnVar.setConnectionTimeout(30000);
        bnVar.setSoTimeout(30000);
        this.l = new com.amap.api.mapcore.util.hk(bnVar, this.b, this.c, com.amap.api.maps.MapsInitializer.getProtocol() == 2);
        this.m = new com.amap.api.mapcore.util.bc(this.a.b() + java.io.File.separator + this.a.c(), this.b);
    }

    private void d() {
        java.io.File file = new java.io.File(this.a.b() + this.a.c());
        if (!file.exists()) {
            this.b = 0L;
            this.c = 0L;
            return;
        }
        this.e = false;
        this.b = file.length();
        try {
            long g = g();
            this.d = g;
            this.c = g;
        } catch (java.io.IOException unused) {
            com.amap.api.mapcore.util.bm bmVar = this.j;
            if (bmVar != null) {
                bmVar.a(com.amap.api.mapcore.util.bm.a.file_io_exception);
            }
        }
    }

    private boolean e() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this.a.b());
        sb.append(java.io.File.separator);
        sb.append(this.a.c());
        return new java.io.File(sb.toString()).length() >= 10;
    }

    private void f() throws com.amap.api.maps.AMapException {
        if (com.amap.api.mapcore.util.ex.a != 1) {
            for (int i = 0; i < 3; i++) {
                try {
                } catch (java.lang.Throwable th) {
                    com.amap.api.mapcore.util.gd.c(th, "SiteFileFetch", "authOffLineDownLoad");
                    th.printStackTrace();
                }
                if (com.amap.api.mapcore.util.ex.a(this.i, com.amap.api.mapcore.util.dl.a())) {
                    return;
                }
            }
        }
    }

    private long g() throws java.io.IOException {
        java.util.Map<java.lang.String, java.lang.String> map;
        if (com.amap.api.mapcore.util.fe.a(this.i, com.amap.api.mapcore.util.dl.a()).a != com.amap.api.mapcore.util.fe.c.SuccessCode) {
            return -1L;
        }
        java.lang.String a2 = this.a.a();
        try {
            com.amap.api.mapcore.util.hh.b();
            map = com.amap.api.mapcore.util.hh.e(new com.amap.api.mapcore.util.bg.b(a2), com.amap.api.maps.MapsInitializer.getProtocol() == 2);
        } catch (com.amap.api.mapcore.util.eu e) {
            e.printStackTrace();
            map = null;
        }
        int i = -1;
        if (map != null) {
            for (java.lang.String str : map.keySet()) {
                if ("Content-Length".equalsIgnoreCase(str)) {
                    i = java.lang.Integer.parseInt(map.get(str));
                }
            }
        }
        return i;
    }

    private void h() {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        if (this.a == null || currentTimeMillis - this.g <= 500) {
            return;
        }
        i();
        this.g = currentTimeMillis;
        a(this.b);
    }

    private void i() {
        this.f.a(this.a.e(), this.a.d(), this.d, this.b, this.c);
    }

    public final void a() {
        try {
            if (!com.amap.api.mapcore.util.dl.d(this.i)) {
                com.amap.api.mapcore.util.bm bmVar = this.j;
                if (bmVar != null) {
                    bmVar.a(com.amap.api.mapcore.util.bm.a.network_exception);
                    return;
                }
                return;
            }
            f();
            if (com.amap.api.mapcore.util.ex.a != 1) {
                com.amap.api.mapcore.util.bm bmVar2 = this.j;
                if (bmVar2 != null) {
                    bmVar2.a(com.amap.api.mapcore.util.bm.a.amap_exception);
                    return;
                }
                return;
            }
            if (!e()) {
                this.e = true;
            }
            if (this.e) {
                long g = g();
                this.d = g;
                if (g != -1 && g != -2) {
                    this.c = g;
                }
                this.b = 0L;
            }
            com.amap.api.mapcore.util.bm bmVar3 = this.j;
            if (bmVar3 != null) {
                bmVar3.m();
            }
            if (this.b >= this.c) {
                onFinish();
            } else {
                c();
                this.l.a(this);
            }
        } catch (com.amap.api.maps.AMapException e) {
            com.amap.api.mapcore.util.gd.c(e, "SiteFileFetch", "download");
            com.amap.api.mapcore.util.bm bmVar4 = this.j;
            if (bmVar4 != null) {
                bmVar4.a(com.amap.api.mapcore.util.bm.a.amap_exception);
            }
        } catch (java.io.IOException unused) {
            com.amap.api.mapcore.util.bm bmVar5 = this.j;
            if (bmVar5 != null) {
                bmVar5.a(com.amap.api.mapcore.util.bm.a.file_io_exception);
            }
        }
    }

    public final void a(com.amap.api.mapcore.util.bg.a aVar) {
        this.h = aVar;
    }

    public final void b() {
        com.amap.api.mapcore.util.hk hkVar = this.l;
        if (hkVar != null) {
            hkVar.a();
        }
    }

    @Override // com.amap.api.mapcore.util.hd.a
    public final void onDownload(byte[] bArr, long j) {
        try {
            this.m.a(bArr);
            this.b = j;
            h();
        } catch (java.io.IOException e) {
            e.printStackTrace();
            com.amap.api.mapcore.util.gd.c(e, "fileAccessI", "fileAccessI.write(byte[] data)");
            com.amap.api.mapcore.util.bm bmVar = this.j;
            if (bmVar != null) {
                bmVar.a(com.amap.api.mapcore.util.bm.a.file_io_exception);
            }
            com.amap.api.mapcore.util.hk hkVar = this.l;
            if (hkVar != null) {
                hkVar.a();
            }
        }
    }

    @Override // com.amap.api.mapcore.util.hd.a
    public final void onException(java.lang.Throwable th) {
        com.amap.api.mapcore.util.bc bcVar;
        this.n = true;
        b();
        com.amap.api.mapcore.util.bm bmVar = this.j;
        if (bmVar != null) {
            bmVar.a(com.amap.api.mapcore.util.bm.a.network_exception);
        }
        if ((th instanceof java.io.IOException) || (bcVar = this.m) == null) {
            return;
        }
        bcVar.a();
    }

    @Override // com.amap.api.mapcore.util.hd.a
    public final void onFinish() {
        h();
        com.amap.api.mapcore.util.bm bmVar = this.j;
        if (bmVar != null) {
            bmVar.n();
        }
        com.amap.api.mapcore.util.bc bcVar = this.m;
        if (bcVar != null) {
            bcVar.a();
        }
        com.amap.api.mapcore.util.bg.a aVar = this.h;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // com.amap.api.mapcore.util.hd.a
    public final void onStop() {
        if (this.n) {
            return;
        }
        com.amap.api.mapcore.util.bm bmVar = this.j;
        if (bmVar != null) {
            bmVar.o();
        }
        i();
    }
}
