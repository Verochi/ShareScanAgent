package com.alimm.tanx.core.net.okhttp.tanxc_do;

/* loaded from: classes.dex */
public class tanxc_do {
    private boolean tanxc_byte;
    private final okhttp3.OkHttpClient tanxc_case = com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_do(false);
    private final android.os.Handler tanxc_char = com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_for();
    private long tanxc_do;
    private okhttp3.Request.Builder tanxc_else;
    private java.lang.String tanxc_for;
    private java.lang.String tanxc_if;
    private java.lang.String tanxc_int;
    private java.lang.String tanxc_new;
    private boolean tanxc_try;

    /* renamed from: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do$1, reason: invalid class name */
    public class AnonymousClass1 implements okhttp3.Callback {
        final /* synthetic */ com.alimm.tanx.core.net.okhttp.callback.OnDownloadListener tanxc_do;

        /* renamed from: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC00241 implements java.lang.Runnable {
            final /* synthetic */ java.io.IOException tanxc_do;

            public RunnableC00241(java.io.IOException iOException) {
                this.tanxc_do = iOException;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.alimm.tanx.core.net.okhttp.callback.OnDownloadListener onDownloadListener = com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do.AnonymousClass1.this.tanxc_do;
                com.alimm.tanx.core.ut.UtErrorCode utErrorCode = com.alimm.tanx.core.ut.UtErrorCode.NETWORK_DOWNLOAD_EXCEPTION;
                onDownloadListener.onDownloadFailed(utErrorCode.getIntCode(), utErrorCode.getMsg() + ": 下载失败监听回调 :" + com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(this.tanxc_do));
            }
        }

        /* renamed from: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do$1$2, reason: invalid class name */
        public class AnonymousClass2 implements com.alimm.tanx.core.utils.FileUtil.WriteProgress {
            public AnonymousClass2() {
            }

            @Override // com.alimm.tanx.core.utils.FileUtil.WriteProgress
            public void error(java.lang.Exception exc) {
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do.AnonymousClass1 anonymousClass1 = com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do.AnonymousClass1.this;
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do.this.tanxc_do(null, -1L, -1, exc, anonymousClass1.tanxc_do);
            }

            @Override // com.alimm.tanx.core.utils.FileUtil.WriteProgress
            public void writeProgress(int i) {
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do.AnonymousClass1 anonymousClass1 = com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do.AnonymousClass1.this;
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do.this.tanxc_do(null, -1L, i, null, anonymousClass1.tanxc_do);
            }
        }

        public AnonymousClass1(com.alimm.tanx.core.net.okhttp.callback.OnDownloadListener onDownloadListener) {
            this.tanxc_do = onDownloadListener;
        }

        @Override // okhttp3.Callback
        public void onFailure(okhttp3.Call call, java.io.IOException iOException) {
            com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do.this.tanxc_if();
            com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do.this.tanxc_char.post(new com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do.AnonymousClass1.RunnableC00241(iOException));
        }

        @Override // okhttp3.Callback
        public void onResponse(okhttp3.Call call, okhttp3.Response response) throws java.io.IOException {
            try {
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do.this.tanxc_if();
                java.io.File andCreateFile = com.alimm.tanx.core.utils.FileUtil.getAndCreateFile(com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do.this.tanxc_int, com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do.this.tanxc_new);
                java.lang.Long valueOf = java.lang.Long.valueOf(response.body().contentLength());
                java.lang.Long l = valueOf != null ? valueOf : 0L;
                if (com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do.this.tanxc_do == l.longValue()) {
                    com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do.this.tanxc_do(andCreateFile, -1L, -1, null, this.tanxc_do);
                    return;
                }
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do.this.tanxc_do(null, com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do.this.tanxc_try ? l.longValue() + com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do.this.tanxc_do : l.longValue(), -1, null, this.tanxc_do);
                if (response.body() != null) {
                    com.alimm.tanx.core.utils.FileUtil.writeFile(response.body(), andCreateFile, com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do.this.tanxc_do, com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do.this.tanxc_try, new com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do.AnonymousClass1.AnonymousClass2());
                }
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do.this.tanxc_do(andCreateFile, -1L, -1, null, this.tanxc_do);
            } catch (java.lang.Exception e) {
                com.alimm.tanx.core.utils.LogUtils.e("OkDownloadBuilder", e);
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do.this.tanxc_do(null, -1L, -1, e, this.tanxc_do);
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ int tanxc_do;
        final /* synthetic */ java.io.File tanxc_for;
        final /* synthetic */ com.alimm.tanx.core.net.okhttp.callback.OnDownloadListener tanxc_if;
        final /* synthetic */ long tanxc_int;
        final /* synthetic */ java.lang.Exception tanxc_new;

        public AnonymousClass2(int i, com.alimm.tanx.core.net.okhttp.callback.OnDownloadListener onDownloadListener, java.io.File file, long j, java.lang.Exception exc) {
            this.tanxc_do = i;
            this.tanxc_if = onDownloadListener;
            this.tanxc_for = file;
            this.tanxc_int = j;
            this.tanxc_new = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = this.tanxc_do;
            if (i > -1) {
                this.tanxc_if.onDownloading(i);
            }
            java.io.File file = this.tanxc_for;
            if (file != null) {
                this.tanxc_if.onDownloadSuccess(file);
            }
            long j = this.tanxc_int;
            if (j > -1) {
                this.tanxc_if.onDownLoadTotal(j);
            }
            if (this.tanxc_new != null) {
                com.alimm.tanx.core.net.okhttp.callback.OnDownloadListener onDownloadListener = this.tanxc_if;
                com.alimm.tanx.core.ut.UtErrorCode utErrorCode = com.alimm.tanx.core.ut.UtErrorCode.NETWORK_DOWNLOAD_EXCEPTION;
                onDownloadListener.onDownloadFailed(utErrorCode.getIntCode(), utErrorCode.getMsg() + ": callBack e不为空:" + com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(this.tanxc_new));
            }
        }
    }

    public com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do tanxc_do() {
        okhttp3.Request.Builder builder = new okhttp3.Request.Builder();
        this.tanxc_else = builder;
        builder.url(this.tanxc_if);
        if (!android.text.TextUtils.isEmpty(this.tanxc_for)) {
            this.tanxc_else.tag(this.tanxc_for);
        }
        this.tanxc_else.cacheControl(okhttp3.CacheControl.FORCE_NETWORK);
        return this;
    }

    public com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do tanxc_do(java.lang.String str) {
        this.tanxc_int = str;
        return this;
    }

    public com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do tanxc_do(boolean z) {
        this.tanxc_try = z;
        return this;
    }

    public void tanxc_do(com.alimm.tanx.core.net.okhttp.callback.OnDownloadListener onDownloadListener) {
        if (this.tanxc_byte) {
            if (android.text.TextUtils.isEmpty(this.tanxc_for)) {
                if (com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().contains(this.tanxc_if)) {
                    return;
                } else {
                    com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().add(this.tanxc_if);
                }
            } else if (com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().contains(this.tanxc_for)) {
                return;
            } else {
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().add(this.tanxc_for);
            }
        }
        if (this.tanxc_try) {
            java.io.File file = new java.io.File(this.tanxc_int, this.tanxc_new);
            if (file.exists()) {
                this.tanxc_do = file.length();
                this.tanxc_else.header("RANGE", "bytes=" + this.tanxc_do + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            }
        }
        this.tanxc_case.newCall(this.tanxc_else.build()).enqueue(new com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do.AnonymousClass1(onDownloadListener));
    }

    public void tanxc_do(java.io.File file, long j, int i, java.lang.Exception exc, com.alimm.tanx.core.net.okhttp.callback.OnDownloadListener onDownloadListener) {
        if (onDownloadListener != null) {
            this.tanxc_char.post(new com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do.AnonymousClass2(i, onDownloadListener, file, j, exc));
        }
    }

    public com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do tanxc_for(java.lang.String str) {
        this.tanxc_if = str;
        return this;
    }

    public com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do tanxc_if(java.lang.String str) {
        this.tanxc_new = str;
        return this;
    }

    public void tanxc_if() {
        if (this.tanxc_byte) {
            if (android.text.TextUtils.isEmpty(this.tanxc_for)) {
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().remove(this.tanxc_if);
            } else {
                com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do().tanxc_int().remove(this.tanxc_for);
            }
        }
    }

    public com.alimm.tanx.core.net.okhttp.tanxc_do.tanxc_do tanxc_int(java.lang.String str) {
        this.tanxc_for = str;
        return this;
    }
}
