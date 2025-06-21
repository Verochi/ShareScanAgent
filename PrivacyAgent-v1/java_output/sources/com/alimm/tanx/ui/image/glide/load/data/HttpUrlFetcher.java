package com.alimm.tanx.ui.image.glide.load.data;

/* loaded from: classes.dex */
public class HttpUrlFetcher implements com.alimm.tanx.ui.image.glide.load.data.DataFetcher<java.io.InputStream> {
    private static final com.alimm.tanx.ui.image.glide.load.data.HttpUrlFetcher.HttpUrlConnectionFactory DEFAULT_CONNECTION_FACTORY = new com.alimm.tanx.ui.image.glide.load.data.HttpUrlFetcher.DefaultHttpUrlConnectionFactory(null);
    private static final int MAXIMUM_REDIRECTS = 5;
    private static final java.lang.String TAG = "HttpUrlFetcher";
    private final com.alimm.tanx.ui.image.glide.load.data.HttpUrlFetcher.HttpUrlConnectionFactory connectionFactory;
    private final com.alimm.tanx.ui.image.glide.load.model.GlideUrl glideUrl;
    private volatile boolean isCancelled;
    private java.io.InputStream stream;
    private java.net.HttpURLConnection urlConnection;

    public static class DefaultHttpUrlConnectionFactory implements com.alimm.tanx.ui.image.glide.load.data.HttpUrlFetcher.HttpUrlConnectionFactory {
        private DefaultHttpUrlConnectionFactory() {
        }

        public /* synthetic */ DefaultHttpUrlConnectionFactory(com.alimm.tanx.ui.image.glide.load.data.HttpUrlFetcher.AnonymousClass1 anonymousClass1) {
        }

        @Override // com.alimm.tanx.ui.image.glide.load.data.HttpUrlFetcher.HttpUrlConnectionFactory
        public java.net.HttpURLConnection build(java.net.URL url) throws java.io.IOException {
            return (java.net.HttpURLConnection) url.openConnection();
        }
    }

    public interface HttpUrlConnectionFactory {
        java.net.HttpURLConnection build(java.net.URL url) throws java.io.IOException;
    }

    public HttpUrlFetcher(com.alimm.tanx.ui.image.glide.load.model.GlideUrl glideUrl) {
        com.alimm.tanx.ui.image.glide.load.data.HttpUrlFetcher.HttpUrlConnectionFactory httpUrlConnectionFactory = DEFAULT_CONNECTION_FACTORY;
        this.glideUrl = glideUrl;
        this.connectionFactory = httpUrlConnectionFactory;
    }

    public HttpUrlFetcher(com.alimm.tanx.ui.image.glide.load.model.GlideUrl glideUrl, com.alimm.tanx.ui.image.glide.load.data.HttpUrlFetcher.HttpUrlConnectionFactory httpUrlConnectionFactory) {
        this.glideUrl = glideUrl;
        this.connectionFactory = httpUrlConnectionFactory;
    }

    private java.io.InputStream getStreamForSuccessfulRequest(java.net.HttpURLConnection httpURLConnection) throws java.io.IOException {
        if (android.text.TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.stream = com.alimm.tanx.ui.image.glide.util.ContentLengthInputStream.obtain(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
        } else {
            if (android.util.Log.isLoggable(TAG, 3)) {
                tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do("Got non empty content encoding: ").append(httpURLConnection.getContentEncoding());
            }
            this.stream = httpURLConnection.getInputStream();
        }
        return this.stream;
    }

    private java.io.InputStream loadDataWithRedirects(java.net.URL url, int i, java.net.URL url2, java.util.Map<java.lang.String, java.lang.String> map) throws java.io.IOException {
        if (i >= 5) {
            throw new java.io.IOException("Too many (> 5) redirects!");
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new java.io.IOException("In re-direct loop");
                }
            } catch (java.net.URISyntaxException unused) {
            }
        }
        this.urlConnection = this.connectionFactory.build(url);
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            this.urlConnection.addRequestProperty(entry.getKey(), entry.getValue());
        }
        this.urlConnection.setConnectTimeout(2500);
        this.urlConnection.setReadTimeout(2500);
        this.urlConnection.setUseCaches(false);
        this.urlConnection.setDoInput(true);
        this.urlConnection.connect();
        if (this.isCancelled) {
            return null;
        }
        int responseCode = this.urlConnection.getResponseCode();
        int i2 = responseCode / 100;
        if (i2 == 2) {
            return getStreamForSuccessfulRequest(this.urlConnection);
        }
        if (i2 == 3) {
            java.lang.String headerField = this.urlConnection.getHeaderField("Location");
            if (android.text.TextUtils.isEmpty(headerField)) {
                throw new java.io.IOException("Received empty or null redirect url");
            }
            return loadDataWithRedirects(new java.net.URL(url, headerField), i + 1, url, map);
        }
        if (responseCode == -1) {
            throw new java.io.IOException("Unable to retrieve response code from HttpUrlConnection.");
        }
        throw new java.io.IOException("Request failed " + responseCode + ": " + this.urlConnection.getResponseMessage());
    }

    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
    public void cancel() {
        this.isCancelled = true;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
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
    }

    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
    public java.lang.String getId() {
        return this.glideUrl.getCacheKey();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
    public java.io.InputStream loadData(com.alimm.tanx.ui.image.glide.Priority priority) throws java.lang.Exception {
        return loadDataWithRedirects(this.glideUrl.toURL(), 0, null, this.glideUrl.getHeaders());
    }
}
