package com.getui.gtc.base.http;

/* loaded from: classes22.dex */
public class RealCall implements com.getui.gtc.base.http.Call {
    private volatile boolean canceled;
    private com.getui.gtc.base.http.GtHttpClient client;
    private boolean executed;
    private com.getui.gtc.base.http.Request request;

    public final class AsyncCall implements java.lang.Runnable {
        private final com.getui.gtc.base.http.Call.Callback callback;

        public AsyncCall(com.getui.gtc.base.http.Call.Callback callback) {
            this.callback = callback;
        }

        public final com.getui.gtc.base.http.RealCall get() {
            return com.getui.gtc.base.http.RealCall.this;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.getui.gtc.base.http.Response responseWithInterceptorChain;
            try {
                responseWithInterceptorChain = com.getui.gtc.base.http.RealCall.this.getResponseWithInterceptorChain();
            } finally {
                try {
                } finally {
                }
            }
            if (com.getui.gtc.base.http.RealCall.this.isCanceled()) {
                throw new java.io.IOException("Canceled");
            }
            this.callback.onResponse(get(), responseWithInterceptorChain);
        }
    }

    private RealCall(com.getui.gtc.base.http.GtHttpClient gtHttpClient, com.getui.gtc.base.http.Request request) {
        this.client = gtHttpClient;
        this.request = request;
    }

    public static com.getui.gtc.base.http.RealCall newCall(com.getui.gtc.base.http.GtHttpClient gtHttpClient, com.getui.gtc.base.http.Request request) {
        return new com.getui.gtc.base.http.RealCall(gtHttpClient, request);
    }

    @Override // com.getui.gtc.base.http.Call
    public void cancel() {
        this.canceled = true;
    }

    @Override // com.getui.gtc.base.http.Call
    public void enqueue(com.getui.gtc.base.http.Call.Callback callback) {
        synchronized (this) {
            if (this.executed) {
                throw new java.lang.IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        this.client.getDispatcher().enqueue(new com.getui.gtc.base.http.RealCall.AsyncCall(callback));
    }

    @Override // com.getui.gtc.base.http.Call
    public com.getui.gtc.base.http.Response execute() throws java.lang.Exception {
        synchronized (this) {
            if (this.executed) {
                throw new java.lang.IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        try {
            this.client.getDispatcher().executed(this);
            com.getui.gtc.base.http.Response responseWithInterceptorChain = getResponseWithInterceptorChain();
            if (responseWithInterceptorChain != null) {
                return responseWithInterceptorChain;
            }
            throw new java.io.IOException("Canceled");
        } finally {
            this.client.getDispatcher().finished(this);
        }
    }

    public com.getui.gtc.base.http.Response getResponseWithInterceptorChain() throws java.lang.Exception {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.addAll(this.client.interceptors);
        if (this.request.cryptInterceptor() != null) {
            arrayList.add(this.request.cryptInterceptor());
        }
        arrayList.add(new com.getui.gtc.base.http.BridgeInterceptor());
        arrayList.add(new com.getui.gtc.base.http.ConnectInterceptor(this.client));
        arrayList.add(new com.getui.gtc.base.http.CallServerInterceptor());
        return new com.getui.gtc.base.http.RealInterceptorChain(arrayList, null, 0, this.request).proceed(this.request);
    }

    @Override // com.getui.gtc.base.http.Call
    public boolean isCanceled() {
        return this.canceled;
    }

    @Override // com.getui.gtc.base.http.Call
    public synchronized boolean isExecuted() {
        return this.executed;
    }

    @Override // com.getui.gtc.base.http.Call
    public com.getui.gtc.base.http.Request request() {
        return this.request;
    }
}
