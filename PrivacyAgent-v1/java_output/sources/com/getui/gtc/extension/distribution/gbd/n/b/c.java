package com.getui.gtc.extension.distribution.gbd.n.b;

/* loaded from: classes22.dex */
public final class c {
    private static java.lang.String a(java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return null;
            }
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put("imsi", str);
            hashMap.put("clientIp", "");
            hashMap.put("clientAgent", "");
            java.lang.String a = a(hashMap, "dYmzgLbOiUPyg87ZsBYjg3kjVwe2T7z4");
            java.lang.String a2 = com.getui.gtc.extension.distribution.gbd.n.b.b.a(com.getui.gtc.extension.distribution.gbd.n.b.b.a("test30020" + com.aliyun.auth.common.AliyunVodHttpCommon.Format.FORMAT_JSON + "v1.3" + a, "dYmzgLbOiUPyg87ZsBYjg3kjVwe2T7z4"));
            hashMap.put(com.anythink.expressad.videocommon.e.b.u, "test");
            hashMap.put("clientType", "30020");
            hashMap.put("format", com.aliyun.auth.common.AliyunVodHttpCommon.Format.FORMAT_JSON);
            hashMap.put("version", "v1.3");
            hashMap.put("paras", a);
            hashMap.put("sign", a2);
            return b(hashMap, "&");
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private static java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6) {
        return com.getui.gtc.extension.distribution.gbd.n.b.b.a(com.getui.gtc.extension.distribution.gbd.n.b.b.a(str + str2 + str3 + str4 + str5, str6));
    }

    private static java.lang.String a(java.util.Map map, java.lang.String str) {
        try {
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(java.lang.System.currentTimeMillis());
            map.put("timeStamp", sb.toString());
            for (java.util.Map.Entry entry : map.entrySet()) {
                java.lang.String obj = entry.getKey().toString();
                java.lang.String str2 = (java.lang.String) entry.getValue();
                stringBuffer.append(android.text.TextUtils.isEmpty(str2) ? obj + "=&" : obj + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + str2 + "&");
            }
            java.lang.StringBuffer deleteCharAt = stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            map.clear();
            return com.getui.gtc.extension.distribution.gbd.n.b.a.a(deleteCharAt.toString(), "UTF-8", com.getui.gtc.extension.distribution.gbd.n.b.d.a(str.getBytes()));
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private static java.lang.String b(java.util.Map map, java.lang.String str) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        if (!map.isEmpty()) {
            if (android.text.TextUtils.isEmpty(str)) {
                str = "&";
            }
            for (java.util.Map.Entry entry : map.entrySet()) {
                stringBuffer.append((java.lang.String) entry.getKey());
                stringBuffer.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                stringBuffer.append((java.lang.String) entry.getValue());
                stringBuffer.append(str);
            }
        }
        return stringBuffer.toString();
    }
}
