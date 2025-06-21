package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class am {
    private static java.lang.String a(java.lang.String str) {
        try {
            return java.lang.String.valueOf(com.xiaomi.push.al.a(java.security.MessageDigest.getInstance("SHA1").digest(str.getBytes("UTF-8"))));
        } catch (java.io.UnsupportedEncodingException | java.security.NoSuchAlgorithmException | java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("CloudCoder.hash4SHA1 ", e);
            throw new java.lang.IllegalStateException("failed to SHA1");
        }
    }

    public static java.lang.String a(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str2)) {
            throw new java.security.InvalidParameterException("security is not nullable");
        }
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList();
        if (str != null) {
            arrayList.add(str.toUpperCase());
        }
        boolean z = true;
        if (!map.isEmpty()) {
            for (java.util.Map.Entry entry : new java.util.TreeMap(map).entrySet()) {
                arrayList.add(java.lang.String.format("%s=%s", entry.getKey(), entry.getValue()));
            }
        }
        arrayList.add(str2);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.lang.String str3 : arrayList) {
            if (!z) {
                sb.append(kotlin.text.Typography.amp);
            }
            sb.append(str3);
            z = false;
        }
        return a(sb.toString());
    }
}
