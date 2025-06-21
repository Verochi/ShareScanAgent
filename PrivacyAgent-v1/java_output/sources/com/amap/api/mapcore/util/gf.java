package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class gf extends com.amap.api.mapcore.util.fc {
    public org.json.JSONObject a = null;
    public android.content.Context b = null;

    @Override // com.amap.api.mapcore.util.hi
    public final byte[] getEntityBytes() {
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
            java.lang.String f = com.amap.api.mapcore.util.ev.f(this.b);
            stringBuffer.append("&key=".concat(java.lang.String.valueOf(f)));
            java.lang.String a = com.amap.api.mapcore.util.ey.a();
            stringBuffer.append("&ts=".concat(java.lang.String.valueOf(a)));
            stringBuffer.append("&scode=" + com.amap.api.mapcore.util.ey.a(this.b, a, "key=".concat(java.lang.String.valueOf(f))));
            return stringBuffer.toString().getBytes("utf-8");
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.mapcore.util.hi
    public final java.util.Map<java.lang.String, java.lang.String> getParams() {
        return null;
    }

    @Override // com.amap.api.mapcore.util.hi
    public final java.util.Map<java.lang.String, java.lang.String> getRequestHead() {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("Content-Type", com.anythink.expressad.foundation.g.f.g.b.e);
        hashMap.put(com.google.common.net.HttpHeaders.ACCEPT_ENCODING, "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android core 4.2.7");
        hashMap.put("X-INFO", com.amap.api.mapcore.util.ey.b(this.b));
        hashMap.put("platinfo", java.lang.String.format("platform=Android&sdkversion=%s&product=%s", "4.2.7", "core"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    @Override // com.amap.api.mapcore.util.hi
    public final java.lang.String getSDKName() {
        return "core";
    }

    @Override // com.amap.api.mapcore.util.hi
    public final java.lang.String getURL() {
        return com.amap.api.mapcore.util.fb.a().b() ? "https://restsdk.amap.com/sdk/compliance/params" : "http://restsdk.amap.com/sdk/compliance/params";
    }
}
