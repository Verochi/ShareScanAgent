package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class cf extends com.amap.api.mapcore.util.en<java.lang.String, com.amap.api.mapcore.util.cf.a> {
    private java.lang.String j;
    private java.lang.String k;
    private java.lang.String l;
    private final java.lang.String m;
    private boolean n;
    private java.lang.String o;

    public static class a {
        public byte[] a;
        public int b = -1;
        public java.lang.String c = null;
        public boolean d = false;
    }

    public cf(android.content.Context context, java.lang.String str) {
        super(context, str);
        this.k = "1.0";
        this.l = "0";
        this.m = "lastModified";
        this.n = false;
        this.o = null;
        ((com.amap.api.mapcore.util.en) this).h = "/map/styles";
        ((com.amap.api.mapcore.util.en) this).i = true;
    }

    public cf(android.content.Context context, java.lang.String str, boolean z) {
        super(context, str);
        this.k = "1.0";
        this.l = "0";
        this.m = "lastModified";
        this.o = null;
        this.n = z;
        if (z) {
            ((com.amap.api.mapcore.util.en) this).h = "/sdk/map/styles";
            this.isPostFlag = false;
        } else {
            ((com.amap.api.mapcore.util.en) this).h = "/map/styles";
        }
        ((com.amap.api.mapcore.util.en) this).i = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.mapcore.util.en
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.amap.api.mapcore.util.cf.a a(com.amap.api.mapcore.util.hj hjVar) throws com.amap.api.mapcore.util.em {
        java.util.List<java.lang.String> list;
        if (hjVar == null) {
            return null;
        }
        com.amap.api.mapcore.util.cf.a a2 = a(hjVar.a);
        a2.d = a2.a != null;
        java.util.Map<java.lang.String, java.util.List<java.lang.String>> map = hjVar.b;
        if (map == null || !map.containsKey("lastModified") || (list = hjVar.b.get("lastModified")) == null || list.size() <= 0) {
            return a2;
        }
        a2.c = list.get(0);
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.mapcore.util.en
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.amap.api.mapcore.util.cf.a a(byte[] bArr) throws com.amap.api.mapcore.util.em {
        com.amap.api.mapcore.util.cf.a aVar = new com.amap.api.mapcore.util.cf.a();
        aVar.a = bArr;
        if (this.n && bArr != null) {
            if (bArr.length == 0) {
                aVar.a = null;
            } else if (bArr.length <= 1024) {
                try {
                    if (new java.lang.String(bArr, "utf-8").contains("errcode")) {
                        aVar.a = null;
                    }
                } catch (java.lang.Exception e) {
                    com.amap.api.mapcore.util.gd.c(e, "CustomStyleRequest", "loadData");
                }
            }
        }
        return aVar;
    }

    @Override // com.amap.api.mapcore.util.en
    public final /* bridge */ /* synthetic */ com.amap.api.mapcore.util.cf.a a(java.lang.String str) throws com.amap.api.mapcore.util.em {
        return null;
    }

    public final void b(java.lang.String str) {
        this.o = str;
    }

    @Override // com.amap.api.mapcore.util.en
    public final java.lang.String c() {
        return null;
    }

    public final void c(java.lang.String str) {
        this.j = str;
    }

    public final void d(java.lang.String str) {
        this.l = str;
    }

    @Override // com.amap.api.mapcore.util.hi
    public final java.lang.String getIPV6URL() {
        return com.amap.api.mapcore.util.dl.a(getURL());
    }

    @Override // com.amap.api.mapcore.util.cp, com.amap.api.mapcore.util.hi
    public final java.util.Map<java.lang.String, java.lang.String> getParams() {
        java.util.Hashtable hashtable = new java.util.Hashtable(16);
        hashtable.put("key", com.amap.api.mapcore.util.ev.f(((com.amap.api.mapcore.util.en) this).g));
        if (this.n) {
            hashtable.put("sdkType", this.o);
        } else {
            hashtable.put("output", "bin");
        }
        hashtable.put("styleid", this.j);
        hashtable.put("protocol", this.k);
        hashtable.put("ispublic", "1");
        hashtable.put("lastModified", this.l);
        java.lang.String a2 = com.amap.api.mapcore.util.ey.a();
        java.lang.String a3 = com.amap.api.mapcore.util.ey.a(((com.amap.api.mapcore.util.en) this).g, a2, com.amap.api.mapcore.util.fi.b(hashtable));
        hashtable.put("ts", a2);
        hashtable.put("scode", a3);
        return hashtable;
    }

    @Override // com.amap.api.mapcore.util.en, com.amap.api.mapcore.util.hi
    public final java.util.Map<java.lang.String, java.lang.String> getRequestHead() {
        com.amap.api.mapcore.util.fh a2 = com.amap.api.mapcore.util.dl.a();
        java.lang.String b = a2 != null ? a2.b() : null;
        java.util.Hashtable hashtable = new java.util.Hashtable(16);
        hashtable.put("User-Agent", com.amap.api.mapcore.util.l.c);
        hashtable.put(com.google.common.net.HttpHeaders.ACCEPT_ENCODING, "gzip");
        hashtable.put("platinfo", java.lang.String.format(java.util.Locale.US, "platform=Android&sdkversion=%s&product=%s", b, "3dmap"));
        hashtable.put("x-INFO", com.amap.api.mapcore.util.ey.a(((com.amap.api.mapcore.util.en) this).g));
        hashtable.put("key", com.amap.api.mapcore.util.ev.f(((com.amap.api.mapcore.util.en) this).g));
        hashtable.put("logversion", "2.1");
        return hashtable;
    }

    @Override // com.amap.api.mapcore.util.hi
    public final java.lang.String getURL() {
        return "http://restsdk.amap.com/v4" + ((com.amap.api.mapcore.util.en) this).h;
    }

    @Override // com.amap.api.mapcore.util.hi
    public final boolean isSupportIPV6() {
        return true;
    }
}
