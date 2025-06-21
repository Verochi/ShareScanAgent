package com.getui.gtc.extension.distribution.gbd.n.d.a;

/* loaded from: classes22.dex */
public final class c implements com.getui.gtc.extension.distribution.gbd.n.d.a {
    private com.getui.gtc.extension.distribution.gbd.n.d.a.d a = new com.getui.gtc.extension.distribution.gbd.n.d.a.c.C0319c((byte) 0);
    private com.getui.gtc.extension.distribution.gbd.n.d.a.e b = new com.getui.gtc.extension.distribution.gbd.n.d.a.c.d();

    public static abstract class a<T extends com.getui.gtc.extension.distribution.gbd.n.d.a.InterfaceC0318a> implements com.getui.gtc.extension.distribution.gbd.n.d.a.InterfaceC0318a<T> {
        java.net.URL a;
        com.getui.gtc.extension.distribution.gbd.n.d.a.c b;
        java.util.Map<java.lang.String, java.lang.String> c;
        java.util.Map<java.lang.String, java.lang.String> d;

        private a() {
            this.c = new java.util.LinkedHashMap();
            this.d = new java.util.LinkedHashMap();
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        private java.lang.String g(java.lang.String str) {
            java.util.Map.Entry<java.lang.String, java.lang.String> h;
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a((java.lang.Object) str, "Header name must not be null");
            java.lang.String str2 = this.c.get(str);
            if (str2 == null) {
                str2 = this.c.get(str.toLowerCase());
            }
            return (str2 != null || (h = h(str)) == null) ? str2 : h.getValue();
        }

        private java.util.Map.Entry<java.lang.String, java.lang.String> h(java.lang.String str) {
            java.lang.String lowerCase = str.toLowerCase();
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : this.c.entrySet()) {
                if (entry.getKey().toLowerCase().equals(lowerCase)) {
                    return entry;
                }
            }
            return null;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.InterfaceC0318a
        public final T a(com.getui.gtc.extension.distribution.gbd.n.d.a.c cVar) {
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(cVar, "Method must not be null");
            this.b = cVar;
            return this;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.InterfaceC0318a
        public final T a(java.lang.String str, java.lang.String str2) {
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(str, "Header name must not be empty");
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a((java.lang.Object) str2, "Header value must not be null");
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(str, "Header name must not be empty");
            java.util.Map.Entry<java.lang.String, java.lang.String> h = h(str);
            if (h != null) {
                this.c.remove(h.getKey());
            }
            this.c.put(str, str2);
            return this;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.InterfaceC0318a
        public final T a(java.net.URL url) {
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(url, "URL must not be null");
            this.a = url;
            return this;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.InterfaceC0318a
        public java.lang.String a(java.lang.String str) {
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a((java.lang.Object) str, "Header name must not be null");
            return g(str);
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.InterfaceC0318a
        public java.net.URL a() {
            return this.a;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.InterfaceC0318a
        public final T b(java.lang.String str, java.lang.String str2) {
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(str, "Cookie name must not be empty");
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a((java.lang.Object) str2, "Cookie value must not be null");
            this.d.put(str, str2);
            return this;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.InterfaceC0318a
        public com.getui.gtc.extension.distribution.gbd.n.d.a.c b() {
            return this.b;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.InterfaceC0318a
        public boolean b(java.lang.String str) {
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(str, "Header name must not be empty");
            return g(str) != null;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.InterfaceC0318a
        public final T c(java.lang.String str) {
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(str, "Header name must not be empty");
            java.util.Map.Entry<java.lang.String, java.lang.String> h = h(str);
            if (h != null) {
                this.c.remove(h.getKey());
            }
            return this;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.InterfaceC0318a
        public java.util.Map<java.lang.String, java.lang.String> c() {
            return this.c;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.InterfaceC0318a
        public java.lang.String d(java.lang.String str) {
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a((java.lang.Object) str, "Cookie name must not be null");
            return this.d.get(str);
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.InterfaceC0318a
        public java.util.Map<java.lang.String, java.lang.String> d() {
            return this.d;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.InterfaceC0318a
        public boolean e(java.lang.String str) {
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a("Cookie name must not be empty");
            return this.d.containsKey(str);
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.InterfaceC0318a
        public final T f(java.lang.String str) {
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a("Cookie name must not be empty");
            this.d.remove(str);
            return this;
        }
    }

    public static class b implements com.getui.gtc.extension.distribution.gbd.n.d.a.b {
        private java.lang.String a;
        private java.lang.String b;

        private b(java.lang.String str, java.lang.String str2) {
            this.a = str;
            this.b = str2;
        }

        public static com.getui.gtc.extension.distribution.gbd.n.d.a.c.b a(java.lang.String str, java.lang.String str2) {
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(str, "Data key must not be empty");
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a((java.lang.Object) str2, "Data value must not be null");
            return new com.getui.gtc.extension.distribution.gbd.n.d.a.c.b(str, str2);
        }

        private com.getui.gtc.extension.distribution.gbd.n.d.a.c.b c(java.lang.String str) {
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(str, "Data key must not be empty");
            this.a = str;
            return this;
        }

        private com.getui.gtc.extension.distribution.gbd.n.d.a.c.b d(java.lang.String str) {
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a((java.lang.Object) str, "Data value must not be null");
            this.b = str;
            return this;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.b
        public final /* bridge */ /* synthetic */ com.getui.gtc.extension.distribution.gbd.n.d.a.b a(java.lang.String str) {
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(str, "Data key must not be empty");
            this.a = str;
            return this;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.b
        public final java.lang.String a() {
            return this.a;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.b
        public final /* synthetic */ com.getui.gtc.extension.distribution.gbd.n.d.a.b b(java.lang.String str) {
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a((java.lang.Object) str, "Data value must not be null");
            this.b = str;
            return this;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.b
        public final java.lang.String b() {
            return this.b;
        }

        public final java.lang.String toString() {
            return this.a + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + this.b;
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.d.a.c$c, reason: collision with other inner class name */
    public static class C0319c extends com.getui.gtc.extension.distribution.gbd.n.d.a.c.a<com.getui.gtc.extension.distribution.gbd.n.d.a.d> implements com.getui.gtc.extension.distribution.gbd.n.d.a.d {
        private int e;
        private boolean f;
        private java.util.Collection<com.getui.gtc.extension.distribution.gbd.n.d.a.b> g;
        private boolean h;
        private boolean i;
        private com.getui.gtc.extension.distribution.gbd.n.d.c.f j;

        private C0319c() {
            super((byte) 0);
            this.h = false;
            this.i = false;
            this.e = 3000;
            this.f = true;
            this.g = new java.util.ArrayList();
            this.b = com.getui.gtc.extension.distribution.gbd.n.d.a.c.GET;
            this.c.put(com.google.common.net.HttpHeaders.ACCEPT_ENCODING, "gzip");
            this.j = com.getui.gtc.extension.distribution.gbd.n.d.c.f.a();
        }

        public /* synthetic */ C0319c(byte b) {
            this();
        }

        private com.getui.gtc.extension.distribution.gbd.n.d.a.c.C0319c b(int i) {
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(i >= 0, "Timeout milliseconds must be 0 (infinite) or greater");
            this.e = i;
            return this;
        }

        private com.getui.gtc.extension.distribution.gbd.n.d.a.c.C0319c b(com.getui.gtc.extension.distribution.gbd.n.d.a.b bVar) {
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(bVar, "Key val must not be null");
            this.g.add(bVar);
            return this;
        }

        private com.getui.gtc.extension.distribution.gbd.n.d.a.c.C0319c b(com.getui.gtc.extension.distribution.gbd.n.d.c.f fVar) {
            this.j = fVar;
            return this;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.d
        public final /* bridge */ /* synthetic */ com.getui.gtc.extension.distribution.gbd.n.d.a.d a(int i) {
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(i >= 0, "Timeout milliseconds must be 0 (infinite) or greater");
            this.e = i;
            return this;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.d
        public final /* synthetic */ com.getui.gtc.extension.distribution.gbd.n.d.a.d a(com.getui.gtc.extension.distribution.gbd.n.d.a.b bVar) {
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(bVar, "Key val must not be null");
            this.g.add(bVar);
            return this;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.d
        public final /* bridge */ /* synthetic */ com.getui.gtc.extension.distribution.gbd.n.d.a.d a(com.getui.gtc.extension.distribution.gbd.n.d.c.f fVar) {
            this.j = fVar;
            return this;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.d
        public final com.getui.gtc.extension.distribution.gbd.n.d.a.d a(boolean z) {
            this.f = z;
            return this;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.c.a, com.getui.gtc.extension.distribution.gbd.n.d.a.InterfaceC0318a
        public final /* bridge */ /* synthetic */ java.lang.String a(java.lang.String str) {
            return super.a(str);
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.c.a, com.getui.gtc.extension.distribution.gbd.n.d.a.InterfaceC0318a
        public final /* bridge */ /* synthetic */ java.net.URL a() {
            return super.a();
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.c.a, com.getui.gtc.extension.distribution.gbd.n.d.a.InterfaceC0318a
        public final /* bridge */ /* synthetic */ com.getui.gtc.extension.distribution.gbd.n.d.a.c b() {
            return super.b();
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.d
        public final com.getui.gtc.extension.distribution.gbd.n.d.a.d b(boolean z) {
            this.h = z;
            return this;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.c.a, com.getui.gtc.extension.distribution.gbd.n.d.a.InterfaceC0318a
        public final /* bridge */ /* synthetic */ boolean b(java.lang.String str) {
            return super.b(str);
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.d
        public final com.getui.gtc.extension.distribution.gbd.n.d.a.d c(boolean z) {
            this.i = z;
            return this;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.c.a, com.getui.gtc.extension.distribution.gbd.n.d.a.InterfaceC0318a
        public final /* bridge */ /* synthetic */ java.util.Map c() {
            return super.c();
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.c.a, com.getui.gtc.extension.distribution.gbd.n.d.a.InterfaceC0318a
        public final /* bridge */ /* synthetic */ java.lang.String d(java.lang.String str) {
            return super.d(str);
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.c.a, com.getui.gtc.extension.distribution.gbd.n.d.a.InterfaceC0318a
        public final /* bridge */ /* synthetic */ java.util.Map d() {
            return super.d();
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.d
        public final int e() {
            return this.e;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.c.a, com.getui.gtc.extension.distribution.gbd.n.d.a.InterfaceC0318a
        public final /* bridge */ /* synthetic */ boolean e(java.lang.String str) {
            return super.e(str);
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.d
        public final boolean f() {
            return this.f;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.d
        public final boolean g() {
            return this.h;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.d
        public final boolean h() {
            return this.i;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.d
        public final java.util.Collection<com.getui.gtc.extension.distribution.gbd.n.d.a.b> i() {
            return this.g;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.d
        public final com.getui.gtc.extension.distribution.gbd.n.d.c.f j() {
            return this.j;
        }
    }

    public static class d extends com.getui.gtc.extension.distribution.gbd.n.d.a.c.a<com.getui.gtc.extension.distribution.gbd.n.d.a.e> implements com.getui.gtc.extension.distribution.gbd.n.d.a.e {
        private static final int e = 20;
        private int f;
        private java.lang.String g;
        private java.nio.ByteBuffer h;
        private java.lang.String i;
        private java.lang.String j;
        private boolean k;
        private int l;
        private com.getui.gtc.extension.distribution.gbd.n.d.a.d m;

        public d() {
            super((byte) 0);
            this.k = false;
            this.l = 0;
        }

        private d(com.getui.gtc.extension.distribution.gbd.n.d.a.c.d dVar) {
            super((byte) 0);
            this.k = false;
            this.l = 0;
            if (dVar != null) {
                int i = dVar.l + 1;
                this.l = i;
                if (i >= 20) {
                    throw new java.io.IOException(java.lang.String.format("Too many redirects occurred trying to load URL %s", super.a()));
                }
            }
        }

        private static com.getui.gtc.extension.distribution.gbd.n.d.a.c.d a(com.getui.gtc.extension.distribution.gbd.n.d.a.d dVar) {
            return a(dVar, (com.getui.gtc.extension.distribution.gbd.n.d.a.c.d) null);
        }

        /* JADX WARN: Code restructure failed: missing block: B:56:0x0172, code lost:
        
            r2.m = r9;
            r9 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x0179, code lost:
        
            if (r1.getErrorStream() == null) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x017b, code lost:
        
            r10 = r1.getErrorStream();
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x0188, code lost:
        
            if (r2.b("Content-Encoding") == false) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x0194, code lost:
        
            if (r2.a("Content-Encoding").equalsIgnoreCase("gzip") == false) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x0196, code lost:
        
            r0 = new java.io.BufferedInputStream(new java.util.zip.GZIPInputStream(r10));
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x01a6, code lost:
        
            r9 = r0;
            r2.h = com.getui.gtc.extension.distribution.gbd.n.d.a.a.a(r9);
            r2.i = com.getui.gtc.extension.distribution.gbd.n.d.a.a.a(r2.j);
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x01b5, code lost:
        
            r9.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x01b8, code lost:
        
            if (r10 == null) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x01ba, code lost:
        
            r10.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x01bd, code lost:
        
            r2.k = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x01bf, code lost:
        
            return r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x01a1, code lost:
        
            r0 = new java.io.BufferedInputStream(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x01c0, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:76:0x01c5, code lost:
        
            if (r9 != null) goto L76;
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x01c7, code lost:
        
            r9.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x01ca, code lost:
        
            if (r10 != null) goto L78;
         */
        /* JADX WARN: Code restructure failed: missing block: B:79:0x01cc, code lost:
        
            r10.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x01cf, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:81:0x0180, code lost:
        
            r10 = r1.getInputStream();
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:0x01c2, code lost:
        
            r10 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x01c3, code lost:
        
            r0 = r10;
            r10 = null;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static com.getui.gtc.extension.distribution.gbd.n.d.a.c.d a(com.getui.gtc.extension.distribution.gbd.n.d.a.d dVar, com.getui.gtc.extension.distribution.gbd.n.d.a.c.d dVar2) {
            boolean z;
            while (true) {
                com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(dVar, "Request must not be null");
                java.lang.String protocol = dVar.a().getProtocol();
                boolean z2 = false;
                com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(protocol.equals(com.alipay.sdk.m.l.a.q) || protocol.equals("https"), "Only http & https protocols supported");
                if (dVar.b() == com.getui.gtc.extension.distribution.gbd.n.d.a.c.GET && dVar.i().size() > 0) {
                    java.net.URL a = dVar.a();
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append(a.getProtocol());
                    sb.append("://");
                    sb.append(a.getAuthority());
                    sb.append(a.getPath());
                    sb.append("?");
                    if (a.getQuery() != null) {
                        sb.append(a.getQuery());
                        z = false;
                    } else {
                        z = true;
                    }
                    for (com.getui.gtc.extension.distribution.gbd.n.d.a.b bVar : dVar.i()) {
                        if (z) {
                            z = false;
                        } else {
                            sb.append(kotlin.text.Typography.amp);
                        }
                        sb.append(java.net.URLEncoder.encode(bVar.a(), "UTF-8"));
                        sb.append(com.alipay.sdk.m.n.a.h);
                        sb.append(java.net.URLEncoder.encode(bVar.b(), "UTF-8"));
                    }
                    dVar.a(new java.net.URL(sb.toString()));
                    dVar.i().clear();
                }
                java.net.HttpURLConnection b = b(dVar);
                b.connect();
                if (dVar.b() == com.getui.gtc.extension.distribution.gbd.n.d.a.c.POST) {
                    a(dVar.i(), b.getOutputStream());
                }
                int responseCode = b.getResponseCode();
                if (responseCode != 200) {
                    if (responseCode == 302 || responseCode == 301 || responseCode == 303) {
                        z2 = true;
                    } else if (!dVar.g()) {
                        throw new java.io.IOException(responseCode + " error loading URL " + dVar.a().toString());
                    }
                }
                com.getui.gtc.extension.distribution.gbd.n.d.a.c.d dVar3 = new com.getui.gtc.extension.distribution.gbd.n.d.a.c.d(dVar2);
                dVar3.a(b, dVar2);
                if (!z2 || !dVar.f()) {
                    break;
                }
                dVar.a(com.getui.gtc.extension.distribution.gbd.n.d.a.c.GET);
                dVar.i().clear();
                dVar.a(new java.net.URL(dVar.a(), dVar3.a("Location")));
                for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : dVar3.d.entrySet()) {
                    dVar.b(entry.getKey(), entry.getValue());
                }
                dVar2 = dVar3;
            }
        }

        private void a(java.net.HttpURLConnection httpURLConnection, com.getui.gtc.extension.distribution.gbd.n.d.a.e eVar) {
            this.b = null;
            this.b = httpURLConnection.getRequestMethod().equalsIgnoreCase("GET") ? com.getui.gtc.extension.distribution.gbd.n.d.a.c.GET : com.getui.gtc.extension.distribution.gbd.n.d.a.c.POST;
            this.a = httpURLConnection.getURL();
            this.f = httpURLConnection.getResponseCode();
            this.g = httpURLConnection.getResponseMessage();
            this.j = httpURLConnection.getContentType();
            for (java.util.Map.Entry<java.lang.String, java.util.List<java.lang.String>> entry : httpURLConnection.getHeaderFields().entrySet()) {
                java.lang.String key = entry.getKey();
                if (key != null) {
                    java.util.List<java.lang.String> value = entry.getValue();
                    if (key.equalsIgnoreCase(com.google.common.net.HttpHeaders.SET_COOKIE)) {
                        for (java.lang.String str : value) {
                            if (str != null) {
                                com.getui.gtc.extension.distribution.gbd.n.d.c.i iVar = new com.getui.gtc.extension.distribution.gbd.n.d.c.i(str);
                                java.lang.String trim = iVar.e(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER).trim();
                                java.lang.String trim2 = iVar.d(com.alipay.sdk.m.u.i.b).trim();
                                if (trim2 == null) {
                                    trim2 = "";
                                }
                                if (trim != null && trim.length() > 0) {
                                    b(trim, trim2);
                                }
                            }
                        }
                    } else if (!value.isEmpty()) {
                        a(key, value.get(0));
                    }
                }
            }
            if (eVar != null) {
                for (java.util.Map.Entry<java.lang.String, java.lang.String> entry2 : eVar.d().entrySet()) {
                    if (!super.e(entry2.getKey())) {
                        b(entry2.getKey(), entry2.getValue());
                    }
                }
            }
        }

        private static void a(java.util.Collection<com.getui.gtc.extension.distribution.gbd.n.d.a.b> collection, java.io.OutputStream outputStream) {
            java.io.OutputStreamWriter outputStreamWriter = new java.io.OutputStreamWriter(outputStream, "UTF-8");
            boolean z = true;
            for (com.getui.gtc.extension.distribution.gbd.n.d.a.b bVar : collection) {
                if (z) {
                    z = false;
                } else {
                    outputStreamWriter.append(kotlin.text.Typography.amp);
                }
                outputStreamWriter.write(java.net.URLEncoder.encode(bVar.a(), "UTF-8"));
                outputStreamWriter.write(61);
                outputStreamWriter.write(java.net.URLEncoder.encode(bVar.b(), "UTF-8"));
            }
            outputStreamWriter.close();
        }

        private void a(java.util.Map<java.lang.String, java.util.List<java.lang.String>> map) {
            for (java.util.Map.Entry<java.lang.String, java.util.List<java.lang.String>> entry : map.entrySet()) {
                java.lang.String key = entry.getKey();
                if (key != null) {
                    java.util.List<java.lang.String> value = entry.getValue();
                    if (key.equalsIgnoreCase(com.google.common.net.HttpHeaders.SET_COOKIE)) {
                        for (java.lang.String str : value) {
                            if (str != null) {
                                com.getui.gtc.extension.distribution.gbd.n.d.c.i iVar = new com.getui.gtc.extension.distribution.gbd.n.d.c.i(str);
                                java.lang.String trim = iVar.e(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER).trim();
                                java.lang.String trim2 = iVar.d(com.alipay.sdk.m.u.i.b).trim();
                                if (trim2 == null) {
                                    trim2 = "";
                                }
                                if (trim != null && trim.length() > 0) {
                                    b(trim, trim2);
                                }
                            }
                        }
                    } else if (!value.isEmpty()) {
                        a(key, value.get(0));
                    }
                }
            }
        }

        private static java.net.HttpURLConnection b(com.getui.gtc.extension.distribution.gbd.n.d.a.d dVar) {
            java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) dVar.a().openConnection();
            httpURLConnection.setRequestMethod(dVar.b().name());
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setConnectTimeout(dVar.e());
            httpURLConnection.setReadTimeout(dVar.e());
            boolean z = true;
            if (dVar.b() == com.getui.gtc.extension.distribution.gbd.n.d.a.c.POST) {
                httpURLConnection.setDoOutput(true);
            }
            if (dVar.d().size() > 0) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : dVar.d().entrySet()) {
                    if (z) {
                        z = false;
                    } else {
                        sb.append("; ");
                    }
                    sb.append(entry.getKey());
                    sb.append(com.alipay.sdk.m.n.a.h);
                    sb.append(entry.getValue());
                }
                httpURLConnection.addRequestProperty(com.google.common.net.HttpHeaders.COOKIE, sb.toString());
            }
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry2 : dVar.c().entrySet()) {
                httpURLConnection.addRequestProperty(entry2.getKey(), entry2.getValue());
            }
            return httpURLConnection;
        }

        private static java.lang.String c(com.getui.gtc.extension.distribution.gbd.n.d.a.d dVar) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            boolean z = true;
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : dVar.d().entrySet()) {
                if (z) {
                    z = false;
                } else {
                    sb.append("; ");
                }
                sb.append(entry.getKey());
                sb.append(com.alipay.sdk.m.n.a.h);
                sb.append(entry.getValue());
            }
            return sb.toString();
        }

        private static void d(com.getui.gtc.extension.distribution.gbd.n.d.a.d dVar) {
            boolean z;
            java.net.URL a = dVar.a();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(a.getProtocol());
            sb.append("://");
            sb.append(a.getAuthority());
            sb.append(a.getPath());
            sb.append("?");
            if (a.getQuery() != null) {
                sb.append(a.getQuery());
                z = false;
            } else {
                z = true;
            }
            for (com.getui.gtc.extension.distribution.gbd.n.d.a.b bVar : dVar.i()) {
                if (z) {
                    z = false;
                } else {
                    sb.append(kotlin.text.Typography.amp);
                }
                sb.append(java.net.URLEncoder.encode(bVar.a(), "UTF-8"));
                sb.append(com.alipay.sdk.m.n.a.h);
                sb.append(java.net.URLEncoder.encode(bVar.b(), "UTF-8"));
            }
            dVar.a(new java.net.URL(sb.toString()));
            dVar.i().clear();
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.c.a, com.getui.gtc.extension.distribution.gbd.n.d.a.InterfaceC0318a
        public final /* bridge */ /* synthetic */ java.lang.String a(java.lang.String str) {
            return super.a(str);
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.c.a, com.getui.gtc.extension.distribution.gbd.n.d.a.InterfaceC0318a
        public final /* bridge */ /* synthetic */ java.net.URL a() {
            return super.a();
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.c.a, com.getui.gtc.extension.distribution.gbd.n.d.a.InterfaceC0318a
        public final /* bridge */ /* synthetic */ com.getui.gtc.extension.distribution.gbd.n.d.a.c b() {
            return super.b();
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.c.a, com.getui.gtc.extension.distribution.gbd.n.d.a.InterfaceC0318a
        public final /* bridge */ /* synthetic */ boolean b(java.lang.String str) {
            return super.b(str);
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.c.a, com.getui.gtc.extension.distribution.gbd.n.d.a.InterfaceC0318a
        public final /* bridge */ /* synthetic */ java.util.Map c() {
            return super.c();
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.c.a, com.getui.gtc.extension.distribution.gbd.n.d.a.InterfaceC0318a
        public final /* bridge */ /* synthetic */ java.lang.String d(java.lang.String str) {
            return super.d(str);
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.c.a, com.getui.gtc.extension.distribution.gbd.n.d.a.InterfaceC0318a
        public final /* bridge */ /* synthetic */ java.util.Map d() {
            return super.d();
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.e
        public final int e() {
            return this.f;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.c.a, com.getui.gtc.extension.distribution.gbd.n.d.a.InterfaceC0318a
        public final /* bridge */ /* synthetic */ boolean e(java.lang.String str) {
            return super.e(str);
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.e
        public final java.lang.String f() {
            return this.g;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.e
        public final java.lang.String g() {
            return this.i;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.e
        public final java.lang.String h() {
            return this.j;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.e
        public final com.getui.gtc.extension.distribution.gbd.n.d.b.e i() {
            java.lang.String str;
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(this.k, "Request must be executed (with .execute(), .get(), or .post() before parsing response");
            if (!this.m.h() && ((str = this.j) == null || (!str.startsWith("text/") && !this.j.startsWith("application/xml") && !this.j.startsWith("application/xhtml+xml")))) {
                throw new java.io.IOException(java.lang.String.format("Unhandled content type \"%s\" on URL %s. Must be text/*, application/xml, or application/xhtml+xml", this.j, this.a.toString()));
            }
            com.getui.gtc.extension.distribution.gbd.n.d.b.e a = com.getui.gtc.extension.distribution.gbd.n.d.a.a.a(this.h, this.i, this.a.toExternalForm(), this.m.j());
            this.h.rewind();
            this.i = a.a.b.name();
            return a;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.e
        public final java.lang.String j() {
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(this.k, "Request must be executed (with .execute(), .get(), or .post() before getting response body");
            java.lang.String str = this.i;
            if (str == null) {
                str = "UTF-8";
            }
            java.lang.String charBuffer = java.nio.charset.Charset.forName(str).decode(this.h).toString();
            this.h.rewind();
            return charBuffer;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.a.e
        public final byte[] k() {
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(this.k, "Request must be executed (with .execute(), .get(), or .post() before getting response body");
            return this.h.array();
        }
    }

    private static com.getui.gtc.extension.distribution.gbd.n.d.a b(java.net.URL url) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.c cVar = new com.getui.gtc.extension.distribution.gbd.n.d.a.c();
        cVar.a(url);
        return cVar;
    }

    private static com.getui.gtc.extension.distribution.gbd.n.d.a d(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.c cVar = new com.getui.gtc.extension.distribution.gbd.n.d.a.c();
        cVar.a(str);
        return cVar;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.a
    public final com.getui.gtc.extension.distribution.gbd.n.d.a a(int i) {
        this.a.a(i);
        return this;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.a
    public final com.getui.gtc.extension.distribution.gbd.n.d.a a(com.getui.gtc.extension.distribution.gbd.n.d.a.c cVar) {
        this.a.a(cVar);
        return this;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.a
    public final com.getui.gtc.extension.distribution.gbd.n.d.a a(com.getui.gtc.extension.distribution.gbd.n.d.a.d dVar) {
        this.a = dVar;
        return this;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.a
    public final com.getui.gtc.extension.distribution.gbd.n.d.a a(com.getui.gtc.extension.distribution.gbd.n.d.a.e eVar) {
        this.b = eVar;
        return this;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.a
    public final com.getui.gtc.extension.distribution.gbd.n.d.a a(com.getui.gtc.extension.distribution.gbd.n.d.c.f fVar) {
        this.a.a(fVar);
        return this;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.a
    public final com.getui.gtc.extension.distribution.gbd.n.d.a a(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(str, "Must supply a valid URL");
        try {
            this.a.a(new java.net.URL(str));
            return this;
        } catch (java.net.MalformedURLException e) {
            throw new java.lang.IllegalArgumentException("Malformed URL: ".concat(java.lang.String.valueOf(str)), e);
        }
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.a
    public final com.getui.gtc.extension.distribution.gbd.n.d.a a(java.lang.String str, java.lang.String str2) {
        this.a.a(com.getui.gtc.extension.distribution.gbd.n.d.a.c.b.a(str, str2));
        return this;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.a
    public final com.getui.gtc.extension.distribution.gbd.n.d.a a(java.net.URL url) {
        this.a.a(url);
        return this;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.a
    public final com.getui.gtc.extension.distribution.gbd.n.d.a a(java.util.Map<java.lang.String, java.lang.String> map) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(map, "Data map must not be null");
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            this.a.a(com.getui.gtc.extension.distribution.gbd.n.d.a.c.b.a(entry.getKey(), entry.getValue()));
        }
        return this;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.a
    public final com.getui.gtc.extension.distribution.gbd.n.d.a a(boolean z) {
        this.a.a(z);
        return this;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.a
    public final com.getui.gtc.extension.distribution.gbd.n.d.a a(java.lang.String... strArr) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a((java.lang.Object) strArr, "Data key value pairs must not be null");
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(strArr.length % 2 == 0, "Must supply an even number of key value pairs");
        for (int i = 0; i < strArr.length; i += 2) {
            java.lang.String str = strArr[i];
            java.lang.String str2 = strArr[i + 1];
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(str, "Data key must not be empty");
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a((java.lang.Object) str2, "Data value must not be null");
            this.a.a(com.getui.gtc.extension.distribution.gbd.n.d.a.c.b.a(str, str2));
        }
        return this;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.a
    public final com.getui.gtc.extension.distribution.gbd.n.d.b.e a() {
        this.a.a(com.getui.gtc.extension.distribution.gbd.n.d.a.c.GET);
        c();
        return this.b.i();
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.a
    public final com.getui.gtc.extension.distribution.gbd.n.d.a b(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a((java.lang.Object) str, "User agent must not be null");
        this.a.a("User-Agent", str);
        return this;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.a
    public final com.getui.gtc.extension.distribution.gbd.n.d.a b(java.lang.String str, java.lang.String str2) {
        this.a.a(str, str2);
        return this;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.a
    public final com.getui.gtc.extension.distribution.gbd.n.d.a b(java.util.Map<java.lang.String, java.lang.String> map) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(map, "Cookie map must not be null");
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            this.a.b(entry.getKey(), entry.getValue());
        }
        return this;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.a
    public final com.getui.gtc.extension.distribution.gbd.n.d.a b(boolean z) {
        this.a.b(z);
        return this;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.a
    public final com.getui.gtc.extension.distribution.gbd.n.d.b.e b() {
        this.a.a(com.getui.gtc.extension.distribution.gbd.n.d.a.c.POST);
        c();
        return this.b.i();
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.a
    public final com.getui.gtc.extension.distribution.gbd.n.d.a.e c() {
        com.getui.gtc.extension.distribution.gbd.n.d.a.c.d a2 = com.getui.gtc.extension.distribution.gbd.n.d.a.c.d.a(this.a, (com.getui.gtc.extension.distribution.gbd.n.d.a.c.d) null);
        this.b = a2;
        return a2;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.a
    public final com.getui.gtc.extension.distribution.gbd.n.d.a c(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a((java.lang.Object) str, "Referrer must not be null");
        this.a.a(com.google.common.net.HttpHeaders.REFERER, str);
        return this;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.a
    public final com.getui.gtc.extension.distribution.gbd.n.d.a c(java.lang.String str, java.lang.String str2) {
        this.a.b(str, str2);
        return this;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.a
    public final com.getui.gtc.extension.distribution.gbd.n.d.a c(boolean z) {
        this.a.c(z);
        return this;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.a
    public final com.getui.gtc.extension.distribution.gbd.n.d.a.d d() {
        return this.a;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.a
    public final com.getui.gtc.extension.distribution.gbd.n.d.a.e e() {
        return this.b;
    }
}
