package com.meizu.cloud.pushsdk.platform;

/* loaded from: classes23.dex */
public class b {
    public static java.lang.String a(java.lang.String str) {
        try {
            byte[] digest = java.security.MessageDigest.getInstance("MD5").digest(str.getBytes());
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (byte b : digest) {
                int i = b & 255;
                if (i < 16) {
                    sb.append(0);
                }
                sb.append(java.lang.Integer.toHexString(i));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static java.lang.String a(java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str) {
        java.util.Set<java.util.Map.Entry> entrySet = new java.util.TreeMap(map).entrySet();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.util.Map.Entry entry : entrySet) {
            sb.append((java.lang.String) entry.getKey());
            sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append((java.lang.String) entry.getValue());
        }
        sb.append(str);
        return a(sb.toString());
    }
}
