package com.alimm.tanx.core.net.okhttp.tanxc_do;

/* loaded from: classes.dex */
public class tanxc_if {
    private int tanxc_byte;
    private final okhttp3.OkHttpClient tanxc_case = com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_do(false);
    private final android.os.Handler tanxc_char = com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_for();
    private java.lang.String tanxc_do;
    private okhttp3.Request tanxc_else;
    private java.util.Map<java.lang.String, java.lang.String> tanxc_for;
    private java.lang.String tanxc_if;
    private java.util.Map<java.lang.String, java.lang.String> tanxc_int;
    private boolean tanxc_new;
    private int tanxc_try;

    /* renamed from: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.alimm.tanx.core.net.okhttp.callback.ResultCall tanxc_do;

        public AnonymousClass1(com.alimm.tanx.core.net.okhttp.callback.ResultCall resultCall) {
            this.tanxc_do = resultCall;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.tanxc_do.onBefore();
        }
    }

    /* renamed from: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if$2, reason: invalid class name */
    public class AnonymousClass2 implements okhttp3.Callback {
        final /* synthetic */ com.alimm.tanx.core.net.okhttp.callback.ResultCall tanxc_do;

        /* renamed from: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if$2$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ java.io.IOException tanxc_do;
            final /* synthetic */ okhttp3.Call tanxc_if;

            public AnonymousClass1(java.io.IOException iOException, okhttp3.Call call) {
                this.tanxc_do = iOException;
                this.tanxc_if = call;
            }

            @Override // java.lang.Runnable
            public void run() {
                java.io.IOException iOException = this.tanxc_do;
                if (!(iOException instanceof java.net.SocketException)) {
                    com.alimm.tanx.core.ut.UtErrorCode utErrorCode = iOException instanceof java.net.ConnectException ? com.alimm.tanx.core.ut.UtErrorCode.NETWORK_CONNECT_EXCEPTION : iOException instanceof java.net.SocketTimeoutException ? com.alimm.tanx.core.ut.UtErrorCode.NETWORK_TIMEOUT : com.alimm.tanx.core.ut.UtErrorCode.NETWORK_ERROR;
                    com.alimm.tanx.core.utils.LogUtils.i("OkHttp ", "请求失败原因 ==> " + com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(this.tanxc_do));
                    java.io.IOException iOException2 = this.tanxc_do;
                    java.lang.String str = "";
                    if (iOException2 != null && iOException2.getMessage() != null) {
                        java.lang.String message = this.tanxc_do.getMessage();
                        try {
                            str = " --> " + this.tanxc_if.request().url().uri().toString();
                        } catch (java.lang.Exception unused) {
                        }
                        str = message + str;
                    }
                    if (android.text.TextUtils.isEmpty(str)) {
                        com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if.AnonymousClass2.this.tanxc_do.onError(utErrorCode.getIntCode(), utErrorCode.getMsg());
                    } else {
                        com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if.AnonymousClass2.this.tanxc_do.onError(utErrorCode.getIntCode(), str);
                    }
                }
                com.alimm.tanx.core.utils.LogUtils.i("OkHttp ", "----------------------------- 请求结束 -----------------------------");
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if.AnonymousClass2.this.tanxc_do.onAfter();
            }
        }

        /* renamed from: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if$2$2, reason: invalid class name and collision with other inner class name */
        public class RunnableC00262 implements java.lang.Runnable {
            public RunnableC00262() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.alimm.tanx.core.net.okhttp.callback.ResultCall resultCall = com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if.AnonymousClass2.this.tanxc_do;
                if (resultCall != null) {
                    resultCall.onAfter();
                }
            }
        }

        public AnonymousClass2(com.alimm.tanx.core.net.okhttp.callback.ResultCall resultCall) {
            this.tanxc_do = resultCall;
        }

        @Override // okhttp3.Callback
        public void onFailure(okhttp3.Call call, java.io.IOException iOException) {
            if (!(iOException instanceof java.net.SocketException) && com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if.this.tanxc_byte < com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if.this.tanxc_try && com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if.this.tanxc_try > 0) {
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if.tanxc_for(com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if.this);
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if.this.tanxc_case.newCall(call.request()).enqueue(this);
            } else {
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if.this.tanxc_if();
                if (this.tanxc_do != null) {
                    com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if.this.tanxc_char.postDelayed(new com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if.AnonymousClass2.AnonymousClass1(iOException, call), 10L);
                }
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(okhttp3.Call call, okhttp3.Response response) throws java.io.IOException {
            com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if.this.tanxc_if();
            int code = response.code();
            com.alimm.tanx.core.utils.LogUtils.i("OkHttp ", "请求code ==> " + code);
            if (response.isSuccessful()) {
                java.lang.String string = response.body() != null ? response.body().string() : "";
                com.alimm.tanx.core.utils.LogUtils.i("OkHttp ", string);
                com.alimm.tanx.core.net.okhttp.callback.ResultCall resultCall = this.tanxc_do;
                if (resultCall != null) {
                    resultCall.onSuccess(string);
                }
            } else {
                java.lang.String response2 = response.toString();
                com.alimm.tanx.core.net.okhttp.callback.ResultCall resultCall2 = this.tanxc_do;
                if (resultCall2 != null) {
                    resultCall2.onError(code, com.alimm.tanx.core.ut.UtErrorCode.NETWORK_HTTP_CODE_EXCEPTION.getMsg() + "   errorMsg: " + response2);
                }
            }
            com.alimm.tanx.core.utils.LogUtils.i("OkHttp ", "----------------------------- 请求结束 -----------------------------");
            com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if.this.tanxc_char.postDelayed(new com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if.AnonymousClass2.RunnableC00262(), 10L);
        }
    }

    private java.lang.String tanxc_do(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (str.indexOf("?") == -1) {
            sb.append(str + "?");
        } else {
            sb.append(str + "&");
        }
        if (map != null && !map.isEmpty()) {
            for (java.lang.String str2 : map.keySet()) {
                sb.append(str2);
                sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                sb.append(map.get(str2));
                sb.append("&");
            }
        }
        java.lang.StringBuilder deleteCharAt = sb.deleteCharAt(sb.length() - 1);
        com.alimm.tanx.core.utils.LogUtils.i("OkHttp ", "请求接口 ==>> " + deleteCharAt.toString());
        return deleteCharAt.toString();
    }

    public static /* synthetic */ int tanxc_for(com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if tanxc_ifVar) {
        int i = tanxc_ifVar.tanxc_byte;
        tanxc_ifVar.tanxc_byte = i + 1;
        return i;
    }

    private okhttp3.Headers tanxc_for(java.util.Map<java.lang.String, java.lang.String> map) {
        okhttp3.Headers.Builder builder = new okhttp3.Headers.Builder();
        if (map == null || map.isEmpty()) {
            map = new java.util.HashMap<>();
            map.put("User-Agent", com.alimm.tanx.core.utils.AndroidUtils.getUserAgent());
        }
        for (java.lang.String str : map.keySet()) {
            builder.add(str, map.get(str));
        }
        return builder.build();
    }

    public com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if tanxc_do() {
        okhttp3.Request.Builder builder = new okhttp3.Request.Builder();
        java.util.Map<java.lang.String, java.lang.String> map = this.tanxc_int;
        if (map != null) {
            builder.url(tanxc_do(this.tanxc_do, map));
        } else {
            com.alimm.tanx.core.utils.LogUtils.i("OkHttp ", "请求接口 ==>> " + this.tanxc_do);
            builder.url(this.tanxc_do);
        }
        if (!android.text.TextUtils.isEmpty(this.tanxc_if)) {
            builder.tag(this.tanxc_if);
        }
        builder.headers(tanxc_for(this.tanxc_for));
        this.tanxc_else = builder.build();
        return this;
    }

    public com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if tanxc_do(int i) {
        if (i != 0) {
            com.alimm.tanx.core.net.okhttp.tanxc_if.tanxc_if.tanxc_do().tanxc_do(i);
        }
        return this;
    }

    public com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if tanxc_do(java.lang.String str) {
        this.tanxc_do = str;
        return this;
    }

    public com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if tanxc_do(java.util.Map<java.lang.String, java.lang.String> map) {
        this.tanxc_for = map;
        return this;
    }

    public com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if tanxc_do(boolean z) {
        this.tanxc_new = z;
        return this;
    }

    public void tanxc_do(com.alimm.tanx.core.net.okhttp.callback.ResultCall resultCall) {
        if (resultCall != null) {
            com.alimm.tanx.core.utils.LogUtils.i("OkHttp ", "请求方式 ==> GET");
            this.tanxc_char.post(new com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if.AnonymousClass1(resultCall));
        }
        if (this.tanxc_new) {
            if (android.text.TextUtils.isEmpty(this.tanxc_if)) {
                if (com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().contains(this.tanxc_do)) {
                    if (resultCall != null) {
                        resultCall.onError(com.alimm.tanx.core.ut.UtErrorCode.NETWORK_ONLY_ONE_NET_ERROR_EXCEPTION.getIntCode(), "onlyOneNet error url:" + this.tanxc_do);
                        return;
                    }
                    return;
                }
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().add(this.tanxc_do);
            } else {
                if (com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().contains(this.tanxc_if)) {
                    if (resultCall != null) {
                        resultCall.onError(com.alimm.tanx.core.ut.UtErrorCode.NETWORK_ONLY_ONE_NET_ERROR_EXCEPTION.getIntCode(), "onlyOneNet error tag:" + this.tanxc_if);
                        return;
                    }
                    return;
                }
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().add(this.tanxc_if);
            }
        }
        this.tanxc_case.newCall(this.tanxc_else).enqueue(new com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if.AnonymousClass2(resultCall));
    }

    public com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if tanxc_for(int i) {
        this.tanxc_try = i;
        return this;
    }

    public com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if tanxc_if(int i) {
        if (i != 0) {
            com.alimm.tanx.core.net.okhttp.tanxc_if.tanxc_for.tanxc_do().tanxc_do(i);
        }
        return this;
    }

    public com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if tanxc_if(java.lang.String str) {
        this.tanxc_if = str;
        return this;
    }

    public com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if tanxc_if(java.util.Map<java.lang.String, java.lang.String> map) {
        this.tanxc_int = map;
        return this;
    }

    public void tanxc_if() {
        if (this.tanxc_new) {
            if (android.text.TextUtils.isEmpty(this.tanxc_if)) {
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().remove(this.tanxc_do);
            } else {
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().remove(this.tanxc_if);
            }
        }
    }
}
