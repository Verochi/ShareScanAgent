package com.loc;

/* loaded from: classes23.dex */
public final class ay extends com.loc.s {
    public org.json.JSONObject a = null;
    public android.content.Context b = null;

    @Override // com.loc.bu
    public final java.util.Map<java.lang.String, java.lang.String> a() {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("Content-Type", com.anythink.expressad.foundation.g.f.g.b.e);
        hashMap.put(com.google.common.net.HttpHeaders.ACCEPT_ENCODING, "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android core 4.3.13");
        hashMap.put("X-INFO", com.loc.o.a(this.b));
        hashMap.put("platinfo", java.lang.String.format("platform=Android&sdkversion=%s&product=%s", "4.3.13", "core"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    @Override // com.loc.bu
    public final java.lang.String b() {
        return com.loc.r.a().b() ? "https://restsdk.amap.com/sdk/compliance/params" : "http://restsdk.amap.com/sdk/compliance/params";
    }

    @Override // com.loc.bu
    public final java.lang.String c_() {
        return "core";
    }

    @Override // com.loc.bu
    public final byte[] d() {
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
            java.lang.String f = com.loc.m.f(this.b);
            stringBuffer.append("&key=".concat(java.lang.String.valueOf(f)));
            java.lang.String a = com.loc.o.a();
            stringBuffer.append("&ts=".concat(java.lang.String.valueOf(a)));
            stringBuffer.append("&scode=" + com.loc.o.a(this.b, a, "key=".concat(java.lang.String.valueOf(f))));
            return stringBuffer.toString().getBytes("utf-8");
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.loc.bu
    public final java.util.Map<java.lang.String, java.lang.String> e() {
        return null;
    }
}
