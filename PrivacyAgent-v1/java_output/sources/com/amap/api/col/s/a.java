package com.amap.api.col.s;

/* loaded from: classes12.dex */
public abstract class a<T, V> extends com.amap.api.col.s.bp {
    protected T b;
    protected android.content.Context e;
    protected boolean a = true;
    protected int c = 1;
    protected java.lang.String d = "";

    /* renamed from: s, reason: collision with root package name */
    public int f105s = 1;
    protected java.lang.String f = "";

    public a(android.content.Context context, T t) {
        A(context, t);
    }

    public final void A(android.content.Context context, T t) {
        this.e = context;
        this.b = t;
        this.c = 1;
        b(com.amap.api.services.core.ServiceSettings.getInstance().getSoTimeOut());
        a(com.amap.api.services.core.ServiceSettings.getInstance().getConnectionTimeOut());
    }

    public final byte[] B(int i, com.amap.api.col.s.dc dcVar, com.amap.api.col.s.bp bpVar) throws com.amap.api.col.s.bh {
        a(i == 1 ? com.amap.api.col.s.dd.c.HTTP : com.amap.api.col.s.dd.c.HTTPS);
        com.amap.api.col.s.de a = this.a ? com.amap.api.col.s.cx.a(bpVar) : com.amap.api.col.s.dc.e(bpVar);
        if (a == null) {
            return null;
        }
        byte[] bArr = a.a;
        this.f = a.d;
        return bArr;
    }

    public final V C(byte[] bArr) throws com.amap.api.services.core.AMapException {
        return a(bArr);
    }

    public final java.lang.String D() {
        java.lang.String a = a();
        if (a == null) {
            return null;
        }
        try {
            int indexOf = a.indexOf(".com/");
            int indexOf2 = a.indexOf("?");
            return indexOf2 == -1 ? a.substring(indexOf + 5) : a.substring(indexOf + 5, indexOf2);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public abstract V a(java.lang.String str) throws com.amap.api.services.core.AMapException;

    public V a(byte[] bArr) throws com.amap.api.services.core.AMapException {
        java.lang.String str;
        try {
            str = new java.lang.String(bArr, "utf-8");
        } catch (java.lang.Exception e) {
            com.amap.api.col.s.i.a(e, "ProtocalHandler", "loadData");
            str = null;
        }
        if (str == null || str.equals("")) {
            return null;
        }
        com.amap.api.col.s.i.b(str);
        return a(str);
    }

    public abstract java.lang.String a_();

    public final V b() throws com.amap.api.services.core.AMapException {
        if (this.b == null) {
            return null;
        }
        try {
            return z();
        } catch (com.amap.api.services.core.AMapException e) {
            com.amap.api.col.s.am.a(D(), j(), e);
            throw e;
        }
    }

    @Override // com.amap.api.col.s.dd
    public final java.lang.String c() {
        return "sea";
    }

    public com.amap.api.col.s.ad.b d() {
        return null;
    }

    @Override // com.amap.api.col.s.dd
    public java.util.Map<java.lang.String, java.lang.String> e() {
        return null;
    }

    @Override // com.amap.api.col.s.dd
    public java.util.Map<java.lang.String, java.lang.String> f() {
        return null;
    }

    public final java.lang.String j() {
        return this.f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final V z() throws com.amap.api.services.core.AMapException {
        V v;
        com.amap.api.col.s.ad adVar;
        com.amap.api.col.s.ad.c a;
        java.lang.Object obj;
        try {
            com.amap.api.col.s.ad.b d = d();
            boolean b = com.amap.api.col.s.ad.a().b(d);
            boolean z = false;
            int i = 0;
            V v2 = null;
            boolean z2 = false;
            while (i < this.c) {
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                try {
                    try {
                        try {
                            int protocol = com.amap.api.services.core.ServiceSettings.getInstance().getProtocol();
                            com.amap.api.col.s.bo.a().a(this.e);
                            com.amap.api.col.s.dc b2 = com.amap.api.col.s.dc.b();
                            if (b && (a = com.amap.api.col.s.ad.a().a(d)) != null && (obj = a.a) != 0) {
                                try {
                                    com.amap.api.col.s.am.a(this.e, d.a, a.b);
                                    v2 = obj;
                                    z2 = true;
                                } catch (com.amap.api.col.s.bh e) {
                                    e = e;
                                    v2 = obj;
                                    z2 = true;
                                    com.amap.api.col.s.am.a(this.e, D(), java.lang.System.currentTimeMillis() - currentTimeMillis, z);
                                    i++;
                                    if (i >= this.c) {
                                        if (!com.amap.api.maps.AMapException.ERROR_CONNECTION.equals(e.getMessage()) && !com.amap.api.maps.AMapException.ERROR_SOCKET.equals(e.getMessage()) && !com.amap.api.maps.AMapException.ERROR_UNKNOWN.equals(e.a()) && !com.amap.api.maps.AMapException.ERROR_UNKNOW_SERVICE.equals(e.getMessage())) {
                                            throw new com.amap.api.services.core.AMapException(e.a(), 1, e.c());
                                        }
                                        throw new com.amap.api.services.core.AMapException(com.amap.api.services.core.AMapException.AMAP_CLIENT_NETWORK_EXCEPTION, 1, e.c());
                                    }
                                    try {
                                        java.lang.Thread.sleep(this.f105s * 1000);
                                        if (b && !z2) {
                                            com.amap.api.col.s.ad.a().a(d, v2);
                                        }
                                        z = false;
                                    } catch (java.lang.InterruptedException unused) {
                                        if (!com.amap.api.maps.AMapException.ERROR_CONNECTION.equals(e.getMessage()) && !com.amap.api.maps.AMapException.ERROR_SOCKET.equals(e.getMessage()) && !com.amap.api.maps.AMapException.ERROR_UNKNOW_SERVICE.equals(e.getMessage())) {
                                            throw new com.amap.api.services.core.AMapException(e.a(), 1, e.c());
                                        }
                                        throw new com.amap.api.services.core.AMapException(com.amap.api.services.core.AMapException.AMAP_CLIENT_NETWORK_EXCEPTION, 1, e.c());
                                    }
                                } catch (com.amap.api.services.core.AMapException e2) {
                                    e = e2;
                                    v2 = obj;
                                    z2 = true;
                                    com.amap.api.col.s.am.a(this.e, D(), java.lang.System.currentTimeMillis() - currentTimeMillis, z);
                                    i++;
                                    if (i >= this.c) {
                                        throw e;
                                    }
                                    if (b && !z2) {
                                        adVar = com.amap.api.col.s.ad.a();
                                        adVar.a(d, v2);
                                    }
                                    z = false;
                                } catch (java.lang.Throwable th) {
                                    th = th;
                                    v = obj;
                                    z2 = true;
                                    if (b) {
                                        com.amap.api.col.s.ad.a().a(d, v);
                                    }
                                    throw th;
                                }
                            }
                            if (v2 == null) {
                                byte[] B = B(protocol, b2, this);
                                long currentTimeMillis2 = java.lang.System.currentTimeMillis();
                                v2 = C(B);
                                com.amap.api.col.s.am.a(this.e, D(), currentTimeMillis2 - currentTimeMillis, true);
                            }
                            i = this.c;
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            v = null;
                        }
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        v = v2;
                        if (b && !z2) {
                            com.amap.api.col.s.ad.a().a(d, v);
                        }
                        throw th;
                    }
                } catch (com.amap.api.col.s.bh e3) {
                    e = e3;
                } catch (com.amap.api.services.core.AMapException e4) {
                    e = e4;
                }
                if (b && !z2) {
                    adVar = com.amap.api.col.s.ad.a();
                    adVar.a(d, v2);
                }
                z = false;
            }
            return v2;
        } catch (com.amap.api.services.core.AMapException e5) {
            throw e5;
        } catch (java.lang.Throwable th4) {
            th4.printStackTrace();
            throw new com.amap.api.services.core.AMapException(com.amap.api.services.core.AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
        }
    }
}
