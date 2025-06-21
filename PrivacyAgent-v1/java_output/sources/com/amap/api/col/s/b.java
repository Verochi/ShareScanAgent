package com.amap.api.col.s;

/* loaded from: classes12.dex */
public abstract class b<T, V> extends com.amap.api.col.s.a<T, V> {
    public b(android.content.Context context, T t) {
        super(context, t);
    }

    public static java.lang.String E(java.lang.String str) {
        java.lang.String[] split = str.split("&");
        java.util.Arrays.sort(split);
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (java.lang.String str2 : split) {
            stringBuffer.append(F(str2));
            stringBuffer.append("&");
        }
        java.lang.String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.length() > 1 ? (java.lang.String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1) : str;
    }

    public static java.lang.String F(java.lang.String str) {
        if (str == null) {
            return str;
        }
        try {
            return java.net.URLDecoder.decode(str, "utf-8");
        } catch (java.io.UnsupportedEncodingException e) {
            com.amap.api.col.s.i.a(e, "ProtocalHandler", "strReEncoder");
            return "";
        } catch (java.lang.Exception e2) {
            com.amap.api.col.s.i.a(e2, "ProtocalHandler", "strReEncoderException");
            return "";
        }
    }

    public static java.lang.String b(java.lang.String str) {
        if (str == null) {
            return str;
        }
        try {
            return java.net.URLEncoder.encode(str, "utf-8");
        } catch (java.io.UnsupportedEncodingException e) {
            com.amap.api.col.s.i.a(e, "ProtocalHandler", "strEncoderUnsupportedEncodingException");
            return "";
        } catch (java.lang.Exception e2) {
            com.amap.api.col.s.i.a(e2, "ProtocalHandler", "strEncoderException");
            return "";
        }
    }

    @Override // com.amap.api.col.s.a
    public abstract V a(java.lang.String str) throws com.amap.api.services.core.AMapException;

    @Override // com.amap.api.col.s.a
    public abstract java.lang.String a_();

    @Override // com.amap.api.col.s.a, com.amap.api.col.s.dd
    public java.util.Map<java.lang.String, java.lang.String> e() {
        return null;
    }

    @Override // com.amap.api.col.s.a, com.amap.api.col.s.dd
    public java.util.Map<java.lang.String, java.lang.String> f() {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("Content-Type", com.anythink.expressad.foundation.g.f.g.b.e);
        hashMap.put(com.google.common.net.HttpHeaders.ACCEPT_ENCODING, "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android Search 8.1.0");
        hashMap.put("X-INFO", com.amap.api.col.s.bl.a(this.e));
        hashMap.put("platinfo", java.lang.String.format("platform=Android&sdkversion=%s&product=%s", "8.1.0", "sea"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    @Override // com.amap.api.col.s.dd
    public byte[] g() {
        try {
            java.lang.String a_ = a_();
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            if (a_ != null) {
                stringBuffer.append(a_);
                stringBuffer.append("&");
            }
            stringBuffer.append("language=");
            stringBuffer.append(com.amap.api.services.core.ServiceSettings.getInstance().getLanguage());
            java.lang.String stringBuffer2 = stringBuffer.toString();
            java.lang.String E = E(stringBuffer2);
            java.lang.StringBuffer stringBuffer3 = new java.lang.StringBuffer();
            stringBuffer3.append(stringBuffer2);
            java.lang.String a = com.amap.api.col.s.bl.a();
            stringBuffer3.append("&ts=".concat(java.lang.String.valueOf(a)));
            stringBuffer3.append("&scode=" + com.amap.api.col.s.bl.a(this.e, a, E));
            return stringBuffer3.toString().getBytes("utf-8");
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.i.a(th, "ProtocalHandler", "getEntity");
            return null;
        }
    }
}
