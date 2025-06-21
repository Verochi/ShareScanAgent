package com.alimm.tanx.core.view.player.cache.videocache;

/* loaded from: classes.dex */
public class HttpUrlSource implements com.alimm.tanx.core.view.player.cache.videocache.Source {
    private static final com.alimm.tanx.core.view.player.cache.videocache.log.Logger LOG = com.alimm.tanx.core.view.player.cache.videocache.log.LoggerFactory.getLogger("HttpUrlSource");
    private static final int MAX_REDIRECTS = 5;
    private java.net.HttpURLConnection connection;
    private final com.alimm.tanx.core.view.player.cache.videocache.headers.HeaderInjector headerInjector;
    private java.io.InputStream inputStream;
    private com.alimm.tanx.core.view.player.cache.videocache.SourceInfo sourceInfo;
    private final com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.SourceInfoStorage sourceInfoStorage;

    public HttpUrlSource(com.alimm.tanx.core.view.player.cache.videocache.HttpUrlSource httpUrlSource) {
        this.sourceInfo = httpUrlSource.sourceInfo;
        this.sourceInfoStorage = httpUrlSource.sourceInfoStorage;
        this.headerInjector = httpUrlSource.headerInjector;
    }

    public HttpUrlSource(java.lang.String str) {
        this(str, com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.SourceInfoStorageFactory.newEmptySourceInfoStorage());
    }

    public HttpUrlSource(java.lang.String str, com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.SourceInfoStorage sourceInfoStorage) {
        this(str, sourceInfoStorage, new com.alimm.tanx.core.view.player.cache.videocache.headers.EmptyHeadersInjector());
    }

    public HttpUrlSource(java.lang.String str, com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.SourceInfoStorage sourceInfoStorage, com.alimm.tanx.core.view.player.cache.videocache.headers.HeaderInjector headerInjector) {
        this.sourceInfoStorage = (com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.SourceInfoStorage) com.alimm.tanx.core.view.player.cache.videocache.Preconditions.checkNotNull(sourceInfoStorage);
        this.headerInjector = (com.alimm.tanx.core.view.player.cache.videocache.headers.HeaderInjector) com.alimm.tanx.core.view.player.cache.videocache.Preconditions.checkNotNull(headerInjector);
        com.alimm.tanx.core.view.player.cache.videocache.SourceInfo sourceInfo = sourceInfoStorage.get(str);
        this.sourceInfo = sourceInfo == null ? new com.alimm.tanx.core.view.player.cache.videocache.SourceInfo(str, -2147483648L, com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheUtils.getSupposablyMime(str)) : sourceInfo;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void fetchContentInfo() throws com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException {
        java.net.HttpURLConnection httpURLConnection;
        com.alimm.tanx.core.view.player.cache.videocache.log.Logger logger = LOG;
        logger.debug("Read content info from " + this.sourceInfo.url);
        java.io.InputStream inputStream = null;
        try {
            httpURLConnection = openConnection(0L, 10000);
            try {
                try {
                    long contentLength = getContentLength(httpURLConnection);
                    java.lang.String contentType = httpURLConnection.getContentType();
                    inputStream = httpURLConnection.getInputStream();
                    com.alimm.tanx.core.view.player.cache.videocache.SourceInfo sourceInfo = new com.alimm.tanx.core.view.player.cache.videocache.SourceInfo(this.sourceInfo.url, contentLength, contentType);
                    this.sourceInfo = sourceInfo;
                    this.sourceInfoStorage.put(sourceInfo.url, sourceInfo);
                    logger.debug("Source info fetched: " + this.sourceInfo);
                    com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheUtils.close(inputStream);
                } catch (java.io.IOException e) {
                    e = e;
                    LOG.error("Error fetching info from " + this.sourceInfo.url, e);
                    com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheUtils.close(inputStream);
                    if (httpURLConnection == null) {
                        return;
                    }
                    httpURLConnection.disconnect();
                }
            } catch (java.lang.Throwable th) {
                th = th;
                com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheUtils.close(inputStream);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (java.io.IOException e2) {
            e = e2;
            httpURLConnection = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            httpURLConnection = null;
            com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheUtils.close(inputStream);
            if (httpURLConnection != null) {
            }
            throw th;
        }
        httpURLConnection.disconnect();
    }

    private long getContentLength(java.net.HttpURLConnection httpURLConnection) {
        java.lang.String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (headerField == null) {
            return -1L;
        }
        return java.lang.Long.parseLong(headerField);
    }

    private void injectCustomHeaders(java.net.HttpURLConnection httpURLConnection, java.lang.String str) {
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : this.headerInjector.addHeaders(str).entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    private java.net.HttpURLConnection openConnection(long j, int i) throws java.io.IOException, com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException {
        boolean z;
        java.lang.String str;
        java.net.HttpURLConnection httpURLConnection;
        java.lang.String str2 = this.sourceInfo.url;
        int i2 = 0;
        do {
            com.alimm.tanx.core.view.player.cache.videocache.log.Logger logger = LOG;
            z = true;
            java.lang.String[] strArr = new java.lang.String[1];
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Open connection ");
            if (j > 0) {
                str = " with offset " + j;
            } else {
                str = "";
            }
            sb.append(str);
            sb.append(" to ");
            sb.append(str2);
            strArr[0] = sb.toString();
            logger.debug(strArr);
            httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str2).openConnection();
            injectCustomHeaders(httpURLConnection, str2);
            if (j > 0) {
                httpURLConnection.setRequestProperty("Range", "bytes=" + j + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            }
            if (i > 0) {
                httpURLConnection.setConnectTimeout(i);
                httpURLConnection.setReadTimeout(i);
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 301 && responseCode != 302 && responseCode != 303) {
                z = false;
            }
            if (z) {
                str2 = httpURLConnection.getHeaderField("Location");
                i2++;
                httpURLConnection.disconnect();
            }
            if (i2 > 5) {
                throw new com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException("Too many redirects: " + i2);
            }
        } while (z);
        return httpURLConnection;
    }

    private long readSourceAvailableBytes(java.net.HttpURLConnection httpURLConnection, long j, int i) throws java.io.IOException {
        long contentLength = getContentLength(httpURLConnection);
        return i == 200 ? contentLength : i == 206 ? contentLength + j : this.sourceInfo.length;
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Source
    public void close() throws com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException {
        java.net.HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                LOG.error("Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit https://github.com/danikula/AndroidVideoCache/issues/88. Until good solution is not know, just ignore this issue :(", e);
            } catch (java.lang.IllegalArgumentException e2) {
                e = e2;
                throw new java.lang.RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            } catch (java.lang.NullPointerException e3) {
                e = e3;
                throw new java.lang.RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            }
        }
    }

    public synchronized java.lang.String getMime() throws com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException {
        if (android.text.TextUtils.isEmpty(this.sourceInfo.mime)) {
            fetchContentInfo();
        }
        return this.sourceInfo.mime;
    }

    public java.lang.String getUrl() {
        return this.sourceInfo.url;
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Source
    public synchronized long length() throws com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException {
        if (this.sourceInfo.length == -2147483648L) {
            fetchContentInfo();
        }
        return this.sourceInfo.length;
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Source
    public void open(long j) throws com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException {
        try {
            java.net.HttpURLConnection openConnection = openConnection(j, -1);
            this.connection = openConnection;
            java.lang.String contentType = openConnection.getContentType();
            this.inputStream = new java.io.BufferedInputStream(this.connection.getInputStream(), 8192);
            java.net.HttpURLConnection httpURLConnection = this.connection;
            com.alimm.tanx.core.view.player.cache.videocache.SourceInfo sourceInfo = new com.alimm.tanx.core.view.player.cache.videocache.SourceInfo(this.sourceInfo.url, readSourceAvailableBytes(httpURLConnection, j, httpURLConnection.getResponseCode()), contentType);
            this.sourceInfo = sourceInfo;
            this.sourceInfoStorage.put(sourceInfo.url, sourceInfo);
        } catch (java.io.IOException e) {
            throw new com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException("Error opening connection for " + this.sourceInfo.url + " with offset " + j, e);
        }
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Source
    public int read(byte[] bArr) throws com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException {
        java.io.InputStream inputStream = this.inputStream;
        if (inputStream == null) {
            throw new com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException("Error reading data from " + this.sourceInfo.url + ": connection is absent!");
        }
        try {
            return inputStream.read(bArr, 0, bArr.length);
        } catch (java.io.InterruptedIOException e) {
            throw new com.alimm.tanx.core.view.player.cache.videocache.InterruptedProxyCacheException("Reading source " + this.sourceInfo.url + " is interrupted", e);
        } catch (java.io.IOException e2) {
            throw new com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException("Error reading data from " + this.sourceInfo.url, e2);
        }
    }

    public java.lang.String toString() {
        return "HttpUrlSource{sourceInfo='" + this.sourceInfo + com.alipay.sdk.m.u.i.d;
    }
}
