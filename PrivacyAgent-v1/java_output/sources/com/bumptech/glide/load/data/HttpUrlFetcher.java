package com.bumptech.glide.load.data;

/* loaded from: classes.dex */
public class HttpUrlFetcher implements com.bumptech.glide.load.data.DataFetcher<java.io.InputStream> {

    @androidx.annotation.VisibleForTesting
    static final com.bumptech.glide.load.data.HttpUrlFetcher.HttpUrlConnectionFactory DEFAULT_CONNECTION_FACTORY = new com.bumptech.glide.load.data.HttpUrlFetcher.DefaultHttpUrlConnectionFactory();
    private static final int INVALID_STATUS_CODE = -1;
    private static final int MAXIMUM_REDIRECTS = 5;
    private static final java.lang.String TAG = "HttpUrlFetcher";
    private final com.bumptech.glide.load.data.HttpUrlFetcher.HttpUrlConnectionFactory connectionFactory;
    private final com.bumptech.glide.load.model.GlideUrl glideUrl;
    private volatile boolean isCancelled;
    private java.io.InputStream stream;
    private final int timeout;
    private java.net.HttpURLConnection urlConnection;

    public static class DefaultHttpUrlConnectionFactory implements com.bumptech.glide.load.data.HttpUrlFetcher.HttpUrlConnectionFactory {
        @Override // com.bumptech.glide.load.data.HttpUrlFetcher.HttpUrlConnectionFactory
        public java.net.HttpURLConnection build(java.net.URL url) throws java.io.IOException {
            return (java.net.HttpURLConnection) url.openConnection();
        }
    }

    public interface HttpUrlConnectionFactory {
        java.net.HttpURLConnection build(java.net.URL url) throws java.io.IOException;
    }

    public HttpUrlFetcher(com.bumptech.glide.load.model.GlideUrl glideUrl, int i) {
        this(glideUrl, i, DEFAULT_CONNECTION_FACTORY);
    }

    @androidx.annotation.VisibleForTesting
    public HttpUrlFetcher(com.bumptech.glide.load.model.GlideUrl glideUrl, int i, com.bumptech.glide.load.data.HttpUrlFetcher.HttpUrlConnectionFactory httpUrlConnectionFactory) {
        this.glideUrl = glideUrl;
        this.timeout = i;
        this.connectionFactory = httpUrlConnectionFactory;
    }

    private java.io.InputStream getStreamForSuccessfulRequest(java.net.HttpURLConnection httpURLConnection) throws java.io.IOException {
        if (android.text.TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.stream = com.bumptech.glide.util.ContentLengthInputStream.obtain(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
        } else {
            if (android.util.Log.isLoggable(TAG, 3)) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Got non empty content encoding: ");
                sb.append(httpURLConnection.getContentEncoding());
            }
            this.stream = httpURLConnection.getInputStream();
        }
        return this.stream;
    }

    private static boolean isHttpOk(int i) {
        return i / 100 == 2;
    }

    private static boolean isHttpRedirect(int i) {
        return i / 100 == 3;
    }

    private java.io.InputStream loadDataWithRedirects(java.net.URL url, int i, java.net.URL url2, java.util.Map<java.lang.String, java.lang.String> map) throws java.io.IOException {
        if (i >= 5) {
            throw new com.bumptech.glide.load.HttpException("Too many (> 5) redirects!");
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new com.bumptech.glide.load.HttpException("In re-direct loop");
                }
            } catch (java.net.URISyntaxException unused) {
            }
        }
        this.urlConnection = this.connectionFactory.build(url);
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            this.urlConnection.addRequestProperty(entry.getKey(), entry.getValue());
        }
        this.urlConnection.setConnectTimeout(this.timeout);
        this.urlConnection.setReadTimeout(this.timeout);
        this.urlConnection.setUseCaches(false);
        this.urlConnection.setDoInput(true);
        this.urlConnection.setInstanceFollowRedirects(false);
        this.urlConnection.connect();
        this.stream = this.urlConnection.getInputStream();
        if (this.isCancelled) {
            return null;
        }
        int responseCode = this.urlConnection.getResponseCode();
        if (isHttpOk(responseCode)) {
            return getStreamForSuccessfulRequest(this.urlConnection);
        }
        if (!isHttpRedirect(responseCode)) {
            if (responseCode == -1) {
                throw new com.bumptech.glide.load.HttpException(responseCode);
            }
            throw new com.bumptech.glide.load.HttpException(this.urlConnection.getResponseMessage(), responseCode);
        }
        java.lang.String headerField = this.urlConnection.getHeaderField("Location");
        if (android.text.TextUtils.isEmpty(headerField)) {
            throw new com.bumptech.glide.load.HttpException("Received empty or null redirect url");
        }
        java.net.URL url3 = new java.net.URL(url, headerField);
        cleanup();
        return loadDataWithRedirects(url3, i + 1, url, map);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
        this.isCancelled = true;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        java.io.InputStream inputStream = this.stream;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (java.io.IOException unused) {
            }
        }
        java.net.HttpURLConnection httpURLConnection = this.urlConnection;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.urlConnection = null;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @androidx.annotation.NonNull
    public java.lang.Class<java.io.InputStream> getDataClass() {
        return java.io.InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @androidx.annotation.NonNull
    public com.bumptech.glide.load.DataSource getDataSource() {
        return com.bumptech.glide.load.DataSource.REMOTE;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void loadData(@androidx.annotation.NonNull com.bumptech.glide.Priority priority, @androidx.annotation.NonNull com.bumptech.glide.load.data.DataFetcher.DataCallback<? super java.io.InputStream> dataCallback) {
        java.lang.StringBuilder sb;
        long logTime = com.bumptech.glide.util.LogTime.getLogTime();
        try {
            try {
                dataCallback.onDataReady(loadDataWithRedirects(this.glideUrl.toURL(), 0, null, this.glideUrl.getHeaders()));
            } catch (java.io.IOException e) {
                android.util.Log.isLoggable(TAG, 3);
                dataCallback.onLoadFailed(e);
                if (!android.util.Log.isLoggable(TAG, 2)) {
                    return;
                } else {
                    sb = new java.lang.StringBuilder();
                }
            }
            if (android.util.Log.isLoggable(TAG, 2)) {
                sb = new java.lang.StringBuilder();
                sb.append("Finished http url fetcher fetch in ");
                sb.append(com.bumptech.glide.util.LogTime.getElapsedMillis(logTime));
            }
        } catch (java.lang.Throwable th) {
            if (android.util.Log.isLoggable(TAG, 2)) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("Finished http url fetcher fetch in ");
                sb2.append(com.bumptech.glide.util.LogTime.getElapsedMillis(logTime));
            }
            throw th;
        }
    }
}
