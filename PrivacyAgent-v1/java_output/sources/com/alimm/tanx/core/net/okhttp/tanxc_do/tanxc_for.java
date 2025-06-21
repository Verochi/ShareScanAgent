package com.alimm.tanx.core.net.okhttp.tanxc_do;

/* loaded from: classes.dex */
public class tanxc_for {
    private java.util.Map<java.lang.String, java.lang.String> tanxc_byte;
    private java.lang.String tanxc_case;
    private boolean tanxc_char;
    private int tanxc_else;
    private int tanxc_goto;
    private okhttp3.MediaType tanxc_if;
    private java.lang.String tanxc_int;
    private final okhttp3.OkHttpClient tanxc_long;
    private java.lang.String tanxc_new;
    private final android.os.Handler tanxc_this;
    private java.util.Map<java.lang.String, java.lang.String> tanxc_try;
    private okhttp3.Request tanxc_void;
    private int tanxc_do = 0;
    private final okhttp3.MediaType tanxc_for = okhttp3.MediaType.parse("application/json;charset=utf-8");

    /* renamed from: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_for$1, reason: invalid class name */
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

    /* renamed from: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_for$2, reason: invalid class name */
    public class AnonymousClass2 implements okhttp3.Callback {
        final /* synthetic */ com.alimm.tanx.core.net.okhttp.callback.ResultCall tanxc_do;
        final /* synthetic */ long tanxc_if;

        /* renamed from: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_for$2$1, reason: invalid class name */
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
                            str = " --> " + this.tanxc_if.request().url().uri();
                        } catch (java.lang.Exception unused) {
                        }
                        str = message + str;
                    }
                    if (android.text.TextUtils.isEmpty(str)) {
                        com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_for.AnonymousClass2.this.tanxc_do.onError(utErrorCode.getIntCode(), utErrorCode.getMsg());
                    } else {
                        com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_for.AnonymousClass2.this.tanxc_do.onError(utErrorCode.getIntCode(), str);
                    }
                }
                com.alimm.tanx.core.utils.LogUtils.i("OkHttp ", "----------------------------- 请求结束 -----------------------------");
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_for.AnonymousClass2.this.tanxc_do.onAfter();
            }
        }

        /* renamed from: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_for$2$2, reason: invalid class name and collision with other inner class name */
        public class RunnableC00252 implements java.lang.Runnable {
            public RunnableC00252() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.alimm.tanx.core.net.okhttp.callback.ResultCall resultCall = com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_for.AnonymousClass2.this.tanxc_do;
                if (resultCall != null) {
                    resultCall.onAfter();
                }
            }
        }

        public AnonymousClass2(com.alimm.tanx.core.net.okhttp.callback.ResultCall resultCall, long j) {
            this.tanxc_do = resultCall;
            this.tanxc_if = j;
        }

        @Override // okhttp3.Callback
        public void onFailure(okhttp3.Call call, java.io.IOException iOException) {
            if (!(iOException instanceof java.net.SocketException) && com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_for.this.tanxc_goto < com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_for.this.tanxc_else && com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_for.this.tanxc_else > 0) {
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_for.tanxc_for(com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_for.this);
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_for.this.tanxc_long.newCall(call.request()).enqueue(this);
            } else {
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_for.this.tanxc_if();
                if (this.tanxc_do != null) {
                    com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_for.this.tanxc_this.postDelayed(new com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_for.AnonymousClass2.AnonymousClass1(iOException, call), 10L);
                }
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(okhttp3.Call call, okhttp3.Response response) throws java.io.IOException {
            java.lang.String str;
            com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_for.this.tanxc_if();
            int code = response.code();
            com.alimm.tanx.core.utils.LogUtils.i("OkHttp ", "请求code ==> " + code);
            if (!response.isSuccessful()) {
                java.lang.String response2 = response.toString();
                com.alimm.tanx.core.net.okhttp.callback.ResultCall resultCall = this.tanxc_do;
                if (resultCall != null) {
                    resultCall.onError(code, com.alimm.tanx.core.ut.UtErrorCode.NETWORK_HTTP_CODE_EXCEPTION.getMsg() + "   errorMsg: " + response2);
                    return;
                }
                return;
            }
            com.alimm.tanx.core.utils.LogUtils.d("splashTimeConsuming", "netTime onResponse2->" + (java.lang.System.currentTimeMillis() - this.tanxc_if));
            try {
                str = response.body().string();
            } catch (java.lang.Exception e) {
                com.alimm.tanx.core.utils.LogUtils.e(e);
                str = "";
            }
            com.alimm.tanx.core.utils.LogUtils.i("OkHttp ", str);
            com.alimm.tanx.core.net.okhttp.callback.ResultCall resultCall2 = this.tanxc_do;
            if (resultCall2 != null) {
                resultCall2.onSuccess(str);
            }
            com.alimm.tanx.core.utils.LogUtils.i("OkHttp ", "----------------------------- 请求结束 -----------------------------");
            com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_for.this.tanxc_this.postDelayed(new com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_for.AnonymousClass2.RunnableC00252(), 10L);
        }
    }

    public tanxc_for(boolean z) {
        if (z) {
            this.tanxc_long = com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_if().tanxc_do(true);
        } else {
            this.tanxc_long = com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_do(z);
        }
        this.tanxc_this = com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_for();
    }

    private void tanxc_do(okhttp3.FormBody.Builder builder, java.util.Map<java.lang.String, java.lang.String> map) {
        if (builder == null) {
            throw new java.lang.IllegalArgumentException("builder can not be null .");
        }
        if (map == null || map.isEmpty()) {
            return;
        }
        for (java.lang.String str : map.keySet()) {
            builder.add(str, map.get(str));
        }
    }

    public static /* synthetic */ int tanxc_for(com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_for tanxc_forVar) {
        int i = tanxc_forVar.tanxc_goto;
        tanxc_forVar.tanxc_goto = i + 1;
        return i;
    }

    public com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_for tanxc_do() {
        okhttp3.RequestBody build;
        okhttp3.Request.Builder builder = new okhttp3.Request.Builder();
        tanxc_for();
        builder.url(this.tanxc_int);
        com.alimm.tanx.core.utils.LogUtils.i("OkHttp ", "请求接口 ==> " + this.tanxc_int);
        if (!android.text.TextUtils.isEmpty(this.tanxc_new)) {
            builder.tag(this.tanxc_new);
        }
        java.util.Map<java.lang.String, java.lang.String> map = this.tanxc_try;
        if (map != null) {
            builder.headers(tanxc_for(map));
        }
        int i = this.tanxc_do;
        if (i == 1) {
            okhttp3.FormBody.Builder builder2 = new okhttp3.FormBody.Builder();
            if (this.tanxc_byte != null) {
                com.alimm.tanx.core.utils.LogUtils.i("OkHttp ", "请求参数  键值对 ==> " + this.tanxc_byte);
            }
            tanxc_do(builder2, this.tanxc_byte);
            build = builder2.build();
        } else if (i != 2) {
            build = null;
        } else {
            com.alimm.tanx.core.utils.LogUtils.i("OkHttp ", "请求参数  json ==> " + this.tanxc_case);
            okhttp3.MediaType mediaType = this.tanxc_if;
            if (mediaType == null) {
                mediaType = this.tanxc_for;
            }
            build = okhttp3.RequestBody.create(mediaType, this.tanxc_case);
        }
        builder.post(build);
        this.tanxc_void = builder.build();
        return this;
    }

    public com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_for tanxc_do(int i) {
        this.tanxc_else = i;
        return this;
    }

    public com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_for tanxc_do(java.lang.String str) {
        this.tanxc_int = str;
        return this;
    }

    public com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_for tanxc_do(java.util.Map<java.lang.String, java.lang.String> map) {
        this.tanxc_try = map;
        return this;
    }

    public okhttp3.Response tanxc_do(boolean z) {
        com.alimm.tanx.core.utils.LogUtils.i("OkHttp ", "请求方式 ==> SYNC_POST");
        okhttp3.Response response = null;
        try {
            if (this.tanxc_char) {
                if (android.text.TextUtils.isEmpty(this.tanxc_new)) {
                    if (com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().contains(this.tanxc_int)) {
                        return null;
                    }
                    com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().add(this.tanxc_int);
                } else {
                    if (com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().contains(this.tanxc_new)) {
                        return null;
                    }
                    com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().add(this.tanxc_new);
                }
            }
            response = this.tanxc_long.newCall(this.tanxc_void).execute();
            tanxc_if();
            com.alimm.tanx.core.utils.LogUtils.i("OkHttp ", "请求code ==> " + response.code());
            com.alimm.tanx.core.utils.LogUtils.i("OkHttp ", "----------------------------- 请求结束 -----------------------------");
            return response;
        } catch (java.lang.Exception e) {
            if (response != null) {
                com.alimm.tanx.core.utils.LogUtils.e("OkHttp ", "请求异常 ==> " + response.code());
                if (z) {
                    com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(com.alimm.tanx.core.ut.UtErrorCode.CRASH_ERROR.getIntCode(), "OkHttp ", "请求异常 ==> " + response.code() + com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e), "");
                }
            } else if (z) {
                com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(com.alimm.tanx.core.ut.UtErrorCode.CRASH_ERROR.getIntCode(), "OkHttp ", com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e), "");
            }
            com.alimm.tanx.core.utils.LogUtils.e("OkHttp ", e);
            e.printStackTrace();
            return response;
        }
    }

    public void tanxc_do(com.alimm.tanx.core.net.okhttp.callback.ResultCall resultCall) {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        if (resultCall != null) {
            com.alimm.tanx.core.utils.LogUtils.i("OkHttp ", "请求方式 ==> POST");
            this.tanxc_this.post(new com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_for.AnonymousClass1(resultCall));
        }
        if (this.tanxc_char) {
            if (android.text.TextUtils.isEmpty(this.tanxc_new)) {
                if (com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().contains(this.tanxc_int)) {
                    return;
                } else {
                    com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().add(this.tanxc_int);
                }
            } else if (com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().contains(this.tanxc_new)) {
                return;
            } else {
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().add(this.tanxc_new);
            }
        }
        com.alimm.tanx.core.utils.LogUtils.d("splashTimeConsuming", "netTime onResponse1->" + (java.lang.System.currentTimeMillis() - currentTimeMillis));
        this.tanxc_long.newCall(this.tanxc_void).enqueue(new com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_for.AnonymousClass2(resultCall, currentTimeMillis));
    }

    public com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_for tanxc_for(java.lang.String str) {
        this.tanxc_case = str;
        return this;
    }

    public okhttp3.Headers tanxc_for(java.util.Map<java.lang.String, java.lang.String> map) {
        okhttp3.Headers.Builder builder = new okhttp3.Headers.Builder();
        if (map == null || map.isEmpty()) {
            return null;
        }
        for (java.lang.String str : map.keySet()) {
            builder.add(str, map.get(str));
        }
        return builder.build();
    }

    public void tanxc_for() {
        int i;
        if (this.tanxc_byte != null) {
            this.tanxc_do = 1;
            i = 1;
        } else {
            i = 0;
        }
        if (this.tanxc_case != null) {
            this.tanxc_do = 2;
            i++;
        }
        if (i <= 0 || i > 1) {
            throw new java.lang.IllegalArgumentException("the params must has one and only one .");
        }
    }

    public com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_for tanxc_if(java.lang.String str) {
        this.tanxc_new = str;
        return this;
    }

    public com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_for tanxc_if(java.util.Map<java.lang.String, java.lang.String> map) {
        this.tanxc_byte = map;
        return this;
    }

    public com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_for tanxc_if(boolean z) {
        this.tanxc_char = z;
        return this;
    }

    public void tanxc_if() {
        if (this.tanxc_char) {
            if (android.text.TextUtils.isEmpty(this.tanxc_new)) {
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().remove(this.tanxc_int);
            } else {
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().remove(this.tanxc_new);
            }
        }
    }
}
