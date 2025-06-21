package com.sensorsdata.sf.core.http.internal;

/* loaded from: classes19.dex */
public class HttpCall implements java.lang.Runnable {
    private static final java.lang.String TAG = "HttpCall";
    private com.sensorsdata.sf.core.http.internal.HttpCallBack httpCallBack;
    private final com.sensorsdata.sf.core.http.internal.HttpClient httpClient;
    private com.sensorsdata.sf.core.http.internal.HttpRequest httpRequest;

    /* renamed from: com.sensorsdata.sf.core.http.internal.HttpCall$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.concurrent.Callable<com.sensorsdata.sf.core.http.internal.ResponseBody> {
        public AnonymousClass1() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.sensorsdata.sf.core.http.internal.ResponseBody call() throws java.lang.Exception {
            return com.sensorsdata.sf.core.http.internal.HttpCall.this.sendHttpRequest();
        }
    }

    public HttpCall(com.sensorsdata.sf.core.http.internal.HttpClient httpClient, com.sensorsdata.sf.core.http.internal.HttpRequest httpRequest) {
        this.httpClient = httpClient;
        this.httpRequest = httpRequest;
    }

    private void buildHttpHeaders(java.net.HttpURLConnection httpURLConnection) throws java.net.ProtocolException {
        for (java.lang.String str : this.httpRequest.headers().keySet()) {
            httpURLConnection.setRequestProperty(str, this.httpRequest.headers().get(str));
        }
        httpURLConnection.setReadTimeout(this.httpRequest.readTimeout());
        httpURLConnection.setConnectTimeout(this.httpRequest.connectTimeout());
        httpURLConnection.setDoInput(true);
        httpURLConnection.setUseCaches(this.httpRequest.isUseCaches());
        if ("GET".equals(this.httpRequest.method())) {
            httpURLConnection.setRequestMethod("GET");
            return;
        }
        if ("POST".equals(this.httpRequest.method())) {
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            try {
                if (android.text.TextUtils.isEmpty(this.httpRequest.body())) {
                    return;
                }
                java.io.OutputStream outputStream = httpURLConnection.getOutputStream();
                java.io.BufferedOutputStream bufferedOutputStream = new java.io.BufferedOutputStream(outputStream);
                try {
                    bufferedOutputStream.write(this.httpRequest.body().getBytes(java.nio.charset.Charset.forName("UTF-8")));
                    bufferedOutputStream.flush();
                    com.sensorsdata.sf.ui.utils.IoUtils.closeQuietly(outputStream);
                    com.sensorsdata.sf.ui.utils.IoUtils.closeQuietly(bufferedOutputStream);
                } catch (java.lang.Throwable th) {
                    com.sensorsdata.sf.ui.utils.IoUtils.closeQuietly(outputStream);
                    com.sensorsdata.sf.ui.utils.IoUtils.closeQuietly(bufferedOutputStream);
                    throw th;
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            }
        }
    }

    private java.lang.String buildHttpUrl() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (this.httpRequest.url().contains("?")) {
            sb.append(this.httpRequest.url());
            sb.append("&");
        } else {
            sb.append(this.httpRequest.url());
            sb.append("?");
        }
        for (java.lang.String str : this.httpRequest.requestParameters().keySet()) {
            sb.append(str);
            sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(this.httpRequest.requestParameters().get(str));
            sb.append("&");
        }
        return sb.toString().substring(0, r0.length() - 1);
    }

    private void handleException(com.sensorsdata.sf.core.http.internal.ResponseBody responseBody, java.net.HttpURLConnection httpURLConnection, java.lang.Exception exc) {
        if (this.httpCallBack != null) {
            if (httpURLConnection != null) {
                responseBody.errorStream = httpURLConnection.getErrorStream();
            } else {
                responseBody.body = exc.getMessage();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.sensorsdata.sf.core.http.internal.ResponseBody sendHttpRequest() {
        java.net.HttpURLConnection httpURLConnection;
        java.net.MalformedURLException e;
        com.sensorsdata.sf.core.http.internal.ResponseBody responseBody = new com.sensorsdata.sf.core.http.internal.ResponseBody();
        java.lang.String buildHttpUrl = buildHttpUrl();
        java.net.HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(buildHttpUrl).openConnection();
        } catch (java.net.MalformedURLException e2) {
            httpURLConnection = null;
            e = e2;
        } catch (java.lang.Exception e3) {
            e = e3;
        }
        try {
            buildHttpHeaders(httpURLConnection);
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            responseBody.code = responseCode;
            responseBody.contentLength = httpURLConnection.getContentLength();
            if (responseCode == 200) {
                responseBody.inputStream = httpURLConnection.getInputStream();
            } else {
                responseBody.errorStream = httpURLConnection.getErrorStream();
            }
        } catch (java.net.MalformedURLException e4) {
            e = e4;
            com.sensorsdata.sf.core.utils.SFLog.d(TAG, "Server URL = " + buildHttpUrl + " 无效，请重新设置");
            handleException(responseBody, httpURLConnection, e);
            return responseBody;
        } catch (java.lang.Exception e5) {
            e = e5;
            httpURLConnection2 = httpURLConnection;
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            handleException(responseBody, httpURLConnection2, e);
            return responseBody;
        }
        return responseBody;
    }

    public void execute() {
        this.httpClient.dispatcher().enqueue(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.httpCallBack != null) {
            com.sensorsdata.sf.core.http.internal.ResponseBody sendHttpRequest = sendHttpRequest();
            com.sensorsdata.sf.core.utils.SFLog.d(TAG, "http result:" + sendHttpRequest.toString());
            if (sendHttpRequest.code == 200) {
                this.httpCallBack.onSuccess(this, sendHttpRequest);
            } else {
                this.httpCallBack.onFailure(this, sendHttpRequest);
            }
        }
    }

    public void setHttpCallBack(com.sensorsdata.sf.core.http.internal.HttpCallBack httpCallBack) {
        this.httpCallBack = httpCallBack;
    }

    public com.sensorsdata.sf.core.http.internal.ResponseBody submit() {
        return this.httpClient.dispatcher().submit(new com.sensorsdata.sf.core.http.internal.HttpCall.AnonymousClass1());
    }
}
