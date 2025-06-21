package com.alibaba.sdk.android.oss.common.utils;

/* loaded from: classes.dex */
public class SignUtils {
    public static java.lang.String buildCanonicalString(java.lang.String str, java.lang.String str2, com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage, java.lang.String str3) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        sb.append("\n");
        java.util.Map headers = requestMessage.getHeaders();
        java.util.TreeMap treeMap = new java.util.TreeMap();
        if (headers != null) {
            for (java.util.Map.Entry entry : headers.entrySet()) {
                if (entry.getKey() != null) {
                    java.lang.String lowerCase = ((java.lang.String) entry.getKey()).toLowerCase();
                    if (lowerCase.equals("Content-Type".toLowerCase()) || lowerCase.equals("Content-MD5".toLowerCase()) || lowerCase.equals("Date".toLowerCase()) || lowerCase.startsWith(com.alibaba.sdk.android.oss.common.OSSHeaders.OSS_PREFIX)) {
                        treeMap.put(lowerCase, ((java.lang.String) entry.getValue()).trim());
                    }
                }
            }
        }
        if (!treeMap.containsKey("Content-Type".toLowerCase())) {
            treeMap.put("Content-Type".toLowerCase(), "");
        }
        if (!treeMap.containsKey("Content-MD5".toLowerCase())) {
            treeMap.put("Content-MD5".toLowerCase(), "");
        }
        for (java.util.Map.Entry entry2 : treeMap.entrySet()) {
            java.lang.String str4 = (java.lang.String) entry2.getKey();
            java.lang.Object value = entry2.getValue();
            if (str4.startsWith(com.alibaba.sdk.android.oss.common.OSSHeaders.OSS_PREFIX)) {
                sb.append(str4);
                sb.append(':');
                sb.append(value);
            } else {
                sb.append(value);
            }
            sb.append("\n");
        }
        sb.append(buildCanonicalizedResource(str2, requestMessage.getParameters()));
        return sb.toString();
    }

    public static java.lang.String buildCanonicalizedResource(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        com.alibaba.sdk.android.oss.common.utils.OSSUtils.assertTrue(str.startsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR), "Resource path should start with slash character");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        if (map != null) {
            java.lang.String[] strArr = (java.lang.String[]) map.keySet().toArray(new java.lang.String[map.size()]);
            java.util.Arrays.sort(strArr);
            char c = '?';
            for (java.lang.String str2 : strArr) {
                if (com.alibaba.sdk.android.oss.signer.SignParameters.SIGNED_PARAMTERS.contains(str2)) {
                    sb.append(c);
                    sb.append(str2);
                    java.lang.String str3 = map.get(str2);
                    if (str3 != null && !str3.trim().isEmpty()) {
                        sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                        sb.append(str3);
                    }
                    c = kotlin.text.Typography.amp;
                }
            }
        }
        return sb.toString();
    }

    public static java.lang.String buildSignature(java.lang.String str, java.lang.String str2, java.lang.String str3, com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage) {
        return com.alibaba.sdk.android.oss.signer.ServiceSignature.create().computeSignature(str, buildCanonicalString(str2, str3, requestMessage, null));
    }

    public static java.lang.String composeRequestAuthorization(java.lang.String str, java.lang.String str2) {
        return com.alibaba.sdk.android.oss.signer.SignParameters.AUTHORIZATION_PREFIX + str + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + str2;
    }
}
