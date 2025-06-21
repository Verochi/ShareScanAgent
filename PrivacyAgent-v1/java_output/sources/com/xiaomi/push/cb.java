package com.xiaomi.push;

/* loaded from: classes19.dex */
final class cb implements java.lang.Comparable<com.xiaomi.push.cb> {
    java.lang.String a;
    protected int b;
    private final java.util.LinkedList<com.xiaomi.push.bq> c;
    private long d;

    public cb() {
        this(null, 0);
    }

    public cb(java.lang.String str) {
        this(str, 0);
    }

    public cb(java.lang.String str, int i) {
        this.c = new java.util.LinkedList<>();
        this.d = 0L;
        this.a = str;
        this.b = i;
    }

    public final synchronized com.xiaomi.push.cb a(org.json.JSONObject jSONObject) {
        this.d = jSONObject.getLong("tt");
        this.b = jSONObject.getInt(com.anythink.expressad.d.a.b.R);
        this.a = jSONObject.getString(com.alipay.sdk.m.l.c.f);
        org.json.JSONArray jSONArray = jSONObject.getJSONArray("ah");
        for (int i = 0; i < jSONArray.length(); i++) {
            org.json.JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            java.util.LinkedList<com.xiaomi.push.bq> linkedList = this.c;
            com.xiaomi.push.bq bqVar = new com.xiaomi.push.bq();
            bqVar.b = jSONObject2.getLong("cost");
            bqVar.e = jSONObject2.getLong(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE);
            bqVar.c = jSONObject2.getLong("ts");
            bqVar.a = jSONObject2.getInt(com.anythink.expressad.d.a.b.R);
            bqVar.d = jSONObject2.optString("expt");
            linkedList.add(bqVar);
        }
        return this;
    }

    public final synchronized org.json.JSONObject a() {
        org.json.JSONObject jSONObject;
        jSONObject = new org.json.JSONObject();
        jSONObject.put("tt", this.d);
        jSONObject.put(com.anythink.expressad.d.a.b.R, this.b);
        jSONObject.put(com.alipay.sdk.m.l.c.f, this.a);
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        java.util.Iterator<com.xiaomi.push.bq> it = this.c.iterator();
        while (it.hasNext()) {
            com.xiaomi.push.bq next = it.next();
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put("cost", next.b);
            jSONObject2.put(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, next.e);
            jSONObject2.put("ts", next.c);
            jSONObject2.put(com.anythink.expressad.d.a.b.R, next.a);
            jSONObject2.put("expt", next.d);
            jSONArray.put(jSONObject2);
        }
        jSONObject.put("ah", jSONArray);
        return jSONObject;
    }

    public final synchronized void a(com.xiaomi.push.bq bqVar) {
        if (bqVar != null) {
            this.c.add(bqVar);
            int i = bqVar.a;
            if (i > 0) {
                this.b += i;
            } else {
                int i2 = 0;
                for (int size = this.c.size() - 1; size >= 0 && this.c.get(size).a < 0; size--) {
                    i2++;
                }
                this.b += i * i2;
            }
            if (this.c.size() > 30) {
                this.b -= this.c.remove().a;
            }
        }
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(com.xiaomi.push.cb cbVar) {
        com.xiaomi.push.cb cbVar2 = cbVar;
        if (cbVar2 == null) {
            return 1;
        }
        return cbVar2.b - this.b;
    }

    public final java.lang.String toString() {
        return this.a + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + this.b;
    }
}
