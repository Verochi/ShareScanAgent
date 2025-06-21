package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class k implements com.amap.api.mapcore.util.hd.a {
    com.amap.api.mapcore.util.k.a a;
    private final android.content.Context b;
    private java.io.RandomAccessFile c;
    private com.amap.api.mapcore.util.hk d;
    private java.lang.String e;

    public static class a {
        protected java.lang.String a;
        protected java.lang.String b;
        protected java.lang.String c;
        protected java.lang.String d;
        protected java.lang.String e;
        protected com.amap.api.mapcore.util.k.c f;

        public a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4 + com.baidu.mobads.sdk.internal.al.k;
            this.e = str4;
        }

        public final java.lang.String a() {
            return this.a;
        }

        public final void a(com.amap.api.mapcore.util.k.c cVar) {
            this.f = cVar;
        }

        public final java.lang.String b() {
            return this.b;
        }

        public final java.lang.String c() {
            return this.d;
        }

        public final java.lang.String d() {
            return this.e;
        }

        public final com.amap.api.mapcore.util.k.c e() {
            return this.f;
        }
    }

    public static class b extends com.amap.api.mapcore.util.cp {
        private final com.amap.api.mapcore.util.k.a a;

        public b(com.amap.api.mapcore.util.k.a aVar) {
            this.a = aVar;
        }

        @Override // com.amap.api.mapcore.util.hi
        public final java.lang.String getIPV6URL() {
            return getURL();
        }

        @Override // com.amap.api.mapcore.util.cp, com.amap.api.mapcore.util.hi
        public final java.util.Map<java.lang.String, java.lang.String> getParams() {
            return null;
        }

        @Override // com.amap.api.mapcore.util.hi
        public final java.util.Map<java.lang.String, java.lang.String> getRequestHead() {
            return null;
        }

        @Override // com.amap.api.mapcore.util.hi
        public final java.lang.String getURL() {
            com.amap.api.mapcore.util.k.a aVar = this.a;
            if (aVar != null) {
                return aVar.a();
            }
            return null;
        }

        @Override // com.amap.api.mapcore.util.hi
        public final boolean isSupportIPV6() {
            return false;
        }
    }

    public static class c {
        protected java.lang.String a;
        protected java.lang.String b;

        public c(java.lang.String str, java.lang.String str2) {
            this.a = str;
            this.b = str2;
        }

        public final java.lang.String a() {
            return this.a;
        }

        public final java.lang.String b() {
            return this.b;
        }

        public final boolean c() {
            return (android.text.TextUtils.isEmpty(this.a) || android.text.TextUtils.isEmpty(this.b)) ? false : true;
        }
    }

    public static class d extends com.amap.api.mapcore.util.k.a {
        public d(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
            super(str, str2, str3, str4);
        }

        public final void a(java.lang.String str, java.lang.String str2) {
            a(new com.amap.api.mapcore.util.k.c(str, str2));
        }
    }

    public k(android.content.Context context, com.amap.api.mapcore.util.k.a aVar) {
        this.b = context.getApplicationContext();
        this.a = aVar;
        this.d = new com.amap.api.mapcore.util.hk(new com.amap.api.mapcore.util.k.b(aVar));
        this.e = aVar.c();
    }

    private boolean b() {
        com.amap.api.mapcore.util.k.c e = this.a.e();
        return (e != null && e.c() && com.amap.api.mapcore.util.db.a(this.b, e.a(), e.b(), "").equalsIgnoreCase(this.a.b())) ? false : true;
    }

    public final void a() {
        com.amap.api.mapcore.util.hk hkVar;
        if (com.amap.api.mapcore.util.p.a == null || com.amap.api.mapcore.util.fe.a(com.amap.api.mapcore.util.p.a, com.amap.api.mapcore.util.dl.a()).a == com.amap.api.mapcore.util.fe.c.SuccessCode) {
            try {
                if (!b() || (hkVar = this.d) == null) {
                    return;
                }
                hkVar.a(this);
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.gd.c(th, "AuthTaskDownload", "startDownload()");
            }
        }
    }

    @Override // com.amap.api.mapcore.util.hd.a
    public final void onDownload(byte[] bArr, long j) {
        try {
            if (this.c == null) {
                java.io.File file = new java.io.File(this.e);
                java.io.File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                this.c = new java.io.RandomAccessFile(file, "rw");
            }
            this.c.seek(j);
            this.c.write(bArr);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "AuthTaskDownload", "onDownload()");
        }
    }

    @Override // com.amap.api.mapcore.util.hd.a
    public final void onException(java.lang.Throwable th) {
        try {
            java.io.RandomAccessFile randomAccessFile = this.c;
            if (randomAccessFile == null) {
                return;
            }
            randomAccessFile.close();
        } catch (java.lang.Throwable th2) {
            com.amap.api.mapcore.util.gd.c(th2, "AuthTaskDownload", "onException()");
        }
    }

    @Override // com.amap.api.mapcore.util.hd.a
    public final void onFinish() {
        java.io.RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = this.c;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "AuthTaskDownload", "onFinish()");
        }
        if (randomAccessFile == null) {
            return;
        }
        try {
            randomAccessFile.close();
        } catch (java.lang.Throwable th2) {
            com.amap.api.mapcore.util.gd.c(th2, "AuthTaskDownload", "onFinish3");
        }
        java.lang.String b2 = this.a.b();
        java.lang.String a2 = com.amap.api.mapcore.util.fd.a(this.e);
        if (a2 == null || !b2.equalsIgnoreCase(a2)) {
            try {
                new java.io.File(this.e).delete();
                return;
            } catch (java.lang.Throwable th3) {
                com.amap.api.mapcore.util.gd.c(th3, "AuthTaskDownload", "onFinish");
                return;
            }
        }
        java.lang.String d2 = this.a.d();
        try {
            com.amap.api.mapcore.util.bd bdVar = new com.amap.api.mapcore.util.bd();
            java.io.File file = new java.io.File(this.e);
            bdVar.a(file, new java.io.File(d2), -1L, com.amap.api.mapcore.util.bj.a(file), null);
            com.amap.api.mapcore.util.k.c e = this.a.e();
            if (e != null && e.c()) {
                com.amap.api.mapcore.util.db.a(this.b, e.a(), e.b(), (java.lang.Object) a2);
            }
            new java.io.File(this.e).delete();
            return;
        } catch (java.lang.Throwable th4) {
            com.amap.api.mapcore.util.gd.c(th4, "AuthTaskDownload", "onFinish1");
            return;
        }
        com.amap.api.mapcore.util.gd.c(th, "AuthTaskDownload", "onFinish()");
    }

    @Override // com.amap.api.mapcore.util.hd.a
    public final void onStop() {
    }
}
