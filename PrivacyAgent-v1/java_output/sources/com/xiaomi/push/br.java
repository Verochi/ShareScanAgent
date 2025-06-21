package com.xiaomi.push;

/* loaded from: classes19.dex */
public class br {
    public java.lang.String a;
    long b;
    public java.lang.String c;
    public java.lang.String d;
    public java.lang.String e;
    public java.lang.String f;
    public java.lang.String g;
    public java.lang.String h;
    protected java.lang.String i;
    private java.lang.String n;
    private java.util.ArrayList<com.xiaomi.push.cb> m = new java.util.ArrayList<>();
    double j = 0.1d;
    java.lang.String k = "s.mi1.cc";
    long l = 86400000;

    public br(java.lang.String str) {
        this.a = "";
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException("the host is empty");
        }
        this.b = java.lang.System.currentTimeMillis();
        this.m.add(new com.xiaomi.push.cb(str, -1));
        this.a = com.xiaomi.push.bv.b();
        this.c = str;
    }

    private void a(java.lang.String str, int i, long j, long j2, java.lang.Exception exc) {
        a(str, new com.xiaomi.push.bq(i, j, j2, exc));
    }

    private synchronized void c(java.lang.String str) {
        java.util.Iterator<com.xiaomi.push.cb> it = this.m.iterator();
        while (it.hasNext()) {
            if (android.text.TextUtils.equals(it.next().a, str)) {
                it.remove();
            }
        }
    }

    public final synchronized com.xiaomi.push.br a(org.json.JSONObject jSONObject) {
        this.a = jSONObject.optString(com.alipay.sdk.m.k.b.k);
        this.l = jSONObject.getLong(com.huawei.hms.push.constant.RemoteMessageConst.TTL);
        this.j = jSONObject.getDouble("pct");
        this.b = jSONObject.getLong("ts");
        this.e = jSONObject.optString(com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_CITY);
        this.d = jSONObject.optString("prv");
        this.h = jSONObject.optString("cty");
        this.f = jSONObject.optString("isp");
        this.g = jSONObject.optString("ip");
        this.c = jSONObject.optString(com.alipay.sdk.m.l.c.f);
        this.i = jSONObject.optString("xf");
        org.json.JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i = 0; i < jSONArray.length(); i++) {
            a(new com.xiaomi.push.cb().a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    public final java.util.ArrayList<java.lang.String> a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException("the url is empty.");
        }
        java.net.URL url = new java.net.URL(str);
        if (!android.text.TextUtils.equals(url.getHost(), this.c)) {
            throw new java.lang.IllegalArgumentException("the url is not supported by the fallback");
        }
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>();
        java.util.Iterator<java.lang.String> it = a(true).iterator();
        while (it.hasNext()) {
            com.xiaomi.push.bt a = com.xiaomi.push.bt.a(it.next(), url.getPort());
            arrayList.add(new java.net.URL(url.getProtocol(), a.a, a.b, url.getFile()).toString());
        }
        return arrayList;
    }

    public synchronized java.util.ArrayList<java.lang.String> a(boolean z) {
        java.util.ArrayList<java.lang.String> arrayList;
        java.lang.String substring;
        int size = this.m.size();
        com.xiaomi.push.cb[] cbVarArr = new com.xiaomi.push.cb[size];
        this.m.toArray(cbVarArr);
        java.util.Arrays.sort(cbVarArr);
        arrayList = new java.util.ArrayList<>();
        for (int i = 0; i < size; i++) {
            com.xiaomi.push.cb cbVar = cbVarArr[i];
            if (z) {
                substring = cbVar.a;
            } else {
                int indexOf = cbVar.a.indexOf(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                substring = indexOf != -1 ? cbVar.a.substring(0, indexOf) : cbVar.a;
            }
            arrayList.add(substring);
        }
        return arrayList;
    }

    public final void a(long j) {
        if (j <= 0) {
            throw new java.lang.IllegalArgumentException("the duration is invalid ".concat(java.lang.String.valueOf(j)));
        }
        this.l = j;
    }

    public final synchronized void a(com.xiaomi.push.cb cbVar) {
        c(cbVar.a);
        this.m.add(cbVar);
    }

    public final void a(java.lang.String str, long j, long j2) {
        a(str, 0, j, j2, null);
    }

    public final void a(java.lang.String str, long j, long j2, java.lang.Exception exc) {
        try {
            b(new java.net.URL(str).getHost(), j, j2, exc);
        } catch (java.net.MalformedURLException unused) {
        }
    }

    public synchronized void a(java.lang.String str, com.xiaomi.push.bq bqVar) {
        java.util.Iterator<com.xiaomi.push.cb> it = this.m.iterator();
        while (it.hasNext()) {
            com.xiaomi.push.cb next = it.next();
            if (android.text.TextUtils.equals(str, next.a)) {
                next.a(bqVar);
                return;
            }
        }
    }

    public final synchronized void a(java.lang.String[] strArr) {
        int i;
        int size = this.m.size() - 1;
        while (true) {
            i = 0;
            if (size < 0) {
                break;
            }
            int length = strArr.length;
            while (true) {
                if (i < length) {
                    if (android.text.TextUtils.equals(this.m.get(size).a, strArr[i])) {
                        this.m.remove(size);
                        break;
                    }
                    i++;
                }
            }
            size--;
        }
        java.util.Iterator<com.xiaomi.push.cb> it = this.m.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            int i3 = it.next().b;
            if (i3 > i2) {
                i2 = i3;
            }
        }
        while (i < strArr.length) {
            a(new com.xiaomi.push.cb(strArr[i], (strArr.length + i2) - i));
            i++;
        }
    }

    public boolean a() {
        return java.lang.System.currentTimeMillis() - this.b < this.l;
    }

    public final synchronized java.util.ArrayList<java.lang.String> b() {
        return a(false);
    }

    public final synchronized void b(java.lang.String str) {
        a(new com.xiaomi.push.cb(str));
    }

    public final void b(java.lang.String str, long j, long j2, java.lang.Exception exc) {
        a(str, -1, j, j2, exc);
    }

    public final synchronized java.lang.String c() {
        if (!android.text.TextUtils.isEmpty(this.n)) {
            return this.n;
        }
        if (android.text.TextUtils.isEmpty(this.f)) {
            return "hardcode_isp";
        }
        java.lang.String str = this.f;
        java.lang.String[] strArr = {str, this.d, this.e, this.h, this.g};
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(((str == null ? 16 : str.toString().length()) + 1) * 5);
        for (int i = 0; i < 5; i++) {
            if (i > 0) {
                stringBuffer.append("_");
            }
            java.lang.String str2 = strArr[i];
            if (str2 != null) {
                stringBuffer.append((java.lang.Object) str2);
            }
        }
        java.lang.String stringBuffer2 = stringBuffer.toString();
        this.n = stringBuffer2;
        return stringBuffer2;
    }

    public final synchronized org.json.JSONObject d() {
        org.json.JSONObject jSONObject;
        jSONObject = new org.json.JSONObject();
        jSONObject.put(com.alipay.sdk.m.k.b.k, this.a);
        jSONObject.put(com.huawei.hms.push.constant.RemoteMessageConst.TTL, this.l);
        jSONObject.put("pct", this.j);
        jSONObject.put("ts", this.b);
        jSONObject.put(com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_CITY, this.e);
        jSONObject.put("prv", this.d);
        jSONObject.put("cty", this.h);
        jSONObject.put("isp", this.f);
        jSONObject.put("ip", this.g);
        jSONObject.put(com.alipay.sdk.m.l.c.f, this.c);
        jSONObject.put("xf", this.i);
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        java.util.Iterator<com.xiaomi.push.cb> it = this.m.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().a());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this.a);
        sb.append("\n");
        sb.append(c());
        java.util.Iterator<com.xiaomi.push.cb> it = this.m.iterator();
        while (it.hasNext()) {
            com.xiaomi.push.cb next = it.next();
            sb.append("\n");
            sb.append(next.toString());
        }
        sb.append("\n");
        return sb.toString();
    }
}
