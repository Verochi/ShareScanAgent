package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class cl extends com.amap.api.col.s.bp {
    public org.json.JSONObject a = null;
    public android.content.Context b = null;

    @Override // com.amap.api.col.s.dd
    public final java.lang.String c() {
        return "core";
    }

    @Override // com.amap.api.col.s.dd
    public final java.util.Map<java.lang.String, java.lang.String> e() {
        return null;
    }

    @Override // com.amap.api.col.s.dd
    public final java.util.Map<java.lang.String, java.lang.String> f() {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("Content-Type", com.anythink.expressad.foundation.g.f.g.b.e);
        hashMap.put(com.google.common.net.HttpHeaders.ACCEPT_ENCODING, "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android core 4.2.5");
        hashMap.put("X-INFO", com.amap.api.col.s.bl.a(this.b));
        hashMap.put("platinfo", java.lang.String.format("platform=Android&sdkversion=%s&product=%s", "4.2.5", "core"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    @Override // com.amap.api.col.s.dd
    public final byte[] g() {
        try {
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            org.json.JSONObject jSONObject = this.a;
            if (jSONObject != null) {
                java.util.Iterator<java.lang.String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    java.lang.String next = keys.next();
                    stringBuffer.append(next + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + java.net.URLEncoder.encode(this.a.get(next).toString(), "utf-8") + "&");
                }
            }
            stringBuffer.append("output=json");
            java.lang.String f = com.amap.api.col.s.bi.f(this.b);
            stringBuffer.append("&key=".concat(java.lang.String.valueOf(f)));
            java.lang.String a = com.amap.api.col.s.bl.a();
            stringBuffer.append("&ts=".concat(java.lang.String.valueOf(a)));
            stringBuffer.append("&scode=" + com.amap.api.col.s.bl.a(this.b, a, "key=".concat(java.lang.String.valueOf(f))));
            return stringBuffer.toString().getBytes("utf-8");
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.col.s.dd
    public final java.lang.String h() {
        return com.amap.api.col.s.bo.a().b() ? "https://restsdk.amap.com/sdk/compliance/params" : "http://restsdk.amap.com/sdk/compliance/params";
    }
}
