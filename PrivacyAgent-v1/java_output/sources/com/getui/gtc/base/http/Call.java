package com.getui.gtc.base.http;

/* loaded from: classes22.dex */
public interface Call {

    public interface Callback {
        void onFailure(com.getui.gtc.base.http.Call call, java.lang.Exception exc);

        void onResponse(com.getui.gtc.base.http.Call call, com.getui.gtc.base.http.Response response);
    }

    void cancel();

    void enqueue(com.getui.gtc.base.http.Call.Callback callback);

    com.getui.gtc.base.http.Response execute() throws java.lang.Exception;

    boolean isCanceled();

    boolean isExecuted();

    com.getui.gtc.base.http.Request request();
}
