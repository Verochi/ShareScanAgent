package com.sina.weibo.sdk.net;

/* loaded from: classes19.dex */
public final class h {
    private java.util.HashMap<java.lang.String, java.lang.String> r = new java.util.HashMap<>();

    public final java.lang.String k() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        boolean z = true;
        for (java.lang.String str : this.r.keySet()) {
            if (z) {
                z = false;
            } else {
                sb.append("&");
            }
            java.lang.String str2 = this.r.get(str);
            if (!android.text.TextUtils.isEmpty(str2)) {
                try {
                    sb.append(java.net.URLEncoder.encode(str, "UTF-8"));
                    sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                    sb.append(java.net.URLEncoder.encode(str2, "UTF-8"));
                } catch (java.io.UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    public final void put(java.lang.String str, java.lang.String str2) {
        this.r.put(str, str2);
    }
}
