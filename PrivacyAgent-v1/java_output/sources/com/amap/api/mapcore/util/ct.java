package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public abstract class ct extends com.amap.api.mapcore.util.cp {
    public ct() {
        setProxy(com.amap.api.mapcore.util.fg.a(com.amap.api.mapcore.util.p.a));
        setConnectionTimeout(5000);
        setSoTimeout(50000);
    }

    public static java.lang.String a(java.lang.String str) {
        java.lang.String b = b(str);
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append(str);
        java.lang.String a = com.amap.api.mapcore.util.ey.a();
        stringBuffer.append("&ts=".concat(java.lang.String.valueOf(a)));
        stringBuffer.append("&scode=" + com.amap.api.mapcore.util.ey.a(com.amap.api.mapcore.util.p.a, a, b));
        return stringBuffer.toString();
    }

    private static java.lang.String b(java.lang.String str) {
        java.lang.String[] split = str.split("&");
        java.util.Arrays.sort(split);
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (java.lang.String str2 : split) {
            stringBuffer.append(c(str2));
            stringBuffer.append("&");
        }
        java.lang.String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.length() > 1 ? (java.lang.String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1) : str;
    }

    private static java.lang.String c(java.lang.String str) {
        if (str == null) {
            return str;
        }
        try {
            return java.net.URLDecoder.decode(str, "utf-8");
        } catch (java.io.UnsupportedEncodingException e) {
            com.amap.api.mapcore.util.gd.c(e, "AbstractProtocalHandler", "strReEncoder");
            return "";
        } catch (java.lang.Exception e2) {
            com.amap.api.mapcore.util.gd.c(e2, "AbstractProtocalHandler", "strReEncoderException");
            return "";
        }
    }

    @Override // com.amap.api.mapcore.util.hi
    public java.lang.String getIPV6URL() {
        java.lang.String url = getURL();
        return (url == null || !url.contains("http://restsdk.amap.com/v4/gridmap?")) ? url : com.amap.api.mapcore.util.dl.a(url);
    }

    @Override // com.amap.api.mapcore.util.cp, com.amap.api.mapcore.util.hi
    public java.util.Map<java.lang.String, java.lang.String> getParams() {
        return null;
    }

    @Override // com.amap.api.mapcore.util.hi
    public java.util.Map<java.lang.String, java.lang.String> getRequestHead() {
        java.util.Hashtable hashtable = new java.util.Hashtable(16);
        hashtable.put("User-Agent", com.amap.api.mapcore.util.l.c);
        hashtable.put(com.google.common.net.HttpHeaders.ACCEPT_ENCODING, "gzip");
        hashtable.put("platinfo", java.lang.String.format(java.util.Locale.US, "platform=Android&sdkversion=%s&product=%s", "9.1.0", "3dmap"));
        hashtable.put("x-INFO", com.amap.api.mapcore.util.ey.a(com.amap.api.mapcore.util.p.a));
        hashtable.put("key", com.amap.api.mapcore.util.ev.f(com.amap.api.mapcore.util.p.a));
        hashtable.put("logversion", "2.1");
        return hashtable;
    }

    @Override // com.amap.api.mapcore.util.hi
    public boolean isSupportIPV6() {
        java.lang.String url = getURL();
        return url != null && url.contains("http://restsdk.amap.com/v4/gridmap?");
    }
}
