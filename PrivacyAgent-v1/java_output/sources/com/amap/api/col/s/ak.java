package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class ak extends com.amap.api.col.s.a<java.lang.String, java.lang.String> {
    public java.lang.String t;

    public ak(android.content.Context context, java.lang.String str) {
        super(context, str);
        this.t = str;
    }

    public static java.lang.String b(java.lang.String str) throws com.amap.api.services.core.AMapException {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            java.lang.String a = com.amap.api.col.s.p.a(jSONObject, "code");
            java.lang.String a2 = com.amap.api.col.s.p.a(jSONObject, "message");
            if ("1".equals(a)) {
                return com.amap.api.col.s.p.a(jSONObject, "transfer_url");
            }
            if ("0".equals(a)) {
                throw new com.amap.api.services.core.AMapException(com.amap.api.services.core.AMapException.AMAP_SERVICE_UNKNOWN_ERROR, 0, a2);
            }
            if ("2".equals(a)) {
                throw new com.amap.api.services.core.AMapException(com.amap.api.services.core.AMapException.AMAP_SHARE_FAILURE, 0, a2);
            }
            if ("3".equals(a)) {
                throw new com.amap.api.services.core.AMapException(com.amap.api.services.core.AMapException.AMAP_SERVICE_INVALID_PARAMS, 0, a2);
            }
            if ("4".equals(a)) {
                throw new com.amap.api.services.core.AMapException("用户签名未通过", 0, a2);
            }
            if ("5".equals(a)) {
                throw new com.amap.api.services.core.AMapException(com.amap.api.services.core.AMapException.AMAP_SHARE_LICENSE_IS_EXPIRED, 0, a2);
            }
            return null;
        } catch (org.json.JSONException e) {
            com.amap.api.col.s.i.a(e, "ShareUrlSearchHandler", "paseJSON");
            return null;
        }
    }

    @Override // com.amap.api.col.s.a
    public final /* synthetic */ java.lang.String a(java.lang.String str) throws com.amap.api.services.core.AMapException {
        return b(str);
    }

    @Override // com.amap.api.col.s.a
    public final java.lang.String a_() {
        return null;
    }

    @Override // com.amap.api.col.s.a, com.amap.api.col.s.dd
    public final java.util.Map<java.lang.String, java.lang.String> e() {
        byte[] bArr;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("channel=open_api&flag=1");
        sb.append("&address=" + java.net.URLEncoder.encode(this.t));
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append("open_api1");
        stringBuffer.append(this.t);
        stringBuffer.append("@8UbJH6N2szojnTHONAWzB6K7N1kaj7Y0iUMarxac");
        java.lang.String a = com.amap.api.col.s.bq.a(stringBuffer.toString());
        sb.append("&sign=");
        sb.append(a.toUpperCase(java.util.Locale.US));
        sb.append("&output=json");
        try {
            bArr = com.amap.api.col.s.at.a(sb.toString().getBytes("utf-8"), "Yaynpa84IKOfasFx".getBytes("utf-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            com.amap.api.col.s.i.a(e, "ShareUrlSearchHandler", "getParams");
            bArr = null;
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("ent", "2");
        hashMap.put("in", com.amap.api.col.s.bn.b(bArr));
        hashMap.put("keyt", "openapi");
        return hashMap;
    }

    @Override // com.amap.api.col.s.dd
    public final java.lang.String h() {
        return com.amap.api.col.s.h.e();
    }
}
