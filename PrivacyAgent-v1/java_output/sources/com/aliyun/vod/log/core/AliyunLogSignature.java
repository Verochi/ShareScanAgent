package com.aliyun.vod.log.core;

/* loaded from: classes12.dex */
public class AliyunLogSignature {

    public static class ParamsComparator implements java.util.Comparator<java.lang.String> {
        @Override // java.util.Comparator
        public int compare(java.lang.String str, java.lang.String str2) {
            return str.compareTo(str2);
        }
    }

    public static java.util.List<java.lang.String> getAllParams(java.util.Map<java.lang.String, java.lang.String> map, java.util.Map<java.lang.String, java.lang.String> map2) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (map != null) {
            for (java.lang.String str : map.keySet()) {
                java.lang.String str2 = map.get(str);
                arrayList.add(percentEncode(str) + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + percentEncode(str2));
            }
        }
        if (map2 != null) {
            for (java.lang.String str3 : map2.keySet()) {
                java.lang.String str4 = map2.get(str3);
                if (!android.text.TextUtils.isEmpty(str4)) {
                    arrayList.add(percentEncode(str3) + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + percentEncode(str4));
                }
            }
        }
        return arrayList;
    }

    public static java.lang.String getCQS(java.util.List<java.lang.String> list) {
        java.util.Collections.sort(list, new com.aliyun.vod.log.core.AliyunLogSignature.ParamsComparator());
        java.lang.String str = "";
        for (int i = 0; i < list.size(); i++) {
            str = str + list.get(i);
            if (i != list.size() - 1) {
                str = str + "&";
            }
        }
        return str;
    }

    public static java.lang.String hmacSHA1Signature(java.lang.String str, java.lang.String str2) {
        try {
            try {
                javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec((str + "&").getBytes(), "HmacSHA1");
                javax.crypto.Mac mac = javax.crypto.Mac.getInstance("HmacSHA1");
                mac.init(secretKeySpec);
                return new java.lang.String(newStringByBase64(mac.doFinal(str2.getBytes())));
            } catch (java.lang.Exception e) {
                throw new java.security.SignatureException("Failed to generate HMAC : " + e.getMessage());
            }
        } catch (java.security.SignatureException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static java.lang.String newStringByBase64(byte[] bArr) throws java.io.UnsupportedEncodingException {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        return new java.lang.String(com.aliyun.vod.log.util.Base64Coder.encode(bArr, 2));
    }

    public static java.lang.String percentEncode(java.lang.String str) {
        try {
            return java.net.URLEncoder.encode(str, "UTF-8").replace("+", "%20").replace("*", "%2A").replace("%7E", com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR);
        } catch (java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }
}
