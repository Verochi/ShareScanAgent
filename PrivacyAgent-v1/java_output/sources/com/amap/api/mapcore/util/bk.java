package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public abstract class bk<T, V> {
    protected T a;
    protected int b = 3;
    protected android.content.Context c;

    public bk(android.content.Context context, T t) {
        a(context, t);
    }

    private void a(android.content.Context context, T t) {
        this.c = context;
        this.a = t;
    }

    private V d() throws com.amap.api.maps.AMapException {
        int i;
        java.lang.String str;
        com.amap.api.maps.AMapException aMapException;
        int i2 = 0;
        V v = null;
        com.amap.api.mapcore.util.ew.a aVar = null;
        while (i2 < this.b) {
            try {
                aVar = com.amap.api.mapcore.util.ew.a(this.c, com.amap.api.mapcore.util.dl.a(), a(), b());
                v = a(a(aVar));
                i2 = this.b;
            } finally {
                if (i2 < i) {
                    continue;
                }
            }
        }
        return v;
    }

    public abstract V a(org.json.JSONObject jSONObject) throws com.amap.api.maps.AMapException;

    public abstract java.lang.String a();

    public abstract org.json.JSONObject a(com.amap.api.mapcore.util.ew.a aVar);

    public abstract java.util.Map<java.lang.String, java.lang.String> b();

    public final V c() throws com.amap.api.maps.AMapException {
        if (this.a != null) {
            return d();
        }
        return null;
    }
}
