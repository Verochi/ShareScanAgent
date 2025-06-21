package com.efs.sdk.base.http;

/* loaded from: classes22.dex */
public class HttpEnv {
    private java.util.List<com.efs.sdk.base.core.util.concurrent.b<com.efs.sdk.base.http.HttpResponse>> mHttpListenerList;
    private com.efs.sdk.base.http.IHttpUtil mHttpUtil;

    public static class SingletonHolder {
        private static final com.efs.sdk.base.http.HttpEnv INSTANCE = new com.efs.sdk.base.http.HttpEnv(null);

        private SingletonHolder() {
        }
    }

    private HttpEnv() {
        this.mHttpUtil = com.efs.sdk.base.core.util.a.a.a();
        this.mHttpListenerList = new java.util.ArrayList(1);
    }

    public /* synthetic */ HttpEnv(com.efs.sdk.base.http.HttpEnv.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.efs.sdk.base.http.HttpEnv getInstance() {
        return com.efs.sdk.base.http.HttpEnv.SingletonHolder.INSTANCE;
    }

    public void addListener(@androidx.annotation.NonNull com.efs.sdk.base.http.AbsHttpListener absHttpListener) {
        this.mHttpListenerList.add(absHttpListener);
    }

    public java.util.List<com.efs.sdk.base.core.util.concurrent.b<com.efs.sdk.base.http.HttpResponse>> getHttpListenerList() {
        return new java.util.ArrayList(this.mHttpListenerList);
    }

    public com.efs.sdk.base.http.IHttpUtil getHttpUtil() {
        return this.mHttpUtil;
    }

    public void removeListener(@androidx.annotation.NonNull com.efs.sdk.base.http.AbsHttpListener absHttpListener) {
        this.mHttpListenerList.remove(absHttpListener);
    }

    public void setHttpUtil(com.efs.sdk.base.http.IHttpUtil iHttpUtil) {
        this.mHttpUtil = iHttpUtil;
    }
}
