package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public abstract class en<T, V> extends com.amap.api.mapcore.util.cp {
    protected T a;
    protected android.content.Context g;
    protected java.lang.String h;
    protected int b = 1;
    protected boolean i = false;

    public en(android.content.Context context, T t) {
        a(context, t);
    }

    private void a(android.content.Context context, T t) {
        this.g = context;
        this.a = t;
        this.b = 1;
        setSoTimeout(30000);
        setConnectionTimeout(30000);
    }

    private V b(com.amap.api.mapcore.util.hj hjVar) throws com.amap.api.mapcore.util.em {
        return a(hjVar);
    }

    private V b(byte[] bArr) throws com.amap.api.mapcore.util.em {
        return a(bArr);
    }

    private V e() throws com.amap.api.mapcore.util.em {
        V v = null;
        int i = 0;
        while (i < this.b) {
            try {
                setProxy(com.amap.api.mapcore.util.fg.a(this.g));
                v = this.i ? b(makeHttpRequestNeedHeader()) : b(makeHttpRequest());
                i = this.b;
            } catch (com.amap.api.mapcore.util.em e) {
                i++;
                if (i >= this.b) {
                    throw new com.amap.api.mapcore.util.em(e.a());
                }
            } catch (com.amap.api.mapcore.util.eu e2) {
                i++;
                if (i >= this.b) {
                    if (com.amap.api.maps.AMapException.ERROR_CONNECTION.equals(e2.getMessage()) || com.amap.api.maps.AMapException.ERROR_SOCKET.equals(e2.getMessage()) || com.amap.api.maps.AMapException.ERROR_UNKNOWN.equals(e2.a()) || com.amap.api.maps.AMapException.ERROR_UNKNOW_SERVICE.equals(e2.getMessage())) {
                        throw new com.amap.api.mapcore.util.em(com.amap.api.services.core.AMapException.AMAP_CLIENT_NETWORK_EXCEPTION);
                    }
                    throw new com.amap.api.mapcore.util.em(e2.a());
                }
                try {
                    java.lang.Thread.sleep(1000L);
                } catch (java.lang.InterruptedException unused) {
                    if (com.amap.api.maps.AMapException.ERROR_CONNECTION.equals(e2.getMessage()) || com.amap.api.maps.AMapException.ERROR_SOCKET.equals(e2.getMessage()) || com.amap.api.maps.AMapException.ERROR_UNKNOW_SERVICE.equals(e2.getMessage())) {
                        throw new com.amap.api.mapcore.util.em(com.amap.api.services.core.AMapException.AMAP_CLIENT_NETWORK_EXCEPTION);
                    }
                    throw new com.amap.api.mapcore.util.em(e2.a());
                }
            }
        }
        return v;
    }

    public V a(com.amap.api.mapcore.util.hj hjVar) throws com.amap.api.mapcore.util.em {
        return null;
    }

    public abstract V a(java.lang.String str) throws com.amap.api.mapcore.util.em;

    public V a(byte[] bArr) throws com.amap.api.mapcore.util.em {
        java.lang.String str;
        try {
            str = new java.lang.String(bArr, "utf-8");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            str = null;
        }
        if (str == null || "".equals(str)) {
            return null;
        }
        com.amap.api.mapcore.util.ep.a(str);
        return a(str);
    }

    public abstract java.lang.String c();

    public final V d() throws com.amap.api.mapcore.util.em {
        if (this.a == null) {
            return null;
        }
        try {
            return e();
        } catch (com.amap.api.mapcore.util.em e) {
            com.amap.api.mapcore.util.dl.a(e);
            throw e;
        }
    }

    @Override // com.amap.api.mapcore.util.hi
    public java.util.Map<java.lang.String, java.lang.String> getRequestHead() {
        com.amap.api.mapcore.util.fh a = com.amap.api.mapcore.util.dl.a();
        java.lang.String b = a != null ? a.b() : null;
        java.util.Hashtable hashtable = new java.util.Hashtable(16);
        hashtable.put("User-Agent", com.amap.api.mapcore.util.l.c);
        hashtable.put(com.google.common.net.HttpHeaders.ACCEPT_ENCODING, "gzip");
        hashtable.put("platinfo", java.lang.String.format(java.util.Locale.US, "platform=Android&sdkversion=%s&product=%s", b, "3dmap"));
        hashtable.put("X-INFO", com.amap.api.mapcore.util.ey.b(this.g));
        hashtable.put("key", com.amap.api.mapcore.util.ev.f(this.g));
        hashtable.put("logversion", "2.1");
        return hashtable;
    }
}
