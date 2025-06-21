package com.sensorsdata.sf.core.http.internal;

/* loaded from: classes19.dex */
public class HttpClient {
    private static final java.lang.String TAG = "HttpClient";
    private final com.sensorsdata.sf.core.http.internal.Dispatcher dispatcher;

    public static final class Builder {
        private com.sensorsdata.sf.core.http.internal.Dispatcher dispatcher = new com.sensorsdata.sf.core.http.internal.Dispatcher();

        public com.sensorsdata.sf.core.http.internal.HttpClient build() {
            return new com.sensorsdata.sf.core.http.internal.HttpClient(this, null);
        }
    }

    private HttpClient(com.sensorsdata.sf.core.http.internal.HttpClient.Builder builder) {
        this.dispatcher = builder.dispatcher;
    }

    public /* synthetic */ HttpClient(com.sensorsdata.sf.core.http.internal.HttpClient.Builder builder, com.sensorsdata.sf.core.http.internal.HttpClient.AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public com.sensorsdata.sf.core.http.internal.Dispatcher dispatcher() {
        return this.dispatcher;
    }

    public com.sensorsdata.sf.core.http.internal.HttpCall makeHttpCall(com.sensorsdata.sf.core.http.internal.HttpRequest httpRequest) {
        return new com.sensorsdata.sf.core.http.internal.HttpCall(this, httpRequest);
    }
}
