package com.getui.gtc.base.http;

/* loaded from: classes22.dex */
public interface Interceptor {

    public interface Chain {
        java.net.HttpURLConnection connection();

        com.getui.gtc.base.http.Response proceed(com.getui.gtc.base.http.Request request) throws java.io.IOException;

        com.getui.gtc.base.http.Request request();
    }

    com.getui.gtc.base.http.Response intercept(com.getui.gtc.base.http.Interceptor.Chain chain) throws java.io.IOException;
}
