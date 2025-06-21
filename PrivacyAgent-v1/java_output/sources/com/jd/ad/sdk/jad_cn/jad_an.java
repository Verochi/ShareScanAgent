package com.jd.ad.sdk.jad_cn;

/* loaded from: classes23.dex */
public enum jad_an {
    NET_CONNECTION_IS_NULL_ERROR(10001, "http connection is null"),
    NET_HTTP_RESPONSE_IS_NULL_ERROR(10002, "http response is null"),
    NET_HTTP_OTHER_ERROR(10003, "http other error");

    public int jad_an;
    public java.lang.String jad_bo;

    jad_an(int i, java.lang.String str) {
        this.jad_an = i;
        this.jad_bo = str;
    }

    public java.lang.String jad_an(java.lang.String... strArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(this.jad_bo);
        if (strArr.length > 0) {
            for (java.lang.String str : strArr) {
                if (!android.text.TextUtils.isEmpty(str)) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                    sb.append(str);
                }
            }
        }
        return sb.toString();
    }
}
