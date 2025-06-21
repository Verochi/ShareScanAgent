package com.efs.sdk.base.http;

/* loaded from: classes22.dex */
public class HttpResponse extends com.efs.sdk.base.core.model.c<java.util.Map<java.lang.String, java.lang.String>> {
    private static final java.lang.String KEY_BIZ_CODE = "biz_code";
    private static final java.lang.String KEY_REQUEST_URL = "req_url";
    public static final int REQUEST_ERROR_DEFAULT = -1;
    public static final int REQUEST_ERROR_NETWORK_DISCONNECT = -2;
    public static final int REQUEST_ERROR_SOCKET_TIMEOUT = -3;

    /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.HashMap] */
    public HttpResponse() {
        this.extra = new java.util.HashMap();
    }

    public java.lang.String getBizCode() {
        return !((java.util.Map) this.extra).containsKey(KEY_BIZ_CODE) ? "" : (java.lang.String) ((java.util.Map) this.extra).get(KEY_BIZ_CODE);
    }

    public int getHttpCode() {
        return this.code;
    }

    public java.lang.String getReqUrl() {
        return !((java.util.Map) this.extra).containsKey("req_url") ? "" : (java.lang.String) ((java.util.Map) this.extra).get("req_url");
    }

    public void setBizCode(@androidx.annotation.NonNull java.lang.String str) {
        ((java.util.Map) this.extra).put(KEY_BIZ_CODE, str);
    }

    public void setHttpCode(int i) {
        this.succ = (i >= 200 && i < 300) || i == 304;
        this.code = i;
    }

    public void setReqUrl(@androidx.annotation.NonNull java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            str = "";
        }
        if (str.contains("?")) {
            str = str.substring(0, str.indexOf("?"));
        }
        ((java.util.Map) this.extra).put("req_url", str);
    }

    public java.lang.String toString() {
        return "HttpResponse {succ=" + this.succ + ", code=" + this.code + ", data='" + this.data + "', extra=" + this.extra + '}';
    }
}
