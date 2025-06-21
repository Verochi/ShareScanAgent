package com.alimm.tanx.core.web.cache.utils;

/* loaded from: classes.dex */
public class NetUtils {
    public static java.lang.String getOriginUrl(java.lang.String str) {
        java.lang.String str2 = "";
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            java.net.URL url = new java.net.URL(str);
            int port = url.getPort();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(url.getProtocol());
            sb.append("://");
            sb.append(url.getHost());
            if (port != -1) {
                str2 = com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + port;
            }
            sb.append(str2);
            return sb.toString();
        } catch (java.lang.Exception unused) {
            return str;
        }
    }

    public static boolean isConnected(android.content.Context context) {
        android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static java.util.Map<java.lang.String, java.lang.String> multimapToSingle(java.util.Map<java.lang.String, java.util.List<java.lang.String>> map) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.util.HashMap hashMap = new java.util.HashMap();
        for (java.util.Map.Entry<java.lang.String, java.util.List<java.lang.String>> entry : map.entrySet()) {
            java.util.List<java.lang.String> value = entry.getValue();
            sb.delete(0, sb.length());
            if (value != null && value.size() > 0) {
                java.util.Iterator<java.lang.String> it = value.iterator();
                while (it.hasNext()) {
                    sb.append(it.next());
                    sb.append(com.alipay.sdk.m.u.i.b);
                }
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            hashMap.put(entry.getKey(), sb.toString());
        }
        return hashMap;
    }
}
